package View;

public class aux_main {
    /*public static void prg1(){
        IStmt ex1 = new CompStmt(new AssignStmt("v", new ConstExp(2)),
                new PrintStmt(new VarExp("v")));

        MyStack<IStmt> stk = new MyStack<IStmt>();

        MyDictionary<String, Integer> dict = new MyDictionary<String, Integer>();

        MyList<Integer> list = new MyList<Integer>();

        FileTable<Integer, FileTuple> fileTbl = new FileTable<Integer, FileTuple>();

        PrgState state = new PrgState(stk, dict, list, fileTbl,ex1);

        MyList<PrgState> prgStates = new MyList<PrgState>();
        prgStates.add(state);

        Rep r = new Rep(prgStates);
        Controller c = new Controller(r, 1);
        c.allStep();
        System.out.println(r.getCrtPrg().toString());

    }
    public static void prg2(){
        IStmt ex2 = new CompStmt(new AssignStmt("a", new ArithExp('+',new ConstExp(2),new
                ArithExp('*',new ConstExp(3), new ConstExp(5)))),
                new CompStmt(new AssignStmt("b",new ArithExp('+',new VarExp("a"), new
                        ConstExp(1))), new PrintStmt(new VarExp("b"))));

        MyStack<IStmt> stk2 = new MyStack<IStmt>();

        MyDictionary<String, Integer> dict2 = new MyDictionary<String, Integer>();

        MyList<Integer> list2 = new MyList<Integer>();

        FileTable<Integer, FileTuple> fileTbl2 = new FileTable<Integer, FileTuple>();

        PrgState state2 = new PrgState(stk2, dict2, list2,fileTbl2, ex2);

        MyList<PrgState> prgStates2 = new MyList<PrgState>();
        prgStates2.add(state2);

        Rep r2 = new Rep(prgStates2);
        Controller c2 = new Controller(r2, 1);
        c2.allStep();
        System.out.println(r2.getCrtPrg().toString());

    }
    public static void prg3(){
        IStmt ex3 = new CompStmt(new AssignStmt("a",new ArithExp('-',new ConstExp(2),new ConstExp(2))),
                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(2)),
                        new AssignStmt("v",new ConstExp(3))),new PrintStmt(new VarExp("v"))));
        MyStack<IStmt> stk3 = new MyStack<IStmt>();

        MyDictionary<String, Integer> dict3 = new MyDictionary<String, Integer>();

        MyList<Integer> list3 = new MyList<Integer>();

        FileTable<Integer, FileTuple> fileTbl3 = new FileTable<Integer,FileTuple>();


        PrgState state3 = new PrgState(stk3, dict3, list3,fileTbl3, ex3);

        MyList<PrgState> prgStates3 = new MyList<PrgState>();
        prgStates3.add(state3);

        Rep r3 = new Rep(prgStates3);
        Controller c3 = new Controller(r3, 1);
        c3.allStep();
        System.out.println(r3.getCrtPrg().toString());

    }
    public static void prg4(){
        IStmt ex4 = new CompStmt(new AssignStmt("a",new ArithExp('/',new ConstExp(12),new ConstExp(0))),
                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ConstExp(3)),
                        new AssignStmt("v",new ConstExp(3))),new PrintStmt(new VarExp("v"))));
        MyStack<IStmt> stk4 = new MyStack<IStmt>();

        MyDictionary<String, Integer> dict4 = new MyDictionary<String, Integer>();

        MyList<Integer> list4 = new MyList<Integer>();

        FileTable<Integer, FileTuple> fileTbl4 = new FileTable<Integer, FileTuple>();

        PrgState state4 = new PrgState(stk4, dict4, list4,fileTbl4, ex4);

        MyList<PrgState> prgStates4 = new MyList<PrgState>();
        prgStates4.add(state4);

        Rep r4 = new Rep(prgStates4);
        Controller c4 = new Controller(r4, 1);
        c4.allStep();
        System.out.println(r4.getCrtPrg().toString());
    }
    public static void prg5(){
        IStmt ex5 = new CompStmt(new OpenRFile("var_f", "test.in"),
                new CompStmt(new ReadFile(new VarExp("var_f"),"var_c"),
                        new CompStmt(new PrintStmt(new VarExp("var_c")),
                                new CompStmt(new IfStmt(new VarExp("var_c"),
                                        new CompStmt(new ReadFile(new VarExp("var_f"),"var_c"),new PrintStmt(new VarExp("var_c"))),
                                        new PrintStmt(new ConstExp(0))),new CloseRFile(new VarExp("var_f"))))));
        MyStack<IStmt> stk5 = new MyStack<IStmt>();

        MyDictionary<String, Integer> dict5 = new MyDictionary<String, Integer>();

        MyList<Integer> list5 = new MyList<Integer>();

        FileTable<Integer, FileTuple> fileTbl5 = new FileTable<Integer, FileTuple>();

        PrgState state5 = new PrgState(stk5, dict5, list5,fileTbl5, ex5);

        MyList<PrgState> prgStates5 = new MyList<PrgState>();
        prgStates5.add(state5);

        Rep r5 = new Rep(prgStates5);
        Controller c5 = new Controller(r5, 1);
        c5.allStep();
        System.out.println(r5.getCrtPrg().toString());
    }

    public static void printMenu(){
        System.out.println("CHOOSE FROM THE FOLLOWING PROGRAMS:" +
                "\n"+"1. v=2;print(v)"+
                "\n"+"2. a=2+3*5;(b=a+1;print(b))"+
                "\n"+"3. a=2-2;(IF(a)THEN(v=2) ELSE(v=3);print(v))"+
                "\n"+"4. a=12/0;(IF(a)THEN(v=3) ELSE(v=3);print(v))"+
                "\n"+"5. OpenRFile(var_f,test.in);" +"\n"+
                "   ReadFile(var_f,var_c);" +"\n"+
                "   print(var_c);" +"\n"+
                "   (IF(var_c)THEN((ReadFile(var_f,var_c);print(var_c))) ELSE(print(0));" +"\n"+
                "   CloseRFile(var_f)"+"\n" );


    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int k=1;
        while (k==1) {
            printMenu();

            System.out.println("Enter an option:");
            int opt = input.nextInt();
            String g = input.nextLine();

            switch (opt) {
                case 0: {
                    k=0;
                    break;
                }
                case 1: {
                    try{
                        prg1();
                    }
                    catch(MyStmtExecException ex){

                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 2:
                {
                    try{
                        prg2();
                    }
                    catch(MyStmtExecException ex){

                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 3: {
                    try{
                        prg3();
                    }
                    catch(MyStmtExecException ex){

                        System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 4: {
                    try{
                        prg4();
                    }
                    catch(MyStmtExecException ex){
                         System.out.println(ex.getMessage());
                    }
                    break;
                }
                case 5:
                    try{
                        prg5();
                    }
                    catch(MyStmtExecException ex){
                        System.out.println(ex.getMessage());
                    }

            }
        }
        input.close();

    }*/
}
