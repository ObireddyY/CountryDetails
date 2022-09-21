package com.country.service;

import java.util.List;

import com.country.bean.Country;

public interface CountryService {

	Country getIndiaDetails();

	Country getUsaDetails();

	Country getRussiaDetails();

	List<Country> getCountryDetails();

}
