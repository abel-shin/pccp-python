# 스택

## 스택이란

- 스택은 후입선출(Last In First Out; LIFO)의 특성을 가지는 **추상 자료형**이다.
- 자료가 입력된 순서의 역순으로 처리되어야 할 때 사용한다.
    - ex) 프로토타입 체인, 함수 콜 스택, OS 등

## 스택의 연산자

![스택의 연산자](img/section2/1.png)

1. 자료를 Top 위에 삽입하는 연산자 (Push)
    - 더 이상 삽입할 수 없는 경우 *오버플로우* 발생
1. 자료를 Top에서 꺼내는 연산자 (Pop)
    - 더 이상 꺼낼 수 없는 경우 *언더플로우* 발생
1. Top에 있는 자료를 반환하지만, 삭제하지는 않는 연산자 (Peek)
1. 스택이 비어있는지 확인하는 연산자 (Empty)

## 스택의 구현

![스택](img/section2/2.png)

- 배열을 이용하여 구현한 스택
    - 배열을 사용하므로, 크기가 정해져 있다.
    - 메모리 상에서 연속으로 존재하기 떄문에 동작 속도가 빠르다.

## Python에서 스택의 사용

- 파이썬 list를 스택으로 간단히 활용할 수 있다.

    ``` python
    stack = []
    stack.append(1)
    stack.append(12)
    stack.append(30)

    while stack:
        value = stack.pop()
        print(value) # 30, 12, 1
    ```

- 몇가지 기능이 추가된 `collections`의 `deque`를 쓸 수 있다. 성능상 이점이 있기 때문에, 빈번하게 사용된다면 이것을 사용한다.

    ``` python
    from collections import deque
    stack = deque()
    stack.append(1)
    stack.append(12)
    stack.append(30)

    while stack:
        value = stack.pop()
        print(value) # 30, 12, 1
    ```

    !!! note

        Deque는 데크(Dequeue)를 구현한 인터페이스이며, 스택과 큐 기능을 동시에 가지고 있다. 즉, 자료의 양 끝에서 입/출력이 모두 가능하다.


## 스택 문제 해결

- [프로그래머스 올바른 괄호 문제](https://school.programmers.co.kr/learn/courses/30/lessons/12909){:target="_blank"} ([답안 코드](https://github.com/abel-shin/pccp-python/blob/main/src/day3/Solution1.py){:target="_blank"})
- [프로그래머스 주식 가격 문제](https://school.programmers.co.kr/learn/courses/30/lessons/42584){:target="_blank"} ([답안 코드](https://github.com/abel-shin/pccp-python/blob/main/src/day3/Solution2.py){:target="_blank"})