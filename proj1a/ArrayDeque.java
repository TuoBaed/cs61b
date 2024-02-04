
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        // addFirst 下一个添加位置在 3
        // addLast 下一个添加位置在 4
        nextLast = items.length / 2;
        nextFirst = nextLast - 1;
        size = 0;
    }

    public boolean isEmpty() { return size == 0; }

    public void resize(int newLength) {
        T[] newItems = (T[]) new Object[newLength];

        int start = (nextFirst + 1) % items.length;
        int count = 0;
        while (count != size) {
            newItems[count] = items[start];
            count++;
            start = (start + 1) % items.length;
        }
        items = newItems;
        nextFirst = newItems.length - 1;
        nextLast = count % newItems.length;
    }


    public void addFirst(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = x;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }


    public void addLast(T x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = x;
        nextLast = (nextLast + 1) % items.length;
        size++;
    }


    public int size() {
        return size;
    }


    public void printDeque() {
        int count = size;
        int next = (nextFirst + 1) % items.length;

        while (count != 0) {
            System.out.print(items[next] + " ");
            count--;
            next = (next + 1) % items.length;
        }
        System.out.println();
    }


    public T get(int index) {
        int start = (nextFirst + 1) % items.length;
        int count = 0;
        while (count < size) {
            if (count == index) {
                return items[start];
            }
            count++;
            start = (start + 1) % items.length;
        }
        return null;
    }


    public T removeFirst() {
        if (size < items.length / 4 && items.length >= 16) {
            resize(items.length / 4);
        }

        if (size < 1) {
            return null;
        }
        nextFirst = (nextFirst + 1) % items.length;
        T removeItem = items[nextFirst];
        size--;
        return removeItem;
    }


    public T removeLast() {
        if (size <= items.length / 4 && items.length >= 16) {
            resize(items.length / 4);
        }

        if (size < 1) {
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        T removeItem = items[nextLast];
        size--;
        return removeItem;
    }
}