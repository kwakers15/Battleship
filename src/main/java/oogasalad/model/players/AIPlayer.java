package oogasalad.model.players;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import oogasalad.model.utilities.Board;
import oogasalad.model.utilities.Coordinate;
import oogasalad.model.utilities.MarkerBoard;

/**
 * This class demonstrates a simple AI Player.
 * When an AIPlayer is asked to play a turn, it gets a random player and a random coordinate.
 * Note that this AI Player is rather dumb.
 * When selecting a random player, it may select itself.
 * When selecting a random coordinate, it is assuming the valid coordinates of another players's board is the same as its own board.
 * Extensions for this class are one of the following:
 *
 * 1. Make this class an abstract class, implementing subclasses with different levels of intelligence.
 * 2. Add a parameter that dictates the intelligence level of the AI.
 *
 * I recommend using option 1, as different levels of intelligence will 'remember' different things.
 * For example, a dumb AI has no reason to remember where it has fired,
 * whereas a smart AI does.
 * This is easy to implement if different subclasses have different instance variables.
 */
public class AIPlayer extends GenericPlayer{

  private List<Player> players;

  public AIPlayer(Board board, int id, Map<String, Double> inventory, int startingGold, Map<Integer, MarkerBoard> enemyMap) {
    super(board, id, inventory, startingGold, enemyMap);
    players = new ArrayList<>();
  }

  public void addPlayers(List<Player> allPlayers) {
    for(Player p: allPlayers) {
      if(!this.equals(p)) {
        players.add(p);
      }
    }
  }

  @Override
  public void playTurn() {
    Player enemy = getRandomPlayer();
    Coordinate location = getRandomCoordinate();
//    enemy.strike(location);
  }

  @Override
  public void setupBoard(int rows, int cols) {

  }

  private Player getRandomPlayer() {
    Random rand = new Random();
    int randomIndex = rand.nextInt(players.size());
    return players.get(randomIndex);
  }

  private Coordinate getRandomCoordinate() {
    Random rand = new Random();
    List<Coordinate> allCoordinates = getValidCoordinates();
    int randomIndex = rand.nextInt(allCoordinates.size());
    return allCoordinates.get(randomIndex);
  }
}
