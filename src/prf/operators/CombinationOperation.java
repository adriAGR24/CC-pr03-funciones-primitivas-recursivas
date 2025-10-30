package prf.operators;

import prf.core.PrimitiveFunction;
import prf.core.PrimitiveOperation;
import prf.utils.ArrayUtils;

/**
 * Combine the results of two functions by concatenating their output arrays.
 *
 * <p>This operator is useful when composing functions that together produce
 * multiple values required by another function.</p>
 */
public class CombinationOperation extends PrimitiveOperation {
  private final PrimitiveFunction firstFunction;
  private final PrimitiveFunction secondFunction;

  /**
   * Create a combination of two functions.
   *
   * @param firstFunction  first function whose output will be placed first
   * @param secondFunction second function whose output will be appended
   */
  public CombinationOperation(PrimitiveFunction firstFunction, PrimitiveFunction secondFunction) {
    this.firstFunction = firstFunction;
    this.secondFunction = secondFunction;
  }

  /**
   * Compute the concatenation of both functions' outputs for the given args.
   *
   * @param args input arguments forwarded to both functions
   * @return concatenated result array
   */
  @Override
  protected int[] compute(int... args) {
    return ArrayUtils.concat(firstFunction.apply(args), secondFunction.apply(args));
  }
}
