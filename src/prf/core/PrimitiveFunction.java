package prf.core;

/**
 * Functional interface representing a primitive function in the system.
 *
 * <p>Implementations accept zero or more integer arguments and return an array
 * of integers as the result. Most concrete functions will expect a fixed
 * arity and validate arguments before computing results.</p>
 */
@FunctionalInterface
public interface PrimitiveFunction {
  /**
   * Apply the function to the given arguments.
   *
   * @param args input arguments
   * @return output values as int array
   */
  int[] apply(int... args);
}