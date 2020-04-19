package ent.pks.repository;

import ent.pks.dao.UserDAO;
import ent.pks.db.ConnectionDB;
import ent.pks.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserRepository implements UserDAO, ConnectionDB {
    private final Connection CONNECTION = getConnection();
    private final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?)";
    PreparedStatement preparedStatement = null;

    @Override
    public void add(User user) throws SQLException {
        try {
            preparedStatement = CONNECTION.prepareStatement(USER_INSERT);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (CONNECTION != null) {
                CONNECTION.close();
            }
        }

    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }

    @Override
    public User getById(Long id) throws SQLException {
        return null;
    }

    @Override
    public User getByName(String userName) throws SQLException {
        return null;
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public void remove(User user) throws SQLException {

    }
}
