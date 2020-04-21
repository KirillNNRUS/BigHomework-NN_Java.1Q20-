package ent.pks.repository.hibernate;

import ent.pks.dao.SongDAO;
import ent.pks.db.ConnectionHibernate;
import ent.pks.entity.Song;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

import static java.lang.System.err;

public class SongRepository implements SongDAO {
    @Override
    public void add(Song song) {
        try (
                Session session = ConnectionHibernate.getSessionFactory().openSession()
        ) {
            session.getTransaction().begin();
            session.save(song);
            session.getTransaction().commit();
        } catch (Exception e) {
            err.println(e);

        }
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
    public void update(Song song) throws SQLException {

    }

    @Override
    public void remove(Song song) throws SQLException {
    }
}
