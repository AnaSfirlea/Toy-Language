package Model.Statements;

import Exceptions.MyStmtExecException;
import Model.DataStructures.*;
import Model.Expressions.ConstExp;
import Model.Expressions.Exp;
import Model.PrgState;
import Utils.FileTuple;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile implements IStmt {
    private Exp exp_file_id;
    private String var_name;

    public ReadFile(Exp exp_file_id, String var_name) {
        this.exp_file_id = exp_file_id;
        this.var_name = var_name;
    }

    public Exp getExp_file_id() {
        return exp_file_id;
    }

    public void setExp_file_id(Exp exp_file_id) {
        this.exp_file_id = exp_file_id;
    }

    public String getVar_name() {
        return this.var_name;
    }

    public void setVar_name(String var_name) {
        this.var_name = var_name;
    }

    public PrgState execute(PrgState state){
        MyIStack<IStmt> stk = state.getExeStack();
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        IFileTable<Integer, FileTuple> fileTbl = state.getFileTable();
        MyIHeap<Integer,Integer> heap =state.getHeap();
        //stk.pop();
        int value_exp = this.exp_file_id.eval(symTbl,heap);

       if(!fileTbl.isDefined(value_exp))
        {
           throw new MyStmtExecException("The key is not defined in the file table");
        }
        FileTuple ft = fileTbl.get(value_exp);

        BufferedReader buffReader = ft.getBuffReader();
        int val = -1;
        try {
            String line = buffReader.readLine();

            if (line == null) {
                val = 0;
            }else try {
                val = Integer.parseInt(line);
            }
            catch(NumberFormatException ex){}



            //int address = new NewFreeSpace().generateNewFree();
            IStmt is = new NewStmt("0",new ConstExp(0));
            ((NewStmt) is).new_free++;
            int addr = ((NewStmt) is).new_free;
            symTbl.put(this.var_name, addr);
            heap.put(addr,val);


            }
            catch(IOException ex){throw new MyStmtExecException(ex.getMessage());}
            return null;
    }
    @Override
    public String toString(){
        return "ReadFile("+this.exp_file_id+","+this.var_name+")";
    }

    public IStmt deepCopy(){
        return new ReadFile(this.exp_file_id,this.var_name);
    }




}
