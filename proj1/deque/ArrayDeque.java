package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T>{
    private T[] ts;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        ts = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public void addFirst(T item){
        if (size == ts.length){
            upsize(size * 2);
        } else {
            ts[nextFirst] = item;
            if (nextFirst == 0) {
                nextFirst = ts.length - 1;
            } else {
                nextFirst -= 1;
            }
            size += 1;
        }
    }

    public void addLast(T item){
        if (size == ts.length){
            upsize(size * 2);
        } else {
            ts[nextLast] = item;
            if (nextLast == ts.length - 1) {
                nextLast = 0;
            } else {
                nextLast += 1;
            }
            size += 1;
        }
    }

    public void upsize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(ts, 0, a, 0, size);
        ts = a;

    }

    public boolean isEmpty(){return size == 0;}

    public int size(){return size;}

    public void printDeque(){}

    public T removeFirst(){
        if (size == 0){
            return null;
        } else {
            if ((size - 1) / ts.length < 0.25){
                downsize(ts.length / 2);
            }
            T temp;
            if (nextFirst == ts.length - 1) {
                temp = ts[0];
                nextFirst = 0;
            } else {
                temp = ts[nextFirst + 1];
                nextFirst += 1;
            }
            size -= 1;
            return temp;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            if (ts.length >= 16 && (size - 1) / ts.length < 0.25){
                downsize(ts.length / 2);
            }
            T a;
            if (nextLast == 0) {
                a = ts[ts.length - 1];
                nextLast = ts.length - 1;
            } else {
                a = ts[nextLast - 1];
                nextLast -= 1;
            }
            size -= 1;
            return a;
        }

    }

    public void downsize(int capacity){
        T[] a = (T[]) new Object[capacity];
        if (nextFirst > nextLast){ /*the origin array goes across the end*/
            System.arraycopy(ts, nextFirst + 1, a, 0, ts.length - nextFirst - 1); /*copy the items at the end of the array*/
            System.arraycopy(ts, 0, a, ts.length - nextFirst - 1, size - (ts.length - nextFirst - 1)); /*copy the items at the beginning of the array*/
        } else {
            System.arraycopy(ts, nextFirst + 1, a, 0, size);
        }
        ts = a;
        nextFirst = ts.length - 1;
        nextLast = size;
    }

    public T get(int index){return ts[index];}

    public Iterator<T> iterator(){
        return new ADIterator();
    }

    public class ADIterator implements Iterator<T>{
        private int currPos;
        public ADIterator(){
            currPos = nextFirst;
        }

        public boolean hasNext(){
            if (currPos == nextLast - 1 || (nextLast == 0 && currPos == size - 1)){
                return false;
            }
            return true;
        }

        public T next(){
            if (currPos == ts.length - 1) {
                currPos = 0;
            } else {currPos += 1;}
            return ts[currPos];
        }


    }
    public boolean equals(Object o){
        if (o instanceof ArrayDeque o2){
            if (size != o2.size){
                return false;
            } else {
                int n;/* n is the index of this array */
                int m;/* m is the index of array o2 */

                if (nextFirst == ts.length - 1){
                    n = 0;
                } else {n = nextFirst + 1;}

                if (o2.nextFirst == o2.ts.length - 1){
                    m = 0;
                } else {m = o2.nextFirst + 1;}

                for (int i = 0; i < size; i++){
                    if (this.get(n) != o2.get(m)){
                        return false;
                    }
                    if (n == ts.length - 1){
                        n = 0;
                    } else {n += 1;} /*if n reaches the end of the array, it goes back to the index 0*/
                    if (m == o2.ts.length - 1){
                        m = 0;
                    } else {m += 1;}
                }
                return true;
            }
        }
        return false;

    }
}
