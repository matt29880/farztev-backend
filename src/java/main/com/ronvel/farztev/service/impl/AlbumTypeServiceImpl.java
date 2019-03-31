package com.ronvel.farztev.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ronvel.farztev.controller.dto.AlbumType;
import com.ronvel.farztev.controller.dto.ListAlbumType;
import com.ronvel.farztev.dao.AlbumTypeDao;
import com.ronvel.farztev.dao.model.AlbumTypeModel;
import com.ronvel.farztev.service.AlbumTypeService;

@Service
public class AlbumTypeServiceImpl implements AlbumTypeService {

  @Autowired
  private ModelMapper mapper;

  @Autowired
  private AlbumTypeDao albumTypeDao;

  @Override
  public Optional<AlbumType> findAlbumTypeById(Long id) {
    Optional<AlbumType> optional;
    AlbumTypeModel albumTypeModel = albumTypeDao.findOne(id);
    if (albumTypeModel == null) {
      optional = Optional.empty();
    } else {
      AlbumType albumType = mapper.map(albumTypeModel, AlbumType.class);
      optional = Optional.of(albumType);
    }
    return optional;
  }

  @Override
  public List<ListAlbumType> listAlbumTypes() {
    List<ListAlbumType> listAlbumTypes = new ArrayList<>();
    Iterable<AlbumTypeModel> albumTypes = albumTypeDao.findAll();
    albumTypes.forEach(albumTypeModel -> listAlbumTypes.add(mapToListAlbumType(albumTypeModel)));
    return listAlbumTypes;
  }
  @Override
  public ListAlbumType mapToListAlbumType(AlbumTypeModel albumTypeModel) {
    ListAlbumType listAlbumType = mapper.map(albumTypeModel, ListAlbumType.class);
    listAlbumType.setCountryId(albumTypeModel.getCountry().getId());
    listAlbumType.setCountryName(albumTypeModel.getCountry().getName());
    return listAlbumType;
  }

}
