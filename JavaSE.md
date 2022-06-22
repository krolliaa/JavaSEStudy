# `Java`

学习目标：

- 基础程序设计【关键字、数据类型、运算符、流程控制、数组【排序算法/数据结构】】
- 面向对象编程【类/对象、类的结构、封装、继承、多态、接口、设计模式】
- 应用程序开发【`JDBC`【`Oracle/MySQL`】、集合、`IO/NIO`、类库、多线程、异常处理、反射、网络】
- `Java`新特性【泛型、元注解、装箱/拆箱、枚举、可变参数、`Lambda`表达式、`Stream API`、`Date/Time API`】

演练项目：

- 项目一：家庭收支记账软件
- 项目二：客户信息管理软件
- 项目三：开发团队人员调度软件
- 附加项目一：银行业务管理软件
- 附加项目二：单机考试管理软件

# 2022年06月02日上午

## 注释

- 单行注释：可以嵌套使用【不参与编译】
- 多行注释：无法嵌套使用【不参与编译】
- 文档注释：无法嵌套使用【不参与编译】

## 关键字和保留字

关键字：被`Java`语言赋予了特殊含义，用作专门用途的字符串，所有的关键字都是小写字母构成的

保留字：现有`Java`版本尚未使用但是在以后的版本可能会作为关键字使用【`goto const`】

## 标识符

给`Java`中包、类、接口、方法、变量、常量等要素命名时使用的字符串序列称为标识符，**有三点需要注意**：

1. 除了字母数字下划线还有美元符，不能用其它字符构成标识符，严格区分大小写且无长度限制，尤其需要注意的字符就是空格，这个很容易忽略掉，标识符按照规定不能包含空格字符
2. 标识符不能以数字开头，只能以字母、下划线和美元符作开头
3. 尤其注意关键字和保留字无法作为标识符

**常见默认遵守的命名规范如下：**

- 包：给包名命名时，使用的均为小写字母`xxx.yyy.zzz`
- 类/接口：所有单词的首字母大写如`XxxYyyZzz`
- 方法/变量：采用驼峰命名法，第一个单词的字母都小写【包括首字母】，第二个以及后面单词的首字母大写，其余字母小写`xxxYyyZzz`
- 常量名：单词均由大写字母构成，并且单词与单词之间使用下划线连接`XXX_YYY_ZZZ`

## 变量

**变量的概念：**

- 变量就是存储在内存中的一个区域，该区域的数据可以在同一数据类型的范围之内不断变化。
- 变量是程序中最基本的存储单元，它包括：**变量名**、**存储数据的数据类型**以及**存储的值**三部分。

**变量的作用：**

- 用于在内存中存储特定数据类型的数据。

**使用变量需要注意：**

- 在`Java`中，使用变量需要**使用变量名来访问**，并且只有在**先声明**变量之**后才可以使用**变量
- 变量定义在`{}`里头称为变量的**作用域**，超过作用域就无法使用该变量，并且不能在同一作用域中定义重复变量

**变量的分类-按数据类型：**

- 可以将数据类型分为：**基本数据类型**和**引用数据类型**。

- **基本数据类型包括[八大]**：`char byte short int long float double boolean`

  - 在`Java`中的字段长度和表数范围都是固定的不受`OS`影响，因为要保证`Java`程序的可移植性。

  - `byte`占用`1字节=8位bit`，表数范围在：`-128 ~ 127`之中【256】

  - `short`占用`2字节`，表数范围在：`-32768 ~ 32767`之中【65536】

  - `int`占用`4字节`

  - `long`占用`8字节`【`Java`中默认的就是`int`数据类型，声明`long`数据类型需要加`l`或者`L`】

  - `float`占用`4字节`，单精度浮点型，**为什么跟`int`一样是占用`4字节`，但是表示的数据却可以比`long`数据类型还要大呢？**因为它的表数方式有些特别，它是分两部分存储，一边存储具体的数，另一边存储的是10的多少次幂，也就是说用的是科学计数法，所以可以存储比`long`还大的数。

  - `double`占用`8字节`，双精度浮点型，`Java`默认浮点型数据类型

  - `char`占用`2`字节，表示字符，一个汉字正好是`2`字节，所以可以直接存储汉字，`char`存储数值可以有三种表现形式：`char c1 = 'a'`，`Java`中还允许使用转义字符`\`，并且可以使用十六进制如：`\u000a`表示`\n`，`char`数据类型是可以进行运算的，因为它有对应的`Unicode`码，可以进行运算。常见的`65 - A， 97 - a`，为了跨界形成了万国码`Unicode`，其中最广泛应用的`Unicode`实现方式就是`UTF-8`，注意`char`跟`char`是做运算，`char`跟`string`是连接

  - <font color="red">**基本数据类型转换：**</font>分为自动类型转换和强制类型转换，自动类型转换就是容量小的类型可以自动转换为容量大的类型，数据类型容量按从小到大的排序为：`byte ---> short|char ---> int ---> long ---> float ---> double `

    - <font color="deepskyblue">**`byte short int`之间不会相互转换**</font>，他们三者在计算机中首先转换为：`int`数据类型，比如：

      ```java
      byte b = 1;
      byte b1 = b + 1;【报错】
      ```

    - `boolean`数据类型比较特殊，不能跟其它数据类型进行运算，也无法进行数据转换

    - 当把任何基本数据类型的值和字符串进行拼接运算时，基本数据类型的值将自动转换为字符串`String`数据类型【引用数据类型】

  - <font color="red">**强制数据类型转换：**</font>强制类型转换需要加上强制转换符`()`，可能造成精度降低或溢出需要格外注意，字符串不能直接转换为基本数据类型，但是可以通过包装类间接转换，`boolean`数据类型不能转换为其它数据类型。

  - **习题：**

    ```java
    System.out.println("*	*");\\*    *
    System.out.println('*' + '\t' + '*');\\93
    System.out.println('*' + "\t" + '*');\\*	*
    System.out.println('*' + '\t' + "*");\\51*
    System.out.println('*' + ('\t' + "*"));\\*    *
    ```

    ```java
    short s = 5; s= s -2;//编译错误，因为 s 会先转换为 int 数据类型
    byte b = 3; b = b + 3;//编译错误，因为 b 会先转换为 int 数据类型
    byte b - 3; b = (byte)(b + 4);//编译正确
    char c = 'a';int i = 5;float d = 0.314F;double result = c + i + d;//编译正确
    byte b = 5; short s = 3; short t = s + b;//编译错误
    ```

- **引用数据类型包括**：类`class`、接口`interface`、数组`array`

**变量的分类-按声明的位置：**

- 在方法体外称为：成员变量【包括实例变量（没有`static`修饰）和类变量（有`static`修饰）】
- 在方法体内称为：局部变量【包括形参（方法、构造器中定义的变量，不需要显示初始化）、方法局部变量（在方法内定义的变量）、代码块局部变量（在代码块内定义的变量）】

**关于进制：**

二进制以`0b 0B`开头，八进制以`0`开头`3 位二进制表示`，十六进制以`0x 0X`开头`4 位二进制表示`，`A-F`不区分大小写。<font color="red">**计算机存储都是以补码的形式存储数据**</font>，正数的原码反码和补码都是它本身，负数的补码是原码取反码+1。

`10111011`有可能是正数也可能是负数：

- 正数代表：`2^7 + 2^5 + 2^4 + 2^3 + 2^1 + 1 = 1 + 2 + 8 + 16 + 32 + 128 = 197`
- 负数代表：补码取反得到`11000100`首位是符号位不变，`+1`得到：`11000101`，所以最终值为：`-69`

如果这里第一位确保是符号位，那么只能表示负数，结果为：`-69`

`-128`的二进制表示：`10000000`这里指的是只有`8`位存储。十进制转化为二进制可以使用`2 4 6 8 16 32 64 128 512`快速定位进行转换。

**习题：**

1. 标识符的命名规则有哪些？只能使用字母数字下划线和美元符构成标识符，并且不能以数字开头，且不能使用关键字和保留字当作标识符。
2. 标识符的命名规范有哪些？包名都小写，类名首字母都大写，方法名和变量名采用驼峰命名法，常量名都大写。
3. `Java`变量按照数据类型怎么划分？按照数据类型划分变量可以划分为基本数据类型和引用数据类型。`Java`基本数据类型有：`byte[1] short[2] int[4] long[8] char[2] float[4] double[8] boolean[4]`引用数据类型有：类/接口/数组。
4. 说明基本数据类型之间自动类型提升的运算规则？
   - 小容量可以直接转换为大容量数据类型的数据
   - `short byte int`运算时都先转换为`int`数据类型
   - `char`数据类型可以进行运算，如果是跟`String`数据类型进行则表示连接
   - `boolean`类型比较特殊，无法与其它数据类型进行运算，如果某人非得这么做那么会出现编译错误
5. 说明强制转换使用的规则和可能出现的问题？
   - 容量大的转换为容量小的数据类型需要使用强制类型转换
   - 可能会出现精度降低或溢出

# 2022年06月02日下午

## 运算符

包括算术运算符、赋值运算符、关系运算符、逻辑运算符、位运算符、三元运算符

- 算术运算符：++、--，如果++、--在前则先自增/自减后做运算，如果在后则先运算后自增/自减

- 赋值运算符：+=、-=、*=、/=、%=，会进行自动类型转换 ---> `int n = 10; n += n + (n++) + (++n); ---> n = 10 + 10 + 12 = 32`

- 比较运算符：比较运算符的结果都是`boolean`型，所以结果要么是`true`，要么是`false`
- 逻辑运算符：都有逻辑与/或、短路与/或等，短路的意思是比如短路与，前面是假的立马返回假，但是逻辑与不是
- 位运算符：`<<左移 >>右移 >>>无符号右移 &与运算 |或运算 ^异或 ~按位取反`，如何快捷计算`2^3`只需：`2 << 2`相当于：`2 * 2^2 ---> 2^3`【注：没有无符号左移`<<<`，只有无符号右移`>>>`因为符号位在最左边】
- 三元运算符：`a == 1 ? a = 9 : b = 8;`，可以转换为`if-else`

运算符的优先级：想让谁先进行运算可以使用小括号

## 流程控制

`if...else if...else...`以及`switch...case...`

## 循环

`for while do...while`

**项目一：家庭收支记账软件**

## 数组

数组是多个相同数据类型按照一定顺序排列的集合，数组在内存中存储位置是一连串的，而不是分散的，并使用一个名字进行命名通过下标的方式对这些数据进行统一管理。

**数组的特点：**数组是有序排列的，属于引用数据类型的变量。数组中的元素既可以是基本数据类型也可以是引用数据类型，这取决于定义数组变量时定义的数据类型是什么。创建数组引用数据类型会在内存中开辟一整块连续的空间。数组的长度一旦确定了就无法修改。

**数组的分类：**可以按照维度分一维数组、二维数组等，也可以按照数组里面的元素的类型分，分为基本数据类型元素的数组、引用数据类型元素的数组。

**一维数组的使用：**

1. 一维数组的声明和初始化
2. 如何获取数组的长度
3. 如何遍历数组
4. 数组元素的默认初始值
5. 数组的内存解析

```java
//两种初始化方式：【前面的[]永远是空的，要么静态初始化要么动态初始化，其它的形式都是错误的！！！】
int[] a = new int[]{1, 2, 3, 4, 5, 6};//数组静态初始化 ---> 指定元素
String[] names = new String[6];//数组动态初始化 ---> 没有指定元素

//使用索引即可获取指定位置的数组元素

//获取数组长度 ---> 在数组初始化时长度就确立了

//数组元素的默认初始化值 ---> 根据定义数组引用数据类型变量的数据类型来定
//byte、short、int、long 数据类型 ---> 默认值为 0
//float、double 数据类型 ---> 默认值为 0.0
//char 数据类型 ---> 默认值为 '0'
//boolean 数据类型 ---> 默认值为 false
//引用数据类型元素 ---> 默认值为 null
```

**一维数组的内存解析：**

```java
int[] arr = new int[]{1, 2, 3};
String[] arr1 = new String[4];
arr1[0] = "刘德华";
arr1[0] = "张学友";
arr1 = new String[3];
```

变量`arr`存储在**栈内存**中，数组存放在**堆内存**中，数组在内存中分配的空间地址是连续的，连续的内存空间有一个首地址值，用一个十六进制数表示比如：`0x34ab`，将这个地址值赋值给存储在栈内存空间的`arr`，也就是说：栈内存空间中的`arr`变量存储的是一个地址。在堆内存空间这边，起初数组默认值均为：`0`，`1 2 3`将按位置替换掉原先的`0`。

变量`arr1`也是如此，但是这里引入了`String`这种东东，`String`类型的数据比较比较特殊，它本身也是引用数据类型，存放在方法区中的常量池中，`arr1`变量存放的是`String`数组的地址，而该`String`数组存放的也是地址，是`String`元素的内存地址。

**习题：**

```java
public class ArrayTest {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 1, 0, 3};
        int[] index = new int[]{2, 0, 3, 2, 4, 0, 1, 3, 2, 3, 3};
    	String tel = "";
        for(int i = 0; i < index.length; i++) tel += arr[index[i]];
        System.out.println("联系方式：" + tel);//18013820100
    }
}
```

**二维数组：**从数组底层的运行机制来看其实是没有多维数组的，二维数组本质是一个一维数组作为另外一个一维数组`array2`的元素而存在。

**二维数组的初始化：**

```java
int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6, 10}, {7, 8, 9}};//一维数组作为另外一个数组的元素 ---> 静态初始化
int[][] arr1 = new int[3][4];
int[][] arr1 = new int[3][];
int arr1[][] new int[3][];
int[] arr1[] = new int[3][];
int[] arr1[] = {{1, 2, 3}, {4, 5, 6, 10}, {7, 8, 9}};//运用类型推断可不写 new... 相当于直接赋值，但是只能在一行中完成才可以，否则不对，因为在一行才能通过前面推断出后面，不在同一行无法推断。一维数组也是一样的。
//错误：int[][] arr1 = new int[][4];//行必须要确定
```

**二维数组的长度：**

- `arr.length` ---> 取决于行数
- `arr[0].length` ---> 如果是静态初始化的数组，如果第一行有`3`个元素，第二行有`4`个元素，则就是`3`个，就是`4`个，这一行多少个元素就是多少个元素，不会变化

**<font color="red">其实搞清楚二维数组本质上还是一个一维数组，只不过对应的下标那个位置存放的是一个一维数组罢了。</font>**所以当你打印`arr[3][4]`中的`arr[0]`的时候打印出来的就是一个内存地址，该内存地址指向存放在`arr[0]`的数组。

**二维数组的内存解析：**

```java
int[][] arr1 = new int[4][];
arr1[1] = new int[]{1, 2, 3};
arr1[2] = new int[4];
arr1[2][1] = 30;
```

`arr1`是一个数组变量，其元素是一个数组引用数据类型，综合起来就是二维数组。`arr1`存放的是一个数组的内存地址，该数组存放在堆内存中，并且有`4`个元素，`arr1[1]`存放了一个数组元素为`{1, 2, 3}`的数组地址，`arr1[2]`存放了一个数组元素为`{0, 0, 0, 0}`的数组地址。`arr1[2][1]`表示的是`arr1`索引为`2`的位置存放的数组的索引为`1`的位置存放的元素为：`30`

**习题：**

```java
1. 写出一维数组初始化的两种方式？
静态初始化：int[] arr = new int[]{1, 2, 3}; 或者 int arr[] = new int[]{1, 2, 3}; 或者 int arr[] = {1, 2, 3};
动态初始化：int[] arr = new int[6];

2.写出二维数组初始化的两种方式？
静态初始化：int[][] arr = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}}; 或者 int[][] arr = {{1, 2, 3}, {4, 5}, {6, 7, 8}}; 或者 int[] arr[] = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
动态初始化：int[][] arr = new int[3][4]; 或者 int arr[][] = new int[3][4]; 或者 int[] arr[] = new int[][];

3.如何遍历如下的二维数组？使用双重 for 循环即可

4.不同类型的一维数组元素的默认初始化值是多少？0 0.0 '0' false null
```

线性查找、二分法查找、冒泡排序、快速排序【算法不是一朝一夕的事情】

**`Arrays`工具类的使用**

数组在开发当中很频繁被使用，为了更方便的使用数组，所以`Java`设计人员开发了专门用于数组的`API`即工具类。

- 判断两个数组是否相等：`Arrays.equals(arr1, arr2);`【比较的是内容】
- 输出数组信息：`Arrays.toString(arr);`
- 将指定值填充到数组中：`Arrays.fill(int[] a, int val);`【也就是把所有的元素都换成`val`】
- 对数组进行排序：`Arrays.sort(int[] a);`
- 对排序后的数组进行二分法检索指定的值：`Arrays.binarySearch(int[] a, int key);`没找到返回的是一个负数，并不固定而是跟数组长度有关

**常见异常：**`ArrayOutIndexofBoundsException`数组越界异常、`NullPointerException`空指针异常

# 2022年06月04日下午

## 面向对象——类和对象

类：是对一类事物的描述，是抽象的概念上的定义

对象：类的实例，是具体某个类的每个个体(`instance`)

**对象的内存解析：**

对象实例所需要的内存空间全部都在虚拟机中的堆空间中，而栈呢？用于存储局部变量等。方法区用于存储已被虚拟机加载的类信息、常量、静态变量、即时编译器编译后的热点代码等数据。以下面这段代码为例子讲解对象的内存解析：

```java
Person p1 = new Person();
p1.name = "Tom";
p1.isMale = true;
Person p2 = new Person();
System.out.println(p2.name);
Person p3 = p1;
p3.age = 10;
```

1. `p1`变量存放在栈内存空间中，`p1`为名称，存放的类型为`Person`类型，存放的值为`Person`类对象的在堆空间的内存地址，假设为：`0x12ab`，在堆内存空间中，开辟了一个内存空间，地址为：`0x12ab`，存放了：`name:null age:1 isMale:false`。
2. 将`p1.name`在堆内存空间的值赋予字符串的地址，`Tom`存放在方法区常量池中
3. 将`p1.isMale`在堆内存空间的值赋予为`true`
4. 跟`1`类似同样也是**新开辟**了一块堆内存空间，栈内存保存`p2`变量，内容为地址
5. 打印`p2.name`，初始化值为`null`
6. 栈内存空间分配了`p3`，将`p1`中的内存地址分配给了`p3`，于是乎`p3`的值跟`p1`一样保存的是：`0x12ab`，指向同一个堆内存空间中
7. `p3.age = 10`指的是将`p1 p3`共同指向的堆内存空间中的`Person`类对象中的`age`更改为`10`

## 面向对象——属性和方法

属性：对应类中的成员变量(`field`)

方法：对应类中的成员方法

局部变量：声明在方法内部、方法形参、代码块内、构造器形参、构造器内部的变量，可以在声明属性的时候指明其权限修饰符：`public protected default private`，成员变量中的实例变量存储在对空间中，类变量也就是有`static`修饰符修饰的变量存储在方法区当中。局部变量像方法内部的变量、形参、构造器的形参、构造器内部的变量都是局部变量，存储在栈内存空间中。

方法中`return`的作用：结束、返回数据

**方法重载：**

- 只要同名不同参，其余包括权限修饰符、返回值类型随便搞，只要求名字相同，不管你参数个数变了还是参数的数据类型变了【参数名称只是个标识符，不影响本质】都叫方法重载。方法重载跟权限修饰符、返回值类型、形参标识符、方法体都没有关系。

**可变形参个数的方法：**

有时候指定形参个数的方法无法满足需求，而需要可以变化形参个数的方法才能满足需求：

```java
public static void test(int a, String...books);
```

需要注意的点就是可变形参个数方法不能跟其它同名同类型参数的方法相同。比如有了：

```java
public static void test(int a, String book);
```

那么就不能有可变形参个数的方法存在。

**方法参数的值传递机制：**

- 如果传递的是基本数据类型，此时赋值的是变量所保存的数据值，也就是说如果方法体中修改了形参**<font color=red>不会</font>**影响到传递的数据。
- 如果传递的是引用数据类型，此时赋值的是变量所保存的数据的地址值，也就是说如果方法体中修改了形参**<font color="red">会</font>**影响到传递的数据。

习题：

1. 最后结果为：15 0 20

   ```java
   class Value {
       int i = 15;
   }
   
   public class TransferTest {
       public static void main(String[] args) {
           TransferTest test = new TransferTest();
           test.first();
       }
       public void first() {
           int i = 5;
           Value value = new Value();
           value.i = 25;//value 中的 i 变成了 25
           second(value, i);
           System.out.println(value.i);//打印 20
       }
       
       public void second(Value v, int i) {//这里的 v 跟传递过来的 value 一样指向同一个内存地址，i = 5
           i = 0;
           v.i = 20;//value.i = v.i = 20
           Value val = new Value();
           v = val;//value.i = 20, v.i = val.i = 15 这里 v 改变了指向的地址，变成跟 val 执行地址一样了
           System.out.println(v.i + " " + i);//打印：15 0
       }
   }
   ```

2. 最后结果为：一是在方法中打印完就退出程序：`System.exit(0)`，二是可以重写`println()`方法

   ```java
   public class Test {
       public static void main(String[] args) {
           int a = 10;
           int b = 10;
           method(a, b);//需要在 method 方法被调用之后，仅打印出 a=100,b=200，请写出 method 方法的代码
           System.out.println("a = " + a);
           System.out.println("b = " + b);
       }
   }
   ```

   ```java
   public void method(int a, int b) {
   	PrintSystem ps = new PrintSystem(System.out);
   	@Override
   	public void println(String x) {
      		if("a=10".equals(x)) {
           	x = "a=100";
       	} else if("b=10".equals(x)) {
          		x = "b=200";
       	}
   		super.println(x);
   	}
   	System.setOut(ps);
   }
   ```

3. 最后结果为：`abc`

   ```java
   char[] arr1 = new char[]{'a', 'b', 'c'};
   System.out.println(arr1);//输出：abc
   ```

**复习：**

1. 什么是方法的重载？同名不同参就是方法重载
2. 说明`Java`方法中的参数传递机制的具体体现？基本数据类型直接传递值，引用数据类型传递的是地址值。
3. 成员变量和局部变量在声明位置上、是否有默认初始化值上、是否能有权限修饰符修饰上、内存分配的位置上有何不同？成员变量包括实例变量和静态变量，后者有`static`修饰，前者没有，局部变量是方法形参方法体内的变量，还有构造器的形参以及构造器内的局部变量。
4. 谈谈`return`关键字的使用？一是结束方法直接`return;`二是返回符合数据类型的数据`return + 返回数据`。

# 2022年06月04日晚上

## 面向对象——三大特性之封装性

封装使得代码高内聚、低耦合，可以隐藏对象的复杂性，除此之外还可以做一些验证，只对外面公开简单的接口便于外界调用，从而提高系统的可扩展性、可维护性，通俗地说把该隐藏的隐藏起来，该暴露的暴露，这就是封装性的设计思想。

比如：手机我们用就行，并不需要知道手机是怎么做出来的，无需了解手机的内部结构。

## 面向对象——四种权限修饰符的理解

- `private`：只有类内部可以访问
- `default`：只有类内部、在同一个包才可以访问
- `protected`：只有在类内部、在同一个包或者是不同包的子类才可以访问
- `public`：在整个工程均可以访问【也就是在一个工程内，在任意地方都可以访问】

### 面向对象——构造器

构造器就是用来创建对象的，只要`new`就会调用构造器然后创建对象，如果没有显示的定义构造器，系统就会默认提供一个空参构造器，如果显示定义了的话系统将不再默认提供一个空参构造器，如果需要空参构造器需要自己定义。

定义构造器的格式为：`public` 权限修饰符(形参) {}

一个类中定义了多个构造器，彼此就构成了方法重载【同名不同参】。肯定是至少存在一个构造器的。

`JavaBean`：就是符合如下标准的一个类

1. 类是公共的即`public`修饰的
2. 有一个无参公共构造方法
3. 有属性并且存在相对应`Getter Setter`方法

## 面向对象——`this`关键字的使用

为什么要用`this`？它是什么东西？怎么用？

`this`代表的就是对象本身，指向堆内存空间中对象自己，有了对象才有`this`，如果没有对象就没有`this`。

- 在类的方法中我们可以使用`this.属性`或者`this.方法`的方式调用当前对象属性或者方法。但是通常情况下我们选择省略掉`this.`。特殊情况下如果方法的形参和类的属性同名的时候，我们必须显示的使用`this.变量`的形式，表示此变量用的是属性而不是形参。
- 可以在构造方法中使用：`this(形参列表)`调用本类中指定的其它构造器
- 构造器不能通过`this(形参列表)`调用自己
- `this(形参列表)`必须声明在当前构造器的首行

# 2022年06月05日下午

## 复习

1. 构造器的作用是什么？
   - 创建对象，初始化对象信息
   - 注意点：构造器没有返回值 + 权限修饰符是`public` + 如果没有显示写出构造器则程序默认给一个无参构造器，如果写了就不给 + 一个类中至少有一个构造器 + 构造器与构造器之间构成方法重载
2. `this`关键字可以用来调用哪些结构？
   - 调属性，调方法，调用构造器
3. 权限修饰符有哪些？并说明各自权限范围？
   - public  当前类内部 + 当前包 + 子类 + 当前工程外部包
   - protected 当前类内部 + 当前包 + 子类
   - default 当前类内部 + 当前包
   - private 当前类内部
4. 什么是封装性？
   - 可以隐藏设计复杂性，隐藏私有方法，只对外暴露简单的接口供其调用，将类的属性保护起来，该隐藏隐藏，该暴露暴露

## 面向对象——三大特性之继承性

继承性减少了代码的冗余提高了代码的复用性，便于功能的扩展。为之后的多态性提供了前提。一个类是另外一个的子类，则该子类继承了父类的结构、属性和方法。

如果父类的属性或者方法被`priavte`修饰了，仍然认为子类获取了父类私有的结构，但是因为封装性的缘故，子类是不能直接调用父类的结构的。看似获取了实则没有获取。

注意点：

- 一个类只能有一个父类，也就是说`extends`后面只能写一个类【爸爸只有一个】
- 一个父类可以有多个子类，可以被多个子类继承，参考：`Object`类【儿子有很多个】

## 面向对象——方法重写【非常重要】

在子类中可以根据需要对从父类中继承过来的方法进行改造，也称为方法重置、覆盖。在程序执行时，子类的方法将覆盖父类的方法。通俗地讲就是，我继承了你的结构但是我想要内容是自己的一套东西。

- 子类重写的方法方法名和形式参数以及返回值数据类型都必须一样
- 子类重写的方法的访问权限不能比父亲的还严格，比如父亲是`protected`，那子类就不能是`private`，只能是`protected default public`，**并且如果父类是`private`修饰的，那么子类是无法进行重写的。**
- 子类抛出的异常不能比父类抛出的异常范围大、更加多【不允许】，儿子不能比爸爸犯的更多更大的错

**<font color="red">注：就是除了权限修饰符、异常这两个需要注意，其余的都保持一样就叫做方法重写。</font>**

**如果父类中的方法被`static`修饰了，此时看似可以对该静态方法进行方法重写，其实不然，因为静态方法是随着类的加载而被加载的，子类无法对静态方法进行方法重写。**

```java
public static void getNum() {
	System.out.println("123");
}

