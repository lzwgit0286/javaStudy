package lambda;

/**
 * @author zhuwu.long
 * @Date 2020/8/10 21:42
 */
public class Hello {
    int k = 10000;

    Runnable r1 = () -> {
        System.out.println(k);System.out.println(this);
    };

    Runnable r2 = () -> { System.out.println(toString());
    };

    public String toString() {  return "Hello, world"; }

    public static void main(String... args) {
        Integer.sum(2,3);
        new Hello().r1.run();
        new Hello().r2.run();
    }
}
