package Model.DataStructures;

public interface MyIStack<T> {
    T pop();
    void push(T v);
    boolean empty();
    int search(T v);
}
