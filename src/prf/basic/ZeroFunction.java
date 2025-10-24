package prf.basic;

import prf.core.ArityFunctionChecker;

public class ZeroFunction extends ArityFunctionChecker {
  public ZeroFunction() {
    super(1);
  }

  @Override
  protected int[] compute(int... args) {
    return new int[] { 0 };
  }
}