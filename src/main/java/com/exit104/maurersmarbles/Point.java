/*
 * You may only use this file in accordance with the terms and conditions
 * outlined in the accompanying LICENSE file.
 */

package com.exit104.maurersmarbles;

import com.google.common.base.Preconditions;

/**
 * The Point class is used to represent a x,y location.
 *
 * @author Daniel Uppenkamp
 * @since 1.0.0
 */
@SuppressWarnings("PMD.ShortVariable")
public class Point {

  /**
   * The x coordinate of the point.
   */
  protected final float x;
  /**
   * The y coordinate of the point.
   */
  protected final float y;

  /**
   * Creates a new Point at the given x, y location.
   *
   * @param x the x coordinate of the point
   * @param y the y coordinate of the point
   */
  public Point(float x, float y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Creates a new Point using the given point.
   *
   * @param point the point to copy
   * @throws NullPointerException if the given point is null
   */
  public Point(Point point) {
    Preconditions.checkNotNull(point, "Null point");
    this.x = point.x;
    this.y = point.y;
  }

  /**
   * Returns the x coordinate of the point.
   *
   * @return the x coordinate of the point
   */
  public float getX() {
    return x;
  }

  /**
   * Returns the y coordinate of the point.
   *
   * @return the y coordinate of the point
   */
  public float getY() {
    return y;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Point other = (Point) obj;
    if (this.x != other.x) {
      return false;
    }
    if (this.y != other.y) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 43 * hash + Float.floatToIntBits(this.x);
    hash = 43 * hash + Float.floatToIntBits(this.y);
    return hash;
  }

  @Override
  public String toString() {
    return new StringBuilder("(").append(x).append(", ").append(y).append(")").toString();
  }

}
