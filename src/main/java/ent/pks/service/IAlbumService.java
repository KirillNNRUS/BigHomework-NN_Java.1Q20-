package ent.pks.service;

import ent.pks.entity.Album;

import java.util.List;

public interface IAlbumService {
    void add(Album album);

    List<Album> getAll();

    Album getById(Long id);

    void update(Album album, String newAlbumName);

    void delete(Album album);
}
