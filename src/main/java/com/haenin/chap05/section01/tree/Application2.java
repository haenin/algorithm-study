package com.haenin.chap05.section01.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application2 {

    public static BufferedReader toBufferedReader(String str) {
        InputStream is = new ByteArrayInputStream(str.getBytes());
        return new BufferedReader(new InputStreamReader(is));
    }
    static class Node{
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    /* 설명. 각 노드 객체가 담길 리스트 */
    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();
    public static String solution(String input) throws IOException {
        sb.delete(0, sb.length());
        BufferedReader br = toBufferedReader(input);
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for (int i = 1; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n ; i++) {
            String[] alpha = br.readLine().split(" ");
            /* 설명. 각 알파벳을 숫자로 ㅂ바꾸는 과정('A' -> 1, 'B' -> 2, ....) */
            int data = alpha[0].charAt(0) - 'A' + 1;
            int left = alpha[1].charAt(0) - 'A' + 1;
            int right = alpha[2].charAt(0) - 'A' + 1;
            list[data].add(new Node(left,right));
        }

        /* 설명. 전위 -> 중위 -> 후위 */
        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);

        return sb.toString();
    }

    private static void preorder(int start) {
        for (Node node: list[start]){
                int l = node.left;
                int r = node.right;

                sb.append((char)(start+'A'-1));
                if(l+'A'-1 != '.') preorder(l);
                if(r+'A'-1 != '.') preorder(r);
        }
    }

    private static void inorder(int start) {
        for (Node node: list[start]){
            int l = node.left;
            int r = node.right;

            if(l+'A'-1 != '.') inorder(l);
            sb.append((char)(start+'A'-1));
            if(r+'A'-1 != '.') inorder(r);
        }
    }

    private static void postorder(int start) {
        for (Node node: list[start]){
            int l = node.left;
            int r = node.right;

            if(l+'A'-1 != '.') postorder(l);
            if(r+'A'-1 != '.') postorder(r);
            sb.append((char)(start+'A'-1));
        }
    }


}
