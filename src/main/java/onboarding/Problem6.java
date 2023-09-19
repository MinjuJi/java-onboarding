package onboarding;

import java.util.List;

public class Problem6 {

  private static final int MIN_NUMBER_CREW = 1;
  private static final int MAX_NUMBER_CREW = 10000;
  private static final int MIN_LENGTH_EMAIL = 11;
  private static final int MAX_LENGTH_EMAIL = 19;
  private static final int MIN_LENGTH_NICKNAME = 1;
  private static final int MAX_LENGTH_NICKNAME = 19;
  private static final int INDEX_EMAIL = 0;
  private static final int INDEX_NICKNAME = 1;
  private static final String REGEX_EMAIL = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
  private static final String DOMAIN_EMAIL = "email.com";
  private static final String REGEX_NICKNAME = "^[가-힣]*$";

  public static List<String> solution(List<List<String>> forms) {
    List<String> answer = List.of("answer");
    return answer;
  }

  private static String getEmail(List<String> form) {
    return form.get(INDEX_EMAIL);
  }

  private static String getNickname(List<String> form) {
    return form.get(INDEX_NICKNAME);
  }
}
