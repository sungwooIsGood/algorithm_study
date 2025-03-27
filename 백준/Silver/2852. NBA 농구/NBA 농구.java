
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int team1Score = 0, team2Score = 0;  // 팀 점수
        int lastTime = 0;                    // 이전 득점 시간 (초)
        int leadTime1 = 0, leadTime2 = 0;    // 리드한 시간
        int winningTeam = 0;                 // 현재 이기고 있는 팀 (1, 2, 0)

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int team = Integer.parseInt(input[0]);
            int time = convertToSeconds(input[1]);

            // 현재 누가 이기고 있었는지 확인하고 시간 추가
            if (team1Score > team2Score) {
                leadTime1 += (time - lastTime);
            } else if (team2Score > team1Score) {
                leadTime2 += (time - lastTime);
            }

            // 점수 갱신
            if (team == 1) {
                team1Score++;
            } else {
                team2Score++;
            }

            // 이기고 있는 팀 갱신
            if (team1Score > team2Score) {
                winningTeam = 1;
            } else if (team1Score < team2Score) {
                winningTeam = 2;
            } else {
                winningTeam = 0;
            }

            lastTime = time;
        }

        // 마지막 득점 이후 남은 시간 반영
        int totalTime = 48 * 60;  // 48분 = 2880초
        if (winningTeam == 1) {
            leadTime1 += (totalTime - lastTime);
        } else if (winningTeam == 2) {
            leadTime2 += (totalTime - lastTime);
        }

        // 초를 MM:SS 형식으로 변환하여 출력
        System.out.println(convertToMMSS(leadTime1));
        System.out.println(convertToMMSS(leadTime2));
    }

    // MM:SS 형식을 초로 변환
    private static int convertToSeconds(String time) {
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]);
        int seconds = Integer.parseInt(parts[1]);
        return minutes * 60 + seconds;
    }

    // 초를 MM:SS 형식으로 변환
    private static String convertToMMSS(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }
}
