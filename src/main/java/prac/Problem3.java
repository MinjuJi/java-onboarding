package prac;

public class Problem3 {

  private static final char THREE = '3';
  private static final char SIX = '6';
  private static final char NINE = '9';
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 10000;

  public static int solution(int number) {
    if (!isValidRangeNumberException(number))
      throw new IllegalArgumentException("1 ~ 10,000 자연수 입력해주세요.");
    return getAnswer(number);

  }

  public static boolean isValidRangeNumberException(int number) {
    return number >= MIN_NUMBER && number <= MAX_NUMBER;
  }

  public static int getAnswer(int number) {
    int count = 0;
    for (int i = 1; i <= number; i++) {
      String numberStr = makeStringNumber(i);
      count += getClapCount(numberStr);
    }
    return count;
  }

  public static String makeStringNumber(int number) {
    return String.valueOf(number);
  }

  public static int getClapCount(String numberStr) {
    int count = 0;
    for (int i = 0; i < numberStr.length(); i++) {
      char numTypeOfChar = numberStr.charAt(i);
      if (isClapTiming(numTypeOfChar))
        count++;
    }
    return count;
  }

  public static boolean isClapTiming(char numTypeOfChar) {
    if (numTypeOfChar == THREE || numTypeOfChar == SIX || numTypeOfChar == NINE)
      return true;
    return false;
  }
}
