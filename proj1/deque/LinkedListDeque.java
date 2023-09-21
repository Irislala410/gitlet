package deque;

public class LinkedListDeque<T> {
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
            while (p.next != null){
                p = p.next;
            }
            return p.t;
        }
    }

//    public Iterator<T> iterator(){
//
//    }

//    public boolean equals(Object o){
//
//    }

//    public T getRecursive(int index){
//        if (index > size -1) {
//            return null;
//        } else {
//            IntNode p = sentinel;
//            if (index == 0) {
//                return p.T;
//            } else {
//                p = p.next;
//                return p.getRecursive(index - 1);
//            }
//        }
//    }
}
