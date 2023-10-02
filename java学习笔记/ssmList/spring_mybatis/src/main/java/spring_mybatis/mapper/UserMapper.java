package spring_mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import spring_mybatis.pojo.Users;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<Users> select();

    @Update("UPDATE users SET password = #{newPassword} WHERE username = #{username}")
    void update(String username, String newPassword);

    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password} AND sign = #{sign}")
    Users login(Users user);
}
