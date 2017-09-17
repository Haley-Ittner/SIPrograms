/* Interactive Average Program   	This program asks the user to input two real numbers,   	calculates the average of these numbers, and prints the results
    Your name
    Program #1, CS 1050, Section S    (replace “S” with your section number) 
    Version of your Integrated Development Environment (IDE), computer and operating system
    A new vocabulary word (not computer-related) and its meaning
    Inspirational quote – not religious or political – along with the source and the person’s year of birth [and death]
 	written as, for example, (1912 – 1987) or, if the person is still alive, (b. 1949)
 */

import java.util.Scanner;

public class HaleyIttner_1_01 {

public static void main (String [ ] args)  { 

		Scanner console = new Scanner(System.in);
		double num1 = 0.0;				// Input value 1
		double num2 = 0.0;	             	// Input value 2
		double average = 0.0;			// Average of the input values

		// Explain the program to the user
		System.out.println("This program averages two real numbers.");

		// Input the two numbers 
		System.out.print("Input your first number: "); 
		num1 = console.nextDouble();
		System.out.print("Input your second number: ");
		num2 = console.nextDouble();

		// Calculate the average of the two numbers
		average = (num1 + num2) / 2.0;

		// Output the results
		System.out.print("The average of " + num1);
		System.out.println(" and " + num2 + " is " + average);
		System.out.println("your name");

		// Close files and exit
		console.close();
		System.exit(0);
	} // End main
} // End class
