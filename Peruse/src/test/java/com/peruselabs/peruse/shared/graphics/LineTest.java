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
        assertEquals(expected, actual);
        assertTrue(line.isCrossing(anotherLine));
        assertFalse(line.isNotCrossing(anotherLine));

        start = new Point(5, 5);
        end = new Point(5, 10, 5);
        Line shortLine = new Line(start, end);
        assertNull(line.getIntersection(shortLine));
        assertFalse(line.isCrossing(shortLine));
        assertTrue(line.isNotCrossing(shortLine));
    }
}
