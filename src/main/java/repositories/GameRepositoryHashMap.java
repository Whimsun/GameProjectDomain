package repositories;

import domain.Game;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Tim on 17/02/2016.
 */
public class GameRepositoryHashMap implements GameRepository {
    static AtomicInteger nextGameID = new AtomicInteger();
    private Map<Integer,Game> games = new HashMap<Integer,Game>();

    public GameRepositoryHashMap() {
        Game defaultGame=new Game("Metal Gear Solid","Stealth");
        int Id=nextGameID.incrementAndGet();
        defaultGame.setGameID(Id);
        games.put(Id,defaultGame);
    }

    public Collection<Game> getAllGames() {
        return games.values();
    }

    public Game getGame(int gameID) {
        return games.get(gameID);
    }

    public void add(Game game) {
        if (game != null) {
            int Id=nextGameID.incrementAndGet();
            game.setGameID(Id);
            games.put(Id,game);
        }else throw new RepositoryException("Failed to add game");
    }

    public void update(Game game) {
        int id=game.getGameID();
        games.replace(id, game);
    }

    public void remove(Game game) {
        games.remove(game.getGameID());
    }

}
