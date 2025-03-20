
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[11];
        int[] moveCnt = new int[11];
        int result = 0;

        for(int i = 1; i < 11; i++){
            arr[i] = -1;
            moveCnt[i] = 0;
        }

        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            int name = Integer.parseInt(s[0]);
            int move = Integer.parseInt(s[1]);

            if(arr[name] == -1){
                arr[name] = move;
            } else if(arr[name] != move){
                moveCnt[name]++;
                arr[name] = move;
            }

        }

        for(int i = 1; i < 11; i++){
            result += moveCnt[i];
        }

        System.out.println(result);

    }
}
