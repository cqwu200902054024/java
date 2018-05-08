package net.cqwu.datastructure.interfaces;

/**
 * A queue is a particular kind of abstract data type or collection in
 * which the entities in the collection are kept in order and the principal (or
 * only) operations on the collection are the addition of entities to the rear
 * terminal position and removal of entities from the front terminal position.
 * This makes the queue a First-In-First-Out (FIFO) data structure. In a FIFO
 * data structure, the first element added to the queue will be the first one to
 * be removed.
 */
public interface IQueue<T> {
    /**
     *
     * Add a value to the beginning of the queue.
     * @param value
     * @return
     */
    boolean offer(T value);

    /**
     *Remove a value from the tail of the queue.
     * @return
     */
    T poll();

    /**
     * Get but do not remove tail of the queue.
     * @return
     */
    T peek();

    /**
     * Remove the value from the queue.
     * @param value
     * @return
     */
    boolean remove(T value);

    /**
     * Clear the entire queue.
     */
    void clear();

    /**
     * Does the queue contain the value.
     * @param value
     * @return
     */
    boolean contains(T value);

    int size();

    /**
     * Validate the queue according to the invariants.
     * @return
     */
    boolean validate();
    /**
     * Get this Queue as a Java compatible Queue
     *
     * @return Java compatible Queue
     */
    java.util.Queue<T> toQueue();

    /**
     * Get this Queue as a Java compatible Collection
     *
     * @return Java compatible Collection
     */
    java.util.Collection<T> toCollection();
}
