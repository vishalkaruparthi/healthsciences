package com.healthsciences.services.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

import com.healthsciences.services.facade.dto.entities.InternshipDetailsDTO;
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
	
}
