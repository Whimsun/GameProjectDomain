package repositories;

import domain.Review;

/**
 * Created by Tim on 14/02/2016.
 */
public interface ReviewRepository {
    Review getReview(int reviewID);
    void add(Review review);
    void update(Review review);
    void remove(Review review);
    void removeAllOfGame(int gameID);
}
