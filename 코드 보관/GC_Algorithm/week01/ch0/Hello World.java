package week01_d2.ch0;

public class HelloWorld {
    String msg = "환영 합니다";

    void prtMsg(){
        System.out.println(msg);
    }

    void prtMsg(String name){
        System.out.println(name+" "+msg);
    }

    String getMsg(String name){
        return name + " 안녕하세요?";
    }

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        hw.prtMsg();
        hw.prtMsg("홍길동");
        System.out.println(hw.getMsg("김길동"));
    }
}
/*
메모리 영역
Method Static - class 정보, static 정보, 클래스 변수
Heap - 인스턴스 정보
Steak - 메서드 정보
 */
