import java.util.EmptyStackException;

/**
 * A stack backed by a fixed size array.
 * Elements come off in last in, first out order.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyStack<E>
{
    // bottom of the stack is index 0, top is index count - 1
    private E[] myStack;
    // number of elements in the stack, also the next open slot
    private int count;

    /**
     * Constructs a stack that can hold 100 elements.
     */
    public MyStack()
    {
        myStack = (E[]) new Object[100];
        count = 0;
    }

    /**
     * Constructs a stack that can hold maxSize elements.
     *
     * @param maxSize the maximum number of elements the stack can hold
     */
    public MyStack(int maxSize)
    {
        myStack = (E[]) new Object[maxSize];
        count = 0;
    }

    /**
     * Pushes an element on to the top of the stack.
     *
     * @param element the value to push
     * @throws IllegalStateException if the stack is full
     */
    public void push(E element)
    {
        try
        {
            // writing past the end of the array means the stack is full
            myStack[count] = element;
            count++;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new IllegalStateException("Stack is full");
        }
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
            // reading index -1 means the stack is empty
            E removed = myStack[count - 1];
            count--;
            return removed;
        }
        catch (ArrayIndexOutOfBoundsException e)
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
        return count == 0;
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
            return myStack[count - 1];
        }
        catch (ArrayIndexOutOfBoundsException e)
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
        return count;
    }

    /**
     * Indicates whether the stack has used up all of its storage.
     *
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull()
    {
        return count == myStack.length;
    }

    /**
     * Returns the contents of the stack from top to bottom.
     *
     * @return the elements of the stack separated by spaces, top first
     */
    public String toString()
    {
        String result = "";
        for (int i = count - 1; i >= 0; i--)
        {
            result += myStack[i] + " ";
        }
        return result;
    }
}