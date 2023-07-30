package com.abc.medicalrepresentativeschedule.service;

import java.time.LocalDate;
import java.util.List;

import com.abc.medicalrepresentativeschedule.exception.TokenValidationFailedException;
import com.abc.medicalrepresentativeschedule.model.RepSchedule;

public interface MedRepScheduleService {
	public List<RepSchedule> getRepSchedule(String token, LocalDate scheduleStartDate)
			throws TokenValidationFailedException;

}
