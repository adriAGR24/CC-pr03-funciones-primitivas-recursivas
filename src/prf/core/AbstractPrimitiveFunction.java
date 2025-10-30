package prf.core;

/**
 * Base implementation for primitive functions that handles common behavior.
 *
 * <p>This abstract class increments the global function call counter each
 * time a primitive function is applied, then delegates actual computation to
 * {@link #compute(int...)}.</p>
 */
public abstract class AbstractPrimitiveFunction implements PrimitiveFunction {

  /**
   * Apply this primitive function to the provided arguments.
   *
   * <p>This method increments the global call counter and then calls
   * {@link #compute(int...)} to obtain the result.</p>
   *
   * @param args input arguments
   * @return result array produced by the concrete implementation
   */
  @Override
  public int[] apply(int... args) {
    FunctionCallLogger.incrementCallCount();
    return compute(args);
  }

  /**
   * Concrete implementations provide the computation logic here.
   *
   * @param args input arguments
   * @return result as an int array
   */
  protected abstract int[] compute(int... args);
}