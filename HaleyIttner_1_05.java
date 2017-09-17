 /* This program is a modified version of assignment 2 that uses methods to take in
 the gross pay, savings rate and IRA the user inputs and calculates and outputs what
 was inputed along with the savings armount, IRA amount and the total of those two. 
 Haley Ittner
Program #5, CS 1050, Section 3
jGRASP version 2.0.3, Lenovo ThinkPad, Windows 10
Bibble - to drink often; to eat and/or drink noisily
“Vivir con miedo es como vivir a medias(A life lived in fear is a life half lived)” -Spanish Proverb
*/

import java.util.Scanner;                       
import java.util.StringTokenizer;               
public class HaleyIttner_1_05 {                 
   public static void main(String[] args) {   
      Scanner console = new Scanner(System.in); /* The scanner we will use to get the
                                                  input fromt he user */
                                                   
      double grossPay = 0.0;        // The variable that will hold the users gross pay.
      double savingsRate = 0.0;     // The variable that will hold the users savings rate
      double iraRate = 0.0;         // The variable that will hold the users ira rate.
      double savingsAmt = 0.0;      /* The savings amount that will be calculated based 
                                       on the users gross pay and savings rate */
      double iraAmt = 0.0;          /* The IRA amount that will be calculated based
                                       on the users gross pay and IRA rate. */
      
      /* The method area. Several methods are called to get the input from the user and 
         calculate the amounts needed. */
         
      explanation();                
                                      
      grossPay = numberConverter(console, "gross pay");  
                                  
      savingsRate = numberConverter(console, "savings rate");  
                                  
      iraRate = numberConverter(console, "IRA rate");  
                                  
      savingsAmt = moneyMaker(savingsRate, grossPay);  
                                 
      iraAmt = moneyMaker(iraRate, grossPay);   
                                 
      outputPrinter(grossPay, savingsRate, iraRate, savingsAmt, iraAmt);    
   } // End main
   
// ****************************************************************************
   
   // This method prints out the explanation of the program.   
   public static void explanation() {
      System.out.println("This program calculates your gross pay, savings and" +
            "investment.It will use methods in order to do this."+ "\n" + 
            "This program is made by Haley Ittner");             
   } // End explanation method
   
// ****************************************************************************
   
   // This method prompts the user to input a value and the method returns that value
   public static double numberConverter(Scanner scnr, String phrase) {
      double value = 0.0;
      do {
         System.out.println("Please input your " + phrase + ":");
         value = scnr.nextDouble();
         if (value <= 0) {
            System.out.println("You must enter a number greater than zero.");
         }
      } while (value <= 0);
      return value;           
   } // End numberConverter
   
// ****************************************************************************
   
   /* This method takes the respective money and rate to calculate the amount in
     that account */   
   public static double moneyMaker(double rate, double money) {
      double amount = (rate/100) * money;
      return amount;
   } // End of moneyMaker method
   
// ****************************************************************************
   
   /*This method prints out the values the user inputted and the amounts that we 
     calculated in the program with correspodning messages. */
   public static void outputPrinter(double sum, double rate1, double rate2, double amt1, double amt2) {
      double amtTotal = 0.0;
      System.out.println("Your input was: " + sum + ", " + rate1 + ", " + rate2);
      System.out.println("Your savings amount is: " + amt1);
      System.out.println("Your IRA savings amount is: " + amt2);
      amtTotal = amt1 + amt2;
      System.out.println("Your total savings amount is: " + amtTotal);
   } // End outputPrinter
} // End class  