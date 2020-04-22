package ent.pks.repository.hibernate;

import ent.pks.dao.AlbumDAO;
import ent.pks.entity.Album;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

import static java.lang.System.err;

public class AlbumRepository implements AlbumDAO {
    @Override
    public void add(Album album) {
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
    public long albumIDInDB(String name) throws SQLException {
        return 0;
    }

    @Override
    public void update(Album album) throws SQLException {
    }

    @Override
    public void remove(Album album) throws SQLException {
    }
}
