package lambda;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhuwu.long
 * @Date 2020/8/5 21:29
 */
public class LambdaTest {

    public static void main(String[] args) {
        Runnable r2 =  () -> { System.out.println("Hello Lambda!"); };
        Runnable r1 = () -> {System.out.println("Hello Lambda!");};
        t2 t2 = () -> {System.out.println("Hello Lambda!"); return 0;};

//        () -> {};

//        (int x, int y) -> x + y; 出错，必须有函数接口接收
        ttt t = (int x, int y) -> x + y;
        t.test(11,11);

        Comparator<String>
        c = ( s1,  s2) -> s1.compareToIgnoreCase(s2);

    }

    public void transferFromOldToLambda(){
        Thread oldSchool = new Thread( new Runnable () {
            @Override
            public void run() {
                System.out.println("This is from an anonymous class.");
            }
        } );

        Thread oldSchool2 = new Thread(
                () -> {System.out.println("This is from an anonymous class.");}
        );


        List<Object> list = new ArrayList<>();
        for(Object o: list) { // 外部迭代
            System.out.println(o);
        }

        list.forEach(o -> {System.out.println(o);});

        Comparator<Integer> c1 = Integer::compare;

        Comparator<Integer> c2 = (x, y) -> Integer.compare(x, y);

        c2.compare(1,15);
    }

    public void convertTest() {
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collected);
    }

    public void primaryOccurrence(String... numbers) {
        List<String> l = Arrays.asList(numbers);
        Map<Integer, Integer> r = l.stream()
                .map(e -> new Integer(e))
//                .filter(e -> Primes.isPrime(e))
                .collect( Collectors.groupingBy(p->p, Collectors.summingInt(p->1)) );
        System.out.println("primaryOccurrence result is: " + r);
    }

    public void distinctPrimary(String... numbers) {
        List<String> l = Arrays.asList(numbers);
        List<Integer> r = l.stream()
                .map(f -> new Integer(f))
//                .filter(e -> Primes.isPrime(e))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinctPrimary result is: " + r);
    }
}

interface ttt{
    int test(int x, int y);
}

interface t2{
    int t();
}
