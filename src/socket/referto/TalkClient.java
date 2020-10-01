package socket.referto;

import java.io.*;
import java.net.Socket;

public class TalkClient {
    private String host = "localhost";
    private int port = 4700;
    public void chat() throws IOException {
        Socket socket = new Socket(host,port);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//由系统标准输入设备构造BufferedReader对象，用于获取客户端的输入信息
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//由Socket对象得到输出流，并构造BufferedWriter对象
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//由Socket对象得到输入流，并构造相应的BufferedReader对象
            while(true) {
                String send = in.readLine();
                System.out.println("Client： " + send);
                out.write(send,0,send.length());
                out.newLine();
                out.flush();
                String line = reader.readLine();
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        TalkClient client = new TalkClient();
        client.chat();
    }

}
