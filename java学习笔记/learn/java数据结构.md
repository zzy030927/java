<a name="EZL0T"></a>
## 链栈Stack
:::info
特点：后进先出
:::
<a name="zywSo"></a>
### 定义
```java
public class Stack<T> implements Iterable<T>
{
    private int len;		// 栈长度
    private Node head;		// 栈底
    private Node last;		// 栈顶
    class Node				// 内部类 - Node （节点）
    {
        Node next;			// 下一个节点
        T item;				// 具体的值
        public Node(Node next, T item)
        {
            this.next = next;
            this.item = item;
        }
    }
    public Stack()
    {
        this(0, null, null);
    }
    public Stack(int len, Node head, Node last) {
        this.head = head;
        head = new Node(null, null);
        last = new Node(null, null);
    }
}
```
<a name="Hy3YO"></a>
### 具体函数使用
```java
public int size()				// 栈长度
{
    return len;
}
public void push(T item)		// 在栈顶放入元素
{
    Node node = new Node(null, item);
    len++;
    if(len == 1)			// 判断是否使头节点
    {
        head.next = node;
        last.next = node;
    }
    else
    {
        last.next = node;	// 栈顶元素连接新元素
    }
    last = last.next;		// 栈顶后移
}
public T pop()					// 弹出栈顶元素并返回栈顶元素的值
{
    if(head.next != null)
    {
        Node curr = head;
        T item = last.item;
        while (curr.next != last) {		// 找到连接栈顶元素的那个节点
            curr = curr.next;
        }
        curr.next = null;	// 断开此节点
        last = curr;
        len--;
        return item;		// 返回栈顶元素
    }
    else return null;
}
public boolean isEmpty()
{
    return head.next == null;
}
@Override
public Iterator<T> iterator()	// 遍历栈，继承Iterable接口，并重写iterator()方法
{
    // 返回值类型为 Iterator<T>，因为 Iterator是一个接口，所以需要重写里面的方法
    return new Iterator<T>()	
    {
        private Node curr = head; // 重写遍历方法
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
```
<a name="bmOSK"></a>
## 链队列Queue
:::info
先进先出
:::
<a name="t1y7R"></a>
### 定义
```java
public class Queue<T> implements Iterable<T>
{
    private int len;
    private Node head;		// 队列头
    private Node last;		// 队列尾
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
}
```
<a name="BrKYr"></a>
### 具体函数使用
```java
public int size()		
{
    return len;
}
public void enqueue(T item)					// 在队列尾插入元素
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
public T dequeue()						// 在队列头删除元素
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
public boolean isEmpty()				// 判断队列是否为空
{
    return head.next == null;
}
@Override
public Iterator<T> iterator()			// 遍历队列
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
```
<a name="e4N8s"></a>
## 单向链表LinkList
<a name="ttEYg"></a>
### 定义
```java
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
}
```
<a name="Ks7St"></a>
### 具体函数使用
```java
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

// 遍历方法：重写 Iterable 里面的方法 iterator
@Override
public Iterator<T> iterator()
// 返回值类型为 Iterator<T>，因为 Iterator是一个接口，所以需要重写里面的方法
{
    return new LIterator();
}

// 用内部类去重写 Iterator 里面的方法，因为迭代器不能遍历链表
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
```
<a name="JYYEu"></a>
## 双向链表DuLinkedList
<a name="Qlj2f"></a>
### 定义
```java
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
```
<a name="rDXWA"></a>
### 使用
```java
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
        public Object next() {		// 逆向遍历
            if(c != 0)
                curr = curr.pre;
            c++;
            return curr.item;
        }
    };
}
```
<a name="k4sNI"></a>
## 符号表
<a name="fQi99"></a>
### 定义
```java
public class CSymbolTable<Key, Value> implements Iterable<Value> {
    private final Node head ;
    private int len;
    public CSymbolTable() {
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
}
```
<a name="cOk0X"></a>
### 使用
```java
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
```
<a name="XPX7T"></a>
## 二叉排序树
<a name="m3wJK"></a>
### 定义
```java
public class BiSortTree {
    private Node root;
    public BiSortTree() {
        root = new Node(null, null, -1);
    }
    private static class Node {
        public Node lChild;
        public Node rChild;
        public int item;
        public Node(Node lChild, Node rChild, int item) {
            this.lChild = lChild;
            this.rChild = rChild;
            this.item = item;
        }
    }
}
```
<a name="pdQF0"></a>
### 函数具体使用
```java
public Node findInsert(Node curr, int item) {
    Node find = null;								// find为找到要插入的节点
    if (curr.item > item) {							// 如果当前节点的值大于要插入的值
        if (curr.lChild == null)					// 进入左子树中寻找，如果它的左子树是空的
            return curr;							// 返回当前节点
        else
            find = findInsert(curr.lChild, item);	// 否则传入它的左孩子节点
    } else if(curr.item < item) {
        if (curr.rChild == null)
            return curr;
        else
            find = findInsert(curr.rChild, item);
    }
    return find;
}
public void insert(int item) {
    Node node = new Node(null, null, item);
    if (root.item == -1) {						// 根节点没有存放值
        root.item = node.item;
    } else {
        Node insert = findInsert(root, item);	// 寻找要插入的节点
        if (insert.lChild == null && insert.item > item)
            insert.lChild = node;
        else insert.rChild = node;
    }
}

public void orderPrint(Node node) {				// 中序遍历
    if (node.lChild != null)
        orderPrint(node.lChild);
    System.out.println(node.item);
    if (node.rChild != null)
        orderPrint(node.rChild);
}	
public void popRoot() {							// 删除根节点
        if (root.lChild == null) {
            root = root.rChild;
        }
        if (root.rChild == null) {
            root = root.lChild;
        }
    }

public void pop(int item) {						// 删除任意节点
    Node node = findNode(root, item);			// 找到当前节点所在位置
    Node parent = findParent(root, item);		// 找到当前节点的父亲节点
    if (root.item == item)						// 如果删除的节点是根节点
        popRoot();
    else {
        if (node.rChild == null) {				// 删除节点的左子树为空
            if (node.lChild == null)			// 左子树也为空，那么这个节点就为叶子节点
                if (parent.lChild != null && parent.lChild.item == node.item) {	
                    parent.lChild = null;		// 删除叶子节点
                } else
                    parent.rChild = null;
            else {								// 左子树不为空
                if (parent.lChild != null && parent.lChild.item == node.item) {	// 父节点拼接当前节点的左子树
                    parent.lChild = node.lChild;
                } else
                    parent.rChild = node.lChild;
            }
        }
        if (node.lChild == null) {				// 如果删除节点的左子树为空
            if (node.rChild != null) {			// 右子树不为空
                if (parent.lChild != null && parent.lChild.item == node.item) {
                    parent.lChild = node.rChild;	// 父节点拼接当前节点的右子树
                } else
                    parent.rChild = node.rChild;
            }
        }
    }
    if (node.lChild != null && node.rChild != null) {	// 左右子树都不为空，同样对根节点进行判断
        Node minTag = node.lChild;	// 找到要删除节点中序遍历的前一个节点，即当前节点左孩子节点的最大节点
        Node moveFlag = node;		// 判断要删除节点的左孩子节点有没有右子树，如果有那么它会移动
        while (minTag.rChild != null) {		// 找到左子树下的最大节点
            moveFlag = minTag;				// 移动标记位
            minTag = minTag.rChild;
        }
        node.item = minTag.item;			// 替换要删除节点的值
        if (moveFlag != node) {				// 如果标记为移动过，即要删除节点的左孩子节点有右子树
            moveFlag.rChild = minTag.lChild;	// 那么minTag节点的左子树接到前一个节点的右子树上
        } else
            moveFlag.lChild = minTag.lChild;	// 否则说明要删除节点的左孩子节点没有右子树，那么删除它的左孩子节点
    }
}

private Node findParent(Node curr, int item) {
    Node find = null;
    if (curr.lChild != null)
        if (curr.lChild.item == item)
            return curr;
        else {
            find = findParent(curr.lChild, item);
            if (find != null)
                return find;
        }
    if (curr.rChild != null)
        if (curr.rChild.item == item)
            return curr;
        else {
            find = findParent(curr.rChild, item);
            if (find != null)
                return find;
        }
    return find;
}

private Node findNode(Node curr, int item) {
    Node find = null;
    if (curr.item == item)
        return curr;
    if (curr.lChild != null) {
        find = findNode(curr.lChild, item);
        if (find != null)
            return find;
    }
    if (curr.rChild != null) {
        find = findNode(curr.rChild, item);
        if (find != null)
            return find;
    }
    return find;
}
```
