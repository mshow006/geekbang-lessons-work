## 极客时间课程工程

## week-01

```bash
git clone https://github.com/yingming006/geekbang-lessons-work.git
```

```bash
cd geekbang-lessons-work/week-01/user-platform
```

```bash
mvn clean package -U
```

```bash
java -jar user-web/target/user-web-v1-SNAPSHOT-war-exec.jar
```

- 注册页面

```
localhost:8080/register
```

- Apache Derby URL （项目启动时，自动在 `geekbang-lessons-work/week-01/user-platform` 目录下创建 `db/user-platform`）

```
jdbc:derby:db/user-platform;create=true
```

- RegisterController

```
src/main/java/org/geektimes/projects/user/web/controller/RegisterController.java
```

