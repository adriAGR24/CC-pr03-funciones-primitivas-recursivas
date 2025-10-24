package prf.basic;

import prf.core.ArityFunctionChecker;

public class ProjectionFunction extends ArityFunctionChecker {
  private final int index;

  public ProjectionFunction(int index, int arity) {
    super(arity);
    if (index > arity)
      throw new IllegalArgumentException("index can not be greater than the arity in ProjectionFunction");
    if (index < 0)
      throw new IllegalArgumentException("index can not be less than 1 in ProjectionFunction");
    this.index = index - 1;
  }

  @Override
  protected int[] compute(int... args) {
    return new int[] { args[index] };
  }
}