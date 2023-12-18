# 문자열

## 문자열 탐색

- 문자열(String)은 수정이 불가능하기 때문에, 내용을 탐색하는 것이 주로 출제
- 문자열은 실무에서도 빈번하게 다루게 되므로, 꼭 잘 익혀두어야 한다!
- 문자열의 메소드를 잘 조합하여 필요한 기능을 구현하는 것이 핵심

## 문자열 관련 기능

| 기능 | 설명 |
|------------|------|
|len()| 문자열의 길이를 출력 |
|String.strip(s)| 앞/뒤의 불필요한 공백(또는 s에 포함된 문자열) 제거 |
|String.lstrip(s)| 앞의 불필요한 공백(또는 s에 포함된 문자열) 제거 |
|String.rstrip(s)| 뒤의 불필요한 공백(또는 s에 포함된 문자열) 제거 |
|String.replace(a, b)| 문자열 a를 모두 찾아 b로 변경 |
|String.index(s)| 문자열 s를 찾아 인덱스 반환(없으면 ValueError) |
|String.find(s)| 문자열 s를 찾아 인덱스 반환(없으면 -1 반환) |
|String.format()| 문자열 포매팅 ({}와 format 메소드 활용) |
|% 연산자| 문자열 포매팅 (%를 이용한 포매팅) |
|[] 연산자| 문자열 인덱싱 |
|:연산자| 문자열 슬라이싱(리스트와 동일) |
|list.join()| 사이에 문자열을 끼워 넣어서 문자열을 연결 |
|+연산자| 문자열 이어 붙이기 |
|*연산자| 문자열 반복하기 |

## 그 외 모든 메소드 참조

- [문자열 모든 메소드](https://www.w3schools.com/python/python_ref_string.asp){:target="_blank"}

## 문자열 문제 풀이

- [프로그래머스 문자열 밀기 문제](https://school.programmers.co.kr/learn/courses/30/lessons/120921){:target="_blank"} ([답안 코드](https://github.com/abel-shin/pccp-python/blob/main/src/day1/Solution1.py){:target="_blank"})
- [프로그래머스 문자열 나누기 문제](https://school.programmers.co.kr/learn/courses/30/lessons/140108){:target="_blank"} ([답안 코드](https://github.com/abel-shin/pccp-python/blob/main/src/day1/Solution2.py){:target="_blank"})