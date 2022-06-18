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

  - `char`占用`2`字节，表示字符，一个汉字正好是`2`字节，所以可以直接存储汉字，`char`存储数值可以有三种表现形式：`char c1 = 'a'`，`Java`中还允许使用转义字符`\`，并且可以使用十六进制如：`\u000a`表示`\n`，`char`数据类型是可以进行运算的，因为它有对应的`Unicode`码，可以进行运算。常见的`65 - Chapter04.A， 97 - a`，为了跨界形成了万国码`Unicode`，其中最广泛应用的`Unicode`实现方式就是`UTF-8`，注意`char`跟`char`是做运算，`char`跟`string`是连接

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

二进制以`0b 0B`开头，八进制以`0`开头`3 位二进制表示`，十六进制以`0x 0X`开头`4 位二进制表示`，`Chapter04.A-F`不区分大小写。<font color="red">**计算机存储都是以补码的形式存储数据**</font>，正数的原码反码和补码都是它本身，负数的补码是原码取反码+1。

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
   public class Chapter04.Test {
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
class Chapter04.Base {
    int count = 10;

    public void display() {
        System.out.println(this.count);
    }
}

class Chapter04.Sub extends Chapter04.Base {
    int count = 20;

    public void display() {
        System.out.println(this.count);
    }
}

public class Chapter04.FieldMethodTest {
    public static void main(String[] args) {
        Chapter04.Sub s = new Chapter04.Sub();
        System.out.println(s.count);//输出 20
        s.display();//Chapter04.Sub 重写了父类 Chapter04.Base 中的 display 方法，打印 20
        Chapter04.Base b = s;//父类引用指向子类对象，这里用到了多态，所以 b 其实是一个 Chapter04.Sub 对象，跟 s 指向同一个地址
        System.out.println(b == s);//这里比较的是内存地址，b 跟 s 都指向同一个内存地址，所以为 true
        System.out.println(b.count);//10 这里因为 Chapter04.Base b 的缘故，所以在堆内存中会有父类的属性，找的话是先找父类的属性
        b.display();//20 因为这里是 this ，指向的是 Chapter04.Sub 类对象方法区中的方法，如果这里改成 super，那么指向的就是父类的，结果就变为 10，或者找不到才会去找父类的
    }
}
```

如果不懂可以看下这张内存图：

