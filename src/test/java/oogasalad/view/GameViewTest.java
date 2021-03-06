package oogasalad.view;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import oogasalad.model.utilities.Coordinate;
import oogasalad.model.utilities.Piece;
import oogasalad.model.utilities.StaticPiece;
import oogasalad.model.utilities.tiles.ShipCell;
import oogasalad.model.utilities.tiles.enums.CellState;
import oogasalad.view.panes.ConfigPane;
import org.junit.jupiter.api.function.Executable;
import util.DukeApplicationTest;
import org.junit.jupiter.api.Test;

/**
 * @author Minjun Kwak
 */
public class GameViewTest extends DukeApplicationTest {

  private ConfigPane config;
  private Scene myScene;
  private int numPlayers = 3;
  private Button rightButton;
  private Button leftButton;
  private Button shopButton;
  private Button nightButton;
  private Label currentBoardLabel;
  private GameView view;
  private ResourceBundle myResources = ResourceBundle.getBundle("/languages/English");
  private Map<CellState, Color> dummyColorMap;

  @Override
  public void start(Stage stage) {
    dummyColorMap = new HashMap<>();
    dummyColorMap.put(CellState.NOT_DEFINED, Color.TRANSPARENT);
    dummyColorMap.put(CellState.WATER, Color.BLUE);
    dummyColorMap.put(CellState.WATER_HIT, Color.WHITE);
    dummyColorMap.put(CellState.SHIP_HEALTHY, Color.BLACK);
    dummyColorMap.put(CellState.SHIP_DAMAGED, Color.ORANGE);
    dummyColorMap.put(CellState.SHIP_SUNKEN, Color.RED);
    dummyColorMap.put(CellState.SHIP_HOVER, Color.GRAY);
    dummyColorMap.put(CellState.SCANNED, Color.PINK);
    dummyColorMap.put(CellState.ISLAND_HEALTHY, Color.YELLOW);
    dummyColorMap.put(CellState.ISLAND_DAMAGED, Color.GREEN);
    dummyColorMap.put(CellState.ISLAND_SUNK, Color.PURPLE);
    List<CellState[][]> firstPlayerBoards = new ArrayList<>();
    CellState[][] selfBoard = new CellState[][]{
        {CellState.WATER, CellState.WATER, CellState.SHIP_HEALTHY, CellState.SHIP_HEALTHY},
        {CellState.WATER, CellState.WATER, CellState.WATER, CellState.SHIP_HEALTHY},
        {CellState.SHIP_HEALTHY, CellState.WATER, CellState.WATER, CellState.WATER},
        {CellState.SHIP_HEALTHY, CellState.SHIP_HEALTHY, CellState.WATER, CellState.WATER}};
    CellState[][] markerBoards = new CellState[][]{
        {CellState.WATER, CellState.WATER, CellState.WATER, CellState.WATER},
        {CellState.WATER, CellState.WATER, CellState.WATER, CellState.WATER},
        {CellState.WATER, CellState.WATER, CellState.WATER, CellState.WATER},
        {CellState.WATER, CellState.WATER, CellState.WATER, CellState.WATER}};
    firstPlayerBoards.add(selfBoard);
    for (int i = 1; i < numPlayers; i++) {
      firstPlayerBoards.add(markerBoards);
    }
    List<Piece> pieces = new ArrayList<>();
    List<ShipCell> ships = new ArrayList<>();
    ships.add(new ShipCell(1, new Coordinate(0, 0), 10, "0"));
    ships.add(new ShipCell(1, new Coordinate(0, 1), 10, "1"));
    ships.add(new ShipCell(1, new Coordinate(1, 1), 10, "2"));
    List<Coordinate> relativeCoords = new ArrayList<>();
    relativeCoords.add(new Coordinate(0, 0));
    relativeCoords.add(new Coordinate(0, 1));
    relativeCoords.add(new Coordinate(1, 1));
    pieces.add(new StaticPiece(ships, relativeCoords, "0"));

    List<ShipCell> ships2 = new ArrayList<>();
    ships2.add(new ShipCell(1, new Coordinate(0, 0), 10, "0"));
    ships2.add(new ShipCell(1, new Coordinate(0, 2), 10, "1"));
    ships2.add(new ShipCell(1, new Coordinate(0, 1), 10, "2"));
    ships2.add(new ShipCell(1, new Coordinate(1, 1), 10, "3"));
    List<Coordinate> relativeCoords2 = new ArrayList<>();
    relativeCoords2.add(new Coordinate(0, 0));
    relativeCoords2.add(new Coordinate(0, 2));
    relativeCoords2.add(new Coordinate(0, 1));
    relativeCoords2.add(new Coordinate(1, 1));
    pieces.add(new StaticPiece(ships2, relativeCoords2, "1"));

    Collection<Collection<Coordinate>> pieceCoords = new ArrayList<>();
    for (Piece piece : pieces) {
      pieceCoords.add(piece.getRelativeCoords());
    }
    Map<Integer, String> idMap = new HashMap<>();
    for (int i = 0; i < numPlayers; i++) {
      idMap.put(i, "Player " + (i+1));
    }
    view = new GameView(firstPlayerBoards, pieceCoords, idMap, new ArrayList<>(), dummyColorMap, myResources);
    myScene = view.createScene();
    stage.setScene(myScene);
    stage.show();

    rightButton = lookup("#view-pane #view-center-pane #board-button-box #right-button").query();
    leftButton = lookup("#view-pane #view-center-pane #board-button-box #left-button").query();
    currentBoardLabel = lookup("#view-pane #view-center-pane #currentBoardLabel").query();
    shopButton = lookup("#configBox #view-shop-button").query();
    nightButton = lookup("#configBox #configPane #night-mode").query();
    config = lookup("#configBox #configPane").query();
  }

  @Test
  public void testSwitchBoard() {
    assertEquals(view.getCurrentBoardIndex(), 0);
    clickOn(rightButton);
    Polygon cell1 = lookup("#view-pane #view-center-pane #board-view #board-view-base #cell-view-0-0-1").query();
    clickOn(cell1);
    assertEquals(view.getCurrentBoardIndex(), 1);
    clickOn(leftButton);
  }

  @Test
  public void testLabelText() {
    assertEquals(currentBoardLabel.getText(), "Your Board");
    clickOn(rightButton);
    assertEquals(currentBoardLabel.getText(), "Your Shots Against Player 2");
  }

  @Test
  public void testShopBtn(){
    assertDoesNotThrow(() -> rightClickOn(shopButton));
  }

  @Test
  public void testNightMode(){
    config.setExpanded(true);
    clickOn(nightButton);
    String stylesheet = myScene.getStylesheets().toString();
    assertEquals(stylesheet.substring(stylesheet.length() - 20, stylesheet.length() - 1), "nightStylesheet.css");
  }

  @Test
  public void checkShotsRemaining(){
    clickOn(rightButton);
    Polygon cell1 = lookup("#view-pane #view-center-pane #board-view #board-view-base #cell-view-0-0-1").query();
    clickOn(cell1);
    assertEquals(lookup("#configBox #shots-remaining-label").query().toString(), "DynamicLabel[id=shots-remaining-label, styleClass=label]'Shots Remaining: '");
  }


}
