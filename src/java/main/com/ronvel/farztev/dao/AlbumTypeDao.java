package com.ronvel.farztev.dao;

import org.springframework.data.repository.CrudRepository;
import com.ronvel.farztev.dao.model.AlbumTypeModel;

public interface AlbumTypeDao extends CrudRepository<AlbumTypeModel, Long> {
	
}
