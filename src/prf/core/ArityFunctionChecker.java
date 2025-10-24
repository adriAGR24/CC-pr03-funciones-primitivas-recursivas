package prf.core;

public abstract class ArityFunctionChecker extends AbstractPrimitiveFunction {

  private final int arity;

  protected ArityFunctionChecker(int arity) {
    this.arity = arity;
  }

  @Override
  public final int[] apply(int... args) {
    if (args.length != arity) {
      throw new IllegalArgumentException(
        String.format(
          "%s expected %d arguments, but received %d",
          this.getClass().getSimpleName(), arity, args.length
        )
      );
    }
    return super.apply(args);
  }
}
