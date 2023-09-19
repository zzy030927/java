package DataStructure;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>
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
    public Stack()
    {
        len = 0;
        head = new Node(null, null);
        last = new Node(null, null);
    }
    public int size()
    {
        return len;
    }
    public void push(T item)
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
    public T pop()
    {
        if(head.next != null)
        {
            Node curr = head;
            T item = last.item;
            while (curr.next != last) {
                curr = curr.next;
            }
            curr.next = null;
            last = curr;
            len--;
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
