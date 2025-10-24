package prf.operators;

import prf.core.PrimitiveFunction;
import prf.core.PrimitiveOperator;

public class CompositionOperator extends PrimitiveOperator {
  private final PrimitiveFunction outter;
  private final PrimitiveFunction inner;
  
  public CompositionOperator(PrimitiveFunction outter, PrimitiveFunction inner) {
    this.outter = outter;
    this.inner = inner;
  }

  @Override
  protected int[] compute(int... args) {
    return outter.apply(inner.apply(args));
  }
}
