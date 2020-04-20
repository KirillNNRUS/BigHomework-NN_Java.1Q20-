package ent.pks;

import ent.pks.db.ConnectionHibernate;
import ent.pks.entity.Album;
import ent.pks.entity.Song;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.Set;

public class MainHibernate {
    public static void main(String[] args) {

        Session session = ConnectionHibernate.getSessionFactory().openSession();
        session.beginTransaction();

        Song song01 = new Song();
        song01.setId(1L);
        song01.setSongName("Неизвестная песня");

        Song song02 = new Song();
        song02.setId(2L);
        song02.setSongName("Звезда по имени Солнце");

        Song song03 = new Song();
        song03.setId(3L);
        song03.setSongName("Группа крови");

        Album album = new Album();
        album.setId(1L);
        album.setAlbumName("Кино - Легенда (Сборник)");
        Set<Song> songs = new HashSet<>();
        songs.add(song02);
        songs.add(song03);
        album.setSongs(songs);


        session.save(song01);
        session.save(song02);
        session.save(song03);
        session.save(album);

        session.getTransaction().commit();
        ConnectionHibernate.shutdown();

    }
}
