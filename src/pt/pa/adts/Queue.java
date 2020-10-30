package pt.pa.adts;

/**
 * Defines a queue data structure type
 *
 * @param <T> The queue element type
 */
public interface Queue<T> {

    /**
     * Enqueues a new element in the queue
     * @param element The element to enqueue
     * @throws FullQueueException When the queue is full
     */
    void enqueue(T element) throws FullQueueException;

    /**
     * Dequeues the oldest element in the queue (removed and returned)
     * @return The oldest element in the queue
     * @throws EmptyQueueException When the queue is empty
     */
    T dequeue() throws EmptyQueueException;

    /**
     * Returns the element at the top of the queue without removing it
     * @return The oldest element in the queue
     * @throws EmptyQueueException When the queue is empty
     */
    T front() throws EmptyQueueException;

    /**
     * Returns the number of elements in the queue
     * @return The queue size
     */
    int size();

    /**
     * Indicates if the queue is empty or not
     * @return True if empty or false if the queue isn't empty
     */
    boolean isEmpty();

    /**
     * Clears the queue
     */
    void clear();
}
