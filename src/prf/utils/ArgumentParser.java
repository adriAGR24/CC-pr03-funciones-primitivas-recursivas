package prf.utils;

public class ArgumentParser {
  
  public int base = -1;
  public int exponent = -1;

  private final String useText =
    "How to use: ./runProgram.sh -b <base> -e <exponent>\n"
  + "Try ./runProgram.sh -h for more information.";

  private final String helpText =
    "This program calculates a power from a base and an exponent given as parameters."
  + "For this, Recursive Primitive Functions are used, which are defined in the domain"
  + "of Natural Numbers (0 - inf).\n\n"
  + "Usage: ./runProgram.sh -b <base> -e <exponent>\n\n"
  + "Arguments:\n"
  + "- -b <base>: Base of the power.\n"
  + "- -e <exponent>: Exponent of the power.";

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