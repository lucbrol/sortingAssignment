import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/****
 ***** Created by lucag on 11/03/2025
 ***** UPDATE PROGRAM DESCRIPTION HERE
 ****/
public class sortingInsertionSort {


   public static long timeInsertionSortMethod(int[] array) {
      long startTime = System.nanoTime();
      insertionSortMethod(array);
      long endTime = System.nanoTime();
      return endTime - startTime;
   }
   public static void insertionSortMethod(int[] arr) {
      int n = arr.length;
      for (int i = 1; i < n; i++) {
         int key = arr[i];
         int j = i - 1;

         // Move elements that are greater than key one position ahead
         while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
         }
         arr[j + 1] = key; // Insert key in its correct position
      }
   }


   public static void insertionSort(int data[]) {
      int in, out, temp;
      int copies = 0, swapIS = 0;
      for (out = 1; out < data.length; out++) {
         temp = data[out];
         copies++;
         for (in = out; in > 0 && data[in - 1] >= temp; in--) {
            data[in] = data[in - 1];
            copies++; // count this as a copy (as data[in] is moved)
            swapIS++; // count this as a swap
         }
         data[in] = temp; // insert key into position
         copies++;  // This is final insertion of key in correct position
      }
      System.out.println("swapsIS=" + swapIS);
      System.out.println("CopiesIS= " + copies);
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

      int [] arr100I= readNumbers("random100.txt");

      System.out.println("=====================100 numbers========================");
      // print array showing 100 random numbers
      System.out.println("Average case");
      System.out.println(Arrays.toString(arr100I));

      // Perform InsertionSort on random 100 numbers to show average case scenario

      System.out.println("Comparisons and swaps for average case of 100 random numbers are: ");
      insertionSort(arr100I);
      insertionSortMethod(arr100I);
      System.out.println("Average case insertionSort Time: " + timeInsertionSortMethod(arr100I) + "nanoseconds");

      System.out.println();

      System.out.println("Best case");
      //print sorted array
      System.out.println(Arrays.toString(arr100I));

      // perform insertion sort to show best case scenario
      System.out.println("Sorted 100 numbers, best case, comparisons and swaps are: ");
      insertionSort(arr100I);
      insertionSortMethod(arr100I);
      System.out.println("Best case insertionSort Time: " + timeInsertionSortMethod(arr100I) + "nanoseconds");

      System.out.println();

      System.out.println("Worst case");

      // put array in descending order
      for (int i = 0; i < arr100I.length / 2; i++) {
         int temp = arr100I[i];
         arr100I[i] = arr100I[arr100I.length - 1 - i];
         arr100I[arr100I.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr100I));

      // Perform insertion sort on 100 numbers to show worst case scenario
      System.out.println("Comparisons and swaps for 100 numbers are: ");
      insertionSort(arr100I);
      insertionSortMethod(arr100I);
      System.out.println("Worst case insertionSort Time: " + timeInsertionSortMethod(arr100I) + "nanoseconds");

      System.out.println();

      System.out.println("==============1000 numbers==================");
      int [] arr1000I= new int [1000];
      try (BufferedReader reader = new BufferedReader(new FileReader("random1000.txt"))) {//use reader
         String line; // create string
         int index = 0; // index for array
         while ((line = reader.readLine()) != null && index < 1000) {
            arr1000I[index++] = Integer.parseInt(line.trim()); // Convert string to int
         }
      } catch (IOException | NumberFormatException e) {
         System.err.println("Error reading from file: " + e.getMessage());
      }

      // print array showing 1000 random numbers
      System.out.println("Average case");
      System.out.println(Arrays.toString(arr1000I));

      // perform insertionSort for average case scenario
      System.out.println("Comparisons and swaps for average case scenario are: ");
      insertionSort(arr1000I);
      insertionSortMethod(arr1000I);
      System.out.println("Average case insertionSort Time: " + timeInsertionSortMethod(arr1000I) + "nanoseconds");

      System.out.println("Best case");
      // print array now sorted
      System.out.println(Arrays.toString(arr1000I));

      // perform insertionSort on sorted array for best case scenario
      System.out.println("Comparisons and swaps for best case scenario are: ");
      insertionSort(arr1000I);
      insertionSortMethod(arr1000I);
      System.out.println("Best case insertionSort Time: " + timeInsertionSortMethod(arr1000I) + "nanoseconds");

      System.out.println("Worst case");
      // put array in descending order for worst case scenario

      for (int i = 0; i < arr1000I.length / 2; i++) {
         int temp = arr1000I[i];
         arr1000I[i] = arr1000I[arr1000I.length - 1 - i];
         arr1000I[arr1000I.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr1000I));

      // perform insertion sort on worst case scenario
      System.out.println("Comparisons and swaps in worst case scenario are: ");
      insertionSort(arr1000I);
      insertionSortMethod(arr1000I);
      System.out.println("Worst case insertionSort Time: " + timeInsertionSortMethod(arr1000I) + "nanoseconds");


      System.out.println("==============10000 numbers==================");
      int [] arr10000I= new int [10000];
      try (BufferedReader reader = new BufferedReader(new FileReader("random10000.txt"))) {//use reader
         String line; // create string
         int index = 0; // index for array
         while ((line = reader.readLine()) != null && index < 10000) {
            arr10000I[index++] = Integer.parseInt(line.trim()); // Convert string to int
         }
      } catch (IOException | NumberFormatException e) {
         System.err.println("Error reading from file: " + e.getMessage());
      }

      // print array for random 10000 numbers
      System.out.println("Average case");
      System.out.println(Arrays.toString(arr10000I));

      // perform insertion sort on random numbers to show average case scenario
      System.out.println("Comparisons and swaps for average case selection sort are: ");
      insertionSort(arr10000I);
      insertionSortMethod(arr10000I);
      System.out.println("Average case insertionSort Time: " + timeInsertionSortMethod(arr10000I) + "nanoseconds");

      System.out.println();
      System.out.println("Best case");
      // print array now sorted
      System.out.println(Arrays.toString(arr10000I));

      // perform insertion sort on sorted array to show best case scenario
      System.out.println("Comparisons and swaps for best case insertion sort are: ");
      insertionSort(arr10000I);
      insertionSortMethod(arr10000I);
      System.out.println("Best case insertionSort Time: " + timeInsertionSortMethod(arr10000I) + "nanoseconds");
      System.out.println();

      System.out.println("Worst case");
      // put array in descending order for worst case scenario
      for (int i = 0; i < arr10000I.length / 2; i++) {
         int temp = arr10000I[i];
         arr10000I[i] = arr10000I[arr10000I.length - 1 - i];
         arr10000I[arr10000I.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr10000I));
      //perform insertionSort for worst case scenario
      System.out.println("Comparisons and swaps in worst case scenario ");
      insertionSort(arr10000I);
      insertionSortMethod(arr10000I);
      System.out.println("Worst case insertionSort Time: " + timeInsertionSortMethod(arr10000I) + "nanoseconds");











   }//main
}//class   
