package ent.pks.repository;

import ent.pks.dao.AlbumDAO;
import ent.pks.db.ConnectionDB;
import ent.pks.entity.Album;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AlbumRepository implements AlbumDAO, ConnectionDB {
    private final Connection CONNECTION = getConnection();
    private final String ALBUM_INSERT = "INSERT INTO ALBUMS(ALBUM_NAME) VALUES(?)";
    PreparedStatement preparedStatement = null;

    @Override
    public void add(Album album) throws SQLException {
        try {
            preparedStatement = CONNECTION.prepareStatement(ALBUM_INSERT);
            preparedStatement.setString(1, album.getAlbumName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (CONNECTION != null) {
                CONNECTION.close();
            }
        }
    }

    @Override
    public List<Album> getAll() throws SQLException {
        return null;
    }

    @Override
    public Album getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Album getByName(String albumName) throws SQLException {
        return null;
    }

    @Override
    public void update(Album album) throws SQLException {

    }

    @Override
    public void remove(Album album) throws SQLException {

    }
}
