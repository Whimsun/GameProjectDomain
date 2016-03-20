package repositories;

import domain.Review;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Tim on 14/02/2016.
 */
public class ReviewRepositoryHashMap implements ReviewRepository {

    private HashMap<Integer,Review> reviews = new HashMap<Integer, Review>();

    public ReviewRepositoryHashMap() {
    }

    //returns null when review not present
    public Review getReview(int reviewID) {
        return reviews.get(reviewID);
    }

    public void add(Review review) {
        if(review==null){
            throw new RepositoryException("Error adding review");
        }
        reviews.put(review.getReviewID(),review);
    }

    public void update(int reviewID, String reviewerName, double score, String body) {
        Review reviewToEdit=reviews.get(reviewID);
        reviewToEdit.setReviewerName(reviewerName);
        reviewToEdit.setScore(score);
        reviewToEdit.setBody(body);
    }

    public void remove(int reviewID) {
        reviews.remove(reviewID);
    }

    public void removeAllOfGame(int gameID) {
        Collection<Review> allReviews=reviews.values();
        for(Review currentReview:allReviews){
            if(currentReview.getGame().getGameID()==gameID){
                reviews.remove(currentReview.getReviewID());
            }
        }
    }
}
