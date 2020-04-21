package ent.pks.repository.hibernate;

import ent.pks.dao.AlbumDAO;
import ent.pks.db.ConnectionHibernate;
import ent.pks.entity.Album;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

import static java.lang.System.err;

public class AlbumRepository implements AlbumDAO {
    @Override
    public void add(Album album) {
        try (
                Session session = ConnectionHibernate.getSessionFactory().openSession()
        ) {
            session.getTransaction().begin();
            session.save(album);
            session.getTransaction().commit();
        } catch (Exception e) {
            err.println(e);

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
    public void update(Album album) throws SQLException {
    }

    @Override
    public void remove(Album album) throws SQLException {
    }
}
