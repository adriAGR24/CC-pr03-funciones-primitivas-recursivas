package prf.core;

public final class FunctionLogger {
  private static int callCount = 0;

  private FunctionLogger() {}

  public static void incrementCallCount() {
    callCount++;
  } 

  public static int getCallCount() {
    return callCount;
  }

  public static void reset() {
    callCount = 0;
  }
}