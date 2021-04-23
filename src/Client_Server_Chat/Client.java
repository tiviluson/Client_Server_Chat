package Client_Server_Chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client started...");
        try {
            Socket soc = new Socket("localhost", 1102);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a string: ");
            String str = userInput.readLine();
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println(str);
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            System.out.println(in.readLine());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
