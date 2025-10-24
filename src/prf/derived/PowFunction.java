package prf.derived;

import prf.basic.ProjectionFunction;
import prf.core.ArityFunctionChecker;
import prf.core.PrimitiveFunction;
import prf.operators.CombinationOperation;
import prf.operators.CompositionOperation;
import prf.operators.RecursionOperation;

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
    PrimitiveFunction recursive = new CompositionOperation(mul, new CombinationOperation(projection33, projection13));

    return new RecursionOperation(base, recursive).apply(args);
  }
}
