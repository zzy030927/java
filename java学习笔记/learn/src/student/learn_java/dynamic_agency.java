package student.learn_java;

// ��̬����: ������ʽ�ĸ��������Ӷ���Ĺ���
// ����������ϵķ���̫�࣬����һ���ӿ���ת�Ʋ��ַ���
// ������ʲô����Ҫ��ת�ƣ���ô����ӿھ�һ��Ҫ��ʲô����
// ������һ���ࣨ����������Ҳȥʵ�ֽӿ��еķ����� ͨ��ʵ�ֽӿڵķ���ȥ���ö���ķ���

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Ҫת�Ƶķ�������ӿ���
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
        // ������ֻ�볪�裬����ȥ׼����Ͳ����Ǯ
        System.out.println(this.name + "���ڳ�" + name);
        return "xiexie";
    }
    public void dance()
    {
        // ֻ�����裬����ȥ׼�����أ���Ǯ��
        // ׼�����أ���Ǯ ���๦��Ҫ������ʽ�ĸ��������ӹ���
        System.out.println(this.name + "��������");
    }
}

class ProxyUtil     // ����һ������
{

    /*
      �������ã�
        ��һ�����ǵĶ��󣬴���һ������
        �βΣ�����������Ƕ���
        ����ֵ�������Ǵ����Ĵ���
     */
    public static Star creatProxy(BigStar bigStar)
    {
        // ����һ��������� java.lang.reflect.Proxy�ࣺ�ṩ�˶����������ķ�����
        // public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
        // ��һ������Ϊ���ĸ����������ȥ�������ɵĴ�����
        // �ڶ�������ָ���ӿڣ���Щ�ӿ�����Щ����
        // ��������������ָ�����ɵĴ������Ҫ��ʲô

        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
                    {
                        // ����һ������Ķ���
                        // ��������Ҫ���еķ������ӿ��еķ�����
                        // �����������÷���ʱ���ݵ�ʵ��
                        if("Sing".equals(method.getName()))
                        {// ������õ��ǳ���ķ���

                            // �� Sing()���� ������ʽ�����ӹ���
                            System.out.println("׼����Ͳ,��Ǯ");
                        }
                        else if("dance".equals(method.getName()))
                        {
                            System.out.println("׼������,��Ǯ");
                        }

                        // ȥ�Ҵ����ǳ����������
                        // ����ı�����ʽ�� ���ô����ǳ����������ķ���
                        return method.invoke(bigStar, args);
                        // ����
                    }
                }
        );

        // ProxyUtil.class �ҵ���˭�ѵ�ǰ���ֽ����ļ����ص��ڴ�� .getClassLoader()  �ѵ�ǰ�Ĵ�����ص��ڴ���
        // new Class[]{Star.class}  ���ɵĴ��������Դ��� Star �ӿ�������з���
        // ��������һ�������ڲ�����ʵ�� �������Ҫ��ʲô
        return star;
    }


}

// �������������Ҫ�Ҵ����ǳ���
// 1. ��ȡ����Ķ���
//      ������� = ProxyUtil.createProxy(�����Ƕ���);
// 2. ���ô���ĳ��跽��
//      �������.���跽��(),������ InvocationHandler() ������ʵ�ֵ�

public class dynamic_agency
{
    public static void main(String[] args)
    {
        // 1.��ȡ����Ķ���
        BigStar bigStar = new BigStar("����");
        Star star = ProxyUtil.creatProxy(bigStar);
        // 2.���ó���ķ���
        String result = star.Sing("ֻ����̫��");
        System.out.println(result);
        // �ῴ������ ��������������Ǯ��׼����Ͳ�Ĺ���

        star.dance();
    }
}
