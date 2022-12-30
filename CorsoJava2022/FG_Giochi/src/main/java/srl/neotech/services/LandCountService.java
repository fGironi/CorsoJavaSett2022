package srl.neotech.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import srl.neotech.dao.repository.LandsDAO;
import srl.neotech.landCount.model.LandDTO;

@Service
public class LandCountService {

	@Autowired
	LandsDAO landsDAO;
	
	public ArrayList<LandDTO> landPicker() {
		
		return null;
	}
}
