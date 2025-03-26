
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T];

        for(int t = 0 ; t < T; t++){

            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");

            int[] ranks = new int[n];
            Map<Integer,Integer> countMap = new HashMap<>();
            int maxNumTeam = 0;

            for(int i = 0; i < n; i++){
                int data = Integer.parseInt(s[i]);
                countMap.put(data,countMap.getOrDefault(data,0)+1);
                ranks[i] = data;
                maxNumTeam = Math.max(maxNumTeam,data); // 가장 큰 번호의 팀
            }

            int[] fivePlayer = new int[maxNumTeam+1]; // 모든 팀들의 5번째 선수
            Map<Integer, Integer> scoreMap = new HashMap<>();
            Map<Integer, Integer> tmpMap = new HashMap<>();
            int score = 1;

            for(int rank: ranks){
                if(countMap.get(rank) == 6){
                    tmpMap.put(rank,tmpMap.getOrDefault(rank,0)+1);

                    if(tmpMap.get(rank) <= 4){
                        scoreMap.put(rank,scoreMap.getOrDefault(rank,0)+score);
                    }

                    if(tmpMap.get(rank) == 5){
                        fivePlayer[rank] = score;
                    }
                    score++;
                }
            }

            int lowPoint = Integer.MAX_VALUE;
            int fiveScore = Integer.MAX_VALUE;
            for(Integer key : tmpMap.keySet()){
                int point = scoreMap.get(key);
                if(lowPoint > point){
                    lowPoint = point;
                    fiveScore = fivePlayer[key];
                    result[t] = key;
                } else if(lowPoint == point){
                    if(fivePlayer[key] < fiveScore){
                        result[t] = key;
                    }
                }
            }
        }

        for(int i : result){
            System.out.println(i);
        }
    }
}
