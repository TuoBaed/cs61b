
public class LinkedListDeque<T> implements Deque<T>{
    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(T i) {
            prev = null;
            item = i;
            next = null;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        Node newNode = new Node(null);
        sentinel = newNode;
        newNode.next = newNode;
        newNode.prev = newNode;
        size = 0;
    }

    // public boolean isEmpty() { return size == 0; }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x);
        newNode.prev = sentinel;
        newNode.next = sentinel.next;

        // 以下2个statement是有先后顺序的
        sentinel.next.prev = newNode;
        sentinel.next = newNode;

        size++;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x);
        newNode.prev = sentinel.prev;
        newNode.next = sentinel;

        sentinel.prev.next =newNode;
        sentinel.prev = newNode;

        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node nextNode = sentinel.next;
        while (nextNode != sentinel) {
            System.out.print(nextNode.item + " ");
            nextNode = nextNode.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        Node removeNode = sentinel.next;

        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;

        if (sentinel == removeNode) {
            return null;
        }
        size--;
        return removeNode.item;
    }

    @Override
    public T removeLast() {
        Node removeNode = sentinel.prev;

        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;

        if (sentinel == removeNode) {
            return null;
        }
        size--;
        return removeNode.item;
    }

    @Override
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        Node nextNode = sentinel.next;
        int i = 0;
        while (nextNode != sentinel) {
            if (i == index) {
                break;
            }
            i++;
            nextNode = nextNode.next;
        }

        return nextNode.item;
    }
}