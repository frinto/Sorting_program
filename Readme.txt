*Do not move jar file*

1) shift + right click
2) open command window here
3) type in command window for example:
	java -jar sort.jar -fpolyfor1.txt -tv -sz
4) hit enter

PARAMETERS (ORDER DOESNT MATTER)
-f<filename>
-t<compare type>
-s<sort type>

or 
(UPPERCASE)

-F<filename>
-T<compare type>
-S<sort type>

valid file names are:
polyfor1.txt
polyfor3.txt
polyfor5.txt
polyNameBIG.txt

valid compare types are:
a
A
h
H
v
V

valid sort types are:
b
B
s
S
i
I
m
M
q
Q
z
Z

more examples:
java -jar sort.jar -Fpolyfor1.txt -SZ -TA
java -jar sort.jar -Sm -Th -Fpolyfor1.txt
java -jar sort.jar -S b -tH -f polyfor1.txt