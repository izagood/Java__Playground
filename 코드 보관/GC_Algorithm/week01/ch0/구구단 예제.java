package week01_d2.ch0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gugudan {
    void go(int dan){
        System.out.println("구구단 "+ dan +"단 입니다.");
        for(int i=1; i<=9; i++){
            System.out.printf("%d * %d = %d%n",dan,i,dan*i);
        }
    }

    public static void main(String[] args) throws IOException {
        Gugudan gugu = new Gugudan();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.printf("단수를 입력해주세요: ");
            int dan = Integer.parseInt(br.readLine());
            gugu.go(dan);
        }

    }
}
