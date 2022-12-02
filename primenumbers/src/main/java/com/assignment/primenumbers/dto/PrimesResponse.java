package com.assignment.primenumbers.dto;

import java.util.ArrayList;
import java.util.List;

public class PrimesResponse {

	private Integer initial;
	private List<Integer> primes = new ArrayList<>();
	public Integer getInitial() {
		return initial;
	}
	public void setInitial(Integer initial) {
		this.initial = initial;
	}
	public List<Integer> getPrimes() {
		return primes;
	}
	public void setPrimes(List<Integer> primes) {
		this.primes = primes;
	}
	
	
}
