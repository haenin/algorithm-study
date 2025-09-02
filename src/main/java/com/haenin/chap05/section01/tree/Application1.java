package com.haenin.chap05.section01.tree;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;
public class Application1 {

    static int N;
    static int[] parent;
    static boolean[] isVisit;
    static StringTokenizer st;
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }

    public static String solution(String input) throws IOException {
            sb.delete(0, sb.length());
            BufferedReader br = toBufferedReader(input);

            N = Integer.parseInt(br.readLine());

            parent = new int[N+1];
            isVisit = new boolean[N+1];
            list = new ArrayList[N+1];    //필기. 각 노드가 연결된 노드르 담은 ArrayList를 노드 갯수만큼 관리


        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            // 필기. 일종의 양방향 배열
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        /* 설명. 1번 노드부터 각 노드의 parent 배열 세팅 및 visit 배열 체크 */
        dfs(1);

        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    private static void dfs(int parentNode) {
        isVisit[parentNode] =true;
        for(int node: list[parentNode]){
            if(!isVisit[node]){
                parent[node] = parentNode;
                dfs(node);
            }
        }
    }
}
