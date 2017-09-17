import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class HaleyIttner_1_08 {

   public static void main(String[] args) throws IOException {
   
      File output = new File("OutputTxt3.txt");
      File input = new File("InputTxt.txt");
      Scanner scan = new Scanner(input);
      PrintWriter writer = new PrintWriter(output);
      int lineNumber = 0;
      lineNumber = scan.nextInt();
      double[] milage = new double[lineNumber];
      double[] reimbersment = new double[lineNumber];
      double avgMiles = 0.0;
      double avgMoney = 0.0;
      double totalMoney = 0.0;
      double totalMiles = 0.0;
      int overZero = 0;
      int valid = 0;
      programExplainer(writer);
      valid = milageArray(milage, scan, lineNumber);
      totalMiles = milageCalc(milage);
      totalMoney = reimbersmentCalculator(milage, reimbersment, lineNumber);
      headerPrinter(writer);
      dataPrinter(writer, lineNumber, milage, reimbersment);
      avgMiles = averageCalc(milage, lineNumber);
      avgMoney = averageCalc(reimbersment, lineNumber);
      overZero = linesOverZero(milage);
      summaryPrinter(writer, overZero, totalMoney, valid, totalMiles, avgMoney, avgMiles);
      writer.close();  
   }
   
   public static void programExplainer(PrintWriter writer) {
      System.out.println("This program uses methods to calculate your reimbersment amount based on your milage.");
      writer.println("This program uses methods to calculate your reimbersment amount based on your milage.");
      writer.flush();
   }
   
   public static int milageArray(double[] array, Scanner scan, int length) {
      int input = 0;
      for(int x = 0; x < length && scan.hasNext(); x++) {
         array[x] = scan.nextDouble();
         input++;
      }
      return input;      
   }
   
   public static double milageCalc(double[] milage) {
      double total = 0.0;
      for(int x = 0; x < milage.length; x++) {
         if(milage[x] > 0) {
            total += milage[x];
         }
      }
      return total;      
   }
   
   public static int linesOverZero(double[] array) {
      int over = 0;
      for(int x = 0; x < array.length; x++) {
         if(array[x] > 0) {
            over++;
         }
      }
      return over;
   }        
   
   public static double reimbersmentCalculator(double[] milage, double[] reimbersment, int length) {
      double total = 0.0;
      double calcNumber = 0.0;
      double muffin = 0.0;
      for(int x= 0; x < length; x++) {
         calcNumber = milage[x];
         if(calcNumber <= 0) {
            reimbersment[x] = 0.0;               
         } else if(calcNumber < 400) {
            muffin = calcNumber *.18;
            reimbersment[x] = muffin;
         } else if(calcNumber < 900) {
            muffin = 65.0 + ((calcNumber - 400) * .15);
            reimbersment[x] = muffin;
         } else if(calcNumber < 1300) {
            muffin = 114.0 + ((calcNumber - 900) * .12);
            reimbersment[x] = muffin;
         } else if(calcNumber < 1900) {
            muffin = 140.0 + ((calcNumber - 1300) * .1);
            reimbersment[x] = muffin;
         } else if(calcNumber < 2600) {
            muffin = 165.0 + ((calcNumber - 1900) * .08);
            reimbersment[x] = muffin;
         } else {
            muffin = 195.0 + ((calcNumber - 2600) * .06);
            reimbersment[x] = muffin;
         }
         if(calcNumber > 0) {
            total += muffin;               
     }
     }
     return total;                 
   }
   
   public static void headerPrinter(PrintWriter writer) {
      System.out.println("Milage      Reimbersement");
      System.out.println("-------     -------------");
      writer.println("Milage      Reimbersement");
      writer.println("------      -------------");
      writer.flush();
   }
   
   public static void dataPrinter(PrintWriter writer, int length, double[] milage, double[] reimbersment) {
      for(int x = 0; x < length; x++) {
         if(reimbersment[x] == 0) {
            System.out.println(Toolkit.leftPad(milage[x], 7, "#,##0.0") + "             " + "*****");
            writer.println(Toolkit.leftPad(milage[x], 7, "#,##0.0") + "             " + "*****");
         } else {
            System.out.println(Toolkit.leftPad(milage[x], 7, "#,##0.0") + Toolkit.leftPad(reimbersment[x], 18, "###.00"));
            writer.println(Toolkit.leftPad(milage[x], 7, "#,##0.0") + Toolkit.leftPad(reimbersment[x], 18, "###.00"));
         }             
      }
   }
   
   public static double averageCalc(double[] array, int length) {
      double total = 0.0;   
      for(int x = 0; x < length; x++) {
         if(array[x] > 0) {
            total += array[x];
         } else {
            continue;
         }
      }
      if(length > 0) {
         return total/length;
      } else {
         System.out.println("Please enter data in order for it to be processed");
         return 0.0;               
      }
   }
   
   public static void summaryPrinter(PrintWriter writer, int numberOverZero, double totalMoney, int totalLines, 
                                          double totalMiles, double avgMiles, double avgMoney) {
      System.out.println("Total number of millage values: " + totalLines);
      System.out.println("Number of milage values over zero: " + numberOverZero);
      System.out.println("Total amount reimbersed: " + Toolkit.leftPad(totalMoney, 6, "#,##0.00"));
      System.out.println("The total miles traveled: " + Toolkit.leftPad(totalMiles, 6,"#,##0.0"));
      System.out.println("The average amount of money reimbersed: " + Toolkit.leftPad(avgMoney, 6, "#,##0.00"));
      System.out.println("The average miles traveled: " + Toolkit.leftPad(avgMiles, 6, "#,##0.0"));
      writer.println("Total number of milage values: " + totalLines);
      writer.println("Number of milage values over zero: " + numberOverZero);
      writer.println("Total amount reimbersed: " + Toolkit.leftPad(totalMoney, 6, "#,##0.0"));
      writer.println("The total miles traveled: " + Toolkit.leftPad(totalMiles, 6,"#,##0.0"));
      writer.println("The average amount of money reimbersed: " + Toolkit.leftPad(avgMoney, 6, "#,##0.00"));
      writer.println("The average miles traveled: " + Toolkit.leftPad(avgMiles, 6, "#,##0.0"));
      writer.flush();
   } 
   
   
}