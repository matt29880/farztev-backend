package com.ronvel.farztev.dao.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;

@Entity
@Table(name="album")
public class AlbumModel extends BaseModel {
  @NotNull
  @Size(max = 30)
  private String name;
  @NotNull
  @Column(name = "description", nullable = true, length = 65535, columnDefinition="TEXT")
  private String description;
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  private Date updated;
  @NotNull
  @Type(type = "org.hibernate.type.NumericBooleanType")
  @Column(columnDefinition = "TINYINT(1)")
  private Boolean online;
  
  @NotNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "album_type")
  private AlbumTypeModel albumType;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public Boolean getOnline() {
    return online;
  }

  public void setOnline(Boolean online) {
    this.online = online;
  }

  public AlbumTypeModel getAlbumType() {
    return albumType;
  }

  public void setAlbumType(AlbumTypeModel albumType) {
    this.albumType = albumType;
  }



}
