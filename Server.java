import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

import java.net.*;
import java.io.*;
import java.util.*;


public class Server extends JFrame
{
    public static void main(String[] args) 
    {
        try {

            ServerSocket serverSocket = new ServerSocket(2509);
            System.out.println("[!] Server ONLINE con porta 2509");


            Socket socket = serverSocket.accept();
            System.out.println("[!] Client connesso");


            // Create data input and output streams
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());


            while (true) 
            {
                Scanner scanner =new Scanner(System.in);

                String msgread = inputFromClient.readUTF();

                if (msgread.equals("exit")) 
                { 
                    outputToClient.writeUTF("[!] Client DISCONNESSO");
                    break; 
                }
                else 
                {
                    // Print the message
                    System.out.println("Client : " + msgread);

                    System.out.print(">> ");
                    String msgwrite = scanner.nextLine();

                    // Send the message to the server
                    outputToClient.writeUTF(msgwrite);
                }
            }
        }
        catch(IOException ex) { System.err.println(ex); }
    }
}
