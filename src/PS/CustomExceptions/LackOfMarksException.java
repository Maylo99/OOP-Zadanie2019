package PS.CustomExceptions;

public class LackOfMarksException extends Throwable {
    public LackOfMarksException(String s) {
        System.err.println(s);
    }
}