![](https://img-blog.csdnimg.cn/019cbf1e599d41048be1e336aa34f664.png)

- 问：多态是编译时行为还是运行时行为？
- 答：只有在调用的那一刻才知道到底调用的是哪个类的方法，所以是运行时行为。

```java
class Chapter04.Base {
    public void add(int a, int...arr) {
        System.out.println("base");
    }
}

class Chapter04.Sub extends Chapter04.Base {
    public void add(int a, int[] arr) {
        System.out.println("sub_1");
    }
    
    public void add(int a, int b, int c) {
        System.out.println("sub_2");
    }
}

public class Chapter04.FieldMethodTest {
    public static void main(String[] args) {
        Chapter04.Base base = new Chapter04.Sub();
        base.add(1, 2, 3);//输出 sub_1，编译没问题，调用的是 Chapter04.Sub 类的 add 方法，编译器认为int...arr 和 int[] arr 是一样的 如果把 sub_2 打开把 sub_1 合上输出的则为 base，如果不合上，输出的还是 base_1
        Chapter04.Sub s = (Chapter04.Sub)base;//s 指向的跟 base 一样 指向在堆内存中的一个 Chapter04.Sub 对象
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
  char a = 'Chapter04.A';
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
char ch1 = 'Chapter04.A';
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
  private static Chapter04.Test test = new Chapter04.Test();
  
  private Chapter04.Test() {
  }
  
  public static Chapter04.Test getObject() {
      return test;
  }
  ```

- 懒汉式单例模式：【每次要创建都判断定义的对象是不是`null`，如果是就`new`一个不是的话就直接返回，太懒了，你要的话我才给你】

  ```java
  private static Chapter04.Test test = null;
  
  private Chapter04.Test() {
  }
  
  private static Chapter04.Test getObject() {
      if(test != null) return test;
      else return new Chapter04.Test();
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
  public class Chapter04.FieldMethodTest {
      public Chapter04.FieldMethodTest() {
          System.out.println("这是构造器！");
      }
  
      public static void main(String[] args) {
          Chapter04.FieldMethodTest fieldMethodTest = new Chapter04.FieldMethodTest();
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

  `Object`类中的`getClass()`方法就被`final`修饰了，表明无法被重写，因为这个方法只有这种搞法，无需重写，没那个必要。可以发现有一个`native`，`native`的意思就是接下来要调用的底层的`Chapter04.C/Chapter04.C++`了。

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
   private Chapter04.Test test = new Chapter04.Test();
   
   private Chapter04.Test() {
   }
   
   public Chapter04.Test getTest() {
       return test;
   }
   ```

4. 代码实现单例模式的懒汉式【线程不安全】

   ```java
   private Chapter04.Test test = null;
   
   private Chapter04.Test() {
   }
   
   public Chapter04.Test getTest() {
       if(test == null) return new Chapter04.Test();
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
   public class Chapter04.Father {
       public static void method() {
           System.out.println("This is a Chapter04.Father method.");
       }
   }
   
   class Chapter04.Son extends Chapter04.Father {
       public static void method() {
           System.out.println("This is a Chapter04.Son method");
       }
   
       public static void main(String[] args) {
          Chapter04.Father son  = new Chapter04.Son();
          son.method();
       }
   }
   ```

   上述代码如果`method`重写了的话，那么调用的时候肯定是打印`Chapter04.Son`中的，但是现在这里打印的是`Chapter04.Father`中的，也就是说静态方法看似被重写了，其实并没有。那暂时就先记住，静态方法看似重写实则没有重写，而被`abstract`修饰的方法是必须被重写才有意义的，所以`abstract`关键字无法修饰静态方法

4. **`abstract`关键字不能用来修饰`final`修饰的最终方法以及最终类**，因为`final`修饰的方法表示最终的，无法被子类重写，那就与被`abstract`关键字修饰的方法必须被重写是相互违背的，所以`abstract`无法修饰被`final`关键字修饰的方法，相应的也无法修饰被`final`修饰的类，因为无法被继承。

抽象类的匿名子类对象：

```java
Chapter04.Father father = new Chapter04.Father() {
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

接口中的属性默认是静态常量：`public static final int Chapter04.A = 1;`

接口中的方法默认是公共抽象方法：`public abstract void Chapter04.B();**`**

**<font color="red">相比于抽象类，抽象类是有构造器的，但是接口不允许有构造器，因为接口比抽象类还要抽象，抽象类可以通过多态机制实现间接实例化，但是接口无法被实例化【这里暂且忽视掉匿名内部类】，因为它压根就没有构造器！</font>**

实现了一个接口的类必须对接口中所有的方法进行方法重写，否则它只能加上一个`abstract`表示这是一个抽象类而无法被直接实例化。

关于接口还有一个比较特殊的点就是：

**接口是为了解决类的单继承所诞生的东西，所以一个类可以实现多个接口，那接口与接口之间呢？**

**<font color="red">接口与接口之间可以实现多继承！也就是一个接口是可以继承多个接口的！</font>**

**习题：**

1. 排错：编译错误，接口`Chapter04.A`和类`Chapter04.B`都声明了属性`x`，`pX()`方法中不知道到底要用哪个

   可以改成：`Chapter04.A.x`或者`super.x`

   ```java
   interface Chapter04.A {
       public static final int x = 0;
   }
   
   class Chapter04.B {
       int x = 1;
   }
   
   class Chapter04.C extends Chapter04.B implements Chapter04.A {
       public void pX() {
           System.out.println(x);
       }
       
       public static void main(String[] args) {
           new Chapter04.C().pX();
       }
   }
   ```

## 代理模式设计模式

代理模式是`Java`开发中比较常用的设计模式，前面我们学习了：单例模式【懒汉式、饿汉式】还有模板方法设计模式。这些都是常用的设计模式。代理模式这种设计模式就是为其他对象提供一种代理以控制对这个对象的访问。所谓代理其实就是中介。**其实就是把本身`Chapter04.A`要做的事情，`Chapter04.B`把它给做了。**比如这里：`Chapter04.ProxyServer`做了检查但是`Chapter04.Server`并没有做检查，这就是代理。

```java
public interface Chapter04.Network {
    public abstract void work();
}

class Chapter04.Server implements Chapter04.Network {
    @Override
    public void work() {
        System.out.println("服务器完成联网，开始工作...");
    }
}

class Chapter04.ProxyServer implements Chapter04.Network {

    private Chapter04.Server server = null;

    public Chapter04.ProxyServer(Chapter04.Server server) {
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

class Chapter04.Test {
    public static void main(String[] args) {
        Chapter04.Server server = new Chapter04.Server();
        Chapter04.ProxyServer proxyServer = new Chapter04.ProxyServer(server);
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
public class Chapter04.SomeElse {
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
  public class Chapter04.MyException extends RuntimeException {
      static final long serialVersionUID = -7034897190745766939L;
  
      public Chapter04.MyException() {
      }
  
      public Chapter04.MyException(String msg) {
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

> 进入方法`Chapter04.A` 
>
> 方法`Chapter04.A`中的`finally`
>
> 制造异常
>
> 进入方法`Chapter04.A` 
>
> 方法`Chapter04.A`中的`finally`

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
public class Chapter04.MoreThread extends Thread {
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
public class Chapter04.MoreThread extends Thread {

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
        Chapter04.MoreThread moreThread1 = new Chapter04.MoreThread();
        Chapter04.MoreThread moreThread2 = new Chapter04.MoreThread();
        Chapter04.MoreThread moreThread3 = new Chapter04.MoreThread();
        moreThread1.setName("1 号窗口");
        moreThread2.setName("2 号窗口");
        moreThread3.setName("3 号窗口");
        moreThread1.start();
        moreThread2.start();
        moreThread3.start();
    }
}

class Chapter04.MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}

class Chapter04.MyThread2 extends Thread {
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
public class Chapter04.MoreThread extends Thread {
    public static void main(String[] args) {
        Chapter04.MyThread3 myThread3 = new Chapter04.MyThread3();
        Thread thread = new Thread(myThread3);
        thread.start();
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}

class Chapter04.MyThread3 implements Runnable {
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
public class Chapter04.Test {
    private Chapter04.Test test = null;
    
    private Chapter04.Test() {}
    
    public static Chapter04.Test getTest() {
     	if(test == null) test = new Chapter04.Test;
    	return test;   
    }
}
```

学习了线程安全的解决方法之后可以这样改动：

```java
public class Chapter04.Test {
    private Chapter04.Test test = null;
    
    private Chapter04.Test() {}
    
    public static Chapter04.Test getTest() {
        //这里也可以使用 test 当作锁【因为是唯一的】
        synchronized(Chapter04.Test.class) {
	     	if(test == null) test = new Chapter04.Test;
	    	else return test;	           
        }
    }
    
    //效率较低 ---> 出现安全问题的只是 test 如果 test 不为 null 直接返回即可
    public static synchronized Chapter04.Test getTest1() {
     	if(test == null) test = new Chapter04.Test;
		else return test;	           
    }
    
    public static synchronized Chapter04.Test getTest2() {
        if(test == null) {
            synchronized(Chapter04.Test.class) {
                if(test == null)	test = new Chapter04.Test();
            }
        }
        return test;
    }
}
```

## 线程死锁问题

死锁：很好理解，比如某个线程拿着`Chapter04.A`锁进入一个方法，另一个线程拿着`Chapter04.B`锁进入方法，`Chapter04.A`锁中的方法里面又需要拿到`Chapter04.B`锁，而`Chapter04.B`锁方法里边恰恰相反，需要拿到`Chapter04.A`锁，此时是就造成了死锁。

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
   public class Chapter04.SaveMoney {
       public static void main(String[] args) {
           Chapter04.Account account = new Chapter04.Account();
           Thread Chapter04.A = new Thread(account);
           Thread Chapter04.B = new Thread(account);
           Chapter04.A.setName("张三");
           Chapter04.B.setName("李四");
           Chapter04.A.start();
           Chapter04.B.start();
       }
   }
   
   class Chapter04.Account implements Runnable {
   
       private int accountMoney = 0;
       private int saveTime = 1;
   
       @Override
       public void run() {
           while (true) {
               synchronized (this/Chapter04.Account.class) {
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
   public class Chapter04.SaveMoney {
       public static void main(String[] args) {
           Chapter04.Account account = new Chapter04.Account();
           Thread Chapter04.A = new Thread(account);
           Thread Chapter04.B = new Thread(account);
           Chapter04.A.setName("张三");
           Chapter04.B.setName("李四");
           Chapter04.A.start();
           Chapter04.B.start();
       }
   }
   
   class Chapter04.Account implements Runnable {
   
       private int accountMoney = 0;
       private int saveTime = 1;
   
       @Override
       public void run() {
           while (true) {
               show();
           }
       }
   
       //这里的同步监视器默认使用的就是：this 还可以加个 static 表示当前类 Chapter04.Account.class
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
   
   public class Chapter04.SaveMoney {
       public static void main(String[] args) {
           Chapter04.Account account = new Chapter04.Account();
           Thread Chapter04.A = new Thread(account);
           Thread Chapter04.B = new Thread(account);
           Chapter04.A.setName("张三");
           Chapter04.B.setName("李四");
           Chapter04.A.start();
           Chapter04.B.start();
       }
   }
   
   class Chapter04.Account implements Runnable {
   
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
   
   public class Chapter04.SaveMoney {
       public static void main(String[] args) {
           Chapter04.Account Chapter04.A = new Chapter04.Account();
           Chapter04.Account Chapter04.B = new Chapter04.Account();
           Chapter04.A.setName("张三");
           Chapter04.B.setName("李四");
           Chapter04.A.start();
           Chapter04.B.start();
       }
   }
   
   class Chapter04.Account extends Thread {
   
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
   
   public class Chapter04.SaveMoney {
       public static void main(String[] args) {
           Chapter04.Account Chapter04.A = new Chapter04.Account();
           Chapter04.Account Chapter04.B = new Chapter04.Account();
           Chapter04.A.setName("张三");
           Chapter04.B.setName("李四");
           Chapter04.A.start();
           Chapter04.B.start();
       }
   }
   
   class Chapter04.Account extends Thread {
   
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
   
   public class Chapter04.SaveMoney {
       public static void main(String[] args) {
           Chapter04.Account Chapter04.A = new Chapter04.Account();
           Chapter04.Account Chapter04.B = new Chapter04.Account();
           Chapter04.A.setName("张三");
           Chapter04.B.setName("李四");
           Chapter04.A.start();
           Chapter04.B.start();
       }
   }
   
   class Chapter04.Account extends Thread {
   
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

- **<font color="red">【这三个的调用者必须跟同步监视器保持一致！否则报错，这也是为什么我写`Chapter04.WN.class`报错写`Object`也报错的原因，你也可以改成：`object.notify() object.wait()`但，这又是为什么一定要写成一致的呢？】</font>**

  **【上述原因：一旦将一个对象设置成锁之后，我们内存中就有一个区域叫做对象头，对象头会存放同步监视器的状态和信息，当使用`wait()`方法的时候会去找这个同步监视器然后释放】**

- `wait()`：当前线程进入阻塞状态
- `notify()`：唤醒进入阻塞状态的单个线程【按优先级】
- `notifyAll()`：唤醒所有进入阻塞状态的线程

执行两个线程，交替打印`1-100`：【写代码的时候发现用继承的方式无法写，不知道后续是否可以解决？是真的不可以还是有什么不知道的东西？还有就是这里即使使用了`Runnable`的方式来写，但是这里一旦使用了`notify`，我`synchronized`里的同步监视器就无法使用`类.class`作为同步监视器，只能用`this`，这是为何？】

```java
public class Chapter04.WaitAndNotify {
    public static void main(String[] args) {
        Chapter04.WN wn = new Chapter04.WN();
        Thread t1 = new Thread(wn);
        Thread t2 = new Thread(wn);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

class Chapter04.WN implements Runnable {

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
public class Chapter04.ProAndCon implements Runnable {

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

class Chapter04.ProConTest {
    public static void main(String[] args) {
        Chapter04.ProAndCon proAndCon = new Chapter04.ProAndCon();
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

public class Chapter04.CallableTest implements Callable {

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

class Chapter04.CTest {
    public static void main(String[] args) {
        Chapter04.CallableTest callableTest = new Chapter04.CallableTest();
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

public class Chapter04.ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Chapter04.ThreadRunnable1());
        executorService.execute(new Chapter04.ThreadRunnable2());
        //executorService.submit();//适用于Callable方法
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        threadPoolExecutor.setCorePoolSize(10);//设置核心池的大小
        threadPoolExecutor.setMaximumPoolSize(10);//设置最大连接线程数量
        //threadPoolExecutor.setKeepAliveTime();//设置线程最长连接时间
        executorService.shutdown();
    }
}

class Chapter04.ThreadRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

class Chapter04.ThreadRunnable2 implements Runnable {
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
   public class Chapter04.Test {
       private Chapter04.Test test = null;
    	
       private Chapter04.Test() {}
       
       private static Chapter04.Test getTest() {
           if(test == null) {
               synchronized(Chapter04.Test.class) {
                   if(test == null) test = new Chapter04.Test();
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
  public class Chapter04.StringTest {
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
    public class Chapter04.StringTest {
        String str = new String("good");// str 保存着堆内存地址，堆内存地址保存方法区常量池中的地址，指向真正的 good
        char[] ch = {'t', 'e', 's', 't'};
        
        public void change(String str, char ch[]) {//这里新建了一个 str 指向了方法区常量池里的 test ok，但是这里的 ch 因为是数组，所以存放在堆内存当中，ch 从 test 变成了 best
            str = "test ok";//这里只是一个局部变量，并不影响到成员变量的 str，常量池中新建 "test ok"
            ch[0] = 'b';
        }
        
        public static void main(String[] args) {
            Stringtest ex = new Chapter04.StringTest();
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
System.out.println(s13.replace('Chapter04.B', 'E'));
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

public class Chapter04.DateTest {
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
  
  public class Chapter04.Goods implements Comparable {
      private String name;
      private int price;
  
      public Chapter04.Goods() {
      }
  
      public Chapter04.Goods(String name, int price) {
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
          return "Chapter04.Goods{" +
                  "name='" + name + '\'' +
                  ", price=" + price +
                  '}';
      }
  
      @Override
      public int compareTo(Object o) {
          if (o instanceof Chapter04.Goods) {
              Chapter04.Goods goods = (Chapter04.Goods) o;
              if (this.price > goods.price) return 1;
              else if (this.price < goods.price) return -1;
              else return this.name.compareTo(goods.name);
          }
          return 0;
      }
  }
  
  class Chapter04.GoodsTest {
      public static void main(String[] args) {
          Chapter04.Goods goods1 = new Chapter04.Goods("Chapter04.A", 96);
          Chapter04.Goods goods2 = new Chapter04.Goods("Chapter04.B", 100);
          Chapter04.Goods goods3 = new Chapter04.Goods("Chapter04.C", 98);
          Chapter04.Goods goods4 = new Chapter04.Goods("D", 99);
          Chapter04.Goods goods5 = new Chapter04.Goods("E", 97);
          Chapter04.Goods goods6 = new Chapter04.Goods("Chapter04.A", 97);
          Chapter04.Goods[] goods = new Chapter04.Goods[]{goods1, goods2, goods3, goods4, goods5, goods6};
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

