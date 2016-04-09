package ua.golovchenko.artem.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by java on 09.04.2016.
 */
public class EchoClient {

    static String server = "127.0.0.1";
    static int port =4444;


    public static void main(String[] args) throws IOException {

        Socket clientSocket = null;
        try {
            clientSocket = new Socket(server,port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
                BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ){

            String userInput;
            while ((userInput = stdIn.readLine()) !=  null){
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }

        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Error: " + e);
        } finally {
            clientSocket.close();
        }
    }
}