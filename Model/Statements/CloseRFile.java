package Model.Statements;

import Exceptions.MyStmtExecException;
import Model.DataStructures.IFileTable;
import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;
import Model.DataStructures.MyIStack;
import Model.Expressions.Exp;
import Model.PrgState;
import Utils.FileTuple;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseRFile implements IStmt {

    private Exp exp_file_id;

    public CloseRFile(Exp exp_file_id) {
        this.exp_file_id = exp_file_id;
    }

    public PrgState execute(PrgState state){
        MyIStack<IStmt> stk = state.getExeStack();
       // stk.pop();

        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        IFileTable<Integer, FileTuple> fileTbl = state.getFileTable();
        MyIHeap<Integer,Integer> heap = state.getHeap();

        int value_exp = this.exp_file_id.eval(symTbl, heap);

        if(!fileTbl.isDefined(value_exp))
        {
            throw new MyStmtExecException("The key is not defined in the file table");
        }

        BufferedReader buffReader = fileTbl.get(value_exp).getBuffReader();

        try{
            buffReader.close();
        }
        catch(IOException ex){ throw  new MyStmtExecException(ex.getMessage());}

        fileTbl.remove(value_exp);
        return null;

    }
    @Override
    public String toString(){
        return "CloseRFile("+this.exp_file_id+")";
    }

    public IStmt deepCopy(){
        return new CloseRFile(this.exp_file_id);
    }
}
