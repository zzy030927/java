package ExceptionDemo;

// 经常使用的方法
// getMessage() 返回异常的详细消息字符串
// toString() 返回可抛出的简短描述
// printStackTrace() 把异常的错误信息打印到控制台上
public class UsuallyUserMethod {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        try {
            System.out.println(nums[6]);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass().getName()); // 反射
            System.out.println(e);
            e.printStackTrace();
        }
        System.err.println("--------------123------------");    // 将内容变为错误信息进行打印
    }
}
