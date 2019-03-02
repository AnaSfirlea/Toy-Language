package Model.Statements;

import Model.DataStructures.IFileTable;
import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;
import Model.DataStructures.MyIStack;
import Model.Expressions.ConstExp;
import Model.PrgState;
import Utils.*;
import Exceptions.MyStmtExecException;


import java.io.*;
import java.util.Enumeration;

public class OpenRFile implements IStmt {

    private String var_file_id;
    private String filename;

    public OpenRFile(String var_file_id, String filename) {
        this.var_file_id = var_file_id;
        this.filename = filename;
    }

    public PrgState execute(PrgState state){
        MyIStack<IStmt> stk = state.getExeStack();
        //stk.pop();

        IFileTable<Integer, FileTuple> filetable = state.getFileTable();
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        MyIHeap<Integer,Integer> heap = state.getHeap();
        Enumeration<Integer> keys = filetable.keys();
       /* while(keys.nextElement()!=null)
        {
            Pair<String,BufferedReader> pair = filetable.get(keys.nextElement());
            if(pair.getKey().equals(this.filename))
                throw new MyStmtExecException("The file is already open");
        }*/
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
            int id = IdGenerator.generateId();
            FileTuple tuple = new FileTuple(this.filename,bufferedReader);
            filetable.put(id,tuple);

            IStmt is = new NewStmt("e",new ConstExp(0));
            ((NewStmt) is).new_free++;
            int addr = ((NewStmt) is).new_free;
            symTbl.put(this.var_file_id, addr);
            heap.put(addr,id);



        }
        catch(IOException ex){throw new MyStmtExecException(ex.getMessage());}


        return null;
    }

    @Override
    public String toString(){
        return "OpenRFile("+this.var_file_id+","+this.filename+")";
    }

    public IStmt deepCopy() {
        OpenRFile copy = new OpenRFile(this.var_file_id,this.filename);
        return copy;
    }
}
