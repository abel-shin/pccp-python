# 문자열

## 문자열 탐색

- 문자열(String)은 수정이 불가능하기 떄문에, 내용을 탐색하는 것이 주로 출제
- 문자열은 실무에서도 빈번하게 다루게 되므로, 꼭 잘 익혀두어야 한다!
- 문자열의 메소드를 잘 조합하여 필요한 기능을 구현하는 것이 핵심
- 다루는 문자열이 점점 길어질 경우, **StringBuilder**를 사용하여 효율적으로 구현

## 문자열 관련 메소드

| 메소드 | 메소드 선언 | 설명 |
|-------|-----------|------|
|length()| `public int length()`| 문자열의 길이를 출력 |
|charAt()| `public char charAt(int index)`| index번째에 위치한 문자 출력 |
|indexOf()| `public int indexOf(char ch)` | ch가 위치한 index 출력. 없을 시 -1 |
|equals()| `public boolean equals(Object anObject)` | anObject와 비교한 결과 출력 |
|equalsIgnoreCase()| `public boolean equalsIgnoreCase(String anotherString)` | 대소문자 구분없이 anotherString과 비교 결과 출력 |
|replace()| `public String replace(char odlChar, char newChar)` | oldChar를 찾아 newChar로 변경된 문자열 출력 |
|substring()| `public String substring(int beginIndex, int endIndex)` | 문자열을 beginIndex부터 endIndex-1까지 잘라서 출력 |
|trim()| `public String trim()` | 문자열 좌우 공백을 없앤 결과를 출력 |
|matches()| `public boolean matches(String regex)` | 문자열을 정규표현식 regex 확인 결과 출력 |
|split()| `public String[] split(String regex)` | 문자열을 정규표현식 형태로 나눈 후 배열로 출력 |

## StringBuilder

- 아래와 같은 코드로 문자열을 결합할 경우, for문을 반복할 때 마다 새로운 문자열을 생성한다.

    ``` java title="Don't do like this"
    String s = "";
    String[] strings = {"I", "want", "to", "concatenate", "all", "strings"};

    for (int i = 0; i < strings.length; i++) {
        s += strings + " "; // 이 라인이 실행될 때 마다 새로운 문자열을 계속 생성
    }
    System.out.println(s); // I want to concatenate all strings
    ```

- StringBuilder를 사용하면 마지막에 단 한번의 문자열만을 생성하여 효율적으로 동작한다.

    ``` java
    StringBuilder sb = new StringBuilder();
    String[] strings = {"I", "want", "to", "concatenate", "all", "strings"};

    for (int i = 0; i < strings.length; i++) {
        sb.append(strings);
        sb.append(" ");
    }
    String s = sb.toString();
    System.out.println(s); // I want to concatenate all strings
    ```

- 배열이나 리스트에 있는 문자열들을 결합하려면 `join` 메소드를 사용할 수도 있다. (Java8 and above)

    ``` java
    String[] strings = {"I", "want", "to", "concatenate", "all", "strings"};
    String s = String.join(" ", strings);
    System.out.println(s); // I want to concatenate all strings
    ```

- Stream에 있는 문자열들을 결합하려면 `Collectors.joining()`을 사용할 수도 있다.

    ``` java
    String[] strings = {"I", "want", "to", "concatenate", "all", "strings"};
    String s = Arrays.stream(strings).collect(Collectors.joining(" "));
    System.out.println(s); // I want to concatenate all strings
    ```


## 문자열 문제 풀이

- [프로그래머스 문자열 밀기 문제](https://school.programmers.co.kr/learn/courses/30/lessons/120921){:target="_blank"} ([답안 코드](https://github.com/abel-shin/pccp-java/blob/main/src/day1/Solution1.java){:target="_blank"})
- [프로그래머스 문자열 나누기 문제](https://school.programmers.co.kr/learn/courses/30/lessons/140108){:target="_blank"} ([답안 코드](https://github.com/abel-shin/pccp-java/blob/main/src/day1/Solution2.java){:target="_blank"})