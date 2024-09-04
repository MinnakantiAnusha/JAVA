import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter a name: ");
            String name = reader.readLine();

            out.println(name);

            String modifiedName = in.readLine();
            System.out.println("Name in uppercase received from server: " + modifiedName);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
