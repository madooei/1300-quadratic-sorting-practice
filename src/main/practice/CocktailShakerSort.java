package practice;

/** Cocktail shaker sort: bubble sort that alternates direction, with early termination. */
public final class CocktailShakerSort {

  private CocktailShakerSort() {
    // This class should not be instantiated!
  }

  // Sorts arr in ascending order, in place. Assumes arr is not null.
  public static void cocktailShakerSort(int[] arr) {
    // TODO: Implement me
    throw new UnsupportedOperationException("TODO: Implement me");
  }

  // Exchanges arr[i] and arr[j].
  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
