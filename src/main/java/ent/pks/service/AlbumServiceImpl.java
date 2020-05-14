package ent.pks.service;

import ent.pks.dao.IAlbumDAO;
import ent.pks.entity.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {

    private IAlbumDAO iAlbumDAO;

    @Autowired
    public AlbumServiceImpl(IAlbumDAO iAlbumDAO) {
        this.iAlbumDAO = iAlbumDAO;
    }

    @Override
    public void add(Album album) {

    }

    @Override
    public List<Album> getAll() {
        return iAlbumDAO.getAll();
    }

    @Override
    public Album getById(Long id) {
        return null;
    }

    @Override
    public void update(Album album, String newAlbumName) {

    }

    @Override
    public void delete(Album album) {

    }
}
