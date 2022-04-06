package Chapter03;

import java.util.ArrayList;

public class CollectionAndMapHomeWork1 {
    public static void main(String[] args) {
        ArrayList<News> arrayList = new ArrayList<News>();
        News news1 = new News("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        arrayList.add(news1);
        arrayList.add(news2);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).getTitle().substring(0, 15) + "...");
        }
    }
}

class News {
    String title;
    String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "title= '" + title + '\'';
    }
}