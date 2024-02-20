package day04;
import java.util.*;
public class WhileTest2 {
    public static void main(String[] args) {
                //[문제1]  1~100까지 정수를 다음과 같은 식으로 계산한 수식과
                //          결과값을 출력하세요
                //1+ (-2) + 3+(-4) + 5 + (-6) ....+(-100)
                int i = 1;
                int total = 0;
                while(i<101) {
                    if(i%2==0) {
                        int n=i*-1;
                        total+=n;
                        System.out.printf("(%d)", n);
                    }else {
                        System.out.printf("%d", i);
                        total+=i;
                    }
                    if(i!=100) {
                        System.out.printf("%c", '+');
                    }else {
                        System.out.printf("%c", '=');
                    }
                    i++;
                }
                System.out.println(total);
                
                //[문제2] 
                // 1+ (1+2) + (1+2+3) + (1+2+3+4)...+(1+2+...+10)
                //의 결과값을 출력하세요
                int i2=1;
                int total2=0;
                int k=0;
                while(i2<=10) {
                    total2+=i2;
                    k+=total2;
                    i2++;
                }
                System.out.println(k);
                
                //[문제3] Scanner이용해서 "구구단의 몇 단을 하시겠어요?" 입력받아 구구단식 출력하기
                Scanner sc = new Scanner(System.in);
                System.out.println("구구단의 몇 단을 하시겠어요?");
                int dan = sc.nextInt();
                int num=1;
                while(num<=9) {
                     int result = dan*num;
                     System.out.println(dan + "*" + num + "=" + result);
                    num++;
                }
            
    }
}