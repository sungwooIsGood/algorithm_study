
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int search = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[] dx = {1,0,-1,0}; // 아래, 오른, 위, 왼 -> 달팽이
        int[] dy = {0,1,0,-1};
        int idx = 0;

        // 시작 좌표
        int curX = 0;
        int curY = 0;

        // 시작 숫자
        arr[curX][curY] = n * n;

        // 달팽이 이동
        while(idx < 4){

            int nx = curX + dx[idx];
            int ny = curY + dy[idx];

            // 배열 안에 돌도록
            if(nx < n && ny < n && nx >= 0 && ny >= 0 && arr[nx][ny] == 0){

                    arr[nx][ny] = arr[curX][curY] - 1;

                    if(arr[nx][ny] == 1) break; // 종료 조건

                    curX = nx;
                    curY = ny;

            } else {
                idx++;
            }

            if(idx >= 4){
                idx = 0;
            }
        }

        int resultX = 0, resultY = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == search){
                    resultX = i+1;
                    resultY = j+1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(resultX + " " + resultY);
    }
}
