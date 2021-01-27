package udp.manytime;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Zhuwu
 * @date 2020/12/24 11:23
 */
public class UdpServerAllOnline {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(51201);
        while (true) {
            // 准备接收数据包裹
            byte[] buffer = new byte[1024];
            // 用来接收数据
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            // 接收包裹，阻塞时接收
            socket.receive(packet);
            // 接收到的数据
            String receiveData = new String(packet.getData()).trim();
            // 打印到控制台
            System.out.println(receiveData);
            // 什么时候退出
            if ("bye".equals(receiveData)) {
                break;
            }

            sentMsgToClient(packet);
        }

        // 关闭
        socket.close();
    }

    private static void sentMsgToClient(DatagramPacket packet){
        InetAddress address= packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = "客户端登陆成功，欢迎使用服务器".getBytes();
        //创建DatagramPacket
        DatagramPacket packet2 = new DatagramPacket(data2,data2.length,address,port);
        try {
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet2);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
