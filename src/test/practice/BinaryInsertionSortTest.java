package practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** The scenarios for insertion sort with binary search and its two helpers. */
public class BinaryInsertionSortTest {

  // Calls the sort under test.
  private void sort(int[] arr) {
    BinaryInsertionSort.insertionSort(arr);
  }

  // Calls the private insertionPosition through reflection, so the tests can
  // check where a key belongs without making the helper public.
  private static int insertionPosition(int[] arr, int key, int end) {
    try {
      Method method = BinaryInsertionSort.class.getDeclaredMethod(
          "insertionPosition", int[].class, int.class, int.class);
      method.setAccessible(true);
      return (Integer) method.invoke(null, arr, key, end);
    } catch (InvocationTargetException e) {
      throw new IllegalStateException("insertionPosition threw " + e.getCause());
    } catch (ReflectiveOperationException e) {
      throw new IllegalStateException(
          "BinaryInsertionSort has no insertionPosition(int[], int, int)");
    }
  }

  // Calls the private shiftRight through reflection, so the tests can check
  // the shift without making the helper public.
  private static void shiftRight(int[] arr, int start, int end) {
    try {
      Method method = BinaryInsertionSort.class.getDeclaredMethod(
          "shiftRight", int[].class, int.class, int.class);
      method.setAccessible(true);
      method.invoke(null, arr, start, end);
    } catch (InvocationTargetException e) {
      throw new IllegalStateException("shiftRight threw " + e.getCause());
    } catch (ReflectiveOperationException e) {
      throw new IllegalStateException(
          "BinaryInsertionSort has no shiftRight(int[], int, int)");
    }
  }

  @Test
  public void keyForAnEmptySortedPortionBelongsAtTheFront() {
    int[] arr = {7};
    assertEquals(0, insertionPosition(arr, 7, 0));
  }

  @Test
  public void keyLargerThanTheSortedPortionBelongsAtItsEnd() {
    int[] arr = {2, 5, 8, 9};
    assertEquals(3, insertionPosition(arr, 9, 3));
  }

  @Test
  public void keySmallerThanTheSortedPortionBelongsAtTheFront() {
    int[] arr = {2, 5, 8, 1};
    assertEquals(0, insertionPosition(arr, 1, 3));
  }

  @Test
  public void keyBetweenTwoElementsBelongsBetweenThem() {
    int[] arr = {2, 5, 8, 6};
    assertEquals(2, insertionPosition(arr, 6, 3));
  }

  @Test
  public void keyEqualToExistingElementsBelongsAfterThem() {
    int[] arr = {2, 5, 5, 8, 5};
    assertEquals(3, insertionPosition(arr, 5, 4));
  }

  @Test
  public void shiftRightWithNothingToMoveLeavesTheArrayUnchanged() {
    int[] arr = {2, 5, 8, 9};
    shiftRight(arr, 3, 3);
    assertContents(new int[] {2, 5, 8, 9}, arr);
  }

  @Test
  public void shiftRightMovesOneElementOneSlot() {
    int[] arr = {2, 5, 5, 8, 5};
    shiftRight(arr, 3, 4);
    assertContents(new int[] {2, 5, 5, 8, 8}, arr);
  }

  @Test
  public void shiftRightFromTheFrontMovesTheWholeSortedPortion() {
    int[] arr = {2, 5, 8, 1};
    shiftRight(arr, 0, 3);
    assertContents(new int[] {2, 2, 5, 8}, arr);
  }

  @Test
  public void emptyArrayStaysEmpty() {
    int[] arr = {};
    sort(arr);
    assertContents(new int[] {}, arr);
  }

  @Test
  public void singleElementStaysPut() {
    int[] arr = {1};
    sort(arr);
    assertContents(new int[] {1}, arr);
  }

  @Test
  public void twoElementsOutOfOrderGetSorted() {
    int[] arr = {2, 1};
    sort(arr);
    assertContents(new int[] {1, 2}, arr);
  }

  @Test
  public void alreadySortedArrayIsUnchanged() {
    int[] arr = {1, 2, 3};
    sort(arr);
    assertContents(new int[] {1, 2, 3}, arr);
  }

  @Test
  public void allDuplicatesAreUnchanged() {
    int[] arr = {4, 4, 4};
    sort(arr);
    assertContents(new int[] {4, 4, 4}, arr);
  }

  @Test
  public void reverseSortedArrayGetsSorted() {
    int[] arr = {3, 2, 1};
    sort(arr);
    assertContents(new int[] {1, 2, 3}, arr);
  }

  @Test
  public void smallElementAtTheEndMovesToTheFront() {
    int[] arr = {2, 3, 4, 5, 1};
    sort(arr);
    assertContents(new int[] {1, 2, 3, 4, 5}, arr);
  }

  @Test
  public void largeElementAtTheFrontMovesToTheEnd() {
    int[] arr = {5, 1, 2, 3, 4};
    sort(arr);
    assertContents(new int[] {1, 2, 3, 4, 5}, arr);
  }

  @Test
  public void duplicatesAmongOtherValuesGetSorted() {
    int[] arr = {3, 1, 3, 2};
    sort(arr);
    assertContents(new int[] {1, 2, 3, 3}, arr);
  }

  @Test
  public void negativesSortBeforePositives() {
    int[] arr = {-3, 1, -7, 4};
    sort(arr);
    assertContents(new int[] {-7, -3, 1, 4}, arr);
  }

  @Test
  public void longerUnsortedArrayGetsSorted() {
    int[] arr = {5, 6, 0, 2, 1, 9, 3};
    sort(arr);
    assertContents(new int[] {0, 1, 2, 3, 5, 6, 9}, arr);
  }

  // Checks that actual holds the same values as expected, in the same order.
  private static void assertContents(int[] expected, int[] actual) {
    assertEquals(expected.length, actual.length);
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }
}
