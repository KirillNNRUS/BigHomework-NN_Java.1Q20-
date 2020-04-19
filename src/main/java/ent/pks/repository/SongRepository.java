package ent.pks.repository;

import ent.pks.dao.SongDAO;
import ent.pks.db.ConnectionDB;
import ent.pks.entity.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SongRepository implements SongDAO, ConnectionDB {
    private final Connection CONNECTION = getConnection();
    private final String SONG_INSERT = "INSERT INTO SONGS(SONG_NAME) VALUES(?)";
    PreparedStatement preparedStatement = null;

    @Override
    public void add(Song song) throws SQLException {

    }

    @Override
    public List<Song> getAll() throws SQLException {
        return null;
    }

    @Override
    public Song getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Song getByName(String songName) throws SQLException {
        return null;
    }

    @Override
    public void update(Song song) throws SQLException {

    }

    @Override
    public void remove(Song song) throws SQLException {

    }
}
