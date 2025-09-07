package com.haenin.chap06.section01.dp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Application4 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        int n = Integer.parseInt(br.readLine());

        int[][] p = new int[n+1][n+1];      // 입력값 존재 배열
        int[][] dp = new int[n+1][n+1];     // 최적의 누적값 memoization 배열

        /* 설명. p배열에 문제에서 제기된 입력 값 작성 */
        for (int i = 1; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i ; j++) {      // 한 줄에 i번만큼 토큰 추출
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                /* 설명. i행 j열 위치의 모든 값이 좌상단 및 우상단을 가짐(feat. n+1) */
                /* 설명. 좌상단과 우상단 중 큰 값과 현재 위치의 숫자를 더해서 현재 위치의 최적의 값을 dp 배열에 누적  */
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + p[i][j];
            }
        }

        for (int[] arr: dp) {
            System.out.println(Arrays.toString(arr));
        }

        return Arrays.stream(dp[n]).max().getAsInt();
    }
}