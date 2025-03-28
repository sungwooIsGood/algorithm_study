
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int team1Score = 0;
        int team2Score = 0;
        int team1GoalTime = 0;
        int team2GoalTime = 0;
        int lastLeadTime = 0;
        int endTime = 48*60;

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String[] ss = s[1].split(":");
            int goalTeam = Integer.parseInt(s[0]);
            int goalTime = (Integer.parseInt(ss[0]) * 60) + Integer.parseInt(ss[1]);

            if(team1Score > team2Score){
                team1GoalTime += goalTime - lastLeadTime;
            } else if(team2Score > team1Score){
                team2GoalTime += goalTime - lastLeadTime;
            }

            if(goalTeam == 1){
                team1Score++;
            } else {
                team2Score++;
            }

            lastLeadTime = goalTime;
        }

        if(team1Score > team2Score){
            team1GoalTime += endTime - lastLeadTime;
        } else if(team2Score > team1Score) {
            team2GoalTime += endTime - lastLeadTime;
        }


        int min1 = team1GoalTime / 60;
        int sec1 = team1GoalTime % 60;
        int min2 = team2GoalTime / 60;
        int sec2 = team2GoalTime % 60;
        System.out.println(String.format("%02d:%02d", min1, sec1));
        System.out.println(String.format("%02d:%02d", min2, sec2));
    }
}
