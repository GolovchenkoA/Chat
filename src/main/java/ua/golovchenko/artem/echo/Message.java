package ua.golovchenko.artem.echo;

import java.util.Date;

/**
 * Created by art on 09.04.2016.
 */
public class Message {

    private User user;
    private Date timestamp;
    private String message;

    public Message(User user, Date timestamp, String message) {
        this.user = user;
        this.timestamp = timestamp;
        this.message = message;
    }
}
