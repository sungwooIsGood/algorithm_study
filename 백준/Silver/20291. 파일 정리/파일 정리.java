import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new HashMap<>();
        List<String> results = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String s = br.readLine();

            String[] split = s.split("\\.");
            map.put(split[1],map.getOrDefault(split[1],0)+1);
        }

        for(Map.Entry<String, Integer> s : map.entrySet()){
            results.add(s.getKey() + " " + s.getValue());
        }

        Collections.sort(results);

        for(int i = 0; i < results.size(); i++){
            System.out.println(results.get(i));
        }
    }
}
