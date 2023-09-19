package DesignRule.RichterReplaceRule;

public class RectangleTest
{
    public static void main(String[] args) {
        // ���������ζ���
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        // ����
        resize(rectangle);
        // ��ӡ
        printLengthAndWidth(rectangle);
    }
    // �������������˶���������������������������Ǽ̳й�ϵ
    public static void resize(Rectangle rectangle) {
        // �жϿ�����ȳ�С����ô�����������
        while(rectangle.getWidth() < rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    // ��ʾ�ı��εĳ��Ϳ�
    public static void printLengthAndWidth(Quadrilateral rect) {
        System.out.println(rect.getLength());
        System.out.println(rect.getWidth());
    }
}
