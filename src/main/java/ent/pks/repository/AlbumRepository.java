package ent.pks.repository;

import ent.pks.dao.AlbumDAO;
import ent.pks.db.ConnectionDB;
import ent.pks.entity.Album;
import ent.pks.util.SQLQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.err;

public class AlbumRepository implements AlbumDAO, ConnectionDB {

    @Override
    public void add(Album album) throws SQLException {

        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQuery.ALBUM_INSERT)
        ) {

            preparedStatement.setString(1, album.getAlbumName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            err.println(e);
        }
    }

    @Override
    public List<Album> getAll() throws SQLException {
        List<Album> albumList = new ArrayList<>();

        try (
                Connection con = getConnection();
                Statement statement = con.createStatement();
                ResultSet res = statement.executeQuery(SQLQuery.ALBUM_LIST)
        ) {
            while (res.next()) {
                Album album = new Album();
                album.setId(res.getLong(1));
                album.setAlbumName(res.getString(2));

                albumList.add(album);
            }

        } catch (SQLException e) {
            err.println(e);
        }
        return albumList;
    }

    @Override
    public Album getById(Long id) throws SQLException {
        Album album = new Album();
        ResultSet res = null;
        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQuery.ALBUM_BY_ID)
        ) {
            preparedStatement.setLong(1, id);
            res = preparedStatement.executeQuery();
            while (res.next()) {
                album.setId(res.getLong(1));
                album.setAlbumName(res.getString(2));
            }
        } catch (SQLException e) {
            err.println(e);
        } finally {
            if (res != null) {
                res.close();
            }
        }
        return album;
    }

    @Override
    public Album getByName(String albumName) throws SQLException {
        Album album = new Album();
        ResultSet res = null;
        try (
                Connection con = getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(SQLQuery.ALBUM_BY_NAME)
        ) {

            preparedStatement.setString(1, albumName.toUpperCase());
            res = preparedStatement.executeQuery();
            while (res.next()) {
                album.setId(res.getLong(1));
                album.setAlbumName(res.getString(2));
                /*
                Берем первый, который нашли
                 */
                break;
            }
        } catch (SQLException e) {
            err.println(e);
        } finally {
            if (res != null) {
                res.close();
            }
        }
        return album;
    }

    @Override
    public void update(Album album) throws SQLException {

    }

    @Override
    public void remove(Album album) throws SQLException {

    }
}
