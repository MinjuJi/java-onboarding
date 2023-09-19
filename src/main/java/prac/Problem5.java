package prac;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

  private static final int MIN_MONEY = 1;
  private static final int MAX_MONEY = 1000000;
  private static final int[] MONEY_TYPE = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

  public static List<Integer> solution(int money) {
    if (!isValidRangeMoney(money))
      throw new IllegalArgumentException("유효한 범위의 돈을 입력해주세요. (1 ~ 1,000,000원");

    List<Integer> answer = getCount(money);
    return answer;
  }

  public static boolean isValidRangeMoney(int money) {
    return money >= MIN_MONEY && money <= MAX_MONEY;
  }

  public static List<Integer> getCount(int money) {
    List<Integer> result = new ArrayList<>();
    int mod = 0;
    
    for (int i = 0; i < MONEY_TYPE.length; i++) {
      if (money >= MONEY_TYPE[i]) {
        mod = money / MONEY_TYPE[i];
        money -= mod * MONEY_TYPE[i];
        result.add(mod);
        continue;
      }
      result.add(0);
    }
    return result;
  }
}
