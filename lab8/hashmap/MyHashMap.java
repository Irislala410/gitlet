package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author liangruo
 */
public class MyHashMap<K, V> implements Map61B<K, V> {

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;
    private int N = 0;
    private int M = 16;
    private double loadFactor = 0.75;
    // You should probably define some more!

    /** Constructors */
    public MyHashMap() {
        initializeBuckets(M);
    }

    public MyHashMap(int initialSize) {
        initializeBuckets(initialSize);
        M = initialSize;
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        initializeBuckets(initialSize);
        M = initialSize;
        loadFactor = maxLoad;
    }

    private void initializeBuckets(int initialSize){
        buckets = new Collection[initialSize];
        for (int i = 0; i < initialSize; i ++){
            buckets[i] = createBucket();
        }
    }



    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key, value);
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        return new LinkedList<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        return null;
    }

    // TODO: Implement the methods of the Map61B Interface below
    // Your code won't compile until you do so!
    public void clear(){
        initializeBuckets(M);
        N = 0;
    }
    public boolean containsKey(K key){
        if (N == 0){
            return false;
        }
        for (int i = 0; i < M; i++){
            for (Node n : buckets[i]){//‘for-each’ method of iterator, simpler than 'while'
                if (n.key.equals(key)){
                    return true;
                }
            }
//            Iterator<Node> iterator = buckets[i].iterator();//'while' method of iterator
//            while (iterator.hasNext()){
//                if (iterator.next().key.equals(key)){
//                    return true;
//                }
//            }
        }
        return false;
    }
    public V get(K key) {
        for (int i = 0; i < M; i++) {
            for (Node n : buckets[i]) {
                if (n.key.equals(key)) {
                    return n.value;
                }
            }
        }
        return null;
    }

    public int size(){
        return N;
    }

    public void put(K key, V value){
        int c = key.hashCode();
        int i = Math.floorMod(c, M);
        for (Node n: buckets[i]){
            if (n.key.equals(key)){//replace value
                n.value = value;
                return;
            }
        }
        buckets[i].add(new Node(key, value));
        N ++;
        if ((double) N/M > loadFactor){
            resize();
        }
    }

    private void resize(){
        Collection<Node>[] moreBuckets = new Collection[ M * 2];
        for (int i = 0; i < M * 2; i++){
            moreBuckets[i] = createBucket();
        }
        for (int i = 0; i < M; i++){
            for (Node n : buckets[i]){
                int newi = Math.floorMod(n.key.hashCode(), M * 2);//calculate the new bucket position in new buckets
                moreBuckets[newi].add(n);
            }
        }
        buckets = moreBuckets;
        M = M * 2;

    }
    public Set<K> keySet(){
        Set<K> ks = new HashSet<>();
        for (int i = 0; i < M; i ++) {
            for (Node n : buckets[i]){
                ks.add(n.key);
            }
        }
        return ks;
    }

    public V remove(K key){
        for (int i = 0; i < M; i++) {
            for (Node n : buckets[i]) {
                if (n.key.equals(key)) {
                    V v = n.value;
                    buckets[i].remove(n);
                    return v;
                }
            }
        }
        return null;
    }

    public V remove(K key, V value){
        for (int i = 0; i < M; i++) {
            for (Node n : buckets[i]) {
                if (n.key.equals(key) && n.value == value) {
                    buckets[i].remove(n);
                    return value;
                }
            }
        }
        return null;
    }



}
