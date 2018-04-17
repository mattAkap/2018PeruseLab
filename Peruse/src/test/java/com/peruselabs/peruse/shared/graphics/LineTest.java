/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.shared.graphics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link Line}.
 *
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 25, 2018
 *
 */
public class LineTest {
    private Line line;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        Point start = new Point(1, 1);
        Point end = new Point(99, 99);
        line = new Line(start, end);
    }

    /**
     * Test method for
     * {@link com.peruselabs.peruse.shared.graphics.Line#getIntersection(com.peruselabs.peruse.shared.graphics.api.Crossable)}.
     */
    @Test
    public void testGetIntersection() {
        Point start = new Point(1, 99);
        Point end = new Point(99, 1);
        Line anotherLine = new Line(start, end);

        Point expected = new Point(50, 50);
        Point actual = line.getIntersection(anotherLine);

        assertNotNull(actual);
        assertEquals(expected, actual);  //1st test case

        start = new Point(35, 56);
        end = new Point(43, 67);
        anotherLine = new Line(start, end);
        actual = line.getIntersection(anotherLine);
        assertNull(actual);  //2nd test case

        start = new Point(50, 0);
        end = new Point(50, 60);
        anotherLine = new Line(start, end);
        expected = new Point(50, 50);
        actual = line.getIntersection(anotherLine);
        assertEquals(expected, actual);
        assertNotNull(actual);  //3rd test case

        start = new Point(99, 0);
        end = new Point(43, 70);
        anotherLine = new Line(start, end);
        expected = new Point(54, 54);
        actual = line.getIntersection(anotherLine);
        assertEquals(expected, actual);
        assertNotNull(actual);  //4th test case This case results in 53.999999 and 54. Works for double and odd values.

        assertTrue(line.isCrossing(anotherLine));
        assertFalse(line.isNotCrossing(anotherLine));

        start = new Point(5, 5);     //This originally said asserNull but this graph does infact intersect when I plotted it.
        end = new Point(5, 10);
        Line shortLine = new Line(start, end);
        assertNotNull(line.getIntersection(shortLine));
        assertTrue(line.isCrossing(shortLine));
        assertFalse(line.isNotCrossing(shortLine));
    }
}

