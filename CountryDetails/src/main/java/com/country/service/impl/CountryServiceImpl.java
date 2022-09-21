package com.country.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.country.bean.Country;
import com.country.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Value("${ind}")
	String ind;
	
	@Value("${usa}")
	String usa;
	
	@Value("${rus}")
	String rsa;
	
	@Value("${base.uri}")
	String uri;
	
	@Value("${india.poulation}")
	String indPoulation;
	
	@Value("${india.male.poulation}")
	String indMalePoulation;
	
	@Value("${india.female.poulation}")
	String indFemalePoulation;
	
	@Value("${usa.poulation}")
	String usaPoulation;
	
	@Value("${usa.male.poulation}")
	String usaMalePoulation;
	
	@Value("${usa.female.poulation}")
	String usaFemalePoulation;
	
	@Value("${rsa.poulation}")
	String rsaPoulation;
	
	@Value("${rsa.male.poulation}")
	String rsaMalePoulation;
	
	@Value("${rsa.female.poulation}")
	String rsaFemalePoulation;
	
	@Autowired
	RestTemplate restTemplate;
	
	
	List<Country> listCountry=new ArrayList<Country>();

	@Override
	public Country getIndiaDetails() {
		Country country= new Country();
		country.setCountryName("India");
		country.setTotalPopulation(indPoulation);
		country.setTotalMalePopulation(indMalePoulation);
		country.setTotalFemalePopulation(indFemalePoulation);
		return country;
	}

	@Override
	public Country getUsaDetails() {
		Country country= new Country();
		country.setCountryName("USA");
		country.setTotalPopulation(usaPoulation);
		country.setTotalMalePopulation(usaMalePoulation);
		country.setTotalFemalePopulation(usaFemalePoulation);
		return country;
	}

	@Override
	public Country getRussiaDetails() {
		Country country= new Country();
		country.setCountryName("Russia");
		country.setTotalPopulation(rsaPoulation);
		country.setTotalMalePopulation(rsaMalePoulation);
		country.setTotalFemalePopulation(rsaFemalePoulation);
		return country;
	}

	@Override
	public List<Country> getCountryDetails() {
		String indUrl=uri+ind;
		String usaUrl=uri+usa;
		String rsaUrl=uri+rsa;
		Country indRes= restTemplate.getForObject(indUrl, Country.class);
		Country usaRes= restTemplate.getForObject(usaUrl, Country.class);
		Country rsaRes= restTemplate.getForObject(rsaUrl, Country.class);
		
		listCountry.add(indRes);
		listCountry.add(usaRes);
		listCountry.add(rsaRes);
		return listCountry;
	}

}
