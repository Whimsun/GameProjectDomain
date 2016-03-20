package domain;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Tim on 14/02/2016.
 */
public class Review {
    static AtomicInteger nextReviewID = new AtomicInteger();
    private int reviewID;
    private Game game;
    private String reviewerName;
    private double score;
    private String body;

    public Review(){

    }

    public Review(String reviewerName, Game game, double score, String body) {
        setReviewerName(reviewerName);
        setGame(game);
        setScore(score);
        setBody(body);
    }

    public int getReviewID() {
        return reviewID;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        if(game==null){
            throw new DomainException("This game does not exist");
        }
        else {
            this.game = game;
        }
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        if (reviewerName != null && !reviewerName.isEmpty()) {
            this.reviewerName = reviewerName;
        } else {
            throw new DomainException("The reviewer name must be filled in");
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score >= 0 && score <= 10) {
            this.score = score;
        } else {
            throw new DomainException("The score must be between 0 and 10");
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        if(body!=null&&!body.isEmpty()) {
            this.body = body;
        }else{
            throw new DomainException("The review body may not be empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Review) {
            Review otherReview = (Review) o;
            if (this.reviewID==otherReview.reviewID) {
                return true;
            }
        }
        return false;
    }

}
