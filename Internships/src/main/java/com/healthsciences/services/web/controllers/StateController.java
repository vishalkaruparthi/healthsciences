package com.healthsciences.services.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.healthsciences.services.facade.dto.entities.StateListDTO;
import com.healthsciences.services.facade.interfaces.IStateService;


@RequestMapping("/states")
@Controller
public class StateController {

	@Autowired
	IStateService iStateService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	@ResponseBody
	public StateListDTO getStates(){
		return iStateService.getListDTO();
	}

}

