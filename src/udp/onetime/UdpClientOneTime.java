package udp.onetime;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Zhuwu
 * @date 2020/12/24 10:51
 */
public class UdpClientOneTime {
    public static void main(String[] args) throws Exception {
        // 1. 发送数据包需要一个Socket
        DatagramSocket socket = new DatagramSocket();
        // 1.2 建立一个包
        String msg = "MP3_STOP;手机APP用户01,1234;1000,1001;";
//        InetAddress host = InetAddress.getByName("host");
        InetAddress host = InetAddress.getByName("localhost");
        System.out.println(host);
        int port = 51201;
         /*
            通过UDP发送消息，需要通过 包 来发送，--> DatagramPacket()，该方法有多种重载形式，以下使用参数列表最多的那个
            参数：
            - 要发送的 消息 的字节数组
            - 从字节数组的哪个位置开始发送
            - 发送的长度
            - 对方的IP地址
            - 对方的端口号
         */
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, host, port);
        // 2. 发送数据包
        socket.send(packet);

        //3. 获取服务器端回复
        retrieveServerResponse(socket);
        //获取服务器返回
        socket.close();
    }

    private static void retrieveServerResponse(DatagramSocket socket) throws Exception{
        byte[] data = new byte[10*1024];
        DatagramPacket packet2 = new DatagramPacket(data,data.length);
        socket.receive(packet2);
        String reply = new String(data,0, packet2.getLength());
        System.out.println("我是客户端，服务器说："+reply);
    }

}
