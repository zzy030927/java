<?php
    $a = 1;
    $b = 2;
    $array_name = array($a, $b, 3);
    // 取最大索引值加1作为新索引:
    $array_name[] = $array_name[3];
    // 引用多维数组 $array_name[key1][key2]
    // 使用短数组语法创建数组
    $array_name1 = [1 => 1, 2 => 3];
    // 删除整个数组
    unset($array_name1);
    // 删除数组中某个元素
    unset($array_name, $a);