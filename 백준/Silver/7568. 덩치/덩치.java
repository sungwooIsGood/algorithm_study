

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] p = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			
			String[] s = br.readLine().split(" ");
			
			for(int j = 0 ; j < 2; j++) {
				
				p[i][j] = Integer.parseInt(s[j]);
			
			}
		}
		
		for(int i = 0; i < n; i++) {
			
			int rank = 1;
			
			for(int j = 0; j < n; j++) {
				
				// 자기 자신 크기를 잴 수없기 때문에
				if(i == j) {
					continue;
				}
				// 기준이 되는 학생보다 크면 rank++
				if(p[i][0] < p[j][0] && p[i][1] < p[j][1]) {
					rank++;
				}
				
			}
			System.out.println(rank);
		}
	}

}