public static void getNum() {
    System.out.println("456");
}
```

习题：

1. 如果一个父类中某个方法定义成`private`访问权限，在子类中将此方法声明为`default`访问权限，那么这样还叫重写吗？**无法，因为被`private`修饰的无法进行方法重写。**

## 面向对象——`super`关键字

- 我们可以在子类的方法或者构造器中，通过使用`super`关键字来调用父类中声明的属性或者方法，默认省略，适用于重写的方法想要调用父类的方法。
- 子类创建对象的时候，会默认加载所有的父类的结构所以会先调用父类的构造器，一直调到`java.lang.Object`类中的空参构造器为止。
- 在构造器中，无论`this`还是`super`都需要写在首行

## 面向对象——三大特性之多态性

所谓多态就是调用的是父类同名同参的方法，但是实际上执行的确实子类重写父类的方法。`Animal animal = new Cat();`

- **<font color="red">父类引用指向子类对象</font>**

- **<font color="red">编译看左边，运行看右边</font>**

多态性的使用前提：一是存在继承关系，二是方法重写，如果没有继承关系，就谈不上方法重写，而方法重写是多态性体现的根本，所以多态性依赖于方法重写，而方法重写依赖于继承性，所以说形成多态性需要两个条件：1.继承 2.方法重写

多态性只适用于方法，不适用于属性，对于属性编译和运行都看左边。

如果在方法调用之前就已经确定了所要调用的方法，那么他就是早绑定、静态绑定，而如果只有在调用的那一刻才确定，编译器才知道调用哪个具体的方法那么他就是晚绑定或者叫做动态绑定。**“如果它不是晚绑定，那么他就不是多态！”**

因为类是单继承的，但是可以实现多个接口，而没有多态性的话，接口和抽象类就没有用了，这就是多态性的用处。

可以使用`instanceof`看是否可以转型。

习题：

```java
class Base {
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Sub extends Base {
    int count = 20;

    public void display() {
        System.out.println(this.count);
    }
}

public class FieldMethodTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println(s.count);//输出 20
        s.display();//Sub 重写了父类 Base 中的 display 方法，打印 20
        Base b = s;//父类引用指向子类对象，这里用到了多态，所以 b 其实是一个 Sub 对象，跟 s 指向同一个地址
        System.out.println(b == s);//这里比较的是内存地址，b 跟 s 都指向同一个内存地址，所以为 true
        System.out.println(b.count);//10 这里因为 Base b 的缘故，所以在堆内存中会有父类的属性，找的话是先找父类的属性
        b.display();//20 因为这里是 this ，指向的是 Sub 类对象方法区中的方法，如果这里改成 super，那么指向的就是父类的，结果就变为 10，或者找不到才会去找父类的
    }
}
```

如果不懂可以看下这张内存图：

![](https://img-blog.csdnimg.cn/019cbf1e599d41048be1e336aa34f664.png)

- 问：多态是编译时行为还是运行时行为？
- 答：只有在调用的那一刻才知道到底调用的是哪个类的方法，所以是运行时行为。

```java
class Base {
    public void add(int a, int...arr) {
        System.out.println("base");
    }
}

class Sub extends Base {
    public void add(int a, int[] arr) {
        System.out.println("sub_1");
    }
    
    public void add(int a, int b, int c) {
        System.out.println("sub_2");
    }
}

public class FieldMethodTest {
    public static void main(String[] args) {
        Base base = new Sub();
        base.add(1, 2, 3);//输出 sub_1，编译没问题，调用的是 Sub 类的 add 方法，编译器认为int...arr 和 int[] arr 是一样的 如果把 sub_2 打开把 sub_1 合上输出的则为 base，如果不合上，输出的还是 base_1
        Sub s = (Sub)base;//s 指向的跟 base 一样 指向在堆内存中的一个 Sub 对象
        s.add(1, 2, 3);//sub_2 确定个数的优先调用
    }
}
```

# 2022年06月06日上午

## 面向对象——`Object`类的使用

- 所有类的根基都是`Object`类，是`Java`继承树的根节点。

- `Object`类只声明了一个空参构造器。

## 垃圾回收机制

其实这是属于`JVM`里的内容，垃圾回收机制只回收`JVM`堆内存空间里的对象。对其他物理连接比如数据库连接、输入输出流、`Socket`连接无能为力。垃圾回收发生的时间点具有不可预知性，是无法直接确定的，程序无法精确的控制垃圾回收机制的执行。

- 可以将对象的引用置为`null`，以此来按时垃圾回收机制回收该对象。
- 程序员可以通过`System.gc()`或者`RunTime.getRuntime().gc()`来通知垃圾回收机制进行垃圾回收，但是这样做也只能是通知，垃圾回收机制可能不会立马就进行垃圾回收。
- 垃圾回收机制在回收对象之前，总会先调用它的`finalize`方法，记住，永远不要主动调用`finalize`方法，而应该让其交给垃圾回收机制来完成。

在笔试当中通常由这么一道题目：`final finally finlize`的区别？`final finally` 都是关键字，`finalize`是垃圾回收机制在进行垃圾回收之前都会去调用的一个方法。

## `==`和`equals`区别

**关于`==`：**

- `==`在比较基本数据类型的时候，如果两个值的数据类型不一样，会存在数据类型提升，比较基本数据类型比较的是两个变量保存的数据是否相等（数据类型不一定相同）

  ```java
  int i = 10;
  int j = 10;
  double d = 10.0;
  System.out.println(i == j);//true
  System.out.println(i == d);//true
  boolean b = true;
  System.out.println(i == b);//编译错误
  char c = 10;
  System.out.println(i == c);//true
  char a = 'A';
  char e = 65;
  System.out.println(a == e);//true
  ```

- `==`在比较引用数据类型变量的时候，比较的是两个引用数据类型变量保存的地址值是否相同，**<font color="orange">两边的数据类型得保持一致，否则编译不通过</font>**

**关于`equals()`：**

- `Object`类就有`equals()`方法，根据继承关系，所以所有的类都有`equals()`方法

- `equals()`是一个方法，而不是运算符，所以基本数据类型无法使用，因为基本数据类型没有`xx.equals()`这种，基本数据类型是没有方法的【为了解决这些类似的麻烦，所以出来了包装类】，故`equals()`只适用于引用数据类型

- 因为大家的`equals()`方法都是从`Object`继承过来的，所以可以进行方法重写，让我们看看`Object`原生的`equals()`方法长什么样的：

  ```java
  public boolean equals(Object obj) {
  	return (this == obj);
  }
  ```

  可以看到`Object`的`equals`原生方法其实本质上就是使用的是运算符`==`，所以没有对`equals`进行方法重写的两个引用数据类型进行比较，比较的还是变量所保存的内存地址是否一致。

  但是像`String`这些，都对`equals()`方法进行了重写，如下：

  ```java
  public boolean equals(Object anObject) {
      if (this == anObject) {
          return true;
      }
      if (anObject instanceof String) {
          String anotherString = (String)anObject;
          int n = value.length;
          if (n == anotherString.value.length) {
              char v1[] = value;
              char v2[] = anotherString.value;
              int i = 0;
              while (n-- != 0) {
                  if (v1[i] != v2[i])
                      return false;
                  i++;
              }
              return true;
          }
      }
      return false;
  }
  ```

  可以看到在`String.equals()`方法中，首先比较的还是变量保存的内存地址是否相同【是否是用一个东西】，然后比较的就是两个字符串的内容是否相同。

  除了`String`重写了`equals()`还有`Date File`以及后续学习的包装类其实都重写了`equals`方法，重写的`equals`方法比较的都是内容是否相同。

回到原先的问题，`==`和`equals`的区别在于：

1. `==`可以比较基本数据类型，但是`equals`不行

2. `==`对于比较基本数据类型比较的是数据值【这里存在类型提升】，而比较引用数据类型的时候比较的是变量保存的地址值

3. `equals()`只能比较引用数据类型，因为只有引用数据类型才可以调用`equals()`方法，所有的类都是继承了`Object`类的，`equals`方法在`Object`类中其实还是使用运算符`==`进行比较的，所以其实大多数类虽然调用的是`equals`方法但是比较的还是变量所保存的内存地址值。像`String Date File`还有包装类这些，重写了`equals`方法，使得比较的时候比较的是内容而不是单纯比较内存地址。

   【所以会不会比较内容其实要看该类是否重写了`euqlas`方法 ---> 仅限有属性的类，否则还是比较的内存地址】

   **<font color="red">小心空指针异常！！！某个引用数据类型如果要调用方法一定不能是`null`</font>**

**习题：**

```java
int it = 65;
int fl = 65.0f;
System.out.println(it == fl);//true 存在自动类型提升
```

```java
char ch1 = 'A';
char ch2 = 12;
System.out.println(65 == ch1);//true
System.out.println(12 == ch2);//true
```

```java
String str1 = new String("hello");
String str2 = new String("hello");
System.out.println(str1 == str2);//false
System.out.println(str1.equals(str2));//false
```

```java
System.out.println("hello" == new Date());//编译不通过，运算符 == 需要两边数据类型相同，就算是基本数据类型也是因为存在类型提升，char 有 ASCII 码值的转换，引用数据类型的两边数据类型你得相同
```

## `toString()`

`toString()`方法在`Object`类中定义，跟`equals`方法一样，所有的类都继承了这个方法，所以可以进行方法重写，而且只有类的实例化对象才可以调用`toString()`方法，很多情况下虽然没有直写`equals`方法，其实多数情况下是省略了。

- 在进行`String`与其他数据类型的连接操作的时候，自动调用了`toString()`方法：

  ```java
  Date now = new Date();
  System.out.println("now" + now);
  //相当于
  System.out.println("now" + now.toString());
  ```

- 可以根据需要在用户自定义类型中重写`toString()`方法，如：`String`类重写了`toString()`方法返回的是字符串值，但是原生的`toString()`方法长这样，返回的是内存地址值：[虽然很明显这里返回的是一个虚假的内存地址值]

  ```java
  public String toString() {
  	return getClass().getName() + "@" + Integer.toHexString(hashCode());
  }
  ```

  而`String`类重写过后的`toString()`长这样[返回常量池字符串本身]：

  ```java
  public String toString() {
  	return this;
  }
  ```

## 面向对象——包装类

包装类：针对八种数据类型定义的引用数据额类型，有了类的特点就可以调用类中的方法

包装类有：`Byte Short Integer Long Character Float Double Boolean`

**`Byte Short Integer Long Float Double`的父类是`Number`类**

**基本数据类型和包装类如何相互转换？**

基本数据类型转换为包装类：调用包装类的构造器【如果你要调用方法的话】

包装类转换为基本数据类型：调用包装类的`xxxValue()`方法，比如：【如果你要进行加减乘除，就无法使用包装类】

```java
Integer integer = new Integer(12);
int i = integer.intValue();

Float f1 = new Float(13.14);
float f2 = f1.floatValue();
```

是不是调用构造器还是调用`xxxValue`的形式都非常麻烦呢？是的，`Java`开发人员也注意到了这一点，所以`JDK 5.0`以后就有了一个新特性：自动装箱和自动拆箱。非常地方便！

自动装箱：【基本数据类型 ---> 包装类】

```java
int num1 = 0;
Integer num2 = num1;

boolean b1 = true;
Boolean b2 = b1;
```

自动拆箱：【包装类 ---> 基本数据类型】

```java
int num3 = num2;
boolean b3 = b2;
```

因为有了自动装箱和自动拆箱，所以你完全可以把包装类和基本数据类型看成是一个整体。

**基本数据类型和包装类如何转换为`String`？**

1. 直接进行连接运算：

   ```java
   int num = 1;
   String numString = "" + num;
   
   Integer integer = new Integer(12);
   String integerString = "" + integer;
   ```

2. 调用`String.valueOf()`方法

   ```java
   int num1 = 10;
   String num1String = String.valueOf(num1);
   
   Integer integer = new Integer(12);
   String integerString = String.valueOf(integer);
   ```

**`String`类型如何转换为基本数据类型/包装类？**

错误的情况【上来直接强制转换是错误的做法！！！】：

```java
String str = "123";
int num1 = (int)str;//编译错误！！！
Integer integer = (Integer)str;//编译错误！！！
```

正确的做法【调用包装类的方法】：

```java
String str1 = "123";
String str2 = "13.14";

Integer integer = Integer.parseInt(str1);
Double d = Double.parseDouble(str2);

System.out.println(integer + " "+ d);
```

**习题：**

下面两段代码输出结果一样吗？各是什么？

```java
Object o1 = true ? new Integer(1) : new Double(2.0);
System.out.println(o1);
```

```java
Object o2;
if (true) {
    o2 = new Integer(1);
} else {
    o2 = new Double(2.0);
}
System.out.println(o2);
```

**<font color="red">这道题我不会</font>**

答案非常的神奇，第一个打印出来的是`1.0`第二个打印出来的是`1`！神奇！第一个打印出来的竟然是`1.0`，三元运算符运算时存在数据类型的提升，不管是`true`的结果还是`false`的结果都需要进行编译。

<hr/>

```java
public void method1() {
    Integer i = new Integer(1);
    Integer j = new Integer(1);
    System.out.println(i == j);//false
    
    Integer m = 1;
    Integer n = 1;
    System.out.println(m == n);//true
    
    Integer x = 128;
    Integer y = 128;
    System.out.println(x == y);//false
}
```

全部答对，`Integer`在比较的时候，如果是`new`出来的，那自然是比较地址，但是如果是直接赋值的，那么倘若这个数在`-128 ~ 127`之间也就是`byte`数据类型的取值范围的时候，都会直接比较数值。

因为是直接赋值，按理来说，只有基本数据类型才可以自动赋值，所以这里是将基本数据类型转换为了引用数据类型，则包装类会按理来说会调用构造器，但其实不是，这里其实会调用：`Integer.valueOf()`方法，`valueOf()`在前面的包装类/基本数据类型转换为字符串的时候有使用过，这里的用法差不多，是将基本数据类型转换为引用数据类型：

```java
public static Integer valueOf(int i) {
    if (i >= IntegerCache.low && i <= IntegerCache.high)
        return IntegerCache.cache[i + (-IntegerCache.low)];
    return new Integer(i);
}

private static class IntegerCache {
    static final int low = -128;
    static final int high;
    static final Integer cache[];
    static {
        // high value may be configured by property
        int h = 127;
        String integerCacheHighPropValue =
            sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.hig
        if (integerCacheHighPropValue != null) {
            try {
                int i = parseInt(integerCacheHighPropValue);
                i = Math.max(i, 127);
                // Maximum array size is Integer.MAX_VALUE
                h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
            } catch( NumberFormatException nfe) {
                // If the property cannot be parsed into an int, ignore it.
            }
        }
        high = h;
        cache = new Integer[(high - low) + 1];
        int j = low;
        for(int k = 0; k < cache.length; k++)
            cache[k] = new Integer(j++);
        // range [-128, 127] must be interned (JLS7 5.1.7)
        assert IntegerCache.high >= 127;
    }
    private IntegerCache() {}
}
```

可以看到在`valueOf()`缓存了个`cache`，只要在`-128 ~ 127`【这个范围的数用得非常频繁，所以才做了个缓存】之间就是直接从缓存中拿数据。目的就是为了提高效率。

# 2022年06月06日下午

## 复习

1. 如何实现向下转型？需要注意什么问题？如何解决此问题？

   > 向下转型就是之前说的强制转型，需要注意的问题就是精度丢失问题，如何解决这个问题只能在写的时候更小心。如果是引用数据类型的向下转型，就是父类转换成子类，也可以说是向下转型，需要注意的是有可能转不成的问题即：`ClassCastException`，如何解决这个问题？需要使用`instanceof`关键字判断到底是不是属于向下转型那个类的对象，如果属于才转，不属于就不转。

2. `==`和`equals`有什么区别？

   > `==`不仅可以用于基本数据类型，还可以用于引用数据类型，而且用于基本数据类型的时候存在自动转型的一种现象，比方说`int`类型的会转换为`double`类型的，而对于引用数据类型，`==`比较的就是变量所保存的内存地址。
   >
   > 对于`equals`来说，这是一个方法，原生的东西在`Object`类，因为所有的类都继承于`Object`类，所以所有的类相当于都有了`equals`方法，在`Object`类的`equals`方法其实还是使用运算符`==`的，比较的还是内存地址，但是有的类它对`equals`方法进行了方法重写，比如：`String Date File`还有包装类他们都对`equals`方法进行了重写，他们先是比较的是内存地址，然后再比较的是内容，也就是说只要内容相同他们就认为这两个是同一个东西。
   >
   > 很多人经常答错这道问题，是因为大多数人认为`equals`一上来就是比较内容的，其实不然，`equals`实际上还是`==`只不过某些类对它进行了方法重写。

3. 基本数据类型、包装类与`String`三者之间是如何相互转换的？

   > 基本数据类型转换为包装类，常使用的是**构造器的方法**，其实还有一种方法就是**使用：`包装类.valueOf()`这个方法**，反过来，包装类转换为基本数据类型常使用的是：`xxx.xxxValue()`调用的是`xxxValue()`的方法。在`JDK 5.0`之后呢，就出现了新特性：**自动拆箱和自动装箱**，所以后续完全可以将基本数据类型和包装类看成是同一种东西，那么就只需要关心基本数据类型/包装类是如何跟`String`进行相互转换的呢？
   >
   > 基本数据类型/包装类转换为`String`：可以使用连接符、还可以使用`String.valueOf()`的方式
   >
   > `String`转换为包装类/基本数据类型：可以使用`Integer.parseIn("字符串")`这种方式

## `static`关键字

- 我们在编写类的时候，其实都是在对对象的属性和行为进行描述，只有在使用了关键字`new`的时候我们才会在堆内存空间中开辟一块内存创建出一个对象，方法才能供外部使用。但是有些时候我们会发现，有些属性或者方法是公共的，如果每次都在创建对象的时候就给这些公共的属性/方法开辟内存，那么就会导致大量的内存空间浪费，所以我们希望有些公共数据在内存空间中只占据一份，而不是创建一个对象就分配内存。

- 就好比如：每个中国人都只有一个国家，那就是中国，我们无需在创建一个中国人的时候就又单独创建中国。

- 那么我们要怎么做，怎么在原先对对象的描述加以改进呢？怎么才能让原本只要创建了一个对象就会分配一块内存空间给公共属性/方法变成所有的对象共享这个公共的东东，只开辟一块内存呢？这就需要用到`static`关键字，`static`就是用来干这件事情的。

`static`的意思是：静态的，它可以用来修饰属性、方法、代码块、内部类。

**`static`修饰属性：<font color="deepskyblue">将属性也就是变量【统称为成员变量】，划分为：静态变量【类变量】 + 实例变量【非静态变量】，静态变量就是公共的，不管你创建了多少个对象，在内存里头只开辟一块空间，存放在方法区中，随着类的加载而加载，而非静态变量也就是实例变量是你创建了多少个对象就会开辟多少个内存，存放在堆内存中，随着对象的创建而创建。</font>**

类的加载是早于对象的创建的，并且只会加载一次，这也就是为什么静态变量【类变量】只会在内存开辟一个空间。也正因为静态变量早就在类加载的时候就加载了，所以可以通过类.静态变量的方式还可以通过对象.静态变量使用类变量，但是后者没什么意义。

**`static`修饰方法：静态方法，也是随着类的加载而加载，可以通过`类.静态方法`的方式进行调用，当然你也可以通过`对象.静态方法`的方式进行调用，但是这样做没有意义**

## 类变量和实例变量的内存解析

方法区：类的加载信息、静态域、常量池

堆内存：对象 --- 包括实例变量

栈内存：局部变量

## 单例设计模式

设计模式其实就是套路就是模板。常见的设计模式一共有`23`种。所谓单例模式就是单个实例的模式，意思就是整个程序只有一个对象。如何实现呢？

1. 首先将类的构造器的访问权限修改为：`private`
2. 外部无法创建但是内部可以，所以需要在类内部使用静态方法供其外部调用获取到对象，因为只有一个对象，又因为静态方法内部无法使用实例变量，所以类属性也需要是静态的

- 饿汉式单例模式：【定义一个静态对象然后返回这个静态对象，比较饥渴上来就`new`一个对象】

  ```java
  private static Test test = new Test();
  
  private Test() {
  }
  
  public static Test getObject() {
      return test;
  }
  ```

- 懒汉式单例模式：【每次要创建都判断定义的对象是不是`null`，如果是就`new`一个不是的话就直接返回，太懒了，你要的话我才给你】

  ```java
  private static Test test = null;
  
  private Test() {
  }
  
  private static Test getObject() {
      if(test != null) return test;
      else return new Test();
  }
  ```

- **饿汉式单例模式和懒汉式单例模式的区别：**其实这两者饿汉式单例模式上来就把对象给早好了，分配了内存空间，那万一我不用呢？这就很浪费很没必要。而懒汉式单例模式，在需要的时候才创建对象，这样做不会浪费内存空间。所以懒汉式单例模式会更好，因为延迟了对象的创建，可以节省不必要的空间，**所以从考虑内存空间这个角度上来看我们优先使用懒汉式单例模式。**

- 那饿汉式就没有什么好处吗？有的，**饿汉式单例模式天然就是线程安全的**。若是懒汉式单例模式，如果那一瞬间有几十亿个用户同时访问，并且速度非常快，懒汉式单例模式判断完毕到底`test`是不是`null`，但是还没来得及返回`test`，第二个来判断的时候依然是`null`，那就会导致又`new`了一个，所以说**懒汉式单例模式是线程不安全的。如果要写的话，需要加以改进，使其变成线程安全的懒汉式单例模式。**

- **<font color="red">单例模式的好处在于：</font>**只生成了一个实例，减少了系统性能开销，当一个对象的产生需要花费比较多的资源的时候，就可以通过在应用启动的时候直接生产一个单例对象，然后永久驻留在内存的方式来解决系统资源开销问题。`java.lang.Runtime`就是一个典型的单例对象。

- 其实单例模式我们也有使用过，最常用的就是数据库连接池，物品们只需要一个连接池。
- 还有像网站计数器，也是只要一个就可以了。
- 还有应用程序的日志应用，也是一个即可。
- 再比如`Windows`操作系统的任务管理器、回收站也都是单例模式。

## 理解`main`方法的语法

```java
public static void main(String[] args) {}
```

`main`方法被`static`关键字修饰，证明该方法是一个类方法，随着类的加载而加载，并且不返回数据，其形参是一个字符串数组，且是一个公共方法。

## 代码块

- 代码块的结构：`{}`

- 代码块的作用：用于初始化类和对象

- 代码块只能使用`static`用来修饰，表示静态代码块，没有使用`static`修饰的叫做非静态代码块，**<font color="red">静态代码块随着类的加载而执行。</font>**而非静态代码块是随着对象的创建而执行的，**<font color="red">并且每创建一个对象都会执行一次代码块。除此之外还有很重要很重要很重要的一点！！！！！！！！！！就是代码块会先执行然后才会执行构造器！！！！代码块先执行然后才执行构造器！！！</font>**

  ```java
  public class FieldMethodTest {
      public FieldMethodTest() {
          System.out.println("这是构造器！");
      }
  
      public static void main(String[] args) {
          FieldMethodTest fieldMethodTest = new FieldMethodTest();
      }
  
      static {
          System.out.println("这是静态代码块！");
      }
  
      {
          System.out.println("这是非静态代码块！");
      }
  }
  
  输出：
      这是静态代码块！
  	这是非静态代码块！
  	这是构造器！

