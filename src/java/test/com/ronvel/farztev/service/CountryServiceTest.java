package com.ronvel.farztev.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ronvel.farztev.controller.dto.Country;
import com.ronvel.farztev.controller.dto.ListCountry;

public class CountryServiceTest extends BaseServiceTest {

	@Autowired
	private CountryService countryService;
	
	@Test
	public void findCountry() {
		Optional<Country> optionalCountry = countryService.findCountryById(1L);
        assertTrue(optionalCountry.isPresent());
	}

    @Test
    public void findCountry_notFound() {
        Optional<Country> optionalCountry = countryService.findCountryById(0L);
        assertFalse(optionalCountry.isPresent());
    }
    
	@Test
	public void listCountries() {
		List<ListCountry> countries = countryService.listCountries();
        assertEquals(1L, countries.size());
	}
}