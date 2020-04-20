package ent.pks.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SONGS")
public class Song {
    public Song() {
    }

    @Id
    @Column(name = "SONG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "SONG_NAME", nullable = false)
    private String songName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName.toUpperCase();
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songName='" + songName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id &&
                songName.equals(song.songName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, songName);
    }
}
