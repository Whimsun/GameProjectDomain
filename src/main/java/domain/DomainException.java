package domain;

/**
 * Created by Tim on 18/02/2016.
 */
public class DomainException extends RuntimeException {

    public DomainException(){
        super();
    }
    public DomainException(String string){
        super(string);
    }
}
