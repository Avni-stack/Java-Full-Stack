package com.tcs.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.tcs.service.CalculationService;

class CalculationservicetestTest {
     CalculationService calculationService =new CalculationService();
	@Test
	public void addTest() {
		assertEquals(5,calculationService.add(3, 2));
	}
	public void beforeEach() {
		
	}

}
