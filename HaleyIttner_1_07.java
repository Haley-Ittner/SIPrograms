import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
public class HaleyIttner_1_07 {

   public static void main(String[] args) throws IOException {
      File input = new File("Assignment6.txt");
      File output = new File("OutputFile2.txt");
      PrintWriter writer = new PrintWriter(output);
      Scanner reader = new Scanner(input);
      String message = "";
      int grade = 0;
      double average = 0.0;
      double averageC = 0.0;
      String name = "";
      int lines = 0;
      int numberBetweenC = 0;
      Double[] list = new Double[3];
   
      headerMaker(writer);
   
      while(reader.hasNext()) {
         grade = reader.nextInt();
         name = reader.nextLine();
         name = name.trim();
         message = messageFinder(grade);
         linePrinter(writer, grade, name, message);
         if(grade >= 70 && grade <= 89) {
            averageC += grade;
            numberBetweenC++;
         }
         average += grade;    
         lines++;      
      }
      average = average/lines;
      averageC = averageC/numberBetweenC;
      summaryPrinter(writer, lines, numberBetweenC, average, averageC);
      writer.close();   
      }
      
      public static void headerMaker(PrintWriter writer) {
         System.out.println("Name\t\t\t\tGrade\t\t   Message");
         System.out.println("----------------\t\t-----\t\t   ------------");
         writer.println("Name\t\t\t\tGrade\t\t   Message");
         writer.println("----------------\t\t-----\t\t   ------------");
         writer.flush();
      }
   
      public static String messageFinder(int grade) {
         String message = "";
         if(grade >= 90) {
            message = "OUTSTANDING!";
            return message;
         } if(grade >= 70) {
            message = "Satisfactory";
            return message;
         } else {
            message = "Failing";
            return message;            
         }          
      }
   
      public static void linePrinter(PrintWriter writer, int grade, String name, String message) {
         System.out.println(Toolkit.padString(name, 33) + Toolkit.rightPad(grade, 18, "0") + message);
         writer.println(Toolkit.padString(name, 33) + Toolkit.rightPad(grade, 18, "0") + message);
         writer.flush();
      }
                     
      
      public static void summaryPrinter(PrintWriter writer, int lines, int betweenC, double averageAll, double averageC) {
         System.out.println("Number of lines processed: " + lines);
         System.out.println("Number of grades between 70 and 89 inclusively: " + betweenC);
         System.out.println("Average of those between 70 and 89: " + Toolkit.leftPad(averageC, 3, "0.0"));
         System.out.println("Average grade of all students: " + Toolkit.leftPad(averageAll, 3, "0.0"));
         writer.println("Number of lines processed: " + lines);
         writer.println("Number of grades between 70 and 89 inclusively: " + betweenC);
         writer.println("Average of those between 70 and 89: " + Toolkit.leftPad(averageC, 3, "0.0"));
         writer.println("Average grade of all students: " + Toolkit.leftPad(averageAll, 3, "0.0"));
         writer.flush();
      }
}