package prf.operators;

import prf.core.PrimitiveFunction;
import prf.core.PrimitiveOperation;
import prf.utils.ArrayUtils;

public class CombinationOperation extends PrimitiveOperation {
  private final PrimitiveFunction firstFunction;
  private final PrimitiveFunction secondFunction;

  public CombinationOperation(PrimitiveFunction firstFunction, PrimitiveFunction secondFunction) {
    this.firstFunction = firstFunction;
    this.secondFunction = secondFunction;
  }

  @Override
  protected int[] compute(int... args) {
    return ArrayUtils.concat(firstFunction.apply(args), secondFunction.apply(args));
  }
}
