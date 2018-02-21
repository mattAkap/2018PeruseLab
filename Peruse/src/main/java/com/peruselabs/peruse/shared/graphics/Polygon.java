/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.peruselabs.peruse.shared.StdException;
import com.peruselabs.peruse.shared.graphics.api.Crossable;
import com.peruselabs.peruse.shared.graphics.api.MayContain;

/**
 * A polygon as defined in Geometric shapes. A path is collection of contiguous
 * {@link Point}s and each pair of {@link Point}s (Pn, Pn+1, where n =
 * 1,2,3...n) is connected. A closing connection between Pn and P1 must exist to
 * close the loop to create a polygon (a closed) {@link Path}. e.g. Symmetrical
 * <img src= "http://peruselab.com/images/bonds/templates/cycloHexane.svg" />
 * and asymmetrical <img src="https://goo.gl/mfwHgF" width="120px"/>
 * 
 * 
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 25, 2018
 *
 */
public class Polygon implements Crossable, MayContain {
    private List<Point> points;

    public Polygon(@NotNull List<Point> points) throws StdException {
        super();
        if (points.size() < 2) {
            throw new StdException("Not enough points to create a polygon");
        }
        this.points = points;
    }

    @Override
    public boolean contains(Point aPoint) {
        // TODO Auto-generated method stub, discard when completed
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Polygon other = (Polygon) obj;
        if (points == null) {
            if (other.points != null)
                return false;
        } else if (!points.equals(other.points))
            return false;
        return true;
    }

    @Override
    public Point getIntersection(Crossable aLine) {
        // TODO Auto-generated method stub, discard when completed
        return null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((points == null) ? 0 : points.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final int maxLen = 10;
        StringBuilder builder = new StringBuilder();
        builder.append("Polygon [");
        if (points != null) {
            builder.append("points=");
            builder.append(points.subList(0, Math.min(points.size(), maxLen)));
        }
        builder.append("]");
        return builder.toString();
    }
}
