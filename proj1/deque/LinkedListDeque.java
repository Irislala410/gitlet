package deque;

public class LinkedListDeque<Item> {
    private class IntNode {
        public Item item;
        public IntNode prev;
        public IntNode next;

        public IntNode(Item i, IntNode m, IntNode n) {
            item = i;
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
    public LinkedListDeque(Item x){
        sentinel = new IntNode(null, null, null);
        IntNode a = new IntNode(x, sentinel, sentinel);
        sentinel.next = a;
        sentinel.prev = a;
        size = 1;
    }
    public void addFirst(Item x){
        sentinel.next = new IntNode(x, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size +=1;
    }
    public void addLast(Item x){
        sentinel.prev = new IntNode(x, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size +=1;
    }
    public boolean isEmpty(){return size == 0;}
    public int size(){return size;}
    public void printDeque(){
////        int i = size;
//        IntNode temp = sentinel;
//        if (temp.item == null){
//            System.out.println("\n");
//        } else {
//
//            while (temp.next.item != null) {
//                System.out.println(temp.next.item + " " + temp.next.printDeque());
//            }
//        }
        System.out.println(this.toString());
    }
    public Item removeFirst(){
        if (size == 0){
            return null;
        } else {
            IntNode a = sentinel.next;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return a.item;
        }
    }
    public Item removeLast() {
        if (size == 0) {
            return null;
        } else {
            IntNode a = sentinel.prev;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return a.item;
        }
    }
    public Item get(int index) {
        if (index > size - 1) {
            return null;
        } else {
            IntNode p = sentinel;
            while (p.next != null){
                p = p.next;
            }
            return p.item;
        }
    }

//    public Iterator<Item> iterator(){
//
//    }

//    public boolean equals(Object o){
//
//    }

//    public Item getRecursive(int index){
//        if (index > size -1) {
//            return null;
//        } else {
//            IntNode p = sentinel;
//            if (index == 0) {
//                return p.item;
//            } else {
//                p = p.next;
//                return p.getRecursive(index - 1);
//            }
//        }
//    }
}
