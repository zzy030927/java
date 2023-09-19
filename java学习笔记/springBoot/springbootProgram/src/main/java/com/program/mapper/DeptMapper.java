package com.program.mapper;

import com.program.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */

// mapper 层 用于操作数据库
@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    public List<Dept> list();

    @Select("SELECT * FROM dept WHERE id = #{id}")
    public Dept selectById(Integer id);

    @Delete("delete from dept where id = #{id}")
    public int deleteById(Integer id);

    @Insert("INSERT INTO dept(name, create_time, update_time) VALUES (#{name}, #{createTime}, #{updateTime})")
    public int insert(Dept dept);

    @Update("UPDATE dept SET update_time = #{updateTime}, name = #{name} WHERE id = #{id}")
    public int update(Dept dept);

}
