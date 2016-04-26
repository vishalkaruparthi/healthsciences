package com.healthsciences.services.util;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.AuthenticationException;

import com.healthsciences.services.domain.model.AcademicPeriod;
import com.healthsciences.services.facade.dto.entities.AcademicPeriodDTO;
import com.healthsciences.services.facade.dto.entities.HoursWorkDTO;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipTypeDTO;
import com.healthsciences.services.facade.exceptions.FacadeBadCredentialsException;

public class Mail {
	public static void sendMail(InternshipDetailsDTO details, String status) throws FacadeBadCredentialsException{
		final String userName = "vishal.kpty@gmail.com";
		final String password = "Ilva0f$e";
		final String toMail = "rpk003@shsu.edu";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        try {
        	Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            	protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
            		return new javax.mail.PasswordAuthentication(userName, password);
            	}
            });
        	try {
    			String URL = "http://localhost:8080/jai/#/approve/"+status;
    			
    			Message message = new MimeMessage(session);
    			message.setFrom(new InternetAddress(userName));
    			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
    			message.setSubject("Approval request");
                message.setText("Dear admin, Please find below the details of the internship submitted."
                    + "\n\n Organization Name: " + details.getOrganizationName() +"\n\n"
                    + "URL: "+ details.getUrl() +"\n\n"
                    + "Contact Person: "+ details.getContactPerson() + "\n\n"
                    + "Email: "+ details.getEmail() +"\n\n"
                    + "Phone: "+ details.getPhoneNumber() +"\n\n"
                    + "ID "+status);
                
                String academicPeriodList = "";
                for (AcademicPeriodDTO i : details.getAcademicPeriodList()) {
                	academicPeriodList = academicPeriodList +", "+ i.getTitle();
				}
                
                String hoursWorkList = "";
                for (HoursWorkDTO i : details.getHoursWorkList()) {
                	hoursWorkList = hoursWorkList+ ","+ i.getTitle()+"("+i.getHours_week()+"/week "+i.getTotalHours()+" hours)";
				}
                
                String internshipList = "";
                for (InternshipTypeDTO i : details.getInternshipTypeList()) {
                	internshipList = internshipList + i.getTitle();
				}
                
                message.setContent("<li>Organization Name: "+details.getOrganizationName()+"</li> <br>"+
                		"<li>URL: "+details.getUrl()+"</li> <br>"+
                		"<li>Contact Person: "+details.getContactPerson()+" </li> <br>"+
                		"<li>Email: "+details.getEmail()+"</li>    <br>"+
                		"<li>Phone: "+details.getPhoneNumber() +"</li> <br>"+
                		"<li>City: "+details.getCity() +"</li> <br>"+
                		"<li>Pay: "+details.getPayamount() +"</li> <br>"+
                		"<li>Phone: "+details.getPayType()+"</li> <br>"+
                		"<li>Phone: "+details.getPhoneNumber() +"</li> <br>"+
                		"<li>Internship desc: "+details.getInternDesc()+"</li> <br>"+
                		"<li>Special Skills: "+details.getSpecialSkills()+"<li><br>"+
                		"<li>Zip Code: "+details.getZipcode()+"</li><br>"+
                		"<li>Academic Period List: "+academicPeriodList+"</li><br>"+
                		"<li>Hours Work List: "+ hoursWorkList+"</li><br>"+
                		"<li>Internship Type List: "+internshipList+"</li><br>"+
                		"<li>Posted Date: "+details.getPostedDate()+"</li><br>"+
                		"<li>State: "+details.getStateId().getState_name()+"</li><br>"+
                		
                		"<a href="+URL+">Approve</a>", "text/html");
                Transport.send(message);
                
    		}catch (MessagingException e){
    			throw new RuntimeException(e);
    		}
		} catch (Exception e) {
			throw new FacadeBadCredentialsException(e.getMessage());
		}
	}
	
	
}
