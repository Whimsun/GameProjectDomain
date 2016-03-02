import domain.ServiceFacade;
import domain.Game;
import domain.Review;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repositories.GameService;
import repositories.ReviewService;

import java.util.ArrayList;

/**
 * Created by Tim on 18/02/2016.
 */
public class ServiceFacadeTest {

    private ServiceFacade facade;
    private GameService gameService;
    private ReviewService reviewService;
    private Review review;
    private Game game;

    @Before
    public void initVariables() {
        facade = new ServiceFacade("fake");
        gameService=new GameService(facade,"fake");
        reviewService=new ReviewService("fake");
        review=new Review("TestReviewer","Test",9.5,"meh");
        game =new Game("Test","TestGenre",facade);
    }

    @Test
    public void test_setter_gameservice_works(){
        facade.setGameService(gameService);
        Assert.assertTrue(gameService.equals(facade.getGameService()));
    }

    @Test
    public void test_setter_reviewservice_works(){
        facade.setReviewService(reviewService);
        Assert.assertTrue(reviewService.equals(facade.getReviewService()));
    }

    @Test
    public void test_addReview_works(){
        facade.addReview(review);
        ArrayList<Review> reviews=facade.getGameReviews(review.getGameName());
        Assert.assertTrue(reviews.contains(review));
    }
    
    
    @Test
    public void test_addGame_works(){
        facade.addGame(game);
        ArrayList<Game> games=facade.getAllGames();
        Assert.assertTrue(games.contains(game));
    }

    @Test
    public void test_updateReview_works(){
        Review newreview=new Review("TestReviewer","Test",2.3,"meh");
        facade.updateReview(review,newreview);
        ArrayList<Review> reviews=facade.getGameReviews(review.getGameName());
        Assert.assertTrue(reviews.contains(newreview));
    }
    
    @Test
    public void test_updateGame_works(){
        Game newGame=new Game("Test","TestGenre2",facade);
        facade.updateGame(game,newGame);
        ArrayList<Game> games=facade.getAllGames();
        Assert.assertTrue(games.contains(newGame));
        Assert.assertFalse(games.contains(game));

    }

    @Test
    public void test_removeReview_works(){
        facade.addReview(review);
        ArrayList<Review> reviews=facade.getGameReviews(review.getGameName());
        Assert.assertTrue(reviews.contains(review));
        facade.removeReview(review);
        reviews=facade.getGameReviews(review.getGameName());
        Assert.assertFalse(reviews.contains(review));
    }

    @Test
    public void test_removeGame_works(){
        facade.addGame(game);
        ArrayList<Game> games=facade.getAllGames();
        Assert.assertTrue(games.contains(game));
        facade.removeGame(game);
        games=facade.getAllGames();
        Assert.assertFalse(games.contains(game));
    }

}
