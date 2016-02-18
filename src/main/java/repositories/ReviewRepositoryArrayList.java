package repositories;

import domain.Review;

import java.util.ArrayList;

/**
 * Created by Tim on 14/02/2016.
 */
public class ReviewRepositoryArrayList implements ReviewRepository {

    private ArrayList<Review> reviews = new ArrayList<Review>();

    public ReviewRepositoryArrayList() {
        reviews.add(new Review("Jos", "MGSV", 8, "Great Game"));
        reviews.add(new Review("Gaetan", "Goat Simulator", 9, "Still a better love story than twilight"));
        reviews.add(new Review("Jacques", "MGSV", 4, "Too Short"));
    }

    public ArrayList<Review> getGameReviews(String gameName) {
        ArrayList<Review> result = new ArrayList<Review>();
        for (Review review : reviews) {
            if (review.getGameName().equals(gameName)) {
                result.add(review);
            }
        }
        return result;
    }

    public void add(Review review) {
        reviews.add(review);
    }

    public void update(Review oldReview, Review newReview) {
        remove(oldReview);
        add(newReview);
    }

    public void remove(Review review) {
        if (review != null) {
            reviews.remove(review);
        } else {
            throw new RepositoryException();
        }
    }
}
