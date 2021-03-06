package oogasalad.model.players;

import java.util.Map;
import oogasalad.model.utilities.Board;
import oogasalad.model.utilities.MarkerBoard;

public class HumanPlayer extends GenericPlayer {


  public HumanPlayer(Board board, int id, Map<String, Double> inventory, int startingGold, Map<Integer, MarkerBoard> enemyMap) {
    super(board, id, inventory, startingGold, enemyMap);
  }

  //purposefully empty - this is handled by the view
  @Override
  public void playTurn() {

  }

  @Override
  public void setupBoard(int rows, int cols) {

  }

}
