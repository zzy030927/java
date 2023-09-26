<?php
    $name = "zhangSan";
    $gender = "男";
    $age = 19;
    $stu = compact("name", "gender", "age");    // 引用变量的名字作为索引，变量的值作为数组的值
    print_r($stu);
    echo "<br>".$stu["name"]."<br>";

    $arr = ["aa" => 100, "bb" => 200, "cc" => 300];
    extract($arr);      // 从数组中将变量导入到当前的符号表：将数组的索引作为变量，数组的值作为变量的值
    echo "$aa $bb $cc"."<br>";

    $info = ["咖啡", "棕色", "咖啡因"];
    list($drink, $color, $power) = $info;   // 将 数组的每个值赋值给对应的变量
    echo $drink." ".$color." ".$power."<br>";

    // 使用range()创建数组
    $a = ['1', '2', '3'];
    $b = ['4', '5', '6'];
    $arr = array_combine($a, $b);   // 联合函数 array_combine() 第一个参数数组作为索引，第二个参数数组作为值
    print_r($arr);
    echo "<br>";

    $arr1 = range(1,5, 2);  // range()函数, 值从1开始，到5结束，步长为2
    $arr2 = range('a','f');
    var_dump($arr1, $arr2);
    echo "<br>";
    if (array_key_exists('1', $a)) {
        echo "123";
    }
    echo array_search('1', $arr1);