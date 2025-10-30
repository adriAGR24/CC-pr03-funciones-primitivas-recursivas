package prf.utils;

/**
 * Utility to parse natural numbers (0 and positive integers) from strings.
 */
public class NaturalNumericParser {
  /**
   * Parse a non-negative integer from the provided string.
   *
   * @param stringToParse the input string to parse
   * @return parsed non-negative integer
   * @throws IllegalArgumentException when the string is not a valid integer or
   *         when the resulting value is negative
   */
  public static int fromString(String stringToParse) {
    int parsedInt;
    try {
      parsedInt = Integer.parseInt(stringToParse);
    }
    catch (NumberFormatException error)
    {
      throw new IllegalArgumentException("invalid number format for input '" + stringToParse + "'");
    }

    if (parsedInt < 0)
      throw new IllegalArgumentException("invalid natural number for input '" + parsedInt + "'");
    return parsedInt;
   }
}