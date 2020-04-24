package ent.pks;

import ent.pks.entity.Song;
import ent.pks.entity.User;
import ent.pks.repository.SongRepository;
import ent.pks.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainTest {
    @Test
    void createUser() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserRepository userRepository = new UserRepository(entityManager);
        User user = new User();
        user.setUserName("TestUser");
        userRepository.add(user);

        //Все закрываю, что бы потом точно читалось из БД
        userRepository = null;
        entityManager.close();


        entityManager = entityManagerFactory.createEntityManager();
        userRepository = new UserRepository(entityManager);
        User user1 = userRepository.getByUserName("TestUser");
        Assertions.assertEquals("TESTUSER", user1.getUserName());
        //Вот тут нужно удалить пользователя
    }

    @Test
    void createSong() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        SongRepository songRepository = new SongRepository(entityManager);
        Song song = new Song();
        song.setSongName("TestSong");
        songRepository.add(song);

        //Все закрываю, что бы потом точно читалось из БД
        songRepository = null;
        entityManager.close();


        entityManager = entityManagerFactory.createEntityManager();
        songRepository = new SongRepository(entityManager);
        Song song1 = songRepository.getById(songRepository.getIdByName("TestSong"));
        Assertions.assertEquals("TESTSONG", song1.getSongName());
    }
}
