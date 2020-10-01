package io;

import vo.Employee;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 写文件用PrintWriter
 * 读文件用Scanner
 */
public class TextFileTest {
    public static void main(String[] agrs) throws Exception{
        System.out.println(System.getProperty("user.dir"));
//        new FileInputStream("c:/afadf/afaf");  文件不存在异常
        //通过printWriter写文件
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("long1", 20000, 2021,12,12);
        employees[1] = new Employee("long2", 30000, 2022,12,12);
        employees[2] = new Employee("long3", 40000, 2023,12,12);

        //使用try，会在结束时，自动刷新内存. 注意try后没有; 只有{} ， 问题： 如果不用绝对路径，文件保存去哪里了？ 项目的根目录 System.getProperty("user.dir")
        //PrintWriter -- 打印机
        try(PrintWriter printWriter = new PrintWriter("myEmployee.dat","utf-8") ) {
            for (int i = 0; i < employees.length; i++) {
                writeData(employees[i], printWriter);
            }
        }

        //通过Scanner读文件 --- 扫描器
        try(Scanner scanner = new Scanner(new FileInputStream("myEmployee.dat"), "utf-8")){
            readData(scanner);
        }

    }

    private static void readData(Scanner scanner) {
//        System.out.println(scanner.nextInt());
        List<Employee> employeeList = new ArrayList<>();
        while (scanner.hasNextLine()){
            String employeeString = scanner.nextLine();
            String[] token = employeeString.split("\\|");
            String name = token[0];
            Double salary = Double.parseDouble(token[1]);
            LocalDate localDate = LocalDate.parse(token[2]);
            Employee e = new Employee(name, salary, localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth());
            employeeList.add(e);
        }

        for(Employee e : employeeList){
            System.out.println(e);
        }
    }

    private static void writeData(Employee employee,PrintWriter printWriter) throws Exception{
        //使用write也可以，但是不会换行
        printWriter.println(employee.getName() + "|"+ employee.getSalary() + "|"+ employee.getHireDay() );
        //不加close，数据会一直在内存，不会写到文件中
    }


}
