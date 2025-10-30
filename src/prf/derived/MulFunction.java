package prf.derived;

import prf.basic.ProjectionFunction;
import prf.basic.ZeroFunction;
import prf.core.ArityFunctionChecker;
import prf.core.PrimitiveFunction;
import prf.operators.CombinationOperation;
import prf.operators.CompositionOperation;
import prf.operators.RecursionOperation;

/**
 * Multiplication implemented as a primitive recursive function.
 *
 * <p>This function expects two arguments and uses addition and recursion to
 * compute the product.</p>
 */
public class MulFunction extends ArityFunctionChecker {
  /** Create a multiplication function that requires exactly two arguments. */
  public MulFunction() {
    super(2);
  }

  /**
   * Compute the product of two natural numbers using primitive recursion.
   *
   * @param args two-element array containing the operands
   * @return single-element array with the product
   */
  @Override
  protected int[] compute(int... args) {
    PrimitiveFunction base = new ZeroFunction();
    
    PrimitiveFunction add = new AddFunction();
    PrimitiveFunction projection13 = new ProjectionFunction(1, 3);
    PrimitiveFunction projection33 = new ProjectionFunction(3, 3);
    PrimitiveFunction recursive = new CompositionOperation(add, new CombinationOperation(projection33, projection13));

    return new RecursionOperation(base, recursive).apply(args);
  }
}
