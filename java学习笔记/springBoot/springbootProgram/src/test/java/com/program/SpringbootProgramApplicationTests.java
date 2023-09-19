package com.program;

import com.program.mapper.EmpMapper;
import com.program.pojo.Emp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringbootProgramApplicationTests {

    @Autowired
    EmpMapper em;
    @Test
    void contextLoads() {
    }

    // 用于测试生成JWT令牌
    @Test
    public void testGenJWT() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");

        String jwt = Jwts.builder()
                //            采用哪种数字签名算法       自定义密钥
                .signWith(SignatureAlgorithm.HS256, "123456")   //签名算法
                .setClaims(claims)  //自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))// JWT令牌的有效期，设置为1小时 
                .compact();// 生成一个字符串类型的返回值，即JWT的值,此令牌1h后过期

        System.out.println(jwt);
//      eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5MDg4OTcxM30.VsjF55qWc3gmWeEYJ106S5pRamGAimtByjpVzVx-RCU
    }

    // 用于测试解析JWT令牌
    @Test
    public void testParseJWT() {
        Claims claims =  Jwts.parser()
                .setSigningKey("123456")    // 设置密钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5MDg4OTcxM30.VsjF55qWc3gmWeEYJ106S5pRamGAimtByjpVzVx-RCU")
                .getBody(); // 获取JWT令牌中自定义的内容
        System.out.println(claims);
    }

}
