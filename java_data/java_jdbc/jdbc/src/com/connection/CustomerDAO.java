package com.connection;

import java.sql.*;
import java.util.List;

/*
    �˽ӿ����ڹ淶����� customers ��ĳ��ò���,����ӿ�ֻ����� Customer ���� Customer �����һЩ����Ĳ������� BaseDAO �������б����Խ��еĲ���
    �ӿ����ڸ�����ľ���������� BaseDAO ���������һЩͨ�õĲ���
 */
public interface CustomerDAO
{
    void insert(Connection connection, Customer cust) throws Exception;
    void deleteById(Connection connection, int id) throws Exception;
    // ����ڴ��е� cust����ȥ�޸����ݱ���ָ���ļ�¼
    void updateById(Connection connection, Customer cust) throws Exception;
    Customer getCustomerById(Connection connection, int id) throws Exception;
    // ��ѯ�������м�¼���ɵļ���
    List<Customer> getAll(Connection connection, int id) throws Exception;
    // �������ݱ��е���Ŀ��
    Long getCount(Connection connection) throws Exception;
    // �������ݱ�����������
    Date getMaxBirth(Connection connection) throws Exception;
}
