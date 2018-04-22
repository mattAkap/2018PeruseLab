/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics;

import javax.annotation.Nonnull;

/**
 * A location defined by a Cartesien coordinate, with measures in x, y, and z
 * planes.
 * 
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 25, 2018
 *
 */
public class Point {
	private double x;
	private double y;
	private double z;

	public Point() {
		super();
	}

	public Point(@Nonnull double x, @Nonnull double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point(@Nonnull double x, @Nonnull double y, @Nonnull double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Point other = (Point) obj;

		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;

		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;

		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;

		return true;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	public void setX(@Nonnull double x) {
		this.x = x;
	}

	public void setY(@Nonnull double y) {
		this.y = y;
	}

	public void setZ(@Nonnull double z) {
		this.z = z;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Point [x=");
		builder.append(x);
		builder.append(", y=");
		builder.append(y);
		builder.append(", z=");
		builder.append(z);
		builder.append("]");
		return builder.toString();
	}
}
