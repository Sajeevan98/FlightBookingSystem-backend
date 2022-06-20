package com.Assignment04.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Assignment04.exception.ResourceNotFoundException;
import com.Assignment04.model.Passenger;
import com.Assignment04.repository.PassengerRepository;

@Service
public class PassengerServiceImp implements PassengerService{
	
	@Autowired
	private PassengerRepository pRepository;
	
	@Override
	public List<Passenger> getAllPassenger() {
		
		return pRepository.findAll();
	}

	@Override
	public Passenger addPassenger(Passenger pModel) {
		
		return pRepository.save(pModel);
	}

	@Override
	public Optional<Passenger> updatePassenger(long id, Passenger pModel) {
		
		Passenger objPassenger = pRepository.findById(id).orElseThrow(
					()-> new ResourceNotFoundException("Passenger not exit with Id: "+ id)
				);
		objPassenger.setName(pModel.getName());
		objPassenger.setCountry(pModel.getCountry());
		objPassenger.setPassportNo(pModel.getPassportNo());
		
		return Optional.ofNullable(pRepository.save(objPassenger));
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deletePassenger(long id) {
		
		Passenger objPassenger = pRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Passenger not exit with Id: "+ id)
			);
		
		pRepository.delete(objPassenger);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted: ", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
