package com.cognizant.pharmacysupply.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import com.cognizant.pharmacysupply.exception.*;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.pharmacysupply.feignclient.AuthenticationFeignClient;
import com.cognizant.pharmacysupply.feignclient.MedicineStockFeignClient;
import com.cognizant.pharmacysupply.model.JwtResponse;
import com.cognizant.pharmacysupply.model.MedicineDemand;
import com.cognizant.pharmacysupply.model.MedicineStock;
import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;
import com.cognizant.pharmacysupply.exception.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PharmacyServiceTest {
	@Autowired
	private PharmacyServiceImpl medicineSupplyServiceImpl;

	@Mock
	private MedicineDemand medicineDemand;

	@Mock
	private MedicineStockFeignClient medicineStockFeignClient;
	
	@Mock
	private PharmacyMedicineSupply medicineSupply;

	@Mock
	private MedicineStock medicineStock;

	@Mock
	private AuthenticationFeignClient authFeignClient;

	List<MedicineDemand> medicineDemandList = new ArrayList<>();

	@Before
	public void setup() {
		medicineDemand = new MedicineDemand(1, "Crocin", 100);
		medicineDemandList.add(medicineDemand);
		medicineSupply = new PharmacyMedicineSupply(1, "Healthy Pharmacy", "Crocin", 200);
		medicineStock = new MedicineStock(1, "Crocin", "digoxin", "General", "Healthy Pharmacy",
				new java.util.Date(2022 - 9 - 12), 500);
	}

	/**
	 * Tests the method getMedicineStockInformation and checks if it is not null
	 */
	@Test
	public void testGetMedicineSupply() {
		log.info("Start");
		List<PharmacyMedicineSupply> medicineSupply = medicineSupplyServiceImpl.getMedicineSupply();
		assertNotNull(medicineSupply);
		log.info("End");
	}

	@Test(expected = MedicineNotFoundException.class)
	public void testGetPharmacySupply() throws MedicineNotFoundException {
		log.info("Start");
		
		List<PharmacyMedicineSupply> medicineSupply  = null;
		when(medicineSupplyServiceImpl.getNumberOfTablets("token", medicineDemand)).thenReturn(medicineStock);
		medicineSupply = medicineSupplyServiceImpl.getPharmacySupplyCount("token", medicineDemandList);
		assertNotNull(medicineSupply);
		log.info("End");
	}
	
	@Test(expected = MedicineNotFoundException.class)
	public void testGetNumberOfTablets() throws MedicineNotFoundException {
		log.info("Start");
		MedicineStock medicineStock = null;
		when(medicineStockFeignClient.getNumberOfTabletsInStockByName("token", medicineDemand.getMedicineName())).thenReturn(medicineStock);
		medicineStock = medicineSupplyServiceImpl.getNumberOfTablets("token", medicineDemand);
		assertNotNull(medicineStock);
		log.info("End");
	}
	
	@Test
	public void testGetMedicineDemand() {
		log.info("Start");
		List<MedicineDemand> medicineDemandList = null;
		medicineDemandList = medicineSupplyServiceImpl.getMedicineDemand();
		assertNotNull(medicineDemandList);
		log.info("End");
	}
	
	
}