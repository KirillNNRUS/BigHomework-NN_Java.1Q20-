package ent.pks;

import ent.pks.entity.Album;
import ent.pks.entity.Song;
import ent.pks.repository.AlbumRepository;
import ent.pks.repository.SongRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        SongRepository songRepository = new SongRepository(entityManager);
        AlbumRepository albumRepository = new AlbumRepository(entityManager);
        Song song = new Song();
        Album album = new Album();
        song.setSongName("Все это Рок-н-ролл");
        songRepository.add(song);

        song = new Song();
        song.setSongName("Шабаш");

        songRepository.add(song);

        System.out.println(songRepository.getAll());

        //remove
        long songId = songRepository.getIdByName("ШаБаШ");
        song = songRepository.getById(songId);
        songRepository.remove(song);
        System.out.println(songRepository.getAll());

        //update
        songId = songRepository.getIdByName("Все это Рок-Н-РОЛл");
        song = songRepository.getById(songId);
        songRepository.update(song, "All it's Rock-N-Roll");
        System.out.println(songRepository.getAll());

        song = new Song();
        song.setSongName("Группа Крови");
        album.setAlbumName("Группа крови - Кино");
        album.setSongs(Stream.of(song).collect(Collectors.toSet()));
        albumRepository.add(album);

    }
}
