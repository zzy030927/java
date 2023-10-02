package spring_mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private String username;
    private String password;
    private Integer sign;   // 1用户，2管理
}