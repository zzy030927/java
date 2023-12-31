<a name="J5YEV"></a>
# 总体
:::info
静态网页技术：

   - 结构
      - HTML
      - XML
      - XHTML
   - 表现
      - CSS层叠样式表
   - 行为
      - DOM文档对象模型
      - JavaScript脚本语言
:::
<a name="Ke55s"></a>
# HTML
<a name="YNH9M"></a>
### 通用属性
:::info

- id: 定义元素的唯一标识，一个html页面中，id不嫩那个相同
- name: 定义元素的名称，名称可以相同
- title：定义提示工具中显示的文本
- class：定义元素引用的一个或多个CSS样式类名
- style：定义元素的行内CSS样式
- disabled：规定表单元素输入时使之变为不可用
:::
<a name="Ge2OI"></a>
### 特殊字符
:::info

- 空格：&nbsp;
- &: &amp;
- <: &lt;
- >: &gt;
:::
<a name="dWyV5"></a>
### 标签
<a name="lEYkg"></a>
#### a标签
```html
<a href="www.baidu.com" target="_blank">百度<超链接</a>
<!-- href属性：超链接
		 target属性：在哪个地方打开, _blank在新页面打开，_self在本页面打开   
-->

<a name="属性"></a>	<!-- 创建一个锚点 -->
<h1>属性</h1>

<a href="#属性">回到“属性”</a>		<!-- 点击后可以跳到到 锚点的位置 -->
```
<a name="pFVxD"></a>
#### 列表标签
:::info
列表类型：

- <ol> 有序列表
- <ul>无序列表
- <dl>自定义列表

列表项<li>
:::
```html
<ol>
    <li>1</li>
    <li>2</li>
    <li>3</li>
</ol>
<p>
    无序列表
</p>
<ul>
    <li>3</li>
    <li>5</li>
    <li>2</li>
</ul>
<dl>
  <dt>做好笔记</dt>
  <!--define title 定义标题 dt-->
  <dd>笔记是复习的重点</dd>
  <!--define describe dd标签为 解释-->
  <dt>多加练习</dt>
  <dd>只有敲出来的代码，才是自己的</dd>
  <dt>别怕出错</dt>
  <dd>错是很正常的</dd>
</dl>

<!-- 列表嵌套 -->
<ul>
  <li>组织人员管理
      <ol>
          <li>人员管理</li>
          <li>部门管理</li>
      </ol>
  </li>
  <li>权限管理
      <ul>
          <li>角色管理</li>
          <li>授权管理</li>
      </ul>
  </li>
</ul>
```
<a name="xJJdZ"></a>
#### 音视频标签-audio-video
```html
<audio controls>	<!-- controls 显示音频条 -->
    <source src="">		<!-- 资源位置 -->
</audio>
```
```html
<video controls autoplay>		<!-- autoplay 自动播放 -->
    <source src="">
</video>
```
<a name="pQQ4C"></a>
#### 表格
:::info

- 表格通常用来组织结构化的信息
- 表格是由单元格按照从左到右，从上到下的顺序排列到一起构成
- 表格的数据保存在单元格内
   - 显示表格数据
   - 设置于页面布局		
:::
```html
<!--表格各种标签-->
<!--    表格标题: caption
        表格头部: thead   table head的意思
        表格主体: tbody
        表格脚注: tfoot
      	创建行: tr		table row：行
      	创建列: td		table body:表示table body内的单元格
			  表格头部内单元格：th        table head: 表示table head里的单元格
-->
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表格</title>
</head>
<body>
<!--表格各种标签-->
<!--    表格标题: caption
        表格头部: thead   table head的意思
        表格主体: tbody
        表格脚注: tfoot
-->
  <table border="3" cellspacing="0" align="center">
    <!-- table标签 表示一个表格-->
    <!-- border属性 表示有一个 3 像素宽的边框-->
<!--    表格标题-->
    <caption>学生信息</caption>
<!--    表格头部-->
    <thead align="center">
      <tr> <!--行-->
        <th width="40">姓名</th>
        <th width="40">性别</th>
        <th width="40">年龄</th>
        <th width="40">民族</th>
        <th width="70">政治面貌</th> <!--行内单元格-->
        <!--tr标签 table row 表示行-->
        <!--th标签 表示 table head里面的东西，是一个一个的单元格-->
      </tr>
    </thead>
<!--    表格主体-->
    <tbody align="center">
    <!--td 标签： 表格内的数据，是 table body 内的一个一个单元格，注意：区别于 th，td为 tbody内的单元格-->
      <tr>  <!--第一行-->
        <td>张三</td>
        <td>男</td>
        <td>18</td>
        <td>汉族</td>
        <td>团员</td>
      </tr>
      <tr>  <!--第二行-->
        <td>李四</td>
        <td rowspan="2">男</td>		<!-- rowspan为跨行 -->
        <td>20</td>
        <td>满族</td>
        <td>群众</td>
      </tr>
    <tr>  <!--第三行-->
      <td>王五</td>								<!-- 由于上一行 跨行，所以这一行不用定义 男女 -->
      <td>19</td>
      <td>回族</td>
      <td>党员</td>
    </tr>
    <tr>  <!--第四行-->
      <td>赵六</td>
      <td>女</td>
      <td>21</td>
      <td>壮族</td>
      <td>团员</td>
    </tr>
    </tbody>
<!--    表格脚注-->
    <tfoot align="center">
    <!--脚注中的单元格和 tbody中单元格表示一样，都为 td-->
      <tr>
        <td colspan="4"></td> <!--colspan为横跨几列-->
        <td>共计: 4人</td>
      </tr>

    </tfoot>
  </table>
</body>
</html>
```
<a name="z0rgG"></a>
##### 表格嵌套
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表格嵌套</title>
</head>
<body>
    <table border="0" width="80%" align="center" cellspacing="0" cellpadding="5">
        <caption>表格嵌套</caption>
        <tr>
            <td>用户列表&nbsp;
                <button type="button">注册</button>
            </td>
        </tr>
        <tr>
            <td>			<!-- 一定要放在td内 -->
                <table border="1" width="100%" cellpadding="5" cellspacing="0">
                    <tr>
                        <td width="30%">姓名</td>
                        <td width="30%">性别</td>
                        <td width="40%">操作</td>
                    </tr>
                    <tr>
                        <td>张三</td>
                        <td>男</td>
                        <td>
                            <button type="button">修改</button>
                            <button type="button">删除</button>
                        </td>
                    </tr>
                    <tr>
                        <td>李四</td>
                        <td>男</td>
                        <td>
                            <button type="button">修改</button>
                            <button type="button">删除</button>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr align="center">
            <td>
                <a href="https://www.baidu.com">上一页</a>&nbsp;
                <a href="https://www.baidu.com">下一页</a>
            </td>
        </tr>
    </table>
