/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

/**
 * The Rectangle class represents a 2D rectangle consisting of an x, y point with a width and
 * height.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
@SuppressWarnings("PMD.ShortVariable")
public class Rectangle {

  /**
   * The height of the rectangle.
   */
  protected final transient float height;
  /**
   * The width of the rectangle.
   */
  protected final transient float width;
  /**
   * The x coordinate of the rectangle.
   */
  protected final transient float x;
  /**
   * The y coordinate of the rectangle.
   */
  protected final transient float y;

  /**
   * Creates a new Rectangle.
   *
   * @param x the x coordinate of the rectangle
   * @param y the y coordinate of the rectangle
   * @param width the width of the rectangle
   * @param height the height of the rectangle
   */
  public Rectangle(float x, float y, float width, float height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * Creates a new Rectangle using the given rectangle.
   *
   * @param rectangle the rectangle to copy
   * @throws NullPointerException if the given rectangle is null
   */
  public Rectangle(Rectangle rectangle) {

    Preconditions.checkNotNull(rectangle, "Null rectangle");

    this.x = rectangle.x;
    this.y = rectangle.y;
    this.width = rectangle.width;
    this.height = rectangle.height;

  }

  /**
   * Returns the height of the rectangle.
   *
   * @return the height of the rectangle
   */
  public float getHeight() {
    return height;
  }

  /**
   * Returns the width of the rectangle.
   *
   * @return the width of the rectangle
   */
  public float getWidth() {
    return width;
  }

  /**
   * Returns the x coordinate of the rectangle.
   *
   * @return the x coordinate of the rectangle
   */
  public float getX() {
    return x;
  }

  /**
   * Returns the y coordinate of the rectangle.
   *
   * @return the y coordinate of the rectangle
   */
  public float getY() {
    return y;
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
    final Rectangle other = (Rectangle) obj;
    if (Float.floatToIntBits(this.height) != Float.floatToIntBits(other.height)) {
      return false;
    }
    if (Float.floatToIntBits(this.width) != Float.floatToIntBits(other.width)) {
      return false;
    }
    if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
      return false;
    }
    if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 17 * hash + Float.floatToIntBits(this.height);
    hash = 17 * hash + Float.floatToIntBits(this.width);
    hash = 17 * hash + Float.floatToIntBits(this.x);
    hash = 17 * hash + Float.floatToIntBits(this.y);
    return hash;
  }

}
