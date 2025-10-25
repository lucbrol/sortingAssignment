import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/****
 ***** Created by lucag on 10/03/2025
 ***** UPDATE PROGRAM DESCRIPTION HERE
 ****/
public class sortingAlgorithmsBubble {
   // Method to generate a random array
   public static int[] generateRandom(int size, int min, int max) {
      Random random = new Random();
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
         array[i] = random.nextInt(max - min + 1) + min; // random number between min and max
      }
      return array;
   }
   public static void bubbleSortOptomised(int[] data) {
      int swapBS1 = 0, comparisonBS1 = 0;
      boolean swapped = true;
      for (int out = data.length - 1; out > 0; out--) {
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
   public static int[] readNumbers(String filename) {

      int[] numbers = new int[100]; // Array to store numbers
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


   public static void main(String [] args) {

      int [] arr100= readNumbers("random100.txt");
      int [] arr1000= readNumbers("random1000");
      int [] arr10000= readNumbers("random10000");


      // print of random 100 numbers
      System.out.println(Arrays.toString(arr100));

      // average case bubble sort
      bubbleSortOptomised(arr100);

      // bubble sort best case
      bubbleSortOptomised(arr100);

      // array in descending order
      for (int i = 0; i < arr100.length / 2; i++) {
         int temp = arr100[i];
         arr100[i] = arr100[arr100.length - 1 - i];
         arr100[arr100.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr100));

      // bubble sort in worst case scenario numbers in descending order
      bubbleSortOptomised(arr100);

      System.out.println("===============1000 random numbers bubble Sort=========");

      System.out.println(Arrays.toString(arr1000));

      // bubbleSort average case random 100 numbers
      bubbleSortOptomised(arr1000);

      // print arr1000 for best case bubbleSort
      System.out.println(Arrays.toString(arr1000));

      // bubble Sort for best case scenario array already sorted
      bubbleSortOptomised(arr1000);

      // put array in descending order
      for (int i = 0; i < arr1000.length / 2; i++) {
         int temp = arr1000[i];
         arr1000[i] = arr1000[arr1000.length - 1 - i];
         arr1000[arr1000.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr1000));

      // bubbleSort worst case scenario data in descending order
      bubbleSortOptomised(arr1000);

      System.out.println("=================10000 numbers bubble sort=============");

      // print of 10000 numbers 1-100, random for average case scenario
      System.out.println(Arrays.toString(arr10000));

      // bubbleSort average case scenario for 10000 numbers
      bubbleSortOptomised(arr10000);

      // array 1000 now in best case scenario so bubble sort again
      bubbleSortOptomised(arr10000);

      // put array in descending order for worst case scenario
      for (int i = 0; i < arr10000.length / 2; i++) {
         int temp = arr10000[i];
         arr10000[i] = arr10000[arr10000.length - 1 - i];
         arr10000[arr10000.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr10000));

      // bubblesort array for worst case scenario
      bubbleSortOptomised(arr10000);









   }//main
}//class   
