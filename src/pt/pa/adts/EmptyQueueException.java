package pt.pa.adts;

public class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super("Empty Queue");
    }
}
