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