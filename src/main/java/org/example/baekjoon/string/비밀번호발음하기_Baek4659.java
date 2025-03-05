package org.example.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 비밀번호발음하기_Baek4659 {

    /**
     * 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
     * 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
     * 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){

            String s = br.readLine();

            if(s.equals("end")) break;

            // 모음 하나 포함 여부 확인
            boolean containsVowel = false;
            for (char c : s.toCharArray()) {
                if ("aeiou".indexOf(c) != -1) {
                    containsVowel = true;
                    break;
                }
            }

            if (!containsVowel) {
                System.out.println("<" + s + "> is not acceptable.");
                continue;
            }

            // 모음 혹은 자음 연속 3개
            boolean isAcceptable = true;
            int vowelCount = 0; // 모음
            int consonantCount = 0; // 자음

            for(int i = 0; i < s.length(); i++){
                char now = s.charAt(i);
                if(now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u'){
                    vowelCount++;
                    consonantCount = 0;
                } else {
                    consonantCount++;
                    vowelCount = 0;
                }

                if(vowelCount == 3 || consonantCount == 3){
                    isAcceptable = false;
                    break;
                }

                // 연속된 문자 / ee,oo 는 가능
                if(s.length()-1 == i) break;

                if(s.charAt(i) == s.charAt(i + 1)){
                    // ee, oo가 아니라면 "not acceptable"
                    if(s.charAt(i) != 'e' && s.charAt(i) != 'o'){
                        isAcceptable = false;
                        break;
                    }
                }
            }

            if (isAcceptable){
                System.out.println("<"+s+"> is acceptable.");

            } else {
                System.out.println("<"+s+"> is not acceptable.");
            }
        }
    }
}
