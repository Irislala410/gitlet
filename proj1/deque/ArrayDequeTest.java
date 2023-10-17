package deque;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addGetTest(){
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(0);
        a.addFirst(1);
        a.addFirst(2);
        a.addLast(3);
        assertTrue(a.get(6) == 2);
        assertTrue(a.get(7) == 1);
        assertTrue(a.get(0) == 0);
        assertTrue(a.get(1) == 3);
    }

    @Test
    public void addRemoveTest(){
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(0);
        a.addFirst(1);
        a.addFirst(2);
        a.addLast(3);
        assertTrue(a.removeFirst() == 2);
        assertTrue(a.removeFirst() == 1);
        assertTrue(a.removeLast() == 3);
        assertTrue(a.removeLast() == 0);
    }
}
