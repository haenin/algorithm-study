package com.haenin.chap01.section01.timecompelxity;

import java.util.Arrays;

public class Application {
    /* 목표, 시간 복잡도를 이해할 수 있다 */
    /* 설명. 알고리즘 실행 시 입력 값이 증가함에 따라 연산이 걸리는 시간의 증가도를 나타낸다. */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 15, 4, 9, 10, 7};
        System.out.println(getFirst(arr));
        Arrays.sort(arr); // 필기. 기본 자료형은 퀵 정렬, 참조 자료형은 병합 정렬(nlogn)
        System.out.println(binarySearch(arr, 9));

        System.out.println(Arrays.toString(reverse(arr)));
        System.out.println(fibonacci(10));
    }

    // 필기. 오메가(1) O(1) 이 같기 때문에 세타(1)
    /* 설명. 상수 시간 (O(1))
    *       입력값 크기와 상관없이 항상 일정한 시간이 걸리는 알고리즘
    * */
    /* 설명. 크기가 1 이상인 배열이 던져지면 첫번째 요소를 반환하는 메소드 */
    private static int getFirst(int[] arr) {
        return arr[0];
    }

    /* 설명. 로그 시간(O(log N))
    *   입력값이 증가함에 따라 처리 시간이 로그만큼 증가하는 알고리즘
    *  */
    /* 설명. 정렬된 배열과 찾고자 하는 타겟 값을 넣으면 타겟이 있는 위치를 반환하는 메소드 */
    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        while(left <= right){
            int mid = left + (right -left) / 2 ;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }

    /* 설명. 선형 시간 O(n) */
    /* 설명.
    *   입력값이 증가함에 따라 처리 시간이 선형적으로 증가하는 알고리즘이다.
    * */
    private static int[] reverse(int[] arr){
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - i - 1];
        }
        return reversed;
    }

    /* 설명. 지수 시간 O(2^n)*/
    /* 설명.
    *   입력값이 증가함에 따라 시간이 기하급수적으로 증가하는 알고리즘
    * */
    private static int fibonacci(int n){
        if(n <= 1 ) return n;
        return fibonacci(n-1) + fibonacci(n-2);

    }
}
