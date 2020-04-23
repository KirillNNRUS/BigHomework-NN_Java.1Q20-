package ent.pks;

import ent.pks.entity.Album;
import ent.pks.entity.Song;
import ent.pks.repository.AlbumRepository;
import ent.pks.repository.SongRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicStore");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static SongRepository songRepository = new SongRepository(entityManager);
    static AlbumRepository albumRepository = new AlbumRepository(entityManager);

    public static void main(String[] args) {
        Song song;
        Album album;

        addSimpleSong("Все это Рок-н-ролл");

        addSimpleSong("Шабаш");

        printAllSongs();

        removeSong("ШаБаШ");
        printAllSongs();

        updateSong("Все это Рок-Н-РОЛл", "All it's Rock-N-Roll");
        printAllSongs();

//        addAlbum("Кино - Группа крови", new Song("Группа Крови - 1988"));
//        printAllSongs();
//
//        addAlbum("Алиса - Шабаш",
//                new Song("Шабаш"),
//                new Song("                 Жар Бог Шуга "),
//                new Song("Бес Паники"),
//                new Song("Лодка"),
//                new Song("Мое Поколение"),
//                new Song("Ко Мне"),
//                new Song("Стерх"),
//                new Song("Ветер Водит Хоровод"),
//                new Song("Чую Гибель"),
//                new Song("Красное На Черном"),
//                new Song("Все Это Рок-Н-Ролл"),
//                new Song("Сумерки"),
//                new Song("Шабаш II"),
//                new Song("Новая Кровь"),
//                new Song("Все В Наших руках")
//        );
//        printAllSongs();
//
//        addAlbum("Кино - Последний герой",
//                new Song("Хочу перемен! "),
//                new Song("Электричка"),
//                new Song("Война"),
//                new Song("Троллейбус"),
//                new Song("              Последний герой"),
//                new Song("Группа крови"),
//                new Song("Мама, мы все тяжело больны"),
//                new Song("В наших глазах"),
//                new Song("Спокойная ночь ")
//        );
//        printAllSongs();
//        printAlbumNames();
//
//        removeAlbum("Кино - Последний герой");
//        printAlbumNames();
//
//        addAlbum("Кино - Последний герой",
//                new Song("Хочу перемен! "),
//                new Song("Электричка"),
//                new Song("Война"),
//                new Song("Троллейбус"),
//                new Song("              Последний герой"),
//                new Song("Группа крови"),
//                new Song("Мама, мы все тяжело больны"),
//                new Song("В наших глазах"),
//                new Song("Спокойная ночь ")
//        );
//        printAlbumNames();
//        System.out.println("!!!!!");
//        removeSong("МАМА, МЫ ВСЕ ТЯЖЕЛО БОЛЬНЫ");
    }

    static void removeAlbum(String albumName) {
        Album album = albumRepository.getById(albumRepository.getIdByName(albumName));
        albumRepository.remove(album);
    }

    static void updateSong(String oldSongName, String newSongName) {
        Song song = songRepository.getById(songRepository.getIdByName(oldSongName));
        songRepository.update(song, newSongName);
    }

    static void removeSong(String songName) {
        Song song = songRepository.getById(songRepository.getIdByName(songName));
        songRepository.remove(song);
    }

    static void addSimpleSong(String songName) {
        Song song = new Song();
        song.setSongName(songName);
        songRepository.add(song);
    }

    static void printAllSongs() {
        System.out.println(songRepository.getAll());
    }

    static void printAlbumNames() {
        System.out.println(albumRepository.getAll());
    }
}
