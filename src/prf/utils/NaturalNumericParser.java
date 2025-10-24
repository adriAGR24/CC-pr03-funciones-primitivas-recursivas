package prf.utils;

public class NaturalNumericParser {
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