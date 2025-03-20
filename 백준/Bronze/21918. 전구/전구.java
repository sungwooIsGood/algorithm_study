import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /**
     * 1이면 해당 전구를 켜져있음 끄고 꺼져있음 켜라
     * 2이면 해당 전구부터 해당 전구까지 켜져있음 끄고 꺼져있음 켜라
     * 3이면 해당 전구부터 해당 전구까지 끈다.
     * 4이먄 해당 전구부터 해당 전구까지 킨다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[] arr = new int[n+1];

        // 전구 상태
        String[] status = br.readLine().split(" ");
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(status[i-1]);
        }

        // 전구를 끄거나 키는 헹동
        for(int i = 0; i < m; i++){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            if(a == 1){
                arr[b] = c;
            } else if(a == 2){
                for(int j = b; j <= c; j++){
                    arr[j] = arr[j] == 1 ? 0: 1;
                }
            } else if(a == 3){
                for(int j = b; j <= c; j++){
                    arr[j] = 0;
                }
            } else {
                for(int j = b; j <= c; j++){
                    arr[j] = 1;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
