package DataStructure;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>
{
    private int len;
    private Node head;
    private Node last;
    class Node
    {
        Node next;
        T item;
        public Node(Node next, T item)
        {
            this.next = next;
            this.item = item;
        }
    }
    public Queue()
    {
        len = 0;
        head = new Node(null, null);
        last = new Node(null, null);
    }
    public int size()
    {
        return len;
    }
    public void enqueue(T item)
    {
        Node node = new Node(null, item);
        len++;
        if(len == 1)
        {
            head.next = node;
            last.next = node;
        }
        else
        {
            last.next = node;
        }
        last = last.next;
    }
    public T dequeue()
    {
        if(head.next != null)
        {
            T item = head.next.item;
            Node curr = head.next;
            head.next = curr.next;
            return item;
        }
        else return null;
    }
    public boolean isEmpty()
    {
        return head.next == null;
    }
    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            private Node curr = head;
            @Override
            public boolean hasNext()
            {
                return curr.next != null;
            }

            @Override
            public T next()
            {
                curr = curr.next;
                return curr.item;
            }
        };
    }

}
