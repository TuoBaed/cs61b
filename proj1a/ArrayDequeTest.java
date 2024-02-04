
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Performs some basic array list tests.
 */
public class ArrayDequeTest {

    @Test
    /** Adds a few things to the array list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", ad1.isEmpty());
        ad1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, ad1.size());
        assertFalse("lld1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals(2, ad1.size());

        ad1.addLast("back");
        assertEquals(3, ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        // System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        // System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test
    /* Tests removing from an empty deque */
    public void printDequeTest() {

        // System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> ad1 = new ArrayDeque<>();
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addFirst("f");
        ad1.addLast("g");
        ad1.addLast("h");

        ad1.printDeque();

        ArrayDeque<String> ad2 = new ArrayDeque<>();
        ad2.addLast("a");
        ad2.addLast("b");
        ad2.addLast("c");
        ad2.addLast("d");
        ad2.addLast("e");
        ad2.addLast("f");
        ad2.addLast("g");
        ad2.addLast("h");

        ad2.printDeque();

        ArrayDeque<String> ad3 = new ArrayDeque<>();
        ad3.addFirst("a");
        ad3.addFirst("b");
        ad3.addFirst("c");
        ad3.addFirst("d");
        ad3.addFirst("e");
        ad3.addFirst("f");
        ad3.addFirst("g");
        ad3.addFirst("h");
        ad3.addFirst("1");
        ad3.addFirst("2");
        ad3.addFirst("3");
        ad3.addFirst("4");
        ad3.addFirst("5");
        ad3.addFirst("6");
        ad3.addFirst("7");
        ad3.addFirst("8");
        ad3.addFirst("9");

        ad3.printDeque();
    }

    @Test
    /* Tests removing from an empty deque */
    public void getitemTest() {

        // System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> ad1 = new ArrayDeque<>();
        ad1.addFirst("a");
        ad1.addFirst("b");
        ad1.addFirst("c");
        ad1.addFirst("d");
        ad1.addFirst("e");
        ad1.addFirst("f");
        ad1.addFirst("g");
        ad1.addFirst("h");

        for (int i = 0; i < ad1.size(); i++) {
            assertEquals(ad1.get(i), "" + (char) ('h' - i));
        }
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        // System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        assertEquals("Should return null when removeFirst is called on an empty Deque,",
                null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,",
                null, lld1.removeLast());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeTest() {

        // System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> ad1 = new ArrayDeque<>();
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addFirst("f");
        ad1.addLast("g");
        ad1.addLast("h");

        ad1.printDeque();
        String removedFront = ad1.removeFirst();
        assertEquals(removedFront, "f");
        String removedEnd = ad1.removeLast();
        assertEquals(removedEnd, "h");
        ad1.printDeque();

    }

    @Test
    public void resizeTest() {
        ArrayDeque<String> ad3 = new ArrayDeque<>();
        ad3.addFirst("a");
        ad3.addFirst("b");
        ad3.addFirst("c");
        ad3.addFirst("d");
        ad3.addFirst("e");
        ad3.addFirst("f");
        ad3.addFirst("g");
        ad3.addFirst("h");
        ad3.addFirst("1");
        ad3.addFirst("2");
        ad3.addFirst("3");
        ad3.addFirst("4");
        ad3.addFirst("5");
        ad3.addFirst("6");
        ad3.addFirst("7");
        ad3.addFirst("8");
        ad3.addFirst("9");

        String removedEnd = ad3.removeLast();
        assertEquals(removedEnd, "a");
        removedEnd = ad3.removeLast();
        assertEquals(removedEnd, "b");
        removedEnd = ad3.removeLast();
        assertEquals(removedEnd, "c");
        removedEnd = ad3.removeLast();
        assertEquals(removedEnd, "d");
        removedEnd = ad3.removeLast();
        assertEquals(removedEnd, "e");
        removedEnd = ad3.removeLast();
        assertEquals(removedEnd, "f");
        removedEnd = ad3.removeLast();
        assertEquals(removedEnd, "g");
        removedEnd = ad3.removeLast();
        assertEquals(removedEnd, "h");
        removedEnd = ad3.removeLast();
        assertEquals(removedEnd, "1");
        ad3.printDeque();
        removedEnd = ad3.removeLast();
        assertEquals(removedEnd, "2");
    }
}
