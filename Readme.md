## 学习笔记

## 资料

[Spring 文档](https://spring.io/guides)

[Spring Web](https://spring.io/guides/gs/serving-web-content/)
  
[Bootstrap](https://v3.bootcss.com/gettign-started)

[es](https://elasticsearch.cn/explore)

[Git](https://git-scm.com/download)

[okhttp](https://square.github.io/okhttp/)

[maven repository](https://mvnrepository.com/tags/maven)

## 工具

- [Visual Paradigm](https://www.visual-paradigm.com/cn/)

- git commit --amend --no-edit

- IDEA 小技巧：按住 Option 键，鼠标下拉，可以在多行同时编辑。

- github oAuth apps 

  - Client ID  
    b8602067c021014a9669

  - Client Secret  
    585107226029a5d66d5dec92524a547277cf5e27
    
## 快捷键

- command + shift + F12 -> Project Structure 隐藏/显示

- command + n -> 类添加 get 和 set 方法

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

