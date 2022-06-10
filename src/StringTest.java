import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        String s3 = "abcdef";
        String s4 = "abc" + "def";
        System.out.println(s3 == s4);
        String s5 = s1 + s2;
        System.out.println(s3 == s5);
        System.out.println(s4 == s5);
        String s6 = "abc" + s2;
        System.out.println(s3 == s6);
        System.out.println(s4 == s6);
        System.out.println(s5 == s6);
        String s7 = s1 + "def";
        System.out.println(s3 == s7);
        System.out.println(s4 == s7);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);
        System.out.println(s3 == s7.intern());

        String s8 = "  nu  ll  ";
        System.out.println(s8.trim());

        String s9 = "A";
        String s10 = "A";
        System.out.println(s10.compareTo(s9));

        String s11 = "123456";
        String s12 = "56";
        System.out.println(s11.indexOf(s12, 4));

        String s13 = "ABC";
        System.out.println(s13.replace('B', 'E'));
        System.out.println(s13.replace("BC", "E"));

        String s14 = "ABC,123,def,456,ghi,789";
        System.out.println(Arrays.toString(s14.split(",")));

        byte[] bytes = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(bytes));
        String s15 = "happy";
        System.out.println(s15.getBytes());

        final String s16 = "abc";
        String s17 = "abcdef";
        String s18 = s16 + "def";
        System.out.println(s17 == s18);//true

        StringBuffer stringBuffer = new StringBuffer("abc132");
        String s19 = stringBuffer.substring(2, 6);
        System.out.println(s19);
    }
}
