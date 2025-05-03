package ir.ac.kntu;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private ArrayList<Game> userGames = new ArrayList<>();

    private ArrayList<User> userFriends = new ArrayList<>();

    private ArrayList<User> userRequests = new ArrayList<>();

    private double wallet;

    private long logInTime = 0;

    private long logOutTime = 0;

    private long playTime = 0;

    private long score;


    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.wallet = 0.0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        updateUser();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        updateUser();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        updateUser();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        updateUser();
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
        updateUser();
    }

    public void chargeWallet(double charge) {
        this.wallet = this.wallet + charge;
        updateUser();
    }

    public void addGame(Game game) {
        userGames.add(game);
        updateUser();
    }

    public ArrayList getUserGames() {
        return userGames;
    }

    public String getUserGamesName(int index) {
        return userGames.get(index).getName();
    }

    public ArrayList<User> getUserFriends() {
        return userFriends;
    }

    public String getUserFriendsName(int index) {
        return userFriends.get(index).getUsername();
    }

    public void setLogInTime(long logInTime) {
        this.logInTime = logInTime;
    }

    public void setLogOutTime(long logOutTime) {
        this.logOutTime = logOutTime;
        updatePlayTime();
    }

    public long getPlayTime() {
        return playTime;
    }

    public void updatePlayTime() {
        this.playTime += (logOutTime - logInTime);
        logInTime = 0;
        logOutTime = 0;
        updateScore();
        updateUser();
    }

    public void updateScore() {
        score = ((playTime / 1000) / 2);
    }

    public long getScore() {
        return score;
    }

    public float getDiscountMultiplier() {
        if (this.score >= 20 && this.score < 50) {
            return 0.9F;
        } else if (this.score >= 50 && this.score < 100) {
            return 0.8F;
        } else if (this.score >= 100) {
            return 0.7F;
        } else {
            return 1;
        }
    }

    public void addRequest(User requester) {
        userRequests.add(requester);
        updateUser();
    }

    public void deleteRequester(User requester) {
        userRequests.remove(requester);
        updateUser();
    }

    public void addFriend(User requester) {
        userFriends.add(requester);
        updateUser();
    }

    public ArrayList<User> getUserRequests() {
        return userRequests;
    }

    public void addUser() {
        Main.users.add(this);
        updateUser();
    }

    public void updateUser() {
        new DataBase().saveUserInfos(Main.users);
    }

    @Override
    public String toString() {
        return new String("Username:" + " " + this.username + "\n" +
                "Password: " + this.password + "\n" +
                "Email: " + this.email + "\n" +
                "PhoneNumber: " + this.phoneNumber + "\n" +
                "Wallet: " + this.wallet + "\n" +
                "PlayTime: " + this.playTime + "s" + "\n" +
                "Score: " + this.getScore());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Double.compare(user.wallet, wallet) == 0 && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email, phoneNumber);
    }
}



