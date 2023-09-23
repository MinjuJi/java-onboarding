package prac;

import java.util.List;

public class Test7 {
  public static void main(String[] args) {

    String user = "mrko";

    //// 원본 테스트
    //    List<List<String>> friends = List.of(
    //        List.of("donut", "andole"),
    //        List.of("donut", "jun"),
    //        List.of("donut", "mrko"),
    //        List.of("shakevan", "andole"),
    //        List.of("shakevan", "jun"),
    //        List.of("shakevan", "mrko"));
    //    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
    //    List<String> answer = Problem7.solution(user, friends, visitors);
    //    System.out.println(answer);
    //    // List<String> result = List.of("andole", "jun", "bedi");

    //// friends에 user와 관계된 친구만 있는 경우
    //        List<List<String>> friends = List.of(
    //            List.of("donut", "mrko"),
    //            List.of("shakevan", "mrko"));
    //        List<String> visitors = List.of("donut", "minju", "shakevan");
    //        List<String> answer = Problem7.solution(user, friends, visitors);
    //        System.out.println(answer);
    //        // List<String> result = List.of("minju");

    //// friends에 user와 전혀 연관없는 요소가 있는 경우
    //    List<List<String>> friends = List.of(
    //        List.of("donut", "andole"),
    //        List.of("donut", "jun"),
    //        List.of("donut", "mrko"),
    //        List.of("shakevan", "andole"),
    //        List.of("shakevan", "jun"),
    //        List.of("shakevan", "mrko"),
    //        List.of("minju", "sana"));
    //    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
    //    List<String> answer = Problem7.solution(user, friends, visitors);
    //    System.out.println(answer);
    //    // List<String> result = List.of("andole", "jun");

    //// friedns에 중복된 값이 있는 경우
    //    List<List<String>> friends = List.of(
    //        List.of("donut", "andole"),
    //        List.of("donut", "jun"),
    //        //        List.of("donut", "jun"),
    //        //        List.of("jun", "donut"),
    //        List.of("donut", "mrko"),
    //        List.of("shakevan", "andole"),
    //        List.of("shakevan", "jun"),
    //        List.of("shakevan", "mrko"));
    //    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
    //    List<String> answer = Problem7.solution(user, friends, visitors);
    //    System.out.println(answer);
    //    // 오류 발생 or [andole, jun, bedi]

    //// 추천 친구가 없는 경우
    List<List<String>> friends = List.of(
        List.of("donut", "mrko"),
        List.of("shakevan", "mrko"),
        List.of("minju", "sana"),
        List.of("donut", "shakevan"));
    List<String> visitors = List.of("donut", "shakevan");
    List<String> answer = Problem7.solution(user, friends, visitors);
    System.out.println(answer);
    // 오류 발생

  }
}
