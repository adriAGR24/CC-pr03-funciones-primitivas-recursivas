package prf.basic;

import prf.core.ArityFunctionChecker;

/**
 * Successor function: returns the successor (n + 1) of the single input.
 */
public class SuccessorFunction extends ArityFunctionChecker {
  /**
   * Create a successor function that expects exactly one argument.
   */
  public SuccessorFunction() {
    super(1);
  }

  /**
   * Compute the successor of the provided argument.
   *
   * @param args one-element array containing the input number
   * @return one-element array with the successor value
   */
  @Override
  protected int[] compute(int... args) {
    return new int[] { args[0] + 1 };
  }
}