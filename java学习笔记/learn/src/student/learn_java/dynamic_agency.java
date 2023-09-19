package student.learn_java;

// 动态代理: 无侵入式的给代码增加额外的功能
// 对象如果身上的方法太多，可以一个接口来转移部分方法
// 对象有什么方法要被转移，那么这个接口就一定要有什么方法
// 创建另一个类（代理），代理也去实现接口中的方法， 通过实现接口的方法去调用对象的方法

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 要转移的方法存入接口中
interface Star
{
    public String Sing(String name);
    public void dance();
}

class BigStar implements Star
{
    String name;
    public BigStar(){};
    public BigStar(String name)
    {
        this.name = name;
    }
    public String Sing(String name)
    {
        // 大明星只想唱歌，不想去准备话筒，收钱
        System.out.println(this.name + "正在唱" + name);
        return "xiexie";
    }
    public void dance()
    {
        // 只想跳舞，不想去准备场地，收钱，
        // 准备场地，收钱 这类功能要无侵入式的给代码增加功能
        System.out.println(this.name + "正在跳舞");
    }
}

class ProxyUtil     // 创建一个代理
{

    /*
      方法作用：
        给一个明星的对象，创建一个代理
        形参：被代理的明星对象
        返回值：给明星创建的代理
     */
    public static Star creatProxy(BigStar bigStar)
    {
        // 创建一个代理对象 java.lang.reflect.Proxy类：提供了对象产生代理的方法：
        // public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        // 第一个参数为用哪个类加载器，去加载生成的代理类
        // 第二个参数指定接口，这些接口有哪些方法
        // 第三个参数用来指定生成的代理对象要干什么

        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
                    {
                        // 参数一：代理的对象
                        // 参数二：要运行的方法（接口中的方法）
                        // 参数三：调用方法时传递的实参
                        if("Sing".equals(method.getName()))
                        {// 如果调用的是唱歌的方法

                            // 给 Sing()方法 无侵入式的增加功能
                            System.out.println("准备话筒,收钱");
                        }
                        else if("dance".equals(method.getName()))
                        {
                            System.out.println("准备场地,收钱");
                        }

                        // 去找大明星唱歌或者跳舞
                        // 代码的表现形式： 调用大明星唱歌或者跳舞的方法
                        return method.invoke(bigStar, args);
                        // 反射
                    }
                }
        );

        // ProxyUtil.class 找到是谁把当前的字节码文件加载到内存的 .getClassLoader()  把当前的代理加载到内存中
        // new Class[]{Star.class}  生成的代理，它可以代理 Star 接口里的所有方法
        // 第三个用一个匿名内部类来实现 这个代理要干什么
        return star;
    }


}

// 需求：外面的人想要找大明星唱歌
// 1. 获取代理的对象
//      代理对象 = ProxyUtil.createProxy(大明星对象);
// 2. 调用代理的唱歌方法
//      代理对象.唱歌方法(),这是在 InvocationHandler() 参数中实现的

public class dynamic_agency
{
    public static void main(String[] args)
    {
        // 1.获取代理的对象
        BigStar bigStar = new BigStar("鸡哥");
        Star star = ProxyUtil.creatProxy(bigStar);
        // 2.调用唱歌的方法
        String result = star.Sing("只因你太美");
        System.out.println(result);
        // 会看出除了 唱歌又增加了收钱，准备话筒的功能

        star.dance();
    }
}
