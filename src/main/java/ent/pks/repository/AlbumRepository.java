package ent.pks.repository;

import ent.pks.dao.AlbumDAO;
import ent.pks.entity.Album;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class AlbumRepository implements AlbumDAO {
    private final EntityManager entityManager;

    public AlbumRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Album> getAll() {
        return entityManager.createNamedQuery("Album.All", Album.class).getResultList();
    }

    @Override
    public Album getById(Long id) {
        Album album = null;
        try {
            album = entityManager.createNamedQuery("Album.getById", Album.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.err.println(e.toString() + " Album ID " + id);
        }
        return album;
    }

    @Override
    public boolean isAlbumExist(String name) {
        return getIdByName(name) != 0;
    }

    @Override
    public long getIdByName(String name) {
        long albumId = 0;
        try {
            albumId = entityManager.createNamedQuery("Album.getIdByName", Album.class)
                    .setParameter("name", name.trim().toUpperCase())
                    .getSingleResult().getId();
        } catch (NoResultException e) {
            System.err.println(e.toString() + " Album " + name);
        }
        return albumId;
    }

    @Override
    public void update(Album album, String newAlbumName) {
        entityManager.getTransaction().begin();
        album.setAlbumName(newAlbumName);
        entityManager.persist(album);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(Album album) {
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();
    }
}
