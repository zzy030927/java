package com.connection;
import java.sql.*;


/*
 * ���ݿ�����:
 * ����һ���߼�������Ԫ�������ݴ�һ��״̬�任����һ��״̬
 *      һ���߼�������Ԫ��һ������ DML ��������� DML ����֮���й����������� DML ����Ϊ һ���߼���Ԫ
 * �������ԭ�� ��Ҫ��֤������Ϊһ��������Ԫ��ִ�У���ʹ���˹��ϣ������ܸı�����ִ�з�ʽ��
 *              Ҫô�������ݶ����ύ commit�����ݱ����ñ���������ע�⣺����һ���ύ���Ͳ��ɻع�
 *              Ҫô���ݿ�������еĲ�����ͬʱ���ݿ� rollback �������״̬��
 *  DDL�����ݿⶨ�����ԣ� ALTER\CREATE\DROP\TRUNCATE ��
 *  DML�����ݿ�������ԣ� INSERT\UPDATE\DELETE ��
 *  DDL����һ��ִ�У������Զ��ύ
 *  DMLĬ������£�һ��ִ�У����Զ��ύ -> set autocommit = false ȡ���Զ��ύ����������� DDL ʧЧ
 *  Ĭ���ڹر�����ʱ���Զ��ύ֮ǰִ�в������µ�����
 */

// ����� ACID ����
// 1.ԭ���ԣ�������һ�����ɷָ�Ĺ�����λ��Ҫô��������Ҫô��������
// 2.һ���ԣ���������һ��һ����״̬�任Ϊ��һ��һ����״̬
// 3.�����ԣ�һ���������һ�������ܲ������ţ�һ�������ڲ�����������һ�������ǲ�Ӱ��ģ�����ִ�еĸ�������֮�以��Ӱ��
// 4.�־��ԣ�һ������һ�����ύ����ô�������ݿ�ĸı��������Եģ����������������������ݿ���ϲ����������κ�Ӱ��

// ���ݿ�Ĳ������⣺���ڶ�����е����񣬵���Щ����������ݿ���ͬ������ʱ�����û�в��ñ�Ҫ�ĸ�����ƣ��ͻᵼ�¸��ֲ������⣺
// 1.����������������� T1,T2����� T1��ȡ���Ѿ��� T2���µ��ǻ�û���ύ���ֶΣ�֮���� T2 �ع���T1 ��ȡ����������ʱ����Ч�ģ���������Ǳ���Ҫ������ġ�
// 2.�����ظ����������������� T1,T2,��� T1 ��ȡ��һ���ֶΣ�Ȼ�� T2 �����˸��ֶΣ�֮�� T1 �ٴζ�ȡ���ֶ�ʱ���ָ��ֶε�ֵ�Ѿ����ı䡣�����������ǿ��Ա����ܵ�
// 3.�ö��������������� T1,T2, T1��һ�����ж�ȡ��һ���ֶΣ�Ȼ�� T2 ������һЩ�µ��У�֮����� T1 �ٴβ�ѯ�����ʱ�ᷢ�ֱ�ദ�������ݣ��ö���������ǿ��Ա����ܵġ�

// ���ָ��뼶��
// 1. READ UNCOMMITTED����δ�ύ���ݣ�  ����������ظ������ö���Ϊ���
// 2. READ COMMITTED  �������ύ���ݣ�  ��������
// 3. REPEATABLE READ �����ظ�����     ���������������ظ������� T2 ���������ݺ���� T1 ��δ�ر����ӣ���ô T1 �����Ļ���ԭ��������
// 4. SERIALIZABLE    �����л���       ���������������ظ������ö����� T2 ���������ݺ���� T1 ��δ�ر����ӣ���ô T1 �鵽�Ļ���ԭ��������

public class Transaction
{
    public static void transaction() throws Exception  {
        Connection connection;
        connection = ConnectionClassFIve.ConnecionClass5();
        try
        {
            // ȡ�������Զ��ύ����
            connection.setAutoCommit(false);
            String sql = "UPDATE user_table SET balance = balance + 100 WHERE user = ?";
            String name = "AA";
            String sql1 = "UPDATE user_table SET balance = balance - 100 WHERE user = ?";
            String name1 = "BB";
            preparedStatement.OptimizeUniverseDML(connection, sql, name);
            preparedStatement.OptimizeUniverseDML(connection, sql1, name1);
            //������ύ����
            connection.commit();
        }
        catch(Exception e)  // �����쳣��ת�� catch
        {
            // ��������쳣���ع�����
            connection.rollback();
            e.printStackTrace();
        }
        finally
        {
            connection.setAutoCommit(true);
            close.closeResource(connection, null);
        }
    }
}
