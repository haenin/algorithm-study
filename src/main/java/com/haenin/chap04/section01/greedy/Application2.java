package com.haenin.chap04.section01.greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Application2 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        BufferedReader br = toBufferedReader(input);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //필기. 동전 종류의 수
        int K = Integer.parseInt(st.nextToken()); //필기. 지불할 금액

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        /* 설명. 큰 금액의 동전부터 지불하며 반복 */
        for (int i = N-1; i >= 0; i--) {    //필기. 이득이 큰 동전부터
            if(coins[i] <= K){              //필기. 지불을 고민할 동전을 추려서
               count += K / coins[i];       //필기. 선택한 동전으로 최대한 나누고

                K %= coins[i];               //필기. 남은 금액은 다시 K원에 대입
            }
        }

        return count;
    }

}
