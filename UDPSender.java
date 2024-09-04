import java.net.*;

public class UDPSender {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            String message = "Hello, ANUSHA!";
            InetAddress receiverAddress = InetAddress.getByName("127.0.0.1");
            int receiverPort = 12345;

            byte[] sendData = message.getBytes();
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, receiverAddress, receiverPort);

            socket.send(packet);
            System.out.println("Message sent to receiver.");

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
