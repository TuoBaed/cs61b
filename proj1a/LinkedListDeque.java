
public class LinkedListDeque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;

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


    public void addFirst(T x) {
        Node newNode = new Node(x);
        newNode.prev = sentinel;
        newNode.next = sentinel.next;

        // 以下2个statement是有先后顺序的
        sentinel.next.prev = newNode;
        sentinel.next = newNode;

        size++;
    }


    public void addLast(T x) {
        Node newNode = new Node(x);
        newNode.prev = sentinel.prev;
        newNode.next = sentinel;

        sentinel.prev.next = newNode;
        sentinel.prev = newNode;

        size++;
    }


    public int size() {
        return size;
    }


    public void printDeque() {
        Node nextNode = sentinel.next;
        while (nextNode != sentinel) {
            System.out.print(nextNode.item + " ");
            nextNode = nextNode.next;
        }
        System.out.println();
    }

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

    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel, size);
    }

    private T getRecursiveHelper(int index, Node start, int s) {
        if (index > s - 1) {
            return null;
        } else if (index == 0) {
            return start.next.item;
        } else {
            return getRecursiveHelper(index - 1, start.next, s - 1);
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}