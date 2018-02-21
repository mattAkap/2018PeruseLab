/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics;

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

    @Override
    public Point getIntersection(Crossable aPath) {
        return null;
    }
}
