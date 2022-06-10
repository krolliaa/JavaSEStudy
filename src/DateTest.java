import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Date date = new Date();
        System.out.println(date.toString());//获取当前时间的年月日时分秒[英文]
        System.out.println(date.getTime());//获取当前时间点的毫秒数 1970年1月1日0时0分0秒到现在

    }
}
