import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/****
 ***** Created by lucag on 24/02/2025
 ***** UPDATE PROGRAM DESCRIPTION HERE
 ****/
public class readWrite100Numbers {

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
   public static int[] generateRandom() {
      int [] num = new int [100];
      int min = 1;
      int max = 100;

      for (int i = 0; i< num.length; i++){
         num[i]= (int)(Math.random() * (max - min + 1) + min);
      }
      return num;
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



   public static void main(String[] args) {

      // use random method to create random 100 array
      int [] arr100= generateRandom();

      // print out of random array
      System.out.println(Arrays.toString(arr100) + " ");

      // bubble sort of random 100 numbers Average case comparisons= 4950, swaps= 2845
      bubbleSort(arr100);

      // print of array after bubblSort shows array in ascending order
      System.out.println(Arrays.toString(arr100));

      //bubble sort of array in best case scenario after array is sorted showing comarisons= 4950, swaps= 0
      bubbleSort(arr100);

      //print of array in descending order worst case scenario
      for (int i = 0; i < arr100.length / 2; i++) {
         int temp = arr100[i];
         arr100[i] = arr100[arr100.length - 1 - i];
         arr100[arr100.length - 1 - i] = temp;
      }

      // Print the array in descending order
      System.out.println(Arrays.toString(arr100));

      // bubble sort the array when its in worst case scenario array is in descending order
      bubbleSort(arr100); // Comparisons = 4950, swaps= 4895

      System.out.println("=======================================");


      int [] arr1000 = new int [1000];
      int min = 1;
      int max = 100;

      for (int i = 0; i< arr1000.length; i++){
         arr1000[i]= (int)(Math.random() * (max - min + 1) + min);
      }

      // Array showing average case for 1000 numbers
      System.out.println(Arrays.toString(arr1000));

      // bubble sort random 1000 numbers average case scenario showing comparisons 499500, sswaps = 247452
      bubbleSort(arr1000);
      System.out.println(Arrays.toString(arr1000));

      // bubble sort random 1000 numbers after bubble sort shows best case scenario
      bubbleSort(arr1000); // comparisons= 499500, swaps= 0

      //bubble sort random 1000 numbers when worst case scenario numbers in descending order
      //print of array in descending order worst case scenario
      for (int i = 0; i < arr1000.length / 2; i++) {
         int temp = arr1000[i];
         arr1000[i] = arr1000[arr1000.length - 1 - i];
         arr1000[arr1000.length - 1 - i] = temp;
      }
      System.out.println(Arrays.toString(arr1000));

      // bubble sort in worst case scenario  comparisons= 499500 swaps= 494481
      bubbleSort(arr1000);





//      int [] hundredNums= readNumbers("hundredNumbers.txt");
//      int [] thousandNums= readNumbers("random1000");
//
//
//      // average case 100 numbers
//      int [] averHundredNums= hundredNums;
//      System.out.println(Arrays.toString(averHundredNums));
//
//      // best case 100 numbers
//      int [] bestHundredNums= hundredNums;{
//         insertionSortMethod(bestHundredNums);
//         System.out.print(Arrays.toString(bestHundredNums));
//         System.out.println();
//
//      }
//
//
//      // worst case 100 numbers
//      int [] worseHundredNums= hundredNums;
//      for (int i = 0; i < worseHundredNums.length / 2; i++) {
//         int temp = worseHundredNums[i];
//         worseHundredNums[i] = worseHundredNums[worseHundredNums.length - 1 - i];
//         worseHundredNums[worseHundredNums.length - 1 - i] = temp;
//      }
//
//      // Print the array in descending order
//      System.out.println(Arrays.toString(worseHundredNums));// need to put into descending order
//      System.out.println("==========Add bubbleSort to each se of arrays=================");
//      System.out.println("============================================================");
//
//
//

      


   }//main
}//class   
