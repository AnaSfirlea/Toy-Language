package View;

import Controller.Controller;
import Exceptions.MyStmtExecException;

public class RunExample extends Command {

    private Controller ctrl;
    public RunExample(String key, String description,Controller ctrl) {
        super(key, description);
        this.ctrl = ctrl;
    }

    @Override
    public void execute() {
        try{
            ctrl.allStep();
        }
        catch(MyStmtExecException ex){
            System.out.println(ex.getMessage());
        }
    }
}
