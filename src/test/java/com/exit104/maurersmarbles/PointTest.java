/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The PointTest class contains the unit tests for the Point class.
 *
 * @author Daniel Uppenkamp
 */
public class PointTest {

  public PointTest() {
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
   * Test of constructor method, of class Point.
   */
  @Test
  public void testPoint_float_float() {

    System.out.println("constructor");

    // test with int values
    Point instance = new Point(1, 2);
    assertEquals(1, instance.getX(), 0.0);
    assertEquals(2, instance.getY(), 0.0);

    // test with int values
    instance = new Point(1.2f, 2.3f);
    assertEquals(1.2f, instance.getX(), 0.0);
    assertEquals(2.3f, instance.getY(), 0.0);

  }

  /**
   * Test of constructor method, of class Point.
   */
  @Test
  public void testPoint_Point() {

    System.out.println("copy constructor");

    // test with null
    Point point = null;
    try {
      new Point(point);
      fail("Null pointer exception not thrown");
    } catch (NullPointerException ex) {
      // do nothing
    }

    // test with int values
    point = new Point(1, 2);
    Point instance = new Point(point);
    assertEquals(point, instance);

    // test with float values
    point = new Point(1.2f, 2.3f);
    instance = new Point(point);
    assertEquals(point, instance);

  }

  /**
   * Test of equals method, of class Point.
   */
  @Test
  @SuppressWarnings("PMD.NullAssignment")
  public void testEquals() {

    System.out.println("equals");

    // test with same object
    Object obj = new Point(1, 2);
    Point instance = (Point) obj;
    boolean expResult = true;
    boolean result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with null
    obj = null;
    instance = new Point(1, 2);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different class
    obj = new Object();
    instance = new Point(1, 2);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with equal objects
    obj = new Point(1, 2);
    instance = new Point(1, 2);
    expResult = true;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different x values
    obj = new Point(1, 2);
    instance = new Point(2, 2);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

    // test with different y values
    obj = new Point(1, 2);
    instance = new Point(1, 3);
    expResult = false;
    result = instance.equals(obj);
    assertEquals(expResult, result);

  }

  /**
   * Test of hashCode method, of class Point.
   */
  @Test
  public void testHashCode() {

    System.out.println("hashCode");

    Point instance1 = new Point(1, 2);
    Point instance2 = new Point(1, 2);
    assertEquals(instance1.hashCode(), instance2.hashCode());

  }

  /**
   * Test of toString method, of class Point.
   */
  @Test
  public void testToString() {

    System.out.println("toString");

    Point instance = new Point(1, 2);
    String expResult = "(1.000000, 2.000000)";
    String result = instance.toString();
    assertEquals(expResult, result);

  }

}
