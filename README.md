# Toy-Language
An application that imitates the behavior of a compiler.
We will work with the following :
--->Program States - the state of our current program
--->Statements - the statements that are executed
--->Expressions - expressions evaluated to a certain integer number
             (we use the C convention 0 means false and
             any integer different from 0 means true)
--->Data structures for each program state - Execution Stack (all the statements that will be executed are on this stack)
                                           - Output table ( the output will contain only integer numbers )
                                           - Symbol table (containing all the variables from the program state)
                                           - Heap Table(containing all the addresses of the variables from the program state)
                                           - File Table (containing all the files that are open)
                                  
Firstly we have 3 categories of statements : Compound statement (contains two statements)
                                             Assignment statement (assigns to a variable a certain integer value)
                                             If statement (contains 
