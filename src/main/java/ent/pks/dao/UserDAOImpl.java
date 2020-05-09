package ent.pks.dao;

import ent.pks.entity.Song;
import ent.pks.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDAOImpl implements IUserDAO {
    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<User> getAll() {
        return entityManager.createNamedQuery("User.All", User.class).getResultList();
    }

    @Override
    public User getByUserName(String userName) {
        User user = null;
        try {
            user = entityManager.createNamedQuery("User.Name", User.class)
                    .setParameter("userName", userName.trim().toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            System.err.println(e.toString() + " User " + userName);
        }
        return user;
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        entityManager.getTransaction().begin();
        user.setPassword(newPassword);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(User user) {
        //По факту только выставляет пользователю isLocked = true.
        //Пользователя из БД не удаляем.
        entityManager.getTransaction().begin();
        user.setLocked(true);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void restore(User user) {
        entityManager.getTransaction().begin();
        user.setLocked(false);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void addSongToUserSet(User user, Song... songs) {
        Set<Song> songSet;

        if (user.getSongs() == null) {
            songSet = new HashSet<>();
        } else {
            songSet = user.getSongs();
        }

        Collections.addAll(songSet, songs);

        entityManager.getTransaction().begin();
        user.setSongs(songSet);
        entityManager.persist(user);
        entityManager.getTransaction().commit();

    }

    @Override
    public void removeSongFromUserSet(User user, Song... songs) {
        Set<Song> songSet = user.getSongs();

        for (Song song : songs) {
            songSet.remove(song);
        }

        entityManager.getTransaction().begin();
        user.setSongs(songSet);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
