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

    public ReviewRepositoryDatabase(String name) {
        factory = Persistence.createEntityManagerFactory(name);

    }

    public void closeConnection() {
        try {
            factory.close();
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    public EntityManager getManager() {
        return factory.createEntityManager();
    }

    public Review getReview(int reviewID) {
        EntityManager manager = getManager();
        try {
            return manager.find(Review.class, reviewID);
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            manager.close();
        }

    }

    public void add(Review review) {
        EntityManager manager = getManager();
        try {
            manager.getTransaction().begin();
            manager.persist(review);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            manager.close();
        }
    }

    public void update(Review review) {
        EntityManager manager = getManager();
        try {
            manager.merge(review);
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            manager.close();
        }
    }

    public void remove(Review review) {
        EntityManager manager = getManager();
        try {
            manager.remove(review);
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            manager.close();
        }
    }

    public void removeAllOfGame(int gameID) {
        //not used
    }

}
