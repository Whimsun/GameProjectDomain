package repositories;

/**
 * Created by Tim on 17/02/2016.
 */
public class GameRepositoryFactory {
    public static GameRepository createRepository(String repositoryType){
        if(repositoryType.equals("fake")){
            return new GameRepositoryHashMap();
        }
        if(repositoryType.equals("database")) {
            return new GameRepositoryDatabase("GameProjectPU");
        }
        else throw new IllegalArgumentException();
    }
}
