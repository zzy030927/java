<a name="O1Zbr"></a>
##  第一章 php基础知识
<a name="XJszW"></a>
### 创建php代码段
:::info
php定界符：起始标记<?php<br />php定界符的其他形式：

   - 短形式<? ... ?>
   - ASP定界符<% ... %> 	// off-pn 在配置文件里面更改
   - HTML标签<script lanuage="php"> ... </script>

遵循的规则：

   - 所有用户定义的函数，类和关键词（例如if, else, echo等等）都对大小写不敏感
   - 以分号结尾
   - 变量名均已$开头，并且所有变量都对大小写敏感
:::
<a name="z3unW"></a>
### php推荐代码格式
:::info
变量定义，语句控制等用php语句，纯文本输出用html输出
:::
```php
<?php
  $i = 1;
echo $i, " + ", $i, " = ", 2 * $i, "<br>";
if ($i) {
  ?>
  <p>true</p>
  <?php
} else {
  ?>
  <p>false</p>
  <?php
}
?>
```
<a name="AM3TR"></a>
### 进制表示
```php
<?php
  $dec = 123;
  $oct = 0o123;			// 0o 表示八进制或者在 数字开头加个0也表示八进制，即0123
  $bin = 0b10101;		// 二进制
  $hex = 0x123a;		// 十六进制
  echo $dec,'<br>',$oct,'<br>',$bin,'<br>',$hex; 

	$n1 = 1.23456;	  // 小数
  $n2 = 1.23E5;			// 1.23 * 10^5
  $n3 = 9E-10;			// 9^(-10)
  echo $n1, '<br>', $n2, '<br>', $n3;
```
<a name="eysHj"></a>
### 字符串
```php
<?php
	$name = "liBai";
  echo "my name is $name <br>";		// 双引号会识别定义的变量
  echo 'my name is $name';				// 单引号为纯字符串
	echo 'I\' will be back';				// 转义字符 '\'
	// 在双引号中 $name不能直接输出，需要把 $进行转义，\n在php中为一个空格，输出\\要用\进行转义
	echo "\\\ \\n \$name";
	// echo "$name是我的名字"; 变量$name后面不能直接写字符串
	// 正确格式
  echo " $name 是我的名字 ";			// 加一个空格
  echo " $name\是我的名字 ";			// 加一个除了中文及中文字符及英文字母及数字之外随便一个字符，例子: $name*是我的名字
  echo " {$name}是我的名字 ";		// 输出时变量和后面字符串连在一起

	// heredoc结构定义字符串，与双引号作用相似，可以解析变量，！！！可以嵌入html！！！
  $str = <<<EOD			// EOD为自定义的
      <p>My name is $name </p>
      <p>
          a
          b
          c
      </p>
  EOD;
      echo $str;

// newdoc结构定义字符串，与单引号作用相似，但是 '和\ 不需要再进行转义
	$str = <<<'abd'		// newdoc结构需要加 单引号
    <p>My name is $name </p>
    <p>
        a
        b
        c
    </p>
abd;
    echo $str;
```
<a name="PcyVu"></a>
### 变量
```php
<?php
    if(!defined("USER")) {			// 如果没有定义常量USER
        define("USER","root");	// 定义常量USER
        echo USER;
    }
```
```php
<?php
    define("TITLE", "PHP常量应用示例");
    const NL = "\n";
    echo "<h3>".TITLE."</h3>".NL;
    echo "<ul>";
    echo "<li>当前操作系统: ".PHP_OS."</li>".NL;
    echo "<li>PHP版本号: ".PHP_VERSION."</li>".NL;
    echo "<li>当前目录: ".__DIR__."</li>".NL;
    echo "<li>当前文件: ".__FILE__."</li>".NL;
    echo "<li>当前代码执行号: ".__LINE__."</li>".NL;
```
```php

<?php
    $username = "晚霞";
    $password = &$username; // 指向同一块地址
    echo $username.",".$password."<br>";
    $password = "月亮";     // 地址内的值改变，那么一起改变，并不是$passwrod指向一块新的地址
    echo $username.",".$password."<br>";
```
```php
// 一个变量作为另一个变量的变量名
<?php
  $x = "hello";
	$$x = "world";		// 相当于 $hello = "world";
	echo "$x $$x";		// 输出： hello $hello。 $$x没有被解析
	echo "$x {$$x}";	// 输出: hello world。
										// 也可以写成 ${$x},理解：$x="hello",那么$hello="world";
```
```php
<?php
    $a = 1;
    $b = 2;

    function Sum()
    {
        global $a, $b;  // 在函数中声明了全局变量 $a 和 $b 之后，对任一变量的所有引用都会指向其全局版本。
        $b = $a + $b;
    }

    Sum();
    echo $b;
```
```php
<?php
  function Test()		
  {
      $a = 0;
      echo $a;
      $a++;								// Test函数调用结束后 $a被销毁
  }
	function test()
  {
      static $a = 0;
      echo $a;
      $a++;							// test()函数结束后$a不被销毁，知道整个程序结束后，销毁$a
  }
	// 常量表达式的结果可以赋值给静态变量，但是动态表达式（比如函数调用）会导致解析错误。
	// static $int = sqrt(121);  // 错误（因为它是函数）
?>
```
<a name="JRDsB"></a>
### 数组
```php
<?php
	$flag = false;										// 0为false，其他数值全为true
  echo 'flag = ', $flag , '<br>';		// flag为假什么都不输出
  echo '$flag = ', $flag == true ? 'true' : 'false';
```
```php
<?php
  $arr = array(1, 2, 3);	// array() 函数，可用于定于数组
  $addr = ['Tom', 2];
  echo $addr[0], "学号: ", $addr[1], '<br>';
  $stu = [1=>'Jerry', 3=>'Jim', 'Tom'];			// 更改Jerry索引为1，Jim索引为3，那么Tom索引自增为4
  echo $stu[1], "好朋友: ", $stu[3], " 天敌: ", $stu[4] ,'<br>';
	print_r($stu);	// 打印整个数组,使用echo输出数组只会输出Array
	$stu1 = [1=>'Jerry', 3=>'Jim', 3=>"Kim", "name"=>'Tom'];		// 多个索引相同，只保留最后一个索引,也可以用字符串作为索引
	print_r($stu);	// Array ( [1] => Jerry [3] => Tom ) 保留了Tom
	echo $stu1[0];	// 打印 第0个元素
```
```php
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
  	// 定义多维数组
    $douArray = array(
        1 => array("Tom", 2, 3),
        2 => array("Jerry", 4, 5, 6)		// 当列数不同时，不进行任何改动，也就是 第一行有3个元素，第二行有4个元素
    );
    print_r($douArray);
  	// 使用range()创建数组
    $a = ['1', '2', '3'];
    $b = ['4', '5', '6'];
    $arr = array_combine($a, $b);   // 联合函数 array_combine() 第一个参数数组作为索引，第二个参数数组作为值
    print_r($arr);
    echo "<br>";

    $arr1 = range(1,5, 2);  // range()函数, 值从1开始，到5结束，步长为2
    $arr2 = range('a','f');      
    var_dump($arr1, $arr2);
```
```php
<?php
  $arr = [1, 2, 3];
	foreach($arr ad $key=>$value) {
    echo "key = ".$key."<br>";
  	echo "value = ".$value."<br>";
}
```
```php
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
    echo $drink." ".$color." ".$power;
  	if (array_key_exists('aa', $arr)) {			// 查看对应的数组键是否存在
      echo $arr;
    }
  	echo	array_search(100, $arr);					// 根据值查找键
```
<a name="l5VYS"></a>
### 函数
:::info
值传参：只传入具体值<br />引用传参：加一个&传入变量的地址
:::
<a name="im3H7"></a>
#### 函数参数
```php
<?php
  function modify($a) {
  $a = '123';
  }
  $a = '456';
  add($a);
  echo $a;		// 456
```
```php
<?php
    function add(&$a) {
        $a = '123';
    }
    $a = '456';
    add($a);
    echo $a;		// 123
```
```php
<?php
function makeCoffee($types = array("cappuccino"), $coffeeMaker = NULL)	// 默认参数为 对象，变量，array，null
{
    $device = is_null($coffeeMaker) ? "hands" : $coffeeMaker;
    return "Making a cup of " . join(", ", $types) . " with $device.\n";
}
echo makeCoffee();
echo "<br>";
echo makeCoffee(array("cappuccino", "lavazza"), "teapot");
echo "<br>";
echo makeCoffee(coffeeMaker: "teapot");		// 只传入指定的值
?>
```
```php
<?php
function sum(...$numbers) {				// 用 ... 表示可变参数
    $acc = 0;
    foreach ($numbers as $n) {
        $acc += $n;
    }
    return $acc;
}

echo sum(1, 2, 3, 4);
?>

<!-- 也可用 ... 语法传递 array作为参数到函数中  -->
<?php
function add($a, $b) {
    return $a + $b;
}

echo add(...[1, 2])."\n";

$a = [1, 2];
echo add(...$a);
?>
```
<a name="qApAa"></a>
#### 函数返回值
:::info
没有设置返回值，那么返回null<br />只能返回一个值，可以返回一个引用
:::
```php
<?php
    function &returns_reference()
    {
        $someref = 1;
        return $someref;
    }

    $newref =& returns_reference();
    echo $newref;			// 1
```
```php
<?php
    function small_numbers()
    {
        return [0, 1, 2];
    }
    // 使用短数组语法将数组中的值赋给一组变量
    [$zero, $one, $two] = small_numbers();
    echo $one.'<br>'.$two.'<br>'.$zero;
```
<a name="fpl8W"></a>
#### 可变函数
:::info
PHP 支持可变函数的概念。这意味着如果一个变量名后有圆括号，PHP 将寻找与变量的值同名的函数，并且尝试执行它。可变函数可以用来实现包括回调函数，函数表在内的一些用途。<br />可变函数不能用于例如 [echo](https://www.php.net/manual/zh/function.echo.php)，[print](https://www.php.net/manual/zh/function.print.php)，[unset()](https://www.php.net/manual/zh/function.unset.php)，[isset()](https://www.php.net/manual/zh/function.isset.php)，[empty()](https://www.php.net/manual/zh/function.empty.php)，[include](https://www.php.net/manual/zh/function.include.php)，[require](https://www.php.net/manual/zh/function.require.php) 以及类似的语言结构。需要使用自己的包装函数来将这些结构用作可变函数。
:::
```php
<?php
    function foo() {
        echo "In foo()<br />\n";
    }

    function bar($arg = '') {
        echo "In bar(); argument was '$arg'.<br />\n";
    }

    // 使用 echo 的包装函数
    function echoit($string) {
        echo $string;
    }

    $func = 'foo';
    $func();        // 调用 foo()

    $func = 'bar';
    $func('test');  // 调用 bar()

    $func = 'echoit';
    $func('test');  // 调用 echoit()
```
```php
<?php
    class Foo
    {
        static function bar() {
            echo "bar\n";
        }
        function baz() {
            echo "baz\n";
        }
    }
  	class Tes
		{
      	static function fun() {
          echo "fun\n";
        }
    }
  	$name = "bar";											
  	Foo::$name(); // 打印 "bar"					// 可变参数想要调用类中的方法，需要指定类名
    $func = array("Foo", "bar");				// 也可以用数组表示，第一个值为类名，第二个值为函数名，这个数组有且只有两个值
    $func(); // 打印 "bar"							// 那么这里就可以直接调用
    $func = array("Tes", "fun");
    $func();// 打印 "fun"
    $func = array(new Foo, "baz");
    $func(); // 打印 "baz"
    $func = "Foo::bar";									// 也可以在字符串中指定类名
    $func(); // 打印 "bar"
```
<a name="Ic4Vs"></a>
#### 自定义函数
```php
<?php

    bar();
    function bar()
    {
        echo "I exist immediately upon program start."."<br>";
    }
    /* 不能在此处调用foo()函数，
       因为makefoo还没有被定义，所以foo()函数还不存在，但可以调用bar()函数。*/
    //    foo();
    $makefoo = true;

    if ($makefoo) {
        function foo()
        {
            echo "I don't exist until program execution reaches me."."<br>";
        }
    }

    /* 现在可以安全调用函数 foo()
       因为 $makefoo 值为真 */

    if ($makefoo) foo();
```
```php
<?php
  function foo()
  {
    function bar()
    {
      echo "I don't exist until foo() is called.\n";
    }
  }
  
  /* 现在还不能调用 bar() 函数，因为它还不存在 */
  
  foo();
  
  /* 现在可以调用 bar() 函数了，因为 foo() 函数
     的执行使得 bar() 函数变为已定义的函数 */
  
  bar();
```
<a name="gWtmj"></a>
### 类型转换
```php
<?php
  $x = "1.1";
  $x *= 2.3;
  echo '$x = ', $x;	// php中字符串类型的整数、浮点数都可以直接参与算术运算
	$x *= "1041 little piggies";	// 数字在字符串首尾，那么这个数字会参与运算，否则就会被当成0
  echo '$x = ', $x;
```
```php
// 需要明确告诉程序要转换成什么类型
<?php
    $x = (int)"abc";		
    echo $x;						// 字符串转换为整数会转换为 0
  	$f = (int)3.99;
  	echo $f;						// 浮点数转整形向下取整。
  	$b = -99;						
  	echo $b;						// // 0为false，其他数值全为true
```
<a name="DEc88"></a>
### 比较运算符
```php
<?php
  echo 1 == '1';			// true
  echo 1 == '1.0';		// true
	echo 1 === 1.0;			// false， ===为全相等，即值和数据类型都相等为ture
	// 错误控制运算符：
    	// 用 @ 表示，将它放在一个变量或者函数之前，那么他会忽略错误，不会输出错误信息
	// 执行运算符：
    	// 用 `` 表示
```
<a name="rMmzK"></a>
### 类
<a name="VtMkJ"></a>
#### readonly
```php
<?php
  // 将类标记为readonly只读类只会向每个声明的属性添加 readonly修饰符 并禁止创建 动态属性。
  // 当子类也是readonly类时，才可以继承readonly类
```
```php
<?php
    class Simple {
        // 属性声明
        public $var = "hello world";
        public $num = 2;
        public static $st = 3;
        public readonly string $read;   // 只读属性不能直接初始化，需要在构造函数或者方法中进行赋值，并且只能赋值一次
        public function __construct()   // 在构造方法中进行赋值
        {
            $this->read = "1";
            echo $this->read;
            // $this->read = "2";  报错
        }
	}
	$sim = new Simple();
```
<a name="Bh20F"></a>
#### 类函数访问静态变量、非静态变量
```php
<?php
  class Simple {
  // 属性声明
  public $var = "hello world";
  public $num = 2;
  public static $st = 3;
  public function func(?string $str) {    // ?string 为要么返回的类型为string，要么为null,?的作用为允许返回null
    echo self::$st."<br>";  			 // self::  访问静态变量
    echo $this->var."<br>";        // $this-> 访问非静态变量
    echo $str;              			 // 直接访问形参
  }
}
$sim = new Simple();
$sim->func("zz");
```
<a name="eaz0q"></a>
#### 常量
```php
<?php
  class MyClass
  {
      public const CONSTANT = 'constant value';		// private 修饰只能在类内访问
  
      function showConstant() {
          echo  self::CONSTANT . "\n";		// 访问静态变量用 self:: 访问
      }
  }
  
  echo MyClass::CONSTANT . "\n";				  // 通过类名访问 
  
  $classname = "MyClass";
  echo $classname::CONSTANT . "\n";
  
  $class = new MyClass();
  $class->showConstant();
  
  echo $class::CONSTANT."\n";
```
<a name="nQuWY"></a>
#### 类的自动加载
:::info
spl_autoload_refister()函数，参数传递一个函数，自动加载需要的后缀文件
:::
```php
<?php
  spl_autoload_register(function ($class_name) {
      require_once $class_name . '.php';
  });
  // 尝试分别从 MyClass1.php 和 MyClass2.php 文件中加载 MyClass1 和 MyClass2 类。
  $obj  = new MyClass1();
  $obj2 = new MyClass2();
```
<a name="HwVAr"></a>
#### 构造函数和析构函数
```php
<?php
  class MyDestructableClass {
      function __construct() {		// 构造函数，和C++相同，先运行父类的构造函数
          print "In constructor\n";
      }
  
      function __destruct() {			// 析构函数，和C++相同，先运行自己的析构函数
          print "Destroying " . __CLASS__ . "\n";
      }
  }
  $obj = new MyDestructableClass();
```
<a name="VabF8"></a>
### goto
:::info
跳转到指定一行
:::
```php
<?php
    $a = 1;
    goto a;							// 跳转到指定 a 这一行
    echo 3;							// 因为直接跳转，中间的程序都不执行
    a: echo $a."<br>";	// 指定a这一行
    echo 4;
```
<a name="h5D8V"></a>
### include
:::info
include用于包含并运行指定文件<br />include_once与include区别为include_once只能被引用一次
:::
```php
<?php
    $domin = "www.baidu.com";
    $email = "baidu@edu.com";
    return "OK";
```
```php
<?php
  global $email;					// 想要用test.php中的变量，那么就要定义与test.php中变量名相同的全局变量
  include "test.php";			// 引用test.php中的内容
  echo $email;
	echo include "test.php";		// 会打印test.php中返回的内容
```
<a name="GBabh"></a>
### <br />
