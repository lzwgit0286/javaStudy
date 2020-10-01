package socket.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main (String[] agrs) throws Exception{

            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept(); //一直监听，否则执行完毕就会退出
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String temp = null;
            String info = null;
            try {
                while ((temp = br.readLine()) != null) {
//                    info = info + temp;
//                    System.out.println("已接收到客户端连接");
                    System.out.println("服务端接收到客户端信息：" + temp + ", 当前客户端ip为：" + socket.getInetAddress().getHostAddress());
                }
            }catch (Exception e){
                e.printStackTrace();
                br.close();
                is.close();
                socket.close();
                serverSocket.close();
            }

      /*  OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("你好，服务端已接收到您的信息");
        printWriter.flush();
        printWriter.close();
        printWriter.close();
        outputStream.close();
        br.close();
        is.close();
        socket.close();*/
    }
}
