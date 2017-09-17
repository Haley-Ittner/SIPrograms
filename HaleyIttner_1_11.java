import java.util.Scanner;
import java.util.ArrayList;
public class HaleyIttner_1_11 {

   public static void main(String[] args) {
      double checker = 1.0;
      double total = 0.0;
      double average = 0.0;
      Scanner scan = new Scanner(System.in);
      ArrayList<Double> numbers = new ArrayList<Double>();
      while(checker > 0) {
         System.out.println("Please enter a number");
         checker = scan.nextDouble();
         numbers.add(checker);
      } 
      if(numbers.size() == 1){
         System.out.println("The only number you inputted was 0. Can not do calculations.");
      } else {   
         for(int x = 0; x < numbers.size() - 1; x++) {
            total += numbers.get(x);
         }
         average = total / (numbers.size() - 1);
         System.out.println("Total Number of Lines Read: " + numbers.size());
         System.out.println("Total of the Input Values: " + total);
         System.out.println("Average of the Input Vales: " + average);   
      }           
   }
}