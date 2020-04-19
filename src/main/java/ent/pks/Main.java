package ent.pks;

import ent.pks.entity.Album;
import ent.pks.entity.User;
import ent.pks.repository.AlbumRepository;
import ent.pks.repository.UserRepository;

import java.sql.SQLException;

import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        AlbumRepository albumRepository = new AlbumRepository();
        UserRepository userRepository = new UserRepository();

        Album album = new Album();
        album.setAlbumName("First");

        User user = new User();
        user.setUserName("usr1");
        user.setPassword("user1PaS$");
        try {
            albumRepository.add(album);
            userRepository.add(user);
        } catch (SQLException e) {
            err.println(e);
        }
    }
}