package Chapter01;

public class DataType {
    /*
        之前我们说过变量的三要素就是：数据类型 名称 值，后两者分别对应着标识符和字面量，数据类型还没有介绍。
        数据类型的作用就是程序根据不同的数据类型给某个变量分配不同大小的空间以进行存储。
        数据类型包括：基本数据类型 和 引用数据类型
        基本数据类型共有 8 种：[char] [byte short int long] [float double] [boolean]，分门别类就是字符型、整型、浮点型、布尔型

       小容量的数据类型变量可以直接赋值给大容量的数据类型的变量，称为自动类型转换，也就是说瘦变胖很容易
       大容量的数据类型不可以直接赋值给小容量的数据类型的变量，因为可能存在丢失精度问题，也就是说胖变瘦很难，你得多加个门槛叫做 ---> 强制类型转换

       需要记住的数据类型的取值范围重点是：byte[-128 - 127] 如果超过了这个数字，不管你是左边超还是右边超，都会构成一个循环回来。
       比如这里的 a 是 byte 类型，但是赋值确实赋值 -129【这里用到了强制类型转换】，就会回到 127，
       这里的 b = -128 + (150 % 128) = -106

       short 的取值范围为：[-32768 - 32767]
       char  的取值范围为：[0 - 65535]
       其实际数据的取值跟前面说的 byte 是一样的道理

       Java 中布尔型只能使用 true | false ，不能像 C 那样使用 0 | 1
       这里有必要说下 long 型和 float 型，因为这两个家伙不是默认的数据类型  ---> 整型默认是 int 型，浮点型默认是 double 型，所以要使用这两种数据类型需要加上 l/L f/F

        1. 如果赋予一个变量数据类型为 char byte short 没有超过 0-65535 -128-127 -32768-32767 这个范围那么就可以直接赋值
        2. 八种基本数据类型中除了 boolean 类型是无法转换的，剩下的七种数据类型都是可以互相转换的
        3. 七种基本数据类型的容量大小排行是：byte < short = char < int < long < float < double，其中 byte 占 1 个字节，1 个字节是 8 位也就是一共 256，因为考虑到 0 的关系所以最大是 127 而不是 128
        4. char的取值范围是：0-65535 而 short 是 -32768 - 32767 所以 char 类型在正整数范围之内可以表示更大的数，虽然说它们都占据 2 个字节
        5. 小容量可以直接转换为大容量数据类型即自动类型转换，但是大容量不行胖子若想变成瘦子必须强制类型转换
        6. byte short char 类型虽然可以在自家范围内直接转为各自的，但是如果直接赋值的时候还是赋的 int 数据类型的值，做加法减法也是这么一回事
        7. 多种数据类型混合运算时，会先转换成容量最大的那种再做运算
        8. byte short char 赋值可以直接赋值各自范围的 int 类型，但是如果引入了变量的运算，就无法，此时需要强制类型转换，但是如果使用的是 += -= 这些是默认存在即隐式强制类型转换的可不手动强制类型转换

        自动装箱和自动拆箱：
        1. Integer 的自动装箱
           如果字面量在[-128 - 127]之间，那么就会从内存中读取数据不会再新建一个
           Integer i1 = 100; Integer i2 = 100; System.out.println(i1 == i2); ---> true
           但是如果超出了这个范围就会新建一个 Integer 对象
           Integer i3 = 200; Integer i4 = 200; System.out.println(i3 == i4); ---> false
        2. Double 的自动装箱
           Double 的自动装箱都是返回一个新的对象，而不是像 Integer 那样在一定范围内从内存中取数据
           Double d1 = 100.0;Double d2 = 100.0;System.out.println(d1 == d2); ---> false
           Double d3 = 200.0;Double d4 = 200.0;System.out.println(d3 == d4); ---> false
        3. Boolean 的自动装箱
           Boolean 类型的自动装箱跟 Integer Float 的都不一样，在 valueOf() 方法中，指向的都是静态变量对象，所以一定是 true
           Boolean b1 = false;Boolean b2 = false;System.out.println(b1 == b2);
           Boolean b3 = true;Boolean b4 = true;System.out.println(b3 == b4);
        4. == 如果有表达式比较的是数值，如果没有表达式比较是否是同一个对象然后再比较数值
           equals 先比较()类型是否相同，然后再比较数值是否相同，如果类型不同直接返回 false

    */
    public static void main(String[] args) {
        //byte a = (byte) -129;
        //byte b = (byte) 150;
        //System.out.println(a);
        //System.out.println(b);
        //byte c = 100 - 20;
        //System.out.println(c);
        //byte d = 20;
        //System.out.println(d);
        //short s1 = 1;
        //s1 += 1;
        //System.out.println(Math.round(11.99));
        //System.out.println(Math.round(-11.99));
        //System.out.println(2 << 3);
        //Integer i1 = 100; Integer i2 = 100; System.out.println(i1 == i2);
        //Integer i3 = 200; Integer i4 = 200; System.out.println(i3 == i4);
        //Double d1 = 100.0;Double d2 = 100.0;System.out.println(d1 == d2);
        //Double d3 = 200.0;Double d4 = 200.0;System.out.println(d3 == d4);
        //Boolean b1 = false;Boolean b2 = false;System.out.println(b1 == b2);
        //Boolean b3 = true;Boolean b4 = true;System.out.println(b3 == b4);
        Integer a = 1;
        Integer b = 2;
        Integer c = new Integer(3);
        Integer d = new Integer(3);
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);           //两个不同的对象，地址不同所以为false
        System.out.println(e==f);           //因为不在-128-127这个范围之内，所以新建数据，所以为false
        System.out.println(c==(a+b));       //因为 a+b 有表达式，则 c 会自动拆箱，与 a+b 进行比较，比较的是数值，所以为 true
        System.out.println(c.equals(a+b));  //先判断(a+b)是否属于 Integer 类型然后再做比较
        System.out.println(g==(a+b));       //比较的是数值所以是 true
        System.out.println(g.equals(a+b));  //先判断(a+b)是否属于 Long 类型然后再比较，明显不是
        System.out.println(g.equals(a+h));  //先判断(a+h)是否属于 Long 类型然后再比较，明显不是
    }
}
