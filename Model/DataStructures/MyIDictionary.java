package Model.DataStructures;


import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;


public interface MyIDictionary<K,V> {

    Enumeration<V> elements();
    Enumeration<K> keys();
    boolean empty();
    V get(Object key);
    V remove(Object key);
    V put(K key,V value);
    int size();
    boolean isDefined(K key);
    Collection<V> getValues();
    MyIDictionary<K,V> deepCopy();
}