</body>
</html>
```
<a name="KbkhV"></a>
#### 表单
:::info

- 表单定义：<form></form>
- 主要属性：
   - -action: 定义表单被提交时发生的动作，一般是服务器提供的URL地址
   - method: 表单数据提交的方式，GET或POST
   - enctype: 表单数据进行编码的方式
   - name: 表单名称
   - id：表单id
- 表单控件：
   - input：
      - type :根据不同的type属性值，可创建各种类型的输入，比如文本框，复选框
      - value：控件的数据
      - name：控件的名称
      - id：控件id
:::
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表单</title>
</head>
<body>
<form name="frmLogin"
      id="frmLogin"
      action="https://www.baidu.com"
      method="get">			<!-- get方法提交数据时，数据会暴露在外面 -->
                        <!-- post方法提交数据时，会被封装到页面里面 -->
    <label for="userName">用户名: </label>						<!-- placeholder为提示信息     minlength为最小长度 -->
    <input type="text" name="userName" id="userName" placeholder="请输入用户登录名称" minlength="2" maxlength="6">
    <p></p>
    <label for="pwd">密码: </label>													<!--readonly只读，size为输入框长度 -->
    <input type="password" id="pwd" placeholder="请输入密码" readonly size="100">
</form>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表单</title>
</head>
<body>
<form name="frmLogin"
      id="frmLogin"
      action="./work/home9_6/userinfo.html"
      method="get">

    <p></p>
    性别
    <label for="male"></label>
    <input id="male" type="radio" value="1" name="sex">男		<!-- name相同按钮之间才会互斥 -->

    <label for="female"></label>
    <input id="female" type="radio" value="0" name="sex">女

    <p></p>
    爱好
    <label for="eat"></label>
    <input id="eat" type="checkbox" name="hobby">吃饭
    <label for="sleep"></label>
    <input id="sleep" type="checkbox" name="hobby">睡觉
    <label for="game"></label>
    <input id="game" type="checkbox" name="hobby">游戏
  <!--checkbox值：复选框，和上面相同， name值相同，并且有 value值，那么浏览器才能收集全你选择的信息
      有 value 值，但是 name 各不相同，复选多个时，浏览器只会搜集你所选的第一个信息-->

    <p></p>
    <button>提交</button>
</form>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表单</title>
</head>
<body>
<form name="frmLogin"
      id="frmLogin"
      action="./work/home9_6/userinfo.html"
      method="get"
      enctype="multipart/form-data">        <!-- 要上传文件必须要选择的属性 -->

    <p></p>
    头像
    <input type="file" name="usericon">		<!-- 选择文件 -->

    <p></p>
    <button>提交</button>
</form>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表单</title>
</head>
<body>
  <form name="frmLogin"
      id="frmLogin"
      action="./work/home9_6/userinfo.html"
      method="get">
    
    <input type="button" value="按钮">按钮
    <input type="reset" value="重置">重置
    <input type="submit" value="提交">提交
  </form>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表单</title>
</head>
<body>
  <form name="frmLogin"
      id="frmLogin"
      action="./work/home9_6/userinfo.html"
      method="get">
    
    <p></p>
    班级
    <label>
        <select name="clazz" multiple>				<!-- multiple为是否可以选多个 -->
            <option value="2101">2101</option>
            <option value="2102">2102</option>
            <option value="2103">2103</option>
            <option value="2104">2104</option>
            <option value="2105">2105</option>
            <option value="2106">2106</option>
            <option value="2107">2107</option>
        </select>
    </label>
  </form>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表单</title>
</head>
<body>
  <form name="frmLogin"
      id="frmLogin"
      action="./work/home9_6/userinfo.html"
      method="get">
<!--        fieldset 标签：可对控件进行一个分组-->
<!--        legend 标签 可以在 fieldset 的框子名字， 其他的设置在表单控件设置在框子内-->
    <fieldset>
        <legend>联系方式</legend>
        <label>
            <input type="email" name="email">邮箱
        </label>
        <p></p>
        <label>
            <input type="tel" name="tel">电话
        </label>
    </fieldset>
  </form>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表单</title>
</head>
<body>
<form name="frmLogin"
      id="frmLogin"
      action="./work/home9_6/userinfo.html"
      method="get">
  
	<!-- label作用：点击 用户名，那么输入框会获得焦点，“用户名” 和输入框做了一个绑定 -->
  <!-- for绑定的为 id属性 -->
    <label for="userName">用户名</label>	
    <input type="text" name="userName" id="userName" placeholder="请输入用户登录名称" minlength="2" maxlength="6">

    <p></p>
    <label for="pwd">密码: </label>
    <input type="password" id="pwd" placeholder="请输入密码" size="100">
    
</form>
</body>
</html>
```
<a name="twOq9"></a>
# CSS
<a name="OwDeS"></a>
### 概念
:::info
CSS由以下组成：

   - 一组属性，属性的值更新了HTML的内容的显示方式。
   - 一个选择器，用于选择元素
      - 比如：想将CSS规则应用到HTML文档中的所有段落<p>上。
