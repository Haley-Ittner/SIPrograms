import java.util.Scanner;
public class HaleyIttner_1_09_Calc {
   private double grossPay;
   private double savingsRate;
   private double iraRate;
   private Scanner scan;
   
   public HaleyIttner_1_09_Calc() {
      grossPay = 0.0;
      savingsRate = 0.0;
      iraRate = 0.0;
      scan = null;   
   }
   
   public HaleyIttner_1_09_Calc(double gross, double save, double ira) {
      grossPay = gross;
      savingsRate = save;
      iraRate = ira;
      
   }
   
   public void inputMaker() {
      scan = new Scanner(System.in);
      double check1 = 0.0;
      double check2 = 0.0;
      double check3 = 0.0;
      while(check1 <= 0) {
         System.out.println("Please input your gross pay.");
         check1 = scan.nextDouble();
         if(check1 <= 0) {
            System.out.println("Please input a number greater than zero.");
         }
      }
      grossPay = check1;
      while(check2 <=0) {    
         System.out.println("Please input your savings rate.");
         check2 = scan.nextDouble();
         if(check2 <= 0) {
            System.out.println("Please input a number greater than zero.");
         }
      }   
      savingsRate = check2;
      while(check3<= 0) {
         System.out.println("Please input your IRA rate.");
         check3 = scan.nextDouble();
         if(check3 <= 0) {
            System.out.println("Please input a number greater than zero.");
         }
      }
      iraRate = check3;
   }
   
   public void inputOutputter() {
      System.out.println("Your gross pay: " + Toolkit.leftPad(grossPay, 10, "#,##0.00"));
      System.out.println("Your savings rate: " + savingsRate);
      System.out.println("Your IRA rate: " + iraRate);
   }
   
   public double savingsAmount() {
      return (savingsRate/100) * grossPay;
   }
   
   public double iraAmount() {
      return (iraRate/100) * grossPay; 
   }                      
}