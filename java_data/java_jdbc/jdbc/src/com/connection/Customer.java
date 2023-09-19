package com.connection;
import java.util.Date;

/*
 * ORM 编程思想（ object relational mapping） 对象 关系 映射
 * 一个数据表对应一个 java 类
 * 表中的一条记录对象 java 类的一个对象
 * 表中的一个字段对应 java 类的一个属性
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
