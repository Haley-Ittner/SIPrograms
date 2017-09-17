import java.util.Scanner;
public class HaleyIttner_1_02 {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double grossPay = 0.0;
      double savingsRate = 0.0;
      double iraRate = 0.0;
      double savings = 0.0;
      double investment = 0.0;
      double total = 0.0;
      
      System.out.println("This program calculates your gross pay, savings and investment.");
      
      System.out.print("Input your gross pay");
      grossPay = scnr.nextDouble();
      System.out.print("Input your savings percentage rate");
      savingsRate = scnr.nextDouble();
      System.out.print("Input your IRA investment percentage rate");
      iraRate = scnr.nextDouble();
      
      savings = (savingsRate/100) * grossPay;
      investment = (iraRate/100) * grossPay;
      total = savings + investment;
      
      System.out.println("Your gross pay is " + grossPay + ".");
      System.out.println("Your saving percentage rate is " + savingsRate + ".");
      System.out.println("Your IRA investment percentage rate is " + iraRate + ".");
      System.out.println("Your savings account has " + savings + " dollars.");
      System.out.println("Your IRA account has " + investment + " dollars.");
      System.out.println("Your combined amount in both accounts is " + total + " dollars.");
      System.out.println("Haley Ittner");
      
      scnr.close();
      System.exit(0);
      }
}      
      
      