package DataStructure;

import java.util.Iterator;

public class SymbolTable<Key, Value> implements Iterable<Value> {
    private final Node head ;
    private int len;
    public SymbolTable() {
        head = new Node(null, null, null);
        len = 0;
    }
    class Node {
        public Node next;
        Key key;
        Value value;
        public Node(Node next, Key key, Value value) {
            this.key = key;
            this.next = next;
            this.value = value;
        }
    }
    public int size() {
        return len;
    }
    public boolean isEmpty() {
        return len == 0;
    }
    public void push(Key key, Value value) {
        Node node = new Node(null, key, value);
        if (len == 0) {
            head.next = node;
        } else {
            Node curr = head.next;
            while (curr.next != null) {
                if (curr.key == key) {
                    curr.value = value;
                    return;
                }
                curr = curr.next;
            }
            curr.next = node;
        }
        len++;
    }
    public Value out() {
        Node curr = head.next;
        if (head.next == null) {
            System.err.println("无元素");
            return null;
        } else {
            while (curr.next.next != null) {
                curr = curr.next;
            }
            Value value = curr.next.value;
            curr.next = null;
            len--;
            return value;
        }
    }
    public Value out(Key key) {
        Node curr = head.next;
        while (curr != null && curr.next.key != key) {
            curr = curr.next;
        }
        if (curr != null) {
            Value value = curr.next.value;
            curr.next = curr.next.next;
            len--;
            return value;
        }
        return null;
    }
    public Value getValue(Key key) {
        Node curr = head.next;
        while (curr != null) {
            if (curr.key == key)
                break;
            curr = curr.next;
        }
        return curr != null ? curr.value : null;
    }
    @Override
    public Iterator<Value> iterator() {
        return new Iterator<>() {
            Node curr = head;

            @Override
            public boolean hasNext() {
                return curr.next != null;
            }

            @Override
            public Value next() {
                curr = curr.next;
                return curr.value;
            }
        };
    }

    public static void main(String[] args) {
        System.out.println("-------符号表--------");
        SymbolTable<Integer, String> st = new SymbolTable<>();
        System.out.println("--------isEmpty()---------");
        System.out.println(st.isEmpty());
        System.out.println("--------put()-------");
        st.push(1, "eeee");
        st.push(2, "bbbb");
        st.push(3, "cccc");
        st.push(4, "dddd");
        st.push(1, "aaaa");  // 覆盖
        System.out.println("---------size()---------");
        System.out.println(st.size());
        System.out.println("---------getValue()----------");
        System.out.println(st.getValue(3));
        System.out.println(st.getValue(5));
        System.out.println("-------out()与out(Key key)--------");
        System.out.println(st.out(4));
        System.out.println(st.out());
        System.out.println(st.size());
        System.out.println("-------遍历--------");
        for (String s : st) {
            System.out.println(s);
        }
    }
}
