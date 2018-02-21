/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics;

import com.peruselabs.peruse.shared.graphics.api.Crossable;

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
        if (aLine == null) {
            return null;
        }

        return null;
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
