package repositories;

import domain.Review;

import java.util.ArrayList;

/**
 * Created by Tim on 14/02/2016.
 */
public interface ReviewRepository {
    ArrayList<Review> getGameReviews(String gameName);
    void add(Review review);
    void remove(Review review);
}
