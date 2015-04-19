package ua.artcode.ds;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by se rhii on 19.04.15.
 */
public class MyHashMap<K,V> implements Map<K,V> {

    private Entry[] mas;
    private double loadFactor = 0.75;
    private int masSize = 10;
    private int size = 0;

    public MyHashMap() {
        this.mas = (Entry[]) new Object[masSize];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        int position = hash % masSize;

        if(mas[position] == null){
            mas[position] = new Entry(key,value);
        } else {
            Entry iter = mas[position];
            while (iter.next != null){
                if(iter.key.equals(key)){
                    V forRet = iter.value;
                    iter.value = value;
                    return forRet;
                }
                iter = iter.next;
            }
            iter.next = new Entry(key,value);
        }


        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set entrySet() {
        return null;
    }

    private class Entry {

        K key;
        V value;
        Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }


    }


}
