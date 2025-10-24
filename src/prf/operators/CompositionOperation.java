package prf.operators;

import prf.core.PrimitiveFunction;
import prf.core.PrimitiveOperation;

public class CompositionOperation extends PrimitiveOperation {
  private final PrimitiveFunction outter;
  private final PrimitiveFunction inner;
  
  public CompositionOperation(PrimitiveFunction outter, PrimitiveFunction inner) {
    this.outter = outter;
    this.inner = inner;
  }

  @Override
  protected int[] compute(int... args) {
    return outter.apply(inner.apply(args));
  }
}
