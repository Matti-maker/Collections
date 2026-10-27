import java.util.NoSuchElementException;

/**
 * A queue backed by a linked list.
 * Elements come off in first in, first out order.
 *
 * @param <E> the type of elements stored in the queue
 */
public class MyQueueLL<E>
{
    // the front of the queue is the head of the list, the back is the tail
    private MyLinkedList<E> myQueueLL;

    /**
     * Constructs a dynamic queue.
     */
    public MyQueueLL()
    {
        myQueueLL = new MyLinkedList<E>();
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param element the value to add
     */
    public void enqueue(E element)
    {
        myQueueLL.addTail(element);
    }

    /**
     * Removes an element from the front of the queue.
     *
     * @return the element that was at the front
     * @throws NoSuchElementException if the queue is empty
     */
    public E dequeue()
    {
        return myQueueLL.removeHead();
    }

    /**
     * Indicates whether the queue contains any elements.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return myQueueLL.isEmpty();
    }

    /**
     * Reads the element at the front of the queue without removing it.
     *
     * @return the element at the front
     * @throws NoSuchElementException if the queue is empty
     */
    public E front()
    {
        return myQueueLL.getHead();
    }

    /**
     * Returns the number of elements stored in the queue.
     *
     * @return the number of elements in the queue
     */
    public int size()
    {
        return myQueueLL.size();
    }

    /**
     * Returns the contents of the queue from front to back.
     *
     * @return the elements of the queue separated by commas, front first
     */
    public String toString()
    {
        return myQueueLL.toString();
    }
}