:::
<a name="tveRS"></a>
### CSS呈现在html上
:::info
css渲染html规则：

- 当一个html文件被外部样式表、内部样式表、内联样式表同时渲染时，那么渲染程度：内联样式表>内部样式表>外部样式表
:::
<a name="JprK4"></a>
#### 外部样式表 - link引用
```css
h1 {
  color: #ff00cc;
  background-color: cyan;
  font-style: italic;
  border: 1px solid green;
}

p {
  color: red;
}
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>引用01</title>
  <!-- link标签引用css文件，rel="stylesheet"， href为引用哪个css文件 -->
  <link rel="stylesheet" href="../style01.css">		
</head>
<body>
  <h1>第一个h1标题</h1>		<!-- h1和css文件中的h1绑定 -->
  <p>第一个p段落</p>				<!-- p和css文件中的p绑定 -->
</body>
</html>
```
<a name="iEmyT"></a>
#### 内部样式表
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>嵌套标签</title>
    <style>
        h1 {
            color: #ff00cc;
            background-color: cyan;
            font-style: italic;
            border: 1px solid green;
        }
    </style>
</head>
<body>
  <h1>内部样式表</h1>
</body>
</html>
```
<a name="k8Cxh"></a>
#### 内联样式表
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>内联样式表</title>
</head>
<body>
    <h1 style="font-size: 90px; color: red; border: 10px solid blue">内联样式表</h1>
</body>
</html>
```
<a name="iIDNP"></a>
### html展现原则
:::info
DOM是一种树形结构，html会根据DOM模型，将HTML和XML解析成一系列节点，如果有CSS对应的节点，那么就增加它的叶子节点。
:::
<a name="azLdq"></a>
### 盒子模型
<a name="cOerL"></a>
#### 盒子模型概念
:::info
块状元素可以想象成一个正方形的区块， 这个区块在页面展现时，势必存在一些和其他区块之间的间隔问题， W3C 组织定义的把网页的对象放在一个盒子（box）中， 也就是常说的盒子模型（Box Model）。

