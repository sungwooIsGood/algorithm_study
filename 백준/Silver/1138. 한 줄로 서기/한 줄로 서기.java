
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; // 저장 배열
        boolean[] visited = new boolean[n]; // 방문 확인 배열
        String[] s = br.readLine().split(" ");

        // 입력 받기
        for(int i = 0; i < n; i++){
            int count = Integer.parseInt(s[i]);
            for(int j = 0; j < n; j++){
                if(!visited[j]){
                    if(count == arr[j]){
                        visited[j] = true;
                        arr[j] = i + 1;
                        break;
                    } else {
                        count--;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
