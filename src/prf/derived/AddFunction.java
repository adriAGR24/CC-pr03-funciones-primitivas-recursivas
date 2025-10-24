package prf.derived;

import prf.basic.ProjectionFunction;
import prf.basic.SuccessorFunction;
import prf.core.ArityFunctionChecker;
import prf.core.PrimitiveFunction;
import prf.operators.CompositionOperation;
import prf.operators.RecursionOperation;

public class AddFunction extends ArityFunctionChecker {
  public AddFunction() {
    super(2);
  }
  
  @Override
  protected int[] compute(int... args) {
    PrimitiveFunction base = new ProjectionFunction(1, 1);

    PrimitiveFunction successor = new SuccessorFunction();
    PrimitiveFunction projection33 = new ProjectionFunction(3, 3);
    PrimitiveFunction recursive = new CompositionOperation(successor, projection33);

    return new RecursionOperation(base, recursive).apply(args);
  }
}
