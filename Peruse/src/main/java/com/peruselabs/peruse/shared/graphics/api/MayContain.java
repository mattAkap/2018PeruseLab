/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics.api;

import com.peruselabs.peruse.shared.graphics.Point;

/**
 * Defines the API for the .
 * 
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 25, 2018
 *
 */
public interface MayContain {
    /**
     * Determines if aPoint is in side a polygon or not. Example:
     * <img src="https://goo.gl/QhxaEH"/>.
     * 
     * @param aPoint
     * @return
     */
    public boolean contains(Point aPoint);
    
   
    /**
     * Convenient method to verify the {@link MayContain} doesn't have aPoint
     * inside.
     * 
     * @param aPoint
     * @return boolean
     */
    public default boolean notContains(Point aPoint) {
        return !contains(aPoint);
    }
}
