import java.io.*;

public class Main {

    /**
     * 홀수가 아나인 문자는 가운데 위치
     * 홀수가 두개 이상이면 팰린드롬 x
     * 홀수가 하나 있으면 가운데 위치
     *
     * 결론: front만 문장을 만들고 front를 '뒤집은' 값을 back에다 넣어서 글자를 완성 시킨다.
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine(); // AAABB
        int[] alphabet = new int[26];

        // 빈도수 확인하기
        for(char c : str.toCharArray()){
            alphabet[c - 'A']++;
        }

        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        int odd = 0;
        char oddChar = '0';

        for(int i = 0; i < alphabet.length; i++){

            // 홀수인지 확인
            if(alphabet[i] % 2 != 0) {
                odd++;
                oddChar = (char)(i + 'A');
            }

            if(odd >= 2){
                System.out.println("I'm Sorry Hansoo");
                return;
            }

            // 반을 잘라서 front에다 넣기
            for(int j = 0; j < alphabet[i]/2; j++){
                front.append((char)(i+'A')); // AB
            }
        }

        // 홀수 중앙 배치
        if(odd == 1){
            System.out.print(front.toString() + oddChar); // A
        } else {
            System.out.print(front); // A
        }

        back.append(front.reverse());
        System.out.println(back);
    }
}