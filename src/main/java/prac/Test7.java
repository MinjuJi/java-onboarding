package prac;

import java.util.List;

public class Test7 {
  public static void main(String[] args) {

    String user = "mrko";
    List<List<String>> friends = List.of(
        List.of("donut", "andole"),
        List.of("donut", "jun"),
        List.of("donut", "mrko"),
        List.of("shakevan", "andole"),
        List.of("shakevan", "jun"),
        List.of("shakevan", "mrko"));
    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

    List<String> answer = Problem7.solution(user, friends, visitors);
    System.out.println(answer);

    // List<String> result = List.of("andole", "jun", "bedi");

  }
}
