/* This program uses JOPtionPanes to communicate with the user to get their gross pay, IRA rate and savings rate in order to calculate
   their savings amount, IRA amount and the total of those two accounts. It then outputs these into another JOptionPane. 
   Haley Ittner
   Program #2, CS 1050, Section 3 
   JGrasp 2.0.3, Lenovo ThinkPad, Windows 10
   AGASTOPIA - admiration of a particular part of someone’s body
   "Vivir con miedo es como vivir a medias(A life lived in fear is a life halfed lived)" Spanish Proverb
*/
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
public class HaleyIttner_1_03 {
   public static void main(String[] args) {
      double grossPay = 0.0;
      double savingsRate = 0.0;
      double iraRate = 0.0;
      double savings = 0.0;
      double investment = 0.0;
      double total = 0.0;
      String dialogue = "";
      String newGross = "";
      String newSaveRate = "";
      String newIraRate = "";
      String newSaveAmt = "";
      String newInvest = "";
      String newTotal = "";
      StringTokenizer token;
      DecimalFormat formatter = new DecimalFormat("$#,##0.00");
      DecimalFormat formatter2 = new DecimalFormat("0.00");
      
      
      //Prompts user for gross pay, savings rate and IRA rate and puts them into double variables
      dialogue = JOptionPane.showInputDialog("Enter gross pay, saving rate and IRA rate seperated by spaces.");
      token = new StringTokenizer(dialogue);
      grossPay = Double.parseDouble(token.nextToken());
      savingsRate = Double.parseDouble(token.nextToken());
      iraRate = Double.parseDouble(token.nextToken());
      
      //Calculate the savings and IRA amounts
      savings = (savingsRate/100) * grossPay;
      investment = (iraRate/100) * grossPay;
      total = savings + investment;
   
      //Format all the variables to have the dollar sign and 2 decimal places
      newGross = formatter.format(grossPay);
      newSaveRate = formatter2.format(savingsRate);
      newIraRate = formatter2.format(iraRate);
      newSaveAmt = formatter.format(savings);
      newInvest = formatter.format(investment);
      newTotal = formatter.format(total); 
      
      //Print gross pay, savings rate, IRA rate, savings amount, IRA amount, and the total of those two.
      JOptionPane.showMessageDialog(null, "Your gross pay is " + newGross + 
      ", your saving percentage rate is " + newSaveRate + 
      ", and your IRA percentage rate is " + newIraRate + "." + 
      '\n' + "Your savings account has " + newSaveAmt + "." + '\n' + 
      "Your IRA account has " + newInvest + "." + '\n' + 
      "Your accounts have a total of " + newTotal + "." + '\n' + "Haley Ittner");
   }//End main
}// End class