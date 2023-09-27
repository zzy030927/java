<?php
    class Simple {
        // 属性声明
        public $var = "hello world";
        public $num = 2;
        public static $st = 3;
        public readonly string $read;   // 只读属性不能直接初始化，需要在构造函数或者方法中进行初始化，并且只能赋值一次
        public function func(?string $str) {    // ?string 为要么返回的类型为string，要么为null,?的作用为允许返回null
            echo self::$st."<br>";          // self::  访问静态变量
            echo $this->var."<br>";         // $this-> 访问非静态变量
            echo $str."<br>";                      // 直接访问形参
        }
    }
    $sim = new Simple();
    $sim->func("zz");