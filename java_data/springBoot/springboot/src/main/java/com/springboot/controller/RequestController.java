package com.springboot.controller;

import com.springboot.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * 测试请求参数接收
 */
@RestController
//@Controller
//@ResponseBody
public class RequestController {

    //1. 简单参数
    //原始方式
//    @RequestMapping("/simpleParam")
//    public String simplePara(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String ageStr = request.getParameter("age");
//        int age = Integer.parseInt(ageStr);
//        System.out.println(name + ":" + age);
//        return "OK";
//    }

    //springboot方式
    @RequestMapping("/simpleParam")
    public String simpleParam(String name, Integer age) {
        System.out.println(name + ":" + age);
        return "OK";
    }

//    @RequestMapping("/simpleParam")
//    public String simpleParam(@RequestParam(name = "name", required = false) String username, Integer age){
//        System.out.println(username+ ":" + age);
//        return "OK";
//    }

    // 实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {       // 接收对象为 User, 自动封装，但是必须有对应接受的参数
        System.out.println(user);
        return "OK";
    }

    // 复杂实体的封装
    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {      // 传递 Address 参数时 用 address.city 和 address.province 传递
        System.out.println(user);
        return "OK";
    }

    // 数组实体的封装
    @RequestMapping("/arrayPojo")
    public String arrayPojo(String[] hobby) {       // 数组封装
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    // 用集合封装
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {       // 集合封装, 注意必须加： @RequestParam 注解
        System.out.println(hobby);
        return "OK";
    }

    // 日期实体的封装
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {    // 指定传入的日期格式
        System.out.println(updateTime);
        return "OK";
    }

    // JSON 实体的封装
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {           // @RequestBody 将 json 格式的请求数据封装到 User 对象中
        System.out.println(user);
        return "OK";
    }

    // 路径参数, 路径参数是URL的一部分，例如： http://localhost:8080/pathParam/100, 这个100 即是参数也是路径
    @RequestMapping("/pathParam1/{id}")      // 因为 路径为动态的，即 100可能变化为 1,2,等，所以注解 @RequestMapping 也为动态
    public String pathParam1(@PathVariable Integer id) {         // @PathVariable 路径参数注解，自动将 id 绑定
        System.out.println(id);
        return "OK";
    }

    // 多个路径参数
    @RequestMapping("/pathParam2/{id}/{name}")    //多个路径参数用 / 分割
    public String pathParam2(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(name + ":" + id);
        return "OK";
    }
}