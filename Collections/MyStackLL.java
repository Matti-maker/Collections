import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * A stack backed by a linked list.
 * Elements come off in last in, first out order.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyStackLL<E>
{
    // the top of the stack is the head of the list
    private MyLinkedList<E> myStackLL;

    /**
     * Constructs a dynamic stack.
     */
    public MyStackLL()
    {
        myStackLL = new MyLinkedList<E>();
    }

    /**
     * Pushes an element on to the top of the stack.
     *
     * @param element the value to push
     */
    public void push(E element)
    {
        myStackLL.addHead(element);
    }

    /**
     * Pops the element off the top of the stack.
     *
     * @return the element that was on top
     * @throws EmptyStackException if the stack is empty
     */
    public E pop()
    {
        try
        {
            return myStackLL.removeHead();
        }
        catch (NoSuchElementException e)
        {
            throw new EmptyStackException();
        }
    }

    /**
     * Indicates whether the stack contains any elements.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return myStackLL.isEmpty();
    }

    /**
     * Reads the element at the top of the stack without removing it.
     *
     * @return the element on top
     * @throws EmptyStackException if the stack is empty
     */
    public E top()
    {
        try
        {
            return myStackLL.getHead();
        }
        catch (NoSuchElementException e)
        {
            throw new EmptyStackException();
        }
    }

    /**
     * Returns the number of elements stored in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size()
    {
        return myStackLL.size();
    }

    /**
     * Returns the contents of the stack from top to bottom.
     *
     * @return the elements of the stack separated by commas, top first
     */
    public String toString()
    {
        return myStackLL.toString();
    }
}