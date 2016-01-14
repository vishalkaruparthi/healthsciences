package com.healthsciences.services.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthsciences.services.domain.model.State;
import com.healthsciences.services.domain.repositories.IStateRepository;
import com.healthsciences.services.facade.dto.assembler.StateAssembler;
import com.healthsciences.services.facade.dto.entities.StateListDTO;
import com.healthsciences.services.facade.interfaces.IStateService;

@Service
@Transactional
public class StateDBService implements IStateService{

	@Autowired
	IStateRepository iStateRepo;
	
	public StateListDTO getListDTO() {
		List<State> stateList = iStateRepo.getAll(0, 0, null);
		StateListDTO stateListDTO = new StateListDTO();
		StateAssembler.Statelist2StateListDTO(stateList, stateListDTO);
		return stateListDTO;
	}
}
