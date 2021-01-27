package lambda.atguigu;

/**
 * @author zhuwu.long
 * @Date 2020/10/1 7:24
 */
public class Employee {
    private int age;
    private String name;
    private Double salary;
    private Status status;

    public Employee(String name){
        this.name = name;
    }

    public Employee(){

    }

    public Employee(int age, String name, Double salary, Status status) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.status = status;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}

enum Status{
    FREE, BUSY, VACATION
}


