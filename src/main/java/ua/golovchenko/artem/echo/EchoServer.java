package ua.golovchenko.artem.echo;

/**
 * Created by art on 09.04.2016.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    static int port = 4444;

    static public void main(String[] args){

        try(
                ServerSocket serverSocket = new ServerSocket(port);
                Socket server = serverSocket.accept();
                BufferedReader in = new BufferedReader( new InputStreamReader(server.getInputStream()));
                PrintWriter out = new PrintWriter(server.getOutputStream(),true);
        )
        {

            String serverIn;
            System.out.println("Start Server");
            while ((serverIn = in.readLine()) !=null){
                out.println(serverIn);
            }

            System.out.println("Server Stop");

        }catch (Exception e){
            System.out.println(e);
        }



    }

}
