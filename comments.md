### 完成度：
* 没有完查询分组列表的功能
* 讲师数量为0或1时，没有返回Error对象和400

__Details:__

- \- 没有未分组学员时应返回空列表

### 测试：
* 没有包含任何测试

__Details:__



### 知识点：
* 掌握了Spring MVC的知识点
* 掌握了Restful API Design的知识点
* 能够使用Lombok减少代码量
* IOC相关的注解掌握的不错
* 异常处理的知识点没有完全掌握

__Details:__
+ \+ 使用了stream过滤未分组学员
- \- ResponseStatusException为框架内置异常，不需要使用自定义的ExceptionHandler来处理
- \- @Validated注解使用不合理，可以省略
- \- POST创建资源后，应返回新建的资源

### 工程实践：
* 发生异常时，Spring MVC的返回值与需求不符

__Details:__

- \- 先import，再引用，避免直接使用类的全名
- \- ErrorResult类应放在sub package内
- \- Spring MVC异常处理类的包路径前缀应和Controller保持一致
- \- 变量名应使用驼峰命名，并且首字母小写
- \- 变量名应使用驼峰命名，首字母小写

### 综合：


__Details:__



