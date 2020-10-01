package lambda.atguigu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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
        List<Employee> sourceList = new ArrayList<>();
        Employee e1 = new Employee();
        e1.setName("sss");

        Employee e2 = new Employee();
        e2.setName("1sss");

        sourceList.add(e1);
        sourceList.add(e2);
        predicateTest(sourceList, (x) -> x.getName().startsWith("s"));
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

}
