package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

  private static final int MIN_CREW_COUNT = 1;
  private static final int MAX_CREW_COUNT = 10000;
  private static final int MIN_EMAIL_LENGTH = 11;
  private static final int MAX_EMAIL_LENGTH = 20;
  private static final int MIN_NICKNAME_LENGTH = 1;
  private static final int MAX_NICKNAME_LENGTH = 20;
  private static final String NAME_REGEX = "^[가-힣]*$";
  private static final String EMAIL_REGEX = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
  private static final String VALID_DOMAIN = "email.com";
  private static final int EMAIL_INDEX = 0;
  private static final int NICKNAME_INDEX = 1;

  public static List<String> solution(List<List<String>> forms) {
    checkException(forms);
    return getAnswer(forms);
  }

  private static List<String> getAnswer(List<List<String>> forms) {
    HashMap<String, String> separatedNicknameToEmail = new HashMap<>();

    List<String> answer = forms.stream()
                               .map(form -> getInvalidEmails(separatedNicknameToEmail, form))
                               .flatMap(Collection::stream)
                               .distinct()
                               .sorted()
                               .collect(Collectors.toList());

    return answer;
  }

  private static List<String> getInvalidEmails(HashMap<String, String> separatedNicknameToEmail, List<String> form) {
    List<String> result = new ArrayList<>();

    String email = getEmail(form);
    String nickname = getNickname(form);

    for (int i = 0; i < nickname.length() - 1; i++) {
      String separatedNickname = nickname.substring(i, i + 2);
      String invalidEmail = separatedNicknameToEmail.putIfAbsent(separatedNickname, email);
      if (invalidEmail != null) {
        result.add(invalidEmail);
        result.add(email);
      }
    }
    return result;
  }

  private static String getEmail(List<String> form) {
    return form.get(EMAIL_INDEX);
  }

  private static String getNickname(List<String> form) {
    return form.get(NICKNAME_INDEX);
  }

  private static void checkException(List<List<String>> forms) {
    if (!isValidCrewRange(forms))
      throw new IllegalArgumentException("크루원은 1명 이상 10,000명 이하입니다.");

    if (!isValidEmailRegex(forms))
      throw new IllegalArgumentException("이메일 형식(@)으로 입력해주세요.");

    if (!isValidDomain(forms))
      throw new IllegalArgumentException("유효한 이메일의 도메인은 [email.com] 입니다.");

    if (!isValidEmailLength(forms))
      throw new IllegalArgumentException("유효한 이메일의 길이는 11 ~ 19자 입니다.");

    if (!isValidNicknameRegex(forms))
      throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");

    if (!isValidNicknameLength(forms))
      throw new IllegalArgumentException("유효한 닉네임의 길이는 1 ~ 19자 입니다.");
  }

  private static boolean isValidCrewRange(List<List<String>> forms) {
    return forms.size() >= MIN_CREW_COUNT && forms.size() <= MAX_CREW_COUNT;
  }

  private static boolean isValidEmailRegex(List<List<String>> forms) {
    return forms.stream()
                .allMatch(form -> getEmail(form).matches(EMAIL_REGEX));
  }

  private static boolean isValidDomain(List<List<String>> forms) {
    return forms.stream()
                .allMatch(form -> getEmail(form).contains(VALID_DOMAIN));
  }

  private static boolean isValidEmailLength(List<List<String>> forms) {
    return forms.stream()
                .allMatch(form -> getEmail(form).length() >= MIN_EMAIL_LENGTH && getEmail(form).length() < MAX_EMAIL_LENGTH);
  }

  private static boolean isValidNicknameRegex(List<List<String>> forms) {
    return forms.stream()
                .allMatch(form -> getNickname(form).matches(NAME_REGEX));
  }

  private static boolean isValidNicknameLength(List<List<String>> forms) {
    return forms.stream()
                .allMatch(form -> getNickname(form).length() >= MIN_NICKNAME_LENGTH && getNickname(form).length() < MAX_NICKNAME_LENGTH);
  }
}
