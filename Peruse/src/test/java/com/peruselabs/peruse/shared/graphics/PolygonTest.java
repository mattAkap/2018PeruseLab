/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link Polygon}.
 * 
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 25, 2018
 *
 */
public class PolygonTest {
	protected List<Point> points = new ArrayList<Point>(); 

    private Polygon polygon;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        Point point = new Point(1, 1);
        points.add(point);
        point = new Point(99, 99);

        points.add(point);
        point = new Point(199, 1);
        points.add(point);
        polygon = new Polygon(points);
    }

    /**
     * Test method for {@link .Polygon#contains(.Point)}.
     */
    @Test
    public void testContains() {
        Point point = new Point(2, 2);
        assertTrue(polygon.contains(point));
        point = new Point();
        assertFalse(polygon.contains(point));

        point = new Point(50, 50);
        assertTrue(polygon.contains(point));
        point = new Point(75, 75);
        assertFalse(polygon.contains(point));
    }

    /**
     * Test method for {@link .Polygon#getIntersection(.api.Crossable)}.
     */
    @Test
    public void testGetIntersection() {
        Point start = new Point(1, 99);
        Point end = new Point(99, 1);
        Line aLine = new Line(start, end);
        Point intersection = polygon.getIntersection(aLine);

        assertNotNull(intersection);
    }
}
