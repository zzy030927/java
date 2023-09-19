package DataStructure;

public class Main
{
    public static void main(String[] args)
    {

        System.out.println("--------栈----------");
        System.out.println("-------isEmpty()--------");
        Stack<String> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        System.out.println("---------push()---------");
        stack.push("11111111");
        stack.push("22222222");
        stack.push("33333333");
        System.out.println("--------size()---------");
        System.out.println(stack.size());
        System.out.println("----Iterable->iterator->Iterator----");
        for (String value : stack) {
            System.out.println(value);
        }
        System.out.println("--------pop()---------");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("------队列------");
        System.out.println("-------isEmpty()--------");
        Queue<String> queue = new Queue<String>();
        System.out.println(queue.isEmpty());
        System.out.println("---------enqueue()---------");
        queue.enqueue("11111111");
        queue.enqueue("22222222");
        queue.enqueue("33333333");
        System.out.println("--------size()---------");
        System.out.println(queue.size());
        System.out.println("----Iterable->iterator->Iterator----");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("--------dequeue()---------");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
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
