package lambda.atguigu;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhuwu.long
 * @Date 2020/10/15 8:06
 * 终止操作： 规约和收集
 */
public class TestStreamAPI2 {

    List<Employee> employees = Arrays.asList(
            new Employee(25,"张三", 10000.0, Status.BUSY),
            new Employee(25,"李四", 20000.0, Status.FREE),
            new Employee(23,"王五", 15000.0, Status.VACATION),
            new Employee(31,"赵柳", 3000.0, Status.BUSY),
            new Employee(25,"赵柳", 3000.0, Status.BUSY),
            new Employee(25,"铁蛋", 50000.0, Status.FREE),
            new Employee(25,"赵柳", 3000.0, Status.BUSY)
    );


    @Test
    public void test6() {
        List<String> lis = Arrays.asList("fff", "bbb", "ccc", "ddd");
        //自然排序
        lis.stream().sorted().forEach(System.out::println);

        //定制排序 按照年龄来排序
        employees.stream().sorted((x,y) -> x.getName().compareTo(y.getName())).forEach(System.out::println);
        employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);


        //employees.stream().map(Employee::getAge).sum(); //error, 为什么？ sum方法是IntStream等提供的，而不是Stream提供的
        int totalAge1 = employees.stream().mapToInt(Employee::getAge).sum();
        employees.stream().mapToInt(Employee::getAge).average();
        Stream<Integer> e2  = employees.stream().map(Employee::getAge);
               int totalAge = employees.stream().map(Employee::getAge).reduce(0, (x,y) -> x + y);
        System.out.println(totalAge);
    }

    @Test
    public void test5(){
            List<String> lis = Arrays.asList("aaa","bbb", "ccc","ddd");
            lis.stream().map(String::toUpperCase).forEach(System.out::println);
            lis.stream().map(x -> x.toUpperCase()).forEach(System.out::println);

            // 把aaa拆分成a,a,a 。。，原始方式迭代
          /*  Stream<Stream<Character>> streamStream = lis.stream().map(TestStreamAPI2::chai);
            streamStream.forEach((x) -> {
                x.forEach(System.out::println);
            });*/

            //使用flatMap
            Stream<Character> streamStream2 = lis.stream().flatMap(TestStreamAPI2::chai);
                streamStream2.forEach(
                  System.out::println
                );
    }

    private static Stream<Character> chai(String str){
        List<Character> list = new ArrayList<>();
        for(Character ch : str.toCharArray()){
            list.add(ch);
        }
        return  list.stream();
    }
    @Test
    public void test11(){
        Stream<Employee> stream = employees.stream().filter((x)
                -> {
                        System.out.println("执行过滤");
                        return x.getSalary() > 5000;
                    }
                );
        Employee employee = new Employee();
        //不执行下面的终止操作，上面的"执行过滤不会打印"
        stream.forEach(System.out::println);
    }

    @Test
    public void test1(){
        List<Employee>  es = employees.stream().filter(e -> e.getAge() > 20).collect(Collectors.toList());
        //计算记录条数
        long count = employees.stream().count();
        System.out.println(count);

        //工资平均值
        OptionalDouble  d = employees.stream().mapToDouble(Employee::getSalary).average();
        System.out.println(d.getAsDouble());
    }
}
