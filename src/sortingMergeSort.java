import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/****
 ***** Created by lucag on 11/03/2025
 ***** UPDATE PROGRAM DESCRIPTION HERE
 ****/
public class sortingMergeSort {

   public static int[] generateRandom(int size, int min, int max) {
      Random random = new Random();
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
         array[i] = random.nextInt(max - min + 1) + min; // random number between min and max
      }
      return array;
   }
   public static void mergeSort(int[] arr, int left, int right) {
      if (left < right) {
         int mid = left + (right - left) / 2;

         // Recursively sort both halves
         mergeSort(arr, left, mid);
         mergeSort(arr, mid + 1, right);

         // Merge the sorted halves
         merge(arr, left, mid, right);
      }
   }

   public static void printArray(int[] arr) {
      for (int num : arr) {
         System.out.print(num + " ");
      }
      System.out.println();
   }


   private static void merge(int[] arr, int left, int mid, int right) {
      int n1 = mid - left + 1;
      int n2 = right - mid;

      // Create temporary arrays
      int[] leftArr = new int[n1];
      int[] rightArr = new int[n2];

      // Copy data to temporary arrays
      for (int i = 0; i < n1; i++)
         leftArr[i] = arr[left + i];

      for (int i = 0; i < n2; i++)
         rightArr[i] = arr[mid + 1 + i];

      // Merge the temporary arrays
      int i = 0, j = 0, k = left;
      while (i < n1 && j < n2) {
         if (leftArr[i] <= rightArr[j]) {
            arr[k] = leftArr[i];
            i++;
         } else {
            arr[k] = rightArr[j];
            j++;
         }
         k++;
      }

      // Copy remaining elements of leftArr (if any)
      while (i < n1) {
         arr[k] = leftArr[i];
         i++;
         k++;
      }

      // Copy remaining elements of rightArr (if any)
      while (j < n2) {
         arr[k] = rightArr[j];
         j++;
         k++;
      }
   }
   public static long timeMergeSort(int[] array) {
      long startTime = System.nanoTime();
      mergeSort(array,0,array.length-1);
      long endTime = System.nanoTime();
      return endTime - startTime; // Return the time taken in nanoseconds
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

      int [] arr100M= readNumbers("random100.txt");

      System.out.println("====================100 numbers=========================");
      // print random 100 numbers to show average case
      System.out.println("Average case");
      System.out.println(Arrays.toString(arr100M));
      // Time merge sort for 100 numbers in random order for average case scenario
      System.out.println("Time for merge sort average case is:" + timeMergeSort(arr100M) + "nanoseconds");

      System.out.println();

      System.out.println("Best case");
      // print numbers as they are sorted
      System.out.println(Arrays.toString(arr100M));
      // perform merge sort on  sorted array to show best case scenario and time
      System.out.println("Time for merge sort best case is:" + timeMergeSort(arr100M) + "nanoseconds");

      System.out.println();

      System.out.println("Worst case");
      // put array in descending order to show worst case scenario
      for (int i = 0; i < arr100M.length / 2; i++) {
         int temp = arr100M[i];
         arr100M[i] = arr100M[arr100M.length - 1 - i];
         arr100M[arr100M.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr100M));

      // Perform merge sort and time on worst case scenario for 100 numbers
      System.out.println("Time for merge sort worst case is:" + timeMergeSort(arr100M) + "nanoseconds");

      System.out.println("===============1000 numbers================");
      int [] arr1000M= new int [1000];
      try (BufferedReader reader = new BufferedReader(new FileReader("random1000.txt"))) {//use reader
         String line; // create string
         int index = 0; // index for array
         while ((line = reader.readLine()) != null && index < 1000) {
            arr1000M[index++] = Integer.parseInt(line.trim()); // Convert string to int
         }
      } catch (IOException | NumberFormatException e) {
         System.err.println("Error reading from file: " + e.getMessage());
      }

      // print array with random unsorted numbers
      System.out.println("Average case");
      System.out.println(Arrays.toString(arr1000M));
      // perform merge sort and time
      System.out.println("Time for merge sort average case is:" + timeMergeSort(arr1000M) + "nanoseconds");
      System.out.println();

      System.out.println("Best case");
         // print array which is sorted
      System.out.println(Arrays.toString(arr1000M));

      // time merge sort in best case scenario for 1000 numbers where array is sorted
      System.out.println("Time to perform merge sort in best case scenario is: " + timeMergeSort(arr1000M) + "nanoseconds");
     System.out.println();
      System.out.println("Worst case");

      // put array in descending order for worst case scenario
      for (int i = 0; i < arr1000M.length / 2; i++) {
         int temp = arr1000M[i];
         arr1000M[i] = arr1000M[arr1000M.length - 1 - i];
         arr1000M[arr1000M.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr1000M));

      // perform merge sort and time in worst case scenario for 1000 numbers
      System.out.println("Time to perform merge sort in worst case scenario is: " + timeMergeSort(arr1000M) + "nanoseconds");

         System.out.println("========================10000 numbers================");
      int [] arr10000M= new int [10000];
      try (BufferedReader reader = new BufferedReader(new FileReader("random10000.txt"))) {//use reader
         String line; // create string
         int index = 0; // index for array
         while ((line = reader.readLine()) != null && index < 10000) {
            arr10000M[index++] = Integer.parseInt(line.trim()); // Convert string to int
         }
      } catch (IOException | NumberFormatException e) {
         System.err.println("Error reading from file: " + e.getMessage());
      }

      // print array random 10000 numbers
         System.out.println("Average case");
         System.out.println(Arrays.toString(arr10000M));
         // perform mergeSort and time for average case scenario on 10000 numbers
      System.out.println("Time to perform merge sort in average case scenario is: " + timeMergeSort(arr10000M) + "nanoseconds");
      System.out.println();

      System.out.println("Best case");
      //print numbers now sorted to prepare for best case sort
      System.out.println(Arrays.toString(arr10000M));
      // perform merge and time for best case scenario for 10000 numbers
      System.out.println("Time to perform merge sort in best case scenario is: " + timeMergeSort(arr10000M) + "nanoseconds");

      System.out.println();
      System.out.println("Worst case");
      // put array in descending order for worst case scenario
      for (int i = 0; i < arr10000M.length / 2; i++) {
         int temp = arr10000M[i];
         arr10000M[i] = arr10000M[arr10000M.length - 1 - i];
         arr10000M[arr10000M.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr10000M));

      // perform merge and time
      System.out.println("Time to perform merge sort in worst case scenario is: " + timeMergeSort(arr10000M) + "nanoseconds");


   }//main
}//class   
