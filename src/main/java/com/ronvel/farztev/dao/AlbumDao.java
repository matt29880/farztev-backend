package com.ronvel.farztev.dao;

import org.springframework.data.repository.CrudRepository;
import com.ronvel.farztev.dao.model.AlbumModel;

public interface AlbumDao extends CrudRepository<AlbumModel, Long> {
	
}
