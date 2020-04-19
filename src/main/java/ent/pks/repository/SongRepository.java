package ent.pks.repository;

import ent.pks.dao.SongDAO;
import ent.pks.db.ConnectionDB;
import ent.pks.entity.Song;
import ent.pks.util.SQLQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.err;

public class SongRepository implements SongDAO, ConnectionDB {

    @Override
    public void add(Song song) throws SQLException {
        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQuery.SONG_INSERT)
        ) {
            preparedStatement.setLong(1, song.getId());
            preparedStatement.setString(2, song.getSongName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            err.println(e);
        }
    }

    @Override
    public List<Song> getAll() throws SQLException {
        List<Song> songList = new ArrayList<>();

        try (
                Connection con = getConnection();
                Statement statement = con.createStatement();
                ResultSet res = statement.executeQuery(SQLQuery.SONG_LIST)
        ) {
            while (res.next()) {
                Song song = new Song();
                song.setId(res.getLong(1));
                song.setSongName(res.getString(2));

                songList.add(song);
            }
        } catch (SQLException e) {
            err.println(e);
        }
        return songList;
    }

    @Override
    public Song getById(Long id) throws SQLException {
        Song song = new Song();
        ResultSet res = null;
        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQuery.SONG_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            res = preparedStatement.executeQuery();
            while (res.next()) {
                song.setId(res.getLong(1));
                song.setSongName(res.getString(2));
            }
        } catch (SQLException e) {
            err.println(e);
        } finally {
            if (res != null) {
                res.close();
            }
        }
        return song;
    }

    @Override
    public void update(Song song) throws SQLException {
        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQuery.SONG_UPDATE)
        ) {
            preparedStatement.setString(1, song.getSongName());
            preparedStatement.setLong(2, song.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            err.println(e);
        }
    }

    @Override
    public void remove(Song song) throws SQLException {
        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQuery.SONG_DELETE)
        ) {
            preparedStatement.setLong(1, song.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            err.println(e);
        }
    }
}