- 所以总的执行顺序是这样的：【如果有多个代码块将按照声明的先后顺序执行（没有必要造多个代码块，因为跟放在一个代码块没什么区别）】
  - **静态代码块 > 非静态代码块 > 构造器**

## 属性赋值的先后顺序

默认初始化 > 代码块/显式初始化 > 构造器中初始化 > 对象初始化。

也就是说其实显式初始化和代码块初始化是按照程序的先后位置看属性赋值先后顺序的，地位是同等的。

## `final`关键字

`final`表示最终的，它可以修饰：类、属性、方法。

- 当`final`修饰一个类时：则表示这个类是一个最终类，则表示这个类绝了到头了，**无法被继承**。不玩弄的说就是：`final`表示这个类是最终类，则它的方法、属性都是定义好无法被修改的，而如果被继承的话，子类是可以对父类方法进行重写的，那这就违背了最终的意思。所以如果用`final`修饰类则该类无法被继承。

  `Java`中有些源码类就是被`final`修饰的，比如：`String`类，`System`类，`StringBuffer`类。因为这些类已经写得很完善了，无需方法重写，没有那个必要。

- 当`final`修饰一个方法时：则表示这个方法是一个最终方法，**表明该方法无法被重写**。

  `Object`类中的`getClass()`方法就被`final`修饰了，表明无法被重写，因为这个方法只有这种搞法，无需重写，没那个必要。可以发现有一个`native`，`native`的意思就是接下来要调用的底层的`C/C++`了。

- 当`final`修饰一个变量时：则表示这个变量是一个常量。可以考虑给一个常量赋值的地方有：

  1. 显式初始化
  2. 代码块中初始化
  3. 构造器中初始化

  `final`修饰变量的时候通常跟`static`一起使用，这样只用在内存开辟一块内存空间就可以了，**表示全局常量**。也可以一起修饰方法。

  `static`：只能修饰属性 方法 代码块 内部类

  `final`：只能修饰类 属性 方法

**习题：**

1. 排错：这里`final`修饰了形参`x`，那么就不能改变它的值，传进来是什么就是什么，无法改变

   ```java
   public class Something {
       public int addOne(final int x) {
           return ++x;
           //return x + 1;这个正确
       }
   }
   ```

2. 排错：`o.i++`这样子做是对的，因为`o`其实也是个变量，它只要保存的内存地址没有变那就没关系。但是如果改成：`o = new Other();`那就是错误的。

   ```java
   public class Something {
       public static void main(String[] args) {
           Other o = new Other();
           new Something().addOne(o);
       }
       
       public int addOne(final Other o) {
           //o = new Other();
           o.i++;
       }
   }
   calss Other {
       public int i;
   }
   ```


# 2022年06月07日下午

## 复习

1. `static`关键字修饰的属性，相较于实例变量有哪些特别之处？

   > 1. 随着类的加载而加载，创建的时间早于对象创建的时间
   > 2. 可以通过`类.`和`对象.`的方式进行调用
   > 3. 存在于方法区的静态域中

2. `final`可以用来修饰哪些结构，分别表示什么意思？

   > 1. 可以用来修饰类，表示该类无法被继承【因为是最终类，所以方法无法被重写，所以无法被继承】
   > 2. 可以用来修饰方法，表示该方法无法被重写
   > 3. 可以用来修饰属性，表示常量

3. 代码实现单例模式的饿汉式【线程安全】

   ```java
   private Test test = new Test();
   
   private Test() {
   }
   
   public Test getTest() {
       return test;
   }
   ```

4. 代码实现单例模式的懒汉式【线程不安全】

   ```java
   private Test test = null;
   
   private Test() {
   }
   
   public Test getTest() {
       if(test == null) return new Test();
       else return test;
   }
   ```

5. 类的属性赋值的位置有哪些？先后顺序为何？

   > 1. 默认初始化
   > 2. 显式初始化
   > 3. 代码块初始化
   > 4. 构造器初始化
   > 5. 通过对象.属性的方式赋值

## 抽象类与抽象方法

随着继承层次中一个个新子类的定义，也就是说类的数量越来越多了，类也变得越来越具体，而父类则更一般更通用。类的设计应该保证父类和子类可以共享特征，所以有时候会将父类设计得非常得抽象，抽象到什么地步呢？抽象到没有具体的实例【也就是无法实例化对象】，那么这个类就叫做**<font color="red">抽象类</font>**。

**总结：无法实例化对象的类就叫做抽象类。被`abstract`关键字修饰的类就表示该类是一个抽象类。**

含有抽象方法的类必定是一个抽象类，但是抽象类不一定含有抽象方法，只要被`abstract`关键字修饰的类就叫做抽象类。一个子类如果继承了一个抽象类，那么它必须实现所有的抽象方法，否则无法实例化对象。抽象类是允许有构造器，便于子类的实例化调用。**<font color="red">根据多态机制，子类实例化的时候也会实例化抽象类。所以抽象类也是可以实例化的！跟我们平常 new 的实例化有所不同！千万注意！</font>**

抽象方法默认的写法是：`public abstract`

关于`abstract`的注意点：

1. **`abstract`关键字不能用来修饰属性、构造器等结构【也就是说只能修饰类、方法】**

2. **`abstract`关键字不能用来修饰私有方法**，因为被`abstract`修饰的方法必定需要被实现【方法重写】才有意义，如果你是一个私有方法那就无法被方法重写，也就无法被实现，那什么事情都做不了也就失去了存在的意义

3. **`abstract`关键字不能用来修饰`static`修饰的静态方法**，因为静态方法是随着类的加载而加载的，而被`abstract`关键字修饰的方法只有被重写才有意义，但是静态方法因为随着类的加载而加载，它并不关父类的事情，但是它可以找得到父类的东西。这里涉及到`JVM`的底层知识，以现在的知识无法讲清楚，但是可以通过一个多态的例子来说明：

   ```java
   public class Father {
       public static void method() {
           System.out.println("This is a Father method.");
       }
   }
   
   class Son extends Father {
       public static void method() {
           System.out.println("This is a Son method");
       }
   
       public static void main(String[] args) {
          Father son  = new Son();
          son.method();
       }
   }
   ```

   上述代码如果`method`重写了的话，那么调用的时候肯定是打印`Son`中的，但是现在这里打印的是`Father`中的，也就是说静态方法看似被重写了，其实并没有。那暂时就先记住，静态方法看似重写实则没有重写，而被`abstract`修饰的方法是必须被重写才有意义的，所以`abstract`关键字无法修饰静态方法

4. **`abstract`关键字不能用来修饰`final`修饰的最终方法以及最终类**，因为`final`修饰的方法表示最终的，无法被子类重写，那就与被`abstract`关键字修饰的方法必须被重写是相互违背的，所以`abstract`无法修饰被`final`关键字修饰的方法，相应的也无法修饰被`final`修饰的类，因为无法被继承。

抽象类的匿名子类对象：

```java
Father father = new Father() {
    @Override
    public void method() {
        System.out.println("This is a FFF method.");
    }
};
```

## 模板方法设计模式

抽象类体现的就是一种模板方法的设计模式，抽象类可以作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但是子类总体上会保留抽象类的行为方式。

**也就是说大框架固定好，内部很容易变化的部分就抽象出来，供不同的子类实现，**这就是一种模板方法的设计模式。

## 接口

- 接口时比抽象类还要抽象的类，它里面全都是抽象方法。接口的出现是为了解决`Java`类单继承的问题，因为接口是可以被多个类实现的，抽象类是可以有具体被实现的方法的，但是接口不行。
- 说白了，接口就是一种规范，一种法律，你要想实现我，然后实例化你就必须实现我所有的抽象方法才可以。

接口中的属性默认是静态常量：`public static final int A = 1;`

接口中的方法默认是公共抽象方法：`public abstract void B();**`**

**<font color="red">相比于抽象类，抽象类是有构造器的，但是接口不允许有构造器，因为接口比抽象类还要抽象，抽象类可以通过多态机制实现间接实例化，但是接口无法被实例化【这里暂且忽视掉匿名内部类】，因为它压根就没有构造器！</font>**

实现了一个接口的类必须对接口中所有的方法进行方法重写，否则它只能加上一个`abstract`表示这是一个抽象类而无法被直接实例化。

关于接口还有一个比较特殊的点就是：

**接口是为了解决类的单继承所诞生的东西，所以一个类可以实现多个接口，那接口与接口之间呢？**

**<font color="red">接口与接口之间可以实现多继承！也就是一个接口是可以继承多个接口的！</font>**

**习题：**

1. 排错：编译错误，接口`A`和类`B`都声明了属性`x`，`pX()`方法中不知道到底要用哪个

   可以改成：`A.x`或者`super.x`

   ```java
   interface A {
       public static final int x = 0;
   }
   
   class B {
       int x = 1;
   }
   
   class C extends B implements A {
       public void pX() {
           System.out.println(x);
       }
       
       public static void main(String[] args) {
           new C().pX();
       }
   }
   ```

## 代理模式设计模式

代理模式是`Java`开发中比较常用的设计模式，前面我们学习了：单例模式【懒汉式、饿汉式】还有模板方法设计模式。这些都是常用的设计模式。代理模式这种设计模式就是为其他对象提供一种代理以控制对这个对象的访问。所谓代理其实就是中介。**其实就是把本身`A`要做的事情，`B`把它给做了。**比如这里：`ProxyServer`做了检查但是`Server`并没有做检查，这就是代理。

```java
public interface Network {
    public abstract void work();
}

class Server implements Network {
    @Override
    public void work() {
        System.out.println("服务器完成联网，开始工作...");
    }
}

class ProxyServer implements Network {

    private Server server = null;

    public ProxyServer(Server server) {
        this.server = server;
    }

    public void check() {
        System.out.println("完成联网前的设备检查...");
    }

    @Override
    public void work() {
        check();
        server.work();
    }
}

class Test {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.work();
    }
}
```

代理模式的应用场景：

1. 安全代理：屏蔽对真实角色的直接访问
2. 远程代理：通过代理类处理远程方法调用
3. 延迟加载：先加载轻量级的代理对象，当真正需要的时候再加载真实对象。比如你想要打开一个大文档，里面包含了图片，这时你就可以使用代理模式，用`proxy`打开大图片，只有真正要打开的时候再打开。

代理分为两种：静态代理 + 动态代理【后续学习】

## 工厂模式设计模式

实现了创建者和调用者的分离，你工厂我要的时候你就给我搞个对象，别跟我说别的。比如我要一辆奥迪车你就给我奥迪车，我要马丁你就给我马丁，你一个工厂类给我搞全部。

## 内部类

以一个简单的例子说明内部类的作用：

现在你有一个`Person`类，它有一些变量诸如：`String name; int age;`这些都好理解，但是现在我想植入一个大脑，用属性吧，觉得太简单了无法达到要求，用方法吧又不太合适，这时候用内部类就是一个很好的选择。

类内可以定义属性

内部类的分类：**成员内部类 `VS` 局部内部类**

局部内部类：方法里面声明、代码块内声明、构造器【也是方法】中声明

成员内部类：静态成员内部类、非静态成员内部类【作为外部类的成员】

```java
静态内部类：
	Person.Dog personDog = new Person.Dog();
非静态内部类：
    Person person = new Person();
	Person.Bird bird = person.new Bird();
```

# 2022年06月07日晚上

## 复习

1. **`abstract`关键字能修饰哪些结构？修饰以后，有什么特点？**

   `abstract`关键字可以修饰类和方法，修饰类该类就是一个抽象类，修饰方法以后该类就是一个抽象方法，抽象类可以有抽象方法也可以有实现方法，它可以通过多态机制间接实例化，抽象方法必须被重写才有意义，所以继承抽象类的子类需要对抽象方法都进行了重写之后才能实例化，否则也只能是一个抽象类。

2. **接口是否能继承接口？抽象类是否能实现接口？抽象类是否能继承非抽象的类？**

   接口可以继承接口而且还是多继承，抽象类可以实现接口，抽象类可以继承非抽象的类。

3. **抽象类和接口有哪些共同点和区别？**
   - 接口是比抽象类还要抽象的类、
   - 接口没有构造器但是抽象类有，抽象类可以通过子类间接实例化，但是接口不行
   - 接口内的方法全部都是抽象方法，但是抽象类可以含有具体实现的类并且可以没有抽象方法。
   - 接口跟接口之间可以多继承，并且一个类可以实现多个接口但是只能继承一个抽象类

# 2022年06月08日上午

## 异常

异常可以分为两类：`Error`和`Exception`，其中`Error`表示的是`Java`虚拟机无法解决的问题，比如栈溢出错误和`OOM`错误，而`Exception`指的是不可预知造成的一般性错误，比如说数组下标越界、空指针异常等【比较经典的还有除0`Exception`】。

遇到错误的两种解决办法：【理想发现错误的时机就是编译阶段】

1. 遇到错误就终止程序的运行
2. 程序员在编写程序的时候就考虑到错误的检测、错误消息的提示以及错误的处理

常见的编译时异常【受控异常`checked`】：`IOException ---> FileNotFoundException`以及`ClassNotFoundException`等

常见的运行时异常【非受控异常`unchecked`】：`NullPointerException、ArrayIndexOutOfBoundsException、NumberFormatException`

处理异常的方式：`try-catch-finally【方法体内】`以及`throws异常【类】`，一般使用`try-catch`我们是用来处理编译时一场，前者是真的处理了异常，但是`throws`只是将异常抛给了方法的调用者，并没有真正的将异常处理掉。`throw`用于抛出异常。

**<font color="red">`finally`中声明的是一定会被执行的代码，通常用于资源的释放，即使`try`跟`catch`里面都有`return`语句但是依然会执行`finally`中的代码</font>**

```java
public class SomeElse {
    public static void main(String[] args) {
        System.out.println(method());
    }

    public static int method() {
        try {
            return 1/0;
        } catch (Exception exception) {
            return 0;
        } finally {
            System.out.println("这是 finally 就算 try catch 有 return 也是必定会执行的！");
        }
    }
}
```

- 还记得方法重写中有这么一条规则：进行方法重写的子类方法抛出的异常不能比父类的异常范围大

  这是什么原因呢？原因就是：`try --- catch --- finally`中，假设现在父类方法捕获的异常为`IOException`，但是在重写的方法中捕获的异常为：`Exception`，此时父类方法就无法罩住子类异常。

  如果父类没有异常那子类绝不允许抛出异常。

- 运行时异常必须显示处理。

- 自定义异常：【异常的顶层是一个叫`Throwable`的类，再往上就是`Object`类了】

  ```java
  public class MyException extends RuntimeException {
      static final long serialVersionUID = -7034897190745766939L;
  
      public MyException() {
      }
  
      public MyException(String msg) {
          super(msg);
      }
  }

**习题：**判断程序的输出结果

```java
public class ReturnExceptionDemo {
    static void methodA() {
        try {
            System.out.println("进入方法A");
            throw new RuntimeException("制造异常");
        } finally {
            System.out.println("方法A中的finally");
        }
    }
    
    static void methodB() {
        try {
            System.out.println("进入方法B");
            return;
        } finally {
            System.out.println("方法B中的finally");
        }
    }
    
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        methodB();
    }
}
```

将会输出：

> 进入方法`A` 
>
> 方法`A`中的`finally`
>
> 制造异常
>
> 进入方法`A` 
>
> 方法`A`中的`finally`

**`final finally finalize`三者的区别？**

- `final`是一个关键字，它可以修饰类、方法、属性，修饰类跟方法的时候不能跟`abstract`连用，表示最终的，被修饰的类和方法一个无法被继承一个被重写，修饰属性时，该属性通常被看作是一个常量。
- `finally`是`try --- catch --- finally`结构中的，`finally`是无论如何都会执行的，即使`try catch`中有`return`语句，通常在`finally`做的工作是：释放资源。
- `finlize`是一个方法，它的作用是通知垃圾回收器可以进行回收了，但是也只是起到一个通知的作用，而不是调用垃圾回收器。

**`throw`和`throws`的区别：**

- `throw`表示抛出一个异常类的对象，声明在方法体内
- `throws`表示的是一种异常处理的方式，将异常抛给调用者去处理，声明在方法声明处

## 多线程

### **<font color="deepskyblue">程序、进程、线程</font>**

**程序：**为了完成特定任务某种语言编写的一组指令的集合。

**进程：**是程序的依次执行过程，或者是正在运行的一个程序。存在生命周期：产生、存在、消亡。进程要想运行，需要在内存中加载运行进程的相关数据。

**线程：**是进程的细化，若一个进程同一时间并行多个线程，那么这个进程就是支持多线程的。线程作为调度和执行的最小单位，每个线程拥有独立的运行栈和程序计数器`PC`，线程与线程之间对于栈内存空间中的数据不共享，堆内存和方法区中的数据是共享的。也就是说 —— **<font color="red">每个线程有一个独立的栈内存空间、程序计数器</font>**，堆内存和方法区一个进程有一个。**`JVM`调优就是针对共享区域即：堆内存和方法区进行调优的。**

因为堆内存和方法区的内存空间是共享区域，所以多线程就必然导致线程安全问题。

<hr/>

### **<font color="deepskyblue">关于单核`CPU`和多核`CPU`的理解</font>**

最近刚好也正在学习操作系统，我们知道单核`CPU`其实在一个时间单元内一次只能处理一个线程，只能做到并发，但是多核`CPU`因为处理器数量增加了，所以一个计算机一个时间单元内一次可以处理多个线程，做到真正意义上的多线程。单核`CPU`因为操作系统有并发机制，并且时间很快，看起来是并行的，其实是一个假的`多线程`。【目前的计算机基本都是多核的】

**一个`Java`应用程序最少有三个线程：`main`主线程、`gc`垃圾回收线程、异常处理线程。如果发生异常会影响主线程。**

<hr/>

**背景：**单核`CPU`的情况下，因为线程之间的切换、操作系统处理中断程序等都存在一定的时间/资源开销，所以单个线程完成多个任务，肯定比多个线程完成使用的时间更短。比如单个线程完成一个任务需要一分钟，所以完成十个任务就需要十分钟。而多个线程完成十个任务，本来可以十分钟完成的事情，但是因为存在线程之间的切换时间，所以其用时会超过十分钟。【多核`CPU`可能会快一些】

**<font color="red">那既然花费的时间变长了，为何还需要多线程呢？</font>**

- 因为使用多线程可以提高应用程序的相应，对于图形化用户而言可以增强用户体验。
- 提高计算机`CPU`的利用率
- 改善程序结构，原本很长又复杂的进程分为多线程独立运行，便于理解和修改。

**<font color="red">何时使用多线程？</font>**

- 只要一个程序需要同时执行多个任务就要用到多线程，或者后台需要的程序
- 程序需要实现一些等待任务的时候，比如等待用户输入、文件读写、网络操作等

<hr/>

### **<font color="deepskyblue">线程的创建和使用</font>**

**第一种方式**：继承`Thread`类的方式创建线程【继承类，重写`run()`方法】

- 【如果只是单纯调用`run()`方法是达不到多线程的效果的，这相当于只是单纯调用了一个方法。】
- 【不可以让已经启动的线程再一次`start`，这样会造成：`IllegalThreadStateException`，如果想要多线程需要再造一个实例化对象】

```java
//只用一次所以可以采用匿名内部类的方式直接写
public class MoreThread extends Thread {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 101; i++) {
                    if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + " = " + i);
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 101; i++) {
                    if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + " = " + i);
                }
            }
        }.start();
    }
}
```

`Thread`类常用方法：

1. `start()`：启动当前线程，调用线程中的`run()`方法 
2. `run()`：通常需要重写此类方法，这里就是线程需要执行的动作
3. `currentThread()`：静态方法，获取当前线程
4. `sleep()`：静态方法，进入休眠状态
5. `getName()`：获取当前线程的名称
6. `setName()`：设置当前线程的名称
7. `yield()`：线程让步，释放当前`CPU`的执行权
8. `join()`：调用方法的线程进入阻塞状态，让其它线程先行完成任务，比如在线程`a`中调用：`b.join()`则`a`会进入阻塞状态一直等到线程`b`执行完毕

<hr/>

### **<font color="deepskyblue">线程的调度</font>**

调度策略：时间片策略 + 抢占式策略 ---> 高优先级的线程抢占`CPU`时间片

`Java`调度方法：

- 同优先级的线程组成先进先出队列，使用时间片策略。
- 高优先级的线程使用优先调度的抢占`CPU`的抢占式策略，但是优先级高的只是抢夺到`CPU`时间片概率比较大而已，并不意味着一定先执行

线程的优先级：

- `MAX_PRIORITY 10`：线程最高优先级
- `MIN_PRIORITY 1`：线程最低优先级
- `NORM_PRIORITY 5`：线程默认优先级

获取和设置线程的优先级：`Thread.currentThread().setPriority() + Thread.currentThread().getPriority()`

<hr/>

三个窗口同时售卖`100`张票：【这里如果把`ticket--`单独放一行会导致线程安全问题】

```java
public class MoreThread extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + " : Ticket :" + ticket--);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        MoreThread moreThread1 = new MoreThread();
        MoreThread moreThread2 = new MoreThread();
        MoreThread moreThread3 = new MoreThread();
        moreThread1.setName("1 号窗口");
        moreThread2.setName("2 号窗口");
        moreThread3.setName("3 号窗口");
        moreThread1.start();
        moreThread2.start();
        moreThread3.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}
