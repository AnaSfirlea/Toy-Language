package Controller;
import Model.*;
import Model.DataStructures.IFileTable;
import Model.Expressions.VarExp;
import Model.Statements.CloseRFile;
import Repository.*;
import Exceptions.*;
import Utils.FileTuple;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Controller {
    private IRep repo;
    private int flag;
    private ExecutorService executor;

    public Controller(IRep repo,int flag) {

        this.repo = repo;
        this.flag = flag;
    }
    public void oneStepForAllPrg(List<PrgState> prgList) {
        try {
            prgList.forEach(prg -> repo.logPrgStateExec(prg));
        } catch (MyStmtExecException ex) {
            throw new MyStmtExecException(ex.getMessage());
        }

        //the list of callables
        List<Callable<PrgState>> callList = prgList.stream()
                .map((PrgState p) -> (Callable<PrgState>) p::oneStep)
                .collect(Collectors.toList());

        //start the execution of the callables
        //returns the list of new created PrgStates(threads)
        try{

            List<PrgState> newPrgList = executor.invokeAll(callList)
                    .stream()
                    .map(future ->
                    {
                        try
                        {
                            return future.get();
                        }
                        catch(Exception e) {
                            throw new MyStmtExecException(e.getMessage());
                        }
                    })
                    .filter(p -> p!=null)
                    .collect(Collectors.toList());

            prgList.addAll(newPrgList);//add the new created threads to the list of existing ones
            prgList.forEach(prg->repo.logPrgStateExec(prg));//print the list into the log file
            repo.setPrgList(prgList); //save current programs in repo
        }
        catch(Exception ex)
        {
            throw  new MyStmtExecException(ex.getMessage());
        }



    }
    public  void allStep(){

       executor = Executors.newFixedThreadPool(2);
       List<PrgState> prgList = removeCompletedPrg(repo.getPrgList());
       while(prgList.size()>0)
       {
           //here put the code to call garbage collector------------------------
           ///
           oneStepForAllPrg(prgList);

           prgList = removeCompletedPrg(repo.getPrgList());
       }
       executor.shutdownNow();

       //here put the code to close files---------------------------------
        ///////
        repo.setPrgList(prgList);
    }

    private void displayCrtPrgState(PrgState state){
         System.out.println(state.toString());
    }

    private Map<Integer,Integer> conservativeGarbageCollector(Collection<Integer> symTableValues,
                                                              Map<Integer,Integer> heap)
    {
        return heap.entrySet().stream()
                .filter(e->symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    public List<PrgState> removeCompletedPrg(List<PrgState> inPrgList)
    {
        return inPrgList.stream()
                .filter(p->p.isNotCompleted())
                .collect(Collectors.toList());
    }

}


