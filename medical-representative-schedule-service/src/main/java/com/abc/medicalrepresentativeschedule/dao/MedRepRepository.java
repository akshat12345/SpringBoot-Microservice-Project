package com.abc.medicalrepresentativeschedule.dao;

import org.springframework.stereotype.Repository;

import com.abc.medicalrepresentativeschedule.model.MedicalRepresentative;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MedRepRepository extends JpaRepository<MedicalRepresentative, Integer> {

}
