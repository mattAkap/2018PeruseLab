/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics.api;

import com.peruselabs.peruse.shared.graphics.Line;
import com.peruselabs.peruse.shared.graphics.Point;

/**
 * Defines the policy for crossable (intersectable) objects.
 * 
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 25, 2018
 *
 */
public interface Crossable {
    /**
     * Calculate the {@link Point} at which aLine intersects this line.
     * <img src= "http://flassari.is/wp-content/uploads/2008/11/linesect.png">
     * When found no intersection then return a null otherwise a non-null
     * {@link Point}. If the given {@link Line} aLine is null or invalid (either
     * a starting {@link Point} or the end {@link Point} is missing or invalid)
     * then a null must be returned.
     * 
     * @param aLine
     * @return point at which aLine intersects this line.
     */
    public Point getIntersection(Crossable crossable);

    /**
     * Convenient method if a {@link Crossable} object is intersected or not.
     * 
     * @param crossable
     * @return boolean
     */
    public default boolean isCrossing(Crossable crossable) {
        return getIntersection(crossable) != null;
    }

    /**
     * Convenient method if a {@link Crossable} object is intersected or not.
     * 
     * @param crossable
     * @return boolean
     */
    public default boolean isNotCrossing(Crossable crossable) {
        return getIntersection(crossable) == null;
    }
}