import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // TreeMap을 사용하여 자동 정렬
        Map<String,Integer> map = new TreeMap<>();

        for(int i = 0; i < n; i++){
            String s = br.readLine();

            String[] split = s.split("\\.");
            map.put(split[1],map.getOrDefault(split[1],0)+1);
        }

        for(Map.Entry<String, Integer> s : map.entrySet()){
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
