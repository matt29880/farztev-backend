package com.ronvel.farztev.service;

import java.util.List;
import java.util.Optional;
import com.ronvel.farztev.controller.dto.Country;
import com.ronvel.farztev.controller.dto.ListCountry;

/**
 * Service for selecting countries.
 * 
 * @author mronvel
 *
 */
public interface CountryService {
	/**
	 * Find a country by id.
	 * 
	 * @param id
	 * @return
	 */
	Optional<Country> findCountryById(Long id);

	/**
	 * List all the countries.
	 * 
	 * @return
	 */
	List<ListCountry> listCountries();
}
