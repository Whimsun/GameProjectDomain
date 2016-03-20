package repositories;

import domain.Review;

import java.util.ArrayList;

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

    public void update(int reviewID, String reviewerName, double score, String body) {
        reviewRepository.update(reviewID,reviewerName,score,body);
    }

    public void remove(int reviewID) {
        reviewRepository.remove(reviewID);
    }

    public void removeAllOfGame(int gameID){
        reviewRepository.removeAllOfGame(gameID);
    }
}
