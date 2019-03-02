package Model.Statements;

import Exceptions.MyStmtExecException;
import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;
import Model.Expressions.Exp;
import Model.PrgState;

public class WhStmt implements IStmt {

    private String var_name;
    private Exp expression;

    public WhStmt(String var_name, Exp expression) {
        this.var_name = var_name;
        this.expression = expression;
    }
    @Override
    public PrgState execute(PrgState state){
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        MyIHeap<Integer,Integer> heap = state.getHeap();

        if(!symTbl.isDefined(var_name))
            throw new MyStmtExecException("The variable is not defined in the symbol table!");

        int addr = symTbl.get(var_name);
        if(!heap.isDefined(addr))
            throw new MyStmtExecException("Invalid address!");

        int val = expression.eval(symTbl,heap);
        heap.put(addr,val);


        return null;
    }

    @Override
    public String toString()
    {
        return "wH("+var_name+","+expression+")";
    }

    @Override
    public IStmt deepCopy()
    {
        return new WhStmt(this.var_name,this.expression);
    }

}
