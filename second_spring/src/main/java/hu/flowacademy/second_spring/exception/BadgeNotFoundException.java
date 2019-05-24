package hu.flowacademy.second_spring.exception;

public class BadgeNotFoundException extends RuntimeException {

    public BadgeNotFoundException(String id){
        super("Could not find badge " + id);
    }
    
}
