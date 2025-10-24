package prf.derived;

import prf.basic.ProjectionFunction;
import prf.core.ArityFunctionChecker;
import prf.core.PrimitiveFunction;
import prf.operators.CombinationOperator;
import prf.operators.CompositionOperator;
import prf.operators.RecursionOperator;

public class PowFunction extends ArityFunctionChecker {
  public PowFunction() {
    super(2);
  }

  @Override
  protected int[] compute(int... args) {
    PrimitiveFunction base = new OneFunction();
    
    PrimitiveFunction mul = new MulFunction();
    PrimitiveFunction projection13 = new ProjectionFunction(1, 3);
    PrimitiveFunction projection33 = new ProjectionFunction(3, 3);
    PrimitiveFunction recursive = new CompositionOperator(mul, new CombinationOperator(projection33, projection13));

    return new RecursionOperator(base, recursive).apply(args);
  }
}
