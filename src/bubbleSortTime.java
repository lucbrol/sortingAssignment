import java.util.Arrays;
import java.util.Random;

/****
 ***** Created by lucag on 11/03/2025
 ***** UPDATE PROGRAM DESCRIPTION HERE
 ****/
public class bubbleSortTime {

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
   public static long timeBubbleSort(int[] array) {
      long startTime = System.nanoTime();
      bubbleSort(array);
      long endTime = System.nanoTime();
      return endTime - startTime;
   }
   public static int[] generateRandom(int size, int min, int max) {
      Random random = new Random();
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
         array[i] = random.nextInt(max - min + 1) + min; // random number between min and max
      }
      return array;
   }




   public static void main(String [] args) {

      int [] arr100B= generateRandom(100,1,100);
      int [] arr1000B= generateRandom(1000,1,100);
      int [] arr10000B= generateRandom(10000,1,100);

      // print random array to show average case

      System.out.println(Arrays.toString(arr100B));

      // perform bubble and time for average case scenario for 100 numbers
      System.out.println("The time in nanoseconds for bubble Sort on average case is: " + timeBubbleSort(arr100B)+ "nanoseconds");

      // perform bubble and time on sorted array for best case scenario
      System.out.println("The time in nanoseconds for bubble Sort on best case is: " + timeBubbleSort(arr100B)+ "nanoseconds");

      // put array in descending order for worst case scenario

      for (int i = 0; i < arr100B.length / 2; i++) {
         int temp = arr100B[i];
         arr100B[i] = arr100B[arr100B.length - 1 - i];
         arr100B[arr100B.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr100B));

      //Perform bubble and time in worst case scenario
      System.out.println("The time in nanoseconds for bubble Sort on worst case is: " + timeBubbleSort(arr100B)+ "nanoseconds");

      System.out.println("========================1000 numbers=======================");

      System.out.println(Arrays.toString(arr1000B));

      // perform bubble and time on average case scenario
      System.out.println("Time taken for bubbleSort on 1000 numbers in average case scenario is: " + timeBubbleSort(arr1000B)+ "nanseconds");

      // array sorted perform bubbleSort and time for best case scenario
      System.out.println("Time taken for bubbleSort on 1000 numbers in best case scenario is: " + timeBubbleSort(arr1000B)+ "nanseconds");

      // put array in descending order for worst case scenario
      for (int i = 0; i < arr1000B.length / 2; i++) {
         int temp = arr1000B[i];
         arr1000B[i] = arr1000B[arr1000B.length - 1 - i];
         arr1000B[arr1000B.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr1000B));

      // perform bubble and time for worst case scenario for input at 1000 numnbers
      System.out.println("Time taken for bubbleSort on 1000 numbers in worst case scenario is: " + timeBubbleSort(arr1000B)+ "nanseconds");

      System.out.println("========================10000 numbers==================");

      // print random array with 10000 numbers
      System.out.println(Arrays.toString(arr10000B));

      // perform bubble and time for average case scenario
      System.out.println("Time taken for bubbleSort on 10000 data in average case scenario is: " + timeBubbleSort(arr10000B)+ "nanoseconds");

      // perform bubble on sorted array for best case scenario and time
      System.out.println("Time taken for bubbleSort on 10000 data in best case scenario is: " + timeBubbleSort(arr10000B)+ "nanoseconds");

      // put array in descending order for worst case scenario
      for (int i = 0; i < arr10000B.length / 2; i++) {
         int temp = arr10000B[i];
         arr10000B[i] = arr10000B[arr10000B.length - 1 - i];
         arr10000B[arr10000B.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(arr10000B));

      // perform bubble on sorted array for worst case scenario and time
      System.out.println("Time taken for bubbleSort on 10000 data in worst case scenario is: " + timeBubbleSort(arr10000B)+ "nanoseconds");



   }//main
}//class   
