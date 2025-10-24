package prf.basic;

import prf.core.ArityFunctionChecker;

public class SuccessorFunction extends ArityFunctionChecker {
  public SuccessorFunction() {
    super(1);
  }

  @Override
  protected int[] compute(int... args) {
    return new int[] { args[0] + 1 };
  }
}