package com.ronvel.farztev.dao;

import com.ronvel.farztev.dao.model.CountryModel;
import org.springframework.data.repository.CrudRepository;

public interface CountryDao extends CrudRepository<CountryModel, Long> {
	
}
