import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.text.DecimalFormat;
public class HaleyIttner_1_04 {
   public static void main(String[] args) throws IOException {
      Scanner poof = null;
      PrintWriter doof = null;
      String name = "myNumbers.txt";
      String bah = "OutputFile.txt";
      File fish = new File(name);
      File poop = new File(bah);
      ArrayList<Double> fleep = new ArrayList<Double>();
      double superSavings = 0.00;
      double avSavings = 0.0;
      double superIRA = 0.00;
      double avIRA = 0.0;
      double superGross = 0.00;
      double avGross = 0.00;
      int lines = 0;
      poof = new Scanner(fish); 
      doof = new PrintWriter(poop);          
      while (poof.hasNextDouble()) {
         fleep.add(poof.nextDouble());        
      }
      ArrayList<Double> floop = new ArrayList<Double>();
      ArrayList<Double> boop = new ArrayList<Double>();
      for(int x = 0; x < fleep.size() - 2; x += 3) {
         if(fleep.get(x) > 0 && fleep.get(x + 2) > 0 && fleep.get(x + 2) > 0){
            double gorge = fleep.get(x);
            double maul = fleep.get(x + 1)/100;
            double mullard = gorge * maul; 
            floop.add(mullard);
            double bipped = fleep.get(x);
            double bopped = fleep.get(x + 2)/100;
            double gloawed = bopped * bipped;
            floop.add(gloawed);
            floop.add(0.0);
            superGross += fleep.get(x);
            lines += 1;
            boop.add(fleep.get(x));
            boop.add(fleep.get(x + 1));
            boop.add(fleep.get(x + 2));
            } 
      }        
      for(int x = 0; x < floop.size() - 1; x += 2) {
         superSavings += floop.get(x);
         superIRA += floop.get(x + 1);
      }
      if(lines > 0) {
         avGross = superGross/lines;
         avSavings = superSavings/lines;
         avIRA = superIRA/lines; 
      } else {
         System.out.print("No input given");
      }
      DecimalFormat format = new DecimalFormat("0.00");
      DecimalFormat other = new DecimalFormat("0.0");
      Object[][] bacon = new String[8][];
      int count = 2;
      for(int x = 0; x < bacon.length; x ++) {
         bacon[x] = new String[] {format.format(boop.get(count - 2)), other.format(boop.get(count - 1)), format.format(floop.get(count - 2)), 
         other.format(boop.get(count)), format.format(floop.get(count - 1))};
         count += 3; 
      }
      System.out.println("Gross Pay   Savings Rate   Savings Amount   IRA Rate   IRA Amount");
      doof.println("Gross Pay   Savings Rate   Savings Amount   IRA Rate     IRA Amount");
      for(final Object[] chickens : bacon) {
         System.out.format("%-15s%-15s%-15s%-15s%-15s\n", chickens);
         doof.format("%-15s%-15s%-15s%-15s%-15s\r\n", chickens);
      }
      System.out.println("Number of lines read: " + lines);
      doof.println("Number of lines read: " + lines);
      System.out.println("Gross pay sum: " + superGross);
      System.out.println("Savings amount sum: " + format.format(superSavings));
      System.out.println("IRA amount sum: " + superIRA);
      doof.println("Gross pay Sum: " + superGross);
      doof.println("Savings amount sum: " + format.format(superSavings));
      doof.println("IRA amount sum: " + superIRA);
      System.out.println("Average gross pay: " + avGross);
      System.out.println("Average savings amount: " + format.format(avSavings));
      System.out.print("Average IRA amount: " + other.format(avIRA));
      doof.println("Average gross pay: " + avGross);
      doof.println("Average savings amount: " + format.format(avSavings));
      doof.print("Average IRA amount: " + avIRA);
      doof.flush();
      doof.close();                    
   }
}