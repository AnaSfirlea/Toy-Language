package Model.DataStructures;

import Model.DataStructures.MyIList;

import java.util.*;
import java.util.function.UnaryOperator;

public class MyList<E> implements MyIList<E> {

    private List<E> list;

    public MyList(){ this.list = new ArrayList<>();}
    public MyList(List<E> list) {
        this.list = list;
    }

    public int size(){
        return list.size();

    }
    public boolean add(E e) {
        return list.add(e);

    }
    public void add(int index,E e){
        list.add(index,e);

    }
    public boolean addAll(Collection<? extends E> c){
        return list.addAll(c);
    }

    public boolean addAll(int index,Collection<? extends E> c){
        return list.addAll(index,c);

    }

    public void clear(){
        list.clear();
    }
    public boolean contains(Object o){
        return list.contains(o);
    }
    public boolean containsAll(Collection<?> c){
        return list.containsAll(c);
    }
    public E get(int index){
        return list.get(index);
    }
    public boolean equals(Object o){
        return list.equals(o);

    }
    public int hashCode(){
        return list.hashCode();
    }
    public int indexOf(Object o){
        return list.indexOf(o);

    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public Iterator<E> iterator(){
        return  list.iterator();
    }

    public List<E> getList() {
        return list;

    }
    public int lastIndexOf(Object o){
        return list.lastIndexOf(o);

    }
    public ListIterator<E> listIterator(){
        return list.listIterator();
    }
    public ListIterator<E> listIterator(int index){
        return list.listIterator(index);

    }
    public boolean remove(Object o){
        return list.remove(o);
    }
    public E remove(int index){
        return list.remove(index);
    }
    public boolean removeAll(Collection<?> c){
        return list.removeAll(c);

    }
    public void replaceAll(UnaryOperator<E> operator){
        list.replaceAll(operator);

    }
    public boolean retainAll(Collection<?> c){
        return list.retainAll(c);
    }
    public E set(int index,E element){
        return list.set(index,element);


    }
    public void sort(Comparator<? super E> c){
        list.sort(c);

    }
    public Spliterator<E> spliterator(){
        return list.spliterator();

    }
    public List<E> subList(int fromIndex,int toIndex){
        return list.subList(fromIndex,toIndex);

    }
    public Object[] toArray(){
        return list.toArray();
    }

    public E[] toArray(E[] a) {
        return list.toArray(a);

    }

    @Override
    public String toString() {
        return list.toString();
    }
}
