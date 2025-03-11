

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean flag = false; // 꺽새 확인 유무

        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '<'){
                flag = true;

                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == '>'){
                flag = false;
                sb.append(s.charAt(i));
            } else if(flag){
                sb.append(s.charAt(i));
            } else if(!flag){
                if(s.charAt(i) == ' '){
                    while (!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(s.charAt(i));
                } else{
                    stack.push(s.charAt(i));
                }
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }
}