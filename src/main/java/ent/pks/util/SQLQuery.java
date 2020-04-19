package ent.pks.util;

public class SQLQuery {
    //ALBUMS
    public static final String ALBUM_INSERT = "INSERT INTO ALBUMS VALUES(?, ?)";
    public static final String ALBUM_LIST = "SELECT * FROM ALBUMS";
    public static final String ALBUM_BY_ID = "SELECT * FROM ALBUMS WHERE ALBUM_ID = ?";
    public static final String ALBUM_UPDATE = "UPDATE ALBUMS SET ALBUM_NAME = ? WHERE ALBUM_ID = ?";
    public static final String ALBUM_DELETE = "DELETE FROM ALBUMS WHERE ALBUM_ID = ?";

    //SONGS
    public static final String SONG_INSERT = "INSERT INTO SONGS VALUES(?, ?)";
    public static final String SONG_LIST = "SELECT * FROM SONGS";
    public static final String SONG_BY_ID = "SELECT * FROM SONGS WHERE SONG_ID = ?";
    public static final String SONG_UPDATE = "UPDATE SONGS SET SONG_NAME = ? WHERE SONG_ID = ?";
    public static final String SONG_DELETE = "DELETE FROM SONGS WHERE SONG_ID = ?";
}
