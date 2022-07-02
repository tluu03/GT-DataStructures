public class InvalidBirdException extends RuntimeException{
    public InvalidBirdException(){
        throw new InvalidBirdException("Your bird is invalid!");
    }
    public InvalidBirdException(String s){
        super(s);
    }
}
