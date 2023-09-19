package DesignRule.RichterReplaceRule;

public class RectangleTest
{
    public static void main(String[] args) {
        // 创建长方形对象
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        // 扩宽
        resize(rectangle);
        // 打印
        printLengthAndWidth(rectangle);
    }
    // 扩宽方法，限制了对正方形类进行扩宽，它们两个不是继承关系
    public static void resize(Rectangle rectangle) {
        // 判断宽如果比长小，那么进行扩宽操作
        while(rectangle.getWidth() < rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    // 显示四边形的长和宽
    public static void printLengthAndWidth(Quadrilateral rect) {
        System.out.println(rect.getLength());
        System.out.println(rect.getWidth());
    }
}
