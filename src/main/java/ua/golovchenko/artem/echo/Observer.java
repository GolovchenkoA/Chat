package ua.golovchenko.artem.echo;

/**
 * Created by art on 09.04.2016.
 * Источник: http://www.journaldev.com/1739/observer-design-pattern-in-java-example-tutorial
 */
public interface Observer {

    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(Subject sub);
}
