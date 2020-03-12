## 码匠社区

## 资料
[Spring 文档](https://spring.io/guides)
[参 考](https://elasticsearch.cn/)
[Github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

## 工具

[H2数据库]
在创建H2数据库的时候就要设置用户和密码，否则会报错"Wrong user name or password"。
很多同学创建数据库的时候没有设置User和Password。

    解决办法一：
        删库，再重新创建数据库，创建的时候要设置User和Password。
        注意如何删库，仅仅"Remove"是没用的，要手动删数据库文件 community.mv.db 和 community.trace.db，
        C:\Users\adminstrator 这个目录下。因为数据库URL:\~\community 里的“~”代表用户根目录。

    解决办法二： 执行命令
        create user if not exists sa password '123';
        alter user sa admin true;

[Flyway](https://flywaydb.org/getstarted/firststeps/maven)
[Lombok](https://projectlombok.org/)
[myBatis generator](http://mybatis.org/generator/index.html)

## 脚本
```sql
CREATE TABLE USER
(
    ID INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL,
    ACCOUNT_ID VARCHAR(100)
)
```

```bash
mvn flyway:migrate
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```