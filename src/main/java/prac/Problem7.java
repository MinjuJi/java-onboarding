package prac;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
    checkExeption(user, friends, visitors);
    getFriendsSet(user, friends);
    updateScoreMap(friends, visitors);
    removeUserFriends();
    return getAnswer();
  }

  private static void checkExeption(String user, List<List<String>> friends, List<String> visitors) {
    if (!isValidIdLength(user, friends, visitors))
      throw new IllegalArgumentException("유효한 ID의 길이는 1~30자입니다.");

    if (!isValidIdLowerCase(user, friends, visitors))
      throw new IllegalArgumentException("ID는 알파벳 소문자로만 이루어져야 합니다.");

    if (!isValidFriendsSize(friends))
      throw new IllegalArgumentException("리스트 friends의 크기는 1~10,000 입니다.");

    if (!isValidVisitorsSize(visitors))
      throw new IllegalArgumentException("리스트 visitors의 크기는 0~10,000 입니다.");

    if (hasDuplicates(friends))
      throw new IllegalArgumentException("리스트 friends에 중복된 요소가 있으면 안 됩니다.");
  }

  private static boolean isValidIdLength(String user, List<List<String>> friends, List<String> visitors) {
    boolean userIdLength = user.length() >= MIN_ID_LENGTH && user.length() <= MAX_ID_LENGTH;

    boolean friendsIdLength = friends.stream()
                                     .flatMap(Collection::stream)
                                     .allMatch(friend -> friend.length() >= MIN_ID_LENGTH && friend.length() <= MAX_ID_LENGTH);

    boolean visitorsIdLength = visitors.stream()
                                       .allMatch(visitor -> visitor.length() >= MIN_ID_LENGTH && visitor.length() <= MAX_ID_LENGTH);

    return userIdLength && friendsIdLength && visitorsIdLength;
  }

  private static boolean isValidIdLowerCase(String user, List<List<String>> friends, List<String> visitors) {
    boolean userIdLowerCase = user.matches(ID_REGEX_LOWERCASE);

    boolean friendsIdLowerCase = friends.stream()
                                        .flatMap(Collection::stream)
                                        .allMatch(friend -> friend.matches(ID_REGEX_LOWERCASE));

    boolean visitorsIdLowerCase = visitors.stream()
                                          .allMatch(visitor -> visitor.matches(ID_REGEX_LOWERCASE));

    return userIdLowerCase && friendsIdLowerCase && visitorsIdLowerCase;
  }

  private static boolean isValidFriendsSize(List<List<String>> friends) {
    return friends.size() >= MIN_FRIENDS_SIZE && friends.size() <= MAX_FRIENDS_SIZE;
  }

  private static boolean isValidVisitorsSize(List<String> visitors) {
    return visitors.size() >= MIN_VISITORS_SIZE && visitors.size() <= MAX_VISITORS_SIZE;
  }

  private static boolean hasDuplicates(List<List<String>> friends) {
    Set<List<String>> friendsSet = new HashSet<>();

    for (List<String> subFriends : friends) {
      List<String> temp = new ArrayList<>(subFriends);
      Collections.sort(temp);
      friendsSet.add(temp);
    }
    return friends.size() != friendsSet.size();
  }

  private static List<String> getAnswer() {
    List<String> answer = userAndScoreMap.entrySet()
                                         .stream()
                                         .sorted(Map.Entry.comparingByKey())
                                         .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                         .map(Map.Entry::getKey)
                                         .limit(5)
                                         .collect(Collectors.toList());
    return answer;
  }

  private static void removeUserFriends() {
    for (String friend : userFriendsSet) {
      userAndScoreMap.remove(friend);
    }
  }

  private static void updateScoreMap(List<List<String>> friends, List<String> visitors) {
    for (List<String> friend : friends) {
      String friend1 = friend.get(0);
      String friend2 = friend.get(1);
      if (userFriendsSet.contains(friend1) || userFriendsSet.contains(friend2)) {
        updateRecommendScore(friend1, FRIENDS_POINT);
        updateRecommendScore(friend2, FRIENDS_POINT);
      }
    }
    for (String visitor : visitors) {
      updateRecommendScore(visitor, VISIORS_POINT);
    }
  }

  private static void updateRecommendScore(String friend, int point) {
    userAndScoreMap.put(friend, userAndScoreMap.getOrDefault(friend, 0) + point);
  }

  private static void getFriendsSet(String user, List<List<String>> friends) {
    for (List<String> friend : friends) {
      if (friend.contains(user))
        userFriendsSet.addAll(friend);
    }
  }
}
