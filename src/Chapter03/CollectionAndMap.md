# 集合

## 1. 集合的理解和好处

相比于数组，集合得灵活性更高，数组得长度在开始时就需要指定并且无法做到自动扩容，且保存得长度必须是同一类型得元素，使用数组进行查找的效率很高，但是使用数组进行增加和删除和修改的元素的效率比较低。这些情况下使用集合，就会感受到其好处了。

集合的优点：

- 可以动态保存任意类型任意个数的对象[在没有泛型的情况下]，使用非常方便
- 提供了许多`API`，非常方便如：`add remove set get`

## 2. 集合的框架体系

要求将这个集合的框架体系记忆下来 ---> `New Project ---> com.zwm.MyCollection.java`

第一种集合【单列集合 --- 单个元素】：`Collection`接口继承了`Iterable`接口，`List`接口和`Set`接口继承了`Collection`接口，`List`接口有三个重要的实现子类：`ArrayList.java`、`Vector.java`、`LinkedList.java`，`Set`接口有两个重要的实现子类：`HashSet.java`、`TreeSet.java`[可以用于排序]

![](https://img-blog.csdnimg.cn/4703dbdd6da94faca5c5bff468ff6d40.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

第二种集合【双列集合 --- 键值对形式】：`Map`接口，`HashMap`、`HashTable`、`TreeMap`，这三个实现了`Map`接口的类比较重要，还有一个继承了`HashTable`的子类叫做`Properties`以及`HashMap`的子类`LinkedHashMap`后续也需要学习。

![](https://img-blog.csdnimg.cn/fc8dade994fe429c8af659315a13b830.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

## 3. `Collection`接口

`Collection`接口继承了`Iterable`接口，可以通过迭代器迭代

- `Collection`的子类可以存放多个元素，每个元素都可以是`Object`类型
- `Collection`子接口`List`实现类是可以存放重复元素的但是子接口`Set`实现类不可以
- `Collection`子接口`List`实现类存放的数据是有序的，但是子接口`Set`实现类是无序的
- `Collection`没有直接实现的接口而是通过`List`和`Set`子接口实现的

【接口无法直接实现实例化，只有实现了接口的实现类才可以被实例化，下述方法以`ArrayList`为例】

```tex
1. add：添加单个元素，除了默认在末尾添加元素，在 ArrayList 中还可以指定元素位置添加元素【通过方法重载实现】
2. remove：删除指定元素，可以删除某个具体的元素也可以按照索引删除，由于这里代码使用的是多态所以无法展示出删除索引的 remove，在 ArrayList 中是存在的【通过方法重载实现】
3. contains：查找元素是否存在
4. size：获取元素个数
5. isEmpty：判断是否为空
6. clear：清空
7. addAll：添加多个元素，除了默认在末尾添加集合，在 ArrayList 中还可以指定元素位置添加集合【通过方法重载实现】
8. containsAll：查找多个元素是否都存在
9. removeAll：删除多个元素
```

```java
package Chapter03;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMethod {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        //1.1添加元素
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("ggg");
        System.out.println("collection add = " + collection);
        //1.2添加多个元素
        Collection collection1 = new ArrayList();
        collection1.add("ddd");
        collection1.add("eee");
        collection1.add("fff");
        collection.addAll(collection1);
        System.out.println("collection add all = " + collection);
        //2.1按照具体对象删除元素
        collection.remove("aaa");
        collection.remove("bbb");
        System.out.println("collection remove object = " + collection);
        //2.2删除多个元素
        collection.removeAll(collection1);
        System.out.println("collection remove all = " + collection);
        //3.1查找是否存在某元素
        boolean isContainOrNot = collection.contains("ccc");
        System.out.println("ccc is contains or not? ---> " + isContainOrNot);
        //3.2查找是否存在多个元素
        isContainOrNot = collection.containsAll(collection1);
        System.out.println("collection1 is contains or not? ---> " + isContainOrNot);
        //4.查找集合元素个数
        int size = collection.size();
        System.out.println("size = " + size);
        //5.判断集合是否为空
        boolean isEmptyOrNot = collection.isEmpty();
        System.out.println("Collection is empty or not? ---> " + isEmptyOrNot);
        //6.清空集合
        collection.clear();
        System.out.println("collection clear = " + collection);
    }
}
```

迭代器遍历集合：如果希再次遍历集合元素只需要重置迭代器即可`iterator = collection.iterator();`

```java
package Chapter03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("ddd");
        collection.add("eee");
        collection.add("fff");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println(object);
        }
    }
}
```

集合之增强`for`循环：`for`循环的底层使用的还是`Iterator`迭代器

```java
package Chapter03;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    public static void main(String[] args) {
        Collection<Book> collection = new ArrayList();
        collection.add(new Book("三国演义", "罗贯中", 10.1));
        collection.add(new Book("小李飞刀", "古龙", 5.1));
        collection.add(new Book("红楼梦", "曹雪芹", 34.6));
        for (Book book : collection) {
            System.out.println("book = " + book.toString());
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

## 4. `List`接口

`List`接口是`Collection`接口的子接口，`List`的实现类是有序可重复的，相比于`Collection`接口，`List`有索引，所以可以删除某个索引的元素或者某个集合也可以在某个索引后边增加元素或者某个集合。

常用方法：

```tex
1.add(int index, Object object)指定索引添加元素
2.addAll(int index, Collection collection)指定索引添加集合
3.get(int index)获取某个索引的对象
4.indexOf(Object object)某个object在集合中首先出现的位置
5.lastIndexOf(Object object)末次出现的位置
6.remove(int index)移除指定位置的元素并返回此元素
7.set(int index, Object object)将指定位置的元素设置为object
8.subList(int fromIndex, int toIndex)返回从fromIndex开始的几个元素的集合 ---> 简单理解：左闭右开
```

```java
package Chapter03;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        //1.1直接添加元素
        list.add("AAA");
        System.out.println("List add object = " + list);
        //1.2指定位置添加元素
        list.add(0, "BBB");
        System.out.println("List add index = " + list);
        //2.1获取某位置的元素
        Object object = list.get(0);
        System.out.println("List get = " + object);
        //2.2获取首次出现的元素位置
        list.add("AAA");
        int indexOf = list.indexOf("AAA");
        System.out.println("List indexOf = " + indexOf);
        //2.3末尾首次出现的元素位置
        int lastIndexOf = list.lastIndexOf("AAA");
        System.out.println("List last index of = " + lastIndexOf);
        //3.1直接移除元素
        boolean isRemoveOrNot = list.remove("AAA");
        System.out.println("List remove object = " + isRemoveOrNot);
        //3.2按照位置移除元素
        object = list.remove(0);
        System.out.println("List remove index = " + object);
        System.out.println("List = " + list);
        list.set(0, "super玛丽");
        System.out.println("List set index and object = " + list);
        list.add("愤怒小鸟");
        list.add("僵尸大战");
        List list1 = list.subList(0, 2);
        System.out.println("List subList = " + list1);
    }
}
```

`List`遍历方式有三：一是`Iterator`因为`List`继承了`Collection`接口也就继承了`Iterator`接口，二是增强`for`循环，三是普通`for`循环

```java
package Chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCirculate {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("青椒炒肉");
        list.add("宫保鸡丁");
        list.add("鱼香肉丝");
        list.add("北京烤鸭");
        list.add("麻婆豆腐");
        //1.Iterator 遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println("菜单 iterator：" + object);
        }
        //2.增强 for 遍历方式
        for (Object object : list) {
            System.out.println("菜单增强 for：" + object);
        }
        //3.普通 for 遍历方式
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            System.out.println("菜单普通 for：" + object);
        }
    }
}
```

`List`冒泡排序：

```java
package Chapter03;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    public static void main(String[] args) {
        Collection<Book> collection = new ArrayList();
        collection.add(new Book("三国演义", "罗贯中", 10.1));
        collection.add(new Book("小李飞刀", "古龙", 5.1));
        collection.add(new Book("红楼梦", "曹雪芹", 34.6));
        for (Book book : collection) {
            System.out.println("book = " + book.toString());
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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

`ArrayList`可以存放`null`元素其底层就是一个数组，不过增添了如自动扩容等级制，线程不安全但是效率高。在多线程情况下，要想保证线程安全可以使用`Vector`

**<font color="red">`ArrayList`源码剖析【重点】</font>**：

`ArrayList`维护了一个`Object`类型的数组也就是什么类型都可以存放到`ArrayList`中。

- 对象在序列化的时候，`transient`修饰的属性不会被序列化，而`ArrayList`维护的数组正是被`transient`修饰的，`transient`表示短暂的瞬间的，不会被序列化的【序列化的意思就是持久化，保留在磁盘中】
- 当创建对象的时候，如果使用的是无参构造器那么初始化容量`elementData`为`0`，在`JDK7`中为`10`
- 当添加元素的时候，会判断是否要自动扩容，如果需要扩容则调用`grow`方法，如果不需要则直接将元素添加到相应位置即可
- 当创建`ArrayList`对象时，如果使用的是无参构造器，则初始`elementData`容量为0，第1次添加，则扩容`elementData`为10，如需要再次扩容，则扩容`elementData`为1.5倍
- 如果使用的是有参构造器则初始化容量就是设置的那个容量，并且如果需要扩容的时候，会将其扩容到`1.5`倍`elementData`的容量，这点与无参构造器构造的`ArrayList`不同，它的第一次扩容是先扩容到`10`

探究源码：【`minCapacity`一定要正确理解成所需的最小容量】

```java
package Chapter03;

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

1. 创建了一个空的`elementData`数组

   ![](https://img-blog.csdnimg.cn/8cccf2c1fb314cd8adcba32b59082e27.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

2. 进入到`for`循环，对`int`类型的数据进行了装箱处理转化为`Integer`对象，老样子，如果数值在`-128`到`127`之间也就是`byte`类型的取值范围就直接从缓存中取数据，否则返回一个新建的`Integer`对象

   ![](https://img-blog.csdnimg.cn/90e6cad861004b4c9c15dbf143964dfb.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

3. 然后进入到`ArrayList.add()`方法，这里可以看到`ensureCapacityInternal`确认内部容量，也就是说需要先确定是否需要扩容。

   <font color="red">**看看是如何判断是否需要扩容的？**</font>

   > - 当前`ArrayList`的`size = 0`，传入当前数组所需要的最小容量，所谓最小容量的意思是可以满足新增加元素的最小容量，这里添加一个元素，所以最起码数组的容量得是`1`。
   >
   > - 进入`ensureCapacityInternal` 方法一探究竟---> 在进入到`ensureExplicitCapacity`明确容量 ---> 传入参数：`calculateCapacity(elementData, minCapacity)`计算容量，如果是数组是空数组就返回默认容量`10`和`minCapacity`[此时`= 0`]，很明显这里`Math.max()`返回的是默认容量 ---> `10` ---> 这表明`ArrayList`默认初始化的最小容量为`10`
   >
   > - 进入`ensureExplicitCapacity(int minCapacity)`，`explicit`有明确的意思说明这里才是真正的确认容量的方法 ---> 传递的参数为`10`，这里遇到一个`modCount++`表示的是当前`ArrayList`修改的次数，这是为了防止多线程修改的情况，如果有多线程修改则会报错
   >
   >   比较`minCapacity`和`elementData.length`，如果最小容量要比数组的长度要大，那就表明需要扩容了，此时进入到**<font color="red">`grow(int minCapacity)`</font>**方法里头，这个方法就是执行扩容操作的核心代码，前面都是在判断要不要扩容，扩多少的问题
   >
   > - `int oldCapacity = elementData.length;` ---> 获取旧容量即数组长度，这里现在显然是`0`
   >
   > - `int newCapacity = oldCapacity + (oldCapacity >> 1)`; ---> 获取新容量长度，旧容量+旧容量/2，想想这不就是`1.5`倍吗？因为这是第一次，所以`oldCapacity`是`0`，`0 * 1.5 = 0`还是`0`，所以第一次的时候并没有真正使用到`1.5`倍，我们接着往下看
   >
   > - `if(newCapacity - minCapacity < 0) newCapacity = minCapacity;`如果新容量比规定的默认最小容量还要小，就把默认容量赋值给新容量
   >
   > - `if (newCapacity - MAX_ARRAY_SIZE > 0) newCapacity = hugeCapacity(minCapacity);`如果新容量的值比最大值，这个最大值非常大，需要调用`hugeCapacity(minCapacity)`这个方法暂时先跳过
   >
   > - `elementData = Arrays.copyOf(elementData, newCapacity);`然后就会调用`Array.copyOf()`生成新的数组对象传给`elementData`，这里之所以要使用`copyOf()`是为了保护原先的数组数据到此扩容结束

   ![](https://img-blog.csdnimg.cn/df587d89d25b42e6bb2e7938b3998706.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

   ![](https://img-blog.csdnimg.cn/1aeccd51cb09435383354adaff8e782e.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

   ![](https://img-blog.csdnimg.cn/6ffc5a5923144fbb8c1f58071657d749.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

   ![](https://img-blog.csdnimg.cn/88f645da1298426daa0bccbe9838eb26.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

   ![](https://img-blog.csdnimg.cn/e7efb548e974493e9a059cbc4700e429.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

   ![](https://img-blog.csdnimg.cn/abd8c5b11ead4bacb3cbd08b7445e37b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

4. 回到`add()`方法，将新的元素添加进`ArrayList`，并将`size`自增，然后返回`true`表示添加成功

   ![](https://img-blog.csdnimg.cn/df587d89d25b42e6bb2e7938b3998706.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

5. 然后就是`i=2`的情况，前面的除了`minCapacity`其余的都一样，因为此时`minCapacity = 2`表明最少需要两个容量才能放得下数据，然后一直到`ensureCapacityInternal`这里确认最终容量的时候，调用了`calculateCapacity(elementData, minCapacity)`，此时数组已经不为空了，所以直接返回的就是`minCapacity = 2`，因为`minCapacity`比当前数组的长度要小【上一步在`i=1`的时候数组已经扩容到长度为`10`的地步了】，所以不用扩容，直接跳过`grow()`方法，返回，直接添加元素即可，接下来的：`3 4 5 6 7  8 9 10`都是一样的，都没有超过数组长度所以不需要扩容【每添加一个元素都需要判断是否需要扩容，可想而知效率不是很高】

6. 接下啦是重头戏，因为到了这里又将进行一次扩容：`i = 11`，按以往进入到：`add`方法，此时的`elementData.size == 10`，因为又将放入一个新的数据`11`，所以要求最小容量即`minCapacity == 11`

   ![](https://img-blog.csdnimg.cn/a4a14af97cdf4edd8dd98215a57c14fc.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

7. 进入`ensureCapacityInternal`方法中，调用`calculateCapacity`计算出准确的最小容量，如果是空数组的话需要赋予一个初始化最小容量`10`，如果不是空数组的话直接返回最小容量`minCapacity`，下图中的`minCapacity`应为`11`

   ![](https://img-blog.csdnimg.cn/6ffc5a5923144fbb8c1f58071657d749.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

8. `ensureCapacityInternal`方法调用了`ensureExplicitCapacity`并在上一步中通过`calculateCapacity`得到了准确的最小容量 ---> `11`，防止多线程修改，这里`modCount++`，这里时第`11`次修改所以应为`11`，又到了一个经典的判断：`if(minCapacity - elementData.length > 0)`意思是如果最小容量超过了数组最大长度时就需要扩容，显然前者为`11`后者是`10`，所以需要扩容，进入`grow(minCapacity)`方法，下图中的`minCapacity`应为`11`

   ![](https://img-blog.csdnimg.cn/88f645da1298426daa0bccbe9838eb26.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

9. 进入`grow(int minCapacity)`获取到最旧数组容量：`elementData.length`即`10`，将数组容量扩大至旧容量的`1.5`倍，注意这里已经不是第一次扩容了，第一次扩容是直接赋予一个初始化值`10`，这里是直接扩大至旧容量的`1.5`倍，即`10 * 1.5 = 15`，即新容量为`15`，比较一下新容量和最小容量，如果最小容量比新容量还要大，直接将最小容量赋值给新容量即可，这一步判断也是给第一次扩容时使用的，`hugeCapacity`这里暂时还是不说，然后使用`copyOf(elementDat, newCapacity);`保留原有数据扩容

   ![](https://img-blog.csdnimg.cn/e7efb548e974493e9a059cbc4700e429.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

   ![](https://img-blog.csdnimg.cn/e98fe1280ad1403e8fec9000d0f39271.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

10. 后面继续添加`list.add(100); list.add(200);`依然还会扩容，扩容至`22`，有一点很奇怪就是`IDEA`竟然没有显示，这是因为`IDEA`非常智能，默认会简化`Debug`的信息，通过如图设置即可：

    ![](https://img-blog.csdnimg.cn/364d69946d61459da46ce0bff7a08c36.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

【这可以说是少有的看源码了，非常值得学习，压力肯定还是有说明自己进步的空间还很多】

11. 如果是通过有参构造器，已经指定好了初始化最小容量`minCapacity`，那在第一次扩容的时候，将直接按照指定的数值进行扩容，回到究竟是使用`minCapacity`还是`ArrayList`自带的`DefaultCapacity`，我们需要回到`calculateCapacity`这个方法中：

    ![](https://img-blog.csdnimg.cn/6ffc5a5923144fbb8c1f58071657d749.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

    我们可以看到在比较`elementData`和`DEFAULTCAPACITY_EMPTY_ELEMENTDATA`时使用的是`==`，那么就表明需要比较内存地址，很明显，因为有参构造其中创建了新的数组对象，所以内存地址肯定不一样，所以就不会将最小容量改为默认容量`10`，也就是说扩容将按照给定的容量进行扩容，比如给的是`1`，那么新容量就是`2`，下图是`ArrayList`有参构造器，可以看到新建了一个数组对象：

    ![](https://img-blog.csdnimg.cn/8a064f00911f4b03aabc0350b1da8f47.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

**<font color="red">`Vector`源码剖析</font>**：

```java
package Chapter03;

import java.util.Vector;

public class VectorSource {
    public static void main(String[] args) {
        Vector vector = new Vector();
        for (int i = 1; i <= 10; i++) {
            vector.add(i);
        }
        vector.add(100);
        System.out.println("Vector = " + vector);
    }
}
```

1. 首先看看`Vector`的构造器，可以发现`Vector`如果在创建的时候没有传递任何的值，默认会调用有参构造器然后传递`10`，这个`10`就作为`Vector`对象的初始化容量，`capacityIncrement`表示每次增加多少容量，这里`capacityIncrement`传递的是`0`，如果不手动传入`capacityIncrement`，后续默认增加的容量即为`initialCapacity`即一倍扩容

   ![](https://img-blog.csdnimg.cn/292ef2e472754f549abe9ce6b956ad3e.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

2. 添加元素进入到`add(E e)`可以看到这里方法使用`synchronized`修饰，也证明了`Vector`是线程安全的。`modCount++`记录当前`vector`被修改的次数。进入到`ensureCapacityHelper(int minCapacity)`中，判断是否需要扩容，若需要则进行扩容机制。

   ![](https://img-blog.csdnimg.cn/c21ecba9158a4fc4a2a889c4af75edd0.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_16,color_FFFFFF,t_70,g_se,x_16)

3. 进入到`ensureCapacityHelper(int minCapacity)`中，我们知道在构造`vector`对象的时候，`elementData`的容量就已经赋值为`10`或者是自定义的容量，`minCapacity`这里只需要`1`个容量即可存储，所以够用，无序扩容，一直到`i = 10`的时候都无需扩容，扩容是在`add(100)`的时候生效

   ![](https://img-blog.csdnimg.cn/2ff0b3327b5f4aeabb4d0470b278c830.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

4. 让我们看看添加第`11`个元素，`Vector`进行的扩容机制，可以发现这里的

   ```java
   int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
   ```

   跟前面学习的`ArrayList`扩容是不一样的，扩容扩容最核心的就是扩多少，怎么扩，怎么扩这个问题很简单，使用`copyOf()`保障原有数据的同时扩容即可，那扩多少呢？`Vector`采用的机制是：如果用户有自定义`capacityIncrement`即增加多少容量的话，那就在原有基础上即`oldCapacity`也就是`elementData.length`自增一倍，虽然这里用的是加法但是加上自身就是扩容一倍的意思。所以默认情况下也就是程序没有给出`capacityIncrement`的情况下扩容过程就是：`10 ---> 20 ---> 40`这样扩

   ![](https://img-blog.csdnimg.cn/bde52511040a4ca98418af9d8fe7a4d8.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_19,color_FFFFFF,t_70,g_se,x_16)

5. 上述所有的情况如果整合起来就形成了下面这张图：因为有了`capacityIncrement`所以每次扩容将扩大`capacityIncrement`容量，所以可以看到这里在`i = 2`的时候将进行扩容[初始化容量为`1`]，每次增加`2`个，所以扩容后`Vector`容量为`3`，这里通过下面箭头所指的数值也可以看到

   ![](https://img-blog.csdnimg.cn/c8121fd8a6f54229bf17e120ddd6a44f.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)
