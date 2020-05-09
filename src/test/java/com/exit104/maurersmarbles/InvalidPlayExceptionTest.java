/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * The InvalidPlayExceptionTest class contains the unit tests for the InvalidPlayException class.
 *
 * @author Daniel Uppenkamp
 */
public class InvalidPlayExceptionTest {

  public InvalidPlayExceptionTest() {
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
   * Test of constructor method, of class InvalidPlayException.
   */
  @Test
  public void testInvalidPlayException() {

    InvalidPlayException instance = new InvalidPlayException();
    assertEquals(null, instance.getMessage());

  }

  /**
   * Test of constructor method, of class InvalidPlayException.
   */
  @Test
  public void testInvalidPlayException_String() {

    String message = "my error message";
    InvalidPlayException instance = new InvalidPlayException(message);
    assertEquals(message, instance.getMessage());

  }

}
