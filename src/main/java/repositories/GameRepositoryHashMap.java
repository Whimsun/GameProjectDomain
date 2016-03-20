package repositories;

import domain.Game;
import domain.ServiceFacade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Tim on 17/02/2016.
 */
public class GameRepositoryHashMap implements GameRepository {
    private HashMap<Integer,Game> games = new HashMap<Integer,Game>();
    private ReviewService service;

    public GameRepositoryHashMap() {
        Game defaultGame=new Game("Metal Gear Solid","Stealth");
        games.put(defaultGame.getGameID(),defaultGame);
    }

    public Collection<Game> getAllGames() {
        return games.values();
    }

    public Game getGame(int gameID) {
        return games.get(gameID);
    }

    public void add(Game game) {
        if (game != null) {
            games.put(game.getGameID(),game);
        }else throw new RepositoryException();
    }

    public void update(int gameID, String name, String genre) {
        Game gameToEdit=games.get(gameID);
        gameToEdit.setName(name);
        gameToEdit.setGenre(genre);
    }

    public void remove(int gameID) {
        games.remove(gameID);
    }

}
