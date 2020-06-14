///*
// * You may only use this file in accordance with the terms and conditions
// * outlined in the accompanying LICENSE file.
// */
//
//package com.exit104.maurersmarbles;
//
//import com.google.common.base.Preconditions;
//
//import java.util.Map;
//import java.util.TreeMap;
//
///**
// *
// * @author Daniel Uppenkamp
// */
//public class NewBoardLayout implements BoardLayout {
//
//  /**
//   * The board for the layout.
//   */
//  protected final transient Board board;
//  /**
//   * The card scale factor relative to the size of a grid cell.
//   */
//  protected static final float CARD_SCALE_FACTOR = 0.5f;
//  /**
//   * The size of a grid cell on the board.
//   */
//  protected transient float gridCellSize;
//  /**
//   * The marble scale factor relative to the size of a grid cell.
//   */
//  protected static final float MARBLE_SCALE_FACTOR = 0.98f;
//  /**
//   * The space scale factor relative to the size of a grid cell.
//   */
//  protected static final float SPACE_SCALE_FACTOR = 0.75f;
//  /**
//   * The map that contains the angles for each board index. The key into the map is the board index
//   * and the value is the angle.
//   */
//  protected final transient Map<Integer, Float> boardIndexToAngleMap = new TreeMap<>();
//  /**
//   * The map that contains the bounds for each board index. The key into the map is the board index
//   * and the value is the bounds.
//   */
//  protected final transient Map<Integer, Rectangle> boardIndexToBoundsMap = new TreeMap<>();
//  /**
//   * The bounds for the discard pile on the board.
//   */
//  protected transient Rectangle discardPileRectangle;
//
//  /**
//   * Creates a new NewBoardLayout for the given board. By default, the width and height of the board
//   * layout is defined to be a unit square (1.0 x 1.0).
//   *
//   * @param board the board
//   * @throws NullPointerException if the given board is null
//   */
//  public NewBoardLayout(Board board) {
//    Preconditions.checkNotNull(board, "Null board");
//    this.board = board;
//    update(1.0f, 1.0f);
//  }
//
//  /**
//   * Updates the board layout using the given width and height.
//   *
//   * @param width the width of the board
//   * @param height the height of the board
//   */
//  public final void update(float width, float height) {
//
//    switch (board.getNumberOfPlayers()) {
//      case 4:
//        updateFourPlayers(width, height);
//        break;
//      case 6:
//        updateSixPlayers(width, height);
//        break;
//      default:
//      case 8:
//        updateEightPlayers(width, height);
//        break;
//    }
//
//  }
//
//  public final void updateEightPlayers(float width, float height) {
//
//    int numberOfColumns = 29;
//    int numberOfRows = 17;
//
//    // calculate the size of the grid cells
//    gridCellSize = Math.min(height / (float) numberOfRows, width / (float) numberOfColumns);
//
//    // calculate the spacing in the x and y directions
//    float spacingX = width / (float) numberOfColumns;
//    float spacingY = height / (float) numberOfRows;
//
//    float spaceX;
//    float spaceY;
//
//    // player 0 home entry space
//    spaceX = spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = numberOfRows / 2 * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(0), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(0), 0.0f);
//
//    // player 1 home entry space
//    spaceX = 8 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(1), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(1), 3.0f * (float) Math.PI / 2.0f);
//
//    // player 2 home entry space
//    spaceX = 14 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(2), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(2), 3.0f * (float) Math.PI / 2.0f);
//
//    // player 3 home entry space
//    spaceX = 20 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(3), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(3), 3.0f * (float) Math.PI / 2.0f);
//
//    // player 4 home entry space
//    spaceX = 27 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = numberOfRows / 2 * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(4), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(4), (float) Math.PI);
//
//    // player 5 home entry space
//    spaceX = 20 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = (numberOfRows - 2) * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(5), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(5), (float) Math.PI / 2.0f);
//
//    // player 6 home entry space
//    spaceX = 14 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = (numberOfRows - 2) * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(6), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(6), (float) Math.PI / 2.0f);
//
//    // player 7 home entry space
//    spaceX = 8 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = (numberOfRows - 2) * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(7), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(7), (float) Math.PI / 2.0f);
//
//    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {
//
//      float angle = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex(playerNumber));
//      Rectangle rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(playerNumber));
//
//      for (int offset = -2; offset <= 2; offset++) {
//
//        if (offset == 0) {
//          continue;
//        }
//
//        // spaces along player's home entry space
//        spaceX = (float) (rectangle.getX()
//            + (offset * spacingX * Math.cos(angle + Math.PI / 2.0f)));
//        spaceY = (float) (rectangle.getY()
//            - (offset * spacingY * Math.sin(angle + Math.PI / 2.0f)));
//        int boardIndex = (board.getHomeEntryBoardIndex(playerNumber) + offset)
//            % board.getNumberOfPerimeterSpaces();
//        boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
//            gridCellSize));
//        boardIndexToAngleMap.put(boardIndex, angle);
//
//        // connector spaces from the current player to the next/previous player
//        if (offset == -2 || offset == 2) {
//          int numberOfSpaces = 4;
//          if (playerNumber == 0 || playerNumber == 4) {
//            numberOfSpaces++;
//          }
//          for (int spaceOffset = 1; spaceOffset <= numberOfSpaces; spaceOffset++) {
//            spaceX += spacingX * Math.cos(angle);
//            spaceY -= spacingY * Math.sin(angle);
//            boardIndex = (boardIndex + (offset / 2)) % board.getNumberOfPerimeterSpaces();
//            boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
//                gridCellSize));
//            boardIndexToAngleMap.put(boardIndex, angle);
//          }
//        }
//
//        if (offset == 2 && (playerNumber == 1 || playerNumber == 2 || playerNumber == 5
//            || playerNumber == 6)) {
//          spaceX += spacingX * Math.cos(angle + (float) Math.PI / 2.0f);
//          spaceY -= spacingY * Math.sin(angle + (float) Math.PI / 2.0f);
//          boardIndex = (boardIndex + 1) % board.getNumberOfPerimeterSpaces();
//          boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
//              gridCellSize));
//          boardIndexToAngleMap.put(boardIndex, angle);
//        }
//
//      }
//
//      // home spaces
//      for (int offset = 0; offset < 4; offset++) {
//        float homeX = (float) (rectangle.getX()
//            + ((1 + offset) * gridCellSize * Math.cos(angle)));
//        float homeY = (float) (rectangle.getY()
//            - ((1 + offset) * gridCellSize * Math.sin(angle)));
//        boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
//            new Rectangle(homeX, homeY, gridCellSize, gridCellSize));
//        boardIndexToAngleMap.put(board.getHomeMinBoardIndex(playerNumber) + offset, angle);
//      }
//
//      // start spaces
//      float firstStartX = (float) (rectangle.getX()
//          + (1.5 * gridCellSize * Math.cos(angle + Math.PI / 2.0f))
//          + (gridCellSize * Math.cos(angle + Math.PI)));
//      float firstStartY = (float) (rectangle.getY()
//          - (1.5 * gridCellSize * Math.sin(angle + Math.PI / 2.0f))
//          - (gridCellSize * Math.sin(angle + Math.PI)));
//      for (int offset = 0; offset < 4; offset++) {
//        float startX = (float) (firstStartX + (offset * gridCellSize * Math.cos(angle - Math.PI
//            / 2.0f)));
//        float startY = (float) (firstStartY - (offset * gridCellSize * Math.sin(angle - Math.PI
//            / 2.0f)));
//        boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + offset,
//            new Rectangle(startX, startY, gridCellSize, gridCellSize));
//        boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + offset, angle);
//      }
//
//    }
//
//    // calculate the size of a card on the board based using the grid size
//    float cardWidth = Card.WIDTH * gridCellSize * CARD_SCALE_FACTOR;
//    float cardHeight = Card.HEIGHT * gridCellSize * CARD_SCALE_FACTOR;
//    discardPileRectangle = new Rectangle(width / 8.0f - cardWidth / 2.0f, height - height / 4.0f
//        - cardHeight / 2.0f, cardWidth, cardHeight);
//
//  }
//
//  public final void updateFourPlayers(float width, float height) {
//
//    int numberOfColumns = 21;
//    int numberOfRows = 13;
//
//    // calculate the size of the grid cells
//    gridCellSize = Math.min(height / (float) numberOfRows, width / (float) numberOfColumns);
//
//    // calculate the spacing in the x and y directions
//    float spacingX = width / (float) numberOfColumns;
//    float spacingY = height / (float) numberOfRows;
//
//    float spaceX;
//    float spaceY;
//
////    // player 0 home entry space
////    spaceX = 3 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 11 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(0), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(0), (float)Math.PI / 2.0f);
////
////    // player 1 home entry space
////    spaceX = 3 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(1), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(1), 3.0f * (float) Math.PI / 2.0f);
////
////    // player 2 home entry space
////    spaceX = 17 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(2), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(2), 3.0f * (float) Math.PI / 2.0f);
////
////    // player 3 home entry space
////    spaceX = 17 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 11 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(3), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(3), (float) Math.PI / 2.0f);
////
////    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {
////
////      float angle = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex(playerNumber));
////      Rectangle rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(playerNumber));
////
////      for (int offset = -2; offset <= 2; offset++) {
////
////        if (offset == 0) {
////          continue;
////        }
////
////        // spaces along player's home entry space
////        spaceX = (float) (rectangle.getX()
////            + (offset * spacingX * Math.cos(angle + Math.PI / 2.0f)));
////        spaceY = (float) (rectangle.getY()
////            - (offset * spacingY * Math.sin(angle + Math.PI / 2.0f)));
////        int boardIndex = (board.getHomeEntryBoardIndex(playerNumber) + offset)
////            % board.getNumberOfPerimeterSpaces();
////        boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////            gridCellSize));
////        boardIndexToAngleMap.put(boardIndex, angle);
////
////        // connector spaces from the current player to the next/previous player
////        if (offset == -2 || offset == 2) {
////
////          if (playerNumber % 2 == 0) {
////            if(offset == 2) {              
////              int numberOfSpaces = 5;
////              for (int spaceOffset = 1; spaceOffset <= numberOfSpaces; spaceOffset++) {
////                spaceY -= spacingY * Math.sin(angle);
////                boardIndex = (boardIndex + (offset / 2)) % board.getNumberOfPerimeterSpaces();
////                boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////                    gridCellSize));
////                boardIndexToAngleMap.put(boardIndex, angle);
////              }
////            }
////            else {
////              int numberOfSpaces = 5;
////              for (int spaceOffset = 1; spaceOffset <= numberOfSpaces; spaceOffset++) {
////                spaceX += spacingX * Math.cos(angle + 3.0f * (float) Math.PI / 2.0f);
////                boardIndex = (boardIndex + (offset / 2)) % board.getNumberOfPerimeterSpaces();
////                boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////                    gridCellSize));
////                boardIndexToAngleMap.put(boardIndex, angle);
////              }
////            }
////          } else if (playerNumber % 2 != 0) {
////            if (offset == 2) {
////              int numberOfSpaces = 4;
////              for (int spaceOffset = 1; spaceOffset <= numberOfSpaces; spaceOffset++) {
////                spaceX += spacingX * Math.cos(angle + (float) Math.PI / 2.0f);
////                boardIndex = (boardIndex + (offset / 2)) % board.getNumberOfPerimeterSpaces();
////                boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////                    gridCellSize));
////                boardIndexToAngleMap.put(boardIndex, angle);
////              }
////            } else {
////              int numberOfSpaces = 4;
////              for (int spaceOffset = 1; spaceOffset <= numberOfSpaces; spaceOffset++) {
////                spaceY -= spacingY * Math.sin(angle);
////                boardIndex = (boardIndex + (offset / 2)) % board.getNumberOfPerimeterSpaces();
////                boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////                    gridCellSize));
////                boardIndexToAngleMap.put(boardIndex, angle);
////              }
////            }
////          }
////          
////          
////        }
////
////      }
////
////      // home spaces
////      for (int offset = 0; offset < 4; offset++) {
////        float homeX = (float) (rectangle.getX()
////            + ((1 + offset) * gridCellSize * Math.cos(angle)));
////        float homeY = (float) (rectangle.getY()
////            - ((1 + offset) * gridCellSize * Math.sin(angle)));
////        boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
////            new Rectangle(homeX, homeY, gridCellSize, gridCellSize));
////        boardIndexToAngleMap.put(board.getHomeMinBoardIndex(playerNumber) + offset, angle);
////      }
////
////      // start spaces
////      float firstStartX = (float) (rectangle.getX()
////          + (1.5 * gridCellSize * Math.cos(angle + Math.PI / 2.0f))
////          + (gridCellSize * Math.cos(angle + Math.PI)));
////      float firstStartY = (float) (rectangle.getY()
////          - (1.5 * gridCellSize * Math.sin(angle + Math.PI / 2.0f))
////          - (gridCellSize * Math.sin(angle + Math.PI)));
////      for (int offset = 0; offset < 4; offset++) {
////        float startX = (float) (firstStartX + (offset * gridCellSize * Math.cos(angle - Math.PI
////            / 2.0f)));
////        float startY = (float) (firstStartY - (offset * gridCellSize * Math.sin(angle - Math.PI
////            / 2.0f)));
////        boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + offset,
////            new Rectangle(startX, startY, gridCellSize, gridCellSize));
////        boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + offset, angle);
////      }
////
////    }    
//    
//    // player 0 home entry space
//    spaceX = numberOfColumns / 2 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = (numberOfRows - 2) * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(0), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(0), (float) Math.PI / 2.0f);
//
//    // player 1 home entry space
//    spaceX = spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = numberOfRows / 2 * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(1), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(1), 0.0f);
//
//    // player 2 home entry space
//    spaceX = numberOfColumns / 2 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(2), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(2), 3.0f * (float) Math.PI / 2.0f);
//
//    // player 3 home entry space
//    spaceX = (numberOfColumns - 2) * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = numberOfRows / 2 * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(3), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(3), (float) Math.PI);
//
//    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {
//
//      float angle = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex(playerNumber));
//      Rectangle rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(playerNumber));
//
//      for (int offset = -2; offset <= 2; offset++) {
//
//        if (offset == 0) {
//          continue;
//        }
//
//        // spaces along player's home entry space
//        spaceX = (float) (rectangle.getX()
//            + (offset * spacingX * Math.cos(angle + Math.PI / 2.0f)));
//        spaceY = (float) (rectangle.getY()
//            - (offset * spacingY * Math.sin(angle + Math.PI / 2.0f)));
//        int boardIndex = (board.getHomeEntryBoardIndex(playerNumber) + offset)
//            % board.getNumberOfPerimeterSpaces();
//        boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
//            gridCellSize));
//        boardIndexToAngleMap.put(boardIndex, angle);
//
//        // connector spaces from the current player to the next/previous player
//        if (offset == -2 || offset == 2) {
//          int numberOfSpaces = 6;
//          if (playerNumber % 2 == 0) {
//            numberOfSpaces = 11 - numberOfSpaces - 2;
//          }
//          for (int spaceOffset = 1; spaceOffset <= numberOfSpaces; spaceOffset++) {
//            spaceX += spacingX * Math.cos(angle);
//            spaceY -= spacingY * Math.sin(angle);
//            boardIndex = (boardIndex + (offset / 2)) % board.getNumberOfPerimeterSpaces();
//            boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
//                gridCellSize));
//            boardIndexToAngleMap.put(boardIndex, angle);
//          }
//        }
//
//      }
//
//      // home spaces
//      for (int offset = 0; offset < 4; offset++) {
//        float homeX = (float) (rectangle.getX()
//            + ((1 + offset) * gridCellSize * Math.cos(angle)));
//        float homeY = (float) (rectangle.getY()
//            - ((1 + offset) * gridCellSize * Math.sin(angle)));
//        boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
//            new Rectangle(homeX, homeY, gridCellSize, gridCellSize));
//        boardIndexToAngleMap.put(board.getHomeMinBoardIndex(playerNumber) + offset, angle);
//      }
//
//      // start spaces
//      float firstStartX = (float) (rectangle.getX()
//          + (1.5 * gridCellSize * Math.cos(angle + Math.PI / 2.0f))
//          + (gridCellSize * Math.cos(angle + Math.PI)));
//      float firstStartY = (float) (rectangle.getY()
//          - (1.5 * gridCellSize * Math.sin(angle + Math.PI / 2.0f))
//          - (gridCellSize * Math.sin(angle + Math.PI)));
//      for (int offset = 0; offset < 4; offset++) {
//        float startX = (float) (firstStartX + (offset * gridCellSize * Math.cos(angle - Math.PI
//            / 2.0f)));
//        float startY = (float) (firstStartY - (offset * gridCellSize * Math.sin(angle - Math.PI
//            / 2.0f)));
//        boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + offset,
//            new Rectangle(startX, startY, gridCellSize, gridCellSize));
//        boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + offset, angle);
//      }
//
//    }
//
//    // calculate the size of a card on the board based using the grid size
//    float cardWidth = Card.WIDTH * gridCellSize * CARD_SCALE_FACTOR;
//    float cardHeight = Card.HEIGHT * gridCellSize * CARD_SCALE_FACTOR;
//    discardPileRectangle = new Rectangle(width / 2.0f - cardWidth / 2.0f, height / 2.0f
//        - cardHeight / 2.0f, cardWidth, cardHeight);
//
//  }
//
//  public final void updateSixPlayers(float width, float height) {
//
////    int numberOfColumns = 27;
////    int numberOfRows = 17;
////
////    // calculate the size of the grid cells
////    gridCellSize = Math.min(height / (float) numberOfRows, width / (float) numberOfColumns);
////
////    // calculate the spacing in the x and y directions
////    float spacingX = width / (float) numberOfColumns;
////    float spacingY = height / (float) numberOfRows;
////
////    float spaceX;
////    float spaceY;
////
////    // player 0 home entry space
////    spaceX = 1 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 8 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(0), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(0), 0.0f);
////
////    // player 1 home entry space
////    spaceX = 8 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 1 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(1), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(1), 3.0f * (float) Math.PI / 2.0f);
////
////    // player 2 home entry space
////    spaceX = 18 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 1 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(2), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(2), 3.0f * (float) Math.PI / 2.0f);
////
////    // player 3 home entry space
////    spaceX = 25 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 8 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(3), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(3), (float) Math.PI);
////
////    // player 4 home entry space
////    spaceX = 18 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 15 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(4), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(4), (float) Math.PI / 2.0f);
////
////    // player 5 home entry space
////    spaceX = 8 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 15 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(5), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(5), (float) Math.PI / 2.0f);
////
////    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {
////
////      float angle = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex(playerNumber));
////      Rectangle rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(playerNumber));
////
////      for (int offset = -4; offset <= 4; offset++) {
////
////        if (offset == 0) {
////          continue;
////        }
////
////        // spaces along player's home entry space
////        spaceX = (float) (rectangle.getX()
////            + (offset * spacingX * Math.cos(angle + Math.PI / 2.0f)));
////        spaceY = (float) (rectangle.getY()
////            - (offset * spacingY * Math.sin(angle + Math.PI / 2.0f)));
////        int boardIndex = (board.getHomeEntryBoardIndex(playerNumber) + offset)
////            % board.getNumberOfPerimeterSpaces();
////        boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////            gridCellSize));
////        boardIndexToAngleMap.put(boardIndex, angle);
////
////        // connector spaces from the current player to the next/previous player
////        if (offset == -4 || offset == 4) {
////          
////          int numberOfSpaces = 2;
////          if (offset == 4 && (playerNumber == 0 || playerNumber == 2 || playerNumber== 3 || playerNumber == 5)) {
////            numberOfSpaces = 3;
////          }
////          for (int spaceOffset = 1; spaceOffset <= numberOfSpaces; spaceOffset++) {
////            spaceX += spacingX * Math.cos(angle);
////            spaceY -= spacingY * Math.sin(angle);
////            boardIndex = (boardIndex + (offset / 4)) % board.getNumberOfPerimeterSpaces();
////            boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////                gridCellSize));
////            boardIndexToAngleMap.put(boardIndex, angle);
////          }
////        }
////
////        if (offset == 4 && (playerNumber == 1 || playerNumber == 4)) {
////          spaceX += spacingX * Math.cos(angle + (float) Math.PI / 2.0f);
////          spaceY -= spacingY * Math.sin(angle + (float) Math.PI / 2.0f);
////          boardIndex = (boardIndex + 1) % board.getNumberOfPerimeterSpaces();
////          boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////              gridCellSize));
////          boardIndexToAngleMap.put(boardIndex, angle);
////        }
////
////      }
////
////      // home spaces
////      for (int offset = 0; offset < 4; offset++) {
////        float homeX = (float) (rectangle.getX()
////            + ((1 + offset) * gridCellSize * Math.cos(angle)));
////        float homeY = (float) (rectangle.getY()
////            - ((1 + offset) * gridCellSize * Math.sin(angle)));
////        boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
////            new Rectangle(homeX, homeY, gridCellSize, gridCellSize));
////        boardIndexToAngleMap.put(board.getHomeMinBoardIndex(playerNumber) + offset, angle);
////      }
////
////      // start spaces
////      float firstStartX = (float) (rectangle.getX()
////          + (1.5 * gridCellSize * Math.cos(angle + Math.PI / 2.0f))
////          + (gridCellSize * Math.cos(angle + Math.PI)));
////      float firstStartY = (float) (rectangle.getY()
////          - (1.5 * gridCellSize * Math.sin(angle + Math.PI / 2.0f))
////          - (gridCellSize * Math.sin(angle + Math.PI)));
////      for (int offset = 0; offset < 4; offset++) {
////        float startX = (float) (firstStartX + (offset * gridCellSize * Math.cos(angle - Math.PI
////            / 2.0f)));
////        float startY = (float) (firstStartY - (offset * gridCellSize * Math.sin(angle - Math.PI
////            / 2.0f)));
////        boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + offset,
////            new Rectangle(startX, startY, gridCellSize, gridCellSize));
////        boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + offset, angle);
////      }
////
////    }    
//    
////    int numberOfColumns = 21;
////    int numberOfRows = 13;
////
////    // calculate the size of the grid cells
////    gridCellSize = Math.min(height / (float) numberOfRows, width / (float) numberOfColumns);
////
////    // calculate the spacing in the x and y directions
////    float spacingX = width / (float) numberOfColumns;
////    float spacingY = height / (float) numberOfRows;
////
////    float spaceX;
////    float spaceY;
////
////    // player 0 home entry space
////    spaceX = 10 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 11 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(0), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(0), (float)Math.PI / 2.0f);
////
////    // player 1 home entry space
////    spaceX = 2 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 11 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(1), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(1), (float) Math.PI / 2.0f);
////
////    // player 2 home entry space
////    spaceX = 2 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(2), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(2), 3.0f * (float) Math.PI / 2.0f);
////
////    // player 3 home entry space
////    spaceX = 10 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(3), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(3), 3.0f * (float) Math.PI / 2.0f);
////
////    // player 4 home entry space
////    spaceX = 18 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(4), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(4), 3.0f * (float) Math.PI / 2.0f);
////
////    // player 5 home entry space
////    spaceX = 18 * spacingX + (spacingX - gridCellSize) / 2.0f;
////    spaceY = 11 * spacingY + (spacingY - gridCellSize) / 2.0f;
////    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(5), new Rectangle(spaceX, spaceY,
////        gridCellSize, gridCellSize));
////    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(5), (float) Math.PI / 2.0f);
////
////    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {
////
////      float angle = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex(playerNumber));
////      Rectangle rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(playerNumber));
////
////      for (int offset = -2; offset <= 2; offset++) {
////
////        if (offset == 0) {
////          continue;
////        }
////
////        // spaces along player's home entry space
////        spaceX = (float) (rectangle.getX()
////            + (offset * spacingX * Math.cos(angle + Math.PI / 2.0f)));
////        spaceY = (float) (rectangle.getY()
////            - (offset * spacingY * Math.sin(angle + Math.PI / 2.0f)));
////        int boardIndex = (board.getHomeEntryBoardIndex(playerNumber) + offset)
////            % board.getNumberOfPerimeterSpaces();
////        boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////            gridCellSize));
////        boardIndexToAngleMap.put(boardIndex, angle);
////
////        // connector spaces from the current player to the next/previous player
////        if (offset == -2 || offset == 2) {
////          
////          int numberOfSpaces = 5;
////          if (offset == 2 && (playerNumber == 0 || playerNumber == 2 || playerNumber== 3 || playerNumber == 5)
////              || offset == -2 && (playerNumber == 0 || playerNumber == 1 || playerNumber == 3 || playerNumber == 4)) {
////            numberOfSpaces = 3;
////          }
////          for (int spaceOffset = 1; spaceOffset <= numberOfSpaces; spaceOffset++) {
////            spaceX += spacingX * Math.cos(angle);
////            spaceY -= spacingY * Math.sin(angle);
////            boardIndex = (boardIndex + (offset / 2)) % board.getNumberOfPerimeterSpaces();
////            boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////                gridCellSize));
////            boardIndexToAngleMap.put(boardIndex, angle);
////          }
////        }
////
////        if (offset == 2 && (playerNumber == 0 || playerNumber == 2 || playerNumber == 3 || playerNumber == 5)) {
////          for(int spaceOffset = 0; spaceOffset < 3; spaceOffset++) {
////          spaceX += spacingX * Math.cos(angle + (float) Math.PI / 2.0f);
////          spaceY -= spacingY * Math.sin(angle + (float) Math.PI / 2.0f);
////          boardIndex = (boardIndex + 1) % board.getNumberOfPerimeterSpaces();
////          boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
////              gridCellSize));
////          boardIndexToAngleMap.put(boardIndex, angle);
////          }
////        }
////
////      }
////
////      // home spaces
////      for (int offset = 0; offset < 4; offset++) {
////        float homeX = (float) (rectangle.getX()
////            + ((1 + offset) * gridCellSize * Math.cos(angle)));
////        float homeY = (float) (rectangle.getY()
////            - ((1 + offset) * gridCellSize * Math.sin(angle)));
////        boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
////            new Rectangle(homeX, homeY, gridCellSize, gridCellSize));
////        boardIndexToAngleMap.put(board.getHomeMinBoardIndex(playerNumber) + offset, angle);
////      }
////
////      // start spaces
////      float firstStartX = (float) (rectangle.getX()
////          + (1.5 * gridCellSize * Math.cos(angle + Math.PI / 2.0f))
////          + (gridCellSize * Math.cos(angle + Math.PI)));
////      float firstStartY = (float) (rectangle.getY()
////          - (1.5 * gridCellSize * Math.sin(angle + Math.PI / 2.0f))
////          - (gridCellSize * Math.sin(angle + Math.PI)));
////      for (int offset = 0; offset < 4; offset++) {
////        float startX = (float) (firstStartX + (offset * gridCellSize * Math.cos(angle - Math.PI
////            / 2.0f)));
////        float startY = (float) (firstStartY - (offset * gridCellSize * Math.sin(angle - Math.PI
////            / 2.0f)));
////        boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + offset,
////            new Rectangle(startX, startY, gridCellSize, gridCellSize));
////        boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + offset, angle);
////      }
////
////    }
//    
//    int numberOfColumns = 27;
//    int numberOfRows = 17;
//
//    // calculate the size of the grid cells
//    gridCellSize = Math.min(height / (float) numberOfRows, width / (float) numberOfColumns);
//
//    // calculate the spacing in the x and y directions
//    float spacingX = width / (float) numberOfColumns;
//    float spacingY = height / (float) numberOfRows;
//
//    float spaceX;
//    float spaceY;
//
//    // player 0 home entry space
//    spaceX = spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = numberOfRows / 2 * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(0), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(0), 0.0f);
//
//    // player 1 home entry space
//    spaceX = 8 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(1), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(1), 3.0f * (float) Math.PI / 2.0f);
//
//    // player 2 home entry space
//    spaceX = 18 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(2), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(2), 3.0f * (float) Math.PI / 2.0f);
//
//    // player 3 home entry space
//    spaceX = (numberOfColumns - 2) * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = numberOfRows / 2 * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(3), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(3), (float) Math.PI);
//
//    // player 4 home entry space
//    spaceX = 18 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = (numberOfRows - 2) * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(4), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(4), (float) Math.PI / 2.0f);
//
//    // player 5 home entry space
//    spaceX = 8 * spacingX + (spacingX - gridCellSize) / 2.0f;
//    spaceY = (numberOfRows - 2) * spacingY + (spacingY - gridCellSize) / 2.0f;
//    boardIndexToBoundsMap.put(board.getHomeEntryBoardIndex(5), new Rectangle(spaceX, spaceY,
//        gridCellSize, gridCellSize));
//    boardIndexToAngleMap.put(board.getHomeEntryBoardIndex(5), (float) Math.PI / 2.0f);
//
//    for (int playerNumber = 0; playerNumber < board.getNumberOfPlayers(); playerNumber++) {
//
//      float angle = boardIndexToAngleMap.get(board.getHomeEntryBoardIndex(playerNumber));
//      Rectangle rectangle = boardIndexToBoundsMap.get(board.getHomeEntryBoardIndex(playerNumber));
//
//      for (int offset = -2; offset <= 2; offset++) {
//
//        if (offset == 0) {
//          continue;
//        }
//
//        // spaces along player's home entry space
//        spaceX = (float) (rectangle.getX()
//            + (offset * spacingX * Math.cos(angle + Math.PI / 2.0f)));
//        spaceY = (float) (rectangle.getY()
//            - (offset * spacingY * Math.sin(angle + Math.PI / 2.0f)));
//        int boardIndex = (board.getHomeEntryBoardIndex(playerNumber) + offset)
//            % board.getNumberOfPerimeterSpaces();
//        boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
//            gridCellSize));
//        boardIndexToAngleMap.put(boardIndex, angle);
//
//        // connector spaces from the current player to the next/previous player
//        if (offset == -2 || offset == 2) {
//          int numberOfSpaces = 5;
//          if (offset == 2 && (playerNumber == 1 || playerNumber == 4)
//              || offset == -2 && (playerNumber == 2 || playerNumber == 5)) {
//            numberOfSpaces = 2;
//          }
//          for (int spaceOffset = 1; spaceOffset <= numberOfSpaces; spaceOffset++) {
//            spaceX += spacingX * Math.cos(angle);
//            spaceY -= spacingY * Math.sin(angle);
//            boardIndex = (boardIndex + (offset / 2)) % board.getNumberOfPerimeterSpaces();
//            boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
//                gridCellSize));
//            boardIndexToAngleMap.put(boardIndex, angle);
//          }
//        }
//
//        if (offset == 2 && (playerNumber == 1 || playerNumber == 4)) {
//          for(int spaceOffset = 0; spaceOffset <= 4; spaceOffset++) {
//          spaceX += spacingX * Math.cos(angle + (float) Math.PI / 2.0f);
//          spaceY -= spacingY * Math.sin(angle + (float) Math.PI / 2.0f);
//          boardIndex = (boardIndex + 1) % board.getNumberOfPerimeterSpaces();
//          boardIndexToBoundsMap.put(boardIndex, new Rectangle(spaceX, spaceY, gridCellSize,
//              gridCellSize));
//          boardIndexToAngleMap.put(boardIndex, angle);
//          }
//        }
//
//      }
//
//      // home spaces
//      for (int offset = 0; offset < 4; offset++) {
//        float homeX = (float) (rectangle.getX()
//            + ((1 + offset) * gridCellSize * Math.cos(angle)));
//        float homeY = (float) (rectangle.getY()
//            - ((1 + offset) * gridCellSize * Math.sin(angle)));
//        boardIndexToBoundsMap.put(board.getHomeMinBoardIndex(playerNumber) + offset,
//            new Rectangle(homeX, homeY, gridCellSize, gridCellSize));
//        boardIndexToAngleMap.put(board.getHomeMinBoardIndex(playerNumber) + offset, angle);
//      }
//
//      // start spaces
//      float firstStartX = (float) (rectangle.getX()
//          + (1.5 * gridCellSize * Math.cos(angle + Math.PI / 2.0f))
//          + (gridCellSize * Math.cos(angle + Math.PI)));
//      float firstStartY = (float) (rectangle.getY()
//          - (1.5 * gridCellSize * Math.sin(angle + Math.PI / 2.0f))
//          - (gridCellSize * Math.sin(angle + Math.PI)));
//      for (int offset = 0; offset < 4; offset++) {
//        float startX = (float) (firstStartX + (offset * gridCellSize * Math.cos(angle - Math.PI
//            / 2.0f)));
//        float startY = (float) (firstStartY - (offset * gridCellSize * Math.sin(angle - Math.PI
//            / 2.0f)));
//        boardIndexToBoundsMap.put(board.getStartMinBoardIndex(playerNumber) + offset,
//            new Rectangle(startX, startY, gridCellSize, gridCellSize));
//        boardIndexToAngleMap.put(board.getStartMinBoardIndex(playerNumber) + offset, angle);
//      }
//
//    }
//
//    // calculate the size of a card on the board based using the grid size
//    float cardWidth = Card.WIDTH * gridCellSize * CARD_SCALE_FACTOR;
//    float cardHeight = Card.HEIGHT * gridCellSize * CARD_SCALE_FACTOR;
//    discardPileRectangle = new Rectangle(width / 2.0f - cardWidth / 2.0f, height - cardHeight, 
//        cardWidth, cardHeight);
//
//  }
//
//  @Override
//  public float getAngleForBoardIndex(int boardIndex) {
//    Preconditions.checkArgument(boardIndex >= 0
//        && boardIndex < board.getNumberOfPlayableSpaces(), "Invalid board index");
//    return boardIndexToAngleMap.get(boardIndex);
//  }
//
//  @Override
//  public Rectangle getBoundsForBoardIndex(int boardIndex) {
//    Preconditions.checkArgument(boardIndex >= 0
//        && boardIndex < board.getNumberOfPlayableSpaces(), "Invalid board index");
//    return boardIndexToBoundsMap.get(boardIndex);
//  }
//
//  @Override
//  public Rectangle getBoundsForDiscardPile() {
//    return discardPileRectangle;
//  }
//
//  @Override
//  @SuppressWarnings("PMD.ShortVariable")
//  public Rectangle getBoundsForMarble(int boardIndex) {
//
//    Rectangle rectangle = getBoundsForBoardIndex(boardIndex);
//    float width = rectangle.getWidth() * MARBLE_SCALE_FACTOR;
//    float height = rectangle.getHeight() * MARBLE_SCALE_FACTOR;
//    float x = rectangle.getX() + (rectangle.getWidth() - width) / 2.0f;
//    float y = rectangle.getY() + (rectangle.getHeight() - height) / 2.0f;
//
//    return new Rectangle(x, y, width, height);
//
//  }
//
//  @Override
//  @SuppressWarnings("PMD.ShortVariable")
//  public Rectangle getBoundsForSpace(int boardIndex) {
//
//    Rectangle rectangle = getBoundsForBoardIndex(boardIndex);
//    float width = rectangle.getWidth() * SPACE_SCALE_FACTOR;
//    float height = rectangle.getHeight() * SPACE_SCALE_FACTOR;
//    float x = rectangle.getX() + (rectangle.getWidth() - width) / 2.0f;
//    float y = rectangle.getY() + (rectangle.getHeight() - height) / 2.0f;
//
//    return new Rectangle(x, y, width, height);
//
//  }
//
//}
