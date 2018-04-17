/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics;

import com.peruselabs.peruse.shared.graphics.api.Crossable;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;


/**
 * It is straight, theoretically without thickness, and may have a starting
 * {@link Point} and an ending {@link Point}.
 *
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 25, 2018
 *
 */
public class Line implements Crossable {
    private Point start;
    private Point end;

    public Line() {
        super();
    }

    public Line(Point start, Point end) {
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Line other = (Line) obj;
        if (end == null) {
            if (other.end != null)
                return false;
        } else if (!end.equals(other.end))
            return false;
        if (start == null) {
            if (other.start != null)
                return false;
        } else if (!start.equals(other.start))
            return false;
        return true;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public Point getIntersection(Crossable aLine) {
        Point ret = new Point();

        Line2D line1 = new Line2D.Double(((Line) aLine).start.getX(),((Line) aLine).start.getY(),((Line) aLine).end.getX(),((Line) aLine).end.getY());
        Line2D line2 = new Line2D.Double(this.start.getX(),this.start.getY(),this.end.getX(),this.end.getY());

        boolean result = line2.intersectsLine(line1);
        if (!result) {
            return null;
        } else {
            final double x1,y1, x2,y2, x3,y3, x4,y4;
            x1 = this.start.getX();            y1 = this.start.getY();            x2 = this.end.getX();            y2 = this.end.getY();
            x3 = ((Line) aLine).start.getX();            y3 = ((Line) aLine).start.getY();            x4 = ((Line) aLine).end.getX();            y4 = ((Line) aLine).end.getY();

            double denom = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
            if (denom == 0.0) { // Lines are parallel.
                return  null;

            }
            double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3))/denom;
            double ub = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3))/denom;
            if (ua >= 0.0f && ua <= 1.0f && ub >= 0.0f && ub <= 1.0f) {
                // Get the intersection point.
                return new Point((int) (x1 + ua*(x2 - x1)), (int) (y1 + ua*(y2 - y1)));
            }

            return ret;
        }
    }

    public Point getStart() {
        return start;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((end == null) ? 0 : end.hashCode());
        result = prime * result + ((start == null) ? 0 : start.hashCode());
        return result;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Line [");
        if (start != null) {
            builder.append("start=");
            builder.append(start);
            builder.append(", ");
        }
        if (end != null) {
            builder.append("end=");
            builder.append(end);
        }
        builder.append("]");
        return builder.toString();
    }
}

