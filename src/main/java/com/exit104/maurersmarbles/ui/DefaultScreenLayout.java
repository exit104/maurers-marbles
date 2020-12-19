/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.ui;

import com.google.common.base.Preconditions;

import com.exit104.maurersmarbles.Game;
import com.exit104.maurersmarbles.Rectangle;

import java.util.Map;
import java.util.TreeMap;

/**
 * The DefaultScreenLayout class implements the ScreenLayout interface to provide the default layout
 * for the game components on the screen.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class DefaultScreenLayout implements ScreenLayout {

  /**
   * The number of players in the game.
   */
  protected transient int numberOfPlayers;
  /**
   * The map that contains the bounds for each player. The key into the map is the player number and
   * the value is the bounds.
   */
  protected transient Map<Integer, Rectangle> playerNumberToBoundsMap = new TreeMap<>();
  /**
   * The bounds of the game board on the screen.
   */
  protected transient Rectangle boardRectangle;

  /**
   * Creates a new DefaultScreenLayout.
   *
   * @param numberOfPlayers the number of players in the game
   * @throws IllegalArgumentException if the given number of players is invalid
   */
  public DefaultScreenLayout(int numberOfPlayers) {
    Preconditions.checkArgument(Game.VALID_NUMBER_OF_PLAYERS.contains(numberOfPlayers),
        "Invalid number of players");
    this.numberOfPlayers = numberOfPlayers;
    update(1.0f, 1.0f);
  }

  @Override
  public Rectangle getBoundsForBoard() {
    return boardRectangle;
  }

  @Override
  public Rectangle getBoundsForPlayer(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < numberOfPlayers,
        "Invalid player number");
    return playerNumberToBoundsMap.get(playerNumber);
  }

  @Override
  public final void update(float width, float height) {

    playerNumberToBoundsMap.clear();

    if (width >= height) {

      // landscape
      boardRectangle = new Rectangle(0, 0, height, height);

      // player 0
      playerNumberToBoundsMap.put(0, new Rectangle(height, height / 3.0f, width - height,
          height / 3.0f));
      //player 1-N
      for (int playerNumber = 1; playerNumber < numberOfPlayers; playerNumber++) {
        playerNumberToBoundsMap.put(playerNumber, new Rectangle(
            height + (width - height) / (numberOfPlayers - 1) * (playerNumber - 1), 0,
            (width - height) / (numberOfPlayers - 1), height / 3.0f));
      }

    } else {

      // portrait
      boardRectangle = new Rectangle(0, (height - width) / 2.0f, width, width);

      // player 0
      playerNumberToBoundsMap.put(0, new Rectangle(0, width + ((height - width) / 2.0f), width,
          (height - width) / 2.0f));
      //player 1-N
      for (int playerNumber = 1; playerNumber < numberOfPlayers; playerNumber++) {
        playerNumberToBoundsMap.put(playerNumber, new Rectangle(
            width / (numberOfPlayers - 1) * (playerNumber - 1), 0,
            width / (numberOfPlayers - 1), (height - width) / 2.0f));
      }

    }

  }

}
