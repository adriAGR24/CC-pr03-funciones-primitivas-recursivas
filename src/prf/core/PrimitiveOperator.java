package prf.core;

public abstract class PrimitiveOperator implements PrimitiveFunction {

  @Override
  public final int[] apply(int... args) {
    return compute(args);
  }

  protected abstract int[] compute(int... args);
}