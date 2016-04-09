


package ua.golovchenko.artem.echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by java on 09.04.2016.
 */
public class MultiDialogServer extends Thread {


    private Socket socket = null;
    public MultiDialogServer(Socket socket){this.socket = socket;}


    public void run(){
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {

            System.out.println("Server accept connection from" + socket.getPort());

            String serverIn;
            while ((serverIn = in.readLine()) != null) {
                out.println(serverIn);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println("Server close dialog from " + socket.getPort());
        }

    }
}