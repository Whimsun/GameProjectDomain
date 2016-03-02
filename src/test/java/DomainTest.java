import domain.DomainException;
import domain.Game;
import domain.Review;
import domain.ServiceFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repositories.GameService;
import repositories.ReviewService;

/**
 * Created by Tim on 20/02/2016.
 */
public class DomainTest {
    private ServiceFacade facade;
    private GameService gameService;
    private ReviewService reviewService;
    private String name;
    private String genre;
    private Game game;

    @Before
    public void initVariables() {
        facade = new ServiceFacade("fake");
        name="Junit";
        genre="Java";
        game=new Game(name,genre,facade);
    }

    @Test(expected = DomainException.class)
    public void test_Game_throws_domainexception_with_name_null(){
        Game game=new Game(null,genre,facade);
    }

    @Test(expected = DomainException.class)
    public void test_Game_throws_domainexception_with_genre_null(){
        Game game=new Game(name,null,facade);
    }

    @Test(expected = DomainException.class)
    public void test_Game_throws_domainexception_with_facade_null(){
        Game game=new Game(name,genre,null);
    }

    @Test
    public void test_Game_returns_correct_average(){
        facade.addReview(new Review("revName1","Junit",8.0,"Great Classic"));
        facade.addReview(new Review("revName2","Junit",4.0,"Lacks a fancy UI"));
        facade.addGame(game);
        Assert.assertTrue(game.getAverageScore()==6.0);
    }

    @Test(expected = DomainException.class)
    public void test_Review_throws_domainexception_with_reviewername_null(){
        Review review=new Review(null,name,5.0,"Alright");
    }

    @Test(expected = DomainException.class)
    public void test_Review_throws_domainexception_with_gamename_null(){
        Review review=new Review("John",null,5.0,"Alright");
    }

    @Test(expected = DomainException.class)
    public void test_Review_throws_domainexception_with_negative_score(){
        Review review=new Review("James",name,-6.5,"Alright");
    }

    @Test(expected = DomainException.class)
    public void test_Review_throws_domainexception_with_body_null(){
        Review review=new Review("Jack",name,5.0,null);
    }

}
