package Model.Expressions;

import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;

public class ConstExp extends Exp {

    int number;

    public ConstExp(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  Integer.toString(number);
    }

    @Override
    public int eval(MyIDictionary<String,Integer> tbl, MyIHeap<Integer,Integer> heap){
        return  number;
    }
}
