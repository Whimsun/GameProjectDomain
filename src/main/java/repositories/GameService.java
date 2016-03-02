package repositories;

import domain.Game;
import domain.ServiceFacade;

import java.util.ArrayList;

/**
 * Created by Tim on 17/02/2016.
 */
public class GameService {

    private GameRepository gameRepository;
    private ServiceFacade facade;

    public GameService(ServiceFacade facade,String repositoryType){
        gameRepository = GameRepositoryFactory.createRepository(repositoryType,facade);
        this.facade=facade;
    }

    public void add(Game game){
        gameRepository.add(game);
    }
    public ArrayList<Game>getAll(){
        return gameRepository.getGames();
    }
    public void update(Game prevGame,Game newGame){
        gameRepository.update(prevGame,newGame);
    }

    public void remove(Game game){
        gameRepository.remove(game);
    }

    public GameRepository getGameRepository() {
        return gameRepository;
    }

    public void setGameRepository(String repositoryType) {
        this.gameRepository = GameRepositoryFactory.createRepository(repositoryType,facade);

    }
}
