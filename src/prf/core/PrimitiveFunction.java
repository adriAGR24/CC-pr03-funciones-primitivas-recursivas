package prf.core;

@FunctionalInterface
public interface PrimitiveFunction {
  int[] apply(int... args);
}