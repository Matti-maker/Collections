import java.util.NoSuchElementException;

/**
 * A queue backed by a fixed size circular array.
 * Elements come off in first in, first out order.
 *
 * @param <E> the type of elements stored in the queue
 */
public class MyQueue<E>
{
    // the queue wraps around the end of the array, so the front can be any index
    private E[] myQueue;
    // number of elements in the queue
    private int count;
    // index of the front element
    private int frontIdx;

    /**
     * Constructs a queue that can hold 100 elements.
     */
    public MyQueue()
    {
        myQueue = (E[]) new Object[100];
        count = 0;
        frontIdx = 0;
    }

    /**
     * Constructs a queue that can hold maxSize elements.
     *
     * @param maxSize the maximum number of elements the queue can hold
     */
    public MyQueue(int maxSize)
    {
        myQueue = (E[]) new Object[maxSize];
        count = 0;
        frontIdx = 0;
    }

    /**
     * Indicates whether the queue contains any elements.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return count == 0;
    }

    /**
     * Reads the element at the front of the queue without removing it.
     *
     * @return the element at the front
     * @throws NoSuchElementException if the queue is empty
     */
    public E front()
    {
        // the array wraps around, so an empty queue never causes an array error on its own
        if (isEmpty())
        {
            throw new NoSuchElementException("Queue is empty");
        }
        return myQueue[frontIdx];
    }

    /**
     * Returns the number of elements stored in the queue.
     *
     * @return the number of elements in the queue
     */
    public int size()
    {
        return count;
    }

    /**
     * Indicates whether the queue has used up all of its storage.
     *
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull()
    {
        return count == myQueue.length;
    }

    /**
     * Returns the contents of the queue from front to back.
     *
     * @return the elements of the queue separated by spaces, front first
     */
    public String toString()
    {
        String result = "";
        for (int i = 0; i < count; i++)
        {
            result += myQueue[(frontIdx + i) % myQueue.length] + " ";
        }
        return result;
    }

    /**
     * Adds an element to the back of the queue.
     *
     * @param element the value to add
     * @throws IllegalStateException if the queue is full
     */
    public void enqueue(E element)
    {
        // the index wraps around, so a full queue would overwrite the front instead of erroring
        if (isFull())
        {
            throw new IllegalStateException("Queue is full");
        }
        myQueue[(frontIdx + count) % myQueue.length] = element;
        count++;
    }

    /**
     * Removes an element from the front of the queue.
     *
     * @return the element that was at the front
     * @throws NoSuchElementException if the queue is empty
     */
    public E dequeue()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("Queue is empty");
        }
        E removed = myQueue[frontIdx];
        frontIdx = (frontIdx + 1) % myQueue.length;
        count--;
        return removed;
    }
}
