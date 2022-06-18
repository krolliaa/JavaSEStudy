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