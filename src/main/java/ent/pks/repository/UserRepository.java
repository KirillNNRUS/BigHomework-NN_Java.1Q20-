package ent.pks.repository;

import ent.pks.dao.UserDAO;
import ent.pks.entity.User;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserDAO {
    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
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
        List<User> userList = new ArrayList<>();
        return null;
    }

    @Override
    public User getByUserName(Long id) {
        return null;
    }

    @Override
    public boolean isUserExist(String name) {
        return false;
    }

    @Override
    public void update(User user, String newPassword) {
    }

    @Override
    public void remove(User user) {
    }
}
