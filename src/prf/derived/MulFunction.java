package prf.derived;

import prf.basic.ProjectionFunction;
import prf.basic.ZeroFunction;
import prf.core.ArityFunctionChecker;
import prf.core.PrimitiveFunction;
import prf.operators.CombinationOperator;
import prf.operators.CompositionOperator;
import prf.operators.RecursionOperator;

public class MulFunction extends ArityFunctionChecker {
  public MulFunction() {
    super(2);
  }

  @Override
  protected int[] compute(int... args) {
    PrimitiveFunction base = new ZeroFunction();
    
    PrimitiveFunction add = new AddFunction();
    PrimitiveFunction projection13 = new ProjectionFunction(1, 3);
    PrimitiveFunction projection33 = new ProjectionFunction(3, 3);
    PrimitiveFunction recursive = new CompositionOperator(add, new CombinationOperator(projection33, projection13));

    return new RecursionOperator(base, recursive).apply(args);
  }
}
