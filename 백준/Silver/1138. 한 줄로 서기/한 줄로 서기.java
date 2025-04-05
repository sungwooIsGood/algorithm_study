
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; // 입력 배열
        int[] result = new int[n]; // 정답 배열
        String[] s = br.readLine().split(" ");

        // 입력 받기
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        // 1번부터 탐색하며 자리 배치
        for(int i = 0; i < n; i++) {
            int count = arr[i]; // 2
            for(int j = 0; j < n; j++){
                if(result[j] == 0){ // 빈자리인지 확인
                    if(count == 0){
                        result[j] = i + 1; // 자리
                        break;
                    }
                    count--;
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(result[i] + " ");
        }
    }
}