```

<hr>

**第二种方式**：实现`Runnable`接口的方式创建线程【实现接口，实现`run`方法，将该对象传递到`Thread`构造器里头】

```java
public class MoreThread extends Thread {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        Thread thread = new Thread(myThread3);
        thread.start();
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}
```

<hr/>

### **<font color="deepskyblue">第一种[继承]和第二种[接口]创建线程的方式有什么区别呢？</font>**

总的来说，面向接口编程会更好一些，优点如下：

1. 可以解决单继承的问题
2. 使用`Runnable`接口方式实现多线程天然的解决了数据共享的问题

相同点：两种方式都需要重写`run()`方法，将线程要执行的操作写在`run()`方法中。

# 2022年06月09日上午

## 线程的生命周期

`Thread.State`内部类【枚举】定义了线程的生命周期状态。在一个线程完整的生命周期一共会经历`5`个状态：新建、就绪、运行、阻塞、消亡。

- 新建 ---> 就绪 <---> 运行 ---> 消亡
- 新建 ---> 就绪 <---> 运行 ----> 阻塞 ---> 就绪 ---> 运行 ---> 消亡
- 新建 ---> 就绪：`start()`方法
- 就绪 ---> 运行：获取`CPU`执行权
- 运行 ---> 就绪：失去`CPU`执行权或者`yield()`
- 运行 ---> 消亡：线程执行完毕`run()`方法【正常消亡】 + 线程调用`stop()`方法强杀【强制消亡】 + 出现`Exception/Error`但无处理【异常消亡】
- 运行 ---> 阻塞：阻塞不是最终状态，消亡才是，消亡是线程的最终归宿。
  - 调用`Thread.sleep(long time);`
  - `join()`方法也会令线程阻塞，当你在线程`a`中调用`b.join()`，则阻塞的是`a`，此时`a`会一直阻塞直到`b`运行完毕。
  - 等待同步锁
  - 某个线程调用`wait()`也会进入阻塞状态
  - 某个线程调用`suspend()`表示挂起，但是已经不再建议使用了，但是你得直到调用`suspend()`方法会使线程进入阻塞状态
- 阻塞 ---> 就绪：
  - `Thread.sleep()`时间到了
  - `join()`加入的线程执行完毕
  - `notify()/notifyAll()`唤醒某个线程
  - 获取到同步锁
  - `resume()`跟`suspend()`搭配使用，结束线程挂起状态

## 线程的同步

前面写三个窗口同时售票就出现了线程安全问题 ---> 线程安全问题是多线程导致的

- 多线程必然会导致一些数据的共享，正是因为共享数据所以才会导致线程安全的问题
- **多线程 ---> 数据共享 ---> 线程安全**，加入`Thread.sleep()`会大大提升出现线程安全问题的概率，也就是说线程安全原先就存在，只不过出现的概率增大了而已，还是那句话，多线程必然导致数据共享，数据共享就必然导致线程安全的问题。

设想：既然是多线程的数据共享导致线程不安全问题的出现，那么如果**<font color="ayellow">某个线程在操作某个共享数据的时候，其它线程不让它参与进来不就可以解决这个问题吗？</font>**

- 方式一：同步代码块【使用这种同步锁，相当于一种单线程的运行方式】

  > ```java
  > synchronized(同步监视器) {
  > ​	//需要被同步的代码
  > }
  > ```
  >
  > - 同步监视器：俗称锁，**任何一个类的对象，都可以充当锁**。**<font color="red">注意！同步监视器是一个对象！！！不是一个变量！！！【发现自己写代码的时候只记住是唯一，但是往往忘了是要一个对象！】</font>**但是有个要求：多个线程必须共用一把锁，如果每个人都有一把锁，那谁都可以上锁也就失去了锁的意义。
  >
  >   所以充当锁的对象不适合放在`run()`方法里头，因为这样做会导致每个线程都有一把锁，**<font color="red">必须保证锁的唯一性，锁才有意义</font>**。
  >
  > - 需要被同步的代码：指的是**对共享数据的操作，是操作，操作**
  >
  > - 共享数据：多个线程共同操作的变量。比如三个窗口一起售卖的`ticket`
  >
  > - **<font color="deepskyblue">如果是`Runnable`实现多线程，在`synchronized(同步监视器)`同步监视器里头加入的是`this`，因为接口方式在实例化的时候只有一个，所以相当锁只有一个，是可以这么做的。</font>**
  >
  > - **<font color="deepskyblue">如果是继承方式，则最好是新建一个对象，使其锁唯一，或者可以使用：`Windows2.class`【这只是个例子也间接说明了类也是对象`Class`对象】</font>**

- 方式二：同步方法

  > 如果需要进行同步的代码刚好是一个完整的方法，那么我们就可以将其设为同步方法。
  >
  > 1. 实现`Runnable`接口方式的多线程实现同步方法
  >
  >    例子：`private synchronized void show(){} `，这里的的同步监视器相当于是：`this`
  >
  > 2. 实现继承方式的多线程实现同步方法
  >
  >    例子：`private synchronized void show(){}`，这样写是错误的，因为是继承的方式，所以有多个线程，而实现接口的方式天然的解决了共享数据的方式，因为锁只能有一把，如果直接这样写的话，默认就是给`this`上锁，这里每个线程都是一个`this`，很明显不行。
  >
  >    对象是多个的，但是类是唯一的，那么就有一个唯一的类对象，使用`static`关键字使得`synchronized(同步监视器)`的锁的是一个类对象，这样锁就是唯一的。
  >
  >    ```java
  >    package Chapter03;
  >                                              
  >    public class ShowTicket extends Thread {
  >        public static void main(String[] args) {
  >            ST st1 = new ST();
  >            ST st2 = new ST();
  >            ST st3 = new ST();
  >            st1.setName("售票窗口1");
  >            st2.setName("售票窗口2");
  >            st3.setName("售票窗口3");
  >            st1.start();
  >            st2.start();
  >            st3.start();
  >        }
  >    }
  >                                              
  >    class ST extends Thread {
  >        private static int ticket = 100;
  >                                              
  >        @Override
  >        public void run() {
  >            while (true) {
  >                //实例方法可以调用静态方法，因为静态早在类加载的时候就加载了，但是静态方法不可以调用实例方法
  >                show();
  >            }
  >        }
  >                                              
  >        //加了 static 相当于锁为：ST.class
  >        private static synchronized void show() {
  >            if (ticket > 0) {
  >                try {
  >                    Thread.sleep(2000);
  >                } catch (InterruptedException e) {
  >                    e.printStackTrace();
  >                }
  >                System.out.println(Thread.currentThread().getName() + " 售出票号： " + ticket);
  >                ticket--;
  >            }
  >        }
  >    }
  >    ```

## 单例模式中懒汉式安全问题的解决

前面我们说过单例模式中的懒汉式是线程不安全的：

```java
public class Test {
    private Test test = null;
    
    private Test() {}
    
    public static Test getTest() {
     	if(test == null) test = new Test;
    	return test;   
    }
}
```

学习了线程安全的解决方法之后可以这样改动：

```java
public class Test {
    private Test test = null;
    
    private Test() {}
    
    public static Test getTest() {
        //这里也可以使用 test 当作锁【因为是唯一的】
        synchronized(Test.class) {
	     	if(test == null) test = new Test;
	    	else return test;	           
        }
    }
    
    //效率较低 ---> 出现安全问题的只是 test 如果 test 不为 null 直接返回即可
    public static synchronized Test getTest1() {
     	if(test == null) test = new Test;
		else return test;	           
    }
    
    public static synchronized Test getTest2() {
        if(test == null) {
            synchronized(Test.class) {
                if(test == null)	test = new Test();
            }
        }
        return test;
    }
}
```

## 线程死锁问题

死锁：很好理解，比如某个线程拿着`A`锁进入一个方法，另一个线程拿着`B`锁进入方法，`A`锁中的方法里面又需要拿到`B`锁，而`B`锁方法里边恰恰相反，需要拿到`A`锁，此时是就造成了死锁。

也就是：**不同线程分别占用对方所需要的同步资源不放弃，都在等待对方放弃自己所需要的同步资源，就形成了线程死锁的问题。**

出现死锁会让所有线程都处于阻塞状态，程序一直卡在那里不动，也不报错也无异常不退出不提示。

解决方法：

1. 我们举的例子可以看出是嵌套使用，所以尽量避免嵌套同步
2. 尽量减少同步资源的定义
3. 专门的算法、原则

## `Lock`（锁）

从`JDK5.0`开始，`Java`提供了更为强大的线程同步机制 —— 通过显式定义同步锁对象来实现同步。同步锁使用`Lock`对象充当。`java.util.concurrent.locks.Lock`接口就是控制多个线程对共享资源进行访问的工具。锁提供了对共享资源的独占访问，每次只能有一个线程对`Lock`对象加锁，线程开始访问共享资源之前应先获得`Lock`对象。

`ReentrantLock`类实现了`Lock`，它拥有与`synchronized`相同的并发性和内存语义，在实现线程安全的控制中，比较常用的就是`ReentrantLock`，可以显示加锁、释放锁。

- 多线程继承方式实现锁，注意这里`ReentrantLock`需要使用`static`来修饰，否则一个线程就有一个`ReentrantLock`对象，达不到加锁的意义：

  ```java
  package Chapter03;
  
  import java.util.concurrent.locks.ReentrantLock;
  
  public class ShowTicket extends Thread {
      public static void main(String[] args) {
          ST st1 = new ST();
          ST st2 = new ST();
          ST st3 = new ST();
          st1.setName("售票窗口1");
          st2.setName("售票窗口2");
          st3.setName("售票窗口3");
          st1.start();
          st2.start();
          st3.start();
      }
  }
  
  class ST extends Thread {
      private static int ticket = 100;
  
      private static ReentrantLock reentrantLock = new ReentrantLock(true);
  
      @Override
      public void run() {
          while (true) {
              try {
                  reentrantLock.lock();
  
                  if (ticket > 0) {
                      System.out.println(Thread.currentThread().getName() + " 售出票号： " + ticket);
                      ticket--;
                  }
              } finally {
                  reentrantLock.unlock();
              }
          }
      }
  }
  ```

- 接口方式实现锁

  ```java
  package Chapter03;
  
  import java.util.concurrent.locks.ReentrantLock;
  
  public class ShowTicket extends Thread {
      public static void main(String[] args) {
          IST ist = new IST();
          Thread st1 = new Thread(ist);
          Thread st2 = new Thread(ist);
          Thread st3 = new Thread(ist);
          st1.setName("售票窗口1");
          st2.setName("售票窗口2");
          st3.setName("售票窗口3");
          st1.start();
          st2.start();
          st3.start();
      }
  }
  
  class IST implements Runnable {
  
      private int ticket = 100;
  
      private ReentrantLock reentrantLock = new ReentrantLock(true);
  
      @Override
      public void run() {
          while (true) {
              try {
                  reentrantLock.lock();
  
                  if (ticket > 0) {
                      System.out.println(Thread.currentThread().getName() + " 售出票号： " + ticket);
                      ticket--;
                  }
              } finally {
                  reentrantLock.unlock();
              }
          }
      }
  }

## 两种线程同步机制的比较

1. `Lock`是显示锁需要手动开启和关闭，`synchronized`是隐式锁出了作用域就会自动释放
2. `Lock`只有代码块锁，而`synchronized`不仅有同步代码块，还有同步方法两个
3. 因为`JDK5.0`之后推出了`Lock`，那自然是有它的意义的，使用`Lock`，`Java`虚拟机`JVM`将花费较少的时间来调度线程，性能更好，并且因为有更多的子类所以可扩展性更好。

同步机制优先使用顺序：`Lock` ---> 同步代码块 ---> 同步方法【解决线程安全问题共有3（你回答2也可以）种】

# 2022年06月09日下午

## 多线程习题

题目：银行有一个账户，有两个储户分别向同一个账户存`3000`元，每次存`1000`元，存`3`，每次存完打印账户余额。这道题目可以有好多种方式，我们一一来看下：

