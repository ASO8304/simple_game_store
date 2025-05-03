package ir.ac.kntu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Game implements Serializable {

    private String name;

    private double rating;

    private HashMap<User, Double> ratingMap = new HashMap<User, Double>();

    private int numOfRatings;

    private Genre genre;

    private Double price;

    private HashMap<User, String> comment = new HashMap<>();

    private String description;

    private ArrayList<Developer> developers = new ArrayList<>();


    public Game(String name, Genre genre, Double price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public Game(String name, Genre genre, Double price, String description) {
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.description = description;
    }

    public Game(String name, double rating, int numOfRatings, Genre genre,
                Double price, String description) {
        this.name = name;
        this.rating = rating;
        this.numOfRatings = numOfRatings;
        this.genre = genre;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateGame();
    }

    public double getRating() {
        return rating;
    }

    public void addRating(User user, Double userRating) {
        ratingMap.put(user, userRating);
        calculateRating();
        updateGame();
    }

    public void calculateRating() {
        Double sumRatings = 0.0;
        int counterRatings = 0;
        for (User user : Main.users) {
            if (ratingMap.containsKey(user)) {
                counterRatings++;
                sumRatings += ratingMap.get(user);
            }
        }
        this.rating = (sumRatings / counterRatings);

    }

    public int getNumOfRatings() {
        return numOfRatings;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
        updateGame();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        updateGame();
    }

    public HashMap<User, String> getComment() {
        return comment;
    }

    public void setComment(HashMap<User, String> comment) {
        this.comment = comment;
        updateGame();
    }

    public void addComment(User user, String userComment) {
        this.comment.put(user, userComment);
        updateGame();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        updateGame();
    }

    public void addGame() {
        Main.games.add(this);
        updateGame();
    }

    public void deleteGame() {
        Main.games.remove(this);
        developers.remove(this);
        updateGame();
    }

    public void addGameDeveloper(Developer developer) {
        developers.add(developer);
        updateGame();
    }

    public void removeGameDeveloper(Developer developer) {
        if (developers.contains(developer)) {
            developers.remove(developer);
            updateGame();
        }
    }

    public void updateGame() {
        new DataBase().saveGameInfos(Main.games);
    }

    public ArrayList<Developer> getGameDevelopers() {
        return new ArrayList<>(developers);
    }

    @Override
    public String toString() {
        return ("Name:" + getName() + "  Genre:" + getGenre() + "  Description:" + getDescription() +
                "  Rating:" + this.getRating() + "\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Game game = (Game) o;
        return Double.compare(game.rating, rating) == 0 && numOfRatings == game.numOfRatings && Double.compare(game.price, price) == 0 && Objects.equals(name, game.name) && Objects.equals(ratingMap, game.ratingMap) && genre == game.genre && Objects.equals(comment, game.comment) && Objects.equals(description, game.description) && Objects.equals(developers, game.developers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, ratingMap, numOfRatings, genre, price, comment, description, developers);
    }
}
