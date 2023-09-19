package com.program.mapper;

import com.program.pojo.Emp;
import com.program.pojo.Login;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    @Select("SELECT count(*) FROM emp")
    public Long count();

    @Select("SELECT * FROM emp LIMIT #{pageStart}, #{pageSize}")
    List<Emp> page(Integer pageStart, Integer pageSize);

    @Select("SELECT * FROM emp")
    List<Emp> list();

    List<Emp> chooseEmp(String name, Short gender, LocalDate createTime, LocalDate updateTime);

    void delete(Integer[] ids);

    void insert(Emp emp);

    @Select("SELECT * FROM emp WHERE id = #{id}")
    Emp select(Integer id);

    void update(Emp emp);

    @Select("SELECT * FROM emp WHERE username = #{username} AND password = #{password}")
    Login login(Login log);

    @Delete("DELETE FROM emp WHERE dept_id = #{id}")
    void deleteByDept(Integer id);
}
