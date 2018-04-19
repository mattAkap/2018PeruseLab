/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.peruselabs.peruse.shared.StdException;
import com.peruselabs.peruse.shared.graphics.api.Crossable;

/**
 * A path is collection of contiguous {@link Point}s and each pair of
 * {@link Point}s (Pn, Pn+1, where n = 1,2,3...n) is connected. Example:
 * <img width="150px" src="https://goo.gl/DDpY7h" >
 *
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 25, 2018
 *
 */
public class Path implements Crossable {
    private List<Point> points;

    public Path(@NotNull List<Point> points) throws StdException {
        super();
        if (points.size() < 2) {
            throw new StdException("Not enough points to create a path");
        }

        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public List<Point> getIntersectionsPath (Crossable aPath) {
        List<Point> listOfIntersections = new ArrayList<Point>();
        Point intersectedPoint = new Point();
        for (int i = 0; i < this.points.size()-1; i++) {
            Point firstPoint = this.points.get(i);
            Point secondPoint = this.points.get(i+1);

            Line2D line1 = new Line2D.Double(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
            Line2D line2 = new Line2D.Double(((Line) aPath).getStart().getX(),((Line) aPath).getStart().getY(),((Line) aPath).getEnd().getX(),((Line) aPath).getEnd().getY());
            boolean result = line2.intersectsLine(line1);
            if (!result) {
            }
            else {
                final double x1,y1, x2,y2, x3,y3, x4,y4;

                x1 = firstPoint.getX();                y1 = firstPoint.getY();                x2 = secondPoint.getX();                y2 = secondPoint.getY();
                x3 = ((Line) aPath).getStart().getX();                y3 = ((Line) aPath).getStart().getY();                x4 = ((Line) aPath).getEnd().getX();                y4 = ((Line) aPath).getEnd().getY();

                double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
                if (denom == 0.0) { // Lines are parallel.


                }
                double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))/denom;
                double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3))/denom;
                if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
                    // Get the intersection point.
                    intersectedPoint = new Point((int)x1 + ua*(x2 - x1),(int)y1 + ua*(y2 - y1));
                    listOfIntersections.add(intersectedPoint);

                }
            }
        }

        if (listOfIntersections.size() == 0) {
            return null;
        }

        return listOfIntersections;
    }

    @Override
    public Point getIntersection(Crossable crossable) {
        return null;
    }
}
