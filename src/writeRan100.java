import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

/****
 ***** Created by lucag on 13/03/2025
 ***** UPDATE PROGRAM DESCRIPTION HERE
 ****/
public class writeRan100 {
   public static int[] generateRandom() {
      int [] num = new int [10000];
      int min = 1;
      int max = 100;

      for (int i = 0; i< num.length; i++){
         num[i]= (int)(Math.random() * (max - min + 1) + min);
      }
      return num;
   }
   public static void writeNumbers(int[] numbers) {
      try (FileWriter fw = new FileWriter("random10000.txt");
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw)) {

         for (int number : numbers) {
            pw.println(number);
         }

         System.out.println("Random numbers written to random 10000.txt");

      } catch (IOException e) {
         System.out.println("An error occurred: " + e.getMessage());
      }
   }
   public static void main(String [] args)  {

//      int [] ran100= generateRandom();
//
//      System.out.println(Arrays.toString(ran100));
//
//      writeNumbers(ran100);

      int [] ran10000= generateRandom();

      System.out.println(Arrays.toString(ran10000));

      writeNumbers(ran10000);




   }//main
}//class   
