package prf.basic;

import prf.core.ArityFunctionChecker;

/**
 * Projection function (also called projection/projection operator).
 *
 * <p>This primitive function returns the i-th argument as a single-element
 * array. It verifies its expected arity via {@link ArityFunctionChecker}.
 * Indices used by callers are 1-based; the stored index is 0-based.</p>
 */
public class ProjectionFunction extends ArityFunctionChecker {
  private final int index;

  /**
   * Construct a projection function that returns the {@code index}-th argument.
   *
   * @param index 1-based index of the argument to project (must be between
   *              1 and {@code arity})
   * @param arity expected number of arguments for this function
   * @throws IllegalArgumentException if the provided index is out of range
   */
  public ProjectionFunction(int index, int arity) {
    super(arity);
    if (index > arity)
      throw new IllegalArgumentException("index can not be greater than the arity in ProjectionFunction");
    if (index < 0)
      throw new IllegalArgumentException("index can not be less than 1 in ProjectionFunction");
    this.index = index - 1;
  }

  /**
   * Return the projected argument as a single-element array.
   *
   * @param args input arguments
   * @return single-element array containing the selected argument
   */
  @Override
  protected int[] compute(int... args) {
    return new int[] { args[index] };
  }
}