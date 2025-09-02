package com.haenin.chap06.section01.dp;

public class Application2 {
    public static Integer solution(Integer n) {
        int[] dp = new int[n+1];
        if( n >= 1 ) dp[1] = 1;
        if( n >= 2 ) dp[2] = 2;
        if(n >= 3) {
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
}
