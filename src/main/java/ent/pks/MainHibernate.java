package ent.pks;

import ent.pks.entity.Song;
import ent.pks.repository.hibernate.SongRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainHibernate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        SongRepository songRepository = new SongRepository(entityManager);
        Song song = new Song();
        song.setId(20L);
        song.setSongName("Все это Рок-н-ролл");

        Song song1 = new Song();
        song1.setSongName("Бобо");

        songRepository.add(song);
        songRepository.add(song1);

    }
}
