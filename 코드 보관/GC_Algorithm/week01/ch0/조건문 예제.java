package week01_d2.ch0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//조건문 기본 예제

public class Conditional{
    void log_in() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.printf("## 아이디를 입력하세요: ");
        String userName = br.readLine();

        System.out.printf("# 비밀번호를 입력하세요: ");
        String pwd = br.readLine();

        if(userName.equals("jaebin") && pwd.equals("12345")){
            System.out.println("인증 확인!! -> 로그인 성공");
        }else{
            System.out.println("아이디나 비밀번호가 틀렸습니다.");
        }
    }

    void check(){
        int cnt = 10;
        String msg = cnt >= 1? "새로운 쪽지가 있습니다.": "새로운 쪽지가 없습니다.";
        System.out.println(msg);
    }

    public static void main(String[] args) throws IOException{
        Conditional con = new Conditional();

        while(true){
            System.out.printf("#메뉴를 선택하세요 (1: 로그인, 2: 쪽지확인, 3: 종료): ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String sel = br.readLine();

            switch (sel){
                case "1": con.log_in();break;
                case "2": con.check();break;
                case "3": System.exit(-1);
                default:
                    System.out.printf("잘 못 입력하셨습니다.");
            }
        }
    }
}
