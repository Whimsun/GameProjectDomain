package repositories;

/**
 * Created by Tim on 18/02/2016.
 */
public class RepositoryException extends RuntimeException {
    public RepositoryException(){
        super();
    }
    public RepositoryException(String string){
        super(string);
    }
    public RepositoryException(String string,Exception e){
        super(string,e);
    }
}
