一个简单的房屋租赁管理系统
======
前台使用angular2框架，后台使用Java的spring+springMvc+mybatis，即SSM框架

本系统严格来说有两个系统，一个前台房屋检索浏览系统，一个后台审核房屋上架的系统
后台审核房屋上架系统的入口，目前安置在首页最下面的“房屋管理”链接里

此外还有一个主要点，本系统当用户上架出租房屋时，因为需要上传房屋图片，房屋图片是存放在本地磁盘的。
所以需要改变UserController中copyPicture()方法中的本地路径，同时在Tomcat服务器的server.xml中以下标签：
```html
<Context docBase="你的本地磁盘路径" path="/house/assets/copy"/>
```

本项目属于为了熟悉SSM框架才创建的，可能有很多不足，请多指正，谢谢！
今后继续努力！！！
