package oogasalad.view.gamebuilder;

import java.io.IOException;
import java.lang.reflect.Constructor;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * An utilities class, has method for reflection used across many different parts of the game
 * builder.
 *
 * @author Luka Mdivani
 */
public class GameBuilderUtil {


  protected Object createInstance(String className, Class<?>[] parameterTypes, Object[] parameters)
      throws IOException {

    try {
      Class<?> clazz = Class.forName(className);
      Constructor<?> constructor = clazz.getConstructor(parameterTypes);
      return constructor.newInstance(parameters);
    } catch (Error | Exception e) {
      e.printStackTrace();
      throw new IOException(String.format("Class parsing failed: %s className"));
    }

  }

  protected void throwErrorWindow(String s){
    Alert alert = new Alert(AlertType.ERROR,s);
    alert.showAndWait();
  }
}