1. content 内容
2. padding 内边距 , 边框到层的内容之间的空白
3. border 边框
4. margin 外边距 ：边框以外留的空白
:::
![](https://cdn.nlark.com/yuque/0/2023/png/35506053/1695692097561-2a2c8c60-74dd-4b3a-bc2f-93cbe38f3a96.png#averageHue=%23c9c9be&clientId=u3b39464c-6b43-4&from=paste&id=u3af38ae8&originHeight=283&originWidth=441&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=uaea3beb6-239d-40c3-8675-d98515284ef&title=)
<a name="atV5A"></a>
#### margin作用及如何定义
:::info

- margin 是边框以外留的空白 ，用于定义块级元素之间的距离
- margin 是透明不可见
- margin 的定义包含4个方向 。<br />![](https://cdn.nlark.com/yuque/0/2023/png/35506053/1695692194339-711ca256-2e08-4859-aecd-0745e9e46bf5.png#averageHue=%23fbfbfa&clientId=u3b39464c-6b43-4&from=paste&id=u53e34505&originHeight=200&originWidth=200&originalType=url&ratio=1.25&rotation=0&showTitle=false&status=done&style=none&taskId=u360d1826-a8bc-4bff-ab46-7bbe0d4e9e7&title=)
:::
<a name="NnQkx"></a>
### 选择器
<a name="qPoqJ"></a>
#### 标记选择器
:::info
标记选择器为对标签进行修饰
:::
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>标记选择器</title>
    <link href="../style04.css" rel="stylesheet">
</head>
<body>
    <p>p标签</p>				<!--修饰p标签与div标签-->
    <div>div标签</div>
</body>
</html>
```
```css
p {
  color: red;
}
div {
  background-color: green;
  width: 400px;
  height: 300px;
}
```
<a name="BoyCa"></a>
#### 类选择器
:::info
使用标签内的class属性对标签进行修饰，同一个类选择器可以对多个标签进行修饰
:::
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>类选择器</title>
  <link href="../style05.css" rel="stylesheet">
</head>
<body>
  <!--类选择器要用到class属性-->
  <p class="first">类选择器修饰p标签</p>		
  <!--同一个类选择器可以修饰多个标签-->
  <div class="first">同一个类选择器可以修饰多个标签</div>
</body>
</html>
```
```css
.first {
  font-size: 60px;
  border: #ff00cc 10px solid;
  font-weight: bold;
}
```
<a name="NjpWo"></a>
#### id选择器
:::info
使用标签内的id属性对标签进行修饰，一个id只能对应一个id选择器
:::
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>id选择器</title>
  <link href="../style06.css" rel="stylesheet">
</head>
<body>
  <p id="first_p">id选择器修饰p标签</p>
  <div id="second_p">一个id选择器只能修饰一个标签</div>
</body>
</html>
```
```css
#first_p {
    color: red;
    font-size: 90px;
}
#second_p {
    background-color: #ff00cc;
    font-size: 60px;
    border-bottom: cyan solid;
  	font-family: 宋体, serif;
}
```
<a name="qMghf"></a>
#### 通配符选择器
:::info
为所有标签加上同一个样式	
:::
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>通配符选择器</title>
    <link href="../style07.css" rel="stylesheet">
</head>
<body>
    <p>id选择器修饰p标签</p>
    <div>一个id选择器只能修饰一个标签</div>
</body>
</html>
```
```css
/* 通配符选择器用*来使用 */
* {
  color: red;
  font-size: 90px;
}

```
<a name="SkpOH"></a>
#### 组合选择器
<a name="c0oZv"></a>
##### 后代选择器
:::info
后代选择器又叫包含选择器，可以选择父元素里的子元素。  	
:::
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        /* 有class属性为two 的 div中的所有超链接字体都为红色 */
        .two span a {
            color: red;
        }
    </style>
</head>
<body>
<!-- 后代选择器就是选择某个盒子里面所有的某一类标签 -->
<div>
    <a href="#">div的儿子</a>
    <p>
        <a href="#">p的儿子</a>
    </p>
    <span>
            <a href="#">span的儿子</a>
        </span>
</div>
<p>
    <a href="#">这个会变吗？</a>
</p>

<div class="two">
        <div>			<!-- 多了一层div，但是span a 还是 .two 的后代，所以还是可以用到-->
            <span>
                <a href="#">第二个div中span里面的a</a>
            </span>
        </div>
</div>
</body>
</html>
```
<a name="oQQLO"></a>
##### 子选择器
:::info
通俗的来说，直接选择父元素最近的下一级的元素，也就是父亲选亲儿子。<br />样式： 父元素 > 子元素 {样式}
:::
```html
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        /* > 左右可以加空格也可以不加 */
        /* 子代选择器只会选择它儿子那一层级 */
        p > .span1 {
            background-color: #ccc;
        }

        /* 有些情况 后代和子代选择器可以相互使用，经验所得 后代用的比较多 */
        div .span1 {
            color: red;
        }
    </style>
</head>
<body>
    <div>
        <p>
            <span class="span1">1</span>        <!--定义的两个样式都用到了-->
        </p>
              <span class="span1">              <!--这里只会用到第二个样式-->
                哈哈哈
              </span>
    </div>
</body>
</html>
```
<a name="i13V7"></a>
##### 并集选择器
:::info
并集选择器可以选择多组标签，同时定义相同的样式。
:::
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        div, p {
            width: 200px;
            height: 200px;
            background-color: pink;
        }
    </style>
</head>
<body>
    <!-- 并集选择器：选择多组标签设置相同的样式。 -->
    <div>div</div>			<!-- 既作用在div标签上，也作用在p标签上 -->
    <p class="color">ppp</p>
</body>
</html>
```
<a name="IotZq"></a>
##### 同级选择器
:::info
用〜表示。 顾名思义，通用的同级选择器对于选择指定元素的同级元素很有用。 这也可以用于选择共享相同父元素的元素。
:::
```html
<!DOCTYPE html>

<html lang="en">

<head>
    <style>
      /* div与p平级 */
        div ~ p {			
            font-weight: bold;
            background-color: #f40;
            color: #fff;
            font-size: 32px;
        }
    </style>
    <title>123</title>
</head>
<body>
    <p>A</p>			<!-- 这里的p标签在div标签前使用，所以不起效果-->
    <div>
        <p>B</p>
        <div>123</div>
    </div>				<!-- 在div标签使用之后的p标签才会起到效果 -->
    <p>C</p>			<!-- 这里的p标签与div平级-->
    <p>D</p>
</body>
</html>
```
<a name="ZItWp"></a>
##### 相邻的兄弟选择器
:::info
用+表示。 顾名思义，相邻兄弟选择器用于选择与指定元素相邻的元素。 该组合器仅选择一个位于指定标签旁边的元素。
:::
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <title></title>
    <style>
        div + p {
            font-weight: bold;
            background-color: #f40;
            color: #fff;
            font-size: 32px;
        }
    </style>
