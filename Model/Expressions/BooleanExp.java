package Model.Expressions;

import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;

public class BooleanExp extends Exp {
    private Exp e1;
    private Exp e2;
    private String op;

    public BooleanExp(Exp e1, Exp e2, String op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    @Override
    public String toString(){
        return e1.toString()+op+e2.toString();
    }

    @Override
    public int eval(MyIDictionary<String,Integer> tbl, MyIHeap<Integer,Integer> heap){
        if(op.equals("<"))
            if(e1.eval(tbl,heap) < e2.eval(tbl,heap))
                return 1;
        else
            if(op.equals(">"))
                if(e1.eval(tbl,heap) > e2.eval(tbl,heap))
                    return 1;
            else
                if(op.equals("<="))
                    if(e1.eval(tbl,heap) <= e2.eval(tbl,heap))
                        return 1;
                else
                    if(op.equals(">="))
                        if(e1.eval(tbl,heap) >= e2.eval(tbl,heap))
                            return 1;
                    else
                        if(op.equals("=="))
                            if(e1.eval(tbl,heap) == e2.eval(tbl,heap))
                                return 1;
                        else
                            if(op.equals("!="))
                                if(e1.eval(tbl,heap) != e2.eval(tbl,heap))
                                    return 1;
        return 0;
    }
}
