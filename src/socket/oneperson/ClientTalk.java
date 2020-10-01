package socket.oneperson;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTalk {
    public static void main(String[] agrs) throws Exception{
        Socket socket = new Socket("localhost",4700);
        BufferedReader reader = null;
        BufferedWriter out = null;
        Scanner scanner = null;
        try {
            reader = new BufferedReader((new InputStreamReader(socket.getInputStream())));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            PrintWriter printWriter = new PrintWriter(out);
            scanner = new Scanner(System.in);
            while (true) {
                String text = scanner.nextLine();
                //使用BufferedWriter
               /* out.write(text);
                //不加newLine不会发信息到服务器端, 因为服务器端使用的是readline
                out.newLine();*/
                //使用printWriter
                printWriter.println(text);
                out.flush();
                String serverText = reader.readLine();
                System.out.println("服务器端： " + serverText);
                if("exit".equalsIgnoreCase(text)){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            out.close();
            reader.close();
            socket.close();
        }

    }
}
