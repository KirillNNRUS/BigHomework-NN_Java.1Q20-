package ent.pks.dao;

import ent.pks.entity.User;

import java.util.List;

public interface UserDAO {
    void add(User user);

    List<User> getAll();

    User getByUserName(Long id);

    void update(User user, String newUserPassword);

    void remove(User user);
}
