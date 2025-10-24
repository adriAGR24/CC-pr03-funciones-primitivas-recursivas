package prf.operators;

import prf.core.FunctionLogger;
import prf.core.PrimitiveFunction;
import prf.core.PrimitiveOperator;
import prf.utils.ArrayUtils;

public class RecursionOperator extends PrimitiveOperator {
  private final PrimitiveFunction base;
  private final PrimitiveFunction recursive;
  
  public RecursionOperator(PrimitiveFunction base, PrimitiveFunction recursive) {
    this.base = base;
    this.recursive = recursive;
  }

  @Override
  protected int[] compute(int... args) {
    if (args.length == 0)
      throw new IllegalArgumentException("primitive recursive function can not recieve less than one argument");

    int dynamicArg = args[args.length - 1];
    if (dynamicArg == 0) {
      int[] staticArgs = ArrayUtils.removeLast(args);
      return base.apply(staticArgs.length == 0 ? new int[] {0} : staticArgs);
    }
    
    int[] prevArgs = args.clone();
    prevArgs[prevArgs.length - 1] = dynamicArg - 1;
    FunctionLogger.incrementCallCount();
    int[] prevRecursiveValue = compute(prevArgs);
    return recursive.apply(ArrayUtils.concat(prevArgs, prevRecursiveValue));
  }
}
