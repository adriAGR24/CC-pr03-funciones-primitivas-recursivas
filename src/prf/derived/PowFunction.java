package prf.derived;

import prf.basic.ProjectionFunction;
import prf.core.ArityFunctionChecker;
import prf.core.PrimitiveFunction;
import prf.operators.CombinationOperation;
import prf.operators.CompositionOperation;
import prf.operators.RecursionOperation;

/**
 * Exponentiation (power) implemented as a primitive recursive function.
 *
 * <p>Expect two arguments: base and exponent. Uses multiplication and recursion
 * to compute base^exponent.</p>
 */
public class PowFunction extends ArityFunctionChecker {
  /** Create a power function requiring exactly two arguments (base, exponent). */
  public PowFunction() {
    super(2);
  }

  /**
   * Compute base raised to exponent using primitive recursion.
   *
   * @param args two-element array: {base, exponent}
   * @return single-element array with base^exponent
   */
  @Override
  protected int[] compute(int... args) {
    PrimitiveFunction base = new OneFunction();
    
    PrimitiveFunction mul = new MulFunction();
    PrimitiveFunction projection13 = new ProjectionFunction(1, 3);
    PrimitiveFunction projection33 = new ProjectionFunction(3, 3);
    PrimitiveFunction recursive = new CompositionOperation(mul, new CombinationOperation(projection33, projection13));

    return new RecursionOperation(base, recursive).apply(args);
  }
}
