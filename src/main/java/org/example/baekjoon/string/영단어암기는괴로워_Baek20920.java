package org.example.baekjoon.string;

import java.io.*;
import java.util.*;

public class 영단어암기는괴로워_Baek20920 {

    /**
     * M보다 적은 글자수는 배제한다.
     * 자주 나오는 단어일수록 앞에 배치한다.
     * 해당 단어의 길이가 길수록 앞에 배치한다.
     * 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++){

            String s = br.readLine();

            // 문자 m보다 작은건 거른다.
            // key: 영단어 / value: 빈도
            if(s.length() >= m){
                map.put(s,map.getOrDefault(s,0)+1);
            }
        }

        for(String s : map.keySet()){
            list.add(s);
        }

        Collections.sort(list,(o1,o2) -> {

            // 빈도수 비교
            if(map.get(o1).equals(map.get(o2))){

                // 문자 길이 비교 내림차순
                if(o1.length() == o2.length()){
                    // 사전 순 정렬 오름 차순
                    return o1.compareTo(o2);
                } else {
                    return o2.length() - o1.length();
                }
            } else {
               // 빈도수 내림차순
               return map.get(o2) - map.get(o1);
            }
        });

        for(String s: list){
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }
}
