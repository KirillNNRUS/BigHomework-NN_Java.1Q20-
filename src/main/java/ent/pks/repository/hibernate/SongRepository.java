package ent.pks.repository.hibernate;

import ent.pks.dao.SongDAO;
import ent.pks.entity.Song;

import javax.persistence.EntityManager;
import java.util.List;

public class SongRepository implements SongDAO {
    private EntityManager entityManager;

    public SongRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Song song) {
        entityManager.getTransaction().begin();
        entityManager.merge(song);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Song> getAll() {
        return null;
    }

    @Override
    public Song getById(Long id) {
        return null;
    }

    @Override
    public long songIDInDB(String name) {
        return 0;
    }

    @Override
    public void update(Song song) {
    }

    @Override
    public void remove(Song song) {
    }
}
