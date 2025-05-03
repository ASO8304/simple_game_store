package ir.ac.kntu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Developer implements Serializable{

    private String username;

    private String password;

    public Developer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        updateDeveloper();
    }

    public void addDeveloper() {
        Main.developers.add(this);
        updateDeveloper();
    }

    public void deleteDeveloper() {
        if (Main.developers.contains(this)) {
            Main.developers.remove(this);
            updateDeveloper();
        }
    }

    public void updateDeveloper() {
        new DataBase().saveDeveloperInfos(Main.developers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Developer developer = (Developer) o;
        return Objects.equals(username, developer.username) && Objects.equals(password, developer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
