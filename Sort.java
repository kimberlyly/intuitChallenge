/*
 * Class: Sort
 * Description: A class implementing MergeSort, which sorts at a
 *              time complexity of O(n log n).
 * Usage: java Sort n where n is the number of numbers you wish to enter or
 *        java Sort test to run the default tests.
 */

import java.util.Scanner;

public class Sort {
  private int[] array;
  private int[] tempArray;

  /* Method name: main
   * Description: Main driver for the program. Parses the command
   *              line arguments.
   * Parameters: args
   * Returns: none.
   */
  public static void main(String[] args) {
    // Usage has not been followed
    if (args.length < 1) {
      System.out.println("Usage 1: java Sort n, where n is the number of" +
                          " numbers you wish to enter in your array.\n" +
                          "Usage 2: java Sort test, to run the default" +
                          " tests.");
      return;
    }

    // The user requested to run the default tests
    if (args[0].equals("test")) {
      runTests();
    } else { // The user will enter the number of numbers
      Scanner scanner = new Scanner(System.in);
      int numCount = Integer.parseInt(args[0]);
      int[] array = new int[numCount];
      for (int i = 0; i < numCount; i++) {
        array[i] = scanner.nextInt();
      }
      sort(array);
      printArray(array);
    }
  }

  /* Method name: sort
   * Description: The sorting method. Divides the array in half
   *              recursively. Calls merge afterwards.
   * Parameters: int[] input - the array to be sorted
   * Returns: The sorted array
   */
  public static int[] sort(int[] input) {
    int length = input.length;
    if (length <= 1) {
      return input; // return original array if length is 1
    }

    // Divide the arrays into a left half and right half
    int mid = length / 2;
    int[] left = new int[mid];
    int[] right = new int[length - mid];

    // Copy array contents into a left subarray and right subarray
    System.arraycopy(input, 0, left, 0, left.length);
    System.arraycopy(input, left.length, right, 0, right.length);

    // Sort halves separately
    sort(left);
    sort(right);

    // Then merge the halves
    merge(left, right, input);

    return input;
  }

  /* Method name: merge
   * Description: The merging method. This takes two arrays and puts
   *              them in order depending on which comes first.
   * Parameters: int[] left - the left subarray; 
   *             int[] right - the right subarray;
   *             int[] input - the sorted array
   */
  private static void merge(int[] left, int[] right, int[] input) {
    int leftIndex = 0;
    int rightIndex = 0;
    int currentIndex = 0;

    while (leftIndex < left.length && rightIndex < right.length) {
      // Element in left subarray should go first
      if (left[leftIndex] < right[rightIndex]) {
        input[currentIndex] = left[leftIndex];
        leftIndex++;
      } else { // Element in right subarray should go first
        input[currentIndex] = right[rightIndex];
        rightIndex++;
      }
      currentIndex++; // Increase the currentIndex
    }

    // There are no more elements to compare to. Copy the rest of the
    // arrays into the input array.
    System.arraycopy(left, leftIndex, input, currentIndex, 
                      left.length - leftIndex);
    System.arraycopy(right, rightIndex, input, currentIndex,
                      right.length - rightIndex);
  }

  /* Method: printArray
   * Description: a helper method to print all elements in the array
   * Parameters: the array to print
   * Returns: none.
   */
  public static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.print("\n");
  }

  /* Method: runTests
   * Description: A method to run the default tests
   * Parameters: none
   * Returns: none
   */
  public static void runTests() {
    // TEST 1 - The test provided
    System.out.println("Test 1 - Provided Test");
    int[] test = {1, 10, 5, 63, 29, 71, 10, 12, 44, 29, 10, -1};
    sort(test);
    printArray(test);

    // TEST 2 - Testing with an empty set
    System.out.println("Test 2 - Empty Array");
    int[] test2 = {};
    sort(test2);
    printArray(test2);

    // TEST 3 - Testing with only one number
    System.out.println("Test 3 - Only one number in array");
    int[] test3 = {1};
    sort(test3);
    printArray(test3);

    // TEST 4 - Testing with multiple duplicates
    System.out.println("Test 4 - Multiple duplicates in array");
    int[] test4 = {-1, -1, -1, -1, -10, -10};
    sort(test4);
    printArray(test4);
  }
}