package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K, V>{
    private class BSTNode{
        private K key;
        private V value;
        private BSTNode left;
        private BSTNode right;

        public BSTNode(K k, V v){
            key = k;
            value = v;
            left = null;
            right = null;
        }
    }

    private int size;
    private BSTNode virtualroot;
    public BSTMap(){
        virtualroot = new BSTNode(null, null);
        size = 0;
    }
    /** Removes all of the mappings from this map. */
    public void clear(){
        virtualroot.left = null;
        virtualroot.right = null;
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key) {
        if (size == 0) {
            return false;
        } else {
            return containsKeyHelper(virtualroot.left, key);
        }
    }

    private boolean containsKeyHelper(BSTNode node, K key) {
        if (node == null) {
            return false;
        }
        int comp = node.key.compareTo(key);
        if (comp == 0) {
            return true;
        } else if (comp > 0) {
            return containsKeyHelper(node.left, key);
        } else {
            return containsKeyHelper(node.right, key);
        }
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key){
        if (size == 0){
            return null;
        } else {
            return getHelper(virtualroot.left, key);
        }
    }

    private V getHelper(BSTNode node, K key){
        if (node == null) {
            return null;
        }
        int comp = node.key.compareTo(key);
        if (comp == 0) {
            return node.value;
        } else if (comp > 0) {
            return getHelper(node.left, key);
        } else {
            return getHelper(node.right, key);
        }

    }

    /* Returns the number of key-value mappings in this map. */
    public int size(){
        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    public void put(K key, V value){
        BSTNode newNode = new BSTNode(key, value);
        if (size == 0){
            virtualroot.left = newNode;
            size += 1;
        } else {
            putHelper(virtualroot.left, newNode);
        }
    }
    private void putHelper(BSTNode node, BSTNode newNode){
        int comp = node.key.compareTo(newNode.key);
        if (comp == 0){
            node.value = newNode.value;//replace value, the size of BSTMap doesn't change.
        } else if (comp > 0 ) {
            if (node.left == null){
                node.left = newNode;//newNode is node's left leaf
                size += 1;
            } else {
                putHelper(node.left, newNode);
            }
        } else{//comp < 0
            if (node.right == null){
                node.right = newNode;
                size += 1;
            } else{
                putHelper(node.right, newNode);
            }
        }

    }


    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    public Set<K> keySet(){
        throw new UnsupportedOperationException();
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public V remove(K key){
        throw new UnsupportedOperationException();
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public V remove(K key, V value){
        throw new UnsupportedOperationException();
    }
    public K printInOrder(){
        if (virtualroot.left == null){
            return null;
        } else{
            return printHelper(virtualroot.left);
        }
    }

    private K printHelper(BSTNode node){
        if (node == null){
            return null;
        } else{
            printHelper(node.left);
            System.out.println(node.key);
            printHelper(node.right);
        }

    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
