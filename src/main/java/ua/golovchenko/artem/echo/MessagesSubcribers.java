package ua.golovchenko.artem.echo;

/**
 * Created by art on 09.04.2016.
 */
public class MessagesSubcribers implements Observer {

    private String name;
    private Subject topic;

    public MessagesSubcribers(String name) {
        this.name = name;
    }

    @Override
    public void update() {

    }

    @Override
    public void setSubject(Subject sub) {

    }
}