</head>

<body>
    <p>A</p>
    <div>
        <p>B</p>
    </div>
    <p>C</p>		<!-- div旁边的p标签 -->
    <div>D</div>	<!-- p旁边的div标签无用 -->
    <p>E</p>	
</body>
</html>
```
<a name="vwk3M"></a>
##### 伪类选择器
:::info
分为两种：

   - 链式伪类选择器：主要给超链接添加各种特殊效果
   - 输入框伪类选择器：也叫focus伪类选择器，用于在输入框获取焦点时使用
:::
```html
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>08_a元素的伪类</title>
    <style>
        /*
            :link 用来表示没访问过的链接（正常的链接）
        */
        a:link{
            color: green;
        }


        /*
            :visited 用来表示访问过的链接
            由于隐私的原因，所以visited这个伪类只能修改链接的颜色
        */
        a:visited{
            color: #69ffe8;
            /* font-size: 50px; */
        }


        /*
            :hover 用来表示鼠标移入的状态
        */
        a:hover{
            color: #ff0073;
            font-size: 50px;
        }

        /*
            :active 用来表示鼠标点击
        */
        a:active{
            color: #ffd650;
        }

    </style>
</head>
<body>
    <!--
        1.访问过的链接
        2.没访问过的链接
     -->
    <a href="https://www.baidu.com">访问过的链接</a>
    <br><br>
    <a href="https://www.baidu.com">没访问过的链接</a>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        input{
            width: 335px;
            height: 30px;
            background: no-repeat 300px center;
        }
        input:focus{
            width: 335px;
            height: 30px;
            background: red 600px center;
        }
    </style>
</head>
<body>
    <label>
        <input type="text">
    </label>
</body>
</html>
```
<a name="X1OXY"></a>
### 内容溢出
:::info
当内容超出context容器的大小时，内容默认溢出可见。
:::
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>内容溢出</title>
    <style>
        .class1 {
            width: 300px;
            height: 200px;
            border: 5px solid;
            background-color: yellow;
            overflow: auto;          /*
                                            使用overflow设置过多内容的展现处理，默认情况下取visible的值，即：溢出可见
                                            隐藏超出的内容可以用 hidden
                                            增加滚动条: auto
                                        */
        }
    </style>
</head>
<body>
    <div class="class1">
        中国的崛起：
        中国的崛起不仅是理想之光和信念之光的体现，也是对世界产生了深远的影响。中国已经成为世界上第二大经济体，其国际地位不断上升。中国的“一带一路”倡议、全球气候变化合作以及对国际组织的积极参与，都表明中国正逐渐承担起更多的全球责任。
        中国的崛起也在国际政治和安全领域产生了影响。中国积极参与国际和平维护事务，推动解决一些全球性问题，如气候变化和朝鲜半岛问题。中国的坚定信念和理想之光为国际社会提供了合作伙伴，共同应对全球挑战。
        信念之光：
        信念是中国人民坚守原则和价值观的动力。中国的信念源自深厚的文化传统，它代表着对正义、诚实和善良的坚定信仰。在现代中国，信念是人民坚守法治、维护社会公平正义的力量源泉。
        信念之光的不灭来自中国人民的坚强和坚守。中国社会发展中，尽管面临各种挑战，中国人民一直坚定地捍卫着自己的信念，维护社会的稳定和公平。中国的反腐斗争就是信念之光的生动体现，它为社会提供了清朗的政治生态，树立了公平正义的法治观。
    </div>
</body>
</html>
```
<a name="DiPbP"></a>
### 图片背景
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>背景图片处理</title>
    <style>
      .div1 {
        width: 300px;
        height: 200px;
        border: 20px dashed blue;
        margin: 30px;
        padding: 40px;
        background-color: red;
        background-image: url("../../picture/preview.jpg");   /* 背景图片 url属性的值为图片地址 */
        background-clip: border-box;  /* background-clip为背景裁切到哪个位置 */
      }
    </style>
</head>
<body>
    <div class="div1">

    </div>
