package student.learn_java;

// ö����ʽʹ��
public class enumImprove {
    enum Person{
        ZHANGSAN("male", 20), LISI("female", 25), WANGWU("male", 30);
        private String sex;
        private int age;
        Person(String sex, int age) {   // ö�����͹��캯��
            this.sex = sex;
            this.age = age;
        }

        // �Զ��巽��
        public void setSex(String sex){
            this.sex = sex;
        }

        // ��д����

        @Override
        public String toString() {
            return  "sex='" + sex +
                    ", age=" + age;
        }
    }

    public static void main(String[] args) {
        System.out.println(Person.LISI.age);
        System.out.println(Person.ZHANGSAN.sex);

        System.out.println("��˹�Ա�:" + Person.LISI.sex);
        Person.LISI.setSex("male");
        System.out.println("��˹���Ա�: " + Person.LISI.sex);

        System.out.print("��д����toString(): ");
        System.out.println(Person.LISI.toString());
    }
}
