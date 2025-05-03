package ir.ac.kntu;

import java.io.Serializable;
import java.util.Objects;

public class Admin implements Serializable {

    private String username;

    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        updateAdmin();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        updateAdmin();
    }

    public void addAdmin() {
        Main.admins.add(this);
        updateAdmin();
    }

    public void deleteAdmin() {
        if (Main.admins.contains(this)) {
            Main.admins.remove(this);
            updateAdmin();
        }
    }

    public void updateAdmin() {
        new DataBase().saveAdminInfos(Main.admins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Admin admin = (Admin) o;
        return Objects.equals(username, admin.username) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
