## 学习笔记

## 资料

[Spring 文档](https://spring.io/guides)

[Spring boot](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle)

[Spring Web](https://spring.io/guides/gs/serving-web-content/)

[thymeleaf](https://www.thymeleaf.org/)  

[Bootstrap](https://v3.bootcss.com/gettign-started)

[es](https://elasticsearch.cn/explore)

[Git](https://git-scm.com/download)

[okhttp](https://square.github.io/okhttp/)

[maven repository](https://mvnrepository.com/tags/maven)

## 工具

- [Visual Paradigm](https://www.visual-paradigm.com/cn/)

- git commit --amend --no-edit

- git commit --amend -m "message"

- IDEA 小技巧：按住 Option 键，鼠标下拉，可以在多行同时编辑。

- github oAuth apps 

  - Client ID  
    b8602067c021014a9669

  - Client Secret  
    585107226029a5d66d5dec92524a547277cf5e27
    
## 快捷键

- command + shift + F12 -> Project Structure 隐藏/显示

- command + n -> 类添加 get 和 set 方法, toString 等各种方法

- command + shift + o -> 查找文件

- shift + F6 -> Class 重命名

- command + p -> 查看方法需要的参数

- alt + return -> 引入包，捕获异常补全

- command + shift + return -> 补全代码

- command + option + l -> 代码格式调整 

- command + option + v -> new Class() 后自动生成变量

- shift + return -> 在下一行新建空行，光标移动到空行行首

- command + option + return -> 在上一行新建空行，光标移动到空行行首

- command + return -> 在当前行下一行新建空行，光标不移动

- command + option + n -> 下一行快速合并到当前行

```
String[] split = string.split("&");
String tokenStr = split[0];
String token = tokenStr.split("=")[1];

多个连续操作合并为一行 ==> 

String token = string.split("&")[0].split("=")[1]; 
```

- command + e -> 切换到最近编辑的窗口


## http 知识点 -> Session Cookie

- Session 相当于银行账户，去银行开户后，银行的系统里面就会保留你的信息，你的所有信息就会在银行的数据库里面或者服务里面。

- Cookie 相当于银行卡，每次取钱的时候，把你的银行卡拿来我才知道你的账户是什么，才能去操作银行账号里面的余额。

我们的服务器就相当于银行，本身 http 是无状态的，如何让服务器记录你的状态呢，每次携带一张银行卡来就好了。

Cookie 是不能跨域的，Application -> Cookies 中的每一条记录（Cookie）都有一个域名（Domain），有一个路径，还有一个过期时间。

Cookie 的 Name 相当于银行卡卡号，Value 相当于卡号对应的唯一标识。渲染网页的时候，每次一个请求从浏览器端发送到服务器端的时候，Network -> XHR 中每一条记录就是前端发送到服务器的请求。

Cookie 和 Session 的过程：为什么登陆成功后，再请求网页为什么知道你已经登陆成功了，因为每次请求前端把 Session 中的 Cookie 带着回传到服务器端。服务器端就会拿到 Cookie，去数据库/缓存/内存中找到
对应的 Session，就是你的银行账户，查到你的信息，再返回渲染到页面。

## h2 数据库用户名密码错误

jump to console -> 执行：

```sql
create user if not exists sa password '123'
alter user sa admin true;
```

## 热部署

[Spring boot](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#using-boot-devtools)

配置 `compiler.automake.allow.when.app.running` -> command + option + shift + ?