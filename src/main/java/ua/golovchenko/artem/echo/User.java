package ua.golovchenko.artem.echo;

/**
 * Created by art on 09.04.2016.
 */
public class User {

    private String name;

    public User(){};

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
