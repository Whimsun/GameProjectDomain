package domain;

import repositories.*;
import java.util.Collection;

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
        this.gameService = new GameService(type);
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    public Collection<Game> getAllGames(){
        return gameService.getAll();
    }

    public Game getGame(int gameID){
        return gameService.getGame(gameID);
    }

    public Review getReview(int reviewID){
        return reviewService.getReview(reviewID);
    }

    public void addReview(Review review){
        Game gameToAddReviewTo =gameService.getGame(review.getGame().getGameID());
        gameToAddReviewTo.addReview(review);
        reviewService.add(review);
    }

    public void addGame(Game game){
        gameService.add(game);
    }

    public void updateReview(Review review){
        reviewService.update(review);
    }

    public void updateGame(Game game){
        gameService.update(game);
    }

    public void removeReview(Review review){
        review.getGame().removeReview(review);
        reviewService.remove(review);
    }

    public void removeGame(Game game){
        gameService.remove(game);
        reviewService.removeAllOfGame(game.getGameID());
    }

}
