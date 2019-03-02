package Model.Statements;

import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;
import Model.Expressions.Exp;
import Model.PrgState;


public class NewStmt implements IStmt {

    private String var_name;
    private Exp expression;
    static public int new_free =0;
    public NewStmt(String var_name, Exp expression) {
        this.var_name = var_name;
        this.expression = expression;

    }

    @Override
    public PrgState execute(PrgState state) {
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        MyIHeap<Integer,Integer> heap = state.getHeap();
        int val = expression.eval(symTbl,heap);


        new_free++;
        symTbl.put(var_name,new_free);
        heap.put(new_free,val);

        return null;
    }

    @Override
    public IStmt deepCopy()
    {
        return new NewStmt(this.var_name,this.expression);
    }

    @Override
    public String toString()
    {
        return "new("+var_name+","+expression+")";
    }
}
