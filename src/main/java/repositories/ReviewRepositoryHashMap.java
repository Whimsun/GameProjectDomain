package repositories;

import domain.Review;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Tim on 14/02/2016.
 */
public class ReviewRepositoryHashMap implements ReviewRepository {
    static AtomicInteger nextReviewID = new AtomicInteger();
    private static Map<Integer,Review> reviews = new HashMap<Integer, Review>();

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
        int id=nextReviewID.incrementAndGet();
        review.setReviewID(id);
        reviews.put(id,review);
    }

    public void update(Review review) {
        int id=review.getReviewID();
        reviews.replace(id, review);
    }

    public void remove(Review review) {
        reviews.remove(review.getReviewID());
    }

    public void removeAllOfGame(int gameID) {
        Collection<Review> allReviews=reviews.values();
        for(Review currentReview:allReviews){
            if(currentReview.getGame().getGameID()==gameID){
                reviews.remove(currentReview.getReviewID());
            }
        }
    }
    
    public void destroy(){
        //do nothing
    }
}
