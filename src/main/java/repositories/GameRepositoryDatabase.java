package repositories;

import domain.Game;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by Tim on 17/02/2016.
 */
public class GameRepositoryDatabase implements GameRepository {

    private EntityManagerFactory factory;

    public GameRepositoryDatabase(String name) {
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

    public Collection<Game> getAllGames() {
        EntityManager manager = getManager();
        try {
            Query query = manager.createQuery("select g from Game g");
            return query.getResultList();
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            manager.close();
        }
    }

    public Game getGame(int gameID) {
        EntityManager manager = getManager();
        try {
            return manager.find(Game.class, gameID);
        } catch (Exception e) {
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            manager.close();
        }
    }

    public void add(Game game) {
        EntityManager manager = getManager();
        try {
            manager.getTransaction().begin();
            manager.persist(game);
            manager.flush();
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new RepositoryException(e.getMessage(), e);
        } finally {
            manager.close();
        }
    }

    public void update(Game game) {
        EntityManager manager = getManager();
        Game gameToEdit = manager.find(Game.class, game.getGameID());
        try {
            manager.getTransaction().begin();
            gameToEdit.setName(game.getName());
            gameToEdit.setGenre(game.getGenre());
            manager.merge(gameToEdit);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }

    public void remove(Game game) {
        EntityManager manager = getManager();
        try {
            manager.getTransaction().begin();
            manager.remove(game);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            manager.close();
        }
    }
}
