package onboarding;

import java.util.List;

class Problem1 {

	static final int LEFT_PAGE = 0;
	static final int RIGHT_PAGE = 1;
	static final int POBI_WIN = 1;
	static final int CRONG_WIN = 2;
	static final int DRAW = 0;
	static final int EXCEPTION = -1;

	public static int solution(List<Integer> pobi, List<Integer> crong) {
		int answer = Integer.MAX_VALUE;
		return answer;
	}

	public static boolean checkException(List<Integer> pages) {
		if (pages.get(LEFT_PAGE) + 1 != pages.get(RIGHT_PAGE) || pages.get(LEFT_PAGE) % 2 == 0)
			return true;
		return false;
	}

	public static int getMaxValueOfPage(int page) {
		String pageTypeOfString = String.valueOf(page);
		int sum = getSumOfPage(pageTypeOfString);
		int mul = getMultipleOfPage(pageTypeOfString);
		int max = sum > mul ? sum : mul;
		return max;
	}

	public static int getSumOfPage(String pageTypeOfString) {
		int sum = 0;
		for (int i = 0; i < pageTypeOfString.length(); i++) {
			int temp = Character.getNumericValue(pageTypeOfString.charAt(i));
			sum += temp;
		}
		return sum;
	}

	public static int getMultipleOfPage(String pageTypeOfString) {
		int multiple = 1;
		for (int i = 0; i < pageTypeOfString.length(); i++) {
			int temp = Character.getNumericValue(pageTypeOfString.charAt(i));
			multiple *= temp;
		}
		return multiple;
	}
}