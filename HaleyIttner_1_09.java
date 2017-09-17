import java.util.Scanner;
public class HaleyIttner_1_09 {
   public static void main(String[] args) {
      double savingsAmount = 0.0;
      double iraAmount = 0.0;
      explanation();
      HaleyIttner_1_09_Calc calculator = new HaleyIttner_1_09_Calc();
      Scanner scan = new Scanner(System.in);
      calculator.inputMaker();
      savingsAmount = calculator.savingsAmount();
      iraAmount = calculator.iraAmount();
      calculator.inputOutputter();
      summary(savingsAmount, iraAmount);         
   }
   
   public static void explanation() {
      System.out.println("This program uses methods and a seperate class to calculate your gross pay, savings amount and IRA amount.");
   }
   
   public static void summary(double amount, double another) {
      double total = 0.0;
      System.out.println("Your savings amount: " + Toolkit.leftPad(amount, 10, "#,##0.00"));
      System.out.println("Your IRA amount: " + Toolkit.leftPad(another, 10, "#,##0.00"));
      total = amount + another;
      System.out.println("Your total money in your accounts: " + Toolkit.leftPad(total, 10, "#,##0.00"));
  }   
}      