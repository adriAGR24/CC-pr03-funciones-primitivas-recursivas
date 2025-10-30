package prf.basic;

import prf.core.ArityFunctionChecker;

/**
 * Zero function: returns 0 regardless of the input (used with arity 1 here).
 */
public class ZeroFunction extends ArityFunctionChecker {
  /**
   * Create a zero function that expects exactly one argument (value ignored).
   */
  public ZeroFunction() {
    super(1);
  }

  /**
   * Compute the result for this function.
   *
   * @param args input arguments (ignored)
   * @return one-element array containing 0
   */
  @Override
  protected int[] compute(int... args) {
    return new int[] { 0 };
  }
}