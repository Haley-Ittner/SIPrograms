import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.text.DecimalFormat;
public class HaleyIttner_1_04Redo {
   public static void main(String[] args) throws IOException {
      Scanner scnr = null;
      PrintWriter writer = null;
      String input = "myNumbers.txt";
      String output = "OutputFile.txt";
      File inputFile = new File(input);
      File outputFile = new File(output);
      double superSavings = 0.00;
      double avSavings = 0.0;
      double superIRA = 0.00;
      double avIRA = 0.0;
      double superGross = 0.00;
      double avGross = 0.00;
      double savings = 0.0;
      double gross = 0.0;
      double ira = 0.0;
      double saveAmount = 0.0;
      double iraAmount = 0.0;
      int lines = 0;
      String outputLn = "";
      scnr = new Scanner(inputFile); 
      writer = new PrintWriter(outputFile);
      DecimalFormat format = new DecimalFormat("#,##0.00");
      DecimalFormat other = new DecimalFormat("0.0"); 
      System.out.println("Gross Pay   Savings Rate   Savings Amount   IRA Rate   IRA Amount");  
      writer.println("Gross Pay   Savings Rate   Savings Amount   IRA Rate   IRA Amount");         
      while (scnr.hasNextDouble()) {
         gross = scnr.nextDouble();
         savings = scnr.nextDouble();
         ira = scnr.nextDouble();
         if(gross > 0 && savings > 0 && ira > 0) {
            saveAmount = gross * (savings/100);
            iraAmount = gross * (ira/100);
            outputLn = String.format("%-15s", format.format(gross)) + String.format("%-16s",other.format(savings)) + 
            String.format("%-15s",format.format(saveAmount))
            + String.format("%-10s", other.format(ira)) + format.format(iraAmount);
            lines += 1;
            superSavings += saveAmount;
            superIRA += iraAmount;
            superGross += gross;
            System.out.println(outputLn);
            writer.println(outputLn); 
         }           
      }
      avSavings = superSavings/lines;
      avIRA = superIRA/lines;
      avGross = superGross/lines;
      System.out.println("Number of lines read: " + lines);
      writer.println("Number of lines read: " + lines);
      System.out.println("Gross pay sum: " + format.format(superGross));
      System.out.println("Savings amount sum: " + format.format(superSavings));
      System.out.println("IRA amount sum: " + format.format(superIRA));
      writer.println("Gross pay Sum: " + format.format(superGross));
      writer.println("Savings amount sum: " + format.format(superSavings));
      writer.println("IRA amount sum: " + format.format(superIRA));
      System.out.println("Average gross pay: " + format.format(avGross));
      System.out.println("Average savings amount: " + format.format(avSavings));
      System.out.print("Average IRA amount: " + format.format(avIRA));
      writer.println("Average gross pay: " + format.format(avGross));
      writer.println("Average savings amount: " + format.format(avSavings));
      writer.print("Average IRA amount: " + format.format(avIRA));
      writer.flush();
      writer.close();                            
   }
}
// Confused about what to calculate and what to output. Also \r\n works not \n\r