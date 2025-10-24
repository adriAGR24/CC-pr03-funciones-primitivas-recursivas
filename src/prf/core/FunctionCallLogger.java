package prf.core;

public final class FunctionCallLogger {
  private static int callCount = 0;

  private FunctionCallLogger() {}

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