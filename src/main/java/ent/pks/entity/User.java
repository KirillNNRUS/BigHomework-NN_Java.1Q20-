package ent.pks.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table()
public class User {
    public User() {
    }

    @Id
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName.toUpperCase();
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.userName) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }
}
