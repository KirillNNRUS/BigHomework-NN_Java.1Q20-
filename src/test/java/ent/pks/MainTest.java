package ent.pks;

import ent.pks.entity.Song;
import ent.pks.entity.User;
import ent.pks.dao.SongDAOImpl;
import ent.pks.dao.UserDAOImpl;
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
        UserDAOImpl userRepository = new UserDAOImpl(entityManager);
        User user = new User();
        user.setUserName("TestUser");
        userRepository.add(user);

        //Все закрываю, что бы потом точно читалось из БД
        userRepository = null;
        entityManager.close();


        entityManager = entityManagerFactory.createEntityManager();
        userRepository = new UserDAOImpl(entityManager);
        User user1 = userRepository.getByUserName("TestUser");
        Assertions.assertEquals("TESTUSER", user1.getUserName());
        //Вот тут нужно удалить пользователя
    }

    @Test
    void createSong() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        SongDAOImpl songRepository = new SongDAOImpl(entityManager);
        Song song = new Song();
        song.setSongName("TestSong");
        songRepository.add(song);

        //Все закрываю, что бы потом точно читалось из БД
        songRepository = null;
        entityManager.close();


        entityManager = entityManagerFactory.createEntityManager();
        songRepository = new SongDAOImpl(entityManager);
        Song song1 = songRepository.getById(songRepository.getIdByName("TestSong"));
        Assertions.assertEquals("TESTSONG", song1.getSongName());
    }
}
