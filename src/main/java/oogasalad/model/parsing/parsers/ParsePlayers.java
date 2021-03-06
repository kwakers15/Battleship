package oogasalad.model.parsing.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import oogasalad.model.parsing.ParsedElement;
import oogasalad.model.parsing.ParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParsePlayers extends ParsedElement {
  private final String PROPERTIES_PLAYER_LIST = "Players";
  private final String SPACE = " ";
  private final String PATH = "oogasalad.model.players.";
  private final String BAD_PLAYER = "badPlayer";
  private static final Logger LOG = LogManager.getLogger(ParsePlayers.class);



  @Override
  public void save(Properties props, String location, Object o) throws ParserException {
    LOG.info("saving Players at {}",location);
    List<String> players = (List<String>) o;
    props.put(PROPERTIES_PLAYER_LIST, String.join(SPACE, players));
  }

  @Override
  public ArrayList parse(Properties props) throws ParserException {
    LOG.info("parsing Players");
    String[] playersData = props.getProperty(PROPERTIES_PLAYER_LIST).split(SPACE);
    for(String player: playersData) {
      try {
        Class.forName(PATH+ player);
      } catch (ClassNotFoundException e) {
        throw new ParserException(exceptionMessageProperties.getProperty(BAD_PLAYER).formatted(player));
      }
    }
    return new ArrayList<>(Arrays.asList(playersData));
  }

  @Override
  public Class getParsedClass() {
    return List.class;
  }
}
