package ent.pks.dao;

import ent.pks.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void add(User user) throws SQLException;

    List<User> getAll() throws SQLException;

    User getById(Long id) throws SQLException;

    User getByName(String userName) throws SQLException;

    void update(User user) throws SQLException;

    void remove(User user) throws SQLException;
}
