package Chapter01;

public class ControlStatement {
    /*
        控制语句没什么好说的，主要是 switch case 语句
        这里的 default 虽然放在第一位但是运行时机没有变，y = 3 进入 case 3
        y++所以y=4没有break，所以去到case 5，y++=5，break跳出，输出 y = 5
     */
    public static void main(String[] args) {
        int y = 3;
        switch (y) {
            default:
                y++;
            case 3:
                y++;
            case 5:
                y++;
                break;
        }
        System.out.println("y = " + y);
    }
}
