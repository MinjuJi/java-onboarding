package prac;

import java.util.List;

public class Problem1 {

  private static final int POBI_WIN = 1;
  private static final int CRONG_WIN = 2;
  private static final int DRAW = 0;
  private static final int EXCEPTION = -1;
  private static final int LEFT_PAGE = 0;
  private static final int RIGHT_PAGE = 1;
  private static final int MIN_PAGE = 1;
  private static final int MAX_PAGE = 400;

  public static int solution(List<Integer> pobi, List<Integer> crong) {

    if (checkException(pobi) || checkException(crong))
      return EXCEPTION;

    int ValueOfPobi = getMaxValueOfPlayer(pobi);
    int ValueOfCrong = getMaxValueOfPlayer(crong);

    if (ValueOfPobi == ValueOfCrong)
      return DRAW;

    return ValueOfPobi > ValueOfCrong ? POBI_WIN : CRONG_WIN;

  }

  public static boolean checkException(List<Integer> pages) {
    if (pages.get(LEFT_PAGE) <= MIN_PAGE || pages.get(LEFT_PAGE) > MAX_PAGE - 1 || pages.get(RIGHT_PAGE) >= MAX_PAGE || pages.get(RIGHT_PAGE) < MIN_PAGE + 1)
      return true;
    if (pages.get(LEFT_PAGE) + 1 != pages.get(RIGHT_PAGE) || pages.get(RIGHT_PAGE) % 2 != 0)
      return true;
    return false;
  }

  public static int getMaxValueOfPlayer(List<Integer> pages) {
    int leftPageMaxValue = getMaxValueOfpage(pages.get(LEFT_PAGE));
    int rightPageMaxValue = getMaxValueOfpage(pages.get(RIGHT_PAGE));
    return leftPageMaxValue >= rightPageMaxValue ? leftPageMaxValue : rightPageMaxValue;

  }

  public static int getMaxValueOfpage(int page) {
    String pageTypeOfString = String.valueOf(page);
    int sum = getSumOfPage(pageTypeOfString);
    int multiple = getMultipleOfPage(pageTypeOfString);
    return sum >= multiple ? sum : multiple;
  }

  public static int getSumOfPage(String pageTypeOfString) {
    int sum = 0;
    for (int i = 0; i < pageTypeOfString.length(); i++) {
      int tmp = pageTypeOfString.charAt(i) - '0';
      sum += tmp;
    }
    return sum;
  }

  public static int getMultipleOfPage(String pageTypeOfString) {
    int multiple = 1;
    for (int i = 0; i < pageTypeOfString.length(); i++) {
      int tmp = pageTypeOfString.charAt(i) - '0';
      multiple *= tmp;
    }
    return multiple;
  }
}
