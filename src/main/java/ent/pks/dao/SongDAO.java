package ent.pks.dao;

import ent.pks.entity.Song;

import java.util.List;

public interface SongDAO {
    void add(Song song);

    List<Song> getAll();

    Song getById(Long id);

    boolean isSongExist(String name);

    long getIdByName(String name);

    void update(Song song, String newSongName);

    void remove(Song song);
}
