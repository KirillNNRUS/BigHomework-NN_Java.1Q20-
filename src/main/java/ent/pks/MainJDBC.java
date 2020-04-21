package ent.pks;

import ent.pks.entity.Song;
import ent.pks.repository.jdbc.SongRepositoryJDBC;

import java.sql.SQLException;

public class MainJDBC {
    public static void main(String[] args) {


        SongRepositoryJDBC songRepository = new SongRepositoryJDBC();

        Song song = new Song();
        song.setSongName("s01");
        song.setId(1L);
        Song song2 = new Song();
        song2.setSongName("SsS02");
        song2.setId(2L);
        Song song3 = new Song();
        song3.setSongName("dgdfgdf0003");
        song3.setId(3L);
        Song song4 = new Song();
        song4.setSongName("jkhkhj44444");
        song4.setId(4L);

        try {
            songRepository.add(song);
            songRepository.add(song2);
            songRepository.add(song3);
            songRepository.add(song4);
            System.out.println(songRepository.getAll());
            System.out.println("-----");
            song3 = new Song();
            song3.setId(3L);
            song3.setSongName("dgdfgdf0003");
            songRepository.remove(song3);
            System.out.println(songRepository.getAll());
            song4 = new Song();
            song4.setId(4L);
            song4.setSongName("4_4_4kkkl");
            songRepository.update(song4);
            System.out.println(songRepository.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}