package com.haenin.chap03.section01.graph_search;

public class Application5 {

    static int N;
    static int[] queens; // 필기. 1차원 배열이지만 들어있는 값이 column의 위치를 나타내도록 할 예정
                        // 필기. 결과적으로 1차원 배열만으로 queen의 위치를 행과 열로 표시 가능
    static int count;
    public static int solution(int size) {
        count = 0; // 테스트케이스들 때문에 매번 solution 실행 시 이전 답을 초기화
        N = size;

        queens = new int[size];
        solveNQueen(0); // 첫 행부터 dfs로 문제를 풀기위한 메소드 호출
        System.out.println("count = " + count);
        return count;
    }

    private static void solveNQueen(int row) {
        if(row == N){
         count++;
         printChess();
         return;
        }

        for (int col = 0; col < N; col++) {
            if(isSafe(row, col)){ //필기. 현재 row와 col의 위치에 queen을 놓아도 되는지 유효성 검사메소드
               queens[row] = col; //필기. 백트래킹에서 promising 함수라고 불림
                solveNQueen(row + 1);
            }
        }
    }

    /* 설명. 현재 행에서 Queen을 놓으면 안되는 두 가지 규칙 체크 */

    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) { // 필기. 앞에 놓인 퀸의 갯수만큼 도는 반복
            /* 설명. 1. 같은 열에 있는지 */
            if(queens[i] == col){
                return false;
            }
            /* 설명. 2. 대각선에 있는지 */
            if(Math.abs(queens[i]- col) == Math.abs(i-row)) { // 필기. 컬럼의 차이 = =행의차이
                return false;
            }
        }
        return true;
    }
    private static void printChess() {
        System.out.println(count + "반쩨 체스판");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(queens[i] == j) System.out.print("Q ");
                else System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
