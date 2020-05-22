/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Board class provides the methods for a game board.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
public class Board {

  /**
   * The number of home spaces on the board for each player.
   */
  protected static final int NUMBER_OF_HOME_SPACES_PER_PLAYER = 4;
  /**
   * The number of perimeter spaces on the board for each player.
   */
  protected static final int NUMBER_OF_PERIMETER_SPACES_PER_PLAYER = 14;
  /**
   * The number of start spaces on the board for each player.
   */
  protected static final int NUMBER_OF_START_SPACES_PER_PLAYER = 4;
  /**
   * The number of perimeter spaces on the board.
   */
  protected final transient int numberOfPerimeterSpaces;
  /**
   * The number of playable spaces on the board.
   */
  protected final transient int numberOfPlayableSpaces;
  /**
   * The number of players.
   */
  protected final transient int numberOfPlayers;
  /**
   * The list of home board indexes. The index in the list is the player number the the value is the
   * list of board indexes for that player.
   */
  protected final transient List<List<Integer>> homeBoardIndexes;
  /**
   * The list of home entry board indexes. The index in the list is the player number the the value
   * is the board index for that player.
   */
  protected final transient List<Integer> homeEntryBoardIndexes;
  /**
   * The list of perimeter board indexes.
   */
  protected final transient List<Integer> perimeterBoardIndexes;
  /**
   * The list of safe board indexes. The index in the list is the player number the the value is the
   * board index for that player.
   */
  protected final transient List<Integer> safeBoardIndexes;
  /**
   * The list of start board indexes. The index in the list is the player number the the value is
   * the list of board indexes for that player.
   */
  protected final transient List<List<Integer>> startBoardIndexes;

  /**
   * Creates a new Board using the given number of players.
   *
   * @param numberOfPlayers the number of players (4, 6, 8, 10, or 12)
   * @throws IllegalArgumentException if the given number of players is invalid
   */
  @SuppressWarnings("PMD.UselessParentheses")
  public Board(int numberOfPlayers) {

    Preconditions.checkArgument(Game.VALID_NUMBER_OF_PLAYERS.contains(numberOfPlayers),
        "Invalid number of players");

    this.numberOfPlayers = numberOfPlayers;

    // calculate the number of perimeter spaces
    numberOfPerimeterSpaces = NUMBER_OF_PERIMETER_SPACES_PER_PLAYER * numberOfPlayers;

    // generate the list of perimeter board indexes
    List<Integer> boardIndexes = new ArrayList<>();
    for (int i = 0; i < numberOfPerimeterSpaces; i++) {
      boardIndexes.add(i);
    }
    perimeterBoardIndexes = Collections.unmodifiableList(boardIndexes)

    // calculate the number of playable spaces
    numberOfPlayableSpaces = numberOfPerimeterSpaces
        + (NUMBER_OF_START_SPACES_PER_PLAYER * numberOfPlayers)
        + (NUMBER_OF_HOME_SPACES_PER_PLAYER * numberOfPlayers);

    // calculate the home entry board indexes
    boardIndexes = new ArrayList<>();
    boardIndexes.add(numberOfPerimeterSpaces - 2);
    for (int i = 1; i < numberOfPlayers; i++) {
      boardIndexes.add((NUMBER_OF_PERIMETER_SPACES_PER_PLAYER * i) - 2);
    }
    homeEntryBoardIndexes = Collections.unmodifiableList(boardIndexes);

    // calculate the home board indexes
    List<List<Integer>> playerBoardIndexes = new ArrayList<>();
    for (int playerNumber = 0; playerNumber < numberOfPlayers; playerNumber++) {
      boardIndexes = new ArrayList<>();
      for (int i = 0; i < NUMBER_OF_HOME_SPACES_PER_PLAYER; i++) {
        boardIndexes.add(numberOfPerimeterSpaces
            + (NUMBER_OF_HOME_SPACES_PER_PLAYER * playerNumber) + i);
      }
      playerBoardIndexes.add(Collections.unmodifiableList(boardIndexes));
    }
    homeBoardIndexes = Collections.unmodifiableList(playerBoardIndexes);

    // calculate the start board indexes
    playerBoardIndexes = new ArrayList<>();
    for (int playerNumber = 0; playerNumber < numberOfPlayers; playerNumber++) {
      boardIndexes = new ArrayList<>();
      for (int i = 0; i < NUMBER_OF_START_SPACES_PER_PLAYER; i++) {
        boardIndexes.add(numberOfPerimeterSpaces
            + (NUMBER_OF_HOME_SPACES_PER_PLAYER * numberOfPlayers)
            + (NUMBER_OF_START_SPACES_PER_PLAYER * playerNumber) + i);
      }
      playerBoardIndexes.add(Collections.unmodifiableList(boardIndexes));
    }
    startBoardIndexes = Collections.unmodifiableList(playerBoardIndexes);

    // calculate the safe board indexes
    boardIndexes = new ArrayList<>();
    for (int i = 0; i < numberOfPlayers; i++) {
      boardIndexes.add(NUMBER_OF_PERIMETER_SPACES_PER_PLAYER * i);
    }
    safeBoardIndexes = Collections.unmodifiableList(boardIndexes);

  }

  /**
   * Returns the list of home board indexes for the given player number.
   *
   * @param playerNumber the player number
   * @return the list of home board indexes for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public List<Integer> getHomeBoardIndexes(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < homeBoardIndexes.size(),
        "Invalid player number");
    return homeBoardIndexes.get(playerNumber);
  }

  /**
   * Returns the home entry board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the home entry board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getHomeEntryBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < homeEntryBoardIndexes.size(),
        "Invalid player number");
    return homeEntryBoardIndexes.get(playerNumber);
  }

  /**
   * Returns the home max board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the home max board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getHomeMaxBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < homeBoardIndexes.size(),
        "Invalid player number");
    return homeBoardIndexes.get(playerNumber).get(NUMBER_OF_HOME_SPACES_PER_PLAYER - 1);
  }

  /**
   * Returns the home min board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the home min board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getHomeMinBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < homeBoardIndexes.size(),
        "Invalid player number");
    return homeBoardIndexes.get(playerNumber).get(0);
  }

  /**
   * Returns the number of home spaces for each player.
   *
   * @return the number of home spaces for each player
   */
  public int getNumberOfHomeSpacesPerPlayer() {
    return NUMBER_OF_HOME_SPACES_PER_PLAYER;
  }

  /**
   * Returns the number of perimeter spaces on the board.
   *
   * @return the number of perimeter spaces on the board
   */
  public int getNumberOfPerimeterSpaces() {
    return numberOfPerimeterSpaces;
  }

  /**
   * Returns the number of playable spaces on the board.
   *
   * @return the number of playable spaces on the board
   */
  public int getNumberOfPlayableSpaces() {
    return numberOfPlayableSpaces;
  }

  /**
   * Returns the number of players.
   *
   * @return the number of players
   */
  public int getNumberOfPlayers() {
    return numberOfPlayers;
  }

  /**
   * Returns the list of perimeter board indexes.
   *
   * @return the list of perimeter board indexes
   */
  public List<Integer> getPerimeterBoardIndexes() {
    return perimeterBoardIndexes;
  }

  /**
   * Returns the safe board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the safe board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getSafeBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < safeBoardIndexes.size(),
        "Invalid player number");
    return safeBoardIndexes.get(playerNumber);
  }

  /**
   * Returns the list of start board indexes for the given player number.
   *
   * @param playerNumber the player number
   * @return the list of start board indexes for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public List<Integer> getStartBoardIndexes(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < startBoardIndexes.size(),
        "Invalid player number");
    return startBoardIndexes.get(playerNumber);
  }

  /**
   * Returns the start max board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the start max board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getStartMaxBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < startBoardIndexes.size(),
        "Invalid player number");
    return startBoardIndexes.get(playerNumber).get(NUMBER_OF_START_SPACES_PER_PLAYER - 1);
  }

  /**
   * Returns the start min board index for the given player number.
   *
   * @param playerNumber the player number
   * @return the start min board index for the given player number
   * @throws IllegalArgumentException if the given player number is invalid
   */
  public int getStartMinBoardIndex(int playerNumber) {
    Preconditions.checkArgument(playerNumber >= 0 && playerNumber < startBoardIndexes.size(),
        "Invalid player number");
    return startBoardIndexes.get(playerNumber).get(0);
  }

  /**
   * Returns the number of start spaces for each player.
   *
   * @return the number of start spaces for each player
   */
  public int getNumberOfStartSpacesPerPlayer() {
    return NUMBER_OF_START_SPACES_PER_PLAYER;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Board other = (Board) obj;
    if (this.numberOfPlayers != other.numberOfPlayers) {
      return false;
    }
    /*
     * No need to test other variables. The number of players and other variables are final fields
     * assigned in the constructor, so it is not possible for the values to differ if the number of
     * players is the same (which is checked above).
     */
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 11 * hash + this.numberOfPlayers;
    return hash;
  }

}

///////////////////////////////////////////////////////////////////////////////////////////////////
// 4 player board
///////////////////////////////////////////////////////////////////////////////////////////////////
//
//    | 00 01 02 03 04 05 06 07 08 09 10 11 12 13 14
// ---|---------------------------------------------
// 00 |                24 25 26 27 28
// 01 |       76 77    23    64    29    80 81
// 02 |                22    65    30
// 03 |       78 79    21    66    31    82 83
// 04 |                20    67    32
// 05 | 14 15 16 17 18 19          33 34 35 36 37 38
// 06 | 13                                        39
// 07 | 12 60 61 62 63                71 70 69 68 40
// 08 | 11                                        41
// 09 | 10 09 08 07 06 05          47 46 45 44 43 42
// 10 |                04    59    48
// 11 |       72 73    03    58    49    84 85
// 12 |                02    57    50
// 13 |       74 75    01    56    51    86 87
// 14 |                00 55 54 53 52
//
///////////////////////////////////////////////////////////////////////////////////////////////////
// 6 player board
///////////////////////////////////////////////////////////////////////////////////////////////////
//
//    | 00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
// ---|---------------------------------------------------------------------------
// 00 |                                  C3 C2 C1 C0
// 01 |             B6                38 39 40 41 42
// 02 |          B7    28             37    96    43             52    C7
// 03 |       B8    27    29          36    97    44          51    53    C6
// 04 |    B9    26          30       35    98    45       50          54    C5
// 05 |       25    92          31    34    99    46    49          A0    55    C4
// 06 |    24          93          32 33          47 48          A1          56
// 07 |       23          94                                  A2          57
// 08 |          22          95                            A3          58
// 09 |             21                                              59
// 10 |                20                                        60
// 11 |                   19                                  61
// 12 |                18                                        62
// 13 |             17                                              63
// 14 |          16          91                            A7          64
// 15 |       15          90                                  A6          65
// 16 |    14          89          06 05          75 74          A5          66
// 17 | B2    13    88          07    04    87    76    73          A4    67
// 18 |    B3    12          08       03    86    77       72          68    D1
// 19 |       B4    11    09          02    85    78          71    69    D0
// 20 |          B5    10             01    84    79             70    C9
// 21 |                               00 83 82 81 80                C8
// 22 |                               A8 A9 B0 B1
//
///////////////////////////////////////////////////////////////////////////////////////////////////
// 8 player board
///////////////////////////////////////////////////////////////////////////////////////////////////
//
//    | 00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
// ---|---------------------------------------------------------------------------------
// 00 |                                     G3 G2 G1 G0
// 01 |                F6                52 53 54 55 56
// 02 |             F7    42             51    C8    57             66    G7
// 03 |          F8    41    43          50    C9    58          65    67    G6
// 04 |       F9    40          44       49    D0    59       64          68    G5
// 05 |          39    C4          45    48    D1    60    63          D2    69    G4
// 06 |       38          C5          46 47          61 62          D3          70
// 07 |          37          C6                                  D4          71
// 08 |             36          C7                            D5          72
// 09 |                35                                              73
// 10 |                   34                                        74
// 11 | F2 28 29 30 31 32 33                                        75 76 77 78 79 80
// 12 | F3 27                                                                      81 H1
// 13 | F4 26 C0 C1 C2 C3                                              D9 D8 D7 D6 82 H0
// 14 | F5 25                                                                      83 G9
// 15 |    24 23 22 21 20 19                                        89 88 87 86 85 84 G8
// 16 |                   18                                        90
// 17 |                17                                              91
// 18 |             16          B9                            E3          92
// 19 |          15          B8                                  E2          93
// 20 |       14          B7          06 05          A3 A2          E1          94
// 21 |    E8    13    B6          07    04    B5    A4    A1          E0    95
// 22 |       E9    12          08       03    B4    A5       A0          96    H5
// 23 |          F0    11    09          02    B3    A6          99    97    H4
// 24 |             F1    10             01    B2    A7             98    H3
// 25 |                                  00 B1 B0 A9 A8                H2
// 26 |                                  E4 E5 E6 E7
