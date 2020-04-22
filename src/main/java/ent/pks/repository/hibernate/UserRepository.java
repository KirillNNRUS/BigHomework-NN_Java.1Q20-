package ent.pks.repository.hibernate;

import ent.pks.dao.UserDAO;
import ent.pks.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserDAO {

    @Override
    public void add(User user) {
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
    public void update(User user) {
    }

    @Override
    public void remove(User user) {
    }
}
