package ent.pks.repository;

import ent.pks.dao.SongDAO;
import ent.pks.entity.Song;

import javax.persistence.EntityManager;
import java.util.List;

public class SongRepository implements SongDAO {
    private final EntityManager entityManager;

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
        return entityManager.createNamedQuery("Song.All", Song.class).getResultList();
    }

    @Override
    public Song getById(Long id) {
        return entityManager.createNamedQuery("Song.getById", Song.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public long getIdByName(String name) {
        return entityManager.createNamedQuery("Song.getIdByName", Song.class)
                .setParameter("name", name.trim().toUpperCase())
                .getSingleResult().getId();
    }

    public long getAlbumIDFromSongId(long songId) {
        entityManager.createNativeQuery("SELECT * FROM ALBUM_SONG as2 WHERE SONGS_ID = ?1").setParameter(1, songId).getSingleResult();
        return 0;
    }

    @Override
    public void update(Song song, String newSongName) {
        entityManager.getTransaction().begin();
        song.setSongName(newSongName);
        entityManager.merge(song);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(Song song) {
        entityManager.getTransaction().begin();
        entityManager.remove(song);
        entityManager.getTransaction().commit();
    }
}
