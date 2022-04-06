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

## 4. `List`接口[继承`Collection`接口]

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

### 4.1 `ArrayList`

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

### 4.2 `Vector`

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

### 4.3 `LinkedList`

1. `LinkedList`底层维护了一个双向链表
2. `LinkedList`中维护了两个属性`first`和`last`分别指向首节点和尾节点
3. 每个节点`Node`对象，里面又维护了`prev`、`next`还有`item`三个属性，其中通过`prev`指向当前节点的前一个节点，通过`next`指向当前节点的后一个接待你，最终实现双向链表
4. 链表的删除和添加的效率比数组高，但是查找没有数组的效率高

```java
package Chapter03;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        //添加节点
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("linkedList = " + linkedList);
        //删除节点
        linkedList.remove();
        System.out.println("linkedList = " + linkedList);
        //修改节点
        linkedList.set(1, 8);
        System.out.println("linkedList = " + linkedList);
        //获取某个位置的节点
        Object object = linkedList.get(1);
        System.out.println("linkedList get 1 = " + object);
        //LinkedList 实现了 List 接口，List 接口继承了 Collection 接口
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("next = " + obj);
        }
        for (Object o : linkedList) System.out.println("for++ = " + o);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("for = " + linkedList.get(i));
        }
    }
}
```

`LinkedList`底层就是双向链表，链表是基本必须掌握的数据结构之一，比较简单，这里就不多赘述。

### 4.4  `ArrayList`和`LinkedList`比较

`ArrayList`：底层数据结构为数组，查找的效率较高，添加和删除的效率就相对较低，前者每次添加都要进行是否扩容，后者则需要将数组整体往前移动，效率低

`LinkedList`：底层数据结构为双向链表，查找的效率较低，从头查到尾或者反过来，添加和删除的效率非常高，通过拆解`prev`和`next`指向就可以添加或者删除某元素，在这里没有扩容这一说法，效率高

选择`ArrayList`还是`LinkedList`关键还是看以下两点并且需要根据业务的不同进行选择：

1. 如果查找的操作多[大部分，达到`80% - 90%`的操作其实都是查找]，选择`ArrayList`
2. 如果增加和删除的操作多，选择`LinkedList`

## 5. `Set`接口[继承`Collection`接口]

特点：无序不可重复并且没有索引，不支持随机访问，因为继承了`Collection`接口所以可以使用迭代器和增强`for`循环进行遍历

```java
package Chapter03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetStudy {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("kate");
        set.add("john");
        set.add(null);
        set.add(null);
        System.out.println("set = " + set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println("iterator = " + object);
        }
        for (Object object : set) {
            System.out.println("for++ = " + object);
        }
        //无法使用普通for循环便利 Set
    }
}
```

### 5.1 `HashSet`

- `HashSet`实现了`Set`接口

- `HashSet`的底层其实就是`HashMap``

- ``HashSet`可以存放`null`值并且只能存放一个

- 除此之外`HashSet`不能保证元素是有序的这取决于`Hash`值然后再确定索引取出元素。为什么会有这样的操作？因为：`HashSet`底层是`HashMap`，而`HashMap`底层数据结构是：数组 + 单向链表 + 红黑树，通过`Hash`值可以确定是数组的哪个节点，然后通过索引确定是数组里面链表中的的哪个元素，当链表中的元素个数到达某一个数量的时候就会变成红黑树。

- 所谓的不重复其实是针对内存地址而言的，如果添加的是新创建的对象其实这不叫重复了，这种情况还是属于新增元素

  但是如果加入了两个`new String("A");`其实只加入了一个。这是为什么呢？这个`HashSet`的`add()`加入机制有关，前面说过是先计算出`hash`值然后再看存到哪里，`String`对象重写了`hashCode`方法，比较的是常量值中的对象。

`HashSet`底层结构详细说明：

1. 先获取元素的哈希值即`HashCode`
2. 对哈希值进行运算得到一个索引值即为要存放在哈希值中的位置号
3. 如果该位置上没有其它的元素，则直接存放，如果有其它元素需要调用`equals`进行判断，如果相等则证明该元素存在过了，不再添加，如果不相等则按照链表的方式进行存放即存放到最后面
4. 在`Java8`中如果一条链表中的元素个数超过`TREEIFY_THRESHOLD`[默认是`8`]并且存储数组的大小是`>= MIN_TREEIFY_CAPACITY`[默认`64`]就会转换成红黑树，那如果数组没到`64`呢？就会先把数组进行扩容，按两倍扩容，但是不是直接一步到位的那种扩容，一直到扩容到`64`之前呢，都还是链表的形式，只有到了`64`容量的时候才会树化，转换成红黑树
5. 这里涉及到一个扩容因子，达到`容量 X 扩容因子`的时候就会自动扩容，这里判断是否达到是用`size`判断的，这里的`size`指的不是在数组链表的条数，而是总的元素的个数。

<font color="red">**【注：`HashSet`的底层就是`HashMap`，所以研究`HashSet`其实也就是在研究`HashMap`，除此之外，`HashSet`底层中当一个链表节点个数达到一定的数量之后就会变成红黑树，因为红黑树的存取效率更高】**</font>

这也就是为什么虽然是`new String()`但是存放的数据却只有一个，因为`String`重写了`equals`和`hashCode`的计算方式，可以看看`String`类的`hashCode()`方法：由此也可以看出，`String`对象的哈希值计算出来是什么取决于的是`value`，而`value`就是字符串字符数组，所以只要两个字符串的内容是一样的，则它们的哈希值也是一样的。【简单说就是：`hash() + equals()`】

