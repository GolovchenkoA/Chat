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
        List<Observer> observerLocal = null;
        //synchronization is used to make sure any observer registered after message is received is not notified
        synchronized (MUTEX){

            // Если changed = false прекращаем метод и возвращаем управление
            if(!changed)
                return;

            // если changed = true;
            observerLocal = new ArrayList<>(this.observers);
            changed = false;
        }
       // У всех подписчиков вызываем update
        for(Observer observer : observerLocal){
            observer.update();
        }



    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.messages;
    }

    // добавляем новое сообщение
    public void postMessage(User user,String messages){
        System.out.println("Message posted by " + user.getName() + ": " + messages);
        this.messages = messages;
        this.changed = true;
        //notifyObservers();
    }
}
