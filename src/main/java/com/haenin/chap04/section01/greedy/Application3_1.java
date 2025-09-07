package com.haenin.chap04.section01.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* 설명. 추가 클래스를 활용한 정렬 방법 */
public class Application3_1 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static Integer solution(String input) throws IOException {
        int max_count = 0;

        BufferedReader br = toBufferedReader(input);
        int N = Integer.parseInt(br.readLine());
        ArrayList<Time> timeList = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            timeList.add(new Time(start,end));
        }

        /* 설명. 컬렉션을 활용한 정렬 */
        Collections.sort(timeList);
//        timeList.sort(null); // 필기. 둘다가능

//        timeList.stream().forEach(System.out::println);

        /* 설명. 첫 회의도 0시 이후라는 생각으로 조건을 만족하는 회의들로 최대 회의를 개최함 */
        int lastEndTime = 0;

        for (int i = 0; i < N ; i++) {
            if(timeList.get(i).start == timeList.get(i).end){
                max_count++;
                continue;
            }
            if(timeList.get(i).start >= lastEndTime){ //필기. 겹치지 않게
                max_count++;
                lastEndTime = timeList.get(i).end;
            }
        }
        return max_count;
    }

}

/* 설명. 각 회의 객체를 만들 수 있는 클래스(end 시간 오름차순 정의) */
class Time implements Comparable<Time>{

    @Override
    public int compareTo(Time o) {
//        if(this.end == o.end) return o.start - this.start; //필기. 시작시간이 그 다음순서로 start시간이 정렬 내림차순으로 정렬됨
        return this.end - o.end; //필기. end시간으로 오름차순
    }

    public int start, end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

//    @Override
//    public String toString() {
//        return "Time{" +
//                "start=" + start +
//                ", end=" + end +
//                '}';
//    }
}
