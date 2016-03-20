package domain;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Tim on 14/02/2016.
 */
public class Game {
    static AtomicInteger nextGameID = new AtomicInteger();
    private int gameID;
    private String name;
    private String genre;
    private ArrayList<Review> reviews;

    public Game(){
        gameID= nextGameID.incrementAndGet();
    }

    public Game(String name, String genre) {
        gameID= nextGameID.incrementAndGet();
        setName(name);
        setGenre(genre);
        reviews=new ArrayList<Review>();
    }

    public int getGameID() {
        return gameID;
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

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review){
        if (review == null) {
            throw new DomainException("review does not exist");
        }
        else {
            reviews.add(review);
        }
    }

    public void removeReview(Review review){
        if (review == null) {
            throw new DomainException("review does not exist");
        }
        else {
            reviews.remove(review);
        }
    }

    public double getAverageScore() {
        double totalScore = 0;
        for (Review review : reviews) {
            totalScore += review.getScore();
        }
        return totalScore / reviews.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game othergame = (Game) o;

        return this.gameID==othergame.gameID;

    }

}
