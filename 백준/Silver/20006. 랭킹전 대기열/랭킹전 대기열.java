
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int p = Integer.parseInt(s[0]); // 플레이어 수
        int n = Integer.parseInt(s[1]); // 방 정원

        List<List<String[]>> rooms = new ArrayList<>(); // 대기열 방

        for(int i = 0; i < p; i++){
            s = br.readLine().split(" ");
            int level = Integer.parseInt(s[0]);
            String player = s[1];
            boolean added = false; // 방에 입장 했는지 확인

            // 입장 가능한 방을 돌아보는 중
           for(List<String[]> room : rooms){
               int firstRoomLevel = Integer.parseInt(room.get(0)[0]); // 최초 들어왔던 방 기준 레벨

               if(room.size() < n && Math.abs(firstRoomLevel-level)<= 10){
                   room.add(new String[]{String.valueOf(level),player});
                   added = true;
                   break;
               }
           }

           // 최초 입장
           if(!added){
               List<String[]> newRoom = new ArrayList<>();
               newRoom.add(new String[]{String.valueOf(level),player});
               rooms.add(newRoom);
           }
        }


        for(List<String[]> room : rooms){
            // 사전 순 정렬
            room.sort((o1, o2) -> o1[1].compareTo(o2[1]));

            if(room.size() == n){
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            for(int i = 0; i < room.size(); i++){
                System.out.println(room.get(i)[0] + " " + room.get(i)[1]);
            }
        }
    }
}
