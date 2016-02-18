package repositories;

import domain.Review;

import java.util.ArrayList;

/**
 * Created by Tim on 17/02/2016.
 */
public class ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewService() {
        reviewRepository = ReviewRepositoryFactory.createRepository("fake");
    }

    public ArrayList<Review> getGameReviews(String gameName) {
        return getReviewRepository().getGameReviews(gameName);
    }

    public ReviewRepository getReviewRepository() {
        return reviewRepository;
    }

    public void setReviewRepository(String repositoryType) {
        this.reviewRepository = ReviewRepositoryFactory.createRepository(repositoryType);
    }

    public void add(Review review) {
        reviewRepository.add(review);
    }

    public void update(Review prevReview, Review newReview) {
        reviewRepository.update(prevReview, newReview);
    }

    public void remove(Review review) {
        reviewRepository.remove(review);
    }
}
