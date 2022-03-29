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