![](https://img-blog.csdnimg.cn/812240cc06b24ef6824e5868fec7d67e.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

再接着来看看`equals`方法：可以清楚的看到`String`对象比较的是每个字符也就是比较字符串的内容

![](https://img-blog.csdnimg.cn/101879e4cebf4a1cb6d48586ca4d45b1.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

再回过头来看`HashSet`的存储方法，为什么会有如下这个问题？为什么明明存储了两个对象，在`HashSet`中只存储了一个呢？这就需要我们结合`HashSet`的存储机制和`String`类计算`hashCode`的方式了，我们知道`String`类对象，只要内容一样哈希值肯定也是一样的，而`HashSet`首先就是计算出哈希值，然后通过哈希值计算得到索引，也就是说这两个哈希值相同的`String`对象的索引是一样的，所以会调用`equals`方法比较，内容是相同的，证明这是同一个东西，所以`HashSet`只存放了一个`String`对象。

![](https://img-blog.csdnimg.cn/8e331411283e4a5c9da6e3d7a323b14c.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

`HashSet`源码剖析【重点】：

#### 5.1.1 `HashSet`第一次扩容

1. `HashSet`的底层其实就是`HashMap`，这一点可以通过构造器函数看出来

   ![](https://img-blog.csdnimg.cn/82904035c5de4b759a75813faec82524.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

2. 再进入到`HashMap()`的无参构造器一探究竟：可以看到初始化构造加载因子，加载因子是后面用来给数组扩容用的，后面会讲，这里暂时先不做解释

   ![](https://img-blog.csdnimg.cn/5f0c462cf17b4e458b8b0badbda64bb7.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

我们通过以下这段代码来研究一下`HashSet`的添加方法 ---> `add()`：

```java
package Chapter03;

import java.util.HashSet;

public class HashSetAdd {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        for (int i = 1; i <= 16; i++) {
            hashSet.add(i);
        }
        System.out.println("HashSet = " + hashSet);
    }
}
```

1. `Debug`模式走起，进入到`hashSet.add(i)` ---> `map.put(e, PRESENT)==null`这里的`PRESENT`是个什么东东？它其实就是一个占位符而已，因为`HashSet`的底层就是`HashMap`所以要符合它的格式，这是一种键值对形式 ---> `private static final Object PRESENT = new Object();`

   ![](https://img-blog.csdnimg.cn/d1122e1bb8a442028df0438f3470e04b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

2. 继续进入`map.put(e, PRESENT)`方法一探究竟，可以发现调用了`putVal()`方法，该方法的第一个参数传入的是所添加元素的哈希值，调用的是`hash(key)`方法，我们看看这个`hash(key)`里面是什么东东

   ![](https://img-blog.csdnimg.cn/0adb1603b74645289fc2216de6e32adf.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

3. 进入到`hash(key)`方法，这里的`key`就是传入的元素，如果传入的元素是个`null`值，哈希值为`0`，如果不是`null`就调用传入元素类的`hashCode()`的方法，注意到这里是调用传入元素自身类的`hashCode()`，也就是说，程序员是可以重写这个方法决定某个类的哈希值是否一样，`hash()`方法再对元素的哈希值跟右移`16`位的哈希值做一个异或操作，为得是尽可能地避免哈希碰撞，最后就是返回一个哈希值

   ![](https://img-blog.csdnimg.cn/37a0c0a4c46249ecbfa8461eb9abfeae.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

4. 返回到`put()`方法，传入哈希值，进入到`putVal()`方法中，这段代码是一个重头戏而且篇幅不小，我们一步一步慢慢看。

   > 1. `Node<K, V>[] tab`：首先定义了一个节点数组，这里的`K V`都是泛型，代表的是`key value`的类型，这里的`value`只是一个占位符，重点看`key`
   >
   > 2. `Node<K, V> p`：然后定义节点`p`，通过第`6`可以看出`p`是用来存储当前索引的元素的，也就是数组某个位置存放的元素，用来判断这个位置是`null`还是有元素然后再进行下一步的打算
   >
   > 3. `int n, i`通过第`4`可以看出这里的`n`是用来存储数组长度即`tab.length`的，`i`通过第`6`步可以看出是索引
   >
   > 4. `if((tab = table) == null || (n = tab.length) == 0)`：如果数组是`null`或者数组的长度为`0`也就是没有元素的话，`n = (tab = resize()).length`，调用`reszie()`方法对`tab`进行扩容，这里也可以看出`resize()`返回的是`Node<K, V>[]`类型，让我们进入到`resize()`方法看看是怎么对节点数组进行扩容的，这个`resize()`也是够长的，所以分三批来看，注意哦，因为此时数组是空也就是说这是咋们的数组小朋友第一次扩容
   >
   >    > 1. `Node<K, V>[] oldTab = table;`这里`HashMap`的节点数组表传入给了`oldTab`元素，很明显这是老表的意思
   >    >
   >    > 2. `int oldCap = (oldTab == null) ? 0 : oldTab.length;`判断老表是否是`null`的，如果是老表数组容量我们当做`0`，如果不是返回老表数组的容量
   >    >
   >    > 3. `int oldThr = threshold;`这里的`threshold`是阈值的意思，暂且不明白这个是干嘛的
   >    >
   >    > 4. `int newCap, newThr = 0;`定义新的容量和阈值都为`0`
   >    >
   >    > 5. ```java
   >    >    if (oldCap > 0) {
   >    >        if (oldCap >= MAXIMUM_CAPACITY) {
   >    >            threshold = Integer.MAX_VALUE;
   >    >            return oldTab;
   >    >        }
   >    >        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
   >    >                 oldCap >= DEFAULT_INITIAL_CAPACITY)
   >    >            newThr = oldThr << 1; // double threshold
   >    >    }
   >    >    else if (oldThr > 0) // initial capacity was placed in threshold
   >    >        newCap = oldThr;
   >    >    ```
   >    >
   >    >    很明显，这里`Node<K, V>[] tab`本身就是`null`，很明显这里`oldCap = 0`所以直接跳过这个判断一直到执行`else`语句
   >    >
   >    > 6. ```java
   >    >    else {               // zero initial threshold signifies using defaults
   >    >        newCap = DEFAULT_INITIAL_CAPACITY;
   >    >        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
   >    >    }
   >    >    ```
   >    >
   >    >    这里将赋予`newCap`也就是新的容量一个默认容量值，这里`DEFAULT_INITIAL_CAPACITY`的值为`16`，也就是说`HashSet`或者`HashMap`的数组容量初始化都是`16`，这里的`DEFAULT_INITIAL_CAPACITY`也很有意思，不是直接写`16`而写的是`1 << 4`相当于`1 * 2^4 = 16`
   >    >
   >    >    ```java
   >    >    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
   >    >    ```
   >    >
   >    >    `newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);`
   >    >
   >    >    通过这句代码，真相大白，我们终于明白这个`New Threshold`阈值是个什么东东了，原来阈值表示的就是要做扩容的一个临界值，比如这里是`0.75 * 16 = 12`也就是说如果`HashSet/HashMap`里面的元素个数超过了`12`个也就是`13`个的时候就需要做扩容，这是为了防止突然有一大段数据要插入的时候不够用的情况
   >    >
   >    > 7. 继续进入到下一段代码：新的扩容阈值是`0`吗显然不是，所以这段代码跳过，后续如果遇到了再继续更深一步的探索
   >    >
   >    >    ```java
   >    >    if (newThr == 0) {
   >    >        float ft = (float)newCap * loadFactor;
   >    >        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
   >    >                  (int)ft : Integer.MAX_VALUE);
   >    >    }
   >    >    ```
   >    >
   >    > 8. `threshold = newThr;`阈值初始化
   >    >
   >    > 9. `Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];`创建一个新的节点数组，目的就是为了扩容
   >    >
   >    > 10. `table = newTab;` ---> 直接将`table`指向跟`newTab`一样的数组，直接扩容
   >    >
   >    > 11. 判断老数组中是否为`null`，不为`null`表示里面有元素，需要将元素给到新数组，这里还没遇到这种情况，先跳过，到时候再继续深入
   >    >
   >    >     ```java
   >    >     if (oldTab != null) {
   >    >         for (int j = 0; j < oldCap; ++j) {
   >    >             Node<K,V> e;
   >    >             if ((e = oldTab[j]) != null) {
   >    >                 oldTab[j] = null;
   >    >                 if (e.next == null)
   >    >                     newTab[e.hash & (newCap - 1)] = e;
   >    >                 else if (e instanceof TreeNode)
   >    >                     ((TreeNode<K,V>)e).split(this, newTab, j, oldCa
   >    >                 else { // preserve order
   >    >                     Node<K,V> loHead = null, loTail = null;
   >    >                     Node<K,V> hiHead = null, hiTail = null;
   >    >                     Node<K,V> next;
   >    >                     do {
   >    >                         next = e.next;
   >    >                         if ((e.hash & oldCap) == 0) {
   >    >                             if (loTail == null)
   >    >                                 loHead = e;
   >    >                             else
   >    >                                 loTail.next = e;
   >    >                             loTail = e;
   >    >                         }
   >    >                         else {
   >    >                             if (hiTail == null)
   >    >                                 hiHead = e;
   >    >                             else
   >    >                                 hiTail.next = e;
   >    >                             hiTail = e;
   >    >                         }
   >    >                     } while ((e = next) != null);
   >    >                     if (loTail != null) {
   >    >                         loTail.next = null;
   >    >                         newTab[j] = loHead;
   >    >                     }
   >    >                     if (hiTail != null) {
   >    >                         hiTail.next = null;
   >    >                         newTab[j + oldCap] = hiHead;
   >    >                     }
   >    >                 }
   >    >             }
   >    >         }
   >    >     }
   >    >     ```
   >    >
   >    > 12. `return newTab;`返回新的数组，**<font color="red">到此第一次扩容结束，与其说是扩容，倒不如说是直接创建返回了一个长度为`16`的节点数组</font>**，除此之外还走了初始化扩容阈值操作，不像`ArrayList`和`Vector`，它两的扩容使用的是`copyOf`拷贝出一个新的数组
   >
   >    ![](https://img-blog.csdnimg.cn/c0d8eae33ef345a3bd8064ea29d90047.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)
   >
   >    ![](https://img-blog.csdnimg.cn/10c834bbfab4492ab6b2af955ecd4eec.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)
   >
   >    ![](https://img-blog.csdnimg.cn/0348673fe445401e85b3548e9e7ef325.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_18,color_FFFFFF,t_70,g_se,x_16)
   >
   > 5. `n = (tab = resize()).length;`经过第一次所谓的“扩容”，现在数组就从一个`null`转换成了长度为`16`的节点数组，此时`n`代表数组长度也就成了`16`
   >
   > 6. `if ((p = tab[i = (n - 1) & hash]) == null)`可以很清楚的看到，索引`i`的计算方式就是`(n - 1) & hash`也就是数组的最后一个位置和哈希值进行与操作得来的，`p = tab[i]`所以`p`就是当前这个索引的元素，判断该位置有无元素，很明显，因为是第一次插入所以肯定是没有元素在这里的，进入到`tab[i] = newNode(hash, key, value, null);`，创建一个新的节点`newNode(hash, key, value, null);`传入`hash key value`这都好理解，最后一个`null`代表的是下一个元素的位置，因为用节点的目的就是后续是要形成链表的
   >
   >    ```java
   >    if ((p = tab[i = (n - 1) & hash]) == null)
   >        tab[i] = newNode(hash, key, value, null);
   >    ```
   >
   > 7. `++modCount;`记录修改的次数
   >
   > 8. 比较`++size`和`threshold`，如果添加元素后的数组数量要大于阈值则要进行扩容 ---> `resize();`
   >
   >    ```java
   >    if (++size > threshold)
   >        resize();
   >    ```
   >
   > 9. `afterNodeInsertion(evict);`这个方法是用来给`HashMap`的子类所做的一个标的，当前这里是一个空方法，也就是说，后续可能有一些其它的功能，可以在这个方法中添加，比如将做个有序的数组链表等等
   >
   > 10. `return null;`到这里，元素添加完毕

   ![](https://img-blog.csdnimg.cn/2f406002bfee4858b3841984d58911ca.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

5. 第一个元素添加完成，`HashSet`长这样

   ![](https://img-blog.csdnimg.cn/bf53331d0cd842d0b5a0ab66ad285a00.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_16,color_FFFFFF,t_70,g_se,x_16)

6. 让我们接着来添加第二个元素，从添加第二个元素起一直到添加第`13`个元素【不包括第`13`个元素，第`13`个元素还发生了一些有趣的事情，是什么呢？到时候你就知道啦~而且如果某个链表的长度已经到了`8`个元素并且此时数组容量超过了`64`，那么该链表会转化为红黑树，那如果数组容量没有超过`64`但是链表长度超过了`8`，此时会发生什么呢？此时会一直先扩容到`64`然后再将链表转化为红黑树。这个后面也会提到滴】，中途发生的东西都是一样一样滴

   还是原来的配方，熟悉的味道，照样还是调用`put`方法然后进入到`putVal()`调用`hash()`传入哈希值，跟前面的第`1 2 3`步没什么区别，这里我们直接跳过，直接进入到`putVal()`方法

   ![](https://img-blog.csdnimg.cn/5e9d2e856df842138de4ab4b144f7da9.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

7. 继续阅读这个重点源码`putVal();`

   > 1. `Node<K, V>[] tab; Node<K, V> p; int n, i;`还是定义几个辅助变量，这里再说下，这个`tab`是节点数组，`p`是某索引下数组中的元素节点，`n`是数组长度，`i`是根据哈希计算得来的索引
   >
   > 2. ```java
   >    if ((tab = table) == null || (n = tab.length) == 0)
   >        n = (tab = resize()).length;
   >    ```
   >
   >    可以看到，`table`赋值给了`tab`，此时`table`已经不是`null`，并且在第一次的时候已经添加了元素`1`，所以长度不再为`0`故这里不再进行扩容，跳过
   >
   > 3. ```java
   >    if ((p = tab[i = (n - 1) & hash]) == null)
   >        tab[i] = newNode(hash, key, value, null);
   >    ```
   >
   >    获取当前数组最后一个位置的索引和哈希值进行一个与操作得到索引，判断当前索引是否为`null`，很明显这里是一个`null`，所以直接在这个位置存储第二个节点
   >
   > 4. 重复上述第`4`大步中的第`7 8 9 10`步骤，至此添加元素完成

   ![](https://img-blog.csdnimg.cn/ec448325f0334ac292bef9bac73f92f0.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

#### 5.1.2 `HashSet`第二次扩容

1. 随后添加的第`3 4 5 6 7 8 9 10 11 12`都是如此，我们直接调到`i = 12`的情况，前面的步骤没什么差别，重点在于最后的：因为`threshold = 12`，`++size = 13`超过了，所以要进行第二次扩容，让我们一起看看第二次扩容都发生了什么吧~

   ```java
   if (++size > threshold)
       resize();
   ```

2. 第二次扩容又到来我们的老朋友`resize()`这里做客了

   > 1. `Node<K, V>[] oldTab = table;`存储老表
   >
   > 2. `int oldCap = (oldTap == null) ? 0 : oldTab.length;`存储老表的长度，很明显是`16`
   >
   > 3. `int oldThr = threshold;`存储老表的阈值，很明显是`12`
   >
   > 4. `int newCap, newThr = 0;`创建新容量和新阈值
   >
   > 5. 很明显老表的容量`= 16 > 0`，这是`newCap`到底要赋予多少的容量而做的一个判断，`MAXIMUM_CAPACITY`的数值是`1 << 30`也就是`1 * 2^30`很明显，一般都不会到达这个数值，所以这里进入的是第二个`else if()`【点击栈顶可以快速回到执行处】，`oldCap << 1`也就是老表容量的`2`倍传递给`newCap`确保是小于`MAXIMUM_CAPACITY`的，这个`MAXIMUM_CAPACITY`有多大？前面已经提到过是`1 << 30`所以这个条件是符合的，再来看第二个条件：`oldCap >= DEFAULT_INITIAL_CAPACITY`也就是老表的容量是`>=`默认容量的，都是`16`很明显这个条件也是符合的。
   >
   >    执行代码，到了这里，新的容量和新的阈值都诞生了：`newCap = oldCap << 1`，`newThr = oldThr << 1`都是原先容量和原先阈值的两倍，这里新容量就是`32`，新阈值就是`24`
   >
   >    ```java
   >    if (oldCap > 0) {
   >        if (oldCap >= MAXIMUM_CAPACITY) {
   >            threshold = Integer.MAX_VALUE;
   >            return oldTab;
   >        }
   >        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
   >                 oldCap >= DEFAULT_INITIAL_CAPACITY)
   >            newThr = oldThr << 1; // double threshold
   >    }
   >    ```
   >
   > 6. 很明显`newThr == 0`不符合条件直接跳过
   >
   >    ```java
   >     if (newThr == 0) {
   >         float ft = (float)newCap * loadFactor;
   >         newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
   >                   (int)ft : Integer.MAX_VALUE);
   >     }
   >    ```
   >
   > 7. `threshold = newThr;`赋予新的阈值，阈值为：`32 * 0.75 = 24`
   >
   > 8. `Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];`创建新的节点数组
   >
   > 9. `table = newTab;`数组`table`指向新的节点数组
   >
   > 10. 判断老数组中有无元素，很明显之前存入的`12`个元素都还在里边，我们看看如果老数组存在元素会发生什么有趣的事情？
   >
   >     定义一个普通`for`循环，遍历数组中的每一个链表，创建一个`Node`节点`e`指向当前索引的头结点，这里第一个指向的是`index = 0`索引，很明显没有元素，`j++`，到下一个，`index = 1`，有节点，进入，将`oldTab`数组和链表的联系切断即`oldTab[j] = null;`如果新结点的`next`是`null`的话，说明该链表只有一个元素【这里是为了判断是否要转化为红黑树节点设置的】，如果没有的话直接存入新数组中，照样索引的取值`= e.hash & (newCap - 1)`哈希值和数组最大索引的与运算结果。
   >
   >     **<font color="red">到这里节点的操作就结束了，但是如果节点并不是红黑树节点，并且`next`有节点这种情况呢？这里有必要还要继续说说这种情况：在这里，你将弄明白索引的运算到底是个什么原理？高位链表和低位链表是什么？为什么需要这样做？扩容之后，之前的元素到底是怎么转换的？等等这些答案都将一一揭晓</font>**
   >
   >     - <font color="deepskyblue">**这里为什么要使用高位链表和低位链表两条链表？**</font>
   >     
   >       我猜是因为整个数组都扩容了，可以适当拆分掉链表，使得查找的效率更高，因为相比于把元素都放在一整条链表里面，把链表拆分，高位的放在高位链表，低位的放在低位链表，一条长链表变成了短链表，通过哈希值确定某个索引位置再查找链就可以大大提高效率
   >     
   >     - <font color="deepskyblue">**索引到底是怎么计算出来的？**</font>
   >     
   >       先说结论，其实索引就是元素的哈希值和`数组容量-1`进行与操作的结果，相当于`hash % table.length`，其实原理也很简单，因为`hash`即哈希值一般来说是一个挺大的数，想要存放在一个相对较短的数组里面必然是用余操作，这个没问题，这里本来可以直接用：`e.hash % newCap`但是为什么还要用`e.hash & (newCap - 1)`呢？因为这样效率更高，直接进行位运算，比使用`%`运算的效率更高。
   >     
   >       当然这里还有一个前提条件：就是`table.length`的长度必须是`2`次幂才可以，如果不是`2`次幂无法直接将`%`运算转换成`&`运算的模式，所以这就是为什么``HashSet/HashMap`的初始化容量是`16`
   >     
   >       那么`%`运算是如何转换为`&`运算的呢？我们来看一个例子：10 % 8 这个很简单，答案是2
   >     
   >       将`10 8 2`三个数字转换成二进制的形式，分别是：
   >     
   >       - `10`：`00001010`
   >       - `8`：`00001000` ---> `8 - 1` ---> `00000111`
   >       - `2`：`00000010`
   >     
   >       我们知道`10 / 8`相当于是`10 >> 3`，也就是整体右移`3`位，得到的结果是：`00000001`被舍去掉的就是`010`这就是余数。因为我们要得到的是余数，所以我们的重点就是得到这`3`位数。那么，如何获取这个余数呢？
   >     
   >       我们知道，无论是`0`还是`1`当它与`1`进行与运算的时候，都能得到它的本身，所以一想，如果我们能将`10 ---> 0001010`跟`00000111`运算，岂不是就能得到最后`3`位数也就是余数`00000010`了吗？
   >     
   >       **通过这个例子，我们就可以知道，如果想要获取一个数的余数，可以通过将这个数和`另外一个数 - 1`进行与运算的方式得到余数。也就是下面这中形式：**
   >     
   >       首先将`10 & (8 - 1) ---> 00001010 & 00000111`，我们可以知道只要是`&`运算，有`0`必然就是`0`，有`1`就是它本身，所以我们很快得出最后`3`位一定是`10`的最后`3`位：`00000010`
   >     
   >       到这里我们就明白索引是怎么计算出来的了，索引其实就是哈希值和数组长度的余数，但是因为想要效率更高所以转换成与操作，这也就是为什么需要`HashSet`的长度为`2次幂`的原因。
   >     
   >     - <font color="deepskyblue">**高位链表和低位链表**</font>
   >     
   >       因为原先的数组长度是`16`，想要得到索引需要与`15`也就是`1111`做与运算，这里要想将一个链表拆分成高位链表和低位链表，在这里因为整个数组扩容到了`32`所以所谓低位就是`0 - 15`所谓高位就是`16 - 32`，如何确定索引在低位还是高位？`xxx[]xxxx`我们可以知道这低位跟高位的临界值就是`16`，`16`就是`00010000`，`15`是`00001111`由此得出，`15`以下的二进制都在后四位数里面操作，而`16 - 32`都在前四位操作，关键点就是第`5`位，只要第`5`位是`1`，不用说这个索引位置肯定是在`>= 16`的，所以关键点就在于第五位！【我们的目的是什么？目的不就是为了划分出高位链表和低位链表吗？为了达到这个目的，我们不管这个数字有多大，你跟`00010000`也就是`16`做运算的结果是`00000000`也就是`0`你就去低位链表，如果你是`00010000`得到的结果是`16`你就留在高位链表】
   >     
   >       所以只要一个`hash`值跟`16`也就是这里的`oldCap`做与运算，如果答案是`0`那么肯定是在低位链表中，如果答案不是`0`那么肯定在高位链表，再详细说明下，在一下场景中，这是第二次扩容，所以原先的容量是`16`，`16`的二进制数是`00010000`，一个数和它其与做运算，后面`4`位肯定是`0`前面`3`位也可以肯定是`0`，关键就是看第`5`位，如果第`5`也是`0`也就是得到的二进制数是：`00000000`，我们就将其放入到低位链表，如果是`16`我们就将其放到高位链表中。
   >     
   >     - <font color="deepskyblue">**读源码**</font>
   >     
   >       1. 创建高位链表和低位链表，`next`用于获取下一个元素：
   >     
   >          ```java
   >          Node<K,V> loHead = null, loTail = null;
   >          Node<K,V> hiHead = null, hiTail = null;
   >          Node<K,V> next;
   >          ```
   >     
   >       2. 开始遍历长链表：`next = e.next`获取下一个元素，紧接着判断当前节点应该存放在地位链表还是高位链表，前面已经分析过了，怎么放，用的计算方式就是：`e.hash & oldCap`，放完以后就将`next`赋给当前节点，循环操作直到所有的节点都放到了高位链表或者低位链表里头
   >     
   >          ```java
   >          do {
   >              next = e.next;
   >              if ((e.hash & oldCap) == 0) {
   >                  if (loTail == null)
   >                      loHead = e;
   >                  else
   >                      loTail.next = e;
   >                  loTail = e;
   >              }
   >              else {
   >                  if (hiTail == null)
   >                      hiHead = e;
   >                  else
   >                      hiTail.next = e;
   >                  hiTail = e;
   >              }
   >          } while ((e = next) != null);
   >          ```
   >     
   >       3. 现在我们手中有两个链表，低位链表和高位链表，但是还没有把它放到数组中，放到哪里这个问题可以转换位问低位链表中的低位是什么意思？高位链表中的高位是什么意思？低位还是高位要看新数组的容量是多少，很明显这里是`32`，所以这里的低位就是`0 - 15`也就是老数组的容量，`16 - 31`也就是新数组的容量，为了有对应的存放位置，使用上`j`：
   >     
   >          【整幅代码非常的巧妙，就这么小的一个链表，都能想着拆分成两个提高效率】
   >     
   >          `newTab[j] = loHead;`表示是放低位，因为`j`已经限制在了老容量`oldCap`范围之内
   >     
   >          `newTab[j + lodCap] = hiHead;`表示是放高位，`j + oldCap`相当于升了一阶
   >     
   >          ```java
   >          if (loTail != null) {
   >              loTail.next = null;
   >              newTab[j] = loHead;
   >          }
   >          if (hiTail != null) {
   >              hiTail.next = null;
   >              newTab[j + oldCap] = hiHead;
   >          }
   >          ```
   >     
   >     ```java
   >     if (oldTab != null) {
   >         for (int j = 0; j < oldCap; ++j) {
   >             Node<K,V> e;
   >             if ((e = oldTab[j]) != null) {
   >                 oldTab[j] = null;
   >                 if (e.next == null)
   >                     newTab[e.hash & (newCap - 1)] = e;
   >                 else if (e instanceof TreeNode)
   >                     ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
   >                 else { // preserve order
   >                     Node<K,V> loHead = null, loTail = null;
   >                     Node<K,V> hiHead = null, hiTail = null;
   >                     Node<K,V> next;
   >                     do {
   >                         next = e.next;
   >                         if ((e.hash & oldCap) == 0) {
   >                             if (loTail == null)
   >                                 loHead = e;
   >                             else
   >                                 loTail.next = e;
   >                             loTail = e;
   >                         }
   >                         else {
   >                             if (hiTail == null)
   >                                 hiHead = e;
   >                             else
   >                                 hiTail.next = e;
   >                             hiTail = e;
   >                         }
   >                     } while ((e = next) != null);
   >                     if (loTail != null) {
   >                         loTail.next = null;
   >                         newTab[j] = loHead;
   >                     }
   >                     if (hiTail != null) {
   >                         hiTail.next = null;
   >                         newTab[j + oldCap] = hiHead;
   >                     }
   >                 }
   >             }
   >         }
   >     }
   >     ```
   >
   > 11. 完成了整个扩容操作，返回新的数组即可：
   >
   >     ```java
   >     return newTab;
   >     ```

   ![](https://img-blog.csdnimg.cn/8a95c861bc744ac6bc06a49213702030.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

   ![](https://img-blog.csdnimg.cn/9e5ef748e2464cc29f06e56ecf98ac51.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

#### 5.1.3 `HashSet`扩容的细节

`HashSet`如果某个链表达到了`8`个数量，并且`HashSet`的数组长度达到了`64`就会将这个链表转化为红黑树，注意是这个链表哦，这是出于增删改查的效率决定的。那如果达到了`8`个数量级但是数组长度没有达到`64`呢，此时就会将数组一直扩容到`64`转换成红黑树后，再添加下一个元素

`HashSet`是如何扩容的我们总算是搞完了，总结一下就是：

1. `HashSet`的默认容量是`16`，每一次扩容都是加倍扩容
2. `HashSet`有一个加载因子，当添加的元素数量等于`加载因子 * 当前数组的长度`时，就会开始扩容
3. 链表会在某条件下转换成红黑树，具体见`5.1.3`

#### 5.1.4 `HashSet`添加元素的细节

上述基本情况和源码都说了一个遍了，但是还有一个很重要的还没有说？就是我们知道`HashSet`是无序且不可重复的，无序这个好理解，因为哈希值是计算出来的，结果不一样，顺序可能不一样。那不可重复又是如何做成的呢？

之前添加的元素的哈希值都是不一样的，如果哈希值的值是一样的呢？我们知道哈希值如果一样，那根据索引的计算方式：`hashCode & (n - 1)`那么哈希值一样索引就是一样的，这一小段代码我们还没有看，让我们一探究竟！

`else`之前的两个判断为：`tab`是否是空的，如果是是空的进行第一次扩容，然后判断根据哈希值求出来的索引上有没有数据，没有数据就直接存储节点。

所以`else`这里判断的就是如果得到的索引值上有数据要如何处理结果？到底如何处理呢？请看：

> 1. `Node<K, V> e; K k;`首先定义一个节点以及创建一个跟需要添加的数据一样类型的对象`k`
>
> 2. `if(p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))`判断当前的元素的哈希值跟头结点的哈希值是不是一样的，如果一样接着判断传进来的`key`和头结点的`key`【这里因为是`HashSet`，`HashSet`，存储元素就是存放在`key`里头】如果比较的是对象则比较的是内存地址是不是一样的，如果比较的是基本数据类型则比较的是值，如果本身就是同一个东西，那它直接返回`true`，减少了后续判断，如果不是同一个内存地址，使用`equals`看内容是不是一样的。如果内容也是一样的，将当前的头结点赋值给刚刚创建的节点`Node<K, V> e;`
>
>    有些人可能很好奇，为什么这里返回的是一个节点？而在`main`方法中打印的是`boolean`值，这是因为`boolean`方法是在`add()`方法发生的，判断从`put()`方法有没有返回元素`value`，如果返回的是`null`则表示没有相同元素存在，故添加成功；如果返回的是非空元素，也就是说`添加的元素已经存在了`则表示添加不成功，声明下，`add()`方法就是用来说明添加是否成功的？而添加是否成功的关键就看要添加的元素是否已经存在在`HashSet`中，如果不存在也就是`put() == null`返回`true`表示添加成功，如果`put() != null`返回`false`表示添加失败
>
>    这里的`equals`方法程序员是可以自定义的，由于`String`类型重写了`equals`方法，只要内容相同就认为是同一个对象，因此这里会直接返回`true`
>
> 3. 继续看代码：如果头结点属于树节点，则进入`putTreeVal`判断是否有重复没有就添加
>
>    ```java
>    else if (p instanceof TreeNode)
>        e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
>    ```
>
> 4. 第一步已经判断跟头结点是否是重复元素【提高效率】，第二步判断是不是树节点，这两个情况分开讨论，如果上述都不满足，就需要进入到这条链表中，取出每一个结点跟要添加的元素进行比较，只要有一个结点跟这个元素是相同的，表明无法添加。
>
>    ```java
>    else {
>        for (int binCount = 0; ; ++binCount) {
>            if ((e = p.next) == null) {
>                p.next = newNode(hash, key, value, null);
>                if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
>                    treeifyBin(tab, hash);
>                break;
>            }
>            if (e.hash == hash &&
>                ((k = e.key) == key || (key != null && key.equals(k))))
>                break;
>            p = e;
>        }
>    }
>    ```
>
>    开始遍历每一个结点，如果当前链表只有头结点一个节点，因为之前已经判断过了头结点跟要添加的元素不构成重复关系，所以直接添加即可：
>
>    `p.next = newNode(hash, key, value, null);`添加新元素到这条链表中
>
>    `if (binCount >= TREEIFY_THRESHOLD - 1) treeifyBin(tab, hash); // -1 for 1st`判断当前链表的数量是否已经`= 8`如果`= 8`则需要做红黑树转换
>
>    `break`：添加成功，退出循环，返回`null`
>
>    ```java
>    if ((e = p.next) == null) {
>        p.next = newNode(hash, key, value, null);
>        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
>            treeifyBin(tab, hash);
>        break;
>    }
>    ```
>
>    如果当前节点跟要添加的元素哈希值相同并且（内存地址相同【引用数据类型】或者值相同【基本数据类型】或者使用`equals`判断相同）则表示当前节点和要添加的元素构成重复关系，不往里面添加值，直接退出循环，为什么这里可以直接退出循环呢？因为在上一个判断中：`if((e = p.next) == null)`此时`e`已经指向当前节点，在下面这段代码中此时`break`，意味着当前节点也就是`e`指向的节点跟添加的元素重复了，所以直接`break`即可
>
>    ```java
>    if (e.hash == hash &&
>        ((k = e.key) == key || (key != null && key.equals(k))))
>        break;
>    ```
>
> 5. 返回节点的`value`值，有些同胞们可能感到奇怪，为什么明明搞的是`key`这里却返回的是`value`，嘿嘿，这就是大神们的操作，因为`HashSet`的底层就是`HashMap`，`HashMap`里头是键值对，看的是`key-value`，如果前面判断了`key`都是一样的，但是`value`不一样，`HashMap`也是要存储的，会更新原来的`value`值，但是`HashMap`直接调用的是`put()`方法，而`HashSet`是调用的是`add()`方法，同一个方法，就显示出了不同的功能，这绝实属于写代码的高级境界了。
>
>    **<font color="red">在`HashSet`中有返回`value`说明重复，不添加</font>**
>
>    **<font color="red">在`HashMap`中有返回`value`说明`key`已存在，更新`value`</font>**
>
>    ```java
>    if (e != null) { // existing mapping for key
>        V oldValue = e.value;
>        if (!onlyIfAbsent || oldValue == null)
>            e.value = value;
>        afterNodeAccess(e);
>        return oldValue;
>    }
>    ```

![](https://img-blog.csdnimg.cn/55804be127d645c1a68eed4a6533b90d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

<font color="red">**到此`HashSet`源码剖析就到此结束了，想必已经讲得非常透彻。**</font>

#### 5.1.5 `HashSet`的最佳实践

定义一个`Employee`类，该类包含：`private`成员属性`name.age`

1. 创建`3`个`Employee`对象放入`HashSet`中
2. 当`name`和`age`的值相同时,认为是相同员工，不能添加到`HashSet`集合中

```java
package Chapter03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("张三", 25));
        hashSet.add(new Employee("张三", 25));
        hashSet.add(new Employee("张三", 25));
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
        System.out.println(hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

### 5.2 `LinkedHashSet`

1. `LinkedHashSet`是`HashSet`的子类

2. `LinkedHashSet`的底层是`LinkedHashMap`，底层维护的是一个**数组**和**双向链表**

3. `LinkedHashSet`根据元素的`HashCode`即哈希值决定元素的存储位置，同时使用双向链表维护元素的次序，这使得元素看起来是以插入顺序保存的【也就是取出来的顺序跟添加的元素是一样的】

   ![](https://img-blog.csdnimg.cn/eb29610b5e7a478e8a4be35322b6c703.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pbmdtZW5nc2h1eGlhd28=,size_16,color_FFFFFF,t_70)

4. `LinkedHashSet`也是`HashSet`的一种，不允许添加重复的元素

![](https://img-blog.csdnimg.cn/816f1c3604cb4abaa67363ad6207fe49.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_14,color_FFFFFF,t_70,g_se,x_16)

`LinkedHashSet`源码剖析：

> 1. 在`LinkedHashSet`中维护了一个哈希表和双向链表，双向链表有`head`和`tail`
>
> 2. 每一个节点中都有`before`和`after`属性，这是形成双向链表的必要条件
>
>    ```java
>    tail.next = newElement;
>    newElement.pre = tail;
>    tail = newElement;
>    ```
>
> 3. 在添加一个元素的时候，先求出哈希值再求索引，确定该元素在哈希表中的位置，然后将添加的元素加入到双线链表中，跟他爸爸`HashSet`一样，不能重复添加
>
> 4. 因为每次插入一个节点，`tail`都会指向它，这就使得插入顺序是一定的，我们总是可以通过双向链表找到下一个节点【不管是不是在一个索引上，都可以找到】
>
> 5. `LinkedHashSet`的底层是`LinkedHashMap`，`LinkedHashMap`是`HashMap`的子类

```java
package Chapter03;

import java.util.LinkedHashSet;

public class LinkedHashSetSource {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new String("AAA"));
        linkedHashSet.add(456);
        linkedHashSet.add(456);
        linkedHashSet.add(new Customer(1001, "Z"));
        linkedHashSet.add(123);
        linkedHashSet.add("XML");
        System.out.println(linkedHashSet);
    }
}

class Customer {
    private int no;
    private String name;

    public Customer(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
```

打印结果：可以看到结果是有序的，但是`HashSet`是无序的

```java
[AAA, 456, Customer{no=1001, name='Z'}, 123, XML]

Process finished with exit code 0
```

其实啊，`LinkedHashSet`的添加方法跟`HashSet`的添加方法是没区别的，都是`add put putVal`这三个方法，只是将节点变成了双向链表的节点，有`before`还有`after`，`LinkedHashSet`的底层是`LinkedHashMap`，添加的节点叫做`Entry`，`Enrty`是继承了`Node`类的子类。

可以看到`table`也就是哈希表是`HashMap$Node`但是存放的元素是：`LinkedHashMap$Entry`这两个一个是`HashMap`的子类一个是`Node`的子类。通过下图可以看到`Entry`类的实现是在`LinkedHashMap`中完成的，这是一个静态内部类。

![](https://img-blog.csdnimg.cn/67cc756918504dbfa48eaf0746c78afe.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

![](https://img-blog.csdnimg.cn/ffa800d583514e13941300b07deebf82.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

存入的节点如下：可以看到`value`的值跟当时剖析`HashSet`源码时没区别。

![](https://img-blog.csdnimg.cn/43711623abaa479589ce4d64f279c74a.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

再继续存入一个节点，可以看到`after`和`before`这两个双向链表最明显特征的显示，这就使得插入时是保持顺序插入的：

![](https://img-blog.csdnimg.cn/ab77c44bd1fb413b91d3a5ae66e5837b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

### 5.3 `TreeSet`

`TreeSet`实现了`Set`接口，与`HashSet`最大的区别就是`TreeSet`可以排序。所以在向`TreeSet`添加元素的时候，若不指定比较器，那么会将`key`强制转换为比较器比较，因此`key`必须实现`Comparable`接口，不然无法添加元素。可以看下面这个例子，很明显的报错了，因为`Person`。没有实现`Comparable`接口，所以无法添加元素。

![](https://img-blog.csdnimg.cn/865db0ddc0564fdda6af2a7fd52516ce.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

`TreeSet`的底层就是`TreeMap`，要想弄清楚`TreeSet`，就顺带弄清楚了`TreeMap`。通过`TreeSet`的无参构造方法可以看见底层是`TreeMap`

![](https://img-blog.csdnimg.cn/087faf4506944290b5c1e202bf7eec71.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

`TreeSet`添加元素会调用`TreeSet.add()`方法，进而会调用`TreeMap.put()`方法，这里跟`HashSet`一样，`value`值也是直接给了一个`new Object()`：

![](https://img-blog.csdnimg.cn/6f05d2bb77a14e9a9c26c08149fec2d0.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

接下来进入到`TreeMap.put()`方法一探究竟，到底是如何添加元素的？

> 1. `Enrty<K, V> t = root;`获取到二叉树的根结点【`TreeMap`的底层数据结构就是二叉树】
>
> 2. `if(t == null)`说明这是一棵没有任何数据的空二叉树，直接看看能不能插入
>
>    `compare(key, key);`进入`compare()`方法中判断有无比较器
>
>    `root = new Entry<>(key, value, null);`赋予该元素在根结点的位置上
>
>    `size = 1;`元素个数为`1`
>
>    `modCount++;`修改次数增加
>
>    `return null;`返回`null`表示添加成功
>
> 3. ```java
>    int cmp;
>    Entry<K,V> parent;
>    // split comparator and comparable paths
>    Comparator<? super K> cpr = comparator;
>    if (cpr != null) {
>        do {
>            parent = t;
>            cmp = cpr.compare(key, t.key);
>            if (cmp < 0)
>                t = t.left;
>            else if (cmp > 0)
>                t = t.right;
>            else
>                return t.setValue(value);
>        } while (t != null);
>    }
>    else {
>        if (key == null)
>            throw new NullPointerException();
>        @SuppressWarnings("unchecked")
>            Comparable<? super K> k = (Comparable<? super K>) key;
>        do {
>            parent = t;
>            cmp = k.compareTo(t.key);
>            if (cmp < 0)
>                t = t.left;
>            else if (cmp > 0)
>                t = t.right;
>            else
>                return t.setValue(value);
>        } while (t != null);
>    }
>    ```
>
>    这是一段比较器，如果比较器不为`null`，则一直遍历到最后一个父元素节点，如果要添加的元素通过比较器判断要比父结点小，则放在左边，如果大则放在右边，如果一样，就覆盖掉父元素的`value`值，因为`TreeSet`插入的元素是按照`key`来的，所以我们看`TreeSet`是插不进去的，但是看`TreeMap`可以看到父元素节点的`value`值发生了变化，被覆盖了
>
> 4. 也就是说这里的`abc`我们插入不进去

![](https://img-blog.csdnimg.cn/b53c54af31c04a93aaa3fc61977dc0b5.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)





## 6. `Map`接口

![](https://img-blog.csdnimg.cn/fc8dade994fe429c8af659315a13b830.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

双列集合，存储数据的形式是键值对。之前在学习`HashSet`和`LinkedHashSet`的时候其实已经间接的学习了`Map`接口的实现类`HashMap`了，之前我们往`HashSet`或者`LinkedHashSet`存储元素的时候表面上看好像只是存储了的是单列形式的数据，但深入源码之后可以发现，存储的还是键值对的形式，用户添加的数据存储在`key`上，而`value`则是默认赋予了一个定格的数据：`PRESENT ---> new Object()`，现在要学习的`Map`在这里就不一样，`value`是程序员或者说是用户自定义传递进来的数据。

![](https://img-blog.csdnimg.cn/4fb293ac7c034140b86a954c9b163292.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

![](https://img-blog.csdnimg.cn/ea7afbbf68974328b7b992a79e0cd82d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

- `Map`接口拥有着大量的应用场景，非常使用，所以搞懂`Map`非常非常非常有必要，而且必须是很透彻的那种搞懂而不是一知半解的那种。

- **`Map`接口的特点：**

  1. `Map`和`Collection`并列存在，用于保存具有映射关系的数据`key-value`也就是键值对形式的数据

  2. `Map`中的`key`和`value`是可以引用任何类型的数据[`Object`]，会封装到`HashMap$Node`对象中

  3. `Map`中的`key`不允许重复【严格意义上说是一种有条件的不可重复，如果哈希值或者`equals`方法不同说明是不一样的元素，这就可以添加，即使看着是一样的，但其实并不一样，此时不构成重复】，因为`Map`实现类中是通过`Key`得到哈希值而得到索引进而再使用`equals`方法比较，所以在该实现机制下，认为哈希值得到的索引然后调用`equals`方法内容相同就会认为是同一个东西，此时被认为是一个重复值从而**覆盖**掉原来的`key`中的`value`，所以`key`想重复也重复不了，除非是两个不一样的对象。

     但是`value`是可以一样的。也就是说不同的`key`可以允许有一样的`value`。

  4. `Map`中的`key`可以为`null`，`value`也可以为`null`

  5. 通常使用`String`类作为`Map`的`key`

  6. `key-value`之间的关系是单向一对一的关系，通过`key`总能找到相对应的`value`

  7. 因为哈希值是无法确定的，导致索引无法确定，所以存放的顺序跟取出的顺序不一致【`HashMap`】

  8. 通过`get()`方法获取某个`key`的`value`值

  ```java
  package Chapter03;
  
  import java.util.HashMap;
  import java.util.Map;
  
  public class MapStudy {
      public static void main(String[] args) {
          Map map = new HashMap<>();
          map.put("no1", "逻辑");
          map.put("no2", "水滴");
          map.put("no1", "地球");
          map.put("no3", "三体");
          map.put(null, null);
          map.put(null, "碳中和");
          map.put("no4", null);
          map.put("no5", null);
          map.put(new Object(), "新能源");
          System.out.println(map.get("no1"));
          System.out.println(map.get("no2"));
          System.out.println(map.get("no3"));
          System.out.println(map.get("no4"));
          System.out.println(map.get("no5"));
          System.out.println(map.get(null));
          System.out.println(map);
      }
  }
  ```

  注：`Map`存放数据的`key-value`存放在`Node<K, V>`类中，因为实现了`Map.Entry<K, V>`也就是`Map`接口的静态内部接口`Enrty`接口，所以有的人说一个键值对就是一个`Enrty`。可以通过定位`putVal()`方法从而定位到存入一个键值对的本质是通过`newNode()`方法存入一个新的节点。

  ![](https://img-blog.csdnimg.cn/81c6c7d9f7e04a6db625e5d4901c7381.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

  `newNode()`方法返回的是`Node<K, V>`类的对象

  ![](https://img-blog.csdnimg.cn/abbcba431cb24ec7940c7ad0d7fd98c1.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

  继续看看`Node<K, V>`类，可以看到`Node<K, V>`是一个静态内部类并且实现了`Map.Entry<K, V>`接口。

  ![](https://img-blog.csdnimg.cn/926c46c831f7423cba2e96821207302d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

- 关于`EntrySet`初始化问题，通过调试代码发现在`putVal`的时候`EntrySet`就被初始化了，一直不清楚是怎么初始化的，在哪里初始化的，后面才知道原来`IDEA`在`Debug`模式下会隐式地调用`toString`方法，就会默认初始化了。所以得停止隐式地调用`toString`方法：

  ![](https://img-blog.csdnimg.cn/e5098b5fa7d144e2afa0eae67b91f8ec.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

  此时我们再研究`EntrySet`的初始化逻辑就变得通畅了，在通过`hashMap.entrySet()`时，会调用`entrySet()`方法：

  ![](https://img-blog.csdnimg.cn/b9fec983afcb4bb1841e3168a741f47a.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

  因为是第一次赋值，所以此时的`entrySet`这个变量肯定是一个`null`，所以赋予`entrySet`变量：`new EntrySet()`，这个`EnrtySet`又是`HashMap`的一个内部类：

  ![](https://img-blog.csdnimg.cn/ee51ddbfd98c40a4bb1a7242d015b32b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

  要想真正弄懂这个，首先你得明白什么是内部类？内部类有什么意义？内部类有什么特点？内部类有哪些？等等问题，如果弄不清楚这些是无法弄清楚`EntrySet`的，所以我们得先学习清楚内部类！

### 6.1 内部类

**为什么要用内部类？**

> 1. 内部类方法可以访问该类中定义所在的作用域中的数据，包括私有数据
> 2. 内部类可以对同一个包中的其它类隐藏起来
> 3. 当想要定义一个回调函数且不想编写大量代码时，使用匿名内部类比较便捷

**什么时候用到内部类？**

>  当描述事物时，若一个事物内部还包含由其它的事物，就可以使用内部类这种结构。比如：汽车类即`Car.class`中包含着发动机类`Engine.class`。此时发动机类就可以作为汽车类的一个内部类。

**使用内部类有什么好处？**

> 1. 内部类可以很好地实现隐藏，一般非内部类是不允许访问私有`private`属性/方法的，甚至如果你不是在同一个包下是无法访问`protected`修饰的属性/方法的，但是内部类可以，也就是说内部类拥有外部类所有元素包括属性和方法的访问权限
> 2. 内部类可以实现多重集成
> 3. 可以避免修改接口而实现同一个类中两种同名方法的调用

**使用内部类有什么缺点？**

> 内部类的结构有些许复杂，光是种类划分就可以分为：成员内部类、匿名内部类、局部内部类、静态内部类

#### 6.1.1 成员内部类

成员内部类是最普通的内部类，它是外部类的一个成员，所以它是可以无限制的访问外部类的所有属性和方法的，即使该方法或者属性是被`private`修饰的，但是外部类要访问成员内部类的方法或者属性，必须通过创建成员内部类的实例才可以访问。这就像是成员变量中的实例变量，是一样的。

我们知道成员变量是在一个类中的，如果没有该类也就没有了成员变量，成员内部类也一样，如果没有外部类，也就没有成员内部类，并且，成员内部类，我们类比于成员变量，需要先创建外部类的实例才可以创建成员内部类。

```java
package Chapter03;

public class Car {
    private boolean run = true;

    public Engine getEngine() {
        return new Engine();
    }

    class Engine {
        public void runEngine() {
            //成员内部类可以调用外部类任意权限的方法或者属性，即使是private
            if (run) System.out.println("发动机启动");
            else System.out.println("发动机坏了");
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        Car.Engine carEngine = car.getEngine();
        carEngine.runEngine();
    }
}
```

#### 6.1.2 局部内部类

局部内部类类比于局部变量，我们知道局部变量是在方法体内的， 所以局部内部类也是如此，局部变量出了大括号就不认识了，局部内部类也是如此，它出了这个方法就没人认识它了。

```java
package Chapter03;

public class Car {
    private boolean run = true;

    public void runMethod() {
        class Engine {
            public void runEngine() {
                //成员内部类可以调用外部类任意权限的方法或者属性，即使是private
                if (run) System.out.println("发动机启动");
                else System.out.println("发动机坏了");
            }
        }
        new Engine().runEngine();
    }


    public static void main(String[] args) {
        Car car = new Car();
        car.runMethod();
    }
}
```

#### 6.1.3 静态内部类

用`public static`修饰的就是表示公开的静态内部类，如果再加上一个`final`则表示该类无法被继承也就是说没有子类。它可以直接以`类.静态内部类.静态方法/静态变量`的形式调用该静态内部类中的方法，也可以直接以`new 类.静态内部类()`创建静态内部类对象。

静态内部类和非静态内部类最大一个区别在于内部类编译后会隐含地保存着一个引用，该引用是指向创建它地外部类内，但是静态内部类却没有。

```java
package Chapter03;

public class Car {
    private static boolean run = true;

    static class Engine {
        public void runEngine() {
            //成员内部类可以调用外部类任意权限的方法或者属性，即使是private
            if (run) System.out.println("发动机启动");
            else System.out.println("发动机坏了");
        }
    }


    public static void main(String[] args) {
        Car car = new Car();
        Car.Engine carEngine = new Car.Engine();
        carEngine.runEngine();
    }
}
```

#### 6.1.4 匿名内部类

匿名内部类是内部类地简化写法，它的本质是一个具体实现的父类或者父接口匿名的子类对象。在开发中，最常用的内部类就是匿名内部类了。匿名内部类的作用就是简化接口的创建以及实现的步骤。

> 1. 匿名内部类是没有访问修饰符的
> 2. 当所在的方法的形参需要被匿名的内部类使用，那么这个形参必须是`final`
> 3. 匿名内部类没有构造方法，因为本身没有名字，无意义
> 4. 不能定义静态成员

<hr/>

简单了解了什么是内部类以后，再去看回`EntrySet`就会变得相对好理解一些：我们可以看到`EntrySet`是一个成员内部类，所以它可以持有外部类的任意属性或者方法，并且它被`final`修饰着，这也就是为什么`EntrySet`在初始化的时候我们总是可以看到它持有`table`属性，而且这个`table`总跟外部类的`table`的地址一样，正是因为它是一个成员内部类。

所以这个`EntrySet`也好，`keySet`也好还是`Values`也好，都只是对`HashMap`节点中的引用。

![](https://img-blog.csdnimg.cn/83bcb0c5a9a44bd0b3ffc1b6f37f53df.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

顺带分析分析，`EntrySet`是如何通过迭代器来实现遍历的。可以看到创建了一个`EntryIterator`对象：

![](https://img-blog.csdnimg.cn/9d9637e04ee14364947299c0a124f2ee.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

继续点进去看看`EntryIterator`这个类：然后你会发现这个类并没有显式的构造方法，也就是说有隐式的无参构造方法，会调用`super()`也就是会调用`HashIterator`类的无参构造方法，所以我们进入`HashIterator`类中一探究竟

![](https://img-blog.csdnimg.cn/c9b881be5db84140a6e8ab287be76e95.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

`HashIterator`中的构造方法逻辑就是找到哈希表中索引下的第一个非空节点，后面就跟迭代器的逻辑没什么差别了，通过`hasNext()`和`next()`方法可以不断获取到下一个节点

![](https://img-blog.csdnimg.cn/f3bb07f3249f4430bd4ac28600732c43.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

### 6.2 `Map`接口常用方法

> 1. `put`：添加键值对
> 2. `remove`：根据`key`删除键值对
> 3. `get`：根据`key`获取`value`
> 4. `size`：获取键值对个数
> 5. `isEmpty`：判断`Map`是否为空
> 6. `clear`：清空`Map`
> 7. `containsKey`：查找某个`key`是否存在

```java
package Chapter03;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("no1", "罗辑");
        System.out.println("put = " + map);
        boolean isMapEmpty = map.isEmpty();
        System.out.println("isEmpty = " + isMapEmpty);
        System.out.println("get = " + map.get("no1"));
        System.out.println("size = " + map.size());
        System.out.println("remove = " + map.remove("no1"));
        map.put("no1", "罗辑");
        System.out.println("clear before = " + map);
        map.clear();
        System.out.println("clear after = " + map);
        map.put("no1", "罗辑");
        System.out.println("containsKey = " + map.containsKey("no1"));
        System.out.println("containsKey = " + map.containsKey("no2"));
    }
}
```

### 6.3 `Map`接口遍历方式

> 1. `keySet`：获取所有`key`
> 2. `entrySet`：获取所有`key-value`
> 3. `values`：获取所有`value`

```java
package Chapter03;

import java.util.*;

public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("no1", "罗辑");
        map.put("no2", "地球");
        map.put("no3", "三体");
        map.put("no4", "执剑人");
        map.put(null, null);
        //第一组：取出所有 key 然后获取相应的 value
        Set keySet = map.keySet();
        //(1) 增强 for 循环
        System.out.println("第一种：keySet ---> key ---> get(key)");
        for (Object key : keySet) {
            System.out.println(key + "-" + map.get(key));
        }
        //(2) 迭代器循环
        System.out.println("第二种：Iterator ---> key ---> get(key)");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二组：把所有的 values 取出
        //(1) 增强 for 循环
        Collection values = map.values();
        System.out.println("取出所有的 value 增强 for：");
        for (Object value : values) System.out.println(value);
        //(2) 迭代器
        System.out.println("取出所有的 value 迭代器：");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println(value);
        }

        //第三组：通过 entrySet 来获取 key-value 键值对
        Set entrySet = map.entrySet();
        //(1) 增强 for 循环
        System.out.println("使用 EntrySet 增强 for：");
        for (Object entry : entrySet) {
            Map.Entry mapEntry = (Map.Entry) entry;
            System.out.println(mapEntry.getKey() + "-" + mapEntry.getValue());
        }
        //(2) 迭代器循环
        System.out.println("使用 EntrySet 迭代器：");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object entry = iterator2.next();
            Map.Entry mapEntry = (Map.Entry) entry;
            System.out.println(mapEntry.getKey() + "-" + mapEntry.getValue());
        }
    }
}
```

### 6.4 `Map`接口练习

使用`HashMap`添加`3`个员工对象,要求`key`：员工`id`，`value`:员工对象，并遍历显示`工资>18000`的员工(遍历方式最少`2`种)员工类:姓名、工资、员工id

```java
package Chapter03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new NewEmployee("zs", 20000, 1));
        map.put(2, new NewEmployee("ls", 17000, 2));
        map.put(3, new NewEmployee("ww", 21000, 3));
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            Map.Entry mapEntry = (Map.Entry) entry;
            NewEmployee newEmployee = (NewEmployee) mapEntry.getValue();
            if (newEmployee.salary > 18000) {
                System.out.println(mapEntry.getKey() + "-" + mapEntry.getValue());
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            NewEmployee newEmployee = (NewEmployee) mapEntry.getValue();
            if (newEmployee.salary > 18000) {
                System.out.println(mapEntry.getKey() + "-" + mapEntry.getValue());
            }
        }
        Set keySet = map.keySet();
        for (Object key : keySet) {
            NewEmployee newEmployee = (NewEmployee) map.get(key);
            if (newEmployee.salary > 18000) {
                System.out.println(key + "-" + map.get(key));
            }
        }
    }
}

class NewEmployee {
    public String name;
    public double salary;
    public int id;

    public NewEmployee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "NewEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
```

### 6.5 `HashMap`特点

> 1. `HashMap`是`Map`接口中使用频率最高的实现类
> 2. `HashMap`是以键值对形式来存储数据的
> 3. `HashMap`中`key`不能重复，但是`value`可以重复，允许使用`null`建和`null`值
> 4. 如果添加相同的`key`就会覆盖掉原来的`value`，等同于修改
> 5. `HashMap`没有像`Vector`那样有`synchronized`关键字也没有实现同步互斥，因此是线程不安全的

### 6.6 `HashMap`底层机制

因为`HashSet`的底层就是`HashMap`，所以其底层机制跟`HashSet`那时候学习的东西是一模一样的，只不过`value`不再是`new Object()`，存入的数据是自定义的`value`，然后存入返回的不再是`boolean`而是原先的`value`值。

也就是说第一次返回的`null`，如果有覆盖，则返回的是被覆盖的老的`value`值。

### 6.7 `HashTable`

> 1. `HashTable`跟`HashMap`一样存放的都是键值对
> 2. `HashTable`无论是`key`还是`value`都不能存放`null`，若存放则会抛出`NullPointerException`
> 3. `HashTable`的方法跟`HashMap`的一样，存储取出删除是否包含为空清空都一样
> 4. `HashTable`是线程安全的，有`synchronized`修饰，而`HashMap`则是线程不安全的

**<font color="red">通过源码发现，在同一链表插入元素采用的是头插法的方式，后续有讲到</font>**

深入`HashTable`源码，让我们看看`HashTable`是如何初始化的，又是如何添加元素的，扩容是怎么扩的？举例的代码如下：

```java
package Chapter03;

import java.util.Hashtable;

public class HashTableSource {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put("no1", "罗辑");
        hashtable.put("no2", "三体");
        hashtable.put("no3", "地球");
    }
}
```

1. 可以看到`HashTable`的无参构造方法调用了有参构造方法，传入了初始化容量`11`和加载因子`0.75f`，也就是说`HashTable`的初始化容量不是像`HashMap`那样是`16`了，而是`11`，但是加载因子是一样的为：`0.75f`

   ![](https://img-blog.csdnimg.cn/fe05bc166cc54951bc668c3a1ffab505.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

2. 我们接着进入到`HashTable`的有参构造方法一探究竟，可以看到`HashTable`的有参构造方法先是对初始化容量`initialCapacity`和加载因子`loadFactor`做了一个判断，判断这些值是否在正常范围之内。

   然后初始化实例变量：加载因子`loadFactor`、表`table`、扩容阈值`threshold`，这里的加载因子直接赋值即可为`0.75f`，表赋予了一个`Entry`类型且容量为初始化容量的一维数组`Entry<?, ?>[initialCapacity]`，阈值为：`(int) 初始化容量 x 加载因子 = 11 * 0.75 = 8`

   ![](https://img-blog.csdnimg.cn/f4c2267507be4d7596216a9b884feaa7.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

3. 到了这里，就创建好了容量为`11`的`Entry<?, ?>[11]`表，阈值为`8`，加载因子为`0.75f`的`HashTable`

   ![](https://img-blog.csdnimg.cn/b4fc3a8846104a3aa2dc0f65b0d4a7da.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)

4. 继续看`HashTable`是如何添加元素的，视线来到了`hashTable.put("no1", "罗辑");`上面，我们进到`put`方法里头，可以看到`put`方法被`synchronized`关键字修饰，也就是告诉我们`HashTable`是线程安全的。执行`put`方法：

   首先是对`value`进行了一个`null`判断，如果`value`为`null`，则抛出`NullPointerException`，咦？不是说`key`也不能是`null`，怎么没有在这里看到对`key`是否为`null`的判断呢？

   别急，让我们慢慢往下继续看：

   - `Entry<?, ?> tab[] = table;`将之前初始化容量的`table`放入`tab`变量中

   - `int hash = key.hashCode();`关于`key`也不能为`null`的判断就在这里，因为`null`是无法调用`hashCode()`的，所以会抛出`NullPointerException`异常，有的小伙伴就会问了，那为啥`HashMap`的没事，那说明在`HashMap`的时候没看仔细，`HashMap`是调用了自身的`hash()`方法，而这个方法判断`key`是否为`null`，如果为`null`，那么哈希值为`0`：

     ```java
     static final int hash(Object key) {
         int h;
         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
     }
     ```

     到这里就告诉我们：在`HashTable`中，无论是`key`还是`value`都不能是`null`，若是则会抛出`NullPointerException`空指针异常

   - `int index = (hash & 0x7FFFFFFF) % tab.length;`获取索引，这里括号里面是为了获取到正整数，而后面的`%`操作是为了让索引在数组范围之内

   - `Entry<K,V> entry = (Entry<K,V>)tab[index];`获取到该索引下数组的元素

   - `for(; entry != null ; entry = entry.next)`想对该链表进行一个遍历，并且每次遍历一个元素都会对该节点的`hash`进行一个判断，若不同则再进行`equals`判断，目的就是防止添加重复元素，也就是说`HashTable`也是不能添加重复元素的。这里没有进入到循环体中，因为很明显因为这是第一次添加这个元素，所以直接跳过循环，到下一步

   - `addEntry(hash, key, value, index);`进入到`addEntry()`方法里头添加键值对到`Entry`数组中

     > 1. `modCount++;`保存数组的修改次数
     >
     > 2. `Entry<?, ?> tab[] = table;`定义一个变量指向数组
     >
     > 3. `if(count >= threshold)`如果`count`也就是已添加的个数大于等于阈值**<font color="red">注意这里是已经添加的元素个数，将要添加的还没有算进去，比如现在数组里面有 7 个元素，现在要添加进去第 8 个，此时不扩容，因为数组里面还没有到 8 个，所以说 HashTable 扩容是看已经有的实实在在的情况，并且你可以看到 HashMap HashSet LinkedHashSet 也是如此都是跟 HashTable 一样走一步看一步，到了要添加第 9 个的时候才会扩容，而 HashMap 则是到了 13 才会扩容，除此之外顺带讲下 HashMap 的树化，树化也是如此，树化在第 8 个的时候不会树化，在添加第 9 个元素的时候链表才会转换成红黑树，这是一个细节点，非常需要注意</font>**，则需要进行扩容，重新获取哈希值和索引，扩容机制在`rehash()`方法中完成，我们进入到`rehash()`中看看是怎么一肥事：
     >
     >    - `int oldCapacity = table.length;`先是保存了老表的长度即老表的容量
     >
     >    - `Entry<?, ?>[] oldMap = table;`保存起原来的数组，这样等下需要把老数组的数据转移到新数组上
     >
     >    - `int newCapacity = (oldCapacity << 1) + 1;`新容量赋值为`2`倍老表的容量再`+1`，所以说`HashTable`扩容后的容量是原先老容量的`2倍 + 1`，由于这里初始化容量是`11`，所以扩容以后容量为：`2 * 11 + 1 = 23`
     >
     >    - ```java
     >      if (newCapacity - MAX_ARRAY_SIZE > 0) {
     >          if (oldCapacity == MAX_ARRAY_SIZE)
     >              // Keep running with MAX_ARRAY_SIZE buckets
     >              return;
     >          newCapacity = MAX_ARRAY_SIZE;
     >      }
     >      ```
     >
     >      如果新容量比最大值`MAX_ARRAY_SIZE`还大，需要赋予最大的容量给`newCapacity`
     >
     >    - `Entry<?,?>[] newMap = new Entry<?,?>[newCapacity];`：创建一个新的容量数组
     >
     >    - `modCount++;`保存更改的数据
     >
     >    - `threshold`存储阈值
     >
     >    - `table`将新容量`entry`数组赋值给哈希表`table`
     >
     >    - 遍历原来的数组，获取节点，然后通过`next`不断遍历，每一个结点都重新获取哈希值然后跟`newCapacity`相余得到新的索引，最后将数据存储到新数组中去
     >
     >    - 到此完成扩容操作
     >
     >    ![](https://img-blog.csdnimg.cn/4ccf59b014eb44fdbe072b6c6f7b8b28.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)
     >
     >    4. `tab = table`完成扩容后需要将新的数组赋值给要添加的`tab`
     >
     >    5. `hash = key.hashCode()`重新获取哈希值
     >
     >    6. `index = (hash & 0x7FFFFFFF) % tab.length;`重新获取索引
     >
     >    7. 获取到当前索引的节点，然后把新结点也就是新元素插在这个节点的前面，也就是说`HashTable`采用的竟然是头插法！！！
     >
     >       ```java
     >       Entry<K,V> e = (Entry<K,V>) tab[index];
     >       tab[index] = new Entry<>(hash, key, value, e);
     >       ```
     >
     >       通过以下这段代码也可以验证：
     >
     >       ```java
     >       package Chapter03;
     >       
     >       import java.util.Hashtable;
     >       import java.util.Objects;
     >       
     >       public class HashTableSource {
     >           public static void main(String[] args) {
     >               Hashtable hashtable = new Hashtable();
     >               hashtable.put(new Dog("no1", 11), 1);
     >               hashtable.put(new Dog("no2", 11), 2);
     >               hashtable.put(new Dog("no3", 11), 3);
     >           }
     >       }
     >       
     >       class Dog {
     >           private String name;
     >           private int age;
     >       
     >           public Dog(String name, int age) {
     >               this.name = name;
     >               this.age = age;
     >           }
     >       
     >           @Override
     >           public String toString() {
     >               return "Dog{" +
     >                       "name='" + name + '\'' +
     >                       ", age=" + age +
     >                       '}';
     >           }
     >       
     >           @Override
     >           public int hashCode() {
     >               return 1;
     >           }
     >       }
     >       ```
     >
     >       ![](https://img-blog.csdnimg.cn/05dbc56cedd04a82ba4cf73302476a4b.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)
     >
     >    8. `count++`元素个数添加
     >
     > ![](https://img-blog.csdnimg.cn/d5e949a144574737b3e876b23a296d4d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)
   
   ![](https://img-blog.csdnimg.cn/9686136e64d4465e81d1e34457ef2d5a.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBAQ3JBY0tlUi0x,size_20,color_FFFFFF,t_70,g_se,x_16)
   
   到了这里就把`HashTable`的源码剖析完成了，`HashTable`很不一样：
   
   - 它的初始容量不仅是`11`
   - 初始阈值为`8`
   - 扩容方式为：`2 x 原先容量` + 1也就是二倍加上1，这就挺神奇的一套做法
   - 除此之外还有两个很细节的点，一是无论是`key`还是`value`都无法是`null`
   - 而且添加的时候，如果元素也就是节点都在同一个链表上，采用的是头插法，是一种最后进来的在最前面的一种方式

### 6.8 `Properties`

`Properties`是`HashTable`的子类，间接实现了`Map`接口，`Properties`特点有：

1. `Properties`类继承了`HashTable`类并且实现了`Map`接口也就是以一种键值对的形式保存数据
2. `Properties`使用特点与`HashTable`类似
3. `Properties`还可以用于`xxx.properties`文件中，加载数据到`Properties`类对象并进行读取和修改，`xxx.properties`文件通常作为配置文件使用

### 6.9 `TreeMap`

详见`5.3 TreeSet`

## 7. 集合选型规则

在开发中选择什么集合，主要取决于业务操作特点，然后根据不同集合的特型进行选择：

1. 先判断存储的类型是什么？是一组对象还是一组键值对

2. 如果是一组对象，则在`Collection`接口中选：

   - 允许元素重复：`List`
     - 增删多：`LinkedList`底层维护了一个双向链表
     - 改查多：`ArrayList`底层维护`Object`类型的可变数组
     - 线程安全且改查多：`Vector`
   - 不允许元素重复：`Set`
     - 无序：`HashSet`，底层是`HashMap`，维护了一个哈希表（数组 + 单向链表 + 红黑树）
     - 有序：`LinkedHashSet`【插入和取出顺序一致：数组 + 双向链表】 + `TreeSet`【排序】

3. 如果是一组键值对，则在`Map`接口中选：

   - 键无序：`HashMap`，底层维护了一个哈希表（数组 + 单向链表 + 红黑树）

     ​				`HashTable`，底层维护了一个哈希表（数组 + 单向链表），初始化容量为`11`，扩容为`2倍+1`

   - 键排序：`TreeMap`

   - 键插入和取出的顺序一致：`LinkedHashMap`

   - 读取文件：`Properties`

## 8. `Collections`工具类

1. `Collections`是一个操作`Set、List、Map`等集合的工具类
2. `Collections`中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作
3. 均为静态方法

- `reverse(List)`：反转`List`中元素的顺序
- `shuffle(List)`：对`List`集合元素进行随机排序
- `sort(List)`：根据元素的自然顺序对指定`List`集合元素按升序排序
- `sort(List, Comparator)`：根据指定的`Comparator`产生的顺序对指定`List`集合元素按升序排序
- `swap(List, int, int)`：将指定`List`集合中的`i`处元素和`j`处元素进行交换

```java
package Chapter03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsStudy {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("D");
        list.add("E");
        list.add("A");
        list.add("B");
        //1.将 list 反转
        Collections.reverse(list);
        System.out.println(list);
        //2.将 list 随机排序
        Collections.shuffle(list);
        System.out.println(list);
        //3.将 list 进行正序排序
        Collections.sort(list);
        System.out.println(list);
        //4.将 list 按照 Comparator 进行排序[倒叙]
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o2).compareTo((String) o1);
            }
        });
        System.out.println(list);
        //5.指定 list 交换 i 跟 j 位置上的元素
        Collections.swap(list, 0, 1);
        System.out.println(list);
    }
}
```

- `max(Collection)`：根据元素的自然排序返回给定集合中最大的元素
- `max(Collection, Comparator)`：根据`Comparator`指定的顺序，返回给定集合中最大的元素
- `min(Collection)`：根据元素的自然排序返回给定集合中最小的元素
- `min(Collection, Comparator)`：根据`Comparator`指定的顺序，返回给定集合中最小的元素
- `int frequency(Collection, Object)`：返回指定集合中指定元素的出现次数
- `void copy(List dest, List src)`：将`src`集合中的内容复制到`dest`集合中
- `boolean replaceAll(List list, Object oldVal, Object newVal)`：使用新值替换`List`对象的所有旧值

```java
```
