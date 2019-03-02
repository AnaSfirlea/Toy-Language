package Repository;

import Exceptions.MyStmtExecException;
import Model.*;
import Model.DataStructures.MyIList;

import java.io.*;
import java.io.FileWriter;
import java.util.List;

public class Rep implements IRep {

    private List<PrgState> prgStates;
    private String logFilePath;

    public Rep(List<PrgState> prgStates) {
        this.prgStates = prgStates;
        this.logFilePath = "logfile";
    }

    public Rep(List<PrgState> prgStates,String filename) {
        this.prgStates = prgStates;
        this.logFilePath = filename;

    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void add(PrgState state){
        prgStates.add(state);

    }
    public List<PrgState> getPrgList(){
        return this.prgStates;
    }

    public void setPrgList(List<PrgState> states){
        this.prgStates = states;
    }
    public void logPrgStateExec(PrgState state){
        try {
            PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(this.logFilePath, true)));

            logFile.print("ID:");
            logFile.print("\n");
            logFile.print(""+state.getId());
            logFile.print("\n");

            logFile.print("ExeStack:");
            logFile.print("\n");
            logFile.print(state.getExeStack().toString());
            logFile.print("\n");

            logFile.print("SymTable:");
            logFile.print("\n");
            logFile.print(state.getSymTable().toString());
            logFile.print("\n");

            logFile.print("Out:");
            logFile.print("\n");
            logFile.print((state.getOut().toString()));
            logFile.print("\n");

            logFile.print("FileTable:");
            logFile.print("\n");
            logFile.print(state.getFileTable().toString());
            logFile.print("\n");

            logFile.print("Heap:");
            logFile.print("\n");
            logFile.print(state.getHeap().toString());
            logFile.print("\n");

            logFile.print("\n");
            logFile.print("\n");

            logFile.close();
        }
        catch(IOException ex){throw  new MyStmtExecException(ex.getMessage());}

    }

}
