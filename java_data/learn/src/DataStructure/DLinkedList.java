package DataStructure;

import java.util.Iterator;

public class DLinkedList implements Iterable{

    public Node head;
    public Node last;
    int len;
    public DLinkedList() {
        head = new Node(null, null, 0);
        last = new Node(null, null, 0);
        len = 0;
    }
    private static class Node {
        public Node pre;
        public Node next;
        public int item;
        public Node(Node pre, Node next, int item) {
            this.pre = pre;
            this.next = next;
            this.item = item;
        }
        public Node() {
            this(null, null, 0);
        }
    }
    public void insert(int item) {
        Node node = new Node(null, null, item);
        Node curr = head;
        if (head.next == null) {
            head.next = node;
            len++;
        } else {
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
            len++;
        }
        last = node;
        last.pre = curr;
    }
    public void insert(int local, int item) {
        Node node = new Node(null, null, item);
        if (local < 0) {
            System.err.println("位置错误");
        } else {
            if (local == 0) {
                node.next = head.next;
                head.next = node;
                node.pre = head;
                return;
            }
            Node curr = head.next;
            for (int i = 0; i < local - 1; i++) {
                curr = curr.next;
            }
            curr.next.pre = node;
            node.next = curr.next;
            node.pre = curr;
            curr.next = node;
            len++;
        }
        if (local == len - 1)
            last = node;
    }
    public int getFirst() {
        if (isEmpty()) {
            System.err.println("链表为空");
            return -1;
        }
        return head.next.item;
    }
    public int getLast() {
        if (isEmpty()) {
            System.err.println("链表为空");
            return -1;
        }
        return last.item;
    }
    public int get(int local) {
        Node curr = head.next;
        for (int i = 0; i < local; i++) {
            curr = curr.next;
        }
        return curr.item;
    }
    public int remove(int local) {
        Node curr = head.next;
        int item;
        if (len == 0) {
            System.err.println("链表长度为0");
            return 0;
        } else {
            if (local == 0) {
                item = head.next.item;
                head.next = head.next.next;
                return item;
            } else if (local == len - 1) {
                item = last.item;
                last = last.pre;
                last.next = null;
            }
            else
            {
                for (int i = 0; i < local - 1; i++) {
                    curr = curr.next;
                }
                item = curr.next.item;
                curr.next = curr.next.next;
                curr.next.pre = curr;
            }
            len--;
        }
        return item;
    }
    public int indexOf(int item) {
        Node curr = head.next;
        for (int i = 0; i < len - 1; i++) {
            if (curr.item == item) {
                return i;
            } else
                curr = curr.next;
        }
        System.err.println("没有该元素");
        return -1;
    }
    public boolean isEmpty() {
        return len == 0;
    }
    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node curr = last;
            int c = 0;

            @Override
            public boolean hasNext() {
                return curr.pre != head;
            }

            @Override
            public Object next() {
                if(c != 0)
                    curr = curr.pre;
                c++;
                return curr.item;
            }
        };
    }

    public static void main(String[] args) {
        System.out.println("------单向链表------");
        DLinkedList list = new DLinkedList();
        System.out.println("-------insert()-------");
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(5);
        list.insert(3, 4);
        System.out.println("--------get()---------");
        System.out.println(list.get(3));
        System.out.println("--------remove()--------");
        list.remove(4);
        System.out.println(list.get(3));
        System.out.println("--------indexOf()--------");
        System.out.println(list.indexOf(2));
        System.out.println(list.indexOf(5));
        System.out.println("--------Iterable->iterator()->Iterator----");
        // for each 循环，使用迭代遍历。
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
