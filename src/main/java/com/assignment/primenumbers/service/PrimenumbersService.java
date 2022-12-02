package com.assignment.primenumbers.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.assignment.primenumbers.dto.PrimesResponse;

@Service
public class PrimenumbersService {

	@Cacheable(value = "primes", key = "#initial")
	public PrimesResponse getPrimeNumbers(Integer initial) {
		PrimesResponse primesResponse = new PrimesResponse();
		primesResponse.setInitial(initial);
		for (int i = 0; i <= initial; i++) {
			if (isPrime(i)) {
				primesResponse.getPrimes().add(i);
			}
		}
		return primesResponse;
	}

	private boolean isPrime(Integer number) {
		if (number < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

}