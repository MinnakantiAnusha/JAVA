import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlDemo {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://tse3.mm.bing.net/th?id=OIP.hqgXmy-r13g-63xcvlz6AwHaE7&pid=Api&P=0&h=220");


            // Display various components of the URL
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("File: " + url.getFile());

            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            // Read data from the URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            System.out.println("\nContent from the URL:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
