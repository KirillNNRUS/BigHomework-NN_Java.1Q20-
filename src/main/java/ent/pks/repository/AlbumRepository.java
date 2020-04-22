package ent.pks.repository;

import ent.pks.dao.AlbumDAO;
import ent.pks.entity.Album;

import java.sql.SQLException;
import java.util.List;

public class AlbumRepository implements AlbumDAO {
    @Override
    public void add(Album album) {
    }

    @Override
    public List<Album> getAll()  {
        return null;
    }

    @Override
    public Album getById(Long id) {
        return null;
    }

    @Override
    public long getIdByName(String name)  {
        return 0;
    }

    @Override
    public void update(Album album, String newAlbumName)  {
    }

    @Override
    public void remove(Album album)  {
    }
}
