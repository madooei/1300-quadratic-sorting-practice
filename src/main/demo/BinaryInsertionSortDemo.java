package demo;

import java.util.Arrays;
import practice.BinaryInsertionSort;

/** A demo of BinaryInsertionSort on the example the notes trace. */
public final class BinaryInsertionSortDemo {

  private BinaryInsertionSortDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] arr = {2, 5, 5, 8, 5};
    System.out.println("before: " + Arrays.toString(arr));

    // The last 5 goes after the two 5s already there. Expect [2, 5, 5, 5, 8].
    BinaryInsertionSort.insertionSort(arr);
    System.out.println("after:  " + Arrays.toString(arr));
  }
}
