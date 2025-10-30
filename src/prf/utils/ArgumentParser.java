package prf.utils;

/**
 * Parses command line arguments for the demo program.
 *
 * <p>It extracts two required natural number arguments: {@code -b <base>} and
 * {@code -e <exponent>}. If {@code -h} is provided, usage information is
 * printed and the program exits.</p>
 */
public class ArgumentParser {
  
  /** Parsed base value (natural number). */
  public int base = -1;
  /** Parsed exponent value (natural number). */
  public int exponent = -1;

  private final String useText =
    "How to use: ./runProgram.sh -b <base> -e <exponent>\n"
  + "Try ./runProgram.sh -h for more information.";

  private final String helpText =
    "This program calculates a power from a base and an exponent given as parameters. "
  + "For this, Recursive Primitive Functions are used, which are defined in the domain "
  + "of Natural Numbers (0 - inf).\n\n"
  + "Usage: ./runProgram.sh -b <base> -e <exponent>\n\n"
  + "Arguments:\n"
  + "- -b <base>: Base of the power.\n"
  + "- -e <exponent>: Exponent of the power.";

  /**
   * Parse provided command line arguments and populate {@link #base} and
   * {@link #exponent}.
   *
   * @param args raw arguments passed to {@code main}
   * @throws IllegalArgumentException when a required argument is missing or
   *         when a provided value is not a natural number
   */
  public ArgumentParser(String[] args) {
    for (int i = 0; i < args.length; ++i) {
      String argument = args[i];
      if (argument.equals("-h")) {
        System.out.println(helpText);
        System.exit(0);
      }
      else if ((argument.equals("-b")) && (i + 1 < args.length)) {
        base = NaturalNumericParser.fromString(args[++i]);
      }
      else if ((argument.equals("-e")) && (i + 1 < args.length)) {
        exponent = NaturalNumericParser.fromString(args[++i]);
      }
    }

    if (base < 0) {
      System.out.println(useText);
      throw new IllegalArgumentException("no base was provided");
    }
    if (exponent < 0) {
      System.out.println(useText);
      throw new IllegalArgumentException("no exponent was provided");
    }
  }

}