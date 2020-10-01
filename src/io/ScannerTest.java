package io;

import java.util.Scanner;

/**
 * Scanner是输入
 */

public class ScannerTest {

    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        String text = null;
        //**** scanner.hasNextLine() 堵塞，等待输入
        while (scanner.hasNextLine()){
//        while (true){
            text = scanner.nextLine();
            System.out.println("out put : " + text);
            if("exit".equalsIgnoreCase(text)){
                break;
            }
        }
    }

}
