package lambda.atguigu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author zhuwu.long
 * @Date 2020/10/1 7:20
 */
public class LambdaTest {

    /**
     * 测试Consumer接口:
     * 消费金额打印信息
     */
    @Test
    public void test1(){
        consumerTest("lzw", (x) -> System.out.println(x + "消费了"));
    }

    private void consumerTest(String name, Consumer<String> consumer){
        consumer.accept(name);
    }

    /**
     * 测试Supplier接口
     * 产生指定个数的整数，然后放入集合
     */
    @Test
    public void test2(){
        testSupplier(new ArrayList<>(), 10, () -> new Random().nextInt(100));
    }

    private void testSupplier(List<Integer> resultList, int count, Supplier<Integer> supplier){
       for(int i=0; i < count; i++){
            resultList.add(supplier.get());
       }
        System.out.println(resultList);
    }

    /**
     *  测试Function 把字符串大小写转换
     */
    @Test
    public void test3(){
        functionTest("sssssfs", (x) -> x.toUpperCase());
    }

    private void functionTest(String source, Function<String, String> function){
        System.out.println(function.apply(source));
    }

    /**
     *  测试Predicate ,满足条件放入集合
     */
    @Test
    public void test4(){
     /*   List<Employee> sourceList = new ArrayList<>();
        Employee e1 = new Employee();
        e1.setName("sss");

        Employee e2 = new Employee();
        e2.setName("1sss");

        sourceList.add(e1);
        sourceList.add(e2);
        predicateTest(sourceList, (x) -> x.getName().startsWith("s"));*/
    }

    private void predicateTest(List<Employee> sourceList, Predicate<Employee> predicate){
        List<Employee> resultList = new ArrayList<>();
        for(Employee e : sourceList){
            if(predicate.test(e)){
                resultList.add(e);
            }
        }

        for(Employee e : resultList){
            System.out.println(e.getName());
        }
    }

    /**
     * 测试stream map和flatmap
     * map，接收Lambda，将元素转换成其他方式或提取信息。接收一个函数作为参数，该函数会应用到每个元素上，并将其映射成一个新的元素
     * flatmap：接收一个函数作为参数，将流中的每个值转换成一个流，最后把所有元素的流组装成一个新
     */
    @Test
    public void test5(){
        List<String> ss = Arrays.asList("aaa","bbb","ccc");
        //把元素全部变成大写
        ss.stream().map((x) -> x.toUpperCase())
//                    .forEach((y) -> System.out.print(y));
                    .forEach(System.out::println);

        //不使用flatmap ，把 "aaa","bbb","ccc"，转换成a,a,a,b,b,b,c,c,c.
        //流里还是流。 需要嵌套来foreach
        Stream<Stream<Character>> temp = ss.stream().map(LambdaTest::filterChars);
        temp.forEach(
                (x) -> {
                    x.forEach(System.out::println);
                }
        );

        //使用flatmap。 map和flatmap类似list的add一个list，和addAll一个list
       ss.stream().flatMap(LambdaTest::filterChars).forEach(System.out::println);
    }

    /**
     * 自然排序和自定义排序
     * 自然排序：comparable接口， 自定义排序: comparator
     */
    @Test
    public void test7(){
        List<String> ss = Arrays.asList("aaa","bbb","ddd","ccc");
        ss.stream().sorted().forEach(System.out::println);
    }

    public static Stream<Character> filterChars(String s){
        List<Character> characters = new ArrayList<>();

        for(Character c : s.toCharArray()){
            characters.add(c);
        }

        return characters.stream();
    }


}
