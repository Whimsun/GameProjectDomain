
import domain.DomainException;
import domain.Game;
import domain.Review;
import org.junit.Assert;
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
public class GameTest {
    
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
    public void test_Game_throws_domainexception_with_name_null(){
        Game game=new Game(null,genre);
    }

    @Test(expected = DomainException.class)
    public void test_Game_throws_domainexception_with_genre_null(){
        Game game=new Game(name,null);
    }


    @Test
    public void test_Game_returns_correct_average_with_given_reviews(){
        game.addReview(new Review("revName1",game,8.0,"Great Classic"));
        game.addReview(new Review("revName2",game,4.0,"Lacks a fancy UI"));
        Assert.assertTrue(game.getAverageScore()==6.0);
    }
    

    @Test(expected = DomainException.class)
    public void test_Game_throws_domainexception_with_name_empty(){
        Game game=new Game("",genre);
    }

    @Test(expected = DomainException.class)
    public void test_Game_throws_domainexception_with_genre_empty(){
        Game game=new Game(name,"");
    }
    
}
