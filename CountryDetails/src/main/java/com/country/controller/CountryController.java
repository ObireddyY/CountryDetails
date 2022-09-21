package com.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.country.bean.Country;
import com.country.service.CountryService;

@RestController
public class CountryController {
	
	
	@Autowired
	public CountryService countryService;
	
	
	@RequestMapping(value= "/india",method=RequestMethod.GET)
	public Country getIndiaDetails() {
		Country country = countryService.getIndiaDetails();
		return country;
	}
	
	@RequestMapping(value= "/usa",method=RequestMethod.GET)
	public Country getUsaDetails() {
		Country country = countryService.getUsaDetails();
		return country;
	}
	
	@RequestMapping(value= "/russia",method=RequestMethod.GET)
	public Country getRussiaDetails() {
		Country country = countryService.getRussiaDetails();
		return country;
	}
	
	@RequestMapping(value= "/countryDetals",method=RequestMethod.GET)
	public ResponseEntity<List<Country>> getCountryDetails() {
		
		List<Country> listCountry = countryService.getCountryDetails();
		
		return new ResponseEntity<List<Country>>(listCountry,HttpStatus.OK);
	}

}
