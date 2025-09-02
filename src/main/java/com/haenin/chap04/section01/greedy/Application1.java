package com.haenin.chap04.section01.greedy;

public class Application1 {
    public static Integer solution(Integer input) {

        int count = 0;

        /* 설명. 5키로 봉지(이득을 많이 가져다 줄)로 나누어 담아 보고,
                3키로 봉지를 최소한으로 사용 */
        while (true){
            if(input % 5 == 0){ // 필기. 남은 설탕을 5kg로 해결할 수 있는 경우
                return input / 5 + count;
            }else {             // 필기. 어쩔 수 없는 경우네는 3kg 하나 사용
                input -= 3;
                count ++;
                if(input == 0) break;
                if(input < 0) return -1; // 필기. 가지고 있는 봉지로 나누어 떨어지지 않는 경우
            }
        }
        return count;
    }
}
