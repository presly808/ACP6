package ua.artcode.ds.hash;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by se rhii on 19.04.15.
 */
public class MyHashMap<K,V> implements Map<K,V> {

    private MyEntry<K,V>[] mas;
    private double loadFactor = 0.75;
    private int masSize = 10;
    private int size = 0;

    public MyHashMap() {
        this.mas =  new MyEntry[masSize];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size < 1;
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
        int position = hash < 0 ? (hash * -1) % masSize : hash % masSize;

        if(mas[position] == null){
            mas[position] = new MyEntry<K,V>(key,value);
        } else {
            MyEntry<K,V> iter = mas[position];
            while (iter.next != null){
                if(iter.key.equals(key)){
                    V forRet = iter.getValue();
                    iter.value = value;
                    size++;
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

    private static class MyEntry<K,V> implements Entry<K,V> {

        K key;
        V value;
        MyEntry<K,V> next;

        public MyEntry() {
        }

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
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
            return null;
        }
    }


}
