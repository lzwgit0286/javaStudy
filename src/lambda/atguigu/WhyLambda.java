package lambda.atguigu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhyLambda {
    List<Employee> employees = Arrays.asList(
            new Employee(25,"张三", 10000.0, Status.BUSY),
            new Employee(25,"李四", 20000.0, Status.FREE),
            new Employee(25,"王五", 15000.0, Status.VACATION),
            new Employee(25,"赵柳", 3000.0, Status.BUSY),
            new Employee(25,"铁蛋", 50000.0, Status.FREE)
    );

    /**
     * 使用原始方法，工资少于10000的员工
     */
    @Test
    public void test1(){
        List<Employee> result = filterEmployee(employees);
        for(Employee e : result){
            System.out.println(e);
        }
    }

    /**
     * 使用新方法，工资少于10000的员工， 可以过滤其他的条件，只要实现Mypredicate接口即可
     */
    @Test
    public void test2(){
        List<Employee> result = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean check(Employee employee) {
                return employee.getSalary() < 10000;
            }
        });

        for(Employee e : result){
            System.out.println(e);
        }
    }

    private List<Employee> filterEmployee(List<Employee> employees) {
        List<Employee> result = new ArrayList<>();
        for(Employee e: employees){
            if(e.getSalary() < 10000){
                result.add(e);
            }
        }
        return result;
    }

    private List<Employee> filterEmployee(List<Employee> employees, MyPredicate<Employee> predicate) {
        List<Employee> result = new ArrayList<>();
        for(Employee e: employees){
            if(predicate.check(e) == true){
                result.add(e);
            }
        }
        return result;
    }
}
