# Note
Learning Route

BootsTrap
1. <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
2. 把所有的HTML内容放在class为container-fluid的div下
3. 给图片添加 img-responsive class属性，这样图片的宽度就能完美地适配你的页面的宽度
4. Bootstrap有它自己的 button 按钮风格，添加 btn class 属性实现
   button 元素与包含的文本一样宽。使其成为块级元素，按钮会填满页面整个水平空间，添加 btn-block class 属性实现
   深蓝色btn-primary是你的应用的主要颜色，被用在那些用户主要采取的操作上，添加 btn-primary class 属性实现
   浅蓝色 btn-info 被用在那些用户可能会采取的操作上，添加 btn-info class 属性实现
   红色btn-danger被用来提醒用户该操作具有“破坏性”，添加 btn-danger class 属性实现
5. 三个按钮放入一个 <div class="row"> 中；每一个按钮都需要被 <div class="col-xs-4"> 元素
   *col-md-* → medium； col-xs-* → extra small
6. 
7. Font Awesome 图标库，图片都是矢量图，以 .svg 文件格式保存
   <link rel="stylesheet" href="//cdn.bootcss.com/font-awesome/4.2.0/css/font-awesome.min.css"/>
8. i 元素起初是让元素有斜体(italic)的功能，现在一般指代图标
   Font Awesome 中的 class 属性添加到 i 元素中，把它变成一个图标，比如：<i class="fa fa-info-circle"></i>
   *<div class="row">
        <div class="col-xs-4">
            <button class="btn btn-block btn-primary"><i class="fa fa-thumbs-up"></i>Like</button>
        </div>
        <div class="col-xs-4">
            <button class="btn btn-block btn-info"><i class="fa fa-info-circle"></i>Info</button>
        </div>
        <div class="col-xs-4">
            <button class="btn btn-block btn-danger"><i class="fa fa-trash"></i>Delete</button>
        </div>
    </div>
    <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane"></i> Submit</button>
9. 一个 class 属性叫做 well，它的作用是为设定的列创造出一种视觉上的深度感
10. 属于按钮的 class 属性叫做 btn-default： <button class="btn btn-default target"></button>


jQuery
1. $(document).ready(function() {}); 
2. jQuery方法都是由$开始的，通常称作为 美元符号，或者简称为bling，jQuery库和Animate.css库
3. 元素选择器：$("button")、class选择器：$(".btn")、id选择器：$("#target1")。
   $("button").addClass("animated");
   $(".btn").addClass("shake");
   $("#target1").addClass("btn-primary");
4. addClass()添加class, removeClass()去掉class
   .css()改变CSS样式： $("#target1").css("color", "blue");
   .prop()调整元素的属性： $("button").prop("disabled", true);
   .html()添加HTML标签和文字到元素，通过em[emphasize]标签来重写和强调标题文本：
       $("h3").html("<em>jQuery Playground</em>"); 
       类似方法.text()，改变文本但不能修改标记。把传进来的东西当成文本来显示。
   appendTo()把选中的元素加到其他元素中： $("#target2").appendTo("#right-well");
   clone()拷贝元素： $("#target2").clone().appendTo("#right-well");
   parent()访问指定元素的父元素： $("#left-well").parent().css("background-color", "blue")
   target:nth-child(n)按索引顺序(从1开始)选择目标元素的所有子元素：
       $(".target:nth-child(3)").addClass("animated bounce");
   $(".target:odd").addClass("animated shake");（索引为奇数，ever偶数，索引序号从0开始）
5. 退出效果（class）： fadeOut，hinge


JavaScript
1. 七种数据类型:undefined,null,boolean,string,symbol,number,object
2. .push()   ：将数据追加到数组的末尾：var arr = [1,2,3];arr.push(4);   // arr的值为 [1,2,3,4]
   .pop()    ：抛出一个数组末尾的值：  var oneDown = [1, 4, 6].pop();   //oneDown 的值为 6 ，数组变成了 [1, 4]。
   .shift()  ：移除第一个元素
   .unshift()：数组的头部添加元素
3. 函数外定义的变量具有 全局 作用域
4. 严格相等运算符（===）相对于相等操作符（==），它会同时比较元素的值和数据类型。
5. 输出： return count + " " + (count > 0 ? 'Bet' : 'Hold');
6. 数组通过索引来访问和修改数据
   对象通过属性来访问和修改数据
7. 两种方式访问对象属性：点操作符(.)→知道属性的名称的时候
                       中括号操作符([])→访问的属性的名称包含一个空格则只能使用中括号
8. 格式
   var lookup = {
       "" : "",
       "" : "",
       "" : "",
       "" : "",
       "" : "",
       "" : ""
     };
   样例
   function phoneticLookup(val) {
     var result = "";
     var lookup = {
       "alpha" : "Adams",
       "bravo" : "Boston",
       "charlie" : "Chicago",
       "delta" : "Denver",
       "echo" : "Easy",
       "foxtrot" : "Frank"
     };
     var value = val;
     return lookup[value];
   }

9. JavaScript Object Notation 简称 JSON，它使用JavaScript对象的格式来存储数据。
   允许 数据结构 是 字符串，数字，布尔值，字符串，和 对象 的任意组合。
   数组中有多个 JSON 对象的时候，对象与对象之间要用逗号隔开。
   用[]调用JSON中带空格字符,[]内要用""，即["xxxxx"]
10.// 深拷贝 collection，用于测试
   var collectionCopy = JSON.parse(JSON.stringify(collection));
11. 格式
   var lookup = {
       "" : "",
       "" : "",
       "" : "",
       "" : "",
       "" : "",
       "" : ""
     };
     样例
   function phoneticLookup(val) {
     var result = "";
     var lookup = {
       "alpha" : "Adams",
       "bravo" : "Boston",
       "charlie" : "Chicago",
       "delta" : "Denver",
       "echo" : "Easy",
       "foxtrot" : "Frank"
     };
     var value = val;
     return lookup[value];
   }
12.JavaScript Object Notation 简称 JSON，它使用JavaScript对象的格式来存储数据。
   允许 数据结构 是 字符串，数字，布尔值，字符串，和 对象 的任意组合。
   数组中有多个 JSON 对象的时候，对象与对象之间要用逗号隔开。
   用[]调用JSON中带空格字符,[]内要用""，即["xxxxx"]
13.深拷贝 collection，用于测试
   var collectionCopy = JSON.parse(JSON.stringify(collection));
14.Math.random() 生成一个随机小数  乘以 20   Math.floor() 向下取整
   Math.floor(Math.random() * (myMax - myMin + 1)) + myMin;
