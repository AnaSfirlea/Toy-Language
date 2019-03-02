package Model.Expressions;

import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;

public abstract class Exp {
   public abstract int eval(MyIDictionary<String,Integer> tbl, MyIHeap<Integer,Integer> heap);
}
