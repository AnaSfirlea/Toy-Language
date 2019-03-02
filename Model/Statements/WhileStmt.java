package Model.Statements;

import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;
import Model.Expressions.Exp;
import Model.PrgState;

public class WhileStmt implements IStmt {

    private Exp exp;
    private IStmt stmt;

    public WhileStmt(Exp expression,IStmt stmt) {
        this.exp = expression;
        this.stmt = stmt;
    }

    @Override
    public String toString() {
        return "while("+ exp.toString()+")"+stmt.toString();
    }

    @Override
    public PrgState execute(PrgState state){
        MyIDictionary<String,Integer> tbl = state.getSymTable();
        MyIHeap<Integer,Integer> heap = state.getHeap();

        if(exp.eval(tbl,heap)!=0)
        {
            stmt.execute(state);
            state.getExeStack().push(stmt);
        }

        return null;
    }

    @Override
    public IStmt deepCopy(){
        return new WhileStmt(this.exp,this.stmt);
    }
}
