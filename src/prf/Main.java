package prf;


import prf.core.FunctionLogger;
import prf.core.PrimitiveFunction;
import prf.derived.PowFunction;
import prf.utils.ArgumentParser;

public class Main {
  public static void main(String[] args) {
    try {
      ArgumentParser parser = new ArgumentParser(args);
      PrimitiveFunction pow = new PowFunction();
      System.out.println("\u001b[1m\u001b[4m" +
                         "Result of " + parser.base + "^" + parser.exponent +
                         "\u001b[0m");
      System.out.println(pow.apply(parser.base, parser.exponent)[0]);
      System.out.println();
      System.out.println("\u001b[1m\u001b[4mCall Count\u001b[0m");
      System.out.println(FunctionLogger.getCallCount());
    } catch (Exception error) {
      System.err.println("ERROR: " + error.getMessage());
      System.exit(1);
    }
  }
}