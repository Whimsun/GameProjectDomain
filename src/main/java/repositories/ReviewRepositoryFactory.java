package repositories;

/**
 * Created by Tim on 17/02/2016.
 */
public class ReviewRepositoryFactory {
    public static ReviewRepository createRepository(String repositoryType){
        if(repositoryType.equals("fake")){
            return new ReviewRepositoryHashMap();
        }
        if(repositoryType.equals("database")) {
            return new ReviewRepositoryDatabase();
        }
        else throw new IllegalArgumentException();
    }
}
