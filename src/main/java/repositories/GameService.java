package repositories;

import domain.Game;

import java.util.Collection;

/**
 * Created by Tim on 17/02/2016.
 */
public class GameService {

    private GameRepository gameRepository;

    public GameService(String repositoryType){
        gameRepository = GameRepositoryFactory.createRepository(repositoryType);
    }

    public Game getGame(int gameID){
        return gameRepository.getGame(gameID);
    }

    public void add(Game game){
        gameRepository.add(game);
    }
    public Collection<Game> getAll(){
        return gameRepository.getAllGames();
    }
    public void update(Game game){
        gameRepository.update(game);
    }

    public void remove(Game game){
        gameRepository.remove(game);
    }

    public GameRepository getGameRepository() {
        return gameRepository;
    }

    public void setGameRepository(String repositoryType) {
        this.gameRepository = GameRepositoryFactory.createRepository(repositoryType);

    }
    
    public void destroy(){
        gameRepository.destroy();
    }
}
