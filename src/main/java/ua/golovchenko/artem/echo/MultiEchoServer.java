package ua.golovchenko.artem.echo;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by java on 09.04.2016.
 */
public class MultiEchoServer {

    static int port = 4444;

    static public void main(String[] args) {

        try (
                ServerSocket serverSocket = new ServerSocket(port);
        ) {

            while (true) {
                try(Socket server = serverSocket.accept()) {

                    MultiDialogServer multiDialogServer = new MultiDialogServer(server);
                    multiDialogServer.start();

                }catch (Exception e) {
                    System.out.println(e);
                }
            }
            // Catch serverSocket
        } catch (Exception e) {
            System.out.println("Server Stop");
            System.out.println(e);
        }
    }

}