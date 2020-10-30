package pt.pa.adts;

/**
 * Doubly linked list implementation of the queue data structure type
 *
 * @param <T> The queue element type
 */
public class QueueLinkedList<T> implements Queue<T> {

    private Node header, trailer;
    private int size;
    private int capacity;

    public QueueLinkedList(int capacity) {
        clear();
        this.capacity = capacity;
    }

    /**
     * Enqueues a new element in the queue
     *
     * @param element The element to enqueue
     * @throws FullQueueException When the queue is full
     */
    public void enqueue(T element) throws FullQueueException {
        if(size() == capacity)
            throw new FullQueueException();
        Node node = new Node(element, header, header.next);
        header.next.prev = node;
        header.next = node;
        size++;
    }

    /**
     * Dequeues the oldest element in the queue (removed and returned)
     *
     * @return The oldest element in the queue
     * @throws EmptyQueueException When the queue is empty
     */
    public T dequeue() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        Node node = trailer.prev;
        node.prev.next = trailer; // node.prev.next = node.next
        trailer.prev = node.prev;
        size--;
        return node.element;
    }

    /**
     * Returns the element at the top of the queue without removing it
     *
     * @return The oldest element in the queue
     * @throws EmptyQueueException When the queue is empty
     */
    public T front() throws EmptyQueueException {
        if(isEmpty())
            throw new EmptyQueueException();
        return trailer.prev.element;
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return The queue size
     */
    public int size() {
        return size;
    }

    /**
     * Indicates if the queue is empty or not
     *
     * @return True if empty or false if the queue isn't empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Clears the queue
     */
    public void clear() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.next = trailer;
        size = 0;
    }

    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public Node(T element, Node prev, Node next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
