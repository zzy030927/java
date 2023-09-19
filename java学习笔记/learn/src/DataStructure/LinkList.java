package DataStructure;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T>
{
    private Node head;
    private int n;
    private Node last;

    private class Node
    {
        T item;
        Node next;
        public Node(T item,Node next)
        {
            this.item = item;
            this.next = next;
        }
    }
    public LinkList()
    {
        head = new Node(null, null);
        last = new Node(null, null);
        n = 0;
    }
    public void clear()
    {
        head.next = null;
        last = head;
        n = 0;
    }
    public int length()
    {
        return n;
    }
    public boolean isEmpty()
    {
        return head.next == null;
    }
    public T get(int i)
    {
        Node temp = head.next;
        if(i < n)
        {
            for (int index = 0; index < i; index++)
            {
                temp = temp.next;
            }
            return temp.item;
        }
        else return null;
    }
    public void insert(T t)
    {
        Node node = new Node(t, null);
        n++;
        if(n == 1)
            head.next = node;
        last.next = node;
        last = last.next;
    }
    public void insert(int i, T t)
    {
        Node node = new Node(t, null);
        Node curr = head.next;
        for(int index = 0; index < i - 1; index++)
        {
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        n++;
    }
    public void remove(int i)
    {
        Node curr = head.next;
        for (int index = 0; index < i - 1; index++)
        {
            curr = curr.next;
        }
        if(i != n - 1)
        {
            curr.next = curr.next.next;
        }
        else
        {
            curr.next = null;
            last = curr;
        }
        this.n--;
    }
    public int indexOf(T t)
    {
        int find = -1;
        Node curr = head.next;
        for(int i = 0; i < n; i++)
        {
            if(curr.item == t)
            {
                find = i;
                break;
            }
            curr = curr.next;
        }
        return find;
    }

    // ������������д Iterable ����ķ��� iterator
    @Override
    public Iterator<T> iterator()
    // ����ֵ����Ϊ Iterator<T>����Ϊ Iterator��һ���ӿڣ�������Ҫ��д����ķ���
    {
        return new LIterator();
    }

    // ���ڲ���ȥ��д Iterator ����ķ�������Ϊ���������ܱ�������
    private class LIterator implements Iterator
    {
        private Node curr = head;
        @Override
        public boolean hasNext() {
            return curr.next != null;
        }

        @Override
        public Object next() {
            curr = curr.next;
            return curr.item;
        }
    }
}
