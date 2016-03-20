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
        gameService=new GameService("fake");
        reviewService=new ReviewService("fake");
        game =new Game("Test","TestGenre");
        review=new Review("TestReviewer",game,9.5,"meh");
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
    public void test_addGame_works(){
        facade.addGame(game);
        Game gameToCheck=facade.getGame(game.getGameID());
        Assert.assertEquals(game,gameToCheck);
    }

    @Test
    public void test_addReview_works(){
        facade.addGame(game);
        facade.addReview(review);
        Review reviewToCheck=facade.getReview(review.getReviewID());
        Assert.assertEquals(review,reviewToCheck);
    }

    @Test
    public void test_updateReview_works(){
        facade.addGame(game);
        facade.addReview(review);
        facade.updateReview(review.getReviewID(),"Gr8reviewer",8.8,"trololo");
        Review reviewToCheck=facade.getReview(review.getReviewID());
        Assert.assertTrue(reviewToCheck.getReviewerName().equals("Gr8reviewer"));
        Assert.assertTrue(reviewToCheck.getScore()==8.8);
        Assert.assertTrue(reviewToCheck.getBody().equals("trololo"));
    }
    
    @Test
    public void test_updateGame_works(){
        facade.addGame(game);
        facade.updateGame(game.getGameID(),"goodname","goodgenre");
        Game gameToCheck=facade.getGame(game.getGameID());
        Assert.assertTrue(gameToCheck.getName().equals("goodname"));
        Assert.assertTrue(gameToCheck.getGenre().equals("goodgenre"));
    }

    @Test
    public void test_removeReview_works(){
        facade.addGame(game);
        facade.addReview(review);
        Game gameToCheck=review.getGame();
        facade.removeReview(review.getReviewID());
        Assert.assertFalse(gameToCheck.getReviews().contains(review));
        Assert.assertTrue(facade.getReview(review.getReviewID())==null);
    }

    @Test
    public void test_removeGame_works(){
        facade.addGame(game);
        facade.removeGame(game.getGameID());
        Assert.assertTrue(facade.getGame(game.getGameID())==null);
    }

}
