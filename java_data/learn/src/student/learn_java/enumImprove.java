package student.learn_java;

// 枚举正式使用
public class enumImprove {
    enum Person{
        ZHANGSAN("male", 20), LISI("female", 25), WANGWU("male", 30);
        private String sex;
        private int age;
        Person(String sex, int age) {   // 枚举类型构造函数
            this.sex = sex;
            this.age = age;
        }

        // 自定义方法
        public void setSex(String sex){
            this.sex = sex;
        }

        // 重写方法

        @Override
        public String toString() {
            return  "sex='" + sex +
                    ", age=" + age;
        }
    }

    public static void main(String[] args) {
        System.out.println(Person.LISI.age);
        System.out.println(Person.ZHANGSAN.sex);

        System.out.println("里斯性别:" + Person.LISI.sex);
        Person.LISI.setSex("male");
        System.out.println("里斯新性别: " + Person.LISI.sex);

        System.out.print("重写方法toString(): ");
        System.out.println(Person.LISI.toString());
    }
}
