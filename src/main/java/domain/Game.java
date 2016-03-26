package domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by Tim on 14/02/2016.
 */
@Entity
public class Game {
    @Id
    @GeneratedValue
    private int gameID;
    private String name;
    private String genre;
    @OneToMany(mappedBy = "game",orphanRemoval = true)
    private List<Review> reviews;

    public Game(){
        reviews=new ArrayList<Review>();
    }

    public Game(String name, String genre) {
        setName(name);
        setGenre(genre);
        reviews=new ArrayList<Review>();
    }
    
    public Game(int id,String name,String genre){
        setGameID(id);
        setName(name);
        setGenre(genre);
        reviews=new ArrayList<Review>();
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if( name!=null&&!name.isEmpty()){this.name = name;}else throw new DomainException("name is empty");
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if(genre!=null&&!genre.isEmpty()) {this.genre = genre;}else throw new DomainException("genre is empty");
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review){
        if (review == null) {
            throw new DomainException("review does not exist");
        }
        else {
            reviews.add(review);
            review.setGame(this);
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
