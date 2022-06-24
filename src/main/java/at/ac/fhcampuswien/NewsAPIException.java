package at.ac.fhcampuswien;

public class NewsAPIException extends Exception{

    public NewsAPIException(){};

    public NewsAPIException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return "Oops. Something went wrong!";
    }
}
