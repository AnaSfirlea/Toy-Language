package Model.Expressions;

import Exceptions.MyStmtExecException;
import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;

public class ArithExp extends Exp {

    private Exp e1;
    private Exp e2;
    private char op;

    public ArithExp(char op,Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    public Exp getE1() {
        return e1;
    }

    public void setE1(Exp e1) {
        this.e1 = e1;
    }

    public Exp getE2() {
        return e2;
    }

    public void setE2(Exp e2) {
        this.e2 = e2;
    }

    public int getOp() {
        return op;
    }

    public void setOp(char op) {
        this.op = op;
    }

    @Override
    public String toString() {

        return e1.toString()+op+e2.toString();
    }

    @Override
    public int eval(MyIDictionary<String,Integer> tbl, MyIHeap<Integer,Integer> heap){

        if(op == '+')
            return (e1.eval(tbl,heap)+e2.eval(tbl,heap));
        else
            if(op=='-')
                return (e1.eval(tbl,heap)-e2.eval(tbl,heap));
            else
                if (op == '*')
                    return (e1.eval(tbl,heap)*e2.eval(tbl,heap));
                else
                    if(op == '/')//div by zero exception
                    {
                        if (e2.eval(tbl,heap) == 0)
                            throw new MyStmtExecException("Division by zero is not possible!");
                        else
                            return (e1.eval(tbl,heap) / e2.eval(tbl,heap));
                    }
                    else
                        if(op == '%')
                            return (e1.eval(tbl,heap)%e2.eval(tbl,heap));
                        else
                            if(op == '=')
                                if(e1.eval(tbl,heap) != e2.eval(tbl,heap))
                                    return 0;
        return 0;
    }

}
