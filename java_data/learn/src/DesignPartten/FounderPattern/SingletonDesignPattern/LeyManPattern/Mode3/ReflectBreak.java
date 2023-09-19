package DesignPartten.FounderPattern.SingletonDesignPattern.LeyManPattern.Mode3;
import java.lang.reflect.Constructor;

public class ReflectBreak {
    public static void main(String[] args) throws Exception{
        Class<Slob> clazz = Slob.class;

        // 2.获取无参构造方法对象
        Constructor<Slob> cons = clazz.getDeclaredConstructor();

        // 3.取消访问检查 （暴力反射）
        cons.setAccessible(true);

        // 4.通过反射创建 Slob 对象
        Slob slob1 = cons.newInstance();
//        Slob slob2 = cons.newInstance();  报错，不能创建多个对象
    }
}
