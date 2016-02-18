package repositories;

import domain.ServiceFacade;

/**
 * Created by Tim on 17/02/2016.
 */
public class GameRepositoryFactory {
    public static GameRepository createRepository(String repositoryType, ServiceFacade facade){
        if(repositoryType.equals("fake")){
            return new GameRepositoryArrayList(facade);
        }
        if(repositoryType.equals("database")) {
            return new GameRepositoryDatabase();
        }
        else throw new IllegalArgumentException();
    }
}
