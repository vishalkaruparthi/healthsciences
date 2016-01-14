package com.healthsciences.services.facade.dto.assembler;

import java.util.ArrayList;
import java.util.List;

import com.healthsciences.services.domain.model.State;
import com.healthsciences.services.facade.dto.entities.StateDTO;
import com.healthsciences.services.facade.dto.entities.StateListDTO;

public class StateAssembler {
	private StateAssembler(){
		
	}
	public static void Statelist2StateListDTO(List<State> statelist, StateListDTO stateListDto){
		
		List<StateDTO> stateListDTO = new ArrayList<StateDTO>();
		for (State state : statelist) {
			StateDTO stateDTO = new StateDTO();
			StateAssembler.state2stateDTO(state, stateDTO);
			
			stateListDTO.add(stateDTO);
		}		
		stateListDto.setStatesList(stateListDTO);	
	}
	
	public static void state2stateDTO(State state, StateDTO stateDTO){
		stateDTO.setStateid(state.getStateID());
		stateDTO.setState_name(state.getName());
	}
	

}
