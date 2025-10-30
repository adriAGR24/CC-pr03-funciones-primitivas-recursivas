package prf.core;

/**
 * Simple global logger that counts how many primitive function calls have been
 * performed during the program execution.
 *
 * <p>This class is intentionally minimal and exposes static methods to update
 * and query the counter.</p>
 */
public final class FunctionCallLogger {
  private static int callCount = 0;

  private FunctionCallLogger() {}

  /**
   * Increment the global function call counter by one.
   */
  public static void incrementCallCount() {
    callCount++;
  } 

  /**
   * Return the current value of the global function call counter.
   *
   * @return number of primitive function calls recorded so far
   */
  public static int getCallCount() {
    return callCount;
  }

  /**
   * Reset the global call counter to zero.
   */
  public static void reset() {
    callCount = 0;
  }
}