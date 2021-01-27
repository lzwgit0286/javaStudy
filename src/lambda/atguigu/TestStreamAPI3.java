package lambda.atguigu;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI3 {
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
    public void test2() {
        //把所有员工的工资放入list中
        List<String> e1 = employees.stream().map(Employee::getName).collect(Collectors.toList());
        employees.stream().map(Employee::getName).forEach(System.out::println);

        Set<String> e2 = employees.stream().map(Employee::getName).collect(Collectors.toSet());

        LinkedList<String> e3 =  employees.stream().map(Employee::getName).collect(Collectors.toCollection(LinkedList :: new));

        //求工资总数
        Double d1 = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(d1);

        Double d11 = employees.stream().map(Employee::getSalary).reduce(0.0, (x,y) -> x + y);
        System.out.println(d11);

        //求平均值
        Double d2 = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(d2);

        //分组
        Map<Status, List<Employee>> result = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(result);

        //分区
        Map<Boolean, List<Employee>> t = employees.stream().collect(Collectors.partitioningBy((e) -> e.getSalary() > 10000));
        System.out.println(t);
    }

    @Test
    public void test1() {
       boolean b1 = employees.stream().anyMatch( x -> x.getName().equalsIgnoreCase("张三"));
       System.out.println(b1);

       boolean b2 = employees.stream().allMatch( x -> x.getStatus().equals(Status.BUSY));
       System.out.println(b2);

       //查找工资最高的值
       Optional<Double> result = employees.stream().map(x -> x.getSalary()).max(Double::compareTo);
       System.out.println(result.get());

        Optional<Double>  d = employees.stream().map(Employee::getSalary).collect(Collectors.maxBy(Double::compareTo));
       System.out.println(d.get());

        System.out.println(employees.stream().mapToDouble(Employee::getSalary).max().getAsDouble());
    }

}