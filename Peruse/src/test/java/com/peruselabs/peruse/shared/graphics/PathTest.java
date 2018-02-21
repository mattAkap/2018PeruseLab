/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics;

import static org.junit.Assert.*;

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
    private List<Point> points;
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
        path = new Path(points);
    }

    /**
     * Test method for {@link .Path#getIntersection(.api.Crossable)}.
     */
    @Test
    public void testGetIntersection() {
        Point start = new Point(1, 99);
        Point end = new Point(99, 1);
        Line anotherLine = new Line(start, end);
        Point actual = path.getIntersection(anotherLine);

        Point expected = new Point(50, 50);
        assertNotNull(actual);
        assertEquals(expected, actual);
        assertTrue(path.isCrossing(anotherLine));
        assertFalse(path.isNotCrossing(anotherLine));

        start = new Point(5, 5);
        end = new Point(5, 10, 5);
        Line shortLine = new Line(start, end);
        assertNull(path.getIntersection(shortLine));
        assertFalse(path.isCrossing(shortLine));
        assertTrue(path.isNotCrossing(shortLine));
    }
}
