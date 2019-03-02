package Model.Statements;

import Model.DataStructures.MyIStack;
import Model.PrgState;

public class CompStmt implements IStmt {
    private IStmt first;
    private IStmt snd;

    public CompStmt(IStmt first, IStmt snd) {
        this.first = first;
        this.snd = snd;
    }

    public IStmt getFirst() {
        return first;
    }

    public void setFirst(IStmt first) {
        this.first = first;
    }

    public IStmt getSnd() {
        return snd;
    }

    public void setSnd(IStmt snd) {
        this.snd = snd;
    }

    @Override
    public String toString(){return "("+first.toString()+";"
            +snd.toString()+")";
    }

    public PrgState execute(PrgState state) {

        MyIStack<IStmt> stk = state.getExeStack();
        stk.push(snd);
        stk.push(first);
        return null;
    }

    public IStmt deepCopy(){

        CompStmt copy = new CompStmt(this.first,this.snd);
        return copy;
    }





}
