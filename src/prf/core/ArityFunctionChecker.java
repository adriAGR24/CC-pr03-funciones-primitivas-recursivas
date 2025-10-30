package prf.core;

/**
 * Utility abstract class that enforces a fixed arity for a primitive function.
 *
 * <p>Subclasses declare an expected {@code arity} and calls to {@link #apply(int...)}
 * are checked against it. If the provided number of arguments does not match
 * the expected arity, an {@link IllegalArgumentException} is thrown.</p>
 */
public abstract class ArityFunctionChecker extends AbstractPrimitiveFunction {

  private final int arity;

  /**
   * Create a checker that requires {@code arity} arguments.
   *
   * @param arity expected number of arguments
   */
  protected ArityFunctionChecker(int arity) {
    this.arity = arity;
  }

  /**
   * Apply the function after verifying argument count.
   *
   * @param args input arguments
   * @return result produced by the concrete implementation
   * @throws IllegalArgumentException when {@code args.length != arity}
   */
  @Override
  public final int[] apply(int... args) {
    if (args.length != arity) {
      throw new IllegalArgumentException(
        String.format(
          "%s expected %d arguments, but received %d",
          this.getClass().getSimpleName(), arity, args.length
        )
      );
    }
    return super.apply(args);
  }
}
