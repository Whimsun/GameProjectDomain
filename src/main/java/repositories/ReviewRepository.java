package repositories;

import domain.Review;

import java.util.ArrayList;

/**
 * Created by Tim on 14/02/2016.
 */
public interface ReviewRepository {
    Review getReview(int reviewID);
    void add(Review review);
    void update(int reviewID, String reviewerName,double score,String body);
    void remove(int reviewID);
    void removeAllOfGame(int gameID);
}
