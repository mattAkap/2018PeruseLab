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
    private Point start;
    private Point end;

    public Polygon(@NotNull List<Point> points) throws StdException {
        super();
        if (points.size() < 2) {
            throw new StdException("Not enough points to create a polygon");
        }
        this.points = points;
    }

    @Override
    public boolean contains(Point aPoint) {
        int j = points.size() - 1;
        boolean oddNodes = false;

        for (int i = 0; i < points.size(); i++)
        {
            if (points.get(i).getY() < aPoint.getY() && points.get(j).getY() >= aPoint.getY() ||
                    points.get(j).getY() < aPoint.getY() && points.get(i).getY() >= aPoint.getY())
            {
                if (points.get(i).getX() + (aPoint.getY() - points.get(i).getY())/(points.get(j).getY() - points.get(j).getY()) * (points.get(j).getX() - points.get(i).getX()) < aPoint.getX())
                {
                    oddNodes = !oddNodes;
                }
            }
            j = i;
        }

        return oddNodes;
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

    public List<Point> getIntersections(Crossable aLine) {
        List<Point> listOfIntersections = new ArrayList<Point>();
        Point intersectedPoint = new Point();
        for (int i = 0; i < this.points.size()-1; i++) {
            Point firstPoint = this.points.get(i);
            for (int j = i+1; j < this.points.size(); j++) {
                Point secondPoint = this.points.get(j);

                Line2D line1 = new Line2D.Double(firstPoint.getX(), firstPoint.getY(), secondPoint.getX(), secondPoint.getY());
                Line2D line2 = new Line2D.Double(((Line) aLine).getStart().getX(),((Line) aLine).getStart().getY(),((Line) aLine).getEnd().getX(),((Line) aLine).getEnd().getY());
                boolean result = line2.intersectsLine(line1);
                if (!result) {

                }
                else {
                    final double x1,y1, x2,y2, x3,y3, x4,y4;

                    x1 = firstPoint.getX();                    
					y1 = firstPoint.getY();
                    x2 = secondPoint.getX();
                    y2 = secondPoint.getY();
                    x3 = ((Line) aLine).getStart().getX();
                    y3 = ((Line) aLine).getStart().getY();
                    x4 = ((Line) aLine).getEnd().getX();
                    y4 = ((Line) aLine).getEnd().getY();

                    double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
                    if (denom == 0.0) { // Lines are parallel.
					
                    }
					
                    double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))/denom;
                    double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3))/denom;
                    if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
                        // Get the intersection point.
                        intersectedPoint.setX(x1 + ua*(x2 - x1));
                        intersectedPoint.setY(y1 + ua*(y2 - y1));
                        listOfIntersections.add(intersectedPoint);

                    }
                }
            }
        }

        if (listOfIntersections.size() == 0) {
            return null;
        }
		
        return listOfIntersections;
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

    /**
     * DO NOT use this method when using polygons. This method is just for lines.
     */
    @Override
    public Point getIntersection(Crossable crossable) {
        return null;
    }
}