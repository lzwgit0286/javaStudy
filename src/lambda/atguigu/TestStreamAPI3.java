package lambda.atguigu;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhuwu.long
 * @Date 2020/10/15 8:06
 * 终止操作： 规约和收集
 */
public class TestStreamAPI3 {

    List<Employee> employees = Arrays.asList(
            new Employee(25,"张三", 10000.0, Status.BUSY),
            new Employee(25,"李四", 20000.0, Status.FREE),
            new Employee(25,"王五", 15000.0, Status.VACATION),
            new Employee(25,"赵柳", 3000.0, Status.BUSY),
            new Employee(25,"铁蛋", 50000.0, Status.FREE)
    );

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
