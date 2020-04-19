package ent.pks;

import ent.pks.db.ConnectionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static java.lang.System.err;

public class CreateDB {
    /*
    Решил сделать создание БД и таблиц здесь, что бы Вы могли посмотреть, что и как.
    Для удобства чтения, сначала создаю таблицу, потом назначаю ключи, т.к. иначе запросы слишком громоздкие
     */
    public static void main(String[] args) {
        DBH2 dbh2 = new DBH2();
        try {
            dbh2.createTable("ALBUMS", "ALBUM_ID BIGINT NOT NULL, " +
                    "ALBUM_NAME VARCHAR(255) NOT NULL");
            dbh2.alterTable("ALBUMS", "ADD CONSTRAINT ALBUMS_PKEY PRIMARY KEY (ALBUM_ID)");

            dbh2.createTable("SONGS", "SONG_ID BIGINT NOT NULL, " +
                    "SONG_NAME VARCHAR(255) NOT NULL");
            dbh2.alterTable("SONGS", "ADD CONSTRAINT SONGS_PKEY PRIMARY KEY (SONG_ID)");

            dbh2.createTable("USERS", "USER_NAME VARCHAR(255) NOT NULL UNIQUE, " +
                    "USER_PASSWORD VARCHAR(255) NOT NULL");
            dbh2.alterTable("USERS", "ADD CONSTRAINT USERS_PKEY PRIMARY KEY (USER_NAME)");
        } catch (SQLException e) {
            err.println(e);
        }
    }

    static class DBH2 implements ConnectionDB {
        Connection connection = getConnection();
        Statement statement = null;

        void createTable(String tableName, String createQuery) throws SQLException {
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName +
                    "(" +
                    createQuery +
                    ")");
        }

        void alterTable(String tableName, String alterQuery) throws SQLException {
            statement = connection.createStatement();
            statement.executeUpdate("ALTER TABLE " + tableName + " " + alterQuery);
        }
    }
}
