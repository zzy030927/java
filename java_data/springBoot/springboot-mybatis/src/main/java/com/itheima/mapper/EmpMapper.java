package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {
    // 根据 id 删除数据
    @Delete("DELETE FROM emp WHERE id = #{id}")     // 动态获取 传入参数的方式
    public void delete(Integer id);

    // useGenerateKeys = true 表示要获取返回的主键值， keyProperty = "id" 表示把返回的主键值封装到 Emp 的 id 属性中
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUES (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    // 这里传入的都是 Emp 的属性
    public void insert(Emp emp);

    // 更新数据
    @Update("UPDATE emp SET username = #{username},name = #{name},gender = #{gender}," +
            "image = #{image}, job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId},update_time = #{updateTime} WHERE id = #{id}")
    public void update(Emp emp);

    // 查询数据
    // 方案二：因为 emp表的 列名为 dept_id，而 Emp类中的属性名为 deptId，所以要起别名，（方案一直接在查询语句字段后定义别名，和 sql定义别名方式相同）
    // 方案三：开启 mybatis 的驼峰命名自动映射开关，在配置文件中声明
    @Results({
        @Result(column = "dept_id", property = "deptId"),
        @Result(column = "update_time", property = "updateTime"),
        @Result(column = "create_time", property = "createTime")
    })
    @Select("SELECT * FROM emp WHERE id > #{id} AND name Like concat('%', #{name}, '%')")
    public List<Emp> select(Integer id, String name);
    public List<Emp> selectInXml(Integer id, String name);    // 用 xml 配置文件实现 sql查询

    // 批量删除员工
    public void deleteByIds(List<Integer> ids);
}
