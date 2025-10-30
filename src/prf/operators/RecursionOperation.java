package prf.operators;

import prf.core.FunctionCallLogger;
import prf.core.PrimitiveFunction;
import prf.core.PrimitiveOperation;
import prf.utils.ArrayUtils;

/**
 * Implements primitive recursion operator.
 *
 * <p>The recursion operator expects at least one argument. The last argument is
 * treated as the dynamic parameter that the recursion iterates over; the other
 * arguments are static and forwarded to the base/recursive functions. The
 * operator invokes {@code base} when the dynamic argument is 0, otherwise it
 * recursively computes the previous value and applies {@code recursive} to the
 * appropriate combined arguments.</p>
 */
public class RecursionOperation extends PrimitiveOperation {
  private final PrimitiveFunction base;
  private final PrimitiveFunction recursive;
  
  /**
   * Create a recursion operation given a base function and a recursive step
   * function.
   *
   * @param base base function invoked when the dynamic argument is zero
   * @param recursive function that computes the next step using previous result
   */
  public RecursionOperation(PrimitiveFunction base, PrimitiveFunction recursive) {
    this.base = base;
    this.recursive = recursive;
  }

  /**
   * Compute the value of the primitive recursive function for the given args.
   *
   * @param args input arguments where the last element is the dynamic one
   * @return result as produced by base/recursive functions
   * @throws IllegalArgumentException if no arguments are supplied
   */
  @Override
  protected int[] compute(int... args) {
    if (args.length == 0)
      throw new IllegalArgumentException("primitive recursive function can not recieve less than one argument");

    int dynamicArg = args[args.length - 1];
    if (dynamicArg == 0) {
      int[] staticArgs = ArrayUtils.removeLast(args);
      return base.apply(staticArgs.length == 0 ? new int[] {0} : staticArgs);
    }
    
    int[] prevArgs = args.clone();
    prevArgs[prevArgs.length - 1] = dynamicArg - 1;
    FunctionCallLogger.incrementCallCount();
    int[] prevRecursiveValue = compute(prevArgs);
    return recursive.apply(ArrayUtils.concat(prevArgs, prevRecursiveValue));
  }
}
