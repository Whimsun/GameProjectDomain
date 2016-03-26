import domain.ServiceFacade;
import domain.Game;
import domain.Review;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repositories.GameService;
import repositories.ReviewService;

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
        facade = new ServiceFacade("database");
        gameService=new GameService("database");
        reviewService=new ReviewService("database");
        game =new Game("Test","TestGenre");
        review=new Review("TestReviewer",game,9.5,"meh");
    }

    @Test
    public void test_setgameservice_sets_correctly_with_given_gameservice(){
        facade.setGameService(gameService);
        Assert.assertTrue(gameService.equals(facade.getGameService()));
    }

    @Test
    public void test_setreviewservice_sets_correctly_with_given_reviewservice(){
        facade.setReviewService(reviewService);
        Assert.assertTrue(reviewService.equals(facade.getReviewService()));
    }

    @Test
    public void test_addGame_adds_correctly_with_given_game(){
        facade.addGame(game);
        Game gameToCheck=facade.getGame(game.getGameID());
        Assert.assertEquals(game,gameToCheck);
    }

    @Test
    public void test_addReview_adds_correctly_with_given_review(){
        facade.addGame(game);
        facade.addReview(review);
        Review reviewToCheck=facade.getReview(review.getReviewID());
        Assert.assertEquals(review,reviewToCheck);
    }
    
    @Test
    public void test_addReview_adds_review_to_correct_Game(){
        facade.addGame(game);
        facade.addReview(review);
        Assert.assertTrue(game.getReviews().contains(review));
    }

    @Test
    public void test_updateReview_updates_correctly_with_given_review(){
        facade.addGame(game);
        facade.addReview(review);
        facade.updateReview(new Review(review.getReviewID(),"Gr8reviewer",game,8.8,"trololo"));
        Review reviewToCheck=facade.getReview(review.getReviewID());
        Assert.assertTrue(reviewToCheck.getReviewerName().equals("Gr8reviewer"));
        Assert.assertTrue(reviewToCheck.getScore()==8.8);
        Assert.assertTrue(reviewToCheck.getBody().equals("trololo"));
    }
    
    @Test
    public void test_updateGame_updates_correctly_with_given_game(){
        facade.addGame(game);
        facade.updateGame(new Game(game.getGameID(),"goodname","goodgenre"));
        Game gameToCheck=facade.getGame(game.getGameID());
        Assert.assertTrue(gameToCheck.getName().equals("goodname"));
        Assert.assertTrue(gameToCheck.getGenre().equals("goodgenre"));
    }

    @Test
    public void test_removeReview_removes_correct_review_with_given_review_and_removes_review_from_given_game(){
        facade.addGame(game);
        facade.addReview(review);
        Game gameToCheck=review.getGame();
        facade.removeReview(review);
        Assert.assertFalse(gameToCheck.getReviews().contains(review));
        Assert.assertTrue(facade.getReview(review.getReviewID())==null);
    }

    @Test
    public void test_removeGame_removes_correct_game_with_given_game(){
        facade.addGame(game);
        facade.removeGame(game);
        Assert.assertTrue(facade.getGame(game.getGameID())==null);
    }

}
