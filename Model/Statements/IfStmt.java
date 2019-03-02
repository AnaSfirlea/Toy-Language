package Model.Statements;


import Model.Expressions.Exp;
import Model.PrgState;

public class IfStmt implements IStmt {
    private Exp exp;
    private IStmt thenS;
    private IStmt elseS;

    public IfStmt(Exp e,IStmt t,IStmt el){
        this.exp = e;
        this.thenS = t;
        this.elseS = el;
    }

    public Exp getExp() {
        return exp;
    }

    public void setExp(Exp exp) {
        this.exp = exp;
    }

    public IStmt getThenS() {
        return thenS;
    }

    public void setThenS(IStmt thenS) {
        this.thenS = thenS;
    }

    public IStmt getElseS() {
        return elseS;
    }

    public void setElseS(IStmt elseS) {
        this.elseS = elseS;
    }

    @Override
    public String toString(){

        return "IF("+exp.toString()+")THEN("+thenS.toString()+")"+" ELSE("+elseS.toString()+")";
    }
    public PrgState execute(PrgState state) {
        if(exp.eval(state.getSymTable(),state.getHeap()) !=0)
            thenS.execute(state);
        else
            elseS.execute(state);

        return null;
    }
    public IStmt deepCopy(){
        IfStmt copy = new IfStmt(this.exp,this.thenS,this.elseS);
        return copy;
    }



}
