## 🚀 기능 요구 사항

레벨 2의 팀 프로젝트 미션으로 SNS(Social Networking Service)를 만들고자 하는 팀이 있다. 팀에 속한 크루 중 평소 알고리즘에 관심이 많은 미스터코는 친구 추천 알고리즘을 구현하고자 아래와 같은 규칙을 세웠다.

- 사용자와 함께 아는 친구의 수 = 10점 
- 사용자의 타임 라인에 방문한 횟수 = 1점

사용자 아이디 user와 친구 관계 정보 friends, 사용자 타임 라인 방문 기록 visitors가 매개변수로 주어질 때, 미스터코의 친구 추천 규칙에 따라 점수가 가장 높은 순으로 정렬하여 최대 5명을 return 하도록 solution 메서드를 완성하라. 이때 추천 점수가 0점인 경우 추천하지 않으며, 추천 점수가 같은 경우는 이름순으로 정렬한다.

### 제한사항

- user는 길이가 1 이상 30 이하인 문자열이다.
- friends는 길이가 1 이상 10,000 이하인 리스트/배열이다.
- friends의 각 원소는 길이가 2인 리스트/배열로 [아이디 A, 아이디 B] 순으로 들어있다.
  - A와 B는 친구라는 의미이다.
  - 아이디는 길이가 1 이상 30 이하인 문자열이다.
- visitors는 길이가 0 이상 10,000 이하인 리스트/배열이다.
- 사용자 아이디는 알파벳 소문자로만 이루어져 있다.
- 동일한 친구 관계가 중복해서 주어지지 않는다.
- 추천할 친구가 없는 경우는 주어지지 않는다.

### 실행 결과 예시

| user | friends | visitors | result |
| --- | --- | --- | --- |
| "mrko" | [ ["donut", "andole"], ["donut", "jun"], ["donut", "mrko"], ["shakevan", "andole"], ["shakevan", "jun"], ["shakevan", "mrko"] ] | ["bedi", "bedi", "donut", "bedi", "shakevan"] | ["andole", "jun", "bedi"] |

<br>

---

## 기능 구현 목록

1. 상수 및 변수 추가
2. user의 친구관계를 구하는 getFriendsSet 함수 구현
3. 친구 추천 점수를 추가하는 updateRecommendScore 함수 구현
4. 미스터코 규칙에 따라 추천 점수를 추가하는 updateScoreMap 함수 구현
5. 친구 추천 점수 Map에서 user와 user의 친구들을 제거하는 removeMyFriends 함수 구현
6. 정답을 도출하는 getAsnwer 함수 구현
7. 유효한 아이디 길이인지 검사하는 isValidIdLength 함수 구현
8. 아이디가 알파벳 소문자인지 검사하는 isValidIdLowerCase 함수 구현
9. 리스트 friends 크기가 유효한지 검사하는 isValidFriendsSize 함수 구현
10. 리스트 visitors 크기가 유효한지 검사하는 isValidVisitorsSize 함수 구현
11. friends에 중복된 요소가 있는지 검사하는 hasDuplicates 함수 구현
12. 추천 친구가 없는 경우 예외를 발생시키는 hasNoRecommendedFriends 함수 구현
13. 제한사항을 처리하는 checkException 함수 구현
14. solution 함수 구현
