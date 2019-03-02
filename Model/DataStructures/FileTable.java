package Model.DataStructures;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;


public class FileTable<K,V> implements IFileTable<K,V> {

    private Dictionary<K,V> filetable;


    public FileTable() {
        this.filetable = new Hashtable<>();

    }

    public Enumeration<V> elements(){
        return filetable.elements();
    }

    public Enumeration<K> keys(){
        return filetable.keys();
    }

    public boolean empty(){
        return filetable.isEmpty();
    }

    public V get(Object key){
        return filetable.get(key);
    }

    public boolean isDefined(K key){
        if(this.get(key) == null)
            return false;

        return true;
    }
    public V remove(Object key){
        return filetable.remove(key);
    }

    public V put(K key,V value){

        return filetable.put(key,value);
    }

    public int size(){
        return filetable.size();
    }

    @Override
    public String toString() {
        return filetable.toString();
    }
}
