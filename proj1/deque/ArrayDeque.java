package deque;

public class ArrayDeque<T> {
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
        ts[nextFirst] = item;
        if (nextFirst == 0){
            nextFirst = ts.length - 1;
        } else {
            nextFirst -= 1;
        }
        size +=1;
    }

    public void addLast(T item){
        ts[nextLast] = item;
        if (nextLast == ts.length - 1){
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }

    public boolean isEmpty(){return size == 0;}

    public int size(){return size;}

    public void printDeque(){}

    public T removeFirst(){
        if (size == 0){
            return null;
        } else {
            T temp;
            if (nextFirst == ts.length - 1) {
                temp = ts[0];
                nextFirst = 0;
            } else {
                temp = ts[nextFirst];
                nextFirst += 1;
            }
            size -= 1;
            return temp;
//            size -= 1;
//            return temp;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T a;
            if (nextLast == 0) {
                a = ts[nextLast];
                nextLast = ts.length - 1;
            } else {
                a = ts[nextLast];
                nextLast -= 1;
            }
            size -= 1;
            return a;
        }

    }

    public T get(int index){return ts[index];}

//    public Iterator<T> iterator(){}
//    public boolean equals(Object o){}
}
