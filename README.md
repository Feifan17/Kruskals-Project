This file provides instructions on how to compile and run my program:

my program contains two java files:
•	UnionFind.java
•	KruskalsMSF.java


To use java in stdlinux:  
•	open the terminal.
•	type "subscribe" and then select JDK-CURRENT. 

•	To compile UnionFind.java and KruskalsMSF.java: 
•	type "cd [directory]”. The "[directory]" should be replaced by the location of where these two files have been stored.
•	type "javac UnionFind.java KruskalsMSF.java" to compile these two files. If they 	are compiled successfully, you should see four new files in the same directory: 	UnionFind.class, KruskalsMSF.class, KruskalsMSF$1.class and 				KruskalsMSF$EdgeWeightComparator.class.

To run the program:
•	put your test data files into the same directory with UnionFind.class, KruskalsMSF.class, KruskalsMSF$1.class and KruskalsMSF$EdgeWeightComparator.class.
•	The program takes one command line argument. To run the program, type "java KruskalsMSF graphX". Here, "graphX" should be replaced by the name of your input 	file. 
•	If the program is run successfully, the result will be printed out in the terminal.

