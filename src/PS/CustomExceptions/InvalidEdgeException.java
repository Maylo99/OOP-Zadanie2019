package PS.CustomExceptions;

public class InvalidEdgeException extends Throwable {
    public InvalidEdgeException(String s) {
        System.err.println(s);
    }
}
