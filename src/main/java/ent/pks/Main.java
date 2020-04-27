package ent.pks;

import ent.pks.entity.Album;
import ent.pks.entity.Song;
import ent.pks.entity.User;
import ent.pks.repository.AlbumRepository;
import ent.pks.repository.SongRepository;
import ent.pks.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    /*
    Тут создается БД + заполняется
     */
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("musicStore");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static SongRepository songRepository = new SongRepository(entityManager);
    static AlbumRepository albumRepository = new AlbumRepository(entityManager);
    static UserRepository userRepository = new UserRepository(entityManager);

    public static void main(String[] args) {
        /*
        Все пока пихаю в Main, но догадываюсь, что наверное нужно сделать класс-сервис именно для работы с Repository
        Подскажите, я правильно думаю... В Архитектуре, я, как и все новички, не очень...
         */
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

        removeSong("Спокойная ночь");

        addUser("Kirill", "K!r!ll");
        printAllUsers();
        updateUserPassword("Kirilllllllll", "Pas$word");
        printAllUsers();
        updateUserPassword("Kirill", "Pas$word");
        printAllUsers();

        User user = userRepository.getByUserName("KiriLL");
        Song song = songRepository.getById(songRepository.getIdByName("Все Это Рок-Н-Ролл"));
        Song song1 = songRepository.getById(songRepository.getIdByName(" В наших глазах"));
        Song song2 = songRepository.getById(songRepository.getIdByName("Электричка"));
        Song song3 = songRepository.getById(songRepository.getIdByName("Шабаш"));
        userRepository.addSongToUserSet(user, song, song1, song2, song3);

        //Тут раскоментировать и удалим одну песню
//        User user55 = userRepository.getByUserName("KiriLL");
//        Song song55 = songRepository.getById(songRepository.getIdByName("Электричка"));
//        userRepository.removeSongFromUserSet(user55, song55);

        addUser("TempUser", "temp");
        removeUser("TempUser");
        //Тут раскоментировать и восстановим пользователя
//        restoreUser("TempUser");


        entityManager.close();
        entityManagerFactory.close();
    }

    static void restoreUser(String userName) {
        if (userRepository.getByUserName(userName) == null) {
            return;
        } else {
            User user = userRepository.getByUserName(userName);
            userRepository.restore(user);
        }
    }

    static void removeUser(String userName) {
        if (userRepository.getByUserName(userName) == null) {
            return;
        } else {
            User user = userRepository.getByUserName(userName);
            userRepository.remove(user);
        }
    }

    static void updateUserPassword(String userName, String newPassword) {
        if (userRepository.getByUserName(userName) == null) {
            return;
        } else {
            User user = userRepository.getByUserName(userName);
            userRepository.updatePassword(user, newPassword);
        }
    }

    static void addUser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        userRepository.add(user);
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

    static void printAllUsers() {
        System.out.println(userRepository.getAll());
    }
}
