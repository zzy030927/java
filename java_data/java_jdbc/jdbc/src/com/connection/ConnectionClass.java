package com.connection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
//�����������ݿ�

public class ConnectionClass
{
    @Test
    public void ConnectionClass1() throws SQLException
    {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        //      Driver �ӿ������������ݿ⣬����һ��mysql�������󣬲�������ֵ�� driver
        //	    ע��Ҫд�µ�������ַ����Ҫд�� com.mysql.jdbc.Driver(),����5.0�汾��������ַ;
        //      Driver �������ݿ�ӿڵĶ��󣬶�����������ʵ����
        //      idea : Ctrl + H �鿴ʵ����

        String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone = UTC";

        //      URL Ϊ Ҫ�����ĸ����ݿ�, ����Ϊ �� jdbc���� mysql ���ݿ⣬���ӵ�������ip����localhost
        //      �˿ں��� 3306�����ӵı��� localhost �е� test ���ݿ�
        //      ������·���� ? ������
        //      useUnicode = true&characterEncoding = utf-8 ���������ñ�������ʽ
        //      useSSL = false; ��ַ:https://blog.csdn.net/weixin_46644575/article/details/117003617?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522167973667916800197064678%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=167973667916800197064678&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~top_positive~default-1-117003617-null-null.142^v76^insert_down38,201^v4^add_ask,239^v2^insert_chatgpt&utm_term=usessl%3Dfalse&spm=1018.2226.3001.4187
        //      allowPublicKeyRetrieval = true ����ͻ��˴ӷ�������ȡ��Կ��
        //      serverTimezone = UTC��������ʹ��5.#���ݿ⻹��8.#�汾���ݿ⣬
        //      ֻҪjdbc����ʹ�õ���8.#��ô���Ǿ���Ҫ�������ݿ�ʱ�����⣬����ͻᱨʱ������
        //      ����Ҫ�� serverTimezone = GMT,��������ʱ��������

        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","zzy0927");
        //      ���û����������װ�� Properties��

        Connection connection = driver.connect(url,info);
        //      Driver �ӿ��е� connect �����������������ݿ⣬
        //      ������������� String���͵� url �� Properties���͵� info
        //      ���Ұ����������ɵ����ݸ� Connection ����

        System.out.println("���ӳɹ�");
        System.out.println(connection);
    }
}
