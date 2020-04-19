package ent.pks.dao;

import ent.pks.entity.Song;

import java.sql.SQLException;
import java.util.List;

public interface SongDAO {
    void add(Song song) throws SQLException;

    List<Song> getAll() throws SQLException;

    Song getById(Long id) throws SQLException;

    void update(Song song) throws SQLException;

    void remove(Song song) throws SQLException;
}
