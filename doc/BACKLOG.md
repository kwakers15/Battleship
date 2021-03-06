# Backlog

### Specifications

Write at least ten Use Cases per team member that describe specific features each person expects to
complete — these will serve as the project's initial Backlog. Focus on features you plan to complete
during the first two Sprints (i.e., the project's highest priority features). Note, they can be
similar to those given in the assignment specification, but should include more detail specific to
your project's goals. It may help to role play or draw a diagram of how your classes collaborate to
complete each case.

### Brandon Bae

* Use case 1: The current player ends his turn. The controller will check the current win condition
  and check the current board states to check for a winner/loser
* Use case 2: Allow designer to combine multiple different win/lose conditions to the game to define rules
* Use case 3: Add special island type that can add a new win condition to the game when hit
* Use case 4: Add special island type that can remove a win condition when hit
* Use case 5: Designer can define a non square/rectangle board shape for player's to place ships on
* Use case 6: Player decides to shoot at a certain coordinate. BoardModel receives shot's lambda function
and applies function on received coordinate
* Use case 7: User fires a sensor/seeker shot at board model's specific coordinate. Use boardmodel's getState()
method to reveal cells around coordinate
* Use case 8: User can define a "Destroy X amt of Y" win condition which allows players who destroy a certain amount 
of a certain type of tile to win.
* Use case 9: User can define a "Destroy X amt of Y" loss condition which forces players who destroy a certain amount of
a certain type of tile to win
* Use case 10: User can define a "X Amount of Time" loss condition which forces players who run out of time in their turn to lose.

### Edison Ooi

* Use case 1: User clicks a cell on their shooting board to fire a shot. The result of that shot 
  is visually displayed to them.
* Use case 2: User opens the shop, buys a shot upgrade, and then clicks a cell on their shooting 
  board to fire that buffed shot
* Use case 3: User fires a shot that hits a boat, and they see their gold balance increase
* Use case 4: User fires a shot that hits a negative special island, such as a mine, and they 
  lose the game.
* Use case 5: User fires a game-winning shot and is visually shown a winning screen.
* Use case 6: In setup, user tries to place a piece in an invalid location, such as on top of 
  another piece or outside of the board. They receive a visual pop-up indicating that they 
  cannot place it there.
* Use case 7: In building, user indicates that there is a special island where, when hit, limits 
  the number of boats a player can have to X. All but X boats for each player are instantly 
  sunk.
* Use case 8: In building, user customizes their board by specifying the desired 
  rectangular dimensions and then de-selecting cells that they wish to not include in the board.
* Use case 9: In building, user customizes their ships by activating cells on a mini-board.
* Use case 10: In a 1v1 game, user makes their move and is then shown a screen that instructs 
  them to pass the computer to the opponent, who will have to press a key in order to see 
  their board.

### Matthew Knox

* Use case 1: Play a round where only turns are played
* Use case 2: Construct CPU players
* Use case 3: Construct Real Players
* Use case 4: Place a ship
* Use case 5: Move a ship
* Use case 6: Fire a shot, get gold for hitting
* Use case 7: move actors (at end of round)
* Use case 8: Construct real and CPU Players
* Use case 9: play entire simple round
* Use case 10: make purchase

### Matthew Giglio

* Use case 1: Build different AI variations (easy, medium, hard)
* Use case 2: Allow player to move pieces between rounds
* Use case 3: Use StripeAPI to simulate in game payments
* Use case 4: Allow two players to play across a server
* Use case 5: Throw "exception" when player tries to place boat at invalid coordinate
* Use case 6: Allow player to use certain items (health upgrade, scout, etc) without losing the turn
* Use case 7: Throw "exception" when player lacks enough money to make payment
* Use case 8: Remove items from player's inventory after they have used them
* Use case 9: Remove piece from player's pieces after it has been lost
* Use case 10: Have AI "invert" strategies from Battleship to Minesweeper

### Minjun Kwak

* Use case 1 - The user clicks a location on the enemy board to fire a shot
* Use case 2 - The user clicks a location on their board to place their ship
* Use case 3 - The user begins building their ship in the ship builder, but then decides to change
  the number of ships they want to place on their board
* Use case 4 - The user buys a bomb weapon to use for their next shot and fires it to an enemy board
* Use case 5 - The user scrolls through each of the other players' boards to see the shots they have
  taken against each player
* Use case 6 - The user fires a shot, but hits a mine
* Use case 7 - The user fires a shot, but hits a radar
* Use case 8 - The user destroys all enemy ships and wins the game
* Use case 9 - The user buys a finder weapon to use for their next shot and fires it to an enemy
  board
* Use case 10 - The user clicks the sidebar to see how many ships are left for each of the other
  players

### Saad Lahrichi

* Use case 1
* Use case 2
* Use case 3
* Use case 4
* Use case 5
* Use case 6
* Use case 7
* Use case 8
* Use case 9
* Use case 10

### Eric Xie

* Use case 1 - The user sets up ship pieces in the setup phase and clicks on a spot they want to put the piece on
* Use case 2 - The user goes into the ShipBuilder, builds a custom ship, and places said custom ship onto the setup board
* Use case 3 - The user tries to place a ship piece on the setup board but in an invalid spot, causing an error to be displayed
* Use case 4 - The user enters the parameters into the game engine creator, choosing win conditions and the number of certain abilities
* Use case 5 - The user enters the shop and spends the points he earned on a special shot (bomb).
* Use case 6 - The user enters the shop and tries to purchase a bomb, but he doesn't have enough points. This results in a message notifying them that they are lacking points.
* Use case 7 - The user fires a shot, but misses any targets.
* Use case 8 - The user fires a shot, but hits a target (ship)
* Use case 9 - The user fires a shot, but hits a special space (power-up debuff or buff)
* Use case 10 - The user scrolls through his boards using the buttons under them to check his own board and the shots he has against enemy player(s).

### Prajwal Jagadish

* Use case 1: A user clicks a shipblock to destroy it. The shipblock decrements its life counter and if its dead it communicates with its ship
* Use case 2: A user clicks a mine. That mine should instead hit one random ship on the attacking players side
* Use case 3: A user trys to place a ship on top of a ship, the model should send an error back up the view to make sure that the ship cannot be placed there 
* Use case 4: The player decides to heal a ship, the shipblocks must increment in their life counters. 
* Use case 5: A user hits a point multiplier island then the future amounts of points that player gets should be multplied by that factor
* Use case 6: The front end sends over a ship construct, the builder creates a json object using those specifications
* Use case 7: The controller calls the hit() method class in the model which applies the weapon specifications
* Use case 8: The parser must create a valid starting game state based off initialization files.
* Use case 9: The player api calls to buy a certain weapon. The shop checks if they have sufficient funds and if so it will subtract and activate that weapon for the player
* Use case 10: The designer gives a custom weapon certain properties, those properties should be translated into a json class file

### Luka Mdivani

* Use case 1 - user initializes a Moving object

```java
    // in grid we initialize an Piece subclass MovingPiece with reflection
// in constructor:
public interface MovingPiece() {

  public MovingPice(Coordinate[] movementPath, Coordinate[] shape) {
    this.setPath(movementPath);
    this.setStatus("Alive");
    this.initializeShape(shape);
  }
}

```

* Use case 2 - a ship is hit

```java
    // if the traget grid is is identified as a ship grid in the Grid.java
    Piece shisp=new Piece();
        ship.registerDamage(Coordinate location);
        //Inside ship:
        pubic

interface registerDamage(Coordinate location) {
      occupiedCells.remove(location);

  checkPieceStatus();
}

```

* Use case 3 - a ship is hit and it sinks

```java

public interface checkPieceStatus() {
  if(occupiedCells.size()==0)

  {
    setStatus("Dead");
  }
}

```

* Use case 4 - a MovingPiece is hit and its movement ability is disabled

```java

public interface checkPieceStatus() {
  if(occupiedCells.size()==0)

  {
    setStatus("Dead");
  }
  if(!status.equals("damaged"))

  {
    setStatus("damaged");
    disableMovementStatus();
  }
}

```

* Use case 5 - Piece has to move

```java
// Inside Piece
public interface updateLocation() {
  for(
  Coordinate cell :occupiedCells )

  {
    for (Coordinate direction : path) {
      if (inBounds()) {
        cell.x + path.x;
        cell.y + path.y;
      }
    }
  }
}

```

* Use case 6 - Piece has to move and path leads it out of bounds

```java
// Inside Piece
public interface updateLocation() {
  if(movementStatus)

  {
    for (Coordinate cell : occupiedCells) {
      for (Coordinate direction : path) {
        if (inBounds()) {
          cell.x + path.x;
          cell.y + path.y;
        } else
          () {
          disableMovementStatus();
        }
      }
    }
  }
}

```

* Use case 7 - apply weapon effect to target

```java
//in grid
selectedWeapon.fireAt(coordinate)
```

* Use case 8 - idea of how cluster weapons work

```java
//in weapon.applyEffect()
for(Coordinate effectedCell:ClusterAOE){
    if(inBoudnds){
    fireAt(
    grid.getCell(targetCell.x+effectedCell.x,targetCell.y+effectedCell.y);
    );
    }
    }
```

* Use case 9 - create a cluster bomb
```java
  // in grid we initialize an Weapon subclass ClusterWeapon with reflection
  // in constructor:
  public interface ClusterWeapon() {

  public ClusterWeapon(Coordinate[] clusterAOE) {
  this.setAOE(cluesterAOE);
  }


```
* Use case 10 - radar weapon is created
```java
  // in grid we initialize an Weapon subclass RadarWeapon with reflection
  // in constructor:
  public interface RadarWeapon() {

  public RadarWeapon(Coordinate[] clusterAOE) {
  this.setAOE(cluesterAOE);
  
  }
  

```
