# Toy-Language
An application that imitates the behavior of a compiler._____________________________________________________________________
We will work with the following :____________________________________________________________________________________________
--->Program States - the state of our current program________________________________________________________________________
--->Statements - the statements that are executed (IStmt interface)__________________________________________________________
--->Expressions - expressions evaluated to a certain integer number__________________________________________________________ 
_____________(we use the C convention 0 means false and______________________________________________________________________
_____________any integer different from 0 means true)________________________________________________________________________
--->Data structures for each program state - Execution Stack (all the statements that will be executed are on this stack)
__________________________________________ - Symbol table (containing all the variables from the program state)
__________________________________________ - Heap Table(containing all the addresses of the variables from the program state)
__________________________________________ - File Table (containing all the files that are open)
__________________________________________ - Output table (all the output contains only integer numbers)
                                  
Firstly we have 3 classes that implement the statement interface:____________________________________________________________
                    Compound statement (contains two statements)_____________________________________________________________
                    Assignment statement (assigns to a variable a certain integer value)_____________________________________
                    If statement (if expression true then statement1 else statement2)________________________________________
We have mutiple expressions that are subclasses of the super class Exp :_____________________________________________________ 
_____________________________________-Constant expression (just an integer number)___________________________________________
_____________________________________-Variable expression
_____________________________________-Boolean expression
                    
                                                           
