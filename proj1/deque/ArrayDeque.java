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
            resize(size * 2);
        }
        ts[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = ts.length - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }

    public void addLast(T item){
        if (size == ts.length){
            resize(size * 2);
        }
        ts[nextLast] = item;
        if (nextLast == ts.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }


    public void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        if (nextFirst == ts.length - 1){/*the original array starts from index 0, no matter the length or upsizing or downsizing*/
            System.arraycopy(ts, 0, a, 0, size);
        } else if (size == ts.length){/*this means it is upsizing and the array is full*/
            System.arraycopy(ts, nextFirst + 1, a, 0, ts.length - nextFirst - 1);/*copy the items at the end of the array*/
            System.arraycopy(ts, 0, a, ts.length - nextFirst - 1, size - (ts.length - nextFirst - 1));
        } else if (nextFirst < nextLast){/*this means it is downsizing and the items don't cover the end of array*/
            System.arraycopy(ts, nextFirst + 1, a, 0, size);
        } else {/*this means it is downsizing and the items cover the end of array*/
            System.arraycopy(ts, nextFirst + 1, a, 0, ts.length - nextFirst - 1);/*copy the items at the end of the array*/
            System.arraycopy(ts, 0, a, ts.length - nextFirst - 1, size - (ts.length - nextFirst - 1));
        }
        ts = a;
        nextFirst = ts.length - 1;/*the new array starts from index 0*/
        nextLast = size;
    }

    public boolean isEmpty(){return size == 0;}

    public int size(){return size;}

    public void printDeque(){}

    public T removeFirst(){
        if (size == 0){
            return null;
        } else {
            double ration = (double)(size - 1) / ts.length;
            if (ts.length >= 16 && ration < 0.25){
                resize(ts.length / 2);
            }
            T temp;
            if (nextFirst == ts.length - 1) {
                temp = ts[0];
                ts[0] = null;
                nextFirst = 0;
            } else {
                temp = ts[nextFirst + 1];
                ts[nextFirst + 1] = null;
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
            double ration = (double)(size - 1) / ts.length;
            if (ts.length >= 16 && ration < 0.25){
                resize(ts.length / 2);
            }
            T a;
            if (nextLast == 0) {
                a = ts[ts.length - 1];
                ts[ts.length - 1] = null;
                nextLast = ts.length - 1;
            } else {
                a = ts[nextLast - 1];
                ts[nextLast - 1] = null;
                nextLast -= 1;
            }
            size -= 1;
            return a;
        }

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
