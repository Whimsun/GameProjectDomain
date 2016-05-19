package repositories;

import domain.Review;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Tim on 17/02/2016.
 */
public class ReviewRepositoryDatabase implements ReviewRepository {
    private EntityManagerFactory factory;
    private EntityManager manager;
    public ReviewRepositoryDatabase(String name) {
        factory=Persistence.createEntityManagerFactory(name);
        manager=factory.createEntityManager();
    }
    
    public void closeConnection(){
        try{
        manager.close();
        factory.close();
        }catch(Exception e){
            throw new RepositoryException(e.getMessage(),e);
        }
    }


    public Review getReview(int reviewID) {
       return manager.find(Review.class, reviewID);
    }

    public void add(Review review) {
       try{
        manager.getTransaction().begin();
        manager.persist(review);
        manager.flush();
        manager.getTransaction().commit();
        }catch(Exception e){
            throw new RepositoryException(e.getMessage(),e);
        }
    }

    public void update(Review review) {
        manager.merge(review);
    }

    public void remove(Review review) {
        manager.remove(review);
    }

    public void removeAllOfGame(int GameID) {
        //do nothing
    }
}
