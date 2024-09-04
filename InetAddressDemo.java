
    import java.net.InetAddress;
import java.net.UnknownHostException;

    public class InetAddressDemo {
        public static void main(String[] args) {
            try {
                // Get the local host InetAddress instance
                InetAddress localHost = InetAddress.getLocalHost();
                System.out.println("Local Host:");
                System.out.println("Host Name: " + localHost.getHostName());
                System.out.println("IP Address: " + localHost.getHostAddress());

                // Get InetAddress instance for a specific host
                String host = "www.google.com";
                InetAddress googleAddress = InetAddress.getByName(host);
                System.out.println("\nGoogle Host:");
                System.out.println("Host Name: " + googleAddress.getHostName());
                System.out.println("IP Address: " + googleAddress.getHostAddress());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }


