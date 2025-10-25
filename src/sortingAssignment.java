import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/****
 ** Created by lucy brolly on 15/03/2025
 * Sorting algorithms Merge, Selection and Insertion, timing methods
 * for each algorithm
 ****/
public class sortingAssignment {
   // Method to read numbers from a file into an array
   public static int[] readNumbersFromFile(String fileName, int arraySize) {
      int[] numbers = new int[arraySize];
      int count = 0;

      try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
         String line;
         while ((line = br.readLine()) != null && count < arraySize) {
            try {
               numbers[count] = Integer.parseInt(line.trim());
               count++;
            } catch (NumberFormatException e) {
               System.out.println("Skipping invalid number: " + line);
            }
         }
      } catch (IOException e) {
         System.out.println("Error reading file: " + e.getMessage());
      }

      return Arrays.copyOf(numbers, count); // Resizing the array to the actual number of elements read
   }
   // Method to clone an array (to avoid modifying the original array)
   public static int[] cloneArray(int[] original) {
      return Arrays.copyOf(original, original.length);
   }
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
   public static long timeInsertionSortMethod(int[] array) {
      long startTime = System.nanoTime();
      insertionSortMethod(array);
      long endTime = System.nanoTime();
      return endTime - startTime;
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

   public static void shuffleArray(int[] array) {
      Random rand = new Random();
      for (int i = array.length - 1; i > 0; i--) {
         // Pick a random index
         int j = rand.nextInt(i + 1);

         // Swap array[i] with the element at random index
         int temp = array[i];
         array[i] = array[j];
         array[j] = temp;
      }
   }


   public static void main(String [] args) {

      // read in different data sizes 100,1000,10000 and out into arrays
      int [] oneHunNum=readNumbersFromFile("random100.txt",100);
      int [] oneThousandNum=readNumbersFromFile("random1000.txt",1000);
      int [] TenThousandNum=readNumbersFromFile("random10000.txt",10000);


//
//      System.out.println(Arrays.toString(TenThousandNum));

      System.out.println("=================SelectionSort 100 numbers=======================");

      //make clone of array for average case scenario,print random
      System.out.println("Average case");
      int [] averageCaseSelection= cloneArray(oneHunNum);
      shuffleArray(averageCaseSelection);
      System.out.println(Arrays.toString(averageCaseSelection));
      System.out.println("Time for selection sort on 100 numbers average case is:" + timeSelectionSortMethod(averageCaseSelection)+ "nanoseconds");
      System.out.println();


      System.out.println("Best case");
      int [] bestcaseSelection=cloneArray(oneHunNum); //make clone of array for best case scenario
      // sort array for best case scenario
      insertionSortMethod(bestcaseSelection);

      System.out.println(Arrays.toString(bestcaseSelection));
      System.out.println("Selection sort best case Time:" + timeSelectionSortMethod(bestcaseSelection)+ "nanoseconds");
      System.out.println();

      //make clone of OneHunNum for worst case scenario
      // put in descending order
      System.out.println("worst case");
      int [] worstCaseSelection= cloneArray(oneHunNum);
      selectionSort(worstCaseSelection);
      for (int i = 0; i < worstCaseSelection.length / 2; i++) {
         int temp = worstCaseSelection[i];
         worstCaseSelection[i] = worstCaseSelection[worstCaseSelection.length - 1 - i];
         worstCaseSelection[worstCaseSelection.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(worstCaseSelection));
      System.out.println("Worst case Selection sort Time:" + timeSelectionSortMethod(worstCaseSelection)+ "nanoseconds");
      System.out.println();

      System.out.println("=================SelectionSort 1000 numbers=======================");

      System.out.println("Average case");
      int [] aver1000Sel=cloneArray(oneThousandNum);
      shuffleArray(aver1000Sel);
      System.out.println(Arrays.toString(aver1000Sel));
      System.out.println("Average case 1000 Selection sort Time:" + timeSelectionSortMethod(aver1000Sel)+ "nanoseconds");
      System.out.println();

      System.out.println("Best case");
      int [] best1000Sel= cloneArray(oneThousandNum);
      // sort array for best case
      selectionSort(best1000Sel);
      System.out.println(Arrays.toString(best1000Sel));
      System.out.println("Best case 1000 Selection sort Time:" + timeSelectionSortMethod(best1000Sel)+ "nanoseconds");
      System.out.println();

      System.out.println("Worst case");
      int [] worst1000Sel= cloneArray(oneThousandNum);
      insertionSortMethod(worst1000Sel);

      // put array in descending order
      for (int i = 0; i < worst1000Sel.length / 2; i++) {
         int temp = worst1000Sel[i];
         worst1000Sel[i] = worst1000Sel[worst1000Sel.length - 1 - i];
         worst1000Sel[worst1000Sel.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(worst1000Sel));
      System.out.println("Worst case Selection sort Time:" + timeSelectionSortMethod(worst1000Sel)+ "nanoseconds");
      System.out.println();

      System.out.println("=================SelectionSort 10000 numbers=======================");

      System.out.println("Average case");
      int [] aver10000Sel= cloneArray(TenThousandNum);
      shuffleArray(aver10000Sel);
      System.out.println(Arrays.toString(aver10000Sel));
      System.out.println("Time for selection sort on 10000 numbers average case is:" + timeSelectionSortMethod(aver10000Sel)+ "nanoseconds");
      System.out.println();

      System.out.println("Best case");
      int [] best10000Sel= cloneArray(TenThousandNum);
      insertionSortMethod(best10000Sel);
      System.out.println(Arrays.toString(best10000Sel));
      System.out.println("Time for selection sort on 10000 numbers best case is:" + timeSelectionSortMethod(best10000Sel)+ "nanoseconds");
      System.out.println();

      System.out.println("Worst case");
      int [] worst10000Sel=cloneArray(TenThousandNum);
      insertionSortMethod(worst10000Sel);
      // put array in descending order for worst case scenario 10000 numbers
      for (int i = 0; i < worst10000Sel.length / 2; i++) {
         int temp = worst10000Sel[i];
         worst10000Sel[i] = worst10000Sel[worst10000Sel.length - 1 - i];
         worst10000Sel[worst10000Sel.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(worst10000Sel));
      System.out.println("Worst case Selection sort Time:" + timeSelectionSortMethod(worst10000Sel)+ "nanoseconds");
      System.out.println();

      System.out.println("=================Insertion Sort 100 numbers=======================");

      System.out.println("Average case");
      int [] aver100Insertion= cloneArray(oneHunNum);
      shuffleArray(aver100Insertion);
      System.out.println(Arrays.toString(aver100Insertion));
      System.out.println("Average case insertionSort Time: " + timeInsertionSortMethod(aver100Insertion) + "nanoseconds");
      System.out.println();

      System.out.println("Best case");
      int [] best100Insertion=cloneArray(oneHunNum);
      // sort into ascending order
      insertionSortMethod(best100Insertion);
      System.out.println(Arrays.toString(best100Insertion));
      System.out.println("Best case insertionSort Time: " + timeInsertionSortMethod(best100Insertion) + "nanoseconds");
      System.out.println();

      System.out.println("Worst case");
      int [] worst100Insertion= cloneArray(oneHunNum);
      insertionSortMethod(worst100Insertion);
      // put in descending order for worst case scenario
      for (int i = 0; i < worst100Insertion.length / 2; i++) {
         int temp = worst100Insertion[i];
         worst100Insertion[i] = worst100Insertion[worst100Insertion.length - 1 - i];
         worst100Insertion[worst100Insertion.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(worst100Insertion));
      System.out.println("Worst case Selection sort Time:" + timeInsertionSortMethod(worst100Insertion)+ "nanoseconds");
      System.out.println();

      System.out.println("=================Insertion Sort 1000 numbers=======================");
      System.out.println("Average case");
      int [] aver1000Insertion=cloneArray(oneThousandNum);
      shuffleArray(aver1000Insertion);
      System.out.println(Arrays.toString(aver1000Insertion));
      System.out.println("Average case Selection sort Time:" + timeInsertionSortMethod(aver1000Insertion)+ "nanoseconds");
      System.out.println();

      System.out.println("Best case");
      int [] bes1000Insertion=cloneArray(oneThousandNum);
      insertionSortMethod(bes1000Insertion);
      System.out.println(Arrays.toString(bes1000Insertion));
      System.out.println("Best case Selection sort Time: " + timeInsertionSortMethod(bes1000Insertion)+ "nanoseconds");
      System.out.println();

      System.out.println("Worst case");
      int [] worse1000Insertion=cloneArray(oneThousandNum);
      insertionSortMethod(worse1000Insertion);
      // put in descending order for worst case scenario
      for (int i = 0; i < worse1000Insertion.length / 2; i++) {
         int temp = worse1000Insertion[i];
         worse1000Insertion[i] = worse1000Insertion[worse1000Insertion.length - 1 - i];
         worse1000Insertion[worse1000Insertion.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(worse1000Insertion));
      System.out.println("Worst case Selection sort Time:" + timeInsertionSortMethod(worse1000Insertion)+ "nanoseconds");
      System.out.println();

      System.out.println("=================Insertion Sort 10000 numbers=======================");

      System.out.println("Average case");
      int [] aver10000Insertion=cloneArray(TenThousandNum);
      shuffleArray(aver10000Insertion);
      System.out.println(Arrays.toString(aver10000Insertion));
      System.out.println("Average case Selection sort Time:" + timeInsertionSortMethod(aver10000Insertion)+ "nanoseconds");
      System.out.println();

      System.out.println("Best case");
      int [] best10000Insertion=cloneArray(TenThousandNum);
      insertionSortMethod(best10000Insertion); // sort array for best case scenario
      System.out.println(Arrays.toString(best10000Insertion));
      System.out.println("best case Selection sort Time:" + timeInsertionSortMethod(best10000Insertion)+ "nanoseconds");
      System.out.println();

      System.out.println("Worst case");
      int [] worse10000Insertion=cloneArray(oneThousandNum);
      insertionSortMethod(worse10000Insertion);
      // put in descending order for worst case scenario
      for (int i = 0; i < worse10000Insertion.length / 2; i++) {
         int temp = worse10000Insertion[i];
         worse10000Insertion[i] = worse10000Insertion[worse10000Insertion.length - 1 - i];
         worse10000Insertion[worse10000Insertion.length - 1 - i] = temp;
      }
      // Print the array in descending order
      System.out.println(Arrays.toString(worse10000Insertion));
      System.out.println("Worst case Selection sort Time:" + timeInsertionSortMethod(worse10000Insertion)+ "nanoseconds");
      System.out.println();

      System.out.println("================Merge Sort 100=============================");

      System.out.println("Average case");
      int [] merge100average=cloneArray(oneHunNum);
      shuffleArray(merge100average);
      System.out.println(Arrays.toString(merge100average));
      System.out.println("Merge sort average case Time: " + timeMergeSort(merge100average)+ "nanoseconds");
      System.out.println();

      System.out.println("Best case");
      int [] merge100best=cloneArray(oneHunNum);
      mergeSort(merge100best,0,merge100best.length-1);
      System.out.println(Arrays.toString(merge100best));
      System.out.println("Merge sort best case Time: " + timeMergeSort(merge100best)+ "nanoseconds");
      System.out.println();

      System.out.println("Worst case");
      int [] merge100worst=cloneArray(oneHunNum);

      // put in descending order for worst case scenario
        mergeSort(merge100worst,0,merge100worst.length-1);
        for (int i = 0; i < merge100worst.length / 2; i++) {
         int temp = merge100worst[i];
         merge100worst[i] = merge100worst[merge100worst.length - 1 - i];
         merge100worst[merge100worst.length - 1 - i] = temp;
         }
      // Print the array in descending order
         System.out.println(Arrays.toString(merge100worst));
         System.out.println("Worst case Merge sort Time:" + timeMergeSort(merge100worst)+ "nanoseconds");
         System.out.println();

         System.out.println("==================Merge 1000==================");

         System.out.println("Average Case");
         int [] merge1000average=cloneArray(oneThousandNum);
         shuffleArray(merge100average);
         System.out.println(Arrays.toString(merge1000average));
         System.out.println("Average case merge sort Time: "+ timeMergeSort(merge1000average) + "nanoseconds");

         System.out.println("Best case");
         int [] merge1000best=cloneArray(oneThousandNum);
         mergeSort(merge1000best,0,merge1000best.length-1);
         // sort for best case scenario
         System.out.println(Arrays.toString(merge1000best));
         System.out.println("Best case merge sort Time: "+ timeMergeSort(merge1000best) + "nanoseconds");
         System.out.println();

         System.out.println("Worst case");
         int [] merge1000worst=cloneArray(oneThousandNum);
         mergeSort(merge1000worst,0,merge1000worst.length-1);
         for (int i = 0; i < merge1000worst.length / 2; i++) {
            int temp = merge1000worst[i];
            merge1000worst[i] = merge1000worst[merge1000worst.length - 1 - i];
            merge1000worst[merge1000worst.length - 1 - i] = temp;
         }
         // Print the array in descending order
         System.out.println(Arrays.toString(merge1000worst));
         System.out.println("Worst case Merge sort Time:" + timeMergeSort(merge1000worst)+ "nanoseconds");
         System.out.println();

         System.out.println("=========================Merge 10000========================");

         System.out.println("Average case");
         int [] merge10000average=cloneArray(TenThousandNum);
         shuffleArray(merge10000average);
         System.out.println(Arrays.toString(merge10000average));
         System.out.println("Merge sort time average case: " + timeMergeSort(merge10000average)+ "nanoseconds");
         System.out.println();

         System.out.println("Best case");
         int [] merge10000best=cloneArray(TenThousandNum);
         //sort for best case scenario
         mergeSort(merge10000best,0,merge10000best.length-1);
         System.out.println(Arrays.toString(merge10000best));
         System.out.println("Merge sort time best case: " + timeMergeSort(merge10000best)+ "nanoseconds");
         System.out.println();

         System.out.println("Worst case");
         int [] merge10000worst=cloneArray(TenThousandNum);
         mergeSort(merge10000worst,0,merge10000worst.length-1);
         // put in descending order for worst case scenario
         for (int i = 0; i < merge10000worst.length / 2; i++) {
            int temp = merge10000worst[i];
            merge10000worst[i] = merge10000worst[merge10000worst.length - 1 - i];
            merge10000worst[merge10000worst.length - 1 - i] = temp;
         }
         // Print the array in descending order
         System.out.println(Arrays.toString(merge10000worst));
         System.out.println("Worst case Merge sort Time:" + timeMergeSort(merge10000worst)+ "nanoseconds");
         System.out.println();















































   }//main
}//class   
