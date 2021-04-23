package Client_Server_Chat;

import java.io.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {

    public static void WebpageDownloader(String address) {
        try {
            // Create URL object
            URL url = new URL("https://" + address);
            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));

            // Enter filename in which you want to download
            BufferedWriter writer = new BufferedWriter(new FileWriter("Webpage.html"));

            // read each line from stream till end
            String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }

            readr.close();
            writer.close();
            System.out.println("Successfully Downloaded.");
        }

        // Exceptions
        catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        }
        catch (IOException ie) {
            System.out.println("IOException raised");
        }
    }

    public static void main(String[] args) {
        try {
                // Get hostname by textual representation of IP address
                InetAddress address;
                address = InetAddress.getByName(args[0]);
                // Get hostname by a byte array containing the IP address
                // byte[] ipAddr = new byte[]{127, 0, 0, 1};
                // address = InetAddress.getByAddress(ipAddr);
                // Get the host name
                String hostname = address.getHostName();
                // Get canonical host name
                String hostnameCanonical = address.getCanonicalHostName();
                System.out.println("address: " +  address);
                System.out.println("hostname: " + hostname);
                System.out.println("hostnameCanonical:" + hostnameCanonical);
                WebpageDownloader(args[0]);
        } catch (UnknownHostException e) {
            System.out.println("Error");
        }

//        try {
//
//            // Create URL object
//            URL url = new URL(args[0]);
//            BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));
//
//            // Enter filename in which you want to download
//            BufferedWriter writer = new BufferedWriter(new FileWriter("Webpage.html"));
//
//            // read each line from stream till end
//            String line;
//            while ((line = readr.readLine()) != null) {
//                writer.write(line);
//            }
//
//            readr.close();
//            writer.close();
//            System.out.println("Successfully Downloaded.");
//        }
//
//        // Exceptions
//        catch (MalformedURLException mue) {
//            System.out.println("Malformed URL Exception raised");
//        }
//        catch (IOException ie) {
//            System.out.println("IOException raised");
//        }
    }
}
