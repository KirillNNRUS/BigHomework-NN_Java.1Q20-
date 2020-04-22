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
        /*
        Может я балбес, и не умею искать информацию в интернете, но...
        на всех найденных мною примерах было...
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        И, в БД ничего, именно НИЧЕГО не записывалось...
        потратил на поиски два дня..., где то на stackoverflow.com нашел...
        Нужно закомитить... и думаю удалить наконец JDBC
         */
        entityManager.merge(song);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Song> getAll() {
        return null;
    }

    @Override
    public Song getById(Long id) {
        Song song = entityManager.find(Song.class, id);
        return song;
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
