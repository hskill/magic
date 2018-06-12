[TOC]

**说明：**

1. 本项目参考了以下项目
    * [https://github.com/nuysoft/Mock](https://github.com/nuysoft/Mock)
    * [http://chancejs.com](http://chancejs.com/)
2. 该项目使用了 __lombok__ ，如果需要调试或修改代码，请在 __idea__ 中开启相关插件与功能。

# 使用场景
（1）向数据库生成测试数据
（2）快速搭建后端服务，向前端发送测试数据，快速开发原型系统
（3）增加单元测试的真实性，为测试代码生成测试数据

# 快速认识
## （1）设置数据属性
使用 `Schema.serial` 使用时传入数据名称，以及需要的数据属性。

```java
// code(1)

Schema.serial("user"
    new Id("id"),
    new Name("name"),
    new Age("age")
);
```

### 第一个参数：名称
唯一的名称标识。

### 其它参数：随机数据域
如 `new Id("id")` ，该对象将生成一个唯一的数字标识；除此之外，本示例代码中还使用了 Name 与 Age。

注意，随机数据域的构造方法一般都需要传入一个字符串值，作为数据域的名称，该名称对应生成数据的名称。

## （2）如何生成数据
可以在 Schema 对象上，可以方便地调用数据生成方法（详见__结果生成__部分）。

```java
// code(2)

Schema user = Schema.serial("user",
    new Id("id"),
    new Name("name"),
    new Age("age")
);

// 简单使用：按模板生成内容字符串，并打印到终端命令行。
user.size(10)
    .asText()
    .template("${id} - ${name} - ${age}")
    .toPrint();
```
该示例中，`size` 是指定生成的数量，该值若不设置，默认将生成 __100__个数据；`asText` 是指生成为文本；`template` 是传入文本生成的模板（按freemarker模板语法）；`toPrint` 是指结果打印在控制台屏幕上。

## （3）数据结果
按照 code (2) 的代码执行，将打印为以下文本内容。
```plain
772375471734792192 - 金伴花 - 48
772375471734792193 - 朱七七 - 49
772375471734792194 - 潘乘风 - 21
772375471734792195 - 金不畏 - 39
772375471734792196 - 铁成钢 - 31
772375471734792197 - 小雯 - 43
772375471734792198 - 火凤凰 - 44
772375471738986496 - 凤娟 - 41
772375471738986497 - 孟星魂 - 47
772375471738986498 - 烈火夫人 - 38
```

# Schema
`Schema` 是内容生成的主要入口类，它接受__名称__与__随机数据域__定义对象.

## Schema.serial
`SerialSchema Schema.serial(String mark, Randomable... ables)`

__静态方法__，该方法如 code(1) 与 code(2) 显示，将返回一个 `SerialSchema` 类对象（ `Schema` 的子类 ），该对象将产生一个列表数据（`List<Map<String, Object>`）。

### 参数：mark
名称用于标识。

### 参数：ables
可传入多个随机数据域，用于数据定义。

## Schema.only
`OnlySchema Schema.only(String name, Randomable... ables)` 

__静态方法__，该方法与 `Schema.serial` 类似，主要返回 `OnlySchema` 对象（ `Schema` 的子类），该对象将产生一个数据（`Map<String, Object>`）。

## Schema.get
`Schema Schema.get(String mark)` 
__静态方法__，以指定的名称标识，获取已定义过的 `Schema` 对象。

### 参数：mark
名称标识

## getMark
`String getMark()` 
实例方法，获取该对象名称标识。

## asText
`Text asText()` 
实例方法，获取 `Text` 结果处理类实例。

## asObj
`Obj asObj()` 
实例方法，获取 `Obj` 结果处理类实例。

## asJson
`Json asJson()` 
实例方法，获取 `Json` 结果处理实例。

## asJdbc
`Jdbc asJdbc` 
实例方法，获取 `Jdbc` 结果处理实例。

# 随机数据域使用
## （1）简单介绍
随机数据的生成，主要依靠随机数据域产生数据，在 `Schema.serial` 方法中，需要传入一系列的数据域对象。例如，在 code(1) 中，使用了 `Id` 、 `Name` 、 `Age`  进行实例化。

这些实例对象，将分别生成对应的数据，如 `Id` 将生成一系列唯一的长整数标识，`Name` 将生成随机的中文名字，`Age` 将生成随机的年龄数。

随机数据域在项目代码中就是实现了 `Randomable` 接口的类，通过该类 `next` 实例方法，不断产生随机生成数据。

按照实际需要，本项目定义了一系列的随机数据域，更多介绍，请查看本文档后叙内容： __随机数据域__ 

## （2）单个数据生成与关联
假设创建人员数据，除了人员基础信息外，还定义了一个地址数据，而地址数据由 `province` 、 `city` 组成。在一些Java类中，该实现的可能方式是在类User中定义了Address类，也即通常说的 1-1 关系，代码如下：

```java
// code(3)

Schema.serial("user", 
    new Id("id"),
    new Name("name"),
    
    Schema.only("address",
        new Pronvince("province"),
        new City("city")
    )
)
```

以上代码运行结果，将产生关联数据。
该代码其实表示一个内在含义，就是 `Schema` 对象也实现了 `Randomable` 

## （3）列表数据生成与关联
按 code(1) 或 code(2) ，对每个属性可以生成单一值，但往往属性也需要生成列表数据。
例如，简单的__老师－学生__关系，一个老师数据中，包含多个学生数据，在面向对象中，通常通过列表属性实现，在数据库中由外键实现，也即通常说的 1-N 的关系。

```java
// code(4)

Schema.serial("teacher",
    new Id("id"),
    new Name("name")
);
```

在学生数据表中，需要维护一个老师的id（teacherId），简单的方法是只有把刚才生成过的老师数据中的id收集起来，插入到学生数据中即可。

```java
// code (5)

Schema.serial("student", 
    new Id("id"),
    new Name("name"),

    // 重点在这里，使用刚才给老师表标明的名称 teacher
    // 使用getProduced方法，返回一个随机数据域
    // 
    // 需要传入两个参数，
       // (1) id 表示在teahcer中的数据域
    // (2) teacherId 表示在当前表中新建的随机数据域的id
    Schema.get("teacher").getProduced("id", "teacherId")
);
```

以上代码运行结果，学生将得到一个 `teahcerId` 数据，该数据的取值来源是生成的老师数据中 `id` 的值。

# 结果生成
通过 `Schema` 生成数据，其实是生成 `Map<String, Object>` 对象，该对象通过随机数据域的名称作为键，而生成的数据为值。

其中，在 `SerialSchema` 中生成列表数据，即 `List<Map<String, Object>` 数据，而 `OnlySchema` 就是生成单个 `Map` 数据。

`Map` 对象可以通过不同的__结果处理器__，转换为不同格式的数据，或进行不同的数据处理。

## （1）生成文本
在 `Schema` 中使用 `asText` 返回 `Text` 对象，可以用于生成文本结果。可以考虑在生成 `sql` 、 `html` 等文本结果的场景使用。

### template
`Text template(String template)` 

实例方法，数据生成为文本的模板字符串。模板字符串使用 freemarker 模板语法（项目使用freemarker库）将数据生成为字符串。

### seperator
`Text seperator(String seperator)` 

实例方法，用于在每一条数据中插入间隔字符串，默认为换行符。

### toList
`List<String> toList()` 

实例方法，返回列表字符串。

### toFile
`void toFile(String filename)` 

实例方法，将字符串写入文本文件，需传入带完整路径的文件名。

### toWriter
`void toWriter(Writer writer)` 

实例方法，将字符串写入writer。

### toPrint
`void toPrint()` 

实例方法，将字符串打印到终端命令行。

代码示例：

```java
// code (6)

Schema user = Schema.serial("user", 
    new Id("id"), 
    new Name("name"), 
    new Age("age")
);

// 方法1 返回字符串列表
List<String> strList = user.asText()
.template("INSERT INTO `user` VALUES('${id}', '${name}', '${age}'")
.toList();

// 方法2 直接写文件
user.asText()
.template("INSERT INTO `user` VALUES('${id}', '${name}', '${age}'")
.toFile("/User/Jevon/Source/project/insert_user.sql");

// 方法3 通过writer作用 例如 System.out
user.asText()
.template("INSERT INTO `user` VALUES('${id}', '${name}', '${age}'")
.toWriter(new OutputSteamWriter(System.out));

// 方法4 直接打印内容到终端命令行
user.asText()
.template("INSERT INTO `user` VALUES('${id}', '${name}', '${age}'")
.toPrint();

```

## （2）生成Json
在 `Schema` 中使用 `asJson` 返回 `Json` 对象，可以将通过 `alibaba fastjson` 将生成的数据直接转为json字符串 。

适合在web应用中，向前端返回json数据。

注意，以下相同方法不再详细说明。

### target
`Json target(Class<?> clazz)` 
实例方法，数据生成json时，使用类进行数据转换。

### toStr
`String toStr()` 
实例方法，数据生成json字符串。

### toWriter
`void toWriter()` 
实例方法。

### toPrint
`void toPrint()` 
实例方法。

### toFile
`void toFile(String filename)` 
实例方法。

代码示例：

```java
// code(7)
Schema user = Schema.serial("user",
    new Id("id"),
    new Name("name"),
    new Age("age")
);

// 生成字符串
String json = user.asJson().toStr();

// 使用 class 进行序列化
String json = user.asJson().target(User.class).toStr();
```

## （3）生成Java对象数据
在 `Schema` 中使用 `asObj` 返回 `Obj` 对象，可以将数据转换为Java对象。

适合在Java单元测试中使用。

### toList
`List<T> toList(Class<T> target)` 
实例方法，返回指定类的对象列表。

### to
`T to(Class<T> target)` 
实例方法，返回指定类（单个）对象。

代码示例：
```java
// code (8) 

// 省略编写 getter 与 setter
public class Person {
    private Long id;
    private String name;
    private int age;
}

Schema.serial("user", 
    new Id("id"), 
    new Name("name"), 
    new Age("age")
).asObj().toList(Person.class);
```

## （4）向JDBC数据库写数据
在 `Schema` 中使用 `asJdbc` 生成 `Jdbc` 对象，该对象用于直接向数据库生成数据（暂只支持Mysql）。

### template
`Jdbc template(String template)` 
实例方法，可以指定向数据写数据的插入SQL模板。

### url
`Jdbc url(String url)`
实例方法，指定数据库url。优先使用该变量。

### host
`Jdbc host(String host)` 
实例方法，指定数据库主机。

### user
`Jdbc user(String user)` 
实例方法，指定数据库用户名。

### password
`Jdbc password(String password)` 
实例方法，指定数据库密码。

### db
`Jdbc db(String db)` 
实例方法，指定数据库。

### table
`Jdbc table(String table)` 

实例方法，指定插入数据的表名。注意，该方法不与template方法同时使用，如果已经指定了template，不使用该参数，如果未指定template，将自动按表名与数据名称，生成sql语句进行执行。

### to
`Jdbc to()` 
实例方法，执行数据库插入数据操作。

代码示例：
```java
// code (9)

Schema user = Schema.serial("user", 
    new Id("id"),
    new Name("name"),
    new Age("age")
)

// 按模板生成sql执行
user.asJdbc()
.host("localhost")
.user("root")
.password("123456")
.db("example")
.template("INSERT INTO `user` VALUES(${id}, '${name}', ${age}")
.to();

// 按表名自动生成sql执行
user.asJdbc()
.host("localhost")
.user("root")
.password("123456")
.db("example")
.table("user")
.to();
```
# 使用实践

在项目中，可以新建一个 `Generator` 类，在该类中定义一系列类型为 `Schema` 静态常量。

```java
public class Generator {
    public static final Schema user = Schema.serial("user", 
        new Id("id"),
        new Name("name"),
        new Email("email"),
        new Cellphone("cellphone")
    );

    public static final Schema article = Schema.serial("article",
        new Id("id"),
        new Paragraph("title"),
        new Article("content"),
        new DateTime("created")
    );
}
```

能过以上代码，就可以在不同场合同时使用，例如在后端数据库数据生成，web层json数据生成等。

```java

@RestController
public class UserController {
    
    @GetMapping("/user")
    public String find() {
        return Generator.user.asJson().toStr();
    }
}
```

```java
public void UserTest {
    
    @Test
    public void test() {
        Generator.user.asJdbc()
            .url("jdbc:myql")
            .table("user").to();
    }
}
```

# 随机数据域
1. 随机数据域都需要按构造方法传入一个字符串参数（mark），表示该随机数据域的名称标识，该标识在结果加工的过程中产生重要作用。
2. 随机数据域的生成可能会依赖于相关参数，参数的使用都需要通过链式调用。

代码示例：
```java
Bool bool = new Bool("bool");
boolean result = bool.next();

Bool bool_another = new Bool("bool").likelihood(60);
boolean result_another = bool.next();
```

## value
### Picker
__说明：__从指定的Randomable列表或数据对象列表中随机进行挑选

__参数设置：__
* values
    * 说明：设置Randomable列表或数据对象列表
    * 类型：Randomable数组、Randomable列表、对象数组、对象列表
### Union
__说明__：从指定的Randomable列表中，进行拼接，返回结果拼接的字符串

__参数设置：__
* values
    * 说明：设置Randomable列表或数据对象列表
    * 类型：Randomable数组、Randomable列表、对象数组、对象列表
### Bool
__说明：__ 随机生成 true 或 false。

__参数设置：__
* likelihood
    * __说明：__设置返回 true 的概率
    * __类型：__int，按 0 - 100 计，如传入值超出 100，则按值对100求余
### Floating
__说明__：生成 float 数值
__参数设置：__
* min
    * 说明：生成 float 数值的最小边界值
    * 类型：float
    * 默认值：`java.lang.Float.MIN_VALUE` 
* max
    * 说明：生成 float 数值的最大边界值
    * 类型：float
    * 默认值：`java.lang.Float.MAX_VALUE` 
* between
    * 说明：快速设置参数 min 与 max
    * 参数：
        * min
        * max
### Int
__说明：__生成 int 数值

__参数设置__：

* min
    * 说明：生成 int 数值的最小边界
    * 类型：int
    * 默认值：`java.lang.Integer.MIN_VALUE` 
* max
    * 说明：生成 int 数值的最大边界
    * 类型：int
    * 默认值：`java.lang.Integer.MAX_VALUE` 
* between
    * 说明：快捷设置 min 与max
## text
### Char
__说明：__ 随机生成单个字符

__参数设置__：

* pool
    * 说明：设置生成单个字符的字符集合
    * 类型：String 或 char[]
    * 默认值：`abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()` 
    * 
### Letter
__说明__：随机生成单个字母字符

__参数设置__：

* pool
    * 说明：设置生成单个字母的字符集合
    * 类型：String 或 char[]
    * 默认值：`abcdefghijklmnopqrstuvwxyz`
* upper
    * 说明：设置返回的字母是大写形式，无需参数调用
### Str
__说明__：生成一定长度的字符串

__参数设置__：

* count
    * 说明：设置生成字符串的长度
    * 类型：单个 `int` 数值，表示指定长度；两个 `int` 数值，表示在该范围之内随机长度
* min
    * 说明：设置生成字符串的最小长度
    * 类型：`int`
* max
    * 说明：设置生成字符串的最大长度
    * 类型：`int`
* pool
    * 说明：生成字符串的字符集合
    * 类型：`String` 或 `char[]`

### Word

__说明__：生成一个中文词语

__参数设置__：

- values
  - 说明：可供生成的词语字符串列表或数组
  - 类型：`List<String>` 或 `String[]`

### EnglishWord

__说明__：生成一个英文单词

__参数设置__：

- values
    - 说明：可供生成的单词列表或数组
    - 类型：`List<String>` 或 `String[]`

### Sentence

说明：生成一个中文句子

参数设置：

- values
  - 说明：可供生成的句子字符串列表
  - 类型：`List<String>`  或 `String[]`

### Pragraph

说明：生成一个中文段落

参数设置：

- values
  - 说明：可供生成的段落的字符串列表
  - 类型：`List<String>` 或 `String[]`

### Article

说明：生成一篇中文文章

参数设置：

- separator
    - 说明：文章每个段落间的间隔符
    - 类型：`String`
    - 默认值：换行符

## web
### Ip

说明：生成ip地址字符串

### Ipv6

说明：生成ipv6地址字符串

### Protocol

说明：生成互联网协议名

### Tld

说明：生成主流的域名后辍

### Url

说明：生成Http协议的Url地址

### UserAgent

说明：生成Http协议中的UserAgent

### Domain

说明：生成完整域名（不带前辍），如: abc.com

### email

说明：生成电子邮件地址

### Image

说明：生成可访问的图片地址，使用 https://placeimg.com

参数设置：
- width
    - 说明：图片宽度
    - 类型：`int`
    - 默认值：200
- height
	- 说明：图片的高度
	- 类型：`int` 
	- 默认值：600
- bewteen
	- 说明：设定图片宽度与高度的随机值范围。注意，如果已经设置了 width 或 - height ，则不使用随机值。
	- 类型：`int`

### ColorImage

说明：生成可访问的图片，图片为纯色与文字组合，使用 https://dummyimage.com

参数设置：
- width
	- 说明：图片宽度
	- 类型：`int`
	- 默认值：200
- height
	- 说明：图片长度
	- 类型：`int`
	- 默认值：200
- ratio
	- 说明：图片宽与高比例，如 `ratio(4, 3)` , 生成的图片会按4:3生成。注意，设置比例后，请再设置宽度或高度。
	- 类型：`int`
- format
	- 说明：图片格式，有jpg(ColorImage.JPG)、png(ColorImage.PNG)、gif(ColorImage.GIF)
	- 类型：`int`
	- 默认值：jpg

## time
### Timpstamp

说明：生成unix时间戳

参数设置：
- year
	- 说明：设置生成时间的年份范围，按start与end进行设置，如 `year(1990, 1997)`
	- 类型：`int`
	- 默认值：1949 - 2049
- month
	- 说明：设置生成时间的月份范围，按start与end进行设置，如 `month(3, 6)`
	- 类型：`int`
	- 默认值：1 - 12
- day
	- 说明：设置生成时间的具体天数范围，按start与end进行设置，如 `day(15, 25)`
	- 类型：`int`
	- 默认值：1 - 30
- hour
	- 说明：设置生成时间的具体小时范围，按24小时计，按start与end进行设置，如 `hour(10, 22)`
	- 类型：`int`
	- 默认值：1 - 23
- minute
	- 说明：设置生成时间的具体分钟范围，按start与end进行设置，如 `minute(15, 25)`
	- 类型：`int`
	- 默认值：0 - 59
- minute
	- 说明：设置生成时间的具体秒范围，按start与end进行设置，如 `minute(15, 25)`
	- 类型：`int`
	- 默认值：0 - 59
### DateTime

说明：生成 java.lang.Date

参数设置：与 Timestamp 相同

## person
### Age

说明：生成整数年龄，默认值范围：16 - 68

参与设置：与 Int 相同

### Bank

说明：生成银行卡号

### Cellphone

说明：生成移动电话号码

### Telphone

说明：生成固定座机号码

### Colleage

说明：生成高校学校名称

### Gender

说明：生成性别名称

参数设置：
- female
	- 说明：返回女性的字符串 
	- 类型：`String`
	- 默认值：女
- male
	- 说明：返回男性的字符串
	- 类型：`String`
	- 默认值：男

### IdCard

说明：生成身份证号码

### Name

说明：生成人名

### Nation

说明：生成56个民族

## identity

### Id

说明：生成唯一id

### Increment

说明：生成自增长id

参数设置：
- start
	- 说明：增长的开始值
	- 类型：int
	- 默认值：1
- stop
	- 说明：增长的结束值，假设循环至该值后，自动重置为开始值
	- 类型：int
	- 默认值：`java.lang.Integer.MAX_VALUE`
- step
	- 说明：每次增长时，增长的值
	- 类型：int
	- 默认值：1

### uuid

说明：生成uuid

## color
### HexColor

说明：生成Hex形式的颜色值

### RgbColor

说明：生成Rgb形式的颜色值

## area
### Address

说明：生成地址字符串

### City

说明：生成城市名称

### Country

说明：生成国家与地区名称

### Province

说明：生成省份名称

### Zip

说明：生成邮编名称
