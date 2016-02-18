package repositories;

import domain.Game;
import domain.ServiceFacade;

import java.util.ArrayList;

/**
 * Created by Tim on 17/02/2016.
 */
public class GameRepositoryArrayList implements GameRepository {
    private ArrayList<Game> games = new ArrayList<Game>();
    private ReviewService service;

    public GameRepositoryArrayList(ServiceFacade facade) {
        games.add(new Game("MGSV", "Stealth", facade));
        games.add(new Game("Goat Simulator", "Simulator", facade));
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void add(Game game) {
        if (game != null) {
            games.add(game);
        }
    }

    public void update(Game prevGame, Game newGame) {
        remove(prevGame);
        add(newGame);
    }

    public void remove(Game game) {
        if (game != null) {
            games.remove(game);
        } else throw new RepositoryException();
    }
}