1. 使用`Runnable + 同步代码块`的方式

   ```java
   public class SaveMoney {
       public static void main(String[] args) {
           Account account = new Account();
           Thread A = new Thread(account);
           Thread B = new Thread(account);
           A.setName("张三");
           B.setName("李四");
           A.start();
           B.start();
       }
   }
   
   class Account implements Runnable {
   
       private int accountMoney = 0;
       private int saveTime = 1;
   
       @Override
       public void run() {
           while (true) {
               synchronized (this/Account.class) {
                   if (saveTime++ < 4) {
                       accountMoney += 1000;
                       System.out.println(Thread.currentThread().getName() + "存储 1000 元，当前账户余额为：" + accountMoney);
                   } else {
                       break;
                   }
               }
           }
       }
   }

2. 使用`Runnable + 同步方法`的方式

   ```java
   public class SaveMoney {
       public static void main(String[] args) {
           Account account = new Account();
           Thread A = new Thread(account);
           Thread B = new Thread(account);
           A.setName("张三");
           B.setName("李四");
           A.start();
           B.start();
       }
   }
   
   class Account implements Runnable {
   
       private int accountMoney = 0;
       private int saveTime = 1;
   
       @Override
       public void run() {
           while (true) {
               show();
           }
       }
   
       //这里的同步监视器默认使用的就是：this 还可以加个 static 表示当前类 Account.class
       public synchronized void show() {
           if (saveTime++ < 4) {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               accountMoney += 1000;
               System.out.println(Thread.currentThread().getName() + "存储 1000 元，当前账户余额为：" + accountMoney);
           }else {
               System.exit(0);
           }
       }
   }
   ```

3. 使用`Runnable + Lock`的方式

   ```java
   import java.util.concurrent.locks.ReentrantLock;
   
   public class SaveMoney {
       public static void main(String[] args) {
           Account account = new Account();
           Thread A = new Thread(account);
           Thread B = new Thread(account);
           A.setName("张三");
           B.setName("李四");
           A.start();
           B.start();
       }
   }
   
   class Account implements Runnable {
   
       private int accountMoney = 0;
       private int saveTime = 1;
   
       private ReentrantLock reentrantLock = new ReentrantLock(true);
   
       @Override
       public void run() {
           while (true) {
               try {
                   reentrantLock.lock();
                   if (saveTime++ < 4) {
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       accountMoney += 1000;
                       System.out.println(Thread.currentThread().getName() + "存储了 1000 元，当前账户余额为：" + accountMoney + " 元");
                   } else {
                       break;
                   }
               }finally {
                   reentrantLock.unlock();
               }
           }
       }
   }
   ```

4. 使用`继承Thread + 同步代码块`的方式

   ```java
   import java.util.concurrent.locks.ReentrantLock;
   
   public class SaveMoney {
       public static void main(String[] args) {
           Account A = new Account();
           Account B = new Account();
           A.setName("张三");
           B.setName("李四");
           A.start();
           B.start();
       }
   }
   
   class Account extends Thread {
   
       private static int accountMoney = 0;
       private static int saveTime = 1;
   
       @Override
       public void run() {
           while (true) {
               synchronized (Thread.class) {
                   if (saveTime++ < 4) {
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       accountMoney += 1000;
                       System.out.println(Thread.currentThread().getName() + "存储了 1000 元，当前账户余额为：" + accountMoney + " 元");
                   } else {
                       break;
                   }
               }
           }
       }
   }
   ```

5. 使用`继承Thread + 同步方法`的方式

   ```java
   import java.util.concurrent.locks.ReentrantLock;
   
   public class SaveMoney {
       public static void main(String[] args) {
           Account A = new Account();
           Account B = new Account();
           A.setName("张三");
           B.setName("李四");
           A.start();
           B.start();
       }
   }
   
   class Account extends Thread {
   
       private static int accountMoney = 0;
       private static int saveTime = 1;
   
       @Override
       public void run() {
           while (true) {
               show();
           }
       }
   
       public static synchronized void show() {
           if (saveTime++ < 4) {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               accountMoney += 1000;
               System.out.println(Thread.currentThread().getName() + "存储了 1000 元，当前账户余额为：" + accountMoney + " 元");
           }
       }
   }
   ```

6. 使用`继承Thread + Lock`的方式【构造`ReentrantLock`传递`true`即可让线程交替运行，但能否某个线程暂停唤醒另一个线程，然后另一个线程进入阻塞唤醒另外一个线程呢？---> 线程的通信】

   ```java
   import java.util.concurrent.locks.ReentrantLock;
   
   public class SaveMoney {
       public static void main(String[] args) {
           Account A = new Account();
           Account B = new Account();
           A.setName("张三");
           B.setName("李四");
           A.start();
           B.start();
       }
   }
   
   class Account extends Thread {
   
       private static int accountMoney = 0;
       private static int saveTime = 1;
       private static Object object = new Object();
       private static ReentrantLock reentrantLock = new ReentrantLock(true);
   
       @Override
       public void run() {
           while (true) {
               try {
                   reentrantLock.lock();
                   if (saveTime++ < 4) {
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       accountMoney += 1000;
                       System.out.println(Thread.currentThread().getName() + "存储了 1000 元，当前账户余额为：" + accountMoney + " 元");
                   } else {
                       break;
                   }
               } finally {
                   reentrantLock.unlock();
               }
           }
       }
   }
   ```

## 线程的通信

需要使用到：

- **<font color="red">【这三个方法只能用在同步代码块和同步方法中，不能用于`Lock`中！】</font>**

- **<font color="red">【这三个的调用者必须跟同步监视器保持一致！否则报错，这也是为什么我写`WN.class`报错写`Object`也报错的原因，你也可以改成：`object.notify() object.wait()`但，这又是为什么一定要写成一致的呢？】</font>**

  **【上述原因：一旦将一个对象设置成锁之后，我们内存中就有一个区域叫做对象头，对象头会存放同步监视器的状态和信息，当使用`wait()`方法的时候会去找这个同步监视器然后释放】**

- `wait()`：当前线程进入阻塞状态
- `notify()`：唤醒进入阻塞状态的单个线程【按优先级】
- `notifyAll()`：唤醒所有进入阻塞状态的线程

执行两个线程，交替打印`1-100`：【写代码的时候发现用继承的方式无法写，不知道后续是否可以解决？是真的不可以还是有什么不知道的东西？还有就是这里即使使用了`Runnable`的方式来写，但是这里一旦使用了`notify`，我`synchronized`里的同步监视器就无法使用`类.class`作为同步监视器，只能用`this`，这是为何？】

```java
public class WaitAndNotify {
    public static void main(String[] args) {
        WN wn = new WN();
        Thread t1 = new Thread(wn);
        Thread t2 = new Thread(wn);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

class WN implements Runnable {

    private int i = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if (++i <= 100) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
```

## 经典题

`sleep()`和`wait()`方法的异同：

相同点：

> - 都会使当前线程进入阻塞状态

不同点：

> 1. `sleep()`是静态方法，而`wait()`是非静态方法
> 2. `sleep()`不仅仅可以用在同步代码块和同步方法里头，但是`wait() notify()`这些只能用在同步代码块或者同步方法里头
> 3. 在同步代码块或者同步方法里头使用`sleep()`，是不会释放同步监视器的，之前说过，同步锁就算你睡着了也视为你持有，但是`wait()`不同，使用`wait()`会释放同步监视器

总结下就是：`sleep()`和`wait()`两个方法都可以让线程进入阻塞状态，但是`sleep()`是静态方法，使用类.的方式调用，而`wait()`是非静态方法，使用对象.的方式调用，并且`wait()`只能用于同步代码块和同步方法中但是`sleep()`不是，除此之外，就算`sleep()`在同步代码块或者同步方法里头使用，也不会释放同步监视器，该拿的锁还是拿住，但是`wait()`一旦使用就会释放同步监视器。

## 生产者/消费者问题

【多线程问题】这个应该很好理解了现在。只说说可能会产生的问题：

1. 生产者比消费者快的时候，也就是说生产者一直发发发但是消费者这边能接受的数量已经满了，可能导致一些数据没有收到。
2. 消费者比生产者快的时候，也就是说消费者一直在消费，但是生产者还没来得及生产，就可能导致消费者一直消费同一个数据。

这是自己写的生产者消费者模型：生产者会线生产`20`个产品，然后进入阻塞状态唤醒消费者消费

```java
public class ProAndCon implements Runnable {

    private int productNum = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (Thread.currentThread().getName().equals("生产者")) {
                    //如果是一个生产者则需要生产数据
                    //如果产品数量达到 20 生产者需要进入阻塞状态并唤醒消费者
                    if (productNum < 20) {
                        product();
                    } else {
                        this.notify();
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    //否则就是消费者，需要消费数据，但是需要确保产品数量大于 0
                    //否则需要唤醒生产者
                    if (productNum > 0) {
                        consume();
                    } else {
                        this.notify();
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    //生产者生产产品
    public void product() {
        System.out.println(Thread.currentThread().getName() + "生产产品：" + (++productNum));
    }

    //消费者消费产品
    public void consume() {
        System.out.println(Thread.currentThread().getName() + "消费产品：" + (productNum--));
    }
}

class ProConTest {
    public static void main(String[] args) {
        ProAndCon proAndCon = new ProAndCon();
        Thread product = new Thread(proAndCon);
        Thread consumer = new Thread(proAndCon);
        product.setName("生产者");
        consumer.setName("消费者");
        product.start();
        consumer.start();
    }
}
```

## 实现多线程的第三种方式

这是`JDK5.0`后新增的实现多线程的方式：两种，现在要讲的是实现`Callable`接口的方式。**这里在使用`Callable`的时候发现好像里面已经写好了，就算我用`Thread.sleep()`也还是`Thread-0`在执行，非常的奇怪**

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable {

    private int i = 1;

    @Override
    public Object call() throws Exception {
        int sum = 0;
        while (true) {
            if (i <= 100) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                sum += i++;
            } else {
                break;
            }
        }
        return sum;
    }
}

class CTest {
    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        FutureTask futureTask = new FutureTask(callableTest);
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        try {
            Object sum = futureTask.get();
            System.out.println("输出的总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
```

## 实现多线程的第四种方式

**背景：**需要经常性地创建和销毁线程，如果没有线程池这样做将非常地耗时。

**思路：**能否把提前创建好多个线程然后放入线程池中，需要使用的时候直接获取，使用完了就放回去【就像图书馆借书一样，要看的时候就借一本，不看或者看完了就还回去，实现了图书的重复利用】，这样就可以避免重复的创建、销毁，创建、销毁，实现线程的重复利用。

**好处：**

> 1. 提高响应速度，线程池中有现有的线程不用重新创建，减少了创建新线程的时间。
> 2. 降低资源消耗，重复利用了线程池中的线程不需要每次都创建。
> 3. 便于线程管理：`corePoolSize 核心池的大小`、`maximumPoolSize 最大线程数`、`keepAliveTime 线程没有任务的时候最多保持多长时间后会终止`

需要使用：**`ExecutorService`**线程池接口【`ThreadPoolExecutor`常见线程池子类】以及**`Executors`**工具类

- `ThreadPoolExecutor`可以通过：`executorService.getClass()`查看

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new ThreadRunnable1());
        executorService.execute(new ThreadRunnable2());
        //executorService.submit();//适用于Callable方法
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        threadPoolExecutor.setCorePoolSize(10);//设置核心池的大小
        threadPoolExecutor.setMaximumPoolSize(10);//设置最大连接线程数量
        //threadPoolExecutor.setKeepAliveTime();//设置线程最长连接时间
        executorService.shutdown();
    }
}

class ThreadRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

class ThreadRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
```

由此可知实现多线程有**四种**方式：

> 1. 继承`Thread`类
> 2. 实现`Runnable`接口
> 3. 实现`Callable`接口
> 4. 线程池`ExecutorService`接口和`Executors`工具类的连用，`ThreadPoolExecutor`是`ExecutorService`的常见接口

# 2022年06月09日晚上

## 复习

1. 说明线程的生命周期，一起各种状态切换使用到的方法等

   > 线程的生命周期有：新建、就绪、阻塞、运行、消亡五种状态
   >
   > - 从新建到就绪：`start()`
   >
   > - 从就绪到运行：抢夺`CPU`时间片
   >
   > - 从运行到就绪：失去`CPU`时间片
   >
   > - 从运行到阻塞：`sleep()`、失去同步锁、`wait()`、`join()`、`suspend()[已不建议使用]`
   >
   > - 从阻塞到就绪：获取同步锁、`resume()[和suspend()连用]`、`notify()`、`notifyAll()`、`Thread.sleep()的时间到了`
   > - 从运行到消亡：`run()方法执行完毕【正常消亡（老死）】`、`调用了stop()方法【（被杀死）】`、`出现异常但是没有处理【（病死）】`

2. 同步代码块中设计到同步监视器和共享数据，谈谈你对同步监视器和共享数据的理解以及注意点

   > - 共享数据就是多个线程共同操作的数据，共享数据若处理不好常常会导致线程安全问题。
   >
   > - 同步监视器其实就是同步锁，它可以是任何对象，并且该对象在作用域里头还是唯一的。
   >
   >   同步监视器在同步方法里头，如果是继承`Thread`类的这种方式要加`static`关键字使用的是`class`对象，如果是实现`Runnable`接口默认同步监视器就是`this`

3. `sleep()`和`wait()`的区别

   > 相同点：`sleep()`和`wait()`方法都会使得线程进入阻塞状态
   >
   > 不同点：
   >
   > ```
   > 1. sleep() 方法是一个静态方法，wait() 是一个非静态方法
   > 2. wait() 方法只能在同步代码块和同步方法中使用，但是 sleep() 不是
   > 3. sleep() 方法倘若也在同步体内执行，并不会使得当前线程释放同步监视器，而 wait() 方法会
   > ```

4. 写一个线程安全的懒汉式

   ```java
   public class Test {
       private Test test = null;
    	
       private Test() {}
       
       private static Test getTest() {
           if(test == null) {
               synchronized(Test.class) {
                   if(test == null) test = new Test();
               }
           }
           return test;
       } 
   }
   ```

5. 创建多线程有哪几种方式？

   > 有四种方式：
   >
   > 1. 继承`Thread`类重写`run()`方法
   > 2. 实现`Runnable`接口重写`run()`方法
   > 3. 实现`Callable`接口重写`call()`方法【相比于`Runnable`方式，`call()`有返回值，并且支持泛型，还可以抛出异常】
   > 4. 线程池：`ExecutorService`接口【其常用子类为：`ThreadPoolExecutor`】 + `Executor`工具类[提高响应速度 + 降低资源消耗便于管理]

# 2022年06月10日上午

## `String`内存

`String`是不可变字符序列，里面的字符存储在一个`final char[]`数组中，由双引号引起来是一个常量，并且实现了`Serializable`、`Comparable`接口

- 字符串是存放在方法区的常量池中的，常量池是不会存储相同内容的字符串的。

  我们知道其实`String`类型的底层就是`final char[]`不可变的`char`型数组，所以一个字符串存储的时候数组长度已经确定，相比在原有的数组扩容直接开辟内存空间的效率更高，所以设置成不可变是有原因的【这并不是单个原因，就算你长度一样，但只要内容变化了，也会开辟新的内存空间】。

- 创建`String`的实例化方式：

  ```java
  //1.通过字面量的方式
  String s1 = "abc";
  
  //2.通过传递字面量构造器的方式
  String s2 = new String("123");
  
  //3.通过传递char[]数组构造器的方式
  String s3 = new String(new char[]{'a', 'b', 'c'});
  ```

- 问：通过字面量的方式和通过构造器的方式有什么区别？

  ```java
  通过构造器的方式会在堆内存中开辟内存空间【存储的也是地址值】，但是字面量的方式不会。
  ```

- 问：对象中的字符串属性比较是`true`还是`false`？

  ```java
  Person person1 = new Person("Tom", 10);
  Person person2 = new Person("Tom", 10);
  System.out.println(person1.name == person2.name);//true
  ```

  因为其实堆内存中`person1.name`和`person2.name`存储的还是在方法区常量池中`Tom`的地址。

- 问：`String s = new String("abc");`的方式创建对象，在内存中创建了几个对象？

  ```java
  创建了 2 个对象，一个在堆内存中创建，一个在方法区常量池内存中创建对应着 char[] 数组。
  ```

- `String`不同拼接方式的对比：

  ```java
  public class StringTest {
      public static void main(String[] args) {
          String s1 = "abc";
          String s2 = "def";
          String s3 = "abcdef";
          String s4 = "abc" + "def";
          System.out.println(s3 == s4);
          String s5 = s1 + s2;
          System.out.println(s3 == s5);
          System.out.println(s4 == s5);
          String s6 = "abc" + s2;
          System.out.println(s3 == s6);
          System.out.println(s4 == s6);
          System.out.println(s5 == s6);
          String s7 = s1 + "def";
          System.out.println(s3 == s7);
          System.out.println(s4 == s7);
          System.out.println(s5 == s7);
          System.out.println(s6 == s7);
      }
  }
  ```

  这里除了第一个是`true`之外其余的都是`false`，这是为什么呢？因为如果没有引入变量，那么就相当于在方法区常量池中创建，如果引入了变量，则相当于执行了：`String x = new String(x1 + x2)`，结果就是会在堆内存开辟空间，如果常量池没有这个字面量则还会在堆内存中开辟。

  除此之外，还有一个比较特殊的，如果拼接的结果调用的是`intern()`方法则返回值就一定要在常量池中去找。比如这里返回的结果必然是`true`。

  ```java
  System.out.println(s3 == s7.intern());//true
  ```

  其实字符串涉及到变量的拼接比如：`str6 = st1 + str2` ===> 编译器会对字符串加号进行优化，背后其实使用了`StringBuffer`：`String str6 = new StringBuffer(str1).append(str5).toString();`堆内存中的存放的是地址，不管如何，最后的字符串都存放在方法区的常量池里头。

- `String`习题

  - ```java
    String s = "0";
    for(int i = 1; i <= 5; i++) {
        s += i;
    }
    System.out.println(s);//012345
    ```

  - ```java
    public class StringTest {
        String str = new String("good");// str 保存着堆内存地址，堆内存地址保存方法区常量池中的地址，指向真正的 good
        char[] ch = {'t', 'e', 's', 't'};
        
        public void change(String str, char ch[]) {//这里新建了一个 str 指向了方法区常量池里的 test ok，但是这里的 ch 因为是数组，所以存放在堆内存当中，ch 从 test 变成了 best
            str = "test ok";//这里只是一个局部变量，并不影响到成员变量的 str，常量池中新建 "test ok"
            ch[0] = 'b';
        }
        
        public static void main(String[] args) {
            Stringtest ex = new StringTest();
            ex.change(ex.str, ex.ch);//good test数组
            System.out.print(ex.str + "and");//good and
    		System.out.println(ex.ch);//best
        }
    }
    ```

    最后的结果就是：`good and best`

# 2022年06月10日下午

## `String`常用方法

```java
int length;	//返回字符串的长度
char charAt(int index);	//返回字符串某索引处的字符
boolean isEmpty();	//判断某个字符串是否为空,如果字符串为 null 将报错
String toLowerCase();	//将字符串中所有字符全部转换为小写
String toUpperCase();	//将字符串中所有字符全部转换为大写
String trim();	//返回去除头尾空格的字符串
String equals();	//比较两个字符串内容是否相同
String equalsIgnoreCase();	//忽略大小写地比较两个字符串内容是否相等
String concat(String str);	//连接两个字符串，等价于 + ，而 + 等价于 new StringBuffer().append();
int compareTo(String anotherString);	//比较两个字符串的大小，小为负，相等为0，大为正
String subString(int beginIndex);	//返回一个新的字符串，从 beginIndex 下标开始一直到字符串末尾
String subString(int beginIndex, int endIndex);	//返回一个新的字符串，从 beginIndex 开始截取到 endIndex【不包含】的一个新的子字符串，String 构造器的那个是从 beginIndex 开始截取几个，最后一个参数的意义是数量


不常用：
boolean endsWith(String suffix);	//判断该字符串是否是以指定字符串结尾
boolean startsWith(String prefix);	//判断该字符串是否是以指定字符串开头
boolean startsWith(String prefix, int toOffset);	//判断该字符串从指定索引开始是否以指定字符串开头
boolean contains(CharSequence s);	//判断该字符串是否包含某字符序列
int indexOf(String str);	//返回指定字符串在该字符串中第一次出现的索引，未找到返回 -1
int indexOf(String str, int fromIndex);	//返回指定字符串在某索引位置开始右边第一次在该字符串出现的位置，包括 fromIndex 的位置，未找到返回 -1
int lastIndexOf(String str);	//反方向的 indexOf，未找到返回 -1
int lastIndexOf(String str, int fromIndex);	//反方向的 indexOf，未找到返回 -1

String replace(char oldChar, char newChar);	//返回一个新的字符串，它是通过 newChar 替换词字符串中出现的 oldChar 得到的，如果 oldChar 不存在在原先的字符串里头则不会更改，replace 将产生一个新的字符串而不是修改原先的字符串，这也保持了 String 是不可变的这一特性

String s13 = "ABC";
System.out.println(s13.replace('B', 'E'));
System.out.println(s13.replace("BC", "E"));

String replace(CharSequence target, CharSequence replacement);	//使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
String replaceAll(String regex, String replacement);	//使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串
String replaceFirst(String regex, String replacement);	//使用给定的 replacement 替换此字符串中第一个可以匹配给定的正则表达式的字符串
boolean matches(String regex);	//判断该字符串是否符合给定的正则表达式
String[] split(String regex);	//根据给定的正则表达式的匹配拆分此字符串
String[] split(String regex, int limit);	//根据匹配给定的正则表达式来拆分此字符串，最多不超过 limit 个，如果超过了，剩下的全部都放到返回的字符串数组中的最后一个元素中

String s14 = "ABC,123,def,456,ghi,789";
System.out.println(Arrays.toString(s14.split(",")));
```

## `String`与基本数据类型的转换

- `String.valueOf()`：基本数据类型转换为字符串，这种方式相当于`new String()`，一定会在堆内存开辟内存空间，并且可能还会在方法区的常量池中开辟内存空间，**<font color="red">只要有变量参与都是在堆里头</font>**。
- 通过拼接的方式：`+` 可以将基本数据类型转换为字符串
- `Integer.parseInt(String str)`因为存在自动拆箱和自动装箱，可以通过这种方式将字符串转换为基本数据类型

回顾下自动拆箱和自动装箱：【`JDK5.0`之后产生的新特性】

- 自动拆箱就是包装类转换为基本数据类型：`包装类.包装类Value()`
- 自动装箱就是基本数据类型转换为包装类：`构造器方式` + `包装类.valueOf(基本数据类型)的方式`

## `String`与字符数组的转换

- `String`转换为`char[]`字符数组【调用方法即可】：`str.toCharArray();`

- `char[]`转换为`String`字符串【构造器就可以】：1. 循环遍历 + 拼接 2.构造器直接用 

## `String`与`byte[]`字节数组的转换

- 字符串转换为`byte[]`字节数组：`str.getBytes();`
- `byte[]`字节数组转换为字符串：`Arrays.toString(bytes);`

后续`I/O`流相关的操作将会用到，`UTF-8`内一个中文字符占`3`个字节，`GBK`内一个中文字符占`2`个字节

```java
byte[] bytes = {1, 2, 3, 4, 5, 6, 7, 8};
System.out.println(Arrays.toString(bytes));	//---> 解码
String s15 = "happy"; 
System.out.println(s15.getBytes());//遍历得到的是各个字符的 ASCII 码，getBytes() 可以指定编码集，否则使用的就是默认的编码集：getBytes("GBK"); ---> 编码
```

**解码时需要跟编码使用的字符集保持一致。**

## 一道习题

```java
final String s1 = "abc";
String s2 = "abcdef";
String s3 = s1 + "def";
System.out.println(s3 == s2);//true
```

## `StringBuffer`和`StringBuilder`

- `String`是不可变的字符序列
- `StringBuffer`是可变的字符序列并且是线程安全的，用到了许多`synchronized`，效率低【涉及到多线程的时候才使用其余情况均建议使用效率更高的`StringBuilder`】
- `StringBuilder`是可变的字符序列但是是线程不安全的，但是效率上比`StringBuffer`高

效率高低：`StringBuilder > StringBuffer > String`

为什么说`String`是不可变的，`StringBuffer StringBuilder`是可变的呢？因为使用`StringBuilder StringBuffer`如果里面的字符更改了，不会返回新的对象，是在原先的基础上加以修改的。

- `StringBuffer`的源码分析：

  - 空参构造器：会创建一个容量为`16`的字符数组
  - 有参构造器：会创建一个长度为`字符串长度 + 16`的字符数组
  - `length()`：表示的是**<font color="red">字符序列的长度</font>**，不是字符数组的长度！
  - 底层数组达到一定条件会扩容：默认扩容到`原先容量的 2 倍 + 2` ---> 指导意义：因为扩容越需要耗费时间，因为数组要进行一次复制，所以一般建议在使用`StringBuffer`的时候【在知道大概容量需要多少的情况下直接给定容量值即可】，使用容量参数的构造器：`StringBuffer stringBuffer = new StringBuffer(512);`

- `StringBuffer`常用方法：

  ```java
  append(xxx);	//追加元素
  delete(int start, int end);	//删除指定位置到指定位置的内容
  replace(int start, int end, String str);	//将[start, end]位置替换为 str
  insert(int offset, xxx);	//在指定位置插入 xxx
  reverse();	//将当前字符串反转
  indexOf(String str);	//指定字符串在当前中第一次出现的位置
  substring(int start, int end);	//截取指定位置字符串
  length();	//字符串长度
  charAt();	//指定位置的字符
  setCharAt();	//设置指定位置的字符
  ```

## `Date`

- 打印当前时间：`System.out.println(System.currentTimeMillis());`

```java
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println(date.toString());//获取当前时间的年月日时分秒[英文]
        System.out.println(date.getTime());//获取当前时间点的毫秒数 1970年1月1日0时0分0秒到现在       
    }
}
```

##  比较器

使用场景：需要对多个对象进行排序，就需要比较对象的大小。包装类和`String`里头都实现了`Comparable`接口，里头都有现成的重写后的`compareTo()`方法。

- **自然排序：`Comparable`**

  ```java
  //String 实现了 Comparable 接口，重写了 CompareTo() 方法：如果当前对象 this 大于形参对象 obj 就返回正整数，如果当前 this 对象小于形参对象则返回负整数，如果相等返回 0
  import java.util.Arrays;
  
  public class Goods implements Comparable {
      private String name;
      private int price;
  
      public Goods() {
      }
  
      public Goods(String name, int price) {
          this.name = name;
          this.price = price;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public int getPrice() {
          return price;
      }
  
      public void setPrice(int price) {
          this.price = price;
      }
  
      @Override
      public String toString() {
          return "Goods{" +
                  "name='" + name + '\'' +
                  ", price=" + price +
                  '}';
      }
  
      @Override
      public int compareTo(Object o) {
          if (o instanceof Goods) {
              Goods goods = (Goods) o;
              if (this.price > goods.price) return 1;
              else if (this.price < goods.price) return -1;
              else return this.name.compareTo(goods.name);
          }
          return 0;
      }
  }
  
  class GoodsTest {
      public static void main(String[] args) {
          Goods goods1 = new Goods("A", 96);
          Goods goods2 = new Goods("B", 100);
          Goods goods3 = new Goods("C", 98);
          Goods goods4 = new Goods("D", 99);
          Goods goods5 = new Goods("E", 97);
          Goods goods6 = new Goods("A", 97);
          Goods[] goods = new Goods[]{goods1, goods2, goods3, goods4, goods5, goods6};
          Arrays.sort(goods);
          System.out.println(Arrays.toString(goods));
      }
  }
  ```

- **定制排序：`Comparator`**【有点临时使用的味道】

  1. 如果当前前元素的类型没有实现`Comparable`接口而且不方便修改代码
  2. 或者实现了`Comparable`接口但是其排序规则不适合当前操作

  以上情况就可以考虑使用`Comparator`对象进行排序，强行对多个对象进行整体排序的比较

  `Arrays.sort()`的倒叙排序：

  ```java
  String[] strings = new String[]{"AA", "BB", "KK", "ZZ", "MM", "QQ", "DD"};
  Arrays.sort(strings);
  System.out.println(Arrays.toString(strings));
  Arrays.sort(strings, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
          return -o1.compareTo(o2);
      }
  });
  System.out.println(Arrays.toString(strings));
  
  [AA, BB, DD, KK, MM, QQ, ZZ]
  [ZZ, QQ, MM, KK, DD, BB, AA]
  ```

## `System`、`BigInteger/BigDecimal`、`Math`类

`System`类是私有的，最主要的就是两个方法：

`System.currentTimeMillis();`

`System.exit();`

还有一些可以获取当前操作系统属性的方法：

```java
System.out.println(System.getProperty("java.version"));
System.out.println(System.getProperty("java.home"));
System.out.println(System.getProperty("os.name"));
System.out.println(System.getProperty("os.version"));
System.out.println(System.getProperty("user.name"));
System.out.println(System.getProperty("user.home"));
System.out.println(System.getProperty("user.dir"));
```

# 2022年06月10日晚上

## 枚举

- 类的对象只有有限个，确定的，当需要定义一组**常量**的时候强烈建议使用枚举类

## 注解

## 集合

要学习的集合有两种类型：**单列集合**、**双列集合**

单列集合：

> 最高接口为`Collection`接口，它继承了`Iterable`接口。`Coolection`接口下面分别有`List`接口和`Set`接口，它们两个都继承了`Collection`接口【也就是在`Collection`接口的基础上由封装了各自特殊的功能】，它们两个的区别在于：`List`接口下的子类允许存放重复的元素且是有序的，但是`Set`接口下的子类存放的元素都是不重复且是无序的。
>
> 实现`List`接口的常见子类为：`ArrayList`、`LinkedList`。除此之外，还有个`Vector`子类，它也实现了`List`接口。总结下就是：`List ---> ArrayList LinkedList Vector`
>
> 实现`Set`接口的常见子类为：`HashSet`、`TreeSet`，它们都实现了`Set`接口。总结下就是：`Set ---> HashSet TreeSet`

双列集合：

> 双列集合最高接口是`Map`接口，常见的子类为：`HashMap`、`TreeMap`，还是继承了`HashMap`的`LinkedHashMap`，除此之外，实现`Map`接口的还有`HashTable`类，它继承了`Dictionary`抽象类实现了`Map`接口，还有`Properties`类它继承了`HashTable`类。
>
> 总结下就是：
>
> - `Map ---> HashMap TreeMap HashTable`
> - `Map ---> HashMap ---> LinkedHashMap`
> - `Map ---> HashTable[还继承了 Dictionary 抽象类] ---> Properties`

# 2022年06月11日下午

### `Collection`

首先来学习下单列集合的最高接口`Collection`接口，它继承了`Iterable`接口，所以所有实现了`Collection`接口的子类都可以通过迭代器实现遍历。该接口的下实现的子类可以存储任何类型的元素即`Object`类。`Collection`接口下的抽象方法：

```java
1. add：添加单个元素，默认在集合末尾添加元素
2. remove：删除指定元素，可以删除某个具体的元素也可以删除某个索引的元素，这里也补充一下如果有多个一样的元素，那么只会删除找到的第一个元素。
3. contains：判断当前元素是否存在
4. size：获取元素个数
5. isEmpty：判断当前集合是否是空集合
6. clear：清空集合
7. addAll：添加多个元素[集合]，默认在集合末尾添加
8. containsAll：判断当前集合是否存在在某个集合
9. removeAll：删除当前集合的某个集合，如果某个集合有好多重复的元素，此时删除一个集合，则会删除全部重复的元素，但是 remove 只会删除第一个遇到的元素
```

```java
package Chapter05;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMethod {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        //添加元素
        collection.add(1);
        collection.add("aaa");
        collection.add(2);
        collection.add("bbb");
        System.out.println("collection add = " + collection);
        //添加多个元素
        collection.addAll(collection);
        System.out.println("collection addAll = " + collection);
        //删除某个具体元素
        collection.remove(1);
        System.out.println("collection remove = " + collection);
        //删除某个集合【若存在某个重复元素则会删除全部重复元素】
        Collection collection1 = new ArrayList();
        collection1.add("aaa");
        collection.removeAll(collection1);
        System.out.println("collection removeAll = " + collection);
        //查找某个元素
        boolean contains1 = collection.contains(2);
        boolean contains2 = collection.contains("aaa");
        System.out.println(contains1 + " " + contains2);
        //查找多个元素 --- 集合
        System.out.println("collection containsAll = " + collection.containsAll(collection1));
        Collection collection2 = new ArrayList();
        collection2.add(2);
        collection2.add("bbb");
        System.out.println("collection containsAll = " + collection.containsAll(collection2));
        //查找集合元素个数
        System.out.println("collection size = " + collection.size());
        //判断集合是否为空
        System.out.println("collection isEmpty = " + collection.isEmpty());
        //清空集合
        collection.clear();
        System.out.println("collection clear = " + collection);
    }
}
```

因为`Collection`接口继承了`Iterable`接口，所以其子类也就实现了`Iterable`接口：

```java
package Chapter05;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection collection = new LinkedList();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("ddd");
        collection.add("eee");
        collection.add("fff");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
