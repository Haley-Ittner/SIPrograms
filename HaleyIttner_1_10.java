import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
public class HaleyIttner_1_10 {

   public static void main(String[] args) throws IOException {

      EmployeeParameters param = new EmployeeParameters();
      param.getEmployeeParameters();   
      param.displayEmployeeParameters(); 
      System.out.println();  
      Employee[] empl = new Employee[param.maxEmployees];
      File input = new File("EmployeeInput.txt");
      File output = new File("EmployeeOutput.txt");
      Scanner console = new Scanner(input);
      PrintWriter pen = new PrintWriter(output);
      int x = 0;
      int y = 0;
      int z = 0;
      int lines = 0;
      int inputLines = 0;
      int alphebet = 0;
      int gross = 0;
     
      printHeader("Regular Input", pen);
   
      while(console.hasNext() && x < empl.length) {
         Employee person = new Employee();
         makeEmployee(console, person);
         calcRightGrossPay(person);
         calcAmounts(param, person);
         printDeats(person, pen);
         empl[x] = person;
         lines++;
         x++;
      }
      
      if(console.hasNext()) {
         inputLines++;
         console.nextLine();
      }
         if(inputLines > 0) {
            System.out.println("You have too many employees!");
            System.exit(0);
         }   
      printTotals(empl, lines, pen);
      
      alphebet = Toolkit.selectionSortArrayOfClass(empl, lines, "Name");
      System.out.println("");
      pen.println("");
      printHeader("Alphebetical", pen);
      while(y < lines) {
         printDeats(empl[y], pen);
         y++;
      }  
      printTotals(empl, lines, pen);
      
      gross = Toolkit.selectionSortArrayOfClass(empl, lines, "Gross Pay" );
      System.out.println("");
      pen.println("");
      printHeader("Decending Gross Pay", pen);
      while(z < lines) {
         printDeats(empl[z], pen);
         z++;
      }
      printTotals(empl, lines, pen);
      console.close();
      pen.close();
}

   public static void makeEmployee(Scanner scan, Employee person) {
      person.hoursWorked = scan.nextDouble();
      person.payRate = scan.nextDouble();
      person.name = scan.nextLine();
      person.name = person.name.trim();
   }
      
   public static void calcRightGrossPay(Employee person) {
      if((person.payRate == 0) || (person.hoursWorked == 0)) {
         person.grossPay = 0.0;
      } else if(person.hoursWorked <= 40) {
          person.grossPay = person.hoursWorked * person.payRate;
      } else if(person.hoursWorked > 40 && person.hoursWorked <= 50) {
         person.grossPay = (40 * person.payRate) + ((person.hoursWorked - 40) * person.payRate * 1.5);
      } else {
         person.grossPay = (10 * person.payRate * 1.5) + ((person.hoursWorked - 50) * person.payRate * 2);
      }         
   }
      
   public static void calcAmounts(EmployeeParameters parm, Employee person) {
      person.iraAmount = (person.grossPay * parm.iraRate)  / 100;
	   person.adjustedGrossPay = person.grossPay - person.iraAmount;
	   person.taxAmount = person.adjustedGrossPay * ((parm.federalWithholdingRate + parm.stateWithholdingRate) / 100);
	   person.netPay = person.adjustedGrossPay - person.taxAmount;
	   person.savingsAmount = (person.netPay * parm.savingsRate) / 100;
   }
   
   public static void printHeader(String title, PrintWriter write) {
      System.out.println(title);
      System.out.println("\t\tMobile Apps Galore, Inc. - Payroll Report\n");
      System.out.println("Name               Gross Pay   Net Pay   Wealth Taxes       Hours   Pay Rate");
      System.out.println("------------------ ---------   -------   ------ ---------   ------- --------"); 
      write.println(title);
      write.println("\t\tMobile Apps Galore, Inc. - Payroll Report\n");
      write.println("Name               Gross Pay   Net Pay   Wealth Taxes       Hours   Pay Rate");
      write.println("------------------ ---------   -------   ------ ---------   ------- --------"); 
      write.flush();
   }
   
   public static void printDeats(Employee emp, PrintWriter pen) {
      System.out.println(Toolkit.padString(emp.name,18) + 
                Toolkit.leftPad(emp.grossPay, 10, "$#,##0.00") +
                Toolkit.leftPad(emp.netPay, 10, "$#,##0.00") +
                Toolkit.leftPad((emp.grossPay - emp.netPay), 9, "$#,##0.00") +
                Toolkit.leftPad(emp.taxAmount, 10, "$#,##0.00") + 
                Toolkit.leftPad(emp.hoursWorked, 10, "0.0") +
                Toolkit.leftPad(emp.payRate, 9, "$#,##0.00"));
      pen.println(Toolkit.padString(emp.name,18) + 
                Toolkit.leftPad(emp.grossPay, 10, "$#,##0.00") +
                Toolkit.leftPad(emp.netPay, 10, "$#,##0.00") +
                Toolkit.leftPad((emp.grossPay - emp.netPay), 9, "$#,##0.00") +
                Toolkit.leftPad(emp.taxAmount, 10, "$#,##0.00") + 
                Toolkit.leftPad(emp.hoursWorked, 10, "0.0") +
                Toolkit.leftPad(emp.payRate, 9, "$#,##0.00"));          
      pen.flush();
   }
   
   
   public static void printTotals(Employee[] doof, int lines, PrintWriter pen) {
      double sumGrossPay = 0.0;
      double sumNetPay = 0.0;
      double sumWealth = 0.0;
      double sumTaxAmount = 0.0;
      double sumHoursWorked = 0.0;
      double sumPayRate = 0.0;
      double avgPayRate = 0.0;
      for(int x = 0; x < lines; x++) {
         sumGrossPay += doof[x].grossPay;
         sumNetPay += doof[x].netPay;
         sumWealth += doof[x].savingsAmount; 
         sumWealth += doof[x].iraAmount;
         sumTaxAmount += doof[x].taxAmount;
         sumHoursWorked += doof[x].hoursWorked;
         sumPayRate += doof[x].payRate;   
      }
      avgPayRate = sumPayRate / lines;
      System.out.println(Toolkit.padString("Totals: ",18) + 
                Toolkit.leftPad(sumGrossPay, 10, "$#,##0.00") +
                Toolkit.leftPad(sumNetPay, 10, "$#,##0.00") +
                Toolkit.leftPad((sumWealth), 9, "$#,##0.00") +
                Toolkit.leftPad(sumTaxAmount, 10, "$#,##0.00") + 
                Toolkit.leftPad(sumHoursWorked, 10, "0.0") +
                "\n\t\t\t\t\t\t     Average Pay Rate: " +
                Toolkit.leftPad(avgPayRate, 3, "0.00"));
     pen.println(Toolkit.padString("Totals: ",18) + 
                Toolkit.leftPad(sumGrossPay, 10, "$#,##0.00") +
                Toolkit.leftPad(sumNetPay, 10, "$#,##0.00") +
                Toolkit.leftPad((sumWealth), 9, "$#,##0.00") +
                Toolkit.leftPad(sumTaxAmount, 10, "$#,##0.00") + 
                Toolkit.leftPad(sumHoursWorked, 10, "0.0") +
                "\n\r  Average Pay Rate: " +
                Toolkit.leftPad(avgPayRate, 3, "0.00")); 
    pen.flush();                      
   }       
}