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

    @Test
    public void testIteration(){
        ArrayDeque<Integer> a = new ArrayDeque<>();
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(3);

        for (int i : a){
            System.out.println(i);
        }
    }

    @Test
    public void testEquals(){
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        a1.addFirst(1);
        a1.addFirst(2);
        a1.addFirst(3);

        ArrayDeque<Integer> a2 = new ArrayDeque<>();
        a2.addLast(3);
        a2.addLast(2);
        a2.addLast(1);

        assertTrue(a1.equals(a2));
    }

    @Test
    public void upsizing(){
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        for (int i = 0; i <= 20; i++){
            a1.addLast(i);
        }
    }

    @Test
    public void downsizing(){
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        for (int i = 0; i <= 100; i++){
            a1.addLast(i);
        }
        for (int i = 0; i <= 95; i++){
            a1.removeLast();
        }

        assertTrue(a1.size() < 5);
    }

    @Test
    public void anotherdownsizing(){
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        for (int i = 0; i <= 50; i++){
            a1.addLast(i);
        }
        for (int i = 0; i <= 50; i++){
            a1.addFirst(i);
        }

        for (int i = 0; i <= 30; i++){
            a1.removeFirst();
        }


        for (int i = 0; i <= 40; i++){
            a1.removeLast();
        }

    }
}
