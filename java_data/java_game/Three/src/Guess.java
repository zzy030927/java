import java.util.Random;
import java.util.Scanner;

public class Guess {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner reader=new Scanner(System.in);
        Random random=new Random();//���������
        System.out.println("����һ��100���ڵ�����������²�");
        int realNum=random.nextInt(100)+1;
        int yourGuess=0;
        System.out.println("������Ĳ²⣺");
        yourGuess=reader.nextInt();
        while(yourGuess!=realNum){  //ѭ������
            if(yourGuess > realNum){
                System.out.println("�´��ˣ��ٴ����룺");
                yourGuess=reader.nextInt();
            }else if(yourGuess < realNum){
                System.out.println("��С�ˣ��ٴ����룺");
                yourGuess=reader.nextInt();
            }
        }
        System.out.println("�¶���");
    }	}


