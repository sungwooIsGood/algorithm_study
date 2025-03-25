
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());
        int[] stock = new int[15];

        String[] s = br.readLine().split(" ");

        for(int i = 1; i < stock.length; i++){
            stock[i] = Integer.parseInt(s[i-1]);
        }

        int jun = jun(money, stock);
        int sung = sung(money, stock);

        if(jun == sung){
            System.out.println("SAMESAME");
        } else if(jun > sung){
            System.out.println("BNP");
        } else {
            System.out.println("TIMING");
        }
    }

    private static int sung(int money, int[] stock) {

        int preDown = 0; // 전날 대비 하락 카운트
        int preUp = 0; // 전날 대비 상승 카운트
        int beforeStockPrice = stock[1]; // 전날 가격
        int stockPrice = 0; // 주식 수

        for(int i = 1; i < stock.length; i++){

            if(beforeStockPrice == stock[i]){
                preDown = 0;
                preUp = 0;
            } else if(beforeStockPrice < stock[i]){

                preUp++;
                preDown = 0;

                if(preUp >= 3 && stockPrice != 0){
                    money += stockPrice * stock[i];
                    stockPrice = 0;
                    preUp = 0;
                }
            } else if(beforeStockPrice > stock[i]){

                preUp = 0;
                preDown++;

                if(preDown >= 3 && money >= stock[i]){
                    stockPrice += money / stock[i];
                    money %= stock[i];
                }
            }
            beforeStockPrice = stock[i];
        }

        return (stockPrice*stock[14]) + money;
    }

    private static int jun(int money, int[] stock) {

        int stockPrice = 0; // 주식 수

        for(int i = 1; i < stock.length; i++){

            if(money >= stock[i]){
                stockPrice += money / stock[i];
                money = money % stock[i];
            }
        }
        return (stock[14]*stockPrice) + money;
    }
}
