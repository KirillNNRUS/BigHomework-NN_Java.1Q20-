package ent.pks.util;

public class SQLQuery {
    public static final String ALBUM_INSERT = "INSERT INTO ALBUMS(ALBUM_NAME) VALUES(?)";
    public static final String ALBUM_LIST = "SELECT * FROM ALBUMS";
    public static final String ALBUM_BY_ID = "SELECT * FROM ALBUMS WHERE ALBUM_ID = ?";
    public static final String ALBUM_BY_NAME = "SELECT * FROM ALBUMS WHERE ALBUM_NAME = ?";
    public static final String ALBUM_UPDATE = "UPDATE ALBUMS SET ALBUM_NAME = ? WHERE ALBUM_ID = ?";
    public static final String ALBUM_DELETE = "DELETE FROM ALBUMS WHERE ALBUM_ID = ?";
}
