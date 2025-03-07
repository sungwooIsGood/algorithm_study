package org.example.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수이어쓰기_Baek1515 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine(); // 234092
        int length = n.length(); // 문자열 길이
        int index = 0; // 타겟 인덱스
        int num = 1; // 탐색

        while(index < length) {

            for(char c : String.valueOf(num).toCharArray()){

                if(n.charAt(index) == c){
                    index++;
                }

                if(index == length){
                    System.out.println(num);
                    return;
                }
            }
            num++;
        }
    }
}
