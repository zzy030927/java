<?php
    function sum() {
        $acc = 0;
        $count = func_num_args();
        $func_get_args[] = func_get_args();
        echo $func_get_args[0];
        return $acc;
    }
    $x = sum(1, 2, 3);
    echo gettype($x)."<br>";
    echo sum(1, 2, 3);