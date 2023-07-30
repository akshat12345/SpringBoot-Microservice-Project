package com.abc.pharmacysupply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.pharmacysupply.model.PharmacyMedicineSupply;

@Repository
public interface PharmacyMedicineSupplyRepository extends JpaRepository<PharmacyMedicineSupply, Integer>{

}
