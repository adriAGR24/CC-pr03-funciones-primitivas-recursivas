package prf.derived;

import prf.basic.SuccessorFunction;
import prf.basic.ZeroFunction;
import prf.core.ArityFunctionChecker;
import prf.core.PrimitiveFunction;
import prf.operators.CompositionOperation;

public class OneFunction extends ArityFunctionChecker {
  public OneFunction() {
    super(1);
  }

  @Override
  protected int[] compute(int... args) {
    PrimitiveFunction zero = new ZeroFunction();
    PrimitiveFunction successor = new SuccessorFunction();
    return new CompositionOperation(successor, zero).apply(args);
  }
}
