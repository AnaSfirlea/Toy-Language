package Model.DataStructures;

import java.util.*;

public interface MyIHeap<K,V> {

    Collection<V> elements();
    Set<K> keys();
    boolean empty();
    V get(Object key);
    V remove(Object key);
    V put(K key,V value);
    int size();
    boolean isDefined(K key);

    HashMap<K, V> getContent();
    void setContent(HashMap<K,V> new_heap);
}
