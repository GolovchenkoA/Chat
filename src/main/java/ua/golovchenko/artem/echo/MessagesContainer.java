package ua.golovchenko.artem.echo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by art on 09.04.2016.
 */

public class MessagesContainer implements Subject{

    private List<Observer> observers;
    private String messages;
    private boolean changed;
    private final Object MUTEX = new Object();


    public MessagesContainer() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) throw new NullPointerException("Null Observer");

        synchronized (MUTEX){
            //добавляем в наблюдатели
            if(!observers.contains(obj)) {observers.add(obj);}
        }
    }

    @Override
    public void unregister(Observer obj) {
        synchronized (MUTEX){ observers.remove(obj);}
    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public Object getUpdate(Observer obj) {
        return null;
    }
}
