package prf;

import prf.core.FunctionCallLogger;
import prf.core.PrimitiveFunction;
import prf.derived.PowFunction;
import prf.utils.ArgumentParser;

/**
 * Entry point for the primitive recursive functions demo application.
 *
 * <p>This class parses command line arguments (base and exponent), computes
 * the power using a primitive-recursive implementation (via {@link PowFunction})
 * and prints the result together with the total number of primitive function
 * calls performed.</p>
 */
public class Main {
  /**
   * Main method and program entry point.
   *
   * @param args command line arguments. Expected flags are {@code -b <base>} and
   *             {@code -e <exponent>} (both natural numbers). The program
   *             prints usage or help text if the arguments are missing or
   *             {@code -h} is provided.
   */
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
      System.out.println(FunctionCallLogger.getCallCount());
    } catch (Exception error) {
      System.err.println("ERROR: " + error.getMessage());
      System.exit(1);
    }
  }
}