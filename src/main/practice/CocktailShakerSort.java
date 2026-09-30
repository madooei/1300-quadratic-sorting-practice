package practice;

/** Cocktail shaker sort: bubble sort that alternates direction, with early termination. */
public final class CocktailShakerSort {

  private CocktailShakerSort() {
    // This class should not be instantiated!
  }

  // Sorts arr in ascending order, in place. Assumes arr is not null.
  public static void cocktailShakerSort(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    boolean swapped = true;
    while (swapped && start < end) {
      swapped = false;
      for (int j = start; j < end; j++) {  // forward pass: largest to end
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
          swapped = true;
        }
      }
      end--;
      if (!swapped) {
        break;
      }
      swapped = false;
      for (int j = end; j > start; j--) {  // backward pass: smallest to start
        if (arr[j - 1] > arr[j]) {
          swap(arr, j - 1, j);
          swapped = true;
        }
      }
      start++;
    }
  }

  // Exchanges arr[i] and arr[j].
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
