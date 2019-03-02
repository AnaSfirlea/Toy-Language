package Model.DataStructures;

import java.util.*;

public class MyHeap<K,V> implements MyIHeap<K,V>{
    private HashMap<K,V> map;


    public MyHeap(){
        this.map = new HashMap<K,V>();

    }


    public Collection<V> elements(){
        return map.values();
    }

    public Set<K> keys(){
        return map.keySet();
    }

    public boolean empty(){
        return map.isEmpty();
    }

    public V get(Object key){
        return map.get(key);
    }

    public boolean isDefined(K key){
        if(this.get(key) == null)
            return false;

        return true;
    }
    public V remove(Object key){
        return map.remove(key);
    }

    public V put(K key,V value){
        return map.put(key,value);
    }

    public int size(){
        return map.size();
    }

    public void setContent(HashMap<K,V> new_heap){
        this.map= new_heap;
    }

    public HashMap<K, V> getContent() {
        return this.map;
    }

    @Override
    public String toString() {
        return map.toString();
    }

}
