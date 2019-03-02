package Model.DataStructures;

import java.util.*;
import java.util.function.UnaryOperator;

public interface MyIList<E> {
    int size();
    boolean add(E e);
    void add(int index,E e);
    boolean addAll(Collection<? extends E> c);
    boolean addAll(int index,Collection<? extends E> c);
    void clear();
    boolean contains(Object o);
    boolean containsAll(Collection<?> c);
    E get(int index);
    boolean equals(Object o);
    int hashCode();
    int indexOf(Object o);
    boolean isEmpty();
    Iterator<E> iterator();
    List<E> getList();
    int lastIndexOf(Object o);
    ListIterator<E> listIterator();
    ListIterator<E> listIterator(int index);
    boolean remove(Object o);
    E remove(int index);
    boolean removeAll(Collection<?> c);
    void replaceAll(UnaryOperator<E> operator);
    boolean retainAll(Collection<?> c);
    E set(int index,E element);
    void sort(Comparator<? super E> c);
    Spliterator<E> spliterator();
    List<E> subList(int fromIndex,int toIndex);
    Object[] toArray();
    E[] toArray(E[] a);
}
