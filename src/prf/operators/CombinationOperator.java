package prf.operators;

import prf.core.PrimitiveFunction;
import prf.core.PrimitiveOperator;
import prf.utils.ArrayUtils;

public class CombinationOperator extends PrimitiveOperator {
  private final PrimitiveFunction firstFunction;
  private final PrimitiveFunction secondFunction;

  public CombinationOperator(PrimitiveFunction firstFunction, PrimitiveFunction secondFunction) {
    this.firstFunction = firstFunction;
    this.secondFunction = secondFunction;
  }

  @Override
  protected int[] compute(int... args) {
    return ArrayUtils.concat(firstFunction.apply(args), secondFunction.apply(args));
  }
}
