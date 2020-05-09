package ent.pks.dao;

import ent.pks.entity.Album;

import java.util.List;

public interface IAlbumDAO {
    void add(Album album);

    List<Album> getAll();

    Album getById(Long id);

    boolean isAlbumExist(String name);

    long getIdByName(String name);

    void update(Album album, String newAlbumName);

    void remove(Album album);
}
