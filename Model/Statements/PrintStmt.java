package Model.Statements;

import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIList;
import Model.Expressions.Exp;
import Model.PrgState;

public class PrintStmt implements IStmt {
    private Exp exp;

    public PrintStmt(Exp exp) {
        this.exp = exp;
    }

    public PrgState execute(PrgState state){

        MyIList<Integer> ot = state.getOut();
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        ot.add(exp.eval(state.getSymTable(),state.getHeap()));
        return null;
    }

    @Override
    public String toString(){

        return "print("+exp.toString()+")";
    }

    public IStmt deepCopy(){
        PrintStmt copy = new PrintStmt(this.exp);
        return copy;
    }

}
