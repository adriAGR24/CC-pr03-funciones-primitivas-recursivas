package prf.operators;

import prf.core.PrimitiveFunction;
import prf.core.PrimitiveOperation;

/**
 * Composition operator: applies the inner function first and passes its result
 * as arguments to the outer function.
 */
public class CompositionOperation extends PrimitiveOperation {
  private final PrimitiveFunction outter;
  private final PrimitiveFunction inner;
  
  /**
   * Create a composition of two functions: {@code outter(inner(args))}.
   *
   * @param outter function applied after the inner function
   * @param inner  function applied to the original arguments
   */
  public CompositionOperation(PrimitiveFunction outter, PrimitiveFunction inner) {
    this.outter = outter;
    this.inner = inner;
  }

  /**
   * Compute the composed result.
   *
   * @param args input arguments forwarded to {@code inner}
   * @return result of {@code outter.apply(inner.apply(args))}
   */
  @Override
  protected int[] compute(int... args) {
    return outter.apply(inner.apply(args));
  }
}
