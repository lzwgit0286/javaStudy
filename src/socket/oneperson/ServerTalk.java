package socket.oneperson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTalk {
    public static void main(String[] agrs) throws Exception{
        ServerSocket serverSocket = new ServerSocket(4700);
        Socket clientSocket = serverSocket.accept();
        BufferedReader  br = new BufferedReader((new InputStreamReader(clientSocket.getInputStream())));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        String clientMsg = br.readLine();
        Scanner scanner = new Scanner(System.in);
        String responseText = null;
        while (clientMsg != null){
            System.out.println(" 客户端: " + clientMsg);
            responseText = scanner.nextLine();
            bw.write(responseText);
            bw.newLine();
            bw.flush();
            if(clientMsg.equalsIgnoreCase("exit")){
                break;
            }

            clientMsg = br.readLine();
        }

        bw.close();
        br.close();
        clientSocket.close();
        serverSocket.close();
    }
}
