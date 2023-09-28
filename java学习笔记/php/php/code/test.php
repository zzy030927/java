<?php
    $arr1 = $arr2 = ['img1', 'img5', 'img2', 'img10'];
    echo "<br>排序前: ";
    print_r($arr1);
    echo "<br>标准排序: ";
    sort($arr1);
    print_r($arr1);
    echo "<br>自然排序: ";
    natsort($arr1);
    print_r($arr1);
    echo "<br>";

    $s = "hello";
    $i = print($s);                                       // 输出一个字符串
    echo "<br>".$i."<br>";
    // 格式化规则：
    // '(char)：用字符（char）填充结果,
    // - ：在指定字段宽度时左对齐，默认右对齐
    $printf = printf("%s,%d", $s, 4);      // 输出一个格式化的字符串并返回字符串的长度,字符串的长度为参数长度之和加除了格式化标识符之外的字符
    echo "<br>".$printf."<br>";
    $sprintf = sprintf("%'#-10.2f",18561);
    echo $sprintf."<br>";

    $str = implode(",", $arr1);         // 将数组元素连接成一个字符串并返回
    echo $str."<br>";
    $arr = explode(",", $str, 2);          // 用指定字符分割字符串并返回一个数组, 2为只分割两个值
    print_r($arr);
    echo "<br>";
    echo strtok($str, ",");     // 取出第一个 , 之前的字符串，同时指针后移到第一个,之后
    echo "<br>";
    echo strtok(",");           // 取出指针之后，第二个,之前的字符串，指针后移....