package ent.pks.dao;

import ent.pks.entity.Album;

import java.util.List;

public interface AlbumDAO {
    void add(Album album);

    List<Album> getAll();

    Album getById(Long id);

    long getIdByName(String name);

    void update(Album album, String newAlbumName);

    void remove(Album album);
}
