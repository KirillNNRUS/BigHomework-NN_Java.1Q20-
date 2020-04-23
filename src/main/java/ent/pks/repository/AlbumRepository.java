package ent.pks.repository;

import ent.pks.dao.AlbumDAO;
import ent.pks.entity.Album;

import javax.persistence.EntityManager;
import java.util.List;

public class AlbumRepository implements AlbumDAO {
    private final EntityManager entityManager;

    public AlbumRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Album album) {
        entityManager.getTransaction().begin();
        entityManager.merge(album);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Album> getAll() {
        return entityManager.createNamedQuery("Album.All", Album.class).getResultList();
    }

    @Override
    public Album getById(Long id) {
        return entityManager.createNamedQuery("Album.getById", Album.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public long getIdByName(String name) {
        return entityManager.createNamedQuery("Album.getIdByName", Album.class)
                .setParameter("name", name.trim().toUpperCase())
                .getSingleResult().getId();
    }

    @Override
    public void update(Album album, String newAlbumName) {
        entityManager.getTransaction().begin();
        album.setAlbumName(newAlbumName);
        entityManager.merge(album);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(Album album) {
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();
    }
}
