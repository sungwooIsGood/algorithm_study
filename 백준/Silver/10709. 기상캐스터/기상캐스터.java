import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int h = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);
        char[][] arr = new char[h][w];
        int[][] resultArr = new int[h][w];


        // 구름 초기화
        for(int i = 0; i < arr.length; i++){
            String ss = br.readLine();
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = ss.charAt(j);
            }
        }

        for(int i = 0; i < arr.length; i++){

            boolean isCloud = false;
            int move = 0;

            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 'c'){
                    resultArr[i][j] = 0;
                    isCloud = true;
                    move = 0;
                } else if(arr[i][j] == '.'){
                    if(isCloud){
                        move++;
                        resultArr[i][j] = move;
                    } else {
                        resultArr[i][j] = -1;
                    }
                }
            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(resultArr[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
