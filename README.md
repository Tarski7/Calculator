# Calculator

Instructions comprise of a keyword and a number that are separated by a space per
line. Instructions are loaded from file and results are output to the screen. Any number
of Instructions can be specified. Instructions can be any binary operators of your choice
(e.g., add, divide, subtract, multiply etc). The instructions will ignore mathematical
precedence. The last instruction should be “apply” and a number (e.g., “apply 3”). The
calculator is then initialised with that number and the previous instructions are applied
to that number.

Examples of the calculator lifecycle might be:

Example 1
Input from file
Output
Explanation
add 2
multiply 3
apply 10
36
10 + 2 * 3 = 36

Example 2
Input from file
Output
Explanation
multiply 3
add 2
apply 10
32
10 * 3 + 2 = 32

Example 3
Input from file
Output
apply 1
1
