package com.springboot.controller;

import com.springboot.pojo.Address;
import com.springboot.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// 给浏览器的响应
@RestController
public class ResponseController {
    /*
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/getAddr")
    public Address getAddr() {
        Address address = new Address();
        address.setProvince("河北");
        address.setCity("北京");
        return address;             // 将 Address 这个对象转换为 JSON 再响应回去
    }

    @RequestMapping("/listAddr")
    public List<Address> listAddr() {
        List<Address> addresses = new ArrayList<>();

        Address address1 = new Address();
        address1.setProvince("河北");
        address1.setCity("北京");

        Address address2 = new Address();
        address2.setProvince("河北");
        address2.setCity("天津");

        Address address3 = new Address();
        address3.setProvince("河北");
        address3.setCity("上海");

        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);

        return addresses;           // addresses 转换为 JSON 格式的数组，里面有三个 Address类型的对象 address1、address2、address3
    }
    */

    // 因为返回的数据类型各不相同，所以为了方便，规定了统一的响应格式，封装一个类 Result
    @RequestMapping("/hello")
    public Result hello() {
        return Result.success("hello");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address address = new Address();
        address.setProvince("河北");
        address.setCity("北京");
        return Result.success(address);
    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        List<Address> addresses = new ArrayList<>();

        Address address1 = new Address();
        address1.setProvince("河北");
        address1.setCity("北京");

        Address address2 = new Address();
        address2.setProvince("河北");
        address2.setCity("天津");

        Address address3 = new Address();
        address3.setProvince("河北");
        address3.setCity("上海");

        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);

        return Result.success(addresses);
    }
}
