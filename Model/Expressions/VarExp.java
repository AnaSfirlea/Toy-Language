package Model.Expressions;

import Exceptions.MyStmtExecException;
import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;
import Model.Expressions.Exp;

public class VarExp extends Exp {
    private String id;

    public VarExp(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id ;
    }

    public int eval(MyIDictionary<String,Integer> tbl, MyIHeap<Integer,Integer> heap){
        if(tbl.get(id) == null )
            throw new MyStmtExecException("The id is not in the table: Exception thrown from VarExp");

        int address = tbl.get(id);

        if(!heap.isDefined(address))
           throw new MyStmtExecException("The address is not in the heap: Exception thrown from VarExp");


        return address;

    }
}
