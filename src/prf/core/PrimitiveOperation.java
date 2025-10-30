package prf.core;

/**
 * Base class for operations that implement {@link PrimitiveFunction} but do not
 * modify the global call counter behavior from {@link AbstractPrimitiveFunction}.
 *
 * <p>This class purposely provides a final {@link #apply(int...)} that forwards
 * the call to {@link #compute(int...)} so subclasses only need to implement
 * computation logic.</p>
 */
public abstract class PrimitiveOperation implements PrimitiveFunction {

  /**
   * Apply the operation by delegating to {@link #compute(int...)}.
   *
   * @param args input arguments
   * @return computed result
   */
  @Override
  public final int[] apply(int... args) {
    return compute(args);
  }

  /**
   * Concrete computation performed by the operation.
   *
   * @param args input arguments
   * @return result as int array
   */
  protected abstract int[] compute(int... args);
}