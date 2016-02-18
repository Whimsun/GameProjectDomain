package domain;

import java.util.ArrayList;

/**
 * Created by Tim on 14/02/2016.
 */
public class Game {
    private String name;
    private String genre;
    private ServiceFacade facade;

    public Game(String name, String genre, ServiceFacade facade) {
        setName(name);
        setGenre(genre);
        this.facade=facade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if( name!=null){this.name = name;}else throw new DomainException("name is empty");
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if(genre!=null){this.genre = genre;}else throw new DomainException("genre is empty");
    }

    public double getAverageScore() {
        double totalScore = 0;
        ArrayList<Review> reviews=facade.getGameReviews(this.name);
        for (Review review : reviews) {
            totalScore += review.getScore();
        }
        return totalScore / reviews.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (!name.equals(game.name)) return false;
        return genre.equals(game.genre);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + genre.hashCode();
        return result;
    }
}
