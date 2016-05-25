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
public class GameRepositoryDatabase implements GameRepository{
    private EntityManagerFactory factory;
    private EntityManager manager;
    public GameRepositoryDatabase(String name){
        factory=Persistence.createEntityManagerFactory(name);
        manager=factory.createEntityManager();
    }
    
    public void destroy(){
        try{
        manager.close();
        factory.close();
        }catch(Exception e){
            throw new RepositoryException(e.getMessage(),e);
        }
    }

    public Collection<Game> getAllGames() {
        try{
        Query query=manager.createQuery("select g from Game g");
        return query.getResultList();
        }catch(Exception e){
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    public Game getGame(int gameID) {
        try{
            return manager.find(Game.class, gameID);
        }catch(Exception e){
            throw new RepositoryException(e.getMessage(), e);
        }
    }

    public void add(Game game) {
        try{
        manager.getTransaction().begin();
        manager.persist(game);
        manager.flush();
        manager.getTransaction().commit();
        }catch(Exception e){
            manager.getTransaction().rollback();
            throw new RepositoryException(e.getMessage(),e);
        }
    }

    public void update(Game game) {
        manager.getTransaction().begin();
        manager.merge(game);
        manager.getTransaction().commit();
    }

    public void remove(Game game) {
        manager.getTransaction().begin();
        manager.remove(game);
        manager.getTransaction().commit();
    }

}
