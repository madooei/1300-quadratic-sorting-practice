package demo;

import java.util.Arrays;
import practice.CocktailShakerSort;

/** A demo of CocktailShakerSort on the example the notes trace. */
public final class CocktailShakerSortDemo {

  private CocktailShakerSortDemo() {
    // This class should not be instantiated!
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 4, 5, 1};
    System.out.println("before: " + Arrays.toString(arr));

    // The backward pass carries the 1 to the front. Expect [1, 2, 3, 4, 5].
    CocktailShakerSort.cocktailShakerSort(arr);
    System.out.println("after:  " + Arrays.toString(arr));
  }
}
