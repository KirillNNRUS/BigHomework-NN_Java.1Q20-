package ent.pks.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table()
@NamedQueries({
        @NamedQuery(name = "User.All", query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.Name", query = "SELECT u FROM User u WHERE u.userName = : userName"),
})
public class User {
    public User() {
        this.isLocked = false;

    }

    @Id
    @Column(nullable = false, unique = true)
    private String userName;

    @Column()
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Song> songs;

    @Column(nullable = false)
    private boolean isLocked;

    //Планирую смотреть, можно входить на "сайт" ( который потом будет :-) ) или нет.

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName.trim().toUpperCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isLocked=" + isLocked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isLocked == user.isLocked &&
                userName.equals(user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(songs, user.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, songs, isLocked);
    }
}
