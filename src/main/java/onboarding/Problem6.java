package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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

  private static List<String> getAnswer(List<List<String>> forms) {
    HashMap<String, String> separatedNicknameAndEmail = new HashMap<>();

    List<String> answer = forms.stream()
                               .map(form -> getInvalidEmails(separatedNicknameAndEmail, form))
                               .flatMap(Collection::stream)
                               .distinct()
                               .sorted()
                               .collect(Collectors.toList());
    return answer;
  }

  private static List<String> getInvalidEmails(HashMap<String, String> separatedNicknameAndEmail, List<String> form) {
    List<String> result = new ArrayList<>();

    String email = getEmail(form);
    String nickname = getNickname(form);

    for (int i = 0; i < nickname.length() - 1; i++) {
      String separatedNickname = nickname.substring(i, i + 2);
      String InvalidEmail = separatedNicknameAndEmail.putIfAbsent(separatedNickname, email);
      if (InvalidEmail != null) {
        result.add(InvalidEmail);
        result.add(email);
      }
    }
    return result;
  }

  private static String getEmail(List<String> form) {
    return form.get(INDEX_EMAIL);
  }

  private static String getNickname(List<String> form) {
    return form.get(INDEX_NICKNAME);
  }

  private static boolean isValidCrewRange(List<List<String>> forms) {
    return forms.size() >= MIN_NUMBER_CREW && forms.size() <= MAX_NUMBER_CREW;
  }

  private static boolean isValidEmailRegex(List<List<String>> forms) {
    return forms.stream()
                .allMatch(form -> getEmail(form).matches(REGEX_EMAIL));
  }

  private static boolean isValidDomain(List<List<String>> forms) {
    return forms.stream()
                .allMatch(form -> getEmail(form).contains(DOMAIN_EMAIL));
  }

  private static boolean isValidEmailLength(List<List<String>> forms) {
    return forms.stream()
                .allMatch(form -> getEmail(form).length() >= MIN_LENGTH_EMAIL && getEmail(form).length() <= MAX_LENGTH_EMAIL);
  }

}
