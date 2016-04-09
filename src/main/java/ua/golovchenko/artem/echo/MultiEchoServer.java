package ua.golovchenko.artem.echo;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by java on 09.04.2016.
 */
public class MultiEchoServer {

    static final int PORT = 4444;
    static Long clientNumber = 0L; // Счетчик подключений
    //static Collection<Message> publicMessages = new Ar;

    static public void main(String[] args) {

        try (
                ServerSocket serverSocket = new ServerSocket(PORT); // Прослушиваем порт сервера
        ) {

            // Бесконечное ожидание подключения клиента
            while (true) {
                try{
                    Socket server = serverSocket.accept();
                    //Отдельный поток для соединения с клиентом
                    Thread t = new Thread(new UserDialog(server,++clientNumber));
                    t.start();
/*                    MultiDialogServer multiDialogServer = new MultiDialogServer(server);
                    multiDialogServer.start();*/

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