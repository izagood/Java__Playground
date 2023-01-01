// x단 부터 y단 까지 구구단 출력하기

package week01_d2.ch0;

public class Gugudan{
    void go(int dan){
        System.out.println("구구단 "+ dan +"단 입니다.");
        for(int i=1; i<=9; i++){
            System.out.printf("%d * %d = %d%n",dan,i,dan*i);
        }
    }

    void go(int start, int end){
        System.out.println("구구단"+start +" 단 부터 구구단 "+ end +"단까지 입니다.");

        for(int i=start; i<=end; i++){
            for(int j=1; j<=9; j++){
                System.out.printf("%d * %d = %d%n",i,j,i*j);
            }
        }
    }

    public static void main(String[] args){
        Gugudan gugu = new Gugudan();
        gugu.go(7,9);

    }
}
