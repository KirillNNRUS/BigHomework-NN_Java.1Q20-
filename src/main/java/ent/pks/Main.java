package ent.pks;

import ent.pks.entity.Album;
import ent.pks.repository.AlbumRepository;
import ent.pks.repository.UserRepository;

import java.sql.SQLException;

import static java.lang.System.err;

public class Main {
    public static void main(String[] args) {
        AlbumRepository albumRepository = new AlbumRepository();
        UserRepository userRepository = new UserRepository();

        Album album = new Album();
        album.setAlbumName("First");


        try {
            albumRepository.add(album);

        } catch (SQLException e) {
            err.println(e);
        }

        try {
            System.out.println(albumRepository.getByName("First"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}