package domain;

import java.util.ArrayList;

/**
 * Created by Tim on 14/02/2016.
 */
public class Game {
    private String name;
    private String genre;
    private ArrayList<Review> reviews = new ArrayList<Review>();

    public Game(String name, String genre) {
        setName(name);
        setGenre(genre);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAverageScore() {
        int totalScore = 0;
        for (Review review : reviews) {
            totalScore += review.getScore();
        }
        return totalScore / reviews.size();
    }
}
