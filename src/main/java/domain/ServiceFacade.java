package domain;

import repositories.*;

import java.util.ArrayList;

/**
 * Created by Tim on 17/02/2016.
 */
public class ServiceFacade {
    private ReviewService reviewService;
    private GameService gameService;

    public ServiceFacade(String repositoryType){
        setGameService(repositoryType);
        setReviewService(repositoryType);
    }

    public ReviewService getReviewService() {
        return reviewService;
    }

    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public void setReviewService(String type) {
        this.reviewService = new ReviewService(type);
    }

    public GameService getGameService() {
        return gameService;
    }

    public void setGameService(String type) {
        this.gameService = new GameService(this,type);
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    public ArrayList<Game> getAllGames(){
        return gameService.getAll();
    }

    public ArrayList<Review> getGameReviews(String name){
        return reviewService.getGameReviews(name);
    }

    public void addReview(Review review){
        reviewService.add(review);
    }

    public void addGame(Game game){
        gameService.add(game);
    }

    public void updateReview(Review oldReview,Review newReview){
        reviewService.update(oldReview,newReview);
    }

    public void updateGame(Game oldGame,Game newGame){
        gameService.update(oldGame,newGame);
    }

    public void removeReview(Review review){
        reviewService.remove(review);
    }

    public void removeGame(Game game){
        gameService.remove(game);
    }

}
