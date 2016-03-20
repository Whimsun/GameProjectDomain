package repositories;

import domain.Game;

import java.util.ArrayList;

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
    public ArrayList<Game>getAll(){
        return gameRepository.getAllGames();
    }
    public void update(int gameID,String name,String Genre){
        gameRepository.update(gameID,name,Genre);
    }

    public void remove(int gameID){
        gameRepository.remove(gameID);
    }

    public GameRepository getGameRepository() {
        return gameRepository;
    }

    public void setGameRepository(String repositoryType) {
        this.gameRepository = GameRepositoryFactory.createRepository(repositoryType);

    }
}