```

遍历集合还可以使用增强`for`，其底层使用的还是`Iterator`迭代器：

```java
package Chapter05;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    public static void main(String[] args) {
        Collection<Book> books = new ArrayList();
        books.add(new Book("三国演义", "罗贯中", 10.1));
        books.add(new Book("小李飞刀", "古龙", 5.1));
        books.add(new Book("红楼梦", "曹雪芹", 34.6));
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
```

到这里`Collection`接口就学习完毕了，总结下：`collection`是单列集合的最高接口，我们学习了`collection`相关方法：`add addAll remove removeAll contains containsAll isEmpty`，还学习了`Collection`接口的两种遍历方式：实现`Iterable`接口的`Iterator`迭代器遍历方式，二是增强`for`循环方式。

# 2022年06月12日下午

#### `List`

`List`接口是`Collection`的子接口，`List`子接口的实现类可以存储的元素是有序可重复的，相比于`Collection`接口，`List`这个继承`Collection`接口的接口有了索引，所以无论是添加元素也好，还是删除元素，还是查找某个元素出现的位置，以及设置某个索引上的元素，还是截取元素获取元素都可以使用索引进行操作，功能比`Collection`接口丰富得多。

```java
package Chapter05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        list.add(1, 2);
        list.add(2, "aaa");
        list.add("aaa");
        list.add(3, "bbb");
        System.out.println("List add = " + list);
        System.out.println("List get = " + list.get(3));
        System.out.println("List indexOf = " + list.indexOf("aaa"));
        System.out.println("List lastIndexOf = " + list.lastIndexOf("aaa"));
        list.remove(4);
        list.remove("bbb");
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);
        list.removeAll(collection);
        System.out.println("List remove = " + list);
        list.set(0, 1);
        System.out.println("List set = " + list);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        collection.clear();
        collection = list.subList(1, 3);//左闭右开
        System.out.println("List subList = " + collection);
    }
}
```

- **这里注意下`add`方法：如果按照索引添加则后续的元素会往后移动而不是覆盖，想要覆盖用`set`**
- **`List`接口的`subList(int fromIndex, int toIndex)`方法采用的是左闭右开原则**

遍历`Lsit`有三种方式：

- 一是普通`for`循环【因为有索引，所以你可以用`get`获取元素】
- 二是增强`for`循环
- 三是迭代器方式

这后两种都是从`Collection`接口继承过来的了，前面学习过。

```java
package Chapter05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCirculate {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("青椒炒肉");
        list.add("宫保鸡丁");
        list.add("鱼香肉丝");
        list.add("北京烤鸭");
        list.add("麻婆豆腐");
        //普通 for 循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-------");
        //增强 for 循环
        for (Object food : list) {
            System.out.println(food);
        }
        System.out.println("-------");
        //迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

##### `ArrayList`

```java
package Chapter05;

import java.util.ArrayList;

public class ArrayListSource {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }
        for (int i = 11; i <= 15; i++) arrayList.add(i);
        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(null);
    }
}
```

从创建`ArrayList`的空参构造器出发，可以看到其实是创建了一个空的静态不可变的存储对象的数组，到这里就产生了一个很好奇的疑问？如果这里指向的是一个静态不可变的常量，那多个`ArrayList`岂不是修改的都是同一个东西？这个疑问非常好，目前来看是非常正确的，后续涉及到扩容`grow()`方法里边，会使用到`Arrays.copyOf()`方法，会返回一个新的数组：

```java
public ArrayList() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
}

transient Object[] elementData;//不可序列化的
private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};//静态不可变数组
```

数组的扩容机制：【`size`在`Java`里面代表的是元素个数，`length`代表长度，比如：`int[] a = new int[10]; a[0] = 1`，则`size == 1;【数组没有 size 这种用法，集合有】 a.length == 10`】

```java
new ArrayList() ---> add() ---> ensureCapacittInternale(size + 1)
```

- `ArrayList`的底层就是`elementData`数组，刚开始没有数据的时候指向的是一个`DEFAULTCAPACITY_EMPTY_ELEMENTDATA`空静态不可变数组【这是为了节省内存空间所设计的】

- 接下来开始调用`add()`方法存储元素，`add()`方法里头会调用`ensureCapacityInternal(int minCapacity)`

  - `ensureCapacityInternal(int minCapacity)`传入了`size + 1`，这里的`size = 0`，因为这里是空参构造器的`ArrayList`且是第一次添加元素

    ```java
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }
    ```

    然后需要通过`calculateCapacity(elementData, minCapacity)`计算出真正所需要的容量，如果`ArrayList`的底层数组`elementData`指向静态不可变的空数组，则取默认数组容量跟`DEFAULT_CAPACITY`跟`minCapacity`的最大值。`DEFAULT_CAPACITY`为`10`。

    ```java
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }
    ```

    `calculateCapacity(elementData, minCapacity)`计算出来的容量 ---> 这里为`10`，返还给`ensureExplicitCapacity()`方法确认容量[这里就是用来做扩容的]，只要所需要的容量即`minCapacity`大于数组长度`elementData.length`[当前为`0`]，则需要进行扩容：【你需要的跟你当前的状态不匹配那你当然得要做点什么，这里指的就是扩容】：`grow(minCapacity)`

  - `grow(int minCapacity)`：

    - 获取到原先数组的长度：`elementData.length`这里是`0`

    - 获取到新数组的长度：原先数组长度的`1.5`倍，如果新数组长度大于原先数组长度，因为这里是第一次所以都是`0`

    - 如果新数组长度跟最小需要的长度【就是传递进来的`minCapacity`】相比较，最新长度比所需要的长度要小，那就把需要长度赋值给最新长度即：`newCapacity = minCapacity`

    - 判断下当前长度比最大长度`MAX_ARRAY_SIZE`还要大的话，就需要更大的容量`hugeCapacity()`这里不多做解释

    - 获取并确认到了新长度`newCapacity`，此时新建一个数组对象赋值给`elementData`，这里使用`Arrays.copyOf()`确保了原来的数据不会丢失

      【扩容完毕，得到一个新的数组，此时数组长度为：10（第一次）】

    ```java
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    ```

  - 此时数组长度为`10`，先扩容，后添加元素：`elementData[size++] = e`【e 为需要存储的数据】然后返回`true`表示添加成功

- 此时一直添加元素直到添加到第`11`个元素，那么此时需要的最小容量为：`minCapacity = 11`，这是`calculateCapacity(elementData, int minCapacity)`获取到的数据。

  - `calculateCapacity()`方法获取到的最小所需容量返回给`ensureExplicityCapacity()`方法

    - 在`ensureExplicityCapacity(int minCapacity)`中，判断当前数组容量是否比所需最小的数组容量要小，如果小就说明需要扩容了，此时数组容量为：`10`，所需最小容量为：`11`，表示需要扩容了，调用`grow()`方法进行扩容。

      1. 获取到原先容量：`int oldCapacity = elementData.length;//10`
      2. 然后获取新容量：`int newCapacity = oldCapacity + (oldCapacity >> 1);//原先容量的1.5倍即 15`
      3. 如果新容量`15`比最小所需容量`minCapacity`即`11`要大的话，就用不着`minCapacity`【反正你都要扩容，就要往大了的取】
      4. 确定新容量为：`15`，调用`Arrays.copyOf(elementData, newCapacity);`将数组长度扩容至`15`

      【需要设置下才可以看到`elementData` ---> `ctrl + alt + s` ---> `Build,Execution,Deployment` ---> `Debugger` ---> `Data Views` ---> `Java`】

      ```java
      private void grow(int minCapacity) {
          // overflow-conscious code
          int oldCapacity = elementData.length;
          int newCapacity = oldCapacity + (oldCapacity >> 1);
          if (newCapacity - minCapacity < 0)
              newCapacity = minCapacity;
          if (newCapacity - MAX_ARRAY_SIZE > 0)
              newCapacity = hugeCapacity(minCapacity);
          // minCapacity is usually close to size, so this is a win:
          elementData = Arrays.copyOf(elementData, newCapacity);
      }
      ```

  - 继续返回给`ensureCapacityInternal(size + 1);`

  - 返回给`add(E e)`

- 添加元素：`elementData[size++] = e;`

- 返回`true`表示添加成功

总结写就是：

```java
add ---> ensureCapacityInternal ---> calculateCapacity ---> ensureExplicitCapacity ---> grow() ---> elementData[size++] = e ---> return true
```

# 2022年06月17日下午

##### `Vector`

1. 源码中，如果不传递初始化容量值则默认初始化容量为：`10`
2. `add`方法被`synchronized`关键字修饰，表示`Vector`是线程安全的
3. `Vector`需要扩容的原因跟`ArrayList`一样都是当前数组长度比需要的最小容量要小的时候就扩调用`grow()`方法：`minCapacity - elementData.length > 0s`
4. 如果用户没有在定义`Vector`的时候就传入扩容因子：`capacityIncrement`的话，默认就是扩容`1`倍，如果有的话就是`原有容量 + capacityIncrement`

总结写就是：

```java
add ---> ensureCapacityHelper (grow) ---> elementData[elementCount++] = e ---> return true
```

##### `LinkedList`

`LinkedList`底层维护了一个双向链表，链表删除和添加元素的效率比数组要高，数组查找元素的效率比链表高。业务代码中`80% - 90%`的操作其实都是查找，所以大部分时间选择`ArrayList`是比较好的选择。

#### `Set`

`Set`接口继承了`Collection`接口，其特点就是：无序且不可重复并且没有索引，不支持随机访问。

##### `HashSet`

`HashSet`的底层其实就是`HashMap`，其底层由`数组 + 单向链表 + 红黑树`构成。通过`Hash`值确定是数组的哪个节点，然后通过索引确定是单向链表中的哪个元素，当某个单向链表中的元素到达某一个数量的时候就会从单向链表变成红黑树。

`HashSet`底层结构的详细说明：

1. 首先通过调用元素的`hashCode()`方法获取要存储元素的哈希值

##### `TreeSet`

## 泛型

一定程度上可以理解为标签，一眼就可以认出里面装什么。`JDK1.5`之后加入了泛型的特性。可自定义泛型：

```java
package Chapter04;

public class Order<T> {
    String name;
    T orderT;

    public Order() {
    }

    public Order(String name, T orderT) {
        this.name = name;
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", orderT=" + orderT +
                '}';
    }
}

class TestOrder {
    public static void main(String[] args) {
        Order<String> order = new Order<String>("张三", "历史");
        System.out.println(order.toString());
    }
}
```

## `File`

> 相对路径：相对于`module`
>
> 绝对路径：整个磁盘一直到当前文件的路径，不同操作系统的分隔符不一样，`Windows`是`\`，`Unix`是`/`，所以最好是使用`File.separator`来做分隔符

`File`对象如果没有`createNewFile/mkdir/mkdirs`这些仅仅停留在内存层面。注意一下`file.delete()`如果文件夹里面有文件则无法删除，必须删除里面的文件才可以删除

```java
package Chapter04;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        /*File file = new File("hello.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        File file3 = new File("world.txt");
        boolean rename = file.renameTo(file3);
        System.out.println(rename);//需要保证 file 存在并且 file3 不存在才能保证 rename 为 true
        File file1 = new File("E:\\2022年\\学习\\计算机学习\\Java\\JavaSEStudy");
        File[] files = file1.listFiles();
        for(File file2 : files) System.out.println(file2.getAbsolutePath());*/
        //file.isDirectory() 判断是否是文件目录
        //file.isFile() 判断是否是文件
        //file.exists() 判断是否存在
        //file.canRead() 判断是否可读
        //file.canWrite() 判断是否可写
        //file.isHidden() 判断是否隐藏
        //boolean file.createNewFile() 创建文件，若文件存在则不创建返回 false
        //boolean file.mkdir() 创建文件目录
        //boolean file.mkdirs() 如果上层文件目录不存在一并创建
        //boolean delete() 删除文件或者文件夹
        File file = new File("E:\\2022年\\学习\\计算机学习\\Java\\JavaSEStudy\\io1\\io2\\io3\\io4\\io5\\io6");
        if(!file.exists()) {
            boolean mkdirs = file.mkdirs();
            System.out.println("文件夹是否创建成功？" + mkdirs);
        }
        file.delete();
        File file1 = new File("E:\\2022年\\学习\\计算机学习\\Java\\JavaSEStudy\\io1\\io2\\io3\\io4\\io5\\hello.txt");
        if(!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file2 = new File("E:\\2022年\\学习\\计算机学习\\Java\\JavaSEStudy\\io1\\io2\\io3\\io4\\io5");
        file2.delete();//内有文件无法删除
        System.out.println(file2.isDirectory());
    }
}
```

## `I/O`流

`I/O`是`Input/Output`的缩写，是非常实用的技术，用于处理设备之间的数据传输。`input`我们称为输入 ---> 将磁盘/光盘等存储设备中的数据读取到内存中，`output`称为输出 ---> 将内存中数据写入到磁盘/光盘等存储设备中。

其实这个也很好理解，以计算机的显示器为中心，输入`input`就是读【从磁盘读】，从屏幕看到的就是从内存中读出来的也就是从屏幕读出来的，我们称之为输入。输出`output`就是写【写入磁盘】，从屏幕上写到磁盘中就是输出。还有一种比较好理解的说法就是：我们直到程序是在内存中运行的，所以如果是从磁盘等存储设备获取数据，那么就是输入也可以叫读取，如果是从程序往磁盘等存储设备写入数据，我们可以叫输出也可以叫做写入。

`I/O`流的分类：

- `I/O`流按照数据单位不同分为：字节流【`1`个字节更适合处理图片非文本数据】、字符流【`2`个字节代表一个字符更适合处理文本】。简单说就是`byte`和`char`的区别。

  - 字节流：`InputStream`、`OutputStream`

  - 字符流：`Writer`、`Reader`

- 也可以按照流向不同分为输入流、输出流：输入流包括`InputStream`、`Reader`，输出流包括`OutputStream`、`Writer`

- 还可以按照流的角色分为：节点流、处理流【节点流的基础上附加了其它功能】，节点流只有：`FileInputStream FileOutputStream FileReader FileWriter`

注：`InputStream OutputStream Reader Writer`都是抽象类，是所有`I/O`流里实现类中的抽象基类。具体说下就是：字节输入流、字节输出流、字符输入流、字符输出流。`I/O`流这一章最重要要学习的内容就是：`FileInputStream FileOutputStream FileReader FileWriter InputStreamReader OutputStreamWriter BufferedInputStream BufferedOutputStream BufferedReader BufferedWriter ObjectInputStream ObjectOutputStream`。【抽象基类、文件流 、缓冲流、转换流】

### `FileReader`

为了保证流资源可以正常关闭所以需要使用`try-catch-finally`，否则只是做了一个抛出问题但不解决问题的人。

`FileReader`的第一种使用方式：

```java
package Chapter04;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderAndWriterTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("hello.txt");
            int data = -1;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

`FileReader`的第二种使用方式：

