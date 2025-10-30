package prf.derived;

import prf.basic.ProjectionFunction;
import prf.basic.SuccessorFunction;
import prf.core.ArityFunctionChecker;
import prf.core.PrimitiveFunction;
import prf.operators.CompositionOperation;
import prf.operators.RecursionOperation;

/**
 * Addition implemented as a primitive recursive function.
 *
 * <p>It expects two arguments (x, y) and computes x + y using recursion:
 * a base function and a recursive step composed with the successor.</p>
 */
public class AddFunction extends ArityFunctionChecker {
  /** Create an addition function requiring exactly two arguments. */
  public AddFunction() {
    super(2);
  }
  
  /**
   * Compute the sum of two natural numbers using primitive recursion.
   *
   * @param args two-element array containing the operands
   * @return single-element array with the sum
   */
  @Override
  protected int[] compute(int... args) {
    PrimitiveFunction base = new ProjectionFunction(1, 1);

    PrimitiveFunction successor = new SuccessorFunction();
    PrimitiveFunction projection33 = new ProjectionFunction(3, 3);
    PrimitiveFunction recursive = new CompositionOperation(successor, projection33);

    return new RecursionOperation(base, recursive).apply(args);
  }
}
