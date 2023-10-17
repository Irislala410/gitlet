package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T>{
    private class IntNode {
        public T t;
        public IntNode prev;
        public IntNode next;

        public IntNode(T i, IntNode m, IntNode n) {
            t = i;
            prev = m;
            next = n;
        }
    }
    private IntNode sentinel;
    private int size;
    public LinkedListDeque(){
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    public LinkedListDeque(T x){
        sentinel = new IntNode(null, null, null);
        IntNode a = new IntNode(x, sentinel, sentinel);
        sentinel.next = a;
        sentinel.prev = a;
        size = 1;
    }
    public void addFirst(T x){
        sentinel.next = new IntNode(x, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }
    public void addLast(T x){
        sentinel.prev = new IntNode(x, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }
    public boolean isEmpty(){return size == 0;}
    public int size(){return size;}
    public void printDeque(){
////        int i = size;
//        IntNode temp = sentinel;
//        if (temp.T == null){
//            System.out.println("\n");
//        } else {
//
//            while (temp.next.T != null) {
//                System.out.println(temp.next.T + " " + temp.next.printDeque());
//            }
//        }
        System.out.println(this.toString());
    }
    public T removeFirst(){
        if (size == 0){
            return null;
        } else {
            IntNode a = sentinel.next;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return a.t;
        }
    }
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            IntNode a = sentinel.prev;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return a.t;
        }
    }
    public T get(int index) {
        if (index > size - 1) {
            return null;
        } else {
            IntNode p = sentinel;
            int i = 0;
            while (i <= index){
                p = p.next;
                i +=1;
            }
            return p.t;
        }
    }

    public Iterator<T> iterator(){
        return new LLDIterator();
    }

    private class LLDIterator implements Iterator<T>{
        private int currPos;
        public LLDIterator(){
            currPos = 0;
        }
        public boolean hasNext(){
            return currPos < size;
        }

        public T next(){
            T nextvalue = get(currPos);
            currPos += 1;
            return nextvalue;

        }

    }

    public boolean equals(Object o){
        if (o instanceof LinkedListDeque o2){
            if (size != o2.size){
                return false;
            } else {
                for (int i = 0; i < size; i++){
                    if (this.get(i) != o2.get(i)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;

    }

    public T getRecursive(int index){
        if (index > size - 1 || index < 0){
            return null;
        } else {
            return recursionhelper(sentinel, index);
        }
    }

    public T recursionhelper(IntNode s, int index){
        if (index == 0) {
            return s.next.t;
        } else {
            return recursionhelper(s.next, index -1);
        }
    }
}
