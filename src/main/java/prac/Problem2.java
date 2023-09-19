package prac;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

  public static String solution(String cryptogram) {
    checkException(cryptogram);
    return getAnswer(cryptogram);
  }

  public static void checkException(String cryptogram) {
    if (!isValidLength(cryptogram))
      throw new IllegalArgumentException("길이가 1 이상 1000 이하인 문자열 입력");
    if (!isLowerCase(cryptogram))
      throw new IllegalArgumentException("소문자로만 이루어진 문자열 입력");
  }

  public static boolean isValidLength(String cryptogram) {
    int length = cryptogram.length();
    return length >= 1 && length <= 1000;
  }

  public static boolean isLowerCase(String cryptogram) {
    return cryptogram.matches("^[a-z]*$");
  }

  public static String getAnswer(String cryptogram) {
    while (true) {
      if (isNotMoreDelete(cryptogram))
        break;
      cryptogram = deleteOverlapChar(cryptogram);
    }
    return cryptogram;
  }

  public static boolean isNotMoreDelete(String cryptogram) {
    for (int i = 1; i < cryptogram.length(); i++) {
      if (cryptogram.charAt(i) == cryptogram.charAt(i - 1))
        return false;
    }
    return true;
  }

  public static String deleteOverlapChar(String cryptogram) {
    List<Integer> deleteIndexOfcharAt = new ArrayList<>();
    StringBuffer modifyCryptogram = new StringBuffer();

    for (int i = 1; i < cryptogram.length(); i++) {
      if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
        deleteIndexOfcharAt.add(i);
        deleteIndexOfcharAt.add(i - 1);
      }
    }

    for (int i = 0; i < cryptogram.length(); i++) {
      if (!deleteIndexOfcharAt.contains(i))
        modifyCryptogram.append(cryptogram.charAt(i));
    }

    return modifyCryptogram.toString();
  }
}
