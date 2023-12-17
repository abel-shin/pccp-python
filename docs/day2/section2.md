# 정렬 알고리즘

## 정렬 알고리즘이란

- 정렬 알고리즘의 조건
    - 정렬 알고리즘의 출력은 비 내림차순이다. 즉, 이전 원소는 다음 원소보다 작지 않다.
    - 정렬 알고리즘의 출력은 입력을 재배열하여 만든 순열이다.

- 알고리즘의 핵심 개념 설명에 용이
    - 점근 표기법
    - 분할 정복 알고리즘 (Divide & Conquer)
    - 최악의 경우, 최선의 경우, 평균적인 경우

## 정렬 알고리즘의 종류

- In-place 알고리즘: 정렬을 수행하는 데에 추가 메모리가 O(logN) 이하로 사용되는 알고리즘
- Stable 알고리즘: 동일 값의 정렬 전후에 순서가 유지되는 알고리즘

!!! note

    코딩테스트를 준비하기 위해 정렬 알고리즘을 암기할 필요는 없다. 대신 라이브러리로 제공되는 정렬 방법을 사용할 줄 알아야 한다.

## 기본 정렬 알고리즘

### 버블 정렬 (Bubble Sort)

![버블 정렬](https://upload.wikimedia.org/wikipedia/commons/3/37/Bubble_sort_animation.gif)
[출처](https://upload.wikimedia.org/wikipedia/commons/3/37/Bubble_sort_animation.gif){:target="_blank"}

- 알고리즘
    - 인접한 두 원소를 검사하여 정렬한다.
    - 마지막 원소를 제외하고 위 동작을 반복한다.
- 공간 복잡도: O(1)
- 시간 복잡도
    - 최악의 경우: O(n^2)
    - 최선의 경우: O(n)
    - 평균적인 경우: O(n^2)

``` python title="bubble_sort.py"
def bubble_sort(x):
    n = len(x) - 1
    for i in range(n):
        swapped = False
        for j in range(n-i):
            if (x[j] > x[j+1]):
                swapped = True
                x[j+1], x[j] = x[j], x[j+1]
        if swapped:
            break
```

### 삽입 정렬 (Insertion Sort)

![삽입 정렬](https://upload.wikimedia.org/wikipedia/commons/2/25/Insertion_sort_animation.gif)
[출처](https://upload.wikimedia.org/wikipedia/commons/2/25/Insertion_sort_animation.gif){:target="_blank"}

- 알고리즘
    - 앞 부분의 이미 정렬된 영역과, 아직 정렬되지 않은 영역으로 나눈다.
    - 정렬되지 않은 영역의 값을 정렬된 영역의 적절한 위치에 하나씩 삽입한다.
- 공간 복잡도: O(1)
- 시간 복잡도
    - 최악의 경우: O(n^2)
    - 최선의 경우: O(n)
    - 평균적인 경우: O(n^2)

``` python title="insertion_sort.py"
def insertion_sort(x):
    for i in range(1, len(x)):
        j = i-1
        key = x[i]
        while (x[j] > key and j >= 0):
            x[j+1] = x[j]
            j = j - 1
        x[j+1] = key
```

### 선택 정렬 (Selection Sort)

![선택 정렬](https://upload.wikimedia.org/wikipedia/commons/b/b0/Selection_sort_animation.gif)
[출처](https://upload.wikimedia.org/wikipedia/commons/b/b0/Selection_sort_animation.gif){:target="_blank"}

- 알고리즘
    - 주어진 리스트 중 최소 값을 찾아, 맨 앞의 값과 교체한다.
    - 맨 처음 위치를 제외하고 위 동작을 반복한다.
- 공간 복잡도: O(1)
- 시간 복잡도
    - 최악의 경우: O(n^2)
    - 최선의 경우: O(n^2)
    - 평균적인 경우: O(n^2)

``` python title="selection_sort.py"
def selection_sort(x):
    n = len(x)
    for i in range(n-1):
        index_min = i
        for j in range(i+1, n):
            if x[index_min] > x[j]:
                index_min = j
            x[index_min], x[i] = x[i], x[index_min]
```


## 심화 정렬 알고리즘

### 합병 정렬 (Merge Sort)

![합병 정렬](https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif)
[출처](https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif){:target="_blank"}

- 알고리즘
    - 정렬되지 않은 리스트는 두 부분 리스트로 나눈다.
        - 길이가 1인 부분 리스트는 정렬된 부분 리스트로 본다.
    - 두 부분 리스트를 합병하여 정렬된 임시 배열에 저장한다.
    - 임시 배열에 저장된 결과를 원래 배열로 복사한다.
- 공간 복잡도: O(n)
- 시간 복잡도
    - 최악의 경우: O(nlogn)
    - 최선의 경우: O(nlogn)
    - 평균적인 경우: O(nlogn)

### 퀵 정렬 (Quick Sort)

![퀵 정렬](https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif)
[출처](https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif){:target="_blank"}

- 알고리즘
    - 리스트에서 하나의 pivot을 선택한다.
    - pivot을 기준으로 좌측에 더 작은 값을, 우측에 더 큰 값을 배치한다.
    - pivot 좌측과 우측에 대해서 재귀적으로 반복한다.
- 공간 복잡도: O(logn)
- 시간 복잡도
    - 최악의 경우: O(n^2)
    - 최선의 경우: O(nlogn)
    - 평균적인 경우: O(nlogn)

## 하이브리드 정렬 알고리즘

### 팀소트 (Timsort)

- **Java SE 7**, Android, GNU Octave, Chrome V8, Swift, Rust, Python 등에 적용된 정렬 알고리즘
- Insertion Sort와 Merge Sort를 결합하여 만든 알고리즘
    - 작은 영역에 대해서 Insertion Sort를 수행하고, 이것을 Merge Sort하여 최적화
- 공간복잡도: O(n)
- 시간복잡도
    - 최악의 경우: O(nlogn)
    - 최선의 경우: O(n)
    - 평균적인 경우: O(nlogn)


## 정렬의 활용 예

- 정렬 알고리즘은 그 자체만으로 출제되기 보다는, 다른 문제를 해결 하는 데에 보조적으로 쓰인다.
    - 탐욕 알고리즘에서 국소최적값을 찾기 위해 활용
    - 특이한 조건으로 값의 순서를 찾아야 할 때 `key`와 익명함수를 이용하여 구현
    - 여러개의 기준을 동시에 만족하도록 정렬할 때 활용

### 여러 기준으로 정렬

- 정렬할 객체를 튜플로 만들면, 리스트를 여러 기준으로 정렬할 수 있다.
- 튜플에서 낮은 인덱스의 값을 우선 기준으로 정렬하며, 값이 같은 경우 다음 인덱스의 값을 기준으로 정렬

    ``` python
    x = [(10, 5), (4, 2), (10, 6), (3, 15)]
    x.sort()
    print(x)
    # [(3, 15), (4, 2), (10, 5), (10, 6)]
    # 0번째 인덱스의 값이 3->4->10으로 정렬됨
    # 10으로 0번째 인덱스 값이 같은 경우, 1번째 인덱스 값으로 정렬(5->6)
    ```

### key와 익명함수를 이용하여 정렬

- 정렬 시 key 인자에 비교할 값을 반환하는 익명함수를 삽입하여 구현
- 익명함수를 이용한 함수형 프로그래밍(FP) 방법으로 적은 코드 작성으로도 구현이 가능

    ``` python
    x = ["abcde", "fgh", "az", "qwer"]
    x.sort(key=lambda x: len(x))
    print(x)
    # ['az', 'fgh', 'qwer', 'abcde']
    # 문자열의 길이를 기준으로 정렬
    ```

## 정렬 문제

- [프로그래머스 문자열 내 마음대로 정렬하기 문제](https://school.programmers.co.kr/learn/courses/30/lessons/12915){:target="_blank"} ([답안 코드](https://github.com/abel-shin/pccp-python/blob/main/src/day2/Solution1.py){:target="_blank"})
- [프로그래머스 가장 큰 수 문제](https://school.programmers.co.kr/learn/courses/30/lessons/42746){:target="_blank"} ([답안 코드](https://github.com/abel-shin/pccp-python/blob/main/src/day2/Solution2.py){:target="_blank"})
