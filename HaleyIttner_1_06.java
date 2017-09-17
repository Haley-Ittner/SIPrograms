import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
public class HaleyIttner_1_06 {
   

   public static void main(String[] args) throws IOException {
      File input = new File("InputTxt.txt");
      File output = new File("Chickens.txt");
      Scanner scan = new Scanner(input);
      PrintWriter writer = new PrintWriter(output);
      double moneyBack = 0.0;
      String invalid = "*****";
      double start = 0.0;
      int count = 0;
      double current = 0.0;
      double total = 0.0;
      int validLine = 0;
            
      headerPrinter(writer);
      start = scan.nextDouble();
      
      while(count < start){
         current = scan.nextDouble();
         if(current < 400) {
            moneyBack = current *.18;
         } else if(current < 900) {
            moneyBack = 65.0 + ((current - 400) * .15);
         } else if(current < 1300) {
            moneyBack = 114.0 + ((current - 900) * .12);
         } else if(current < 1900) {
            moneyBack = 140.0 + ((current - 1300) * .1);
         } else if(current < 2600) {
            moneyBack = 165.0 + ((current - 1900) * .08);
         } else {
            moneyBack = 195.0 + ((current - 2600) * .06);
         }
         if (current > 0) {
            System.out.println(Toolkit.leftPad(current, 7, "#,##0.0") + Toolkit.leftPad(moneyBack, 18, "###.00"));
            writer.println(Toolkit.leftPad(current, 7, "#,##0.0") + Toolkit.leftPad(moneyBack, 18, "###.00"));
            total += moneyBack;
            validLine++;
             
         } else {
            System.out.println(Toolkit.leftPad(current, 7, "#,##0.0") + "             " + invalid);
            writer.println(Toolkit.leftPad(current, 7, "#,##0.0") + "             " + invalid);
         }                  
         count++;
      }
      summaryPrinter(writer, validLine, total, start);
      writer.close();    
   }
   
   public static void headerPrinter(PrintWriter writer) {
      System.out.println("Milage      Reimbersement");
      System.out.println("-------     -------------");
      writer.println("Milage      Reimbersement");
      writer.println("------      -------------");
      writer.flush();
   }
   
   public static void summaryPrinter(PrintWriter writer, int numberOverZero, double totalMoney, double totalLines) {
      System.out.println("Total number of millage values: " + Toolkit.leftPad(totalLines, 3, "0"));
      System.out.println("Number of milage values over zero: " + numberOverZero);
      System.out.println("Total amount reimbersed: " + Toolkit.leftPad(totalMoney, 8, "#,##0.0"));
      writer.println("Total number of milage values: " + Toolkit.leftPad(totalLines, 3, "0"));
      writer.println("Number of milage values over zero: " + numberOverZero);
      writer.println("Total amount reimbersed: " + Toolkit.leftPad(totalMoney, 8, "#,##0.0"));
      writer.flush();
   }   
}