</body>
</html>
```
<a name="sEeR0"></a>
### 行内元素、块级元素、行内块级元素
:::info

- 块级元素：一个元素独占一行
- 行内元素：与其他行内元素一起占满一行后换行，行内元素不能设置宽和高
- 行内块元素：即具有块级元素的属性也具有行内元素的属性，即是行内元素，又能设置宽高。
:::
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>行内、块级、行内块元素转换</title>
    <style>
      .p1 {
        background-color: yellow;
        border: 2px solid blue;
        display: inline;    /* 将元素设置为行内元素 */
                            /* display: inline-block 将元素设置为 行内块元素 */
        /* display: none 效果：隐藏p1类的内容和效果 */
      }
      .p2 {
        background-color: green;
        border: 2px solid red;
        display: inline;
      }
      .p3 {
        background-color: aqua;
        border: 2px solid yellow;
      }
      .a1 {
        display: block;   /* 将a1类设置为块级元素 */
      }
    </style>
</head>
<body>
    <!--p标签原本为块级元素-->
    <p class="p1">
      12
    </p>
    <p class="p2">
      34
    </p>
    <p class="p3">
      AB
    </p>
    <!--a标签原本为行内元素-->
    <a href="#" class="a1">主页</a>
    <a href="#">计算机学院</a>
    <a href="#">经管学院</a>
</body>
</html>
```
<a name="CW7cO"></a>
### 字体样式
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>字体</title>
    <style>
      .p1 {
        color: #ff00cc;
        font-family: 微軟正黑體, serif;
        font-size: 40px;
        font-style: italic; /* 斜体 */
        font-weight: bold;  /* 加粗 */
        text-transform: capitalize; /* 首字母大写 */
        text-decoration-line: overline; /* 字体修饰线 overline, underline, line-through */
        text-shadow: 5px 5px 5px yellow;  /* 文字阴影 */
      }
    </style>
</head>
<body>
    <p class="p1">hello world</p>
</body>
</html>
```
<a name="IzN35"></a>
### 链接样式
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>链接样式化</title>
    <style>
      a {
        outline: none;
        text-decoration: none;
        padding: 2px 1px 0;
      }
      a:link {
        color: #ff00cc;   /*链接颜色*/
      }
      a:visited {
        color: yellow;    /*点击完的颜色*/
      }
      a:focus {
        color: red;
        background-color: aqua;
      }
      a:hover {         /*鼠标移过去的颜色*/
        color: burlywood;
        background-color: green;
      }
      a:active {       /* 鼠标点击时的效果 */
        background: coral;
        color: aquamarine;
      }
    </style>
</head>
<body>
    <a href="http://">主页</a>
    <a href="http://">计算机</a>
    <a href="http://">土木</a>
    <a href="http://">经管</a>
</body>
</html>
```
<a name="CAo7m"></a>
### 盒子样式
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>盒子样式化</title>
    <style>
        .div1 {
            width: 400px;
            height: 300px;
            padding: 20pc;
            background-color: yellow;
            background-image: url("../../picture/preview.jpg");
            background-repeat: repeat-y;       /*在原有图像大小的情况下是否在x轴或y轴上延伸满整个x轴或y轴*/
            background-position: center;
            border: blue solid;
            border-radius: 2000px 200px 2000px 2000px;  /*边框四周角的旋转角度*/
        }
    </style>
</head>
<body>
    <div class="div1"></div>
</body>
</html>
```
<a name="mh2kX"></a>
### 表格样式
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>表格样式化</title>
    <style>
      table {
        /*表格布局样式*/
        table-layout: fixed;
        width: 100%;
        /*属性设置表格的边框是否被合并为一个单一的边框，还是像在标准的 HTML 中那样分开显示。*/
        /*也就是说是否合并单元格*/
        border-collapse: collapse;
        border: 3px solid #0066ff;
        background-color: #ff00cc;
        font-size: 30px;
      }
      table th:nth-child(1) {   /*设置每一列的宽度*/
        width: 30%;
      }
      table th:nth-child(2) {
        width: 20%;
      }
      table th:nth-child(3) {
        width: 15%;
      }
      table th:nth-child(4) {
        width: 35%;
      }
      th {
        padding: 20px;
      }
      td {
        padding: 20px;
        text-align: center;
      }
      tbody tr:nth-child(odd) {   /*奇数列*/
        background-color: #ffffff;
      }
      tr:nth-child(even) {        /*偶数列*/
        background-color: #f0f0f0;
      }
      thead, tfoot {
        background-color: #bfc2c3;
      }
      .div1 {
        width: 80%;
        margin: auto;
      }
    </style>
</head>
<body>
  <div class="div1">
    <table>
      <thead>
        <tr>
          <th>班级</th>
          <th>男生</th>
          <th>女生</th>
          <th>合计</th>
        </tr>
      </thead>
      <tbody>
      <tr>
        <td>2107</td>
        <td>20</td>
        <td>10</td>
        <td>30</td>
      </tr>
      <tr>
        <td>2108</td>
        <td>10</td>
        <td>20</td>
        <td>30</td>
      </tr>
      <tr>
        <td>2109</td>
        <td>25</td>
        <td>5</td>
        <td>30</td>
      </tr>
      </tbody>
      <tfoot>
        <tr>
          <th>合计</th>
          <th>45</th>
          <th>45</th>
          <th>90</th>
        </tr>
      </tfoot>
    </table>
  </div>
</body>
</html>
```
<a name="VWXd9"></a>
### 页面布局		
<a name="t7BEV"></a>
#### 流动模型
:::info
流动模型：默认的网页布局模式。网页在默认状态下的HTML网页元素都是根据流动模型分布网页内容的，典型的特征：

