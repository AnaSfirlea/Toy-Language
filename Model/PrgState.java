package Model;
import Exceptions.MyStmtExecException;
import Model.DataStructures.*;
import Model.Statements.IStmt;
import Utils.*;

public class PrgState {

    private int id;
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String,Integer> symTable;
    private MyIList<Integer> out;
    private IFileTable<Integer, FileTuple> fileTable;
    private MyIHeap<Integer,Integer> heap;
    private IStmt originalProgram;


    public PrgState(MyIStack<IStmt> stk,MyIDictionary<String,Integer> symtbl,
                    MyIList<Integer> ot,IFileTable<Integer, FileTuple> fileTable,
                    MyIHeap<Integer,Integer> heap,IStmt prg){
        this.exeStack = stk;
        this.symTable = symtbl;
        this.out = ot;
        this.originalProgram = prg.deepCopy();
        this.fileTable = fileTable;
        this.heap = heap;
        this.exeStack.push(prg);


    }
    //this is the constructor that MUST be used in the execute method for forkStmt!!!!!
    public PrgState(MyIStack<IStmt> stk,MyIDictionary<String,Integer> symtbl,
                    MyIList<Integer> ot,IFileTable<Integer, FileTuple> fileTable,
                    MyIHeap<Integer,Integer> heap){
        this.exeStack = stk;
        this.symTable = symtbl;
        this.out = ot;
        this.fileTable = fileTable;
        this.heap = heap;



    }
    public PrgState(IStmt prg){
        this.exeStack = new MyStack<IStmt>();
        this.symTable = new MyDictionary<String,Integer>();
        this.out = new MyList<Integer>();
        this.originalProgram = prg.deepCopy();
        this.fileTable = new FileTable<Integer, FileTuple>();
        this.heap = new MyHeap<Integer, Integer>();
        this.exeStack.push(prg);

    }

    public PrgState(int id,MyIStack<IStmt> stk,MyIDictionary<String,Integer> symtbl,
                    MyIList<Integer> ot,IFileTable<Integer, FileTuple> fileTable,
                    MyIHeap<Integer,Integer> heap,IStmt prg){
        this.id = id;
        this.exeStack = stk;
        this.symTable = symtbl;
        this.out = ot;
        this.originalProgram = prg.deepCopy();
        this.fileTable = fileTable;
        this.heap = heap;
        this.exeStack.push(prg);


    }
    public int getId(){
        return this.id;
    }
    public void setId(int new_id){
        this.id = new_id;
    }

    public MyIStack<IStmt> getExeStack() {
        return exeStack;
    }

    public void setExeStack(MyIStack<IStmt> exeStack) {
        this.exeStack = exeStack;
    }

    public MyIDictionary<String, Integer> getSymTable() {
        return symTable;
    }

    public void setSymTable(MyIDictionary<String, Integer> symTable) {
        this.symTable = symTable;
    }

    public MyIList<Integer> getOut() {
        return out;
    }

    public void setOut(MyIList<Integer> out) {
        this.out = out;
    }

    public IStmt getOriginalProgram() {
        return originalProgram;
    }

    public void setOriginalProgram(IStmt originalProgram) {
        this.originalProgram = originalProgram;
    }

    public IFileTable<Integer, FileTuple> getFileTable() {return this.fileTable;}

    public MyIHeap<Integer, Integer> getHeap() {
        return heap;
    }


    public Boolean isNotCompleted(){
        return !this.exeStack.empty();
    }

    public PrgState oneStep() throws MyStmtExecException {
        MyIStack<IStmt> stk = this.getExeStack();
        try {
            if (stk.empty())
                throw new MyStmtExecException("Empty stack");
            IStmt crtStmt = stk.pop();
            PrgState newState = crtStmt.execute(this);

            return newState;
        }
        catch (MyStmtExecException ex){
            throw new MyStmtExecException(ex.getMessage());
        }
    }
    @Override
    public String toString() {

        return "PrgState{" +"\n"+
                "ID:"+this.id+"\n"+
                "ExeStack:" + exeStack+"\n"+
                "SymTable:" + symTable +"\n"+
                "Out:" + out+"\n"+
                "FileTable:" + fileTable+"\n"+
                "Heap:" + heap+"\n"+
                "OriginalProgram:" + originalProgram+"\n"+
                '}';
    }
}
