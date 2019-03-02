package Model.DataStructures;

import java.util.*;

public class MyDictionary<K,V> implements MyIDictionary<K,V> {

    private Dictionary<K,V> dictionary;

    public MyDictionary(){this.dictionary = new Hashtable<>(); }
    public MyDictionary(Dictionary<K, V> dictionary) {
        this.dictionary = dictionary;
    }

    public Enumeration<V> elements(){
        return dictionary.elements();
    }

    public Enumeration<K> keys(){
        return dictionary.keys();
    }

    public boolean empty(){
        return dictionary.isEmpty();
    }

    public V get(Object key){
        return dictionary.get(key);
    }

    public boolean isDefined(K key){
        if(this.get(key) == null)
            return false;

        return true;
    }
    public V remove(Object key){
       return dictionary.remove(key);
    }

    public V put(K key,V value){
        return dictionary.put(key,value);
    }

    public int size(){
        return dictionary.size();
    }

    public Collection<V> getValues(){
        ArrayList<V> collection = new ArrayList<>();

        int size = this.dictionary.size();

        for(int i =0; i<size;i++)
        {
            V value = this.dictionary.elements().nextElement();
            collection.add(i,value);
        }
        return  collection;
   }
    public MyIDictionary<K,V> deepCopy(){
        return new MyDictionary<K,V>(this.dictionary);
    }
    @Override
    public String toString() {
        return dictionary.toString();
    }
}
