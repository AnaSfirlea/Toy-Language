package Model.Statements;

import Model.DataStructures.*;
import Model.PrgState;
import Utils.FileTuple;

import java.util.Stack;

public class ForkStmt implements IStmt {

    private IStmt stmt;

    public ForkStmt(IStmt stmt1) {
        this.stmt = stmt1;
    }

    @Override
    public PrgState execute(PrgState state)
    {
        MyStack<IStmt> exeStack2 = new MyStack<IStmt>();

       exeStack2.push(this.stmt);

        MyIDictionary<String,Integer> symTable2 = state.getSymTable().deepCopy();

        MyIList<Integer> out2 = state.getOut();

        MyIHeap<Integer,Integer> heap2 = state.getHeap();

        IFileTable<Integer, FileTuple> fileTbl2 = state.getFileTable();



        PrgState newState = new PrgState(exeStack2,symTable2,out2,fileTbl2,heap2);
        int new_id = state.getId()+10;
        newState.setId(new_id);

        return newState;

    }
    @Override
    public String toString(){
        return "fork("+this.stmt.toString()+")";
    }
    @Override
    public IStmt deepCopy(){
        return new ForkStmt(this.stmt);
    }
}
