package ent.pks.dao;

import ent.pks.entity.Album;

import java.sql.SQLException;
import java.util.List;

public interface AlbumDAO {
    void add(Album album) throws Exception;

    List<Album> getAll() throws Exception;

    Album getById(Long id) throws Exception;

    long albumIDInDB(String name) throws Exception;

    void update(Album album) throws SQLException;

    void remove(Album album) throws SQLException;
}
