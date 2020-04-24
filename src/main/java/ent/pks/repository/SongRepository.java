package ent.pks.repository;

import ent.pks.dao.SongDAO;
import ent.pks.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class SongRepository implements SongDAO {
    private final EntityManager entityManager;

    public SongRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Song song) {
        entityManager.getTransaction().begin();
        entityManager.persist(song);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Song> getAll() {
        return entityManager.createNamedQuery("Song.All", Song.class).getResultList();
    }

    @Override
    public Song getById(Long id) {
        Song song = null;
        try {
            song = entityManager.createNamedQuery("Song.getById", Song.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.err.println(e.toString() + " Song ID" + id);
        }
        return song;
    }

    @Override
    public boolean isSongExist(String name) {
        return getIdByName(name) != 0;
    }

    @Override
    public long getIdByName(String name) {
        long songId = 0;
        try {
            songId = entityManager.createNamedQuery("Song.getIdByName", Song.class)
                    .setParameter("name", name.trim().toUpperCase())
                    .getSingleResult().getId();
        } catch (NoResultException e) {
            System.err.println(e.toString() + " Song " + name);
        }
        return songId;
    }

    @Override
    public void update(Song song, String newSongName) {
        entityManager.getTransaction().begin();
        song.setSongName(newSongName);
        entityManager.persist(song);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(Song song) {
        entityManager.getTransaction().begin();
        entityManager.remove(song);
        entityManager.getTransaction().commit();
    }
}