1. 块状元素都会在所处的包括元素内自上而下按顺序垂直延伸分布
2. 在流动模型下，行内元素都会在所处的包括元素内从左到右水平分布显示。行内元素不像块状元素一样独占一行。
:::
<a name="RpLcC"></a>
#### 浮动模型
:::info
float属性：是为了能让web开发人员实现简单的布局，包括在一列文本中浮动的图像，文字环绕在左边或右边等。<br />浮动用来实现整个网站页面的布局，是信息列得以横向排列。（流式布局：顺序纵向排列）
:::
```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>页面布局</title>
    <style>
      div {
        width: 500px;
        height: 500px;
        background-color: yellow;
        float: right;    /*使用float属性，使得div标签向右浮动*/
      }
      .div1 {
        width: 200px;
        height: 200px;
        margin: auto;
        background-color: #ff00cc;
      }
      .div2 {
        width: 200px;
        height: 200px;
        background-color: #0066ff;
      }
    </style>
  </head>
  <body>
    <div>
      <div class="div1"></div>
      <div class="div2"></div>
    </div>
  </body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>两栏布局</title>
    <style>
        .div1 {
            float: left;
            width: 48%;
            border: 1px solid blue;
        }
        .div2 {
            float: right;
            width: 48%;
            border: 1px solid blue;
            height: 131px;
        }
    </style>
</head>
<body>
    <div class="div1">
        <p>
            虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。
        </p>
        <p>
            相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，
        </p>
    </div>
    <div class="div2">
        <p>这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
        <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
    </div>

</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>三栏布局</title>
  <style>
    .div1 {
      float: left;
      width: 30%;
      padding: 10px;
      box-sizing: border-box;
    }
    .div2 {
      float: left;
      width: 40%;
    }
    .div3 {
      float: right;
      padding: 10px;
      width: 30%;
      box-sizing: border-box; 
      /* 当一个盒子的总宽度确定之后，要想给盒子添加边框或内边距，往往需要更改 width属性值，才能保证盒子总宽度不变，操作起来烦琐且容易出错，运用CSS3的box-sizing属性可以轻松解决这个问题。
      box-sizing属性用于定义盒子的宽度值和高度值是否包含元素的内边距和边框 */
    }
  </style>
</head>
<body>
  <div class="div1">
    <p>
      虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。
    </p>
    <p>
      相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，
    </p>
  </div>
  <div class="div2">
    <p>这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
  </div>
  <div class="div3">
    <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
  </div>

</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>清除浮动</title>
  <style>
    .div1 {
      float: left;
      width: 30%;
      padding: 10px;
      box-sizing: border-box;
    }
    .div2 {
      float: left;
      width: 40%;
    }
    .div3 {
      float: right;
      padding: 10px;
      width: 30%;
      box-sizing: border-box;
    }
    .clearfix {
      clear: both;  /*清除左浮动和右浮动*/
    }
  </style>
</head>
<body>
  <div class="div1">
    <p>
      虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。
    </p>
    <p>
      相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，
    </p>
  </div>
  <div class="div2">
    <p>这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
  </div>
  <div class="div3">
    <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
  </div>
  <div class="clearfix">@版权所有：123456</div>
</body>
</html>
```
<a name="BQrR4"></a>
#### 层模型
```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>相对定位</title>
  <style>
    body {
      width: 60%;
      margin: 0 auto; /* 0上下 auto左右自动 */
    }
    p {
      border: 1px solid black;
      background-color: aquamarine;
    }
    .position {
      /*浏览器默认为static*/
      position: relative; /*相对前一个元素的位置*/
      top: 25px;			/*上侧相对前一个元素的距离*/
      left: 40px;			/*左侧相对前一个元素的距离*/
      background-color: yellow;
    }
  </style>
</head>
<body>
<div>
  <p>
    虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。
  </p>
  <p>
    相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，
  </p>
</div>
<div>
  <p class="position">这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
</div>
<div>
  <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
</div>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>绝对定位</title>
  <style>
    body {
      width: 60%;
      margin: 0 auto; /* 0上下 auto左右自动 */
    }
    .div1 {
      width: 100px;
      height: 100px;
      background-color: #bfc2c3;
    }
    p {
      border: 1px solid black;
      background-color: aquamarine;
    }
    .position {
      position: absolute; /*绝对定位：独立于其他元素，单独布局*/
      top: 25px;          /*上侧对应于父元素的距离*/
      left: 40px;         /*左侧相对于父元素的距离*/
      background-color: yellow;
      z-index: 3;			/* z轴距离 */
    }
  </style>
</head>
<body>
  <div>
    <p>
      虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。
    </p>
    <p>
      相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，
    </p>
  </div>
  <div class="div1">
    <!--此处<p>标签的父元素为<body>,不是<div>-->
    <p class="position">这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
  </div>
  <div>
    <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
  </div>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>固定定位</title>
    <style>
      body {
        width: 60%;
        margin: 0 auto; /*距离上侧、下侧0px 左右自动*/
      }
      .fixed {
        position: fixed;  /*固定不动, 不随着内容动*/
        top: 0;
        margin: 0;
        width: 600px;
        height: 60px;
        border: 1px solid red;
        background-color: #ffc400;
      }
    </style>
</head>
<body>
    <h1 class="fixed">固定定位</h1>
    <p>虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。</p>
    <p>相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，</p>
    <p>这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
    <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
    <p>虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。</p>
    <p>相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，</p>
    <p>这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
    <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
    <p>虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。</p>
    <p>相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，</p>
    <p>这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
    <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
    <p>虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。</p>
    <p>相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，</p>
    <p>这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
    <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
    <p>虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。</p>
    <p>相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，</p>
    <p>这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
    <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
    <p>虚拟线程是一种轻量化的线程封装，由jvm直接调度和管理。反之普通的线程其实是调用的操作系统的能力，对应的是操作系统级的线程。</p>
    <p>相对虚拟线程来说操作系统级的线程持有成本很高，而且受操作系统调度和管理的。实际在普通多线程情况下，如果出现IO阻塞，</p>
    <p>这个线程就必须得跟着阻塞，这个线程对应的操作系统就被阻塞，而他却持有大量的内存。</p>
    <p>另外，要处理大量的IO就得新建更多线程，而大量的线程会在操作系统切换时因上下文切换导致大量的CPU被浪费。</p>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>粘性定位</title>
    <style>
        dt {
            position: sticky;   /*粘性定位*/
            top: 5px;  /*当下一个dt距离当前这个dt 5个像素时，当前这个dt消失*/
            background-color: cyan;
            border: 1px solid red;
        }
    </style>
</head>
<body>
    <dl>
        <dt>A</dt>
        <dd>a1</dd>
        <dd>a2</dd>
        <dd>a3</dd>
        <dd>a4</dd>
        <dd>a5</dd>
        <dd>a6</dd>
        <dd>a7</dd>
        <dd>a8</dd>
        <dd>a9</dd>
        <dd>a10</dd>
        <dd>a11</dd>
        <dd>a12</dd>
        <dd>a13</dd>
        <dd>a14</dd>
        <dd>a15</dd>
        <dd>a16</dd>
        <dd>a17</dd>
        <dd>a18</dd>
        <dd>a19</dd>
    </dl>
    <dl>
        <dt>B</dt>
        <dd>b1</dd>
        <dd>b2</dd>
        <dd>b3</dd>
        <dd>b4</dd>
        <dd>b5</dd>
        <dd>b6</dd>
        <dd>b7</dd>
        <dd>b8</dd>
        <dd>b9</dd>
        <dd>b10</dd>
        <dd>b11</dd>
        <dd>b12</dd>
        <dd>b13</dd>
        <dd>b14</dd>
        <dd>b15</dd>
        <dd>b16</dd>
        <dd>b17</dd>
        <dd>b18</dd>
        <dd>b19</dd>
    </dl>
    <dl>
        <dt>C</dt>
        <dd>c1</dd>
        <dd>c2</dd>
        <dd>c3</dd>
        <dd>c4</dd>
        <dd>c5</dd>
        <dd>c6</dd>
        <dd>c7</dd>
        <dd>c8</dd>
        <dd>c9</dd>
        <dd>c10</dd>
        <dd>c11</dd>
        <dd>c12</dd>
        <dd>c13</dd>
        <dd>c14</dd>
        <dd>c15</dd>
        <dd>c16</dd>
        <dd>c17</dd>
        <dd>c18</dd>
        <dd>c19</dd>
    </dl>
</body>
</html>
```
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>三帧布局</title>
    <style>
      html, body {
        margin: 0;		/*所有内容 外边距，内边距 清零*/
        padding: 0;
        height: 100%;
      }
      .container {
        text-align: center;
        width: 1024px;
        height: 100%;
        background-color: #ffea00;
        margin: 0 auto;
      }
      .left {
        background-color: #00ffd9;
        width: 20%;
        height: 100%;
        float: left;
      }
      .header {
        background-color: #bfc2c3;
        width: calc(1024px - 20%);
        height: 10%;
        float: right;
      }
      .context {
        background-color: green;
        width: 80%;
        height: 80%;
        float: left;
      }
      .footer {
        background-color: #ff0073;
        width: 80%;
        height: 10%;
        float: left;
      }
    </style>
</head>
<body>
    <div class="container">
      <div class="left">导航栏</div>
      <div class="header">头部</div>
      <div class="context">内容</div>
      <div class="footer">脚标</div>
    </div>
</body>
</html>
```
