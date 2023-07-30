package com.abc.medicalrepresentativeschedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.medicalrepresentativeschedule.dao.MedRepRepository;
import com.abc.medicalrepresentativeschedule.exception.TokenValidationFailedException;
import com.abc.medicalrepresentativeschedule.feignclient.AuthenticationFeignClient;
import com.abc.medicalrepresentativeschedule.model.JwtResponse;
import com.abc.medicalrepresentativeschedule.model.MedicalRepresentative;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MedRepServiceImpl implements MedRepService {

	@Autowired
	AuthenticationFeignClient authFeignClient;

	@Autowired
	private MedRepRepository medicalRepresentativesRepository;

	@Override
	public List<MedicalRepresentative> getMedicalRepresentatives(String token) throws TokenValidationFailedException {

		log.info("Start");

		log.debug("token : {}", token);

		if (!isValidSession(token)) {
			log.info("End");

			return null;
		}

		log.info("End");
		return medicalRepresentativesRepository.findAll();
	}

	public Boolean isValidSession(String token) throws TokenValidationFailedException {

		log.info("Start");

		JwtResponse response = authFeignClient.verifyToken(token);

		log.debug("response : {}", response);

		if (!response.isValid()) {
			log.info("End");

			throw new TokenValidationFailedException("Invalid Token");
		}

		log.info("End");

		return true;
	}

}
