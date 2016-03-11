package com.healthsciences.services.web.controllers;

import javax.mail.Header;

import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthsciences.services.facade.dto.entities.GetInternshipsListCriteriaDTO;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipsListDTO;
import com.healthsciences.services.facade.exceptions.FacadeConstraintException;
import com.healthsciences.services.facade.exceptions.FacadeEntityNotFoundExpection;
import com.healthsciences.services.facade.exceptions.FacadeUnknownException;
import com.healthsciences.services.facade.interfaces.IInternShipsService;


@RequestMapping("/internships")
@Controller
public class InternshipController {
	
	@Autowired
	IInternShipsService internshipService;
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<InternshipsListDTO> getInternships(@RequestBody GetInternshipsListCriteriaDTO getCriteria){
			InternshipsListDTO list = internshipService.getInternshipList(getCriteria);
			return new ResponseEntity<InternshipsListDTO>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="/details/{internshipID}", method=RequestMethod.POST)
	@ResponseBody
	public Object getInternshipDetails(@PathVariable Integer internshipID){
		ResponseEntity<InternshipDetailsDTO> resp;
		HttpHeaders h;
		try {
			InternshipDetailsDTO details = internshipService.getInternshipDetails(internshipID);
			h = new HttpHeaders();
			h.add("status", "200");
			resp = new ResponseEntity<InternshipDetailsDTO>(details, h, HttpStatus.OK);
			return resp; 
			
		} catch (FacadeEntityNotFoundExpection e) {
			h = new HttpHeaders();
			h.add("status", "404");
			h.add("message", e.getMessage());
			resp = new ResponseEntity<InternshipDetailsDTO>(null, h, HttpStatus.OK);
			return resp;
		} catch(FacadeUnknownException e){
			h = new HttpHeaders();
			h.add("status", "400");
			h.add("message", e.getMessage());
			resp = new ResponseEntity<InternshipDetailsDTO>(null, h, HttpStatus.OK);
			return resp;
		}
	}
	
	
	@RequestMapping(value="/formSubmit", method=RequestMethod.POST)
	@ResponseBody
	public Object setIntership(@RequestBody InternshipDetailsDTO setDetails){
		ResponseEntity<String> resp;
		HttpHeaders h;
		try {
			h = new HttpHeaders();
			h.add("status", "200");
			String returnValue = internshipService.setInternships(setDetails);
			resp = new ResponseEntity<String>(returnValue, h, HttpStatus.OK);
			com.healthsciences.services.util.Mail.sendMail(setDetails, returnValue);
			return resp;
		} catch (FacadeConstraintException e) {
			h = new HttpHeaders();
			h.add("status", "400");
			h.add("message", e.getMessage());
			resp = new ResponseEntity<String>(null, h, HttpStatus.OK);
			return resp;
		}catch (Exception e) {
			h = new HttpHeaders();
			h.add("status", "400");
			h.add("message", "Unable to send mail for approval of internship");
			resp = new ResponseEntity<String>(null, h, HttpStatus.OK);
			return resp;
		}
	}
	
	@RequestMapping(value="/approve/{internshipID}", method = RequestMethod.GET)
	@ResponseBody
	public boolean approveInternship(@PathVariable Integer internshipID){
		return internshipService.approveInternship(internshipID);
	}
	
	
}
