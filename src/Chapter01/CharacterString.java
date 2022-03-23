package Chapter01;

public class CharacterString {
    /*
        String 是引用数据类型。
        字符串提取子串：substring(startIndex, number); 从 startIndex 开始截取 number 个字符
        字符串拼接：1.可以使用+连接字符串 2.join()它还有额外的功能，给字符串添加分隔符【第一个形参决定分隔符】

        String类对象是不可变的，因为JVM中有一块内存是专门存放字符串的，这块空间称为字符串常量池：
        String str = "abc"; 那么这个 "abc" 对象就存放在了字符串常量池中，str 这个变量是这个对象的引用，变量 str 存放的是字符串的存放地址
        如果str = "cba"，那么不是说 abc 变成了 cba 而是又在字符串常量池中创建了 cba，str 指向了这个字符串，所以我们说字符串是不可变的
        JVM这样做完全是出于效率的考虑。因为放在常量池中的字符串可以被共享。

        有道非常经典的题目：问 String str = new String("abc");一共创建了几个对象？
        这道题的答案非常有意思，因为有可能是 1 个也有可能是 2 个
        1. 如果常量池中没有 abc 这个字符串对象那么就会先创建"abc"字符串对象然后放到常量池中，再在堆内存中创建 str 对象，指向常量池中的"abc"，所以是 2 个
        2. 如果常量池中已经有了 abc 这个字符串对象那么就直接在堆区中创建 str 字符串对象指向"abc"
        所以说字符串对象跟我们平时所说的对象不太一样，我们平时见到的都是在堆区，但是因为考虑到效率所以新增了字符串常量池，这里面存放的也是对象而且是专门存放字符串对象的一块内存空间。
        还有一道：String str = "wh" + "at"; 创建了几个对象？ 答案是 3 个，想一想就知道为什么了，这里不多表述。

        String的equals()方法比较的是内容，内容相同即返回true，而==比较不止是内容还比较的是两个是否是同一个对象。
        但是 equals() 有个前提就是二者肯定是同一种类型的才可以比较，比如这里 a 是 1，str 也是 1，但是一个属于整型 1 个属于字符串返回的一样是 false

        有个很有意思的问题？
        String aa = new String("aabb");
        String bb = new String("aabb");
        问 aa==bb 吗？还有 aa.equals(bb)？
        我们可以肯定的就是后面的 equals 肯定为 true，因为二者都属于字符串且内容相同。
        值得琢磨的就是 == ，我们知道这是两个不同的对象，所以返回 false，但是仔细想想有一点很有趣，就是他们 aa bb 这两个对象指向的都是在字符串常量池中的同一个位置！
        也就是他们的内容是一样的，都存的是"aabb"这个字符串对象在字符串常量池的地址，但是他们两个本身的地址不一样，所以 == 不一样。
    */
    public static void main(String[] args) {
        String str = "HelloWorld";
        System.out.println(str.substring(0, 3));
        System.out.println(String.join("*", "aa", "bb", "cc", str));
        int a = 1;
        str = "1";
        String aa = new String("aabb");
        String bb = new String("aabb");
        System.out.println(str.equals(a));
        System.out.println(aa == bb);
        System.out.println(aa.hashCode());
        System.out.println(bb.hashCode());
    }
}
