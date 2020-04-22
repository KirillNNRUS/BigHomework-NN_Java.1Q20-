package ent.pks.repository;

import ent.pks.dao.AlbumDAO;
import ent.pks.entity.Album;

import javax.persistence.EntityManager;
import java.util.List;

public class AlbumRepository implements AlbumDAO {
    private EntityManager entityManager;

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
        return null;
    }

    @Override
    public Album getById(Long id) {
        return null;
    }

    @Override
    public long getIdByName(String name) {
        return 0;
    }

    @Override
    public void update(Album album, String newAlbumName) {
    }

    @Override
    public void remove(Album album) {
    }
}
