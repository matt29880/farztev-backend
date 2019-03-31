package com.ronvel.farztev.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ronvel.farztev.controller.dto.Country;
import com.ronvel.farztev.controller.dto.ListCountry;
import com.ronvel.farztev.dao.CountryDao;
import com.ronvel.farztev.dao.model.CountryModel;
import com.ronvel.farztev.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

  @Autowired
  private ModelMapper mapper;

  @Autowired
  private CountryDao countryDao;

  @Override
  public Optional<Country> findCountryById(Long id) {
    Optional<Country> optional;
    CountryModel countryModel = countryDao.findOne(id);
    if (countryModel == null) {
      optional = Optional.empty();
    } else {
      Country country = mapper.map(countryModel, Country.class);
      optional = Optional.of(country);
    }
    return optional;
  }

  @Override
  public List<ListCountry> listCountries() {
    List<ListCountry> listCountries = new ArrayList<>();
    Iterable<CountryModel> countries = countryDao.findAll();
    countries.forEach(country -> listCountries.add(mapper.map(country, ListCountry.class)));
    return listCountries;
  }
}
