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

        point = new Point(50, 50); //Normal case
        assertTrue(polygon.contains(point));
        point = new Point(1000, 1000);        //Normal case
        assertFalse(polygon.contains(point));

        point = new Point(1,1); //Boundary case
        assertFalse(polygon.contains(point));

        point = new Point(199,2); //Special Case
        assertTrue(polygon.contains(point));

        //All test cases pass, the algorithm works sufficiently.
    }

    /**
     * Test method for {@link .Polygon#getIntersection(.api.Crossable)}.
     */
    @Test
    public void testGetIntersection() {
        Point start = new Point(1, 99);
        Point end = new Point(99, 1);
        Line aLine = new Line(start, end);
        List<Point> intersection;

        intersection = new ArrayList<Point>(polygon.getIntersections(aLine)); //Normal Case
        assertNotNull(intersection);

        start = new Point(5, 0);
        end = new Point(5, 40);
        aLine = new Line(start, end);

        intersection = new ArrayList<Point>(polygon.getIntersections(aLine)); //Normal Case
        assertNotNull(intersection);

        start = new Point(-1, -1);
        end = new Point(-5, -5);
        aLine = new Line(start, end);

        intersection = polygon.getIntersections(aLine); //Normal Case
        assertNull(intersection);

        start = new Point(0,0);
        end = new Point(0 , 99);
        aLine = new Line(start, end);

        intersection = polygon.getIntersections(aLine); //Boundary Case
        assertNull(intersection);

        start = new Point(1.5,1.5);
        end = new Point(1.5 , 99);
        aLine = new Line(start, end);

        intersection = polygon.getIntersections(aLine); //Special Case
        assertNotNull(intersection);
    }

}