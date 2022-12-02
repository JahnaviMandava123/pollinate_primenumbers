package com.assignment.primenumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.assignment.primenumbers.dto.PrimesResponse;

@SpringBootTest(classes = PrimenumbersApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class PrimeNumbersControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testPrimes() throws Exception {
		ResponseEntity<PrimesResponse> response = this.restTemplate
				.getForEntity("http://localhost:" + port + "/primes/10", PrimesResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(4, response.getBody().getPrimes().size());
		assertEquals(2, response.getBody().getPrimes().get(0));
		assertEquals(3, response.getBody().getPrimes().get(1));
		assertEquals(5, response.getBody().getPrimes().get(2));
		assertEquals(7, response.getBody().getPrimes().get(3));
	}

	@Test
	public void testPrimesWithAcceptHeaderJSON() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<PrimesResponse> response = this.restTemplate.exchange("http://localhost:" + port + "/primes/10",
				HttpMethod.GET, entity, PrimesResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("application/json", response.getHeaders().get("Content-Type").get(0));
		assertEquals(4, response.getBody().getPrimes().size());
		assertEquals(2, response.getBody().getPrimes().get(0));
		assertEquals(3, response.getBody().getPrimes().get(1));
		assertEquals(5, response.getBody().getPrimes().get(2));
		assertEquals(7, response.getBody().getPrimes().get(3));
	}

	@Test
	public void testPrimesWithAcceptHeaderXML() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<PrimesResponse> response = this.restTemplate.exchange("http://localhost:" + port + "/primes/10",
				HttpMethod.GET, entity, PrimesResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("application/xml", response.getHeaders().get("Content-Type").get(0));
		assertEquals(4, response.getBody().getPrimes().size());
		assertEquals(2, response.getBody().getPrimes().get(0));
		assertEquals(3, response.getBody().getPrimes().get(1));
		assertEquals(5, response.getBody().getPrimes().get(2));
		assertEquals(7, response.getBody().getPrimes().get(3));
	}

	@Test
	public void testPrimesForNoPrimes() throws Exception {
		ResponseEntity<PrimesResponse> response = this.restTemplate
				.getForEntity("http://localhost:" + port + "/primes/1", PrimesResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(0, response.getBody().getPrimes().size());
	}
}
