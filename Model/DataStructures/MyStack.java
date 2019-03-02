package Model.DataStructures;

import Model.DataStructures.MyIStack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
    private Stack<T> stack;

    public MyStack(){this.stack = new Stack<>();}
    public MyStack(Stack<T> stack) {
        this.stack = stack;
    }

    public T pop(){
        return stack.pop();
    }

    public void push(T v) {
        stack.push(v);

    }

    public boolean empty(){
        return stack.empty();
    }

    public int search(T v){
        return stack.search(v);
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();
        for(T elem:stack)
        {
            list.add(elem.toString());
            list.add("\n");
        }

        int size = list.size();
        while(size!=0)
        {
            str.append(list.get(size-1));
            size--;
        }
        return str.toString();
    }
}
