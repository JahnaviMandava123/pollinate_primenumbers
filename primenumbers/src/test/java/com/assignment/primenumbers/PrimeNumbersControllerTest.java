package com.assignment.primenumbers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assignment.primenumbers.controller.PrimenumbersController;
import com.assignment.primenumbers.dto.PrimesResponse;
import com.assignment.primenumbers.service.PrimenumbersService;

@ExtendWith(MockitoExtension.class)
class PrimeNumbersControllerTest {
	
	@InjectMocks
	PrimenumbersController primenumbersController;
	@Mock
	PrimenumbersService primenumbersService;

	@Test
	void test() {
		PrimesResponse expectedPrimesResponse = new PrimesResponse();
		expectedPrimesResponse.setInitial(8);
		expectedPrimesResponse.getPrimes().add(2);
		expectedPrimesResponse.getPrimes().add(3);
		expectedPrimesResponse.getPrimes().add(5);
		expectedPrimesResponse.getPrimes().add(7);
		when(primenumbersService.getPrimeNumbers(8)).thenReturn(expectedPrimesResponse);
		PrimesResponse actualPrimesResponse = primenumbersController.getPrimeNumbers(8).getBody();
		verify(primenumbersService, times(1)).getPrimeNumbers(8);
		assertThat(actualPrimesResponse).usingRecursiveComparison().isEqualTo(expectedPrimesResponse);
	}

	@Test
	void testForNoPrimes() {
		PrimesResponse expectedPrimesResponse = new PrimesResponse();
		expectedPrimesResponse.setInitial(-20);
		when(primenumbersService.getPrimeNumbers(-20)).thenReturn(expectedPrimesResponse);
		PrimesResponse actualPrimesResponse = primenumbersController.getPrimeNumbers(-20).getBody();
		verify(primenumbersService, times(1)).getPrimeNumbers(-20);
		assertThat(actualPrimesResponse).usingRecursiveComparison().isEqualTo(expectedPrimesResponse);
	}

}