```java
public static void fileReaderM2() {
    FileReader fileReader = null;
    char[] cBuf = new char[5];
    try {
        fileReader = new FileReader("hello.txt");
        int len;
        while ((len = fileReader.read(cBuf, 0, cBuf.length)) != -1) {
            for (int i = 0; i < len; i++) System.out.print(cBuf[i]);
        }
        while ((len = fileReader.read(cBuf)) != -1) {
            //for (int i = 0; i < len; i++) System.out.print(cBuf[i]);
            String str = new String(cBuf, 0, len);
            System.out.println(str);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### `FileWriter`

没有文件会创建文件然后再写入。`new FileWriter(file, true);`表示追加，`false`表示重写覆盖，默认就是覆盖重写。

```java
public static void fileReaderM3() {
    FileWriter fileWriter = null;
    try {
        fileWriter = new FileWriter("hello.txt", true);
        fileWriter.write("!!!\n1234567890");
        //fileWriter.write("hello world");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

这里需要使用`fileWriter.flush()`对文件进行刷新，否则读不出来数据。

```java
public static void fileReaderM4() {
    FileReader fileReader = null;
    FileWriter fileWriter = null;
    try {
        File file = new File("text.txt");
        fileWriter = new FileWriter(file, false);
        fileWriter.write("This is a Reader and Writer text!!!\nYeah Yeah Yeah!!!");
        fileWriter.flush();
        fileReader = new FileReader(file);
        char[] cBuf = new char[5];
        int len;
        while ((len = fileReader.read(cBuf, 0, cBuf.length)) != -1) {
            //for (int i = 0; i < len; i++) System.out.print(cBuf[i]);
            System.out.print(new String(cBuf, 0, len));
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### `FileInputStream`

对于图片这种字节数据，无法使用字符流来处理，这种情况下需要使用字节流。

```java
public static void fileInputOutputM1() {
    FileInputStream fileInputStream = null;
    try {
        fileInputStream = new FileInputStream("19.jpg");
        int data;
        while((data = fileInputStream.read()) != -1) {
            System.out.print((char)data);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

```java
public static void fileInputOutputM2() {
    FileInputStream fileInputStream = null;
    try {
        fileInputStream = new FileInputStream("19.jpg");
        byte[] buffer = new byte[5];
        int len;
        while ((len = fileInputStream.read(buffer, 0, buffer.length)) != -1) {
            //for (int i = 0; i < len; i++) System.out.print((char)buffer[i]);
            System.out.print(new String(buffer, 0, len));
        }
    } catch (
            FileNotFoundException e) {
        e.printStackTrace();
    } catch (
            IOException e) {
        e.printStackTrace();
    } finally {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### `FileOutputStream`

```java
public static void fileInputOutputM3() {
    FileOutputStream fileOutputStream = null;
    FileInputStream fileInputStream = null;
    try {
        fileInputStream = new FileInputStream("19.jpg");
        fileOutputStream = new FileOutputStream("19copy.jpg");
        byte[] buffer = new byte[5];
        int len;
        while ((len = fileInputStream.read(buffer, 0, buffer.length)) != -1) {
            for (int i = 0; i < len; i++) {
                System.out.print((char) buffer[i]);
                fileOutputStream.write(buffer[i]);
            }
            //System.out.print(new String(buffer, 0, len));
        }
        fileOutputStream.flush();
    } catch (
            FileNotFoundException e) {
        e.printStackTrace();
    } catch (
            IOException e) {
        e.printStackTrace();
    } finally {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

### `BufferedInputStream`

### `BufferedOutputStream`

### `BufferedReader`

### `BufferedWriter`

缓冲流是处理流，比文件流这种节点流的效率要高很多。处理流包裹着节点流。写法其实没什么变，只不过效率变高了，这不是更好的事情吗？关闭流的顺序是从外往内脱，并且关闭外层流的时候会自动关闭内层流。

缓冲流内部提供了缓冲区，提高了读写速度。`BufferedReader`多了一个方法：`readLine()`一次可以读取一行数据。

### `InputStreamReader`

### `OutputStreamWriter`

这两个是转换流，如果内容是字符，将字节流转换成字符流效率会更高。`InputStreamReader`的第二个参数可以设定存储数据的编码。

### `ObjectInputStream`

### `ObjectOutputStream`

- 对象流，强大之处在于可以把`Java`对象写入到数据源中，也能把对象从数据源中还原回来。序列化就是将对象/基本数据类型写入到磁盘等存储设备中，反序列化就是将磁盘等设备中读取基本数据类型/对象。

- 序列化就是将对象转换成平台无关的二进制流，从而允许把二进制流持久地保存在磁盘上，或通过网络将这种二进制流传输到另外一个网站节点【是所有远程方法调用`RMI`必须实现的机制，`RMI`是`JavaEE`的基础，所以序列化时`JavaEE`平台的基础】。当其它程序获取了这种二进制流，就可以恢复成原来的`Java`对象。

- 序列化的好处在于可以将任何实现了`Serializable`接口的对象转化为**字节数据**，使其在保存和传输时可被还原。

```java
package Chapter04;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            objectOutputStream.writeObject(new String("我爱北京天安门"));
            objectOutputStream.flush();
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));
            Object str = objectInputStream.readObject();
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

凡是实现`Serializable`接口的类都有一个表示序列化版本标识符的静态变量：`private static final long serialVersionUID;`用来表明类不同版本间的兼容性，如果没有显式定义这个静态变量，它的值时`Java`运行时环境根据类的内部细节自动生成的。若类的实例变量做了修改，`serialVersionUID`可能会发生变化，所以建议显示声明，变化的影响就是序列化后可能无法进行反序列化，要想进行反序列化前提是序列化版本需要一致。

### `RandomAccessFile`

这是一个随机存取文件流，既可以作为输入流也可以作为输出流，支持随机访问的方式，程序可以直接跳到文件的任意地方来进行读、写文件。

- 支持只访问文件的部分内容
- 可以向已经存在的文件后面追加内容

> `long getFilePointer();`获取文件记录指针的当前位置
>
> `void seek(long pos);`将文件记录指针定位到`pos`位置

`RandomAccessFile`有四种访问模式：`r rw rwd[同步文件内容的更新] rws[同步文件内容和元数据的更新]`

可以通过`getBytes()`实现插入数据的效果：

```java
package Chapter04;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("raf.txt", "rw");
            randomAccessFile.seek(3);
            //先读取然后插入再覆盖
            byte[] buffer = new byte[1024];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len = randomAccessFile.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, len));
            }
            randomAccessFile.seek(3);
            randomAccessFile.write("xyz".getBytes());
            randomAccessFile.write(stringBuilder.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

# 2022年06月18日下午

### `Java NIO`

`NIO`是`Java`从`1.4`版本引入的一套新的`IO API`，可以替代标准的`Java IO API`。简单说：`IO`是面向流的，而`NIO`是面向缓冲区的，可以以更加高效的方式对文件进行读写。【`NIO`刚开始出来的时候并没有多好，所以在`1.7`就出现了`NIO2`，并且起到了越来越重要的作用】

`Java`中提供了两套`NIO`：一套是针对标准输入输出的`NIO`，另一套就是网络编程`NIO`【这里学习的是标准输入输出的`NIO`】

> - `java.nio.channels.Channel`
>   - `FileChannel;`处理本地文件
>   - `SocketChannel;` `TCP`网络编程客户端的`Channel`
>   - `ServerSocketChannel;` `TCP`网络编程服务器端的`Channel`
>   - `DatagramChannel;` `UDP`网络编程中发送端和接收端的`Channel`

许多框架的底层会对`NIO`进行封装，可以在学习框架的时候再具体学习。

#### `Path Paths Files`类的使用

- 早期的`Java`只提供了一个`File`类来访问文件系统，但是`File`类提供的功能比较优先，提供的方法性能也不高，而且大多数方法出错的时候仅仅返回一个`false`布尔值，并不会抛异常告诉具体到底什么出错了。

- `NIO.2`弥补了这种不足，引入了`Path`接口，它可以在出错的时候抛出异常，实际上可以看成是一个`File`类的升级版本，实际引用的资源可以不存在

  `Path path = Paths.get("index.html");`

#### `commons-io`开源包的直接使用

可以直接使用更简单方便的`jar`包，直接用`Maven`导入即可，内含丰富`IO`简单易用的`API`：

- 使用`FileUtils.copyFile(File srcFile, File destFile);`即可直接复制文件【注：`main`方法中的相对路径是从当前工程出发的】

## 网络编程

### 网络编程概述

- `JVM`隐藏了网络连接的细节，实现了一个跨平台的网络库，程序员面对的是一个同一的网络编程环境，实现了跨平台性。

- **计算机网络：**把分布在不同地理区域的计算机与专门的外部设备用通信线路互连成一个规模大、功能强的网络系统，从而使众多计算机之间可以方便地互相传递信息，共享软硬件、数据信息等资源。【说白了就是用来通信跟共享资源的】
- **网络编程的目的：**直接或间接地通过网络协议与其他计算机实现数据交换，进行通讯
  - 如何准确定位网络上地一台或者多台主机？【**发给谁？**】`Who`
  - 如何在找到主机后进行可靠高效地进行数据传输？【**怎么发？**】`How`
  - 【**发什么**】`What`

### 网络通信要素

`Who`发给谁问题：`IP + Port`即可定位一台主机

`How`怎么发问题：`TCP/IP`协议 + `OSI`参考模型【网络传输协议】【前者：物理+数据链路层、网络层、传输层、应用层`HTTP FTP Telnet DNS...`】【后者：物理层、数据链路层、网络层`IP ICMP ARP`、传输层`TCP UDP`、会话层、表示层、应用层】

总结：**`IP + Port + 网络通信协议`**即可给一台主机发送消息。其中：**<font color="red">`IP + Port`就组成了一个网络套接字`Socket`。</font>**因为网络编程必然涉及到`IP + Port`也就是套接字`Socket`，所以网络编程又会称为套接字编程/`Socket`编程。

常见的端口号：`21-FTP`、`23-Telnet`、`80-HTTP`、`8080-Tomcat`、`3306-MySQL`、`1521-Oracle`

### `InetAddress`类

```java
package Chapter06;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1);
            InetAddress inetAddress2 = InetAddress.getLocalHost();
            System.out.println(inetAddress2);
            String hostName = InetAddress.getLocalHost().getHostName();
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(hostName);
            System.out.println(hostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
```

# 2022年06月18日晚上

### 网络协议

网络协议非常复杂，这么复杂的东西当然选择将它拆分掉呀，拆分后然后再复合，复合的方式就是层次方式，即同层间可以通信，上一层可以调用下一层，而与再下一层不发生关系。各层互不影响，利于系统的开发和扩展。

其中最重要的就是传输层，而传输层中最重要的就是：`TCP`协议和`UDP`协议。

#### `TCP`协议

> - 使用`TCP`协议之前，需要先建立`TCP`连接，形成传输数据通道，
>
> - 传输前，采用三次握手的方式，实现点对点通信，可实现大数据传输并且是通信是可靠的
>   - 客户端发送`SYN`报文，并且置发送号为`x`
>   - 服务端发送`SYN + ACK`报文，并且发送`ACK`序号为`x + 1`，并置发送号为`y`
>   - 客户端发送`ACK`报文，并置发送号为`z`，`ACK = y + 1`
>
> - `TCP`涉及两个应用程序：客户端、服务端
> - 传输完毕，需释放已建立的连接，效率较低，释放连接需要进行四次挥手，主动挥手的可以是客户端也可以是服务端，通常情况下是客户端发起的，下面以客户端为例说明四次挥手
>   - 客户端发送`FIN + ACK`报文`FIN = 1, ACK = Z, SEQ = X`，并置发送序号为：`X`
>   - 服务端接受客户端发送的`FIN + ACK`报文，发送确认报文即`ACK`报文`ACK = X + 1, SEQ = Z`，并置发送序号为：`Z`
>   - 然后服务端这边再立马发送`FIN + ACK`报文表示也要断开，并置发送序号为：`X`即`FIN = 1, ACK = X, SEQ = Y`
>   - 最后客户端收到来自服务端的断开信号即`FIN + ACK`报文，随即发送确认报文即`ACK`报文：`ACK = Y, SEQ = X`，并置发送序号为`X`

#### `UDP`协议

> - 将数据、源、目的封装成数据包，不需要建立连接
> - 每个数据报的大小限制在`64kb`以内
> - 发送方不管对方是否准备好，接收方也无需确认是否收到，所以传输效率很快，但这也产生了不可靠的问题
> - 可以广播发送
> - 发送数据结束时无需释放资源，开销小速度快

总结下：

- `TCP`传输数据前需要进行三次握手，这样传输的数据很可靠，并且数据发送完毕之后需要释放已经建立的连接所以传输速度相对于`UDP`来说较慢。【常用于：`打电话`】
- `UDP`传输数据前不需要进行连接，不用等待接收方准备好，接收方也无需向发送方确认数据是否收到，丢一点数据也无所谓，所以传输速度相对于`TCP`来说较快。【常用于：`微信/QQ小心`、`直播`、`视频`】

### `Java-Socket`模拟发送`TCP`数据一

客户端发送内容给服务端，服务端将内容打印到控制台上。

客户端：

```java
package Chapter06;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest1Client {
    public static void main(String[] args) {
        client();
    }

    //客户端
    public static void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            //向谁发 ---> 套接字 IP + Port
            socket = new Socket(inetAddress, 9527);
            outputStream = socket.getOutputStream();
            outputStream.write("Hello World!".getBytes());
            outputStream.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

服务端：

```java
package Chapter06;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class TCPTest1Server {
    public static void main(String[] args) {
        TCPTest1Server tcpTest11 = new TCPTest1Server();
        tcpTest11.server();
    }

    //服务端
    public void server() {
        //获取套接字发送过来的消息
        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(9527);
            inputStream = serverSocket.accept().getInputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
            System.out.println("谁给我发的？" + serverSocket.getInetAddress().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### `Java-Socket`模拟发送`TCP`数据二

客户端发送文件给服务端，服务端将文件保存在本地。

客户端：

```java
package Chapter06;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest2Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 8888);
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(new FileReader("text.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outputStreamWriter.write(line + "\n");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

服务端：

```java
package Chapter06;

import java.io.*;
import java.net.ServerSocket;

public class TCPTest2Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStreamReader inputStreamReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            serverSocket = new ServerSocket(8888);
            inputStreamReader = new InputStreamReader(serverSocket.accept().getInputStream());
            char[] buffer = new char[1024];
            int len;
            bufferedWriter = new BufferedWriter(new FileWriter("textCopy.txt"));
            while ((len = inputStreamReader.read(buffer, 0, buffer.length)) != -1) {
                bufferedWriter.write(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### `Java-Socket`模拟发送`TCP`数据三

客户端发送文件给服务端，服务端保存到本地，并返回发送成功给客户端，然后关闭相应的连接。

前面发送文件然后保存这件事情在第二个案例中其实已经完成了，问题就是服务端怎么发送数据给客户端呢？

- 注意这里是的`IO`是阻塞式的，客户端没有说发完，则服务端这边一直会保持接收状态，所以需要在客户端这边添加如下语句：`socket.shutdownOutput();`
- 其次需要注意的就是`Server`服务端的`serverSocket.accept();`返回一个`Socket socket;`套接字，并且只返回一次，所以后面想要给客户端发送消息，不能用`serverSocket.accept().getOutputStream();`，只能是在前面定义接收好`Socket socket = serverSocket.accept();`再做输入输出。

客户端：

```java
package Chapter06;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest3Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(new FileReader("text.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outputStreamWriter.write(line + "\n");
            }
            outputStreamWriter.flush();
            //这里传输完数据需要手动关闭下输出流
            socket.shutdownOutput();
            //客户端接收服务端发送的消息
            inputStream = socket.getInputStream();
            int len;
            byte[] buffer = new byte[1024];
            System.out.print("收到了来自服务端的消息：");
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

服务端：

```java
package Chapter06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest3Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStreamReader inputStreamReader = null;
        BufferedWriter bufferedWriter = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();//socket 只能接收一个且只能接收一次
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            char[] buffer = new char[1024];
            int len;
            bufferedWriter = new BufferedWriter(new FileWriter("textCopy.txt"));
            while ((len = inputStreamReader.read(buffer, 0, buffer.length)) != -1) {
                bufferedWriter.write(new String(buffer, 0, len));
            }
            bufferedWriter.flush();
            //下列代码没有执行：
            System.out.print("成功接收来自客户端的文件！");
            outputStream = socket.getOutputStream();
            outputStream.write("中国出了个毛泽东！".getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

### `Java-DatagramSocket`模拟发送`UDP`数据

`UDP`将数据直接封装成包`DatagramPacket`

客户端：

```java
package Chapter06;

import java.io.IOException;
import java.net.*;

public class UDPTestClient {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket = null;
        try {
            datagramSocket = new DatagramSocket();
            byte[] data = "我是通过 UDP 协议发送的导弹！".getBytes();
            datagramPacket = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 8888);
            datagramSocket.send(datagramPacket);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) datagramSocket.close();
        }
    }
}
```

服务端：

```java
package Chapter06;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPTestServer {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket = null;
        try {
            datagramSocket = new DatagramSocket(8888);
            byte[] data = new byte[1024];
            datagramPacket = new DatagramPacket(data, 0, data.length);
            datagramSocket.receive(datagramPacket);
            System.out.println("服务端接收到的 UDP 数据：" + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) datagramSocket.close();
        }
    }
}
```

### `URL`编程

```java
package Chapter06;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com");
            System.out.println("获取URL协议名：" + url.getProtocol());
            System.out.println("获取URL主机名：" + url.getHost());
            System.out.println("获取URL端口号：" + url.getPort());
            System.out.println("获取URL文件名：" + url.getFile());
            System.out.println("获取URL文件路径：" + url.getPath());
            System.out.println("获取URL查询名：" + url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
```

#### 实现从`Tomcat`服务器下载数据

```java
package Chapter06;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com/example/test.txt");
            System.out.println("获取URL协议名：" + url.getProtocol());
            System.out.println("获取URL主机名：" + url.getHost());
            System.out.println("获取URL端口号：" + url.getPort());
            System.out.println("获取URL文件名：" + url.getFile());
            System.out.println("获取URL文件路径：" + url.getPath());
            System.out.println("获取URL查询名：" + url.getQuery());
            URLConnection urlConnection = url.openConnection();//获取到 HTTP 连接
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            //连接
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            //后面就是拷贝数据的操作了，不再多加阐述
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //进行资源关闭
        }
    }
}
```

# 2022年06月20日下午

## 反射

### `Java`反射机制概述

- 反射`Reflection`是被视为动态语言的关键，反射机制允许程序在执行期间获取`Class`实例，取得任何类的内部信息，并且能够直接操作任意对象的内部属性以及方法。
- 加载完类之后，在堆内存中就产生了`Class`类对象，一个类只有一个`class`对象，这个对象就包含了完整的类的结构信息。我们可以通过这个对象看到类的结构。这个对象就像一面镜子，透过这面镜子我们可以看到类内部结构，所以我们形象的称之为：反射。
  - 正常方式：类 ---> 通过`new`实例化 ---> 取得实例化对象
  - 反射方式：实例化对象 ---> `getClass()`方法 ---> 得到类对象
- 程序可以简单的分为：编译 + 运行两个阶段，`Java`在编译阶段是不知道你要产生哪个类的对象，只有在编译阶段才知道，所以`Java`又可以看作是一门静态语言。
- **<font color="red">通过反射机制到底可以干什么？</font>**
  - 在运行时判断任意一个对象所属的类
  - 在运行时构造任意一个类的对象
  - 在运行时判断任意一个类所具有的成员变量和方法
  - 在运行时获取泛型信息
  - 在运行时调用任意一个对象的成员变量和方法
  - 在运行时处理注解
  - 生成动态代理

### 理解`Class`类并获取`Class`实例

- **<font color="red">不管如何，创建某个类的对象都需要用到构造器</font>**
- 并且通常在`JavaBean`中要求有空参构造器，因为默认调用`super()`的时候，会默认调用空参构造器，保证父类有此构造器。没有空参构造器不会默认调用有参的，需要手动实现。

```java
package Chapter07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        //反射之前可以对 Person 类做的事情 ---> 公共的 ---> 无法调用私有物品
        Person person = new Person("张三", 1000);
        person.age = 102;
        System.out.println(person.toString());
        person.show();
        //反射之后可以做的事情 ---> 获取所有的类内部信息
        //1.通过反射获取构造器 Constructor ---> 私有需使用 setAccessible(boolean flag);
        Class personClass = person.getClass();
        Constructor constructor = personClass.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Person personObject = (Person) constructor.newInstance("李四", 108);
        System.out.println(personObject.toString());
        //2.通过反射获取类的属性、方法 Field Method ---> 私有需使用 setAccessible(boolean flag); 设置为 true 才可以修改，否则报 IllegalAccessException
        Field personField = personClass.getDeclaredField("name");
        personField.setAccessible(true);
        personField.set(personObject, "liSi");
        System.out.println(personObject.toString());
        Method personMethod = personClass.getDeclaredMethod("showNation", String.class);
        personMethod.setAccessible(true);
        Object methodObject = personMethod.invoke(personObject, "中国");
        System.out.println(methodObject);
    }
}
```

- **<font color="red">直接使用`new`实例化对象跟反射获取对象有什么区别？</font>**
  - **<font color="deepskyblue">如果可以直接确定要造哪个对象直接使用`new`，如果编译时无法确定则使用反射会更好即动态的【比如`Servlet`对象，前端发送一个`/login`请求此时就需要的是`Login`相关对象，如果前端发送过来的是`/register`请求那么此时就需要的是`Register`相关对象，此时你是无法将创建对象的代码写死的，除非你使用大量的`if-else`代码，但这显然不是一个很好的方法，此时使用反射就是一个很好的选择】。</font>**
- 有了反射机制以后，是否就跟封装性矛盾了呢？如何看待？
  - 不矛盾，封装性只是建议你不要去调用`private`属性和方法，但是如果你非要调用也可以，使用反射获取即可

### 类的理解与`ClassLoader`的理解【重点】

对于类加载过程的理解：

- 程序经过`javac.exe`命令以后会生成一个或多个字节码文件即`.class`文件。
- 然后通过`java.exe`命令会对某个字节码文件即`.class`文件进行解释运行，相当于将字节码文件加载到内存中，这个过程就是类加载过程。加载到内存中的类称为运行时类，此运行时类就作为`Class`的一个实例。

总结下类加载过程：`javac.exe`生成一个或多个字节码文件，`java.exe`对字节码文件即`.class`文件进行解释运行，将字节码文件加载到内存中，这个过程就叫做类加载过程。加载到内存中的类就是运行时类，此运行时类就是一个`Class`实例，**<font color="red">而且在堆内存中有且只有一个`Class`实例</font>**。换句话说`Class`实例就是运行时类。运行时类会缓存一定时间，在此时间内可以通过不同方式获取运行时类。

**类加载过程即`ClassLoader`涉及到`JVM`的知识，在这里先学习一些基础部分：**类加载过程其实就是将类加载到内存其中的一个过程，但并不是对类进行初始化的全部过程，想要将类完全加载到内存并初始化需要通过下面三个部分，这三个部分统称为对该类进行初始化【类加载到内存中仅仅只是一个部分】：

1. **类的加载`Load`：**将类的`.class`后缀文件即字节码文件读入内存并为之创建一个`java.lang.Class`对象。此过程由类加载器完成。【**也就是说在第一步骤类的加载`Load`就出现了`java.lang.Class`对象了，并且只会产生一个，每个类有且只有一个`Class`对象**】

   >`Load`具体过程：将`class`文件字节码内容加载到内存当中，并将这些静态数据[简单理解为静态代码]转换成方法区的运行时数据结构，然后就生成了一个代表这个类的`java.lang.Class`对象，作为方法区中类数据结构的访问入口【即访问地址】。所有需要访问和使用类数据只能通过这个`Class`对象。这个加载的过程需要类加载器参与。

2. **类的链接`Link`：**将类的二进制数据合并到`JRE`[`Java`运行时环境]中。需经历如下三个过程：

   > - 验证：确保加载的类信息符合`JVM`规范
   > - 准备：正式为类变量即`static`关键字修饰的变量分配内存并设置类变量默认初始值的阶段，【说白了就是给静态变量赋予默认值的阶段】，这些内存都将在方法区中进行分配
   > - 解析：虚拟机常量池内的符号引用（常量名）替换为直接引用（地址）的过程

3. **类的初始化`Initialize`：**`JVM`负责对类进行初始化

   > - 执行`类构造器<clint>()`方法的过程。类构造器`<clint>()`方法是由编译器自动收集类中所有类变量的赋值动作和静态代码块中的语句合并产生的。（类构造器是构造类信息的，不是构造该类对象的构造器）【说白了类的初始化就是给静态变量赋值得这么一个阶段】
   > - 当初始化一个类的时候，如果发现其父类还没有进行初始化，则需要先触发其父类的初始化【先加载爸爸的，这在学习继承、`super`时都有学习过】
   > - 虚拟机会保证一个类的`<clint>()`方法在多线程环境中被正确加锁和同步。

**总结下就是：**类的加载【产生了`java.lang.Class`对象】---> 类的链接【包括验证、准备、解析三个阶段，其中在准备阶段就会给静态变量赋予默认值】 ---> 类的初始化【负责对类进行初始化，并会在这个过程给静态变量赋予初始化值】

```java
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(A.m);
    }
}

class A {
    static {
        m = 300;
    }
    static int m = 100;
}
```

- 第一步：类的加载`Load`，生成`A ClassLoaderTest`的`Class`对象

- 第二步：类的链接（验证 ---> 准备 ---> 解析）：在准备这一阶段会给`m`一个默认值 ---> `m = 0`

- 第三步：类的初始化

  - ```java
    <clint>() {
        m = 300;
        m = 100;
    }
    ```

**<font color="red">类的加载是通过类加载器`ClassLoader`来完成的，类加载器`ClassLoader`的作用为：</font>**

> **将字节码文件内容加载到堆内存中，并将这些静态数据转换为方法区的运行时数据结构，然后在堆内存中生成一个代表这个类`java.lang.Class`对象，作为方法区中类数据的访问入口。**

**<font color="red">类的缓存：</font>**

> 标准的`JavaSE`类加载器可以按照要求查找类，但一旦某个类字节码文件内容被类加载器加载到了内存当中，它将维持加载（缓存）一段时间。不过`JVM`垃圾回收机制可以回收这些`Class`对象。【堆内存对象就会被回收】

总的过程：**`*.java`文件 ---> `Java`编译器 ---> 字节码`.class`文件 ---> 类装载器 ---> 字节码校验器 ---> 解释器 ---> 操作系统平台**

类加载器有三种自上而下分别为：

> - **引导类加载器`Bootstrap ClassLoader`：**用`C++`编写，`JVM`自带的类加载器，负责处理`Java`平台核心库并且不被外界所使用，用于装载核心类库，所以引导类加载器是无法直接获取的。
> - **扩展类加载器`Extension ClassLoader`：**负责`jre/lib/ext`目录下的`jar`包或`java.ext.dirs`指定目录下的`jar`包装入工作库。
> - **系统类加载器`System ClassLoader`：**最常用的类加载器，负责加载一些自己编写的类。

如要需要还可以**自定义类加载器**。

```java
package Chapter07;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(systemClassLoader);
        System.out.println(systemClassLoader.getParent());
        System.out.println(systemClassLoader.getParent().getParent());
    }
}

//sun.misc.Launcher$AppClassLoader@18b4aac2
//sun.misc.Launcher$ExtClassLoader@1b6d3586
//null Bootstrap ClassLoaader 引导类加载器无法直接获取到，该类加载器加载 Java 核心类库
```

**<font color="red">使用`ClassLoader`加载配置文件：</font>**这种方式的相对路径以`src`开头，而通常的则是以`module`当前模块开头

```java
package Chapter07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesAndClassLoader {
    public static void main(String[] args) throws IOException {
        //1.传统方式获取配置文件
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("userCopy.properties");//这里最好使用 try-catch 不过懒得写了，相对路径以 module 模块开头
        properties.load(fileInputStream);
        String name1 = properties.getProperty("name");
        String password1 = properties.getProperty("password");
        System.out.println("传统方式获取配置文件 ---> " + name1 + ":" + password1);
        //2.类加载器获取配置文件
        ClassLoader classLoader = PropertiesAndClassLoader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("user.properties");//相对路径以 src 目录开头
        properties.load(inputStream);
        String name2 = properties.getProperty("name");
        String password2 = properties.getProperty("password");
        System.out.println("类加载器获取配置文件 ---> " + name2 + ":" + password2);
    }
}
```

### 创建运行时类的对象即`Class`对象

四种方式：

> 1. 通过类本身
> 2. 通过类对象
> 3. 通过`Class`类的静态方法`forName(String className)`
> 4. 通过类加载器`ClassLoader`对象

```java
package Chapter07;

public class FourGetClassObject {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.通过类本身的属性获取运行时类对象
        Class personClass1 = Person.class;
        System.out.println(personClass1);
        //2.通过类对象的 getClass() 方法获取运行时类对象
        Class personClass2 = new Person().getClass();
        System.out.println(personClass2);
        //3.通过 Class 运行时类的 forName(String className) 静态方法获取运行时类对象
        Class personClass3 = Class.forName("Chapter07.Person");
        System.out.println(personClass3);
        //4.通过 ClassLoader 类加载器获取运行时类对象
        ClassLoader classLoader = FourGetClassObject.class.getClassLoader();
        Class personClass4 = classLoader.loadClass("Chapter07.Person");
        System.out.println(personClass4);
        //不管通过什么方式，运行时类在堆内存中只有一个，所以所有运行时类对象变量都指向同一个堆内存地址
        System.out.println(personClass1 == personClass2);
        System.out.println(personClass1 == personClass3);
        System.out.println(personClass1 == personClass4);
    }
}
```

### 获取运行时类的完整结构

运行时类的结构不仅仅只有类，还包含：接口、数组、枚举、注解、基本数据类型以及`void`，而且`Class`类本身也可以获取运行时类对象。

### 调用运行时类的指定结构

可以使用：`clazz.getGenericSuperClass`获取泛型父类`Class`对象，通过`clazz.getSuperClass()`获取父类`Class`对象

# 2022年06月20日晚上

# 2022年06月21日上午

### 反射的应用：动态代理【重要】

框架：【注解 + 反射 + 设计模式】

静态代理有个不好的地方就是每一个代理类只能为一个接口服务，这样一来在开发过程中就会产生过多的代理，所以我们就希望能否只通过一个代理类就可以完成全部的代理功能。这就是我们所说的 —— **<font color="red">动态代理</font>**。

 静态代理例子：【可以看到这里写死了`nikeClothFactory`，如果我现在还有`Adidas`生产商那么这里只能新建一个代理类对象去代理`Adidas`服装工程，能否根据需要来变化服装工厂甚至直接写一个代理类工厂然后所有的需要被代理的类可以直接使用呢？这就引出了动态代理~】

```java
package Chapter07;

public class StaticProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory {
    public abstract void produceCloth();
}

class ProxyClothFactory implements ClothFactory {

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("执行生产衣服的准备工作");
        clothFactory.produceCloth();
        System.out.println("执行生产衣服的收尾工作");
    }
}

class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike 生产了一批运动裤");
    }
}
```

其实说是自己写动态代理，背后`Java`已经实现好了`Porxy`类，只要调用`newProxyInstance()`静态方法传入必要的参数就可以获取一个代理类对象。这就是动态代理。

```java
class ProxyInstance() {
    public Object getProxyInstance(Object object) {
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler(object);
        return Porxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), proxyInvocationHandler);
    }
}
```

动态代理，因为我们编译的时候是不知道要代理哪个类的所以更别说要执行哪个方法了，所以为了达到动态的效果，需要通过反射来执行方法。所以需要一个实现了`InvocationHandler`接口重写`invoke()`方法的类：

```java
class ProxyInvocationHandler implements InvocationHandler {
    private Object object;
    
    public ProxyInvocationHandler(Object object) {
        this.object = object;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object args[]) throws Throwable() {
        System.out.println("代理类执行一些准备工作...");
        Object returnObject = method.invoke(object, args);
        System.out.println("代理类执行一些收尾工作...");
        return returnObject;
    }
}
```

可以测试一下，现在不管你传入的是什么类，只要有接口，有实现类，就可以实现代理【注意这里因为要传递给`ProxyInvocationHandler`所以无法传递“接口对象”】：

```java
public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        ProxyInstance proxyInstance = new ProxyInstance();
        Human human = (Human) proxyInstance.getInstance(superMan);
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory clothFactory = (ClothFactory) proxyInstance.getInstance(nikeClothFactory);
        human.getBelief();
        System.out.println("-------------------------");
        String food = human.eat();
        System.out.println(food);
        System.out.println("-------------------------");
        clothFactory.produceCloth();
    }
}
interface Human {
    public abstract void getBelief();
    public abstract String eat();
}
```

输出结果为：

```java
代理类执行一些准备工作...
I belief i can fly!
代理类执行一些收尾工作...
-------------------------
代理类执行一些准备工作...
代理类执行一些收尾工作...
Apple
-------------------------
代理类执行一些准备工作...
Nike 生产了一批运动裤
代理类执行一些收尾工作...
```

动态代理的经典应用就是：`AOP`面向切面编程，它可以无须使用硬编码的方式实现日志等操作，而是需要的时候再织入。

# 2022年06月21日下午

# 2022年06月21日晚上

## `Java8`的其它新特性

速度更快、新的语法表达式[`Lambda`表达式]、强大的`Stream API`、便于并行、最大化减少空指针异常：`Optional`、`Nashorn`引擎【之前是`Rhino`引擎但是实在是太慢太慢了，所以还不如重写】可以执行`js`程序

### 函数式接口`@FunctionalInterface`

**<font color="red">使用`Lambda`的前提条件是接口中只有一个抽象方法，这种只有一个抽象方法的接口也称为函数式接口。通常有`@FunctionalInterface`注解进行注解</font>**

**只要是函数式接口，那么它就可以使用`Lambda`表达式来写。**

`Java`内置`4`大核心函数式接口：

> 1. 消费型接口`Consumer`：`Consumer<T> void accept(T t)`
> 2. 供给型接口`Supplier`：`T get()`
> 3. 函数型接口`Function`：`R apply(T t)`
> 4. 判断型接口`Predicate`：`boolean test(T t)`

```java
package Chapter08;

import java.util.function.Consumer;

public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        happyTime(100000.8988, new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println("代号白金刺客消费：" + money + "元");
            }
        });
        happyTime(100000.9899, money -> System.out.println("代号黄金刺客消费：" + money + "元"));
    }

    public static void happyTime(Double price, Consumer<Double> consumer) {
        consumer.accept(price);
    }
}
```

```java
package Chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("北京");
        arrayList.add("天津");
        arrayList.add("南京");
        arrayList.add("上金");
        arrayList.add("西京");
        arrayList.add("夏津");
        arrayList.add("东京");
        //1.传统的使用匿名函数的方式完成过滤
        ArrayList<String> newArrayList = getPredicateArrayList(arrayList, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(newArrayList);
        //2.使用 Lambda 表达式的方式完成过滤
        ArrayList<String> newLambdaArrayList = getPredicateArrayList(arrayList, str -> str.contains("京"));
        System.out.println(newLambdaArrayList);
    }

    public static ArrayList<String> getPredicateArrayList(ArrayList<String> arrayList, Predicate<String> predicate) {
        ArrayList<String> newArrayList = new ArrayList<String>();
        for (String str : arrayList) {
            if (predicate.test(str)) newArrayList.add(str);
        }
        return newArrayList;
    }
}

//[北京, 南京, 西京, 东京]
//[北京, 南京, 西京, 东京]
```

### `Lambda`表达式

`Lambda`表示可以理解为一段可传递的代码，相当于匿名函数。其本质就是作为接口的实例。

举例：`(o1, o2) -> Integer.compare(o1, o2);`

格式：

```java
->：表示 Lambda 的操作符/箭头操作符
-> 左边：Lamdba 形参列表【其实就是接口中抽象方法的形参列表】
-> 右边：Lambda 体【其实就是重写的抽象方法的方法体】
```

`Lambda`常见语法格式：

```java
1. 没有形参，没有返回值
    Runnable runnable = () -> System.out.println("毛爷爷");
	runnable.run();
2. 有一个形参，没有返回值
    Consumer<String> consumer = (String str) -> System.out.println(str);
	consumer.accept("Apple");
3. 数据类型可以省略，因为编译器可以推断出来，称为“类型推断”【数组那一节中有学习过】
    Consumer<String> consumer = (str) -> System.out.println(str);
	consumer.accept("Apple");
4. 只有一个参数，参数小括号可省略
    Consumer<String> consumer = str -> System.out.println(str);
	consumer.accept("Apple");
5. 有两个或以上的参数，多条执行语句，并且可以有返回值
    Comparator<Integer> comparator = (Integer o1, o2) -> {
    	System.out.println("Lambda 表达式实现函数式接口方法！");
    	return Integer.compare(o1, o2);
	}
	Integer compare = comparator.compare(1, 2);
	System.out.println(compare);
6. 若只有一条语句，则 return 和大括号都可以省略
    Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
	Integer compare2 = comparator1.compare(1000, 102);
	System.out.println(compare2);
```

### 方法引用

方法引用和构造器引用时基于`Lambda`表达式的。写了一两个方法引用之后就会发现无非就是写好的方法放到了方法引用而已。 

比方说：`Consumer`接口你是需要重写`accept(Object objet)`方法的，假设你现在里面只有一条打印语句，那你直接就使用`printStream::out`输出这个对象即可【前提是你就是想这样做，如果不是这样做，那你可以使用匿名函数或者`Lambda`表达式】

只要有现成方法可以使用的，那么你就可以使用方法引用。方法引用是`Lambda`一种特殊情况，或者说是更深层次的`Lamdba`表达式，只要你可以使用一个现有方法可以完成的，那么你就可以使用方法引用。然后只要你实现的抽象接口中只有一个抽象方法，那么你就可以使用`Lambda`表达式。

```java
package Chapter08;

import Chapter07.Person;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodQuote {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    //方法是非静态方法 可以使用对象::非静态方法调用
    //消费型函数式接口Consumer:accept(T) 一个参数 + 无返回值
    public static void test1() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("毛爷爷");
        System.out.println("--------------------------");
        consumer = (String str) -> System.out.println(str);
        consumer.accept("石头");
        System.out.println("--------------------------");
        PrintStream printStream = System.out;
        consumer = printStream::println;
        consumer.accept("Chinese Father");
        System.out.println("--------------------------");
    }

    //供给型函数式接口Supplier:get() return T; 没有参数 + 有返回值
    public static void test2() {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "获取了大葫芦娃";
            }
        };
        String BigHuLuWa = supplier.get();
        System.out.println(BigHuLuWa);
        System.out.println("--------------------------");
        supplier = () -> {
            return "获取了中葫芦娃";
        };
        String MiddleHuLuWa = supplier.get();
        System.out.println(MiddleHuLuWa);
        System.out.println("--------------------------");
        HuLuWa huLuWa = new HuLuWa();
        supplier = huLuWa::toString;
        String smallHuLuWa = supplier.get();
        System.out.println(smallHuLuWa);
        System.out.println("--------------------------");
    }

    //方法是静态方法可以使用 类::静态方法调用
    public static void test3() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        Integer answer1 = comparator.compare(100, 200);
        System.out.println(answer1);
        System.out.println("--------------------------");
        comparator = (Integer o1, Integer o2) -> {
            return Integer.compare(o1, o2);
        };
        Integer answer2 = comparator.compare(200, 100);
        System.out.println(answer2);
        System.out.println("--------------------------");
        comparator = Integer::compare;
        Integer answer3 = comparator.compare(100, 100);
        System.out.println(answer3);
        System.out.println("--------------------------");
    }

    //函数型函数式接口Function<T, G>:apply(T t); 有参数[前者表示形式参数，后者表示返回值数据类型] + 有返回值
    //其实就是数学中的函数：y = x^2;
    public static void test4() {
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        Integer answer = function.apply(32);
        System.out.println(answer);
        System.out.println("--------------------------");
        function = (Integer x) -> {
            return x * x;
        };
        answer = function.apply(64);
        System.out.println(answer);
        System.out.println("--------------------------");
        function = Math::abs;
        answer = function.apply(-100);
        System.out.println(answer);
        System.out.println("--------------------------");
    }

    //方法是非静态方法，还可以使用 类::非静态方法，如果第一个参数作为调用方法的对象去使用，则可以使用该种方法
    //比如String类中的compareTo方法：t1.compareToe(t2)，再比如：t1.equals(t1)皆是如此
    public static void test5() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Integer answer = comparator.compare("abc", "abe");
        System.out.println(answer);
        System.out.println("--------------------------");
        comparator = (String s1, String s2) -> s1.compareTo(s2);
        answer = comparator.compare("abd", "abe");
        System.out.println(answer);
        System.out.println("--------------------------");
        comparator = String::compareTo;
        answer = comparator.compare("abe", "abe");
        System.out.println(answer);
    }

    //t1.equals(t2)
    public static void test6() {
        System.out.println("--------------------------");
        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s1, String s2) {
                return s1.equals(s2);
            }
        };
        boolean predicate = biPredicate.test("abc", new String("abc"));
        System.out.println(predicate);
        System.out.println("--------------------------");
        biPredicate = (String s1, String s2) -> s1.equals(s2);
        predicate = biPredicate.test("abcdef", new String("abc"));
        System.out.println(predicate);
        System.out.println("--------------------------");
        biPredicate = String::equalsIgnoreCase;
        predicate = biPredicate.test("abcABC", new String("abcabc"));
        System.out.println(predicate);
    }
}

class HuLuWa {
    private String name;

    public HuLuWa() {
    }

    public HuLuWa(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "获取了小葫芦娃";
    }
}
```

### 构造器引用

构造器引用其实就是方法引用的一个小型应用而已。

```java
package Chapter08;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorQuote {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    //Supplier:get() return T t;
    public static void test1() {
        Supplier<HuLuWa> supplier = new Supplier<HuLuWa>() {
            @Override
            public HuLuWa get() {
                return new HuLuWa("小葫芦娃");
            }
        };
        HuLuWa littleHuLuWa = supplier.get();
        System.out.println(littleHuLuWa.toString());
        System.out.println("--------------------------");
        supplier = () -> new HuLuWa("中葫芦娃");
        HuLuWa middleHuLuWa = supplier.get();
        System.out.println(middleHuLuWa.toString());
        System.out.println("--------------------------");
        supplier = HuLuWa::new;
        HuLuWa bigHuLuWa = supplier.get();
        bigHuLuWa.setName("大葫芦娃");
        System.out.println(bigHuLuWa.toString());
        System.out.println("--------------------------");
    }

    //Function:apply(T t) return G g;
    public static void test2() {
        Function<String, HuLuWa> function = new Function<String, HuLuWa>() {
            @Override
            public HuLuWa apply(String s) {
                return new HuLuWa(s);
            }
        };
        HuLuWa goldWa = function.apply("金娃");
        System.out.println(goldWa);
        System.out.println("--------------------------");
        function = (String name) -> new HuLuWa(name);
        HuLuWa treeWa = function.apply("木娃");
        System.out.println(treeWa);
        System.out.println("--------------------------");
        function = HuLuWa::new;
        HuLuWa waterWa = function.apply("水娃");
        System.out.println(waterWa);
        System.out.println("--------------------------");
    }

    //BiFunction:apply(T t, G g) return U u;
    public static void test3() {
        BiFunction<String, Integer, FiveField> biFunction = new BiFunction<String, Integer, FiveField>() {
            @Override
            public FiveField apply(String name, Integer power) {
                return new FiveField(name, power);
            }
        };
        FiveField fiveField = biFunction.apply("金", 8);
        System.out.println(fiveField);
        System.out.println("--------------------------");
        biFunction = (String name, Integer power) -> new FiveField(name, power);
        fiveField = biFunction.apply("木", 8);
        System.out.println(fiveField);
        System.out.println("--------------------------");
        biFunction = FiveField::new;
        fiveField = biFunction.apply("水", 8);
        System.out.println(fiveField);
        System.out.println("--------------------------");
        biFunction = FiveField::new;
        fiveField = biFunction.apply("火", 8);
        System.out.println(fiveField);
        System.out.println("--------------------------");
        biFunction = FiveField::new;
        fiveField = biFunction.apply("土", 8);
        System.out.println(fiveField);
        System.out.println("--------------------------");
    }
}

class FiveField {
    private String name;
    private Integer power;

    public FiveField() {
    }

    public FiveField(String name, Integer power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return name + " : 能量值 : " + power;
    }
}
```

### 强大的`Stream API`

`Java8`中有两个重要的改变。第一个就是`Lambda`表达式，另外一个就是`Stream API`。**<font color="deepskyblue">使用`Stream API`就像使用`SQL`查询语句。</font>**

**<font color="red">为什么要使用`Stream API`？</font>**

- 当前实际开发的过程中，不仅仅有关系型数据库，还有非关系型数据库`MongoDB Redis`这些，这些非关系型数据库就需要`Java`层面去处理。
- `Stream`和`Collection`的区别在于：后者是一种静态的内存数据结构跟内存/存储器打交道，前者则用于计算的需要跟处理器打交道。所以说：`Stream`是不做存储数据的，存储数据的事情你让`Collection`集合面向内存/存储器去干。

**使用`Stream`的注意点：**

1. `Stream`自己是不存储元素的
2. `Stream`不会改变源对象而是返回持有新结果的`Stream`对象
3. `Stream`的操作是延迟执行的，意味着它们会先获取结果然后才执行【只有调用终止操作才会执行中间操作链】

**操作`Stream`的三个步骤：**【在声明下：`Stream`是跟处理器打交道的，用来计算的】

1. 创建`Stream`

   - 一个数据源【集合、数组等】 ---> 获取一个流【顺序流（同步流） + 并行流】

     ```java
     ArrayList<Integer> arrayList = new ArrayList<>();
     //1.通过集合创建流 Stream
     Stream stream1 = arrayList.stream();//返回一个顺序流
     Stream stream2 = arrayList.parallelStream();//返回一个顺序流
     //2.通过数组创建流 Stream
     int[] array1 = {1, 2, 3, 4, 5, 6};
     IntStream intStream = Arrays.stream(array1);
     String[] array2 = {"1", "2", "3"};
     Stream<String> stream = Arrays.stream(array2);
     //3.通过Stream.of()创建流 Stream
     Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5, 6);//放入的是包装类
     //4.创建无限流 ---> 无限元素
     Stream.iterate(0, x -> 2 + x).limit(10).forEach(System.out::println);
     //  生成无限流 ---> 无限元素
     Stream.generate(Math::random).limit(10).forEach(System.out::println);
     ```

2. 中间操作

   - 一个中间操作链，对数据源的数据进行处理

     - 中间操作之：筛选与切片

       ```java
       String[] huLuWas = new String[]{"金娃", "木娃", "水娃", "火娃", "土娃", "金娃", "金娃", "金娃", "金娃"};
       Stream<String> huLuWaStream = Arrays.stream(huLuWas);
       //1.筛选与切片
       //（1）过滤 filter(Predicate predicate)：从流中排除某些符合特定条件的元素
       huLuWaStream.filter((String str) -> str.contains("金")).forEach(System.out::print);
       System.out.println();
       //因为这里已经执行了终止操作，是无法回到中间操作的。所以这里会报错。
       //（2）截断 limit(n)：使其元素不超过给定数量
       huLuWaStream = Arrays.stream(huLuWas);
       huLuWaStream.limit(3).forEach(System.out::print);
       System.out.println();
       //（3）跳过 skip(n)：返回一个扔掉了前 n 个元素的流
       huLuWaStream = Arrays.stream(huLuWas);
       huLuWaStream.skip(3).forEach(System.out::print);
       System.out.println();
       //（4）筛选 distinct()：去除重复元素
       huLuWaStream = Arrays.stream(huLuWas);
       huLuWaStream.distinct().forEach(System.out::print);
       System.out.println();
       ```

     - 中间操作之：映射

       ```java
       //2.映射
       //（1） map：接受一个函数作为参数，将元素转换成其他形式或提取信息
       List<String> list = Arrays.asList("aa", "bb", "cc");
       list.stream().map(str -> str.toUpperCase()).forEach(System.out::print);
       System.out.println();
       list = Arrays.asList("aaa", "b", "ccccc", "dddddddddd");
       list.stream().map(str -> str.length() > 6 ? str : "").forEach(System.out::print);
       System.out.println();
       //（2） flatMap：接受一个函数作为参数，将流中的每个值转换成另外一个流
       ```

     - 中间操作之：排序

       ```java
       //3.排序
       List<Integer> list1 = Arrays.asList(100, 88, 23, 989, 652, 735, 412, 399);
       //（1） sorted()：产生一个新流，按照自然顺序排序
       list1.stream().sorted().forEach(System.out::print);
       System.out.println();
       //（2） sorted(Comparator com)：产生一个新流，按照自定义顺序排序
       list1.stream().sorted((Integer o1, Integer o2) -> -(Integer.compare(o1, o2))).forEach(System.out::print);
       ```

   - 总结：

     ```java
     package Chapter08;
     
     import java.util.ArrayList;
     import java.util.Arrays;
     import java.util.List;
     import java.util.function.Consumer;
     import java.util.stream.Stream;
     
     public class MiddleStreamTest {
         public static void main(String[] args) {
             String[] huLuWas = new String[]{"金娃", "木娃", "水娃", "火娃", "土娃", "金娃", "金娃", "金娃", "金娃"};
             Stream<String> huLuWaStream = Arrays.stream(huLuWas);
             //1.筛选与切片
             //（1）过滤 filter(Predicate predicate)：从流中排除某些符合特定条件的元素
             huLuWaStream.filter((String str) -> str.contains("金")).forEach(System.out::print);
             System.out.println();
             //因为这里已经执行了终止操作，是无法回到中间操作的。所以这里会报错。
             //（2）截断 limit(n)：使其元素不超过给定数量
             huLuWaStream = Arrays.stream(huLuWas);
             huLuWaStream.limit(3).forEach(System.out::print);
             System.out.println();
             //（3）跳过 skip(n)：返回一个扔掉了前 n 个元素的流
             huLuWaStream = Arrays.stream(huLuWas);
             huLuWaStream.skip(3).forEach(System.out::print);
             System.out.println();
             //（4）筛选 distinct()：去除重复元素
             huLuWaStream = Arrays.stream(huLuWas);
             huLuWaStream.distinct().forEach(System.out::print);
             System.out.println();
             //--------------------------------------------------------------------
             //2.映射
             //（1） map：接受一个函数作为参数，将元素转换成其他形式或提取信息
             List<String> list = Arrays.asList("aa", "bb", "cc");
             list.stream().map(str -> str.toUpperCase()).forEach(System.out::print);
             System.out.println();
             list = Arrays.asList("aaa", "b", "ccccc", "dddddddddd");
             list.stream().map(str -> str.length() > 6 ? str : "").forEach(System.out::print);
             System.out.println();
             //（2） flatMap：接受一个函数作为参数，将流中的每个值转换成另外一个流
             //--------------------------------------------------------------------
             //3.排序
             List<Integer> list1 = Arrays.asList(100, 88, 23, 989, 652, 735, 412, 399);
             //（1） sorted()：产生一个新流，按照自然顺序排序
             list1.stream().sorted().forEach(System.out::print);
             System.out.println();
             //（2） sorted(Comparator com)：产生一个新流，按照自定义顺序排序
             list1.stream().sorted((Integer o1, Integer o2) -> -(Integer.compare(o1, o2))).forEach(System.out::print);
         }
     }
     ```

3. 终止操作

   - 一旦执行终止操作就会执行中间操作链，并产生结果。然后中间操作链将变得不可用。

     - 终止操作之：匹配与查找

       ```java
       1. allMatch(Predicate p)：检查是否匹配所有的元素
       2. anyMatch(Predicate p)：检查是否匹配一个的元素
       3. noneMatch(Predicate p)：检查是否没有匹配的元素 ---> 其实就是 非all
       4. findFirst：返回第一个元素
       5. findAny：返回任意元素
       6. count：返回流中元素的总个数
       7. max(Comparator c)：返回流中最大值
       8. min(Comparator c)：返回流中最小值
       9. forEach(Consumer c)：内部迭代
       ```

       ```java
       //1.匹配与查找
       List<Integer> list = Arrays.asList(100, 88, 23, 989, 652, 735, 412, 399);
       System.out.println(list.stream().allMatch(x -> x > 10));
       System.out.println(list.stream().anyMatch(x -> x > 100));
       System.out.println(list.stream().noneMatch(x -> x > 1000));
       System.out.println(list.stream().findFirst());
       System.out.println(list.stream().findAny());
       System.out.println(list.stream().count());
       System.out.println(list.stream().max(Integer::compare));
       System.out.println(list.stream().min(Integer::compare));
       list.stream().forEach(x -> System.out.print(x + " "));

     - 终止操作之：归约

       ```java
       1.reduce(T iden, BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 T
       2.reduece(BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
       ```

       备注：`map`和`reduce`的连接通常称为：`map-reduce`模式，因`Google`用此来做网络搜索而出名。

       ```java
       //2.规约
       //1.计算 1-10 的自然数的和
       List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
       System.out.println(list1.stream().reduce(0, Integer::sum));//第一个参数相当于一个初始值
       
       ```

     - 终止操作之：收集

       ```java
       1.collect(Collector c)：将流转换为其它形式。接收一个 Collector 接口的实现，用于给 Stream 中元素做汇总的方法    
       ```

       ```java
       //3.收集
       List<Integer> list2 = list.stream().filter(x -> x > 600).collect(Collectors.toList());
       System.out.println(list2);
       ```

### `Optional`类【容器】

最常见的异常就是`NullPointerException`即空指针异常，有没有什么东西可以检查空指针呢？在`Java8`中引入了`Optional`类【从`Google`公司的`Guava`项目引入了`Optional`类中有感而发】。

`Optional<T>`类是一个容器类，它可以保存类型`T`的值，代表这个值是存在的。或者仅仅保存`null`，表示这个值不存在。`Optional`存放的元素要求是非空的`of()`。

1. `Optional.of();`
2. `Optional.ofNullable();`
3. `optionalHuLuWa.orElse(new HuLuWa("火娃"));`如果`optionalHuLuWa`对象为空则返回一个新的对象
4. `boolean isPresent()`：判断容器是否包含该对象
5. `get()`：跟`isPresent`连用先判断，如果存在可获取

```java
package Chapter08;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        HuLuWa huLuWa = new HuLuWa("金娃");
        Optional<HuLuWa> optionalHuLuWa1 = Optional.of(huLuWa);
        huLuWa = null;
        Optional<HuLuWa> optionalHuLuWa2 = Optional.ofNullable(huLuWa);
        System.out.println(huLuWa);
        HuLuWa huLuWa1 = optionalHuLuWa2.orElse(new HuLuWa("火娃"));//如果为空就新建一个火娃，降低了空指针异常的风险
        System.out.println(huLuWa1);
        if(optionalHuLuWa1.isPresent()) {
            System.out.println(optionalHuLuWa1.get());
        }
    }
}
```
