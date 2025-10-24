package prf.utils;

public class ArrayUtils {
  private ArrayUtils() {}

  public static int[] concat(int[] a, int[] b) {
    int[] result = new int[a.length + b.length];
    System.arraycopy(a, 0, result, 0, a.length);
    System.arraycopy(b, 0, result, a.length, b.length);
    return result;
  }

  public static int[] removeLast(int[] arr) {
    if (arr == null || arr.length == 0) {
      throw new IllegalArgumentException("can not remove last element from an empty array");
    }
    int[] result = new int[arr.length - 1];
    System.arraycopy(arr, 0, result, 0, arr.length - 1);
    return result;
}
}
