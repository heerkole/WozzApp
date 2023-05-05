import javax.swing.*;
import java.awt.*;

import java.net.*;
import java.io.*;
import java.util.*;


public class Client extends JFrame
{
    public static void main(String[] args) 
    {
        try 
        {
            Socket socket = new Socket("localhost", 2509);

            DataInputStream inputFromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());


            while (true) 
            {
                Scanner scanner = new Scanner(System.in);
                System.out.print(">> ");
                String msgwrite = scanner.nextLine();

                // Send the message to the server
                outputToServer.writeUTF(msgwrite);

                String msgread = inputFromServer.readUTF();

                // Print the message
                System.out.println("Server : " + msgread);
            }
        }
        catch(IOException ex) { System.err.println(ex); }
    }
}