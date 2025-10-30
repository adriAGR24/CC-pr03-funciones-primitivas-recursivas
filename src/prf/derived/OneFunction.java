package prf.derived;

import prf.basic.SuccessorFunction;
import prf.basic.ZeroFunction;
import prf.core.ArityFunctionChecker;
import prf.core.PrimitiveFunction;
import prf.operators.CompositionOperation;

/**
 * Constant-one function built by composing successor and zero functions.
 *
 * <p>Although defined with arity 1 in this project, it returns the constant
 * value 1 for any input (natural number), implemented via composition.</p>
 */
public class OneFunction extends ArityFunctionChecker {
  /** Create the one function (expects one argument). */
  public OneFunction() {
    super(1);
  }

  /**
   * Compute the constant one value by composing successor and zero.
   *
   * @param args single-element array (value ignored)
   * @return single-element array containing 1
   */
  @Override
  protected int[] compute(int... args) {
    PrimitiveFunction zero = new ZeroFunction();
    PrimitiveFunction successor = new SuccessorFunction();
    return new CompositionOperation(successor, zero).apply(args);
  }
}
