package prf.core;

public abstract class AbstractPrimitiveFunction implements PrimitiveFunction {

  @Override
  public int[] apply(int... args) {
    FunctionCallLogger.incrementCallCount();
    return compute(args);
  }

  protected abstract int[] compute(int... args);
}