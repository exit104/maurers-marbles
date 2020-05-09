/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.Set;

/**
 * The ScoreBasedPlaySelector class implements the PlaySelector interface to select the best play by
 * calculating a score for each possible play.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class ScoreBasedPlaySelector implements PlaySelector {

  /**
   * The player number selecting plays for.
   */
  protected final transient int playerNumber;

  /**
   * Creates a new ScoreBasedPlaySelector.
   *
   * @param playerNumber the player number selecting plays for
   */
  public ScoreBasedPlaySelector(int playerNumber) {
    this.playerNumber = playerNumber;
  }

  /**
   * Returns the score for the given marble.
   *
   * @param game the game
   * @param marble the marble to get the score for
   * @return the score for the given marble
   * @throws NullPointerException if the given game or marble is null
   */
  public int getScoreForMarble(Game game, Marble marble) {

    Preconditions.checkNotNull(game, "Null game");
    Preconditions.checkNotNull(marble, "Null marble");

    if (game.isMarbleInStartSpace(marble)) {
      /*
       * The marble is in a start space. It will require 1 move to get to the safe space and then
       * needs to go around the board.
       *
       * TODO Need to decide if we want to increase the score for a marble in a start space. Doing
       * so would create a bigger reward for getting marbles on the board. If not, we can combine
       * this if statement with the one below.
       */
      return game.getBoard().getNumberOfPerimeterSpaces()
          + game.getBoard().getNumberOfHomeSpacesPerPlayer() - 1;
    }

    if (marble.getBoardIndex() == game.getBoard().getHomeEntryBoardIndex(
        marble.getPlayerNumber()) + 1) {
      /*
       * The marble is in the space before the safe space. It will require 1 move to get to the safe
       * space and then needs to go around the board.
       */
      return game.getBoard().getNumberOfPerimeterSpaces()
          + game.getBoard().getNumberOfHomeSpacesPerPlayer() - 1;
    }

    if (game.isMarbleInHomeSpace(marble)) {
      /*
       * The marble is in a home space. Calculate how many more spaces the marble needs to move in
       * the home spaces. Note, based on the logic below, the lowest possible score a player can
       * have is 6 when all marbles are in the home spaces.
       */
      return game.getBoard().getHomeMaxBoardIndex(marble.getPlayerNumber())
          - marble.getBoardIndex();
    }

    if (marble.getPlayerNumber() == 0) {
      /*
       * Player 0's safe space starts with 0 on the board. Calculate the score by the number of
       * spaces needed to go around the board minus the marble board index.
       */
      return (game.getBoard().getNumberOfPerimeterSpaces()
          + game.getBoard().getNumberOfHomeSpacesPerPlayer() - 2) - marble.getBoardIndex();
    }

    // for the other players, need to account for the board index wrapping
    if (marble.getBoardIndex()
        > game.getBoard().getHomeEntryBoardIndex(marble.getPlayerNumber())) {
      /*
       * The marble has not crossed board index 0 yet. Count the number of spaces to get to board
       * index 0 and add the number of spaces to get to the home entry and home spaces.
       */
      return (game.getBoard().getNumberOfPerimeterSpaces() - marble.getBoardIndex())
          + game.getBoard().getHomeEntryBoardIndex(marble.getPlayerNumber())
          + game.getBoard().getNumberOfHomeSpacesPerPlayer();
    }

    /*
     * The marble is beyond board index 0. Count the number of spaces to get to the home entry and
     * home spaces.
     */
    return (game.getBoard().getHomeEntryBoardIndex(marble.getPlayerNumber())
        - marble.getBoardIndex()) + game.getBoard().getNumberOfHomeSpacesPerPlayer();

  }

  /**
   * Returns the score for the given player number executing the given play.
   *
   * @param game the game
   * @param playerNumber the player number to execute the play
   * @param play the play to execute
   * @return the score for the given player number executing the given play
   * @throws IllegalArgumentException if the given player number is invalid
   * @throws NullPointerException if the given game or play is null
   */
  public int getScoreForPlay(Game game, int playerNumber, Play play) {

    Preconditions.checkNotNull(game, "Null game");
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < game.getPlayers().size(),
        "Invalid player number");
    Preconditions.checkNotNull(play, "Null play");

    // calculate the score before the play
    int scoreBefore = 0;
    for (int i = 0; i < game.getNumberOfTeams(); i++) {
      if (i == playerNumber || i == game.getPartnerPlayerNumber(playerNumber)) {
        scoreBefore += getScoreForTeam(game, i);
      } else {
        scoreBefore -= getScoreForTeam(game, i);
      }
    }

    // create a temp game to execute the play
    Game tmpGame = new Game(game);
    tmpGame.executePlay(playerNumber, play);

    // calculate the score after the play
    int scoreAfter = 0;
    for (int i = 0; i < game.getNumberOfTeams(); i++) {
      if (i == playerNumber || i == game.getPartnerPlayerNumber(playerNumber)) {
        scoreAfter += getScoreForTeam(tmpGame, i);
      } else {
        scoreAfter -= getScoreForTeam(tmpGame, i);
      }
    }

    return scoreBefore - scoreAfter;

  }

  /**
   * Returns the score for the given player number.
   *
   * @param game the game
   * @param playerNumber the player number to get the score for
   * @return the score for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   * @throws NullPointerException if the given game is null
   */
  public int getScoreForPlayer(Game game, int playerNumber) {

    Preconditions.checkNotNull(game, "Null game");
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < game.getPlayers().size(),
        "Invalid player number");

    int score = 0;
    for (Marble marble : game.getPlayers().get(playerNumber).getMarbles()) {
      score += getScoreForMarble(game, marble);
    }

    return score;

  }

  /**
   * Returns the score for the given player number's team.
   *
   * @param game the game
   * @param playerNumber the player number to get the team score for
   * @return the score for the given player number's team
   * @throws IllegalArgumentException if the given player number is invalid
   * @throws NullPointerException if the given game is null
   */
  public int getScoreForTeam(Game game, int playerNumber) {

    Preconditions.checkNotNull(game, "Null game");
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < game.getPlayers().size(),
        "Invalid player number");

    return getScoreForPlayer(game, playerNumber)
        + getScoreForPlayer(game, game.getPartnerPlayerNumber(playerNumber));

  }

  @Override
  public Play select(Game game, Set<Play> plays) {

    Preconditions.checkNotNull(game, "Null game");
    Preconditions.checkNotNull(plays, "Null plays");
    Preconditions.checkArgument(!plays.isEmpty(), "Empty plays");

    int maxScore = Integer.MIN_VALUE;
    Play bestPlay = null;
    for (Play play : plays) {
      int score = getScoreForPlay(game, playerNumber, play);
      if (score > maxScore) {
        maxScore = score;
        bestPlay = play;
      }
    }

    return bestPlay;

  }

}
