package practice;

/** Insertion sort with a binary-search insertion point and a separate shift. */
public final class BinaryInsertionSort {

  private BinaryInsertionSort() {
    // This class should not be instantiated!
  }

  // Returns the index in arr[0..end-1] where key belongs, after any elements
  // equal to key.
  // Pre: arr[0..end-1] is sorted.
  private static int insertionPosition(int[] arr, int key, int end) {
    int low = 0;
    int high = end - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (arr[mid] <= key) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  // Moves arr[start..end-1] one slot to the right, overwriting arr[end].
  private static void shiftRight(int[] arr, int start, int end) {
    for (int k = end; k > start; k--) {
      arr[k] = arr[k - 1];
    }
  }

  // Sorts arr in ascending order, in place. Assumes arr is not null.
  public static void insertionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int key = arr[i];
      int j = insertionPosition(arr, key, i);
      shiftRight(arr, j, i);
      arr[j] = key;
    }
  }
}
