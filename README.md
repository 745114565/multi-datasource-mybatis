# multi-datasource-mybaties

#### 项目介绍
spring boot 2.0.2   mybatis    多数据源demo 

#### 软件架构
软件架构说明


#### 安装教程

1. ```  git clone https://gitee.com/xzbd/multi-datasource-mybatis.git ```
2. 使用Idea 或 eclipce 导入项目
3. 执行sql脚本（项目resource\doc下所有Sql脚本）

#### 使用说明

1. 本项目只是一个demo，只做技术练习

#### 开发过程中遇到的问题
1.spring boot 从配置文件获取配置数据到自定意 bean 。在网上等资源可以获知，spring boot 在2.X版本中多配置文件做了较多改动。

    1.1 使用了` @ConfigurationProperties(prefix = "spring.datasource")` 与 `@Component` 注解,spring boot 读取不到配置的
    属性，例如项目中的 DataSource12.java 。
     
   **解决方案** 

    在pom中添加如下依赖即可。
```xml
        
		<dependency>
			    <groupId>org.springframework.boot</groupId>
			    <artifactId>spring-boot-configuration-processor</artifactId>
			    <optional>true</optional>
		</dependency>

```

    1.2 经以上配置后，自定义的bean可以读取到配置文件里的属性了，但是并不是已经没有问题了。在本项目中，在写完数据库配置后，
    
   ```java
    @Configuration
    public  class ConfigDataSource {
        @Bean("dataSourceUser")
        @Primary
        @ConfigurationProperties(prefix = "spring.datasource.data1") // application.yml中对应属性的前缀
        public DataSource dataSourceUser() {
            return DataSourceBuilder.create().build();
        }
        @Bean("dataSourceOrder")
        @ConfigurationProperties(prefix = "spring.datasource.data2") // application.yml中对应属性的前缀
        public DataSource dataSourceOrder() {
            return DataSourceBuilder.create().build();
        }
    }

```
     初始化的数据源中，jdbcUrl 等基本属性丢失，代码报错。如下：

```text
数据源异常：
    ### Error querying database.  Cause: java.lang.IllegalArgumentException: dataSource or dataSourceClassName or jdbcUrl is required.
    ### The error may exist in com/example/demo/user/mapper/UserMapper.xml
    ### The error may involve com.example.demo.user.mapper.UserMapper.getUser
    ### The error occurred while executing a query
    
原因是：配置文件在配置数据源不疯没有加载，debug中可以看到，jdbcUrl,username,pwd,driver都没有注入

```
```text
    mybatis异常：Invalid bound statement (not found) 
   原因： XXXMapper.xml没有编译在指定的目录下
```
    
以上问题都可以在pom.xml中的build中配置用如下配置解决：
```xml
<!-- 如果不添加此节点mybatis的mapper.xml文件都会被漏掉。 -->  
        <resources>  
            <resource>  
                <directory>src/main/java</directory>  
                <includes>  
                    
                    <!--解决配置文件问题-->
                    <include>**/*.properties</include>  
                    <include>**/*.yml</include>  
                    
                    <!--解决xml没有编译的问题-->
                    <include>**/*.xml</include>  
                </includes>  
                <filtering>false</filtering>  
            </resource>  
            <resource>  
                <directory>src/main/resources</directory>  
                <includes>  
                    <include>**/*.properties</include>  
                    <include>**/*.yml</include>  
                    <include>**/*.xml</include>  
                </includes>  
                <filtering>false</filtering>  
            </resource>  
        </resources> 
```
  
3.提交代码到码云（gitee.com）时遇到的问题

```text
    fatal: authentication failed for "your-repository@gitee.com"
```
**[解决方案](https://www.jianshu.com/p/8a7f257e07b8)**
```text
    git config --system --unset credential.helper
```
