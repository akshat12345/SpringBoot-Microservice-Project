package com.abc.pharmacysupply.service;

import java.util.List;

import com.abc.pharmacysupply.exception.MedicineNotFoundException;
import com.abc.pharmacysupply.model.MedicineDemand;
import com.abc.pharmacysupply.model.PharmacyMedicineSupply;

public interface PharmacyService {
	public Boolean validateToken(String token) ;
	public List<PharmacyMedicineSupply> getMedicineSupply();
	public List<MedicineDemand> getMedicineDemand();
	public List<PharmacyMedicineSupply> getPharmacySupplyCount(String token, List<MedicineDemand> medicineDemandList) throws MedicineNotFoundException ;
}
