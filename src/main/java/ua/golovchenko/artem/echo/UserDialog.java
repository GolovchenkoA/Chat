


package ua.golovchenko.artem.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by java on 09.04.2016.
 */
public class UserDialog implements Runnable {


    private Socket socket = null;
    private Long clientNumber;

    // Пользователь в текущем потоке
    private User user;
    private Message userMessage;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Конеструктор
    public UserDialog(Socket socket, Long clientNumber){this.socket = socket; this.clientNumber = clientNumber;}


    public void run(){
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {

            //++MultiEchoServer.clientNumber; // увеличиваем счетчик соединений

            System.out.println("Server accept connection from (client port)" + socket.getPort() + " ConnectionsCount = " + MultiEchoServer.clientNumber + "; Add Client with number: " + clientNumber);
            //Приветствие
            out.write("Hello. Enter your name");
            // Создаем пользователя
            String userName = in.readLine();
            user = new User(userName);

            //Диалог пользователя
            String serverIn;
            while ((serverIn = in.readLine()) != null) {

                
                Calendar calendar = Calendar.getInstance();
                Date date = calendar.getTime();
                userMessage = new Message(user,date,serverIn);
                //out.println(serverIn);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            System.out.println("Server close dialog from (client port)" + socket.getPort() + " ConnectionsCount = " + MultiEchoServer.clientNumber  + "; Disconnect Client with number: " + clientNumber);
        } finally {
            try {
                socket.close();
                --MultiEchoServer.clientNumber;
                System.out.println("Server close dialog from (client port)" + socket.getPort() + " ConnectionsCount = " + MultiEchoServer.clientNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}