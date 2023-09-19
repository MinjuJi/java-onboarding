package prac;

import java.util.List;

public class Test5 {
  public static void main(String[] args) {

        int money = 50_237;
        List<Integer> a = Problem5.solution(money);
        System.out.println(a);
//        List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);

        int money2 = 15_000;
        List<Integer> b = Problem5.solution(money2);
        System.out.println(b);
//        List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
        
    }
}
