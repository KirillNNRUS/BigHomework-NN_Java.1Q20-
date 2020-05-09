package ent.pks.dao;

import ent.pks.entity.Song;
import ent.pks.entity.User;

import java.util.List;

public interface IUserDAO {
    void add(User user);

    List<User> getAll();

    User getByUserName(String userName);

    void updatePassword(User user, String newUserPassword);

    void remove(User user);

    void restore(User user);

    void addSongToUserSet(User user, Song... songs);

    void removeSongFromUserSet(User user, Song... songs);
}
