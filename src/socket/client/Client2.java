package socket.client;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 {
    public static void main (String[] agrs) throws Exception{
        Socket socket = new Socket("localhost",8888);
        OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("你好，我是客户端22222222222222222222222f");
//        printWriter.flush();
        printWriter.flush();
        socket.shutdownOutput();//关闭输出流
        Thread.sleep(2000);
        printWriter.close();

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
