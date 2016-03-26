
import domain.DomainException;
import domain.Game;
import domain.Review;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tim
 */
public class ReviewTest {
    
    private String name;
    private String genre;
    private Game game;

    @Before
    public void initVariables() {
        name="Junit";
        genre="Java";
        game=new Game(name,genre);
    }

    

    @Test(expected = DomainException.class)
    public void test_Review_throws_domainexception_with_reviewername_null(){
        Review review=new Review(null,game,5.0,"Alright");
    }

    @Test(expected = DomainException.class)
    public void test_Review_throws_domainexception_with_reviewername_empty(){
        Review review=new Review("",game,5.0,"Alright");
    }

    @Test(expected = DomainException.class)
    public void test_Review_throws_domainexception_with_game_null(){
        Review review=new Review("John",null,5.0,"Alright");
    }

    @Test(expected = DomainException.class)
    public void test_Review_throws_domainexception_with_negative_score(){
        Review review=new Review("James",game,-6.5,"Alright");
    }

    @Test(expected = DomainException.class)
    public void test_Review_throws_domainexception_with_body_null(){
        Review review=new Review("Jack",game,5.0,null);
    }

    @Test(expected = DomainException.class)
    public void test_Review_throws_domainexception_with_body_empty(){
        Review review=new Review("Jack",game,5.0,"");
    }

    
}
