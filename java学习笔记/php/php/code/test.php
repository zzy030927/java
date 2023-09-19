<?php
    $dec = 123;
    $oct = 0o123;
    $bin = 0b10101;
    $hex = 0x123;
    echo $dec,'<br>',$oct,'<br>',$bin,'<br>',$hex,'<br>','<br>';

    $n1 = 1.23456;
    $n2 = 1.23E5;
    $n3 = 9e-10;
    echo $n1, '<br>', $n2, '<br>', $n3, '<br>', '<br>';

    $name = "liBai";
    echo "my name is $name <br>";
    echo 'my name is $name <br>';
    echo 'I\' will be back <br>';
    echo '\n <br>';
    echo "\\\ \\n \$name <br>";
    echo " $name 是我的名字 ";
    echo " $name 是我的名字 ";
    echo " ($name)是我的名字 ";
    echo " {$name}是我的名字 <br>";

    $str = <<<'abd'
    <p>My name is $name </p>
    <p>
        a
        b
        c
    </p>
abd;
    echo $str;

    $flag = false;
    echo 'flag = ', $flag , '<br>';
    echo '$flag = ', $flag == true ? 'true' : 'false', "<br>";

    $addr = ['Tom', 2];
    echo $addr[0], "学号: ", $addr[1], '<br>';
    $stu = [1=>'Jerry', 3=>'Jim', 'Tom'];
    echo $stu[1], "好朋友: ", $stu[3], " 天敌: ", $stu[4] ,'<br>';print_r($stu);

    class foo {
        public String $name = "李白";
        function do_foo() {
            echo "Doing foo".$this->name;
        }
    }
    $foo = new foo();
    $foo->do_foo();