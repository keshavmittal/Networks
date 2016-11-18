# Networks

2.<Bit Stuffing> Write a program that has two methods/functions, namely,

a) Method/function that generates a bit stream from a text file with bit stuffing. Recall that for
bit stuffing, an extra 0 bit is added after every five consecutive ones. Your method should
read a text file consisting of alphanumeric characters, white spaces and punctuations,
convert the data into binary values using ASCII codes (http://www.asciitable.com/), and
then generate the binary sequence after bit stuffing.

b) Another method/function that takes a bit stream with stuffed bits, removes the stuffed bits,
converts the bits into ASCII codes and generates text file.
Test your program using a random gibberish text file given below (Source:
RandomTextGenerator.com). If you have done it correctly, the output file that you get after
converting to binary and reconverting it back to ASCII must be the same as the input file. (NOTE:
Make sure that all characters including spaces and new lines are converted to binary).

3.<CRC question>

a) Given a 12-bit sequence 110100111101 and a divisor of 1011, find the CRC and the transmitted
string.

b) Given a remainder of 101, a transmitted data unit of 10110011101, and a divisor of 1001, is there
an error in the data unit. Show all steps.

c) Implement the sending and receiving CRC protocol by writing program routines
(functions/methods) for each of the following:
a. Given a bit string, compute the CRC remainder and generate the bit string to be
transmitted.
b. Given a bit string with CRC remainder appended, divide by G(x) and determine if
the message is error-free.
Use the codes in a test program, assuming values of G(x) and the input string, and demonstrate its
operation and error detection.
You can implement either the long division or the shift register version.

d) Use the program in (c) to run the following experiment. Use the standard CRC-32 generator
polynomial. Generate a random binary number of 1520 bytes. This will be your frame. Find the remainder
(4 bytes). Now introduce a random burst error of length = 32 bits in the frame of 1524 bytes. Check to see if
the error is detected.
Repeat the above experiment a 1000 times, that is, generate a 1000 frames. For each frame, generate a
random burst error of some length (< 32 bits, = 32 bits or > 32 bits). Determine how many times the errors
are detected. Make a table such as the one given below:
Burst error length Number of frames Number of frames in which error
was detected
< 32 bits
= 32 bits
> 32 bits
You should notice that in almost a 100 % of the cases, the errors were detected by CRC.
