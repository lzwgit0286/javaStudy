package udp.onetime;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Zhuwu
 * @date 2020/12/24 10:53
 */
public class UdpServer {
    public static void main(String[] args) throws Exception{
        // 1. 接收也需要一个Socket，并且要开启接收的端口
        DatagramSocket socket = new DatagramSocket(51201);
        // 需要一个字节数组来接收数据
        byte[] buffer = new byte[1024];
        // 1.2 封装数据包
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        // 2. 接收数据，阻塞式接收：一直处于监听状态
        socket.receive(packet);
        // 关闭套接字
        socket.close();
        // 输出一下
        System.out.println(packet.getAddress().getHostAddress());
        // trim()：为了去除多余的空格
        System.out.println(new String(packet.getData()).trim());
    }
}
