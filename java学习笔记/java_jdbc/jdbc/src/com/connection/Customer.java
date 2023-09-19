package com.connection;
import java.util.Date;

/*
 * ORM ���˼�루 object relational mapping�� ���� ��ϵ ӳ��
 * һ�����ݱ��Ӧһ�� java ��
 * ���е�һ����¼���� java ���һ������
 * ���е�һ���ֶζ�Ӧ java ���һ������
 */
public class Customer
{
    private int id;
    private String name;
    private String email;
    private Date birth;
    public Customer(){
        super();
    };
    public Customer(int id, String name, String email, Date birth)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }


    public void setId(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setDate(Date birth)
    {
        this.birth = birth;
    }
    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public Date getDate()
    {
        return birth;
    }
    public String toString()
    {
        return "Customer [id = " + id + ", name = " + name + ", email = " + email + ", Date = " + birth + "]";
    }
}
