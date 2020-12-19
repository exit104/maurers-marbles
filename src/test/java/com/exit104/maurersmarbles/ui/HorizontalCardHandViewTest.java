/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles.ui;

import static org.junit.Assert.assertEquals;

import com.exit104.maurersmarbles.Card;
import com.exit104.maurersmarbles.Rectangle;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The HorizontalCardHandViewTest class contains the unit tests for the HorizontalCardHandView
 * class.
 *
 * @author Daniel Uppenkamp
 */
public class HorizontalCardHandViewTest {

  public HorizontalCardHandViewTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  /**
   * Test of setPaddingBottomScaleFactor method, of class HorizontalCardHandView.
   */
  @Test
  public void testSetPaddingBottomScaleFactor() {

    System.out.println("setPaddingBottomScaleFactor");

    float paddingBottomScaleFactor = 1.23f;
    HorizontalCardHandView instance = new HorizontalCardHandView();
    instance.setPaddingBottomScaleFactor(paddingBottomScaleFactor);
    assertEquals(paddingBottomScaleFactor, instance.getPaddingBottomScaleFactor(), 0.0);

  }

  /**
   * Test of setPaddingLeftScaleFactor method, of class HorizontalCardHandView.
   */
  @Test
  public void testSetPaddingLeftScaleFactor() {

    System.out.println("setPaddingLeftScaleFactor");

    float paddingLeftScaleFactor = 2.34f;
    HorizontalCardHandView instance = new HorizontalCardHandView();
    instance.setPaddingLeftScaleFactor(paddingLeftScaleFactor);
    assertEquals(paddingLeftScaleFactor, instance.getPaddingLeftScaleFactor(), 0.0);

  }

  /**
   * Test of setPaddingRightScaleFactor method, of class HorizontalCardHandView.
   */
  @Test
  public void testSetPaddingRightScaleFactor() {

    System.out.println("setPaddingRightScaleFactor");

    float paddingRightScaleFactor = 3.45f;
    HorizontalCardHandView instance = new HorizontalCardHandView();
    instance.setPaddingRightScaleFactor(paddingRightScaleFactor);
    assertEquals(paddingRightScaleFactor, instance.getPaddingRightScaleFactor(), 0.0);

  }

  /**
   * Test of setPaddingTopScaleFactor method, of class HorizontalCardHandView.
   */
  @Test
  public void testSetPaddingTopScaleFactor() {

    System.out.println("setPaddingTopScaleFactor");

    float paddingTopScaleFactor = 4.56f;
    HorizontalCardHandView instance = new HorizontalCardHandView();
    instance.setPaddingTopScaleFactor(paddingTopScaleFactor);
    assertEquals(paddingTopScaleFactor, instance.getPaddingTopScaleFactor(), 0.0);

  }

  /**
   * Test of setSpaceBetweenCardsScaleFactor method, of class HorizontalCardHandView.
   */
  @Test
  public void testSetSpaceBetweenCardsScaleFactor() {

    System.out.println("setSpaceBetweenCardsScaleFactor");

    float spaceBetweenCardsScaleFactor = 0.0F;
    HorizontalCardHandView instance = new HorizontalCardHandView();
    instance.setSpaceBetweenCardsScaleFactor(spaceBetweenCardsScaleFactor);
    assertEquals(spaceBetweenCardsScaleFactor, instance.getSpaceBetweenCardsScaleFactor(), 0.0);

  }

  /**
   * Test of getAngleForCard method, of class HorizontalCardHandView.
   */
  @Test
  public void testGetAngleForCard() {

    System.out.println("getAngleForCard");

    int cardNumber = 0;
    int currentNumberOfCards = 1;
    int maxNumberOfCards = 1;
    HorizontalCardHandView instance = new HorizontalCardHandView();
    float expResult = 0.0f;
    float result = instance.getAngleForCard(cardNumber, currentNumberOfCards, maxNumberOfCards);
    assertEquals(expResult, result, 0.0);

  }

