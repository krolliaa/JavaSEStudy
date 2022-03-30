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

`ArrayList`源码剖析【重点】：

`ArrayList`维护了一个`Object`类型的数组也就是什么类型都可以存放到`ArrayList`中。

- 对象在序列化的时候，`transient`修饰的属性不会被序列化
- 当创建对象的时候，如果使用的是无参构造器那么初始化容量`elementData`为`0`，在`JDK7`中为`10`
- 当添加元素的时候，会判断是否要自动扩容，如果需要扩容则调用`grow`方法，如果不需要则直接将元素添加到相应位置即可
- 当创建`ArrayList`对象时，如果使用的是无参构造器，则初始`elementData`容量为0，第1次添加，则扩容`elementData`为10，如需要再次扩容，则扩容`elementData`为1.5倍
- 如果使用的是有参构造器则初始化容量就是设置的那个容量，并且如果需要扩容的时候，会将其扩容到`1.5`倍`elementData`的容量，这点与无参构造器构造的`ArrayList`不同，它的第一次扩容是先扩容到`10`

