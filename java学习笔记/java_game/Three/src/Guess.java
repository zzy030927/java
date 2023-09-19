import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner reader=new Scanner(System.in);
        Random random=new Random();//产生随机数
        System.out.println("给你一个100以内的整数，请你猜测");
        int realNum=random.nextInt(100)+1;
        int yourGuess=0;
        System.out.println("输入你的猜测：");
        yourGuess=reader.nextInt();
        while(yourGuess!=realNum){  //循环条件
            if(yourGuess > realNum){
                System.out.println("猜大了，再次输入：");
                yourGuess=reader.nextInt();
            }else if(yourGuess < realNum){
                System.out.println("猜小了，再次输入：");
                yourGuess=reader.nextInt();
            }
        }
        System.out.println("猜对了");
    }	}


