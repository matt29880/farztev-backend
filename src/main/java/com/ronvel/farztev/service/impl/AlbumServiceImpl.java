package com.ronvel.farztev.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ronvel.farztev.controller.dto.Album;
import com.ronvel.farztev.controller.dto.ListAlbum;
import com.ronvel.farztev.dao.AlbumDao;
import com.ronvel.farztev.dao.AlbumTypeDao;
import com.ronvel.farztev.dao.model.AlbumModel;
import com.ronvel.farztev.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {

  @Autowired
  private ModelMapper mapper;

  @Autowired
  private AlbumDao albumDao;
  
  @Autowired
  private AlbumTypeDao albumTypeDao;

  @Override
  public Optional<Album> findAlbumById(Long id) {
    Optional<Album> optional;
    AlbumModel albumModel = albumDao.findOne(id);
    if (albumModel == null) {
      optional = Optional.empty();
    } else {
      Album album = mapAlbum(albumModel);
      optional = Optional.of(album);
    }
    return optional;
  }

  @Override
  public List<ListAlbum> listAlbums() {
    List<ListAlbum> listAlbums = new ArrayList<>();
    Iterable<AlbumModel> albums = albumDao.findAll();
    albums.forEach(album -> listAlbums.add(mapListAlbum(album)));
    return listAlbums;
  }
  
  private Album mapAlbum(AlbumModel resultAlbumModel) {
    Album resultAlbum = mapper.map(resultAlbumModel, Album.class);
    resultAlbum.setCountryId(resultAlbumModel.getAlbumType().getCountry().getId());
    resultAlbum.setCountryName(resultAlbumModel.getAlbumType().getCountry().getName());
    return resultAlbum;
  }
  
  private ListAlbum mapListAlbum(AlbumModel resultAlbumModel) {
    ListAlbum listAlbum = mapper.map(resultAlbumModel, ListAlbum.class);
    listAlbum.setCountryId(resultAlbumModel.getAlbumType().getCountry().getId());
    listAlbum.setCountryName(resultAlbumModel.getAlbumType().getCountry().getName());
    return listAlbum;
  }

}
