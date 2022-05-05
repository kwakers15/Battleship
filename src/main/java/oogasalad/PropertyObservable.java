package oogasalad;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Creates foundation for Observer design pattern by defining a superclass that sets up
 * communication between some object and its observer.
 *
 * @author Minjun Kwak
 */
public class PropertyObservable {

  private PropertyChangeSupport pcs;

  /**
   * Constructor for the PropertyObservable, creates a new PropertyChangeSupport object which is
   * used to allow communication between two objects.
   */
  public PropertyObservable() {
    pcs = new PropertyChangeSupport(this);
  }

  /**
   * Adds an observer to this object by adding a PropertyChangeListener to this object's
   * PropertyChangeSupport
   *
   * @param listener the observer that should be added to this object to listen for changes from
   *                 this object
   */
  public void addObserver(PropertyChangeListener listener) {
    pcs.addPropertyChangeListener(listener);
  }

  /**
   * Notifies this object's observer of a change by firing a PropertyChangeEvent using the
   * PropertyChangeSupport to do so
   *
   * @param name the name of the property that should be changed (used as corresponding method for
   *             the observer to call in our case)
   * @param data the new data that should be sent to the observer to go along with the
   *             PropertyChangeEvent
   */
  public void notifyObserver(String name, Object data) {
    pcs.firePropertyChange(name, null, data);
  }
}
