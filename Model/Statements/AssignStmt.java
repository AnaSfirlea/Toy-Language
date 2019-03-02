package Model.Statements;

import Exceptions.MyStmtExecException;
import Model.DataStructures.MyIDictionary;
import Model.DataStructures.MyIHeap;
import Model.DataStructures.MyIStack;
import Model.Expressions.Exp;
import Model.PrgState;

public class AssignStmt implements IStmt {
    private String id;
    Exp exp;

    public AssignStmt(String id, Exp exp) {
        this.id = id;
        this.exp = exp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Exp getExp() {
        return exp;
    }

    public void setExp(Exp exp) {
        this.exp = exp;
    }

    @Override
    public String toString(){

        return id+"="+exp.toString();
    }

    public PrgState execute(PrgState state){
        MyIStack<IStmt> stk = state.getExeStack();
        MyIHeap<Integer,Integer> heap = state.getHeap();
        MyIDictionary<String,Integer> symTbl = state.getSymTable();
        try{
        int val = exp.eval(symTbl,heap);

        if(!symTbl.isDefined(this.id))
           throw new MyStmtExecException("There is no address assigned for this variable");

        int address = symTbl.get(this.id);
        heap.put(address,val);

        }
        catch (MyStmtExecException ex){
            System.out.println("ASSIGN ERROR");
        }

        return null;
    }

    public IStmt deepCopy(){
        AssignStmt copy = new AssignStmt(this.id,this.exp);
        return copy;
    }
}
