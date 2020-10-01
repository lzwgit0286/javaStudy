package socket.client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main (String[] agrs) throws Exception{
        Socket socket = new Socket("localhost",8888);
        OutputStream outputStream;
        while (true) {
            outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            //因为服务器端接受数据时使用的readLine()方法必须要接收到一个换行符才能读取一行
//            printWriter.print("你好，我是客户端1");  // **** 即使flush，信息也不会发送到服务器端，
            printWriter.println("你好，我是客户端1， 语句1"); // flush，信息会发送到服务器端
            printWriter.flush();  // 不刷新不会发送信息到服务器端

            printWriter.println("你好，我是客户端1， 语句2"); // flush，信息会发送到服务器端
            printWriter.flush();
            printWriter.println();
            Thread.sleep(2000);
//            socket.shutdownOutput();
//            outputStream.close();
        }
//        printWriter.flush();
//        printWriter.close();
//        socket.shutdownOutput();//关闭输出流
//        socket.close();

    /*    printWriter.print("你好，我是客户端2");
        printWriter.flush();
//        printWriter.close();
        socket.shutdownOutput();//关闭输出流*/
/*
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String temp = null;
        String info = null;
        while((temp = bufferedReader.readLine() ) != null){
            info = info + temp;
            System.out.println("客户端接收服务端发送信息："+info);
        }

        bufferedReader.close();
        inputStream.close();
        printWriter.close();
        outputStream.close();
        socket.close();*/
    }
}
