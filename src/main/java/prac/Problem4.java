package prac;

public class Problem4 {

  private static final int MIN_LENGTH = 1;
  private static final int MAX_LENGTH = 1000;

  public static String solution(String word) {
    if (!isValidRangeString(word))
      throw new IllegalArgumentException("유효한 문자열의 길이를 입력해주세요. (1~1000자)");

    String answer = getAnswer(word);
    return answer;
  }

  public static boolean isValidRangeString(String word) {
    int length = word.length();
    return length >= MIN_LENGTH && length <= MAX_LENGTH;
  }

  public static String getAnswer(String word) {
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < word.length(); i++) {
      char alphabet = word.charAt(i);
      sb.append(getFrogWord(alphabet));
    }
    return sb.toString();
  }

  public static char getFrogWord(char alphabet) {
    if (Character.isUpperCase(alphabet))
      return (char) ('A' + ('Z' - alphabet));

    if (Character.isLowerCase(alphabet))
      return (char) ('a' + ('z' - alphabet));

    return alphabet;
  }
}
