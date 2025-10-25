import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/****
 ***** Created by lucag on 24/02/2025
 ***** UPDATE PROGRAM DESCRIPTION HERE
 ****/
public class readWriteNumbers {

   public static int[] generateRandom() {
      int [] num = new int [100];
      int min = 1;
      int max = 100;

      for (int i = 0; i< num.length; i++){
         num[i]= (int)(Math.random() * (max - min + 1) + min);
      }
      return num;
   }
   public static void writeNumbers(int[] numbers) {
      try (FileWriter fw = new FileWriter("tenNumbers.txt");
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw)) {

         for (int number : numbers) {
            pw.println(number);
         }

         System.out.println("Random numbers written to 100Search.txt");

      } catch (IOException e) {
         System.out.println("An error occurred: " + e.getMessage());
      }
   }
   public static int[] readNumbers(String filename) {

      int[] numbers = new int[10]; // Array to store numbers
      try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {//use reader
         String line; // create string
         int index = 0; // index for array
         while ((line = reader.readLine()) != null && index < 100) {
            numbers[index++] = Integer.parseInt(line.trim()); // Convert string to int
         }
      } catch (IOException | NumberFormatException e) {
         System.err.println("Error reading from file: " + e.getMessage());
      }
      return numbers;

   }
   public static void bubbleSort(int[] data) {  // bubble sort method for int []
      int swapBS = 0, comparisonBS = 0;
      for (int out = data.length - 1; out > 0; out--) {
         for (int in = 0; in < out; in++) {
            comparisonBS++;
            if (data[in] > data[in + 1]) {
               int tmp = data[in];        // swap items
               data[in] = data[in + 1];    //
               data[in + 1] = tmp;        //
               swapBS++;
            }
         }
         for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
         System.out.println();

      }

      System.out.println("swapsBS=" + swapBS);
      System.out.println("ComparisonsBS= " + comparisonBS);
   }
   public static void bubbleSortOptomised(int[] data) {
      int swapBS1 = 0, comparisonBS1 = 0;
      boolean swapped = true;
      for (int out = data.length-1; out > 0; out--) {
         swapped = false;
         for (int in = 0; in < out; in++) {
            comparisonBS1++;
            if (data[in] > data[in + 1]) {
               swapped = true;
               int tmp = data[in];        // swap items
               data[in] = data[in + 1];    //
               data[in + 1] = tmp;        //
               swapBS1++;
            }
         }
         for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
         System.out.println();
         if (swapped == false)
            out = 0;
      }
      System.out.println("swapsBS=" + swapBS1);
      System.out.println("ComparisonsBS= " + comparisonBS1);
   }






   public static void main(String [] args) {

    //  int [] tenNumbers= generateRandom();

     // System.out.println(Arrays.toString(tenNumbers));  // print 10 numbers random 1-100

   //   writeNumbers(tenNumbers);  // call to write numbers method to store ten numbers
                                  // array in text file tenNumbers.txt

       // average case
      int [] average=readNumbers("tenNumbers.txt"); // call to readNumbers from tenNumbers.txt
      System.out.println("Average case");
      System.out.println(Arrays.toString(average)); // new array created to store same numbers

         //best case
      int [] best= readNumbers("tenNumbers.txt");
      System.out.println("Best case");
      Arrays.sort(best);
      System.out.println(Arrays.toString(best));

      // worst case
      System.out.println("Worst case");
      int [] worst= {95,90,89,58,34,28,28,24,22,6};
      System.out.println(Arrays.toString(worst));

      System.out.println();

      System.out.println("BubbleSort best");
      bubbleSort(best);

      System.out.println("BubbleSort Average");
      bubbleSort(average);

      System.out.println("BubbleSort worst");
      bubbleSort(worst);

      System.out.println("================================");













   }//main
}//class   
