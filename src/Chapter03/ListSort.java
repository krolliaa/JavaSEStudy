package Chapter03;

import java.util.ArrayList;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Book> list = new ArrayList();
        list.add(new Book("三国演义", "罗贯中", 10.1));
        list.add(new Book("小李飞刀", "古龙", 5.1));
        list.add(new Book("红楼梦", "曹雪芹", 34.6));
        for (Book book : list) System.out.println("排序前：" + book.toString());
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).getPrice() > list.get(j + 1).getPrice()) {
                    Book tempBook = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tempBook);
                }
            }
        }
        for (Book book : list) System.out.println("排序后：" + book.toString());
    }
}
