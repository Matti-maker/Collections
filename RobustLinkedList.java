import java.util.NoSuchElementException;

/**
 * A generic singly linked list that also supports working with elements by index.
 *
 * @param <E> the type of elements stored in the list
 */
public class MyRobustLinkedList<E>
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
    public MyRobustLinkedList()
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
     * Adds an element to the end of the list.
     *
     * @param element the value to add
     */
    public void add(E element)
    {
        addTail(element);
    }

    /**
     * Inserts an element at the specified index.
     * The element that was at that index and everything after it move over by one.
     *
     * @param index the position to insert at, from 0 up to and including the size
     * @param element the value to add
     * @throws IndexOutOfBoundsException if the index is less than 0 or greater than the size
     */
    public void add(int index, E element)
    {
        if (index < 0 || index > count)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        if (index == 0)
        {
            addHead(element);
        }
        else if (index == count)
        {
            addTail(element);
        }
        else
        {
            // walk to the node just before the spot we are inserting at
            Node previous = head;
            for (int i = 0; i < index - 1; i++)
            {
                previous = previous.getNextNode();
            }
            Node newNode = new Node(element);
            newNode.nextNode = previous.getNextNode();
            previous.nextNode = newNode;
            count++;
        }
    }

    /**
     * Returns the element at the specified index without removing it.
     *
     * @param index the position to read, from 0 up to but not including the size
     * @return the element at that index
     * @throws IndexOutOfBoundsException if the index is less than 0 or not less than the size
     */
    public E get(int index)
    {
        if (index < 0 || index >= count)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        Node current = head;
        for (int i = 0; i < index; i++)
        {
            current = current.getNextNode();
        }
        return current.getElement();
    }

    /**
     * Replaces the existing element at the specified index.
     *
     * @param index the position to replace, from 0 up to but not including the size
     * @param element the new value
     * @throws IndexOutOfBoundsException if the index is less than 0 or not less than the size
     */
    public void set(int index, E element)
    {
        if (index < 0 || index >= count)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        Node current = head;
        for (int i = 0; i < index; i++)
        {
            current = current.getNextNode();
        }
        current.element = element;
    }

    /**
     * Removes and returns the element at the specified index.
     *
     * @param index the position to remove, from 0 up to but not including the size
     * @return the element that was at that index
     * @throws IndexOutOfBoundsException if the index is less than 0 or not less than the size
     */
    public E remove(int index)
    {
        if (index < 0 || index >= count)
        {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }
        E removed;
        if (index == 0)
        {
            removed = removeHead();
        }
        else
        {
            // walk to the node just before the one we are removing
            Node previous = head;
            for (int i = 0; i < index - 1; i++)
            {
                previous = previous.getNextNode();
            }
            Node target = previous.getNextNode();
            removed = target.getElement();
            previous.nextNode = target.getNextNode();
            if (target == tail)
            {
                tail = previous;
            }
            count--;
        }
        return removed;
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
