import java.util.NoSuchElementException;

public class MyLinkedList<E>
{
    private Node head;

    private Node tail;

    private int count;

    public MyLinkedList()
    {
        head = null;
        tail = null;
        count = 0;
    }

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

    public E getHead()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("List is empty");
        }
        return head.getElement();
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public int size()
    {
        return count;
    }

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

    private class Node
    {
        private E element;
        private Node nextNode;

        private Node(E element)
        {
            this.element = element;
            nextNode = null;
        }

        public E getElement()
        {
            return element;
        }

        public Node getNextNode()
        {
            return nextNode;
        }
    }
}