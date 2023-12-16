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

``` java title="bubbleSort.java"
void bubbleSort(int[] x) {
    int n = x.length - 1;
    for (int i = 0; i < n; i++) {
        boolean swapped = false;
        for (int j = 0; j < n-i; j++) {
            if (x[j] > x[j+1]) {
                swapped = true;
                int temp = x[j+1];
                x[j+1] = x[j];
                x[j] = temp;
            }
        }
        if (!swapped) {
            break;
        }
    }
}
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

``` java title="insertionSort.java"
void insertionSort(int[] x) {
    for (int i = 1; i < x.length; i++) {
        int j = i - 1;
        int key = x[i];
        while (x[j] > key && j >= 0) {
            x[j+1] = x[j];
            j = j - 1;
        }
        x[j+1] = key;
    }
}
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

``` java title="selectionSort.java"
void selectionSort(int[] x) {
    int n = x.length;
    for (int i = 0; i < n-1; i++) {
        int indexMin = i;
        for (int j = i+1; j < n; j++) {
            if (x[indexMin] > x[j]) {
                indexMin = j;
            }
            int temp = x[indexMin];
            x[indexMin] = x[i];
            x[i] = temp;
        }
    }
}
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
    - 특이한 조건으로 값의 순서를 찾아야 할 때 `Comparator`를 적절히 구현하여 활용
    - 여러개의 기준을 동시에 만족하도록 정렬할 때 활용

### Comparable을 이용한 정렬

- `Comparable` 인터페이스를 구현하여 정렬 가능한 객체를 만들 수 있다.
- 객체지향적인(OOP) 방법으로, 구현해야 하는 코드 양이 많은 편

    ``` java
    class Item implements Comparable<Item> {
        int x;
        int y;

        public Item(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(o) {
            if (this.x == o.x) {      // x가 같으면
                return this.y - o.y;  // y 기준으로 오름차순
            } else {                  // x가 다르면
                return o.x - this.x;  // x 기준으로 내림차순
            }
        }
    }

    ...

    List<Item> items = new ArrayList<>();
    ...
    items.sort();
    ...

    ```

### Comparator를 이용한 정렬

- `Comparator` 클래스를 구현하여 정렬 방법을 결정할 수 있다.
- 람다식을 이용한 함수형 프로그래밍(FP) 방법으로 적은 코드 작성으로도 구현이 가능

    ``` java
    List<int[]> items = new ArrayList<>();
    ...
    items.sort((a, b) -> {
        if (a[0] == b[0]) {
            return a[1] - b[1];
        } else {
            return b[0] - a[0];
        }
    });

    ```

## 정렬 문제

- [프로그래머스 문자열 내 마음대로 정렬하기 문제](https://school.programmers.co.kr/learn/courses/30/lessons/12915){:target="_blank"} ([답안 코드](https://github.com/abel-shin/pccp-java/blob/main/src/day2/Solution1.java){:target="_blank"})
- [프로그래머스 가장 큰 수 문제](https://school.programmers.co.kr/learn/courses/30/lessons/42746){:target="_blank"} ([답안 코드](https://github.com/abel-shin/pccp-java/blob/main/src/day2/Solution2.java){:target="_blank"})
