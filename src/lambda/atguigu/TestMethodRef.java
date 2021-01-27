package lambda.atguigu;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 * 语法格式：
 */
public class TestMethodRef {

    /**
     *  数组引用 Type[]::new
     */
    @Test
    public void test5(){
        Function<Integer, String[]> supplier1 = (x) -> new String[x];
        Function<Integer, String[]> supplier2 = String[]::new ;
    }

    /**
     *  构造器引用 类名::new
     */
    @Test
    public void test4(){
        Supplier<Employee> supplier1 = () -> new Employee();
        Supplier<Employee> supplier2 = Employee::new;
        Employee e1 = supplier2.get();
        System.out.println(e1);

        Function<String, Employee> function1 = (x) -> new Employee(x);
        Function<String, Employee> function2 = Employee::new; // 方法体的实现
        //传参
        Employee e = function2.apply("xxxxx");
        System.out.println(e);
    }


    /**
     * 类名::方法名 , 要求，函数式接口的第一个参数为方法的调用方，第2个参数为方法的参数
     */
    @Test
    public void test3(){
        BiPredicate<String, String> biPredicate = String::equals;
        //实质是调用了函数式接口的第一个参数"bd".equals(第2个参数)
        biPredicate.test("bd","bc");

        Function<Employee, String> t = Employee::getName;
        Function<Employee, String> t2 = x -> x.getName();
    }


    /**
     * 类名::静态方法名
     */
    @Test
    public void test2(){
        Comparator<Integer> comparable = (x, y) ->Integer.compare(x, y);
        Comparator<Integer> comparable2 = Integer::compare;
        comparable.compare(12,13);
    }


    /**
     * 实例参数名::方法名
     */
    @Test
    public void test1(){
        Consumer<String> consumer = System.out::println;
        consumer.accept("abc");

        Employee employee = new Employee();
        employee.setName("lzw");
        Supplier<String> stringSupplier = employee::getName;
        stringSupplier.get();
    }
}
