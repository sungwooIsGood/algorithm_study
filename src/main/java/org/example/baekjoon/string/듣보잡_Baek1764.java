package org.example.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡_Baek1764 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * 500,000이기 때문에 교집합을 이중 for문으로 찾으면 안됨. 0(n*m) 최악의 경우 25억번 돌음
     * set 혹은 map으로 o(1)
     * set이 효율적 -> 중복 저장 x Set.contains()로 검사 가능
     */
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        set(n, m); // set 방식
        map(n,m);
    }

    private static void map(int n, int m) throws IOException {

        Map<String,Integer> map = new HashMap<>();

        // 듣지 못한 사람(n)
        for(int i = 0; i < n; i++){
            map.put(br.readLine(),1);
        }

        // 보지 못한 사람(m)
        for(int i = 0; i < m; i++){
            String name = br.readLine();
            map.put(name,map.getOrDefault(name,0)+1);
        }

        List<String> list = new ArrayList<>();
        for(String name : map.keySet()){
            if(map.get(name) == 2){
                list.add(name);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (String name : list) {
            System.out.println(name);
        }
    }

    private static void set(int n, int m) throws IOException {
        // set - o(1)
        Set<String> set = new HashSet<>();

        // 교집합을 담을 리스트
        List<String> list = new ArrayList<>();

        // 듣도 못한 사람(n) 일단 담기
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }

        // 보도 못한 사람(m) 검사하면서 같으면 list에 담기
        for(int i = 0; i < m; i++){

            String s = br.readLine();

            if(set.contains(s)){
                list.add(s);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
