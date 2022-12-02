package com.assignment.primenumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.assignment.primenumbers.dto.PrimesResponse;
import com.assignment.primenumbers.service.PrimenumbersService;

class PrimeNumbersServiceTest {

	PrimenumbersService primenumbersService = new PrimenumbersService();

	@Test
	void testForInitial10() {
		PrimesResponse primesResponse = primenumbersService.getPrimeNumbers(10);
		assertEquals(10, primesResponse.getInitial());
		assertEquals(4, primesResponse.getPrimes().size());
		assertEquals(2, primesResponse.getPrimes().get(0));
		assertEquals(3, primesResponse.getPrimes().get(1));
		assertEquals(5, primesResponse.getPrimes().get(2));
		assertEquals(7, primesResponse.getPrimes().get(3));
	}

	@Test
	void testForInitial1() {
		PrimesResponse primesResponse = primenumbersService.getPrimeNumbers(1);
		assertEquals(1, primesResponse.getInitial());
		assertEquals(0, primesResponse.getPrimes().size());
	}

}
