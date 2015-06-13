package ua.artcode.ds.hash;

import java.util.*;

/**
 * Created by serhii on 25.04.15.
 */
public class MyHashMapN<K, V> implements Map<K, V> {

    private double loadFactor = 0.75;
    private int masSize = 10;
    private int size = 0;       // q-ty of non-null buckets
    private MyEntry<K, V>[] mas;
    private int count = 0;


    public MyHashMapN() {
        @SuppressWarnings({"rawtypes","unchecked"})
        MyEntry<K,V>[] newTable = (MyEntry<K,V>[])new MyEntry[masSize];
        this.mas = newTable;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
    @Override
    public boolean containsKey(Object key) {
        MyEntry entry = new MyEntry();
        MyEntry iter;
        entry.key = key;
        int hash = key.hashCode();
        int position = hash % masSize; // find bucket

        if (mas[position] != null) {
            if (mas[position].key.equals(key)) {
                return true;
            }
            iter = mas[position];
            while (iter.next != null){
                if(iter.key.equals(key)){
                    return true;
                }
                iter = iter.next;
            }
        }

        return false;
    }
    @Override
    public boolean containsValue(Object value) { // We don't know the key, so we simple search and check

        MyIterator iterator = new MyIterator();
        while (iterator.hasNext()){
            Entry<K,V> next = iterator.next();
            if(next.getValue().equals(value)){
                return true;
            }

        }

        return false;
    }
    @Override
    public V get(Object key) {
        MyEntry entry = new MyEntry();
        MyEntry iter;
        entry.key = key;
        int hash = key.hashCode();
        int position = hash % masSize;
        if (mas[position] != null) {
            if (mas[position].key.equals(key)) {
                return mas[position].value;
            }
            iter = mas[position];
            while (iter.next != null){
                if(iter.key.equals(key)){
                    return (V)iter.value;
                }
                iter = iter.next;
            }
        }
        return null;
    }
    // resize (run from method put(); !!!!!!!!!!!!!!!!!!!!!!!!!!  TODO resize
    public void resize(){

    }

    // x - 75
    // 10 - 100 x = 10 * 75 / 100
    @Override
    public V put(K key, V value) {
        /*double currLoadFactor = (size + 1) / masSize;
        if (currLoadFactor > loadFactor) {
            resize();
        }*/
        int hash = key.hashCode();
        int position = hash % masSize;
        if(mas[position] == null){
            mas[position] = new MyEntry<K,V>(key,value);
        } else {
            MyEntry<K,V> iter = mas[position];
            while (iter.next != null){
                if(iter.key.equals(key)){
                    V forRet = iter.value;
                    iter.value = value;
                    return forRet;
                }
                iter = iter.next;
            }
            iter.next = new MyEntry<K,V>(key,value);
        }
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        MyEntry entry = new MyEntry();
        MyEntry iter = new MyEntry();
        entry.key = key;
        int hash = key.hashCode();
        int position = hash % masSize;
        if (mas[position] != null) {
            if (mas[position].key.equals(key)) {
                V forRet = (V)mas[position];
                if (mas[position].next == null){
                    mas[position] = null;
                } else {
                    iter = mas[position];
                    while (iter.next != null){
                        if(iter.key.equals(key)){
                            return (V)iter.value;
                        }
                        iter = iter.next;
                    }
                }
                return forRet;
            } else {
                iter = mas[position];
                while (iter.next != null){
                    if(iter.key.equals(key)){
                        return (V)iter.value;
                    }
                    iter = iter.next;
                }
            }
            count--;
        }
        return null;
    }
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }
    @Override
    public void clear() {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = null;
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        Iterator<Entry<K,V>> entryIter = iterator();
        while(entryIter.hasNext()){
            Entry<K,V> entry = entryIter.next();
            set.add(entry.getKey());
        }

        return set;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return null;
    }

    //@Override
    public Iterator iterator() {
        return new MyIterator();
    }


    private class MyIterator implements Iterator<Entry<K, V>> {

        int bucketIndex = 0;
        MyEntry<K,V> current;

        public MyIterator() {
            findFirstBucketWithEntry();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Entry<K, V> next() {
            MyEntry<K,V> iter = current;
            if(iter.next != null){
                current = iter.next;
            } else {
                bucketIndex++;
                findFirstBucketWithEntry();
            }
            return iter;
        }

        private void findFirstBucketWithEntry() {
            while(bucketIndex < mas.length && mas[bucketIndex] == null){
                bucketIndex++;
            }
            current = bucketIndex == mas.length ? null : mas[bucketIndex];
        }
    }

    private static class MyEntry<K, V> implements Entry<K,V> {
        K key;
        V value;
        MyEntry<K, V> next;
        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public MyEntry(){

        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
}
