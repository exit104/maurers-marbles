/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The RectangleTest class contains the unit tests for the Rectangle class.
 *
 * @author Daniel Uppenkamp
 */
public class RectangleTest {

  public RectangleTest() {
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
   * Test of constructor method, of class Rectangle.
   */
  @Test
  public void testRectangle() {

    System.out.println("constructor");

    // test with int values
    Rectangle instance = new Rectangle(1, 2, 3, 4);
    assertNotNull(instance);

    // test with float values
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    assertNotNull(instance);

  }

  /**
   * Test of copy constructor method, of class Rectangle.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testRectangle_Rectangle() {

    System.out.println("copy constructor");

    // test with null rectangle
    Rectangle rectangle = null;
    try {
      new Rectangle(rectangle);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with int values
    rectangle = new Rectangle(1, 2, 3, 4);
    Rectangle instance = new Rectangle(rectangle);
    assertEquals(rectangle, instance);

    // test with float values
    rectangle = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    instance = new Rectangle(rectangle);
    assertEquals(rectangle, instance);

  }

  /**
   * Test of getHeight method, of class Rectangle.
   */
  @Test
  public void testGetHeight() {

    System.out.println("getHeight");

    // test with int values
    Rectangle instance = new Rectangle(1, 2, 3, 4);
    float expResult = 4;
    float result = instance.getHeight();
    assertEquals(expResult, result, 0.0);

    // test with float values
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = 4.5f;
    result = instance.getHeight();
    assertEquals(expResult, result, 0.0);

  }

  /**
   * Test of getWidth method, of class Rectangle.
   */
  @Test
  public void testGetWidth() {

    System.out.println("getWidth");

    // test with int values
    Rectangle instance = new Rectangle(1, 2, 3, 4);
    float expResult = 3;
    float result = instance.getWidth();
    assertEquals(expResult, result, 0.0);

    // test with float values
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = 3.4f;
    result = instance.getWidth();
    assertEquals(expResult, result, 0.0);

  }

  /**
   * Test of getX method, of class Rectangle.
   */
  @Test
  public void testGetX() {

    System.out.println("getX");

    // test with int values
    Rectangle instance = new Rectangle(1, 2, 3, 4);
    float expResult = 1;
    float result = instance.getX();
    assertEquals(expResult, result, 0.0);

    // test with float values
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = 1.2f;
    result = instance.getX();
    assertEquals(expResult, result, 0.0);

  }

  /**
   * Test of getY method, of class Rectangle.
   */
  @Test
  public void testGetY() {

    System.out.println("getY");

    // test with int values
    Rectangle instance = new Rectangle(1, 2, 3, 4);
    float expResult = 2;
    float result = instance.getY();
    assertEquals(expResult, result, 0.0);

    // test with float values
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = 2.3f;
    result = instance.getY();
    assertEquals(expResult, result, 0.0);

  }

  /**
   * Test of equals method, of class Rectangle.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEquals() {

    System.out.println("equals");

    // test same object
    Object obj = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    Rectangle instance = (Rectangle) obj;
    boolean expResult = true;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with null
    obj = null;
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different class
    obj = new Object();
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test equal objects
    obj = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different x
    obj = new Rectangle(1.0f, 2.3f, 3.4f, 4.5f);
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different y
    obj = new Rectangle(1.2f, 2.0f, 3.4f, 4.5f);
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different width
    obj = new Rectangle(1.2f, 2.3f, 3.0f, 4.5f);
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test different height
    obj = new Rectangle(1.2f, 2.3f, 3.4f, 4.0f);
    instance = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

  }

  /**
   * Test of hashCode method, of class Rectangle.
   */
  @Test
  public void testHashCode() {

    System.out.println("hashCode");

    // test with int values
    Rectangle instance1 = new Rectangle(1, 2, 3, 4);
    Rectangle instance2 = new Rectangle(1, 2, 3, 4);
    assertEquals(instance1.hashCode(), instance2.hashCode());

    // test with float values
    instance1 = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    instance2 = new Rectangle(1.2f, 2.3f, 3.4f, 4.5f);
    assertEquals(instance1.hashCode(), instance2.hashCode());

  }

}
