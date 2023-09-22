package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
  private static final int FRIENDS_POINT = 10;
  private static final int VISIORS_POINT = 1;
  private static final int MIN_ID_LENGTH = 1;
  private static final int MAX_ID_LENGTH = 30;
  private static final int MIN_FRIENDS_SIZE = 1;
  private static final int MAX_FRIENDS_SIZE = 10000;
  private static final int MIN_VISITORS_SIZE = 0;
  private static final int MAX_VISITORS_SIZE = 10000;
  private static final String ID_REGEX_LOWERCASE = "^[a-z]*$";

  private static Set<String> userFriendsSet = new HashSet<>();
  private static Map<String, Integer> userAndScoreMap = new HashMap<>();

  public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    return null;
  }

}
