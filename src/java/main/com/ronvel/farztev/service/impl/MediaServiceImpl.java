package com.ronvel.farztev.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ronvel.farztev.controller.dto.ListMedia;
import com.ronvel.farztev.controller.dto.Media;
import com.ronvel.farztev.dao.AlbumDao;
import com.ronvel.farztev.dao.MediaDao;
import com.ronvel.farztev.dao.model.MediaModel;
import com.ronvel.farztev.service.MediaService;

@Service
public class MediaServiceImpl implements MediaService {

  @Autowired
  private ModelMapper mapper;

  @Autowired
  private AlbumDao albumDao;

  @Autowired
  private MediaDao mediaDao;

  @Override
  public Optional<Media> findMediaById(Long id) {
    Optional<Media> optional;
    MediaModel mediaModel = mediaDao.findOne(id);
    if (mediaModel == null) {
      optional = Optional.empty();
    } else {
      Media media = mapMedia(mediaModel);
      optional = Optional.of(media);
    }
    return optional;
  }

  @Override
  public List<ListMedia> listMedias() {
    List<ListMedia> listMedias = new ArrayList<>();
    Iterable<MediaModel> medias = mediaDao.findAll();
    medias.forEach(media -> listMedias.add(mapListMedia(media)));
    return listMedias;
  }

  @Override
  public List<ListMedia> listAlbumMedias(Long albumId) {
    List<MediaModel> medias = mediaDao.findByAlbumId(albumId);
    return medias.stream().map(media -> mapListMedia(media)).collect(Collectors.toList());
  }

  private Media mapMedia(MediaModel resultMediaModel) {
    Media resultMedia = mapper.map(resultMediaModel, Media.class);
    resultMedia.setAlbumId(resultMediaModel.getAlbum().getId());
    resultMedia.setAlbumName(resultMediaModel.getAlbum().getName());
    return resultMedia;
  }

  private ListMedia mapListMedia(MediaModel resultMediaModel) {
    ListMedia listMedia = mapper.map(resultMediaModel, ListMedia.class);
    return listMedia;
  }
}
