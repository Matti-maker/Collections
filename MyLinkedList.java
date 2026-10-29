import java.util.NoSuchElementException;
 
/**
 * A generic singly linked list.
 *
 * @param <E> the type of elements stored in the list
 */
public class MyLinkedList<E>
{
    // first node in the list, null when the list is empty
    private Node head;
    // last node in the list, null when the list is empty
    private Node tail;
    // number of elements in the list
    private int count;
 
    /**
     * Constructs a basic singly linked list.
     */
    public MyLinkedList()
    {
        head = null;
        tail = null;
        count = 0;
    }
 
    /**
     * Adds an element at the beginning of the list.
     *
     * @param element the value to add
     */
    public void addHead(E element)
    {
        Node newNode = new Node(element);
        newNode.nextNode = head;
        if (isEmpty())
        {
            tail = newNode;
        }
        head = newNode;
        count++;
    }
 
    /**
     * Adds an element at the end of the list.
     *
     * @param element the value to add
     */
    public void addTail(E element)
    {
        Node newNode = new Node(element);
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            tail.nextNode = newNode;
        }
        tail = newNode;
        count++;
    }
 
    /**
     * Removes and returns the element at the beginning of the list.
     *
     * @return the element that was at the beginning
     * @throws NoSuchElementException if the list is empty
     */
    public E removeHead()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("List is empty");
        }
        E removed = head.getElement();
        head = head.getNextNode();
        count--;
        if (isEmpty())
        {
            tail = null;
        }
        return removed;
    }
 
    /**
     * Returns the element at the beginning of the list without removing it.
     *
     * @return the element at the beginning
     * @throws NoSuchElementException if the list is empty
     */
    public E getHead()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("List is empty");
        }
        return head.getElement();
    }
 
    /**
     * Indicates whether the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return count == 0;
    }
 
    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size()
    {
        return count;
    }
 
    /**
     * Returns the elements in the list as one string.
     *
     * @return the elements of the list from first to last, separated by commas
     */
    public String toString()
    {
        String result = "";
        Node current = head;
        while (current != null)
        {
            result += current.getElement();
            if (current.getNextNode() != null)
            {
                result += ", ";
            }
            current = current.getNextNode();
        }
        return result;
    }
 
    /**
     * One link in the list. Holds an element and the node after it.
     */
    private class Node
    {
        private E element;
        private Node nextNode;
 
        /**
         * Constructs a node that does not point at another node yet.
         *
         * @param element the value stored in the node
         */
        private Node(E element)
        {
            this.element = element;
            nextNode = null;
        }
 
        /**
         * Returns the element stored in this node.
         *
         * @return the element in this node
         */
        public E getElement()
        {
            return element;
        }
 
        /**
         * Returns the node after this one.
         *
         * @return the next node, or null if this is the last node
         */
        public Node getNextNode()
        {
            return nextNode;
        }
    }
}

