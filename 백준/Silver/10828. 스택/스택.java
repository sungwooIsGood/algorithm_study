

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stack = new Stack<>();
		
		// 첫째 줄에 주어지는 명령의 수
		int m = Integer.parseInt(br.readLine());
		
		// 메소드를 실행 할 때마다 변하는 수
		
		for(int i  = 0; i < m; i++) {
			// N개의 줄에는 명령
			String n = br.readLine();
			
			if(n.contains("push")) {
				
				// 공백 기준 분할
				String[] input = n.split(" ");
				int count = Integer.parseInt(input[1]);
				stack.push(count);
				
			} else if (n.contains("pop")) {
				
				if(!stack.isEmpty()) {
					bw.write(stack.pop() + "\n");
//					System.out.println(stack.pop()); // peek후 pop
				} else {
					bw.write(-1 + "\n");
//					System.out.println(-1);
				}
				
			} else if (n.contains("size")) {
				bw.write(stack.size() + "\n");
//				System.out.println(stack.size());
				
			} else if (n.contains("empty")) {
				
				if(stack.isEmpty()) {
					bw.write(1 + "\n");
//					System.out.println(1);
				} else {
					bw.write(0 + "\n");
//					System.out.println(0);
				}
				
			} else if (n.contains("top")){
				
				if(!stack.isEmpty()) {
					bw.write(stack.peek() + "\n");
//					System.out.println(stack.peek());
				} else {
					bw.write(-1 + "\n");
//					System.out.println(-1);
				}
			}
		

		}
		bw.flush();
		bw.close();
		br.close();
	
	}

}
