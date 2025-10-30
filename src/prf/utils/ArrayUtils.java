package prf.utils;

/**
 * Small array utility helpers used across the project.
 */
public class ArrayUtils {
  private ArrayUtils() {}

  /**
   * Concatenate two integer arrays.
   *
   * @param a first array
   * @param b second array
   * @return new array containing elements of {@code a} followed by elements of
   *         {@code b}
   */
  public static int[] concat(int[] a, int[] b) {
    int[] result = new int[a.length + b.length];
    System.arraycopy(a, 0, result, 0, a.length);
    System.arraycopy(b, 0, result, a.length, b.length);
    return result;
  }

  /**
   * Return a new array identical to {@code arr} but without the last element.
   *
   * @param arr source array (must not be null or empty)
   * @return array without the last element
   * @throws IllegalArgumentException when {@code arr} is null or empty
   */
  public static int[] removeLast(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("can not remove last element from an empty array");
    }
    int[] result = new int[arr.length - 1];
    System.arraycopy(arr, 0, result, 0, arr.length - 1);
    return result;
}
}
