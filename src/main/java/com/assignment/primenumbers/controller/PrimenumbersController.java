package com.assignment.primenumbers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.primenumbers.dto.PrimesResponse;
import com.assignment.primenumbers.service.PrimenumbersService;

@RestController
public class PrimenumbersController {

	@Autowired
	private PrimenumbersService primenumbersService;

	@GetMapping(value = "/primes/{initial}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<PrimesResponse> getPrimeNumbers(@PathVariable("initial") Integer initial) {
		return new ResponseEntity<>(primenumbersService.getPrimeNumbers(initial), HttpStatus.OK);
	}
}
