package ent.pks.dao;

import ent.pks.entity.Album;

import java.sql.SQLException;
import java.util.List;

public interface AlbumDAO {
    void add(Album album) throws SQLException;

    List<Album> getAll() throws SQLException;

    Album getById(Long id) throws SQLException;

    Album getByName(String albumName) throws SQLException;

    void update(Album album) throws SQLException;

    void remove(Album album) throws SQLException;
}