  /**
   * Test of getBoundsForCard method, of class HorizontalCardHandView.
   */
  @Test
  public void testGetBoundsForCard() {

    System.out.println("getBoundsForCard");

    // test with 1 card with 1 card max
    int cardNumber = 0;
    int currentNumberOfCards = 1;
    int maxNumberOfCards = 1;
    HorizontalCardHandView instance = new HorizontalCardHandView();
    instance.update(Card.WIDTH, Card.HEIGHT * 1.5f);
    Rectangle expResult = new Rectangle(0.0f, Card.HEIGHT * 0.25f, Card.WIDTH, Card.HEIGHT);
    Rectangle result = instance.getBoundsForCard(cardNumber, currentNumberOfCards,
        maxNumberOfCards);
    assertEquals(expResult, result);

    // test with 2 card with 2 cards max
    cardNumber = 0;
    currentNumberOfCards = 2;
    maxNumberOfCards = 2;
    instance = new HorizontalCardHandView();
    instance.update(Card.WIDTH * 2.0f, Card.HEIGHT * 1.5f);
    expResult = new Rectangle(0.0f, Card.HEIGHT * 0.25f, Card.WIDTH, Card.HEIGHT);
    result = instance.getBoundsForCard(cardNumber, currentNumberOfCards, maxNumberOfCards);
    assertEquals(expResult, result);

    // test with 2 card with 2 cards max
    cardNumber = 0;
    currentNumberOfCards = 1;
    maxNumberOfCards = 2;
    instance = new HorizontalCardHandView();
    instance.update(Card.WIDTH * 2.0f, Card.HEIGHT * 1.5f);
    expResult = new Rectangle(Card.WIDTH / 2.0f, Card.HEIGHT * 0.25f, Card.WIDTH, Card.HEIGHT);
    result = instance.getBoundsForCard(cardNumber, currentNumberOfCards, maxNumberOfCards);
    assertEquals(expResult, result);

    // test with height greater than width
    cardNumber = 0;
    currentNumberOfCards = 1;
    maxNumberOfCards = 1;
    instance = new HorizontalCardHandView();
    instance.update(Card.WIDTH, Card.HEIGHT / 2.0f);
    expResult = new Rectangle(
        Card.WIDTH / 2.0f - (Card.WIDTH * (Card.HEIGHT / 2.0f) / Card.HEIGHT / 2.0f), 0.0f,
        Card.WIDTH * (Card.HEIGHT / 2.0f) / Card.HEIGHT, Card.HEIGHT / 2.0f);
    result = instance.getBoundsForCard(cardNumber, currentNumberOfCards, maxNumberOfCards);
    assertEquals(expResult, result);

    // test with padding
    cardNumber = 0;
    currentNumberOfCards = 1;
    maxNumberOfCards = 1;
    instance = new HorizontalCardHandView();
    instance.setPaddingBottomScaleFactor(0.1f);
    instance.setPaddingLeftScaleFactor(0.2f);
    instance.setPaddingRightScaleFactor(0.3f);
    instance.setPaddingTopScaleFactor(0.4f);
    expResult = new Rectangle(((1.0f - 0.2f - (0.5f * Card.WIDTH / Card.HEIGHT) - 0.3f) / 2.0f)
        + 0.2f, 0.4f, 0.5f * Card.WIDTH / Card.HEIGHT, 0.5f);
    result = instance.getBoundsForCard(cardNumber, currentNumberOfCards, maxNumberOfCards);
    assertEquals(expResult, result);

    // test with space between cards
    cardNumber = 0;
    currentNumberOfCards = 2;
    maxNumberOfCards = 2;
    instance = new HorizontalCardHandView();
    instance.setSpaceBetweenCardsScaleFactor(0.1f);
    expResult = new Rectangle(
        ((1.0f - (currentNumberOfCards * 0.45f) - ((currentNumberOfCards - 1) * 0.1f)) / 2.0f)
        + (cardNumber * (0.45f + 0.1f)),
        0.185f, 0.45f, 0.45f * Card.HEIGHT / Card.WIDTH);
    result = instance.getBoundsForCard(cardNumber, currentNumberOfCards, maxNumberOfCards);
    assertEquals(expResult, result);

    // test with space between cards
    cardNumber = 1;
    currentNumberOfCards = 2;
    maxNumberOfCards = 2;
    instance = new HorizontalCardHandView();
    instance.setSpaceBetweenCardsScaleFactor(0.1f);
    expResult = new Rectangle(
        ((1.0f - (currentNumberOfCards * 0.45f) - ((currentNumberOfCards - 1) * 0.1f)) / 2.0f)
        + (cardNumber * (0.45f + 0.1f)),
        0.185f, 0.45f, 0.45f * Card.HEIGHT / Card.WIDTH);
    result = instance.getBoundsForCard(cardNumber, currentNumberOfCards, maxNumberOfCards);
    assertEquals(expResult, result);

  }

}
