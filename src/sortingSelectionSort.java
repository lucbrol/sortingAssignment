import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/****
 ***** Created by lucag on 11/03/2025
 ***** UPDATE PROGRAM DESCRIPTION HERE
 ****/
public class sortingSelectionSort {


   public static void selectionSort(int data[]) {
      int in, out, min;
      int comparisonSS = 0, swapSS = 0;
      for (out = 0; out < data.length - 1; out++) {
         min = out;
         for (in = out + 1; in < data.length; in++) {
            comparisonSS++;    // count comparisons
            if (data[in] < data[min]) {
               min = in;  // new minimum

            }
         }
         if(min!=out) {   // swap only if the minimum index has changed
            int tmp = data[out];
            data[out] = data[min];
            data[min] = tmp;
            swapSS++; // count swaps only when a swap occurs
         }
      }
      System.out.println("swapsSS=" + swapSS);
      System.out.println("ComparisonsSS= " + comparisonSS);
   }
   public static long timeSelectionSortMethod(int[] array) {
      long startTime = System.nanoTime();
      selectionSort(array);
      long endTime = System.nanoTime();
      return endTime - startTime;
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

      int [] arr100S= readNumbers("random100.txt");


      // print array arr100S which shows random 100 numbers for average case scenario
      System.out.println("Array of random 100 numbers");
      System.out.println(Arrays.toString(arr100S));

      // Section sort for  average case scenario
      System.out.println("Average case");
      System.out.println("Time for selection sort on 100 numbers average case is:" + timeSelectionSortMethod(arr100S)+ "nanoseconds");
      System.out.println();

      System.out.println("Best case");
      System.out.println(Arrays.toString(arr100S));
      System.out.println("Time for selection sort on 100 numbers best case is:" + timeSelectionSortMethod(arr100S)+ "nanoseconds");

      System.out.println();

      System.out.println("Worst case");
      // put array in descending order for worst case scenario
      for (int i = 0; i < arr100S.length / 2; i++) {
         int temp = arr100S[i];
         arr100S[i] = arr100S[arr100S.length - 1 - i];
         arr100S[arr100S.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr100S));
      // SelectionSort array for worst case scenarios
      System.out.println("Time for selection sort on 100 numbers worst case is:" + timeSelectionSortMethod(arr100S)+ "nanoseconds");
      System.out.println("=============");

      System.out.println();

      System.out.println("===============SectionSort for 1000 numbers =============");
      int [] arr1000S= new int [1000];
      try (BufferedReader reader = new BufferedReader(new FileReader("random1000.txt"))) {//use reader
         String line; // create string
         int index = 0; // index for array
         while ((line = reader.readLine()) != null && index < 1000) {
            arr1000S[index++] = Integer.parseInt(line.trim()); // Convert string to int
         }
      } catch (IOException | NumberFormatException e) {
         System.err.println("Error reading from file: " + e.getMessage());
      }

      // print arr1000 to show numbers in random order
      System.out.println("Average case");
      System.out.println(Arrays.toString(arr1000S));
      // selectionSort to show average case scenario
      System.out.println("Time for selection sort on 1000 numbers average case is:" + timeSelectionSortMethod(arr1000S)+ "nanoseconds");
      System.out.println();

      System.out.println("best case");
      //  Print Array sorted perform selection sort for best case scenario
      System.out.println(Arrays.toString(arr1000S));
      System.out.println("Time for selection sort on 1000 numbers best case is:" + timeSelectionSortMethod(arr1000S)+ "nanoseconds");
      System.out.println();

      System.out.println("Worst case");
      // Put array in descending order to show worst case scenario
      for (int i = 0; i < arr1000S.length / 2; i++) {
         int temp = arr1000S[i];
         arr1000S[i] = arr1000S[arr1000S.length - 1 - i];
         arr1000S[arr1000S.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr1000S));
      System.out.println("Time for selection sort on 1000 numbers worst case is:" + timeSelectionSortMethod(arr1000S)+ "nanoseconds");
      System.out.println();

      System.out.println("==============SelectionSort for 10000 =========== ");
      int [] arr10000S= new int [10000];
      try (BufferedReader reader = new BufferedReader(new FileReader("random10000.txt"))) {//use reader
         String line; // create string
         int index = 0; // index for array
         while ((line = reader.readLine()) != null && index < 10000) {
            arr10000S[index++] = Integer.parseInt(line.trim()); // Convert string to int
         }
      } catch (IOException | NumberFormatException e) {
         System.err.println("Error reading from file: " + e.getMessage());
      }

      // print array with 10000 numbers to show random order for average case scenario
      System.out.println("Average case");
      System.out.println(Arrays.toString(arr10000S));
      // perform selectionSort on 10000 numbers for average case scenario
      System.out.println("Time for selection sort average case:" + timeSelectionSortMethod(arr10000S)+ "nanoseconds");

      System.out.println();
      System.out.println("Best case");
      // print array to show it is sorted
      System.out.println(Arrays.toString(arr10000S));
      // perform selection sort on sorted array to show best case scenario
      System.out.println("Time for selection sort on 10000 numbers best case is:" + timeSelectionSortMethod(arr10000S)+ "nanoseconds");
      System.out.println();

      System.out.println("Worst case");
      // put array in descending order for worst case scenario
      for (int i = 0; i < arr10000S.length / 2; i++) {
         int temp = arr10000S[i];
         arr10000S[i] = arr10000S[arr10000S.length - 1 - i];
         arr10000S[arr10000S.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr10000S));

      // perform SelectionSort to show worst case scenario
      System.out.println("Time for selection sort on 10000 numbers worst case is:" + timeSelectionSortMethod(arr10000S)+ "nanoseconds");











   }//main
}//class   
