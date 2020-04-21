package ent.pks.repository.hibernate;

import ent.pks.dao.UserDAO;
import ent.pks.db.ConnectionJDBC;
import ent.pks.entity.User;
import ent.pks.util.SQLQueryJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.err;

public class UserRepository implements UserDAO, ConnectionJDBC {

    @Override
    public void add(User user) throws SQLException {
        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQueryJDBC.USER_INSERT)
        ) {
            preparedStatement.setString(1, user.getUserName().toUpperCase());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            err.println(e);
        }
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> userList = new ArrayList<>();

        try (
                Connection con = getConnection();
                Statement statement = con.createStatement();
                ResultSet res = statement.executeQuery(SQLQueryJDBC.USER_LIST)
        ) {
            while (res.next()) {
                User user = new User();
                user.setUserName(res.getString(1));
                user.setPassword(res.getString(2));

                userList.add(user);
            }
        } catch (SQLException e) {
            err.println(e);
        }
        return userList;
    }

    @Override
    public User getById(Long id) throws SQLException {
        User user = new User();
        ResultSet res = null;
        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQueryJDBC.USER_BY_NAME)
        ) {
            preparedStatement.setLong(1, id);
            res = preparedStatement.executeQuery();
            while (res.next()) {
                user.setUserName(res.getString(1));
                user.setPassword(res.getString(2));
            }
        } catch (SQLException e) {
            err.println(e);
        } finally {
            if (res != null) {
                res.close();
            }
        }
        return user;
    }

    @Override
    public void update(User user) throws SQLException {
        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQueryJDBC.USER_UPDATE)
        ) {
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getUserName().toUpperCase());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            err.println(e);
        }
    }

    @Override
    public void remove(User user) throws SQLException {
        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQueryJDBC.USER_DELETE)
        ) {
            preparedStatement.setString(1, user.getUserName().toUpperCase());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            err.println(e);
        }
    }
}
