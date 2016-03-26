package repositories;

import domain.Review;

/**
 * Created by Tim on 17/02/2016.
 */
public class ReviewService {
    private ReviewRepository reviewRepository;

    public ReviewService(String repositoryType) {
        reviewRepository = ReviewRepositoryFactory.createRepository(repositoryType);
    }

    public Review getReview(int reviewID) {
        return getReviewRepository().getReview(reviewID);
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

    public void update(Review review) {
        reviewRepository.update(review);
    }

    public void remove(Review review) {
        reviewRepository.remove(review);
    }

    public void removeAllOfGame(int gameID){
        reviewRepository.removeAllOfGame(gameID);
    }
}
