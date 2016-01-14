package com.healthsciences.services.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.healthsciences.services.facade.dto.entities.GetInternshipsListCriteriaDTO;
import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
import com.healthsciences.services.facade.dto.entities.InternshipsListDTO;
import com.healthsciences.services.facade.interfaces.IInternShipsService;


@RequestMapping("/internships")
@Controller
public class InternshipController {
	
	@Autowired
	IInternShipsService internshipService;
	
	@RequestMapping(value="/details/{internshipID}", method=RequestMethod.GET)
	@ResponseBody
	public InternshipDetailsDTO getInternshipDetails(@PathVariable Integer internshipID){
		return internshipService.getInternshipDetails(internshipID);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	@ResponseBody
	public InternshipsListDTO getInternships(@RequestBody GetInternshipsListCriteriaDTO getCriteria){
		return internshipService.getInternshipList(getCriteria);
	}
	
	@RequestMapping(value="/formSubmit", method=RequestMethod.POST)
	@ResponseBody
	
	public String setIntership(@RequestBody InternshipDetailsDTO setDetails){
		
		return internshipService.setInternships(setDetails);
	}
	
	
}
