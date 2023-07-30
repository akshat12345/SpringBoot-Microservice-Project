package com.abc.medicalrepresentativeschedule.service;

import java.util.List;

import com.abc.medicalrepresentativeschedule.exception.TokenValidationFailedException;
import com.abc.medicalrepresentativeschedule.model.MedicalRepresentative;

public interface MedRepService {
	
	public List<MedicalRepresentative> getMedicalRepresentatives(String token) throws TokenValidationFailedException;

}
