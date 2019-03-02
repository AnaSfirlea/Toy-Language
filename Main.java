package App;
import Model.*;
import Controller.*;
import Model.DataStructures.MyList;
import Model.Expressions.ArithExp;
import Model.Expressions.ConstExp;
import Model.Expressions.RhExp;
import Model.Expressions.VarExp;
import Model.Statements.ReadFile;
import Model.Statements.*;
import Repository.*;
import View.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        /*IStmt ex1 = new CompStmt(new AssignStmt("v", new ConstExp(2)),
            new PrintStmt(new VarExp("v")));

        PrgState state1 = new PrgState(ex1);

        MyList<PrgState> prgStates1 = new MyList<PrgState>();
        prgStates1.add(state1);

        Rep r1 = new Rep(prgStates1);
        Controller c1 = new Controller(r1, 1);

        IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp('+',new ConstExp(2),new
                ArithExp('*',new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new NewStmt("b",new ArithExp('+',new VarExp("a"), new
                        ConstExp(1))), new PrintStmt(new VarExp("b"))));
        PrgState state2 = new PrgState(ex2);

        MyList<PrgState> prgStates2 = new MyList<PrgState>();
        prgStates2.add(state2);

        Rep r2 = new Rep(prgStates2);
        Controller c2 = new Controller(r2, 1);

        IStmt ex3 = new CompStmt(new AssignStmt("a",new ArithExp('-',new ConstExp(2),new ConstExp(2))),
                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)),
                        new AssignStmt("v",new ConstExp(3))),new PrintStmt(new VarExp("v"))));
        PrgState state3 = new PrgState(ex3);

        MyList<PrgState> prgStates3 = new MyList<PrgState>();
        prgStates3.add(state3);

        Rep r3 = new Rep(prgStates3);
        Controller c3 = new Controller(r3, 1);


        IStmt ex4 = new CompStmt(new AssignStmt("a",new ArithExp('/',new ConstExp(12),new ConstExp(0))),
                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(3)),
                        new AssignStmt("v",new ConstExp(3))),new PrintStmt(new VarExp("v"))));
        PrgState state4 = new PrgState(ex4);

        MyList<PrgState> prgStates4 = new MyList<PrgState>();
        prgStates4.add(state4);

        Rep r4 = new Rep(prgStates4);
        Controller c4 = new Controller(r4, 1);

        IStmt ex5 = new CompStmt(new OpenRFile("var_f", "test.in"),new CompStmt(new NewStmt("var_c",new ConstExp(0)),
                new CompStmt(new ReadFile(new VarExp("var_f"),"var_c"),
                        new CompStmt(new PrintStmt(new VarExp("var_c")),
                                new CompStmt(new IfStmt(new VarExp("var_c"),
                                        new CompStmt(new ReadFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                                        new PrintStmt(new ConstExp(0))),new CloseRFile(new VarExp("var_f")))))));
       // IStmt ex5 = new CompStmt(new OpenRFile("var_f", "test.in"),new CompStmt(new NewStmt("var_c",new ConstExp(0)),
          //      new CompStmt(new ReadFile(new VarExp("var_f"),"var_c"),
            //            new CompStmt(new PrintStmt(new VarExp("var_c")),
              //                  new IfStmt(new VarExp("var_c"),
                //                        new CompStmt(new ReadFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                  //                      new PrintStmt(new ConstExp(0)))))));

        PrgState state5 = new PrgState(ex5);

        MyList<PrgState> prgStates5 = new MyList<PrgState>();
        prgStates5.add(state5);

        Rep r5 = new Rep(prgStates5);
        Controller c5 = new Controller(r5, 1);

        IStmt ex6 = new CompStmt(new AssignStmt("v",new ConstExp(10)),new CompStmt(new NewStmt("v",new ConstExp(20)),
                new CompStmt(new NewStmt("a",new ConstExp(22)),new PrintStmt(new VarExp("v")))));

        PrgState state6 = new PrgState(ex6);

        MyList<PrgState> prgStates6 = new MyList<PrgState>();
        prgStates6.add(state6);

        Rep r6 = new Rep(prgStates6);
        Controller c6 = new Controller(r6, 1);

        IStmt ex7 = new CompStmt(new AssignStmt("v",new ConstExp(10)),
                new CompStmt(new NewStmt("v",new ConstExp(20)),
                        new CompStmt(new NewStmt("a",new ConstExp(22)),
                                new CompStmt(new PrintStmt(new ArithExp('+',new ConstExp(100),new RhExp("v"))),
                                        new PrintStmt(new ArithExp('+',new ConstExp(100),new RhExp("a")))))));
        PrgState state7 = new PrgState(ex7);

        MyList<PrgState> prgStates7 = new MyList<PrgState>();
        prgStates7.add(state7);

        Rep r7 = new Rep(prgStates7);
        Controller c7 = new Controller(r7, 1);


        IStmt ex8 = new CompStmt(new AssignStmt("v",new ConstExp(10)),
                new CompStmt(new NewStmt("v",new ConstExp(20)),
                        new CompStmt(new NewStmt("a",new ConstExp(22)),
                                new CompStmt(new WhStmt("a",new ConstExp(30)),
                                        new CompStmt(new PrintStmt(new VarExp("a")),new PrintStmt(new RhExp("a")))))));

        PrgState state8 = new PrgState(ex8);

        MyList<PrgState> prgStates8 = new MyList<PrgState>();
        prgStates8.add(state8);

        Rep r8 = new Rep(prgStates8);
        Controller c8 = new Controller(r8, 1);


        IStmt ex9 = new CompStmt(new NewStmt("v",new ConstExp(6)),
                new CompStmt(new WhileStmt(new ArithExp('-',new VarExp("v"),new ConstExp(4)),
                        new CompStmt(new PrintStmt(new VarExp("v")),
                                new AssignStmt("v",new ArithExp('-',new VarExp("v"),new ConstExp(1))))),
                        new PrintStmt(new VarExp("v"))));

        PrgState state9 = new PrgState(ex9);

        MyList<PrgState> prgStates9 = new MyList<PrgState>();
        prgStates9.add(state9);

        Rep r9 = new Rep(prgStates9);
        Controller c9 = new Controller(r9, 1);*/

        IStmt ex10 = new CompStmt(new NewStmt("v",new ConstExp(10)),
                new CompStmt(new NewStmt("a",new ConstExp(22)),
                        new ForkStmt(new CompStmt(new WhStmt("a",new ConstExp(30)),
                                new CompStmt(new AssignStmt("v",new ConstExp(32)),
                                        new CompStmt(new PrintStmt(new VarExp("v")),
                                                new CompStmt(new PrintStmt(new RhExp("a")),
                                                        new CompStmt(new PrintStmt(new VarExp("v")),new PrintStmt(new RhExp("a"))))))))));

        PrgState state10 = new PrgState(ex10);

        List<PrgState> prgStates10 = new ArrayList<PrgState>();
        prgStates10.add(state10);

        Rep r10 = new Rep(prgStates10);
        //r10.add(state10);
        Controller c10 = new Controller(r10,1);
        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        /*menu.addCommand(new RunExample("1",ex1.toString(),c1));
        menu.addCommand(new RunExample("2",ex2.toString(),c2));
        menu.addCommand(new RunExample("3",ex3.toString(),c3));
        menu.addCommand(new RunExample("4",ex4.toString(),c4));
        menu.addCommand(new RunExample("5",ex5.toString(),c5));
        menu.addCommand(new RunExample("6",ex6.toString(),c6));
        menu.addCommand(new RunExample("7",ex7.toString(),c7));
        menu.addCommand(new RunExample("8",ex8.toString(),c8));
        menu.addCommand(new RunExample("9",ex9.toString(),c9));*/
        menu.addCommand(new RunExample("10",ex10.toString(),c10));



        menu.show();
   }
}
