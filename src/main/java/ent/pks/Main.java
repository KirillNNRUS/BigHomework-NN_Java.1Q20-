package ent.pks;

import ent.pks.entity.Album;
import ent.pks.entity.Song;
import ent.pks.repository.AlbumRepository;
import ent.pks.repository.SongRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicStore");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static SongRepository songRepository = new SongRepository(entityManager);
    static AlbumRepository albumRepository = new AlbumRepository(entityManager);

    public static void main(String[] args) {
        Song song;
        Album album;

        addSong("Все это Рок-н-ролл");

        addSong("Шабаш");

        printAllSongs();

        removeSong("ШаБаШ");
        printAllSongs();

        updateSong("Все это Рок-Н-РОЛл", "All it's Rock-N-Roll");
        printAllSongs();

        album = new Album();
        album.setAlbumName("Алиса - Шабаш");

        addSong("Шабаш", album);
        addSong("                 Жар Бог Шуга ", album);
        addSong("Бес Паники", album);
        addSong("                 Лодка ", album);
        addSong("  Мое Поколение ", album);
        addSong(" Ко Мне ", album);
        addSong("          Стерх ", album);
        addSong("Ветер Водит Хоровод", album);
        addSong("     Чую Гибель ", album);
        addSong(" Красное На Черном ", album);
        addSong("    Все Это Рок-Н-Ролл ", album);
        addSong("   Сумерки ", album);
        addSong("   Шабаш II ", album);
        addSong("    Новая Кровь ", album);
        addSong("  Все В Наших руках ", album);

        long i = albumRepository.getIdByName("Кино - Последний герой");

        album = albumRepository.getById(30L);

        printAllSongs();

        album = new Album();
        album.setAlbumName("Кино - Последний герой");
        addSong("Электричка", album);
        addSong("Хочу перемен! ", album);
        addSong("Война ", album);
        addSong("Троллейбус ", album);
        addSong("   Последний герой ", album);
        addSong("Группа крови ", album);
        addSong("Мама, мы все тяжело больны", album);
        addSong("  В наших глазах ", album);
        addSong("Спокойная ночь  ", album);

        printAllSongs();
        printAlbumNames();

        addAlbum("Киркоров - Ой, мама, шика дам!");
        printAlbumNames();
        //WTF
        removeAlbum("Киркоров - Ой, мама, шика дам!");
        printAlbumNames();
    }

    static void addAlbum(String albumName) {
        if (albumRepository.isAlbumExist(albumName)) {
            return;
        } else {
            Album album = new Album();
            album.setAlbumName(albumName);
            albumRepository.add(album);
        }
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

    static void addSong(String songName) {
        Song song = new Song();
        song.setSongName(songName);
        songRepository.add(song);
    }

    static void addSong(String songName, String albumName) {
        Song song = new Song();
        Album album = new Album();
        album.setAlbumName(albumName);
        song.setSongName(songName);
        song.setAlbum(album);
        songRepository.add(song);
    }

    static void addSong(String songName, Album album) {
        Song song = new Song();
        song.setSongName(songName);
        song.setAlbum(album);
        songRepository.add(song);
    }

    static void printAllSongs() {
        System.out.println(songRepository.getAll());
    }

    static void printAlbumNames() {
        System.out.println(albumRepository.getAll());
    }
}
