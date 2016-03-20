package repositories;

import domain.Game;

import java.util.ArrayList;

/**
 * Created by Tim on 17/02/2016.
 */
public interface GameRepository {
    ArrayList<Game> getAllGames();
    Game getGame(int gameID);
    void add(Game game);
    void update(int gameID,String name,String genre);
    void remove(int gameID);
}
