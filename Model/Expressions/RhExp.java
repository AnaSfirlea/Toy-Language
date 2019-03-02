package Model.Expressions;

import Exceptions.MyStmtExecException;
import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;
import Model.Expressions.Exp;

public class RhExp extends Exp {

    private String variableName;

    public RhExp(String variableName) {
        this.variableName = variableName;
    }


    public int eval(MyIDictionary<String,Integer> symTbl,MyIHeap<Integer,Integer> heap){

        if(!symTbl.isDefined(variableName))
            throw new MyStmtExecException("The variable is not defined in the symbol table!");

        int address = symTbl.get(variableName);

        if(!heap.isDefined(address))
        {
            throw new MyStmtExecException("The variable is not defined in the heap!");

        }
        int value = heap.get(address);


        return value;
    }

    @Override
    public String toString(){
        return "rH("+variableName+")";
    }




}
