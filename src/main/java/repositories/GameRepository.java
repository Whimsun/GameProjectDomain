package repositories;

import domain.Game;

import java.util.ArrayList;

/**
 * Created by Tim on 17/02/2016.
 */
public interface GameRepository {
    ArrayList<Game> getGameReviews();
    void add(Game game);
    void remove(Game game);
}
