package AnnotationDemo;

import java.lang.annotation.*;

/**
 * Ԫע��ʹ�÷�ʽ :
 * @Target:��ʾ��ע������÷�Χ�����ÿ�ѡ��Ϊ���ࡢ����������
 * @Retention:��ʾ��ע����ʲôʱ����Ч��������ѡ�����ѡ��RUNTIME
 * @Documented:��ʾ��ע���Ƿ�д��api�ĵ���
 * @Inherited:��ʾ��ע�����ε����࣬�Ƿ��ܱ��̳�
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})   // ��ʾ AnnoDemo3 ���ע��ֻ���������࣬��������Ա������
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AnnoDemo3 {

}
