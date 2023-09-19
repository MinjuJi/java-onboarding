package prac;

import java.util.List;

public class Test6 {
  public static void main(String[] args) {

    List<List<String>> forms = List.of(
        List.of("jm@email.com", "제이엠"),
        List.of("jason@email.com", "제이슨"),
        List.of("woniee@email.com", "워니"),
        List.of("mj@email.com", "엠제이"),
        List.of("nowm@email.com", "이제엠"));

    List<String> a = Problem6.solution(forms);
    System.out.println(a);
    //List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
  }
}
