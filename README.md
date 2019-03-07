# Toy-Language
An application that imitates the behavior of an interpretator.
We will work with the following :
--->Program States - the state of our current program
--->Statements - the statements that are executed (IStmt interface)
--->Expressions - expressions evaluated to a certain integer number
                  (we use the C convention 0 means false and
                    any integer different from 0 means true)
--->Data structures for each program state - Execution Stack (all the statements that will be executed are on this stack)
                                           - Symbol table (containing all the variables from the program state)
                                           - Heap Table(containing all the addresses, represented as integers, of the                         variables from the program state)
                                           - File Table (containing all the files that are open)
                                           - Output table (all the output contains only integer numbers)
                                  
Firstly we have 3 classes that implement the statement interface:
                    Compound statement (contains two statements)
                    Assignment statement (assigns to a variable a certain integer value)
                    If statement (if expression true then statement1 else statement2)
                    Fork statement
                    Print statement
                    Some statements that work with the heap
                    Some statements that work with the files
We have mutiple expressions that are subclasses of the super class Exp : 
                                     -Constant expression (just an integer number)
                                     -Variable expression
                                     -Boolean expression
                                     -Arithmetic expression (two expressions and an operator)
 
 With all these classes we imitate the behaviour of an compiler. The project contains multi-threading as well, we can have multiple program states running at the same time. At the beginning only one program state is introduced and is being forked, creating other program states.
                    
                                                           
