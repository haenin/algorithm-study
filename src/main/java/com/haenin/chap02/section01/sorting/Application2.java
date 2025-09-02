package com.haenin.chap02.section01.sorting;

/* 설명.
*   선택 정렬(Selection Sort)
*    대상 데이터에서 최대나 최소를 찾아 맨앞(맨뒤)과 교환하는 방법이다.
*   시간복잡도는 (O(n^2)) -> 효율적이지 않다
*   */
public class Application2 {

    /* 설명.
     *  문제 내용
     *   : N개의 정수가 주어졌을 때, 선택 정렬 알고리즘을 사용하여 내림차순으로 정렬하는 프로그램을 작성하시오.
     *  입력
     *   - 첫 번째 줄에 자연수 N(1 <= N <= 100)이 주어진다.
     *   - 두 번째 줄에 N개의 정수가 공백으로 구분되어 입력된다. 각 정수는 -10^9 이상, 10^9 이하이다.
     *  출력
     *    - 내림차순으로 정렬된 수열을 공백으로 구분하여 출력한다.
     *
     * 설명.
     *  예시 입력 1
     *    - 10
     *      32 7 34 39 40 41 22 31 23 25
     *  예시 출력 1
     *    - 41 40 39 34 32 31 25 23 22 7
     *
     * 설명.
     *  예시 입력 2
     *    - 6
     *      42 29 34 64 28 12
     *  예시 출력 2
     *    - 64 42 34 29 28 12
     * */

    public static void solution(int length, int[]arr){
        for (int i = 0; i < length - 1; i++) {
//            int maxIndex = i;
            for (int j = i + 1; j < length; j++) { // 필기. 현재 i위치를 제외한 우측 나머지 부분
                if(arr[i] < arr[j]){
//                    maxIndex = j;
                    int temp =arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }
}
