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
 * Unit test for {@link Path}.
 *
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 25, 2018
 *
 */
public class PathTest {
    private List<Point> points = new ArrayList<Point>();
    private Path path;

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
        point = new Point(200,99);
        points.add(point);
        path = new Path(points);
    }

    /**
     * Test method for {@link .Path#getIntersection(.api.Crossable)}.
     */
    @Test
    public void testGetIntersection() {
        List<Point> intersection = new ArrayList<Point>();
        List<Point> expected = new ArrayList<Point>();
        Point point = new Point(50, 50);
        expected.add(point);

        Point start = new Point(1, 99);
        Point end = new Point(99, 1);
        Line anotherLine = new Line(start, end);
        intersection = new ArrayList<Point>(path.getIntersectionsPath(anotherLine));    //Normal Case, same case as polygon but only
        // 1 point of intersection since PATH.
        assertNotNull(intersection);
        assertEquals(expected.get(0), intersection.get(0));

        assertEquals(1, intersection.size());
        assertTrue(path.isCrossingPath(anotherLine));
        assertFalse(path.isNotCrossingPath(anotherLine));

        expected.clear();

        start = new Point(0, 50); //Normal case
        end = new Point(160, 50);
        Line shortLine = new Line(start, end);
        expected.add(new Point(50,50));
        expected.add(new Point(149,50));
        intersection = new ArrayList<Point>(path.getIntersectionsPath(shortLine));
        assertEquals(expected.get(0),intersection.get(0));
        assertEquals(expected.get(1),intersection.get(1));
        assertEquals(expected.size(),intersection.size());
        assertNotNull(path.getIntersectionsPath(shortLine));
        assertTrue(path.isCrossingPath(shortLine));
        assertFalse(path.isNotCrossingPath(shortLine));

        expected.clear();
        start = new Point(0,50);
        end = new Point(200 , 50);
        shortLine = new Line(start, end);

        Point intersectedPoint1 = new Point(50,50);
        Point intersectedPoint2 = new Point(149,50);
        Point intersectedPoint3 = new Point(199.5,50);
        expected.add(intersectedPoint1);
        expected.add(intersectedPoint2);
        expected.add(intersectedPoint3);

        intersection = new ArrayList<Point>(path.getIntersectionsPath(shortLine));   //Same case as polygon, but this has 3 intersections
        // Since its a path and not a closed polygon!
        assertEquals(expected.size(),intersection.size());
        assertEquals(expected.get(0),intersection.get(0));
        assertEquals(expected.get(1),intersection.get(1));
        assertEquals(expected.get(2),intersection.get(2));
    }

}