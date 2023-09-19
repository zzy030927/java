<?php
    $bool = 0;
    echo empty("0") ? "null" : "notnull", "<br>";       // empty只能传入一个参数
    echo empty(0) ? "null" : "notnull", "<br>";
    echo empty(false) ? "null" : "notnull", "<br>";
    echo empty('0') ? "null" : "notnull", "<br>";
    echo empty(null) ? "null" : "notnull", "<br>";
    echo empty([]) ? "null" : "notnull", "<br>";
    echo empty([null]) ? "null" : "notnull", "<br>";    // notnull
    echo empty($x) ? "null" : "notnull", "<br>";
    echo empty($bool) ? "null" : "notnull", "<br>";
    echo isset($bool) ? "set" : "notset", "<br>";
    echo isset($bool, $x) ? "set" : "notset", "<br>";   // isset可以传入多个参数，只要有一个没有被赋值，那么就返回false
?>
