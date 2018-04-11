package com.peruselabs.peruse.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.peruselabs.peruse.client.widget.SVGItems;
import com.peruselabs.peruse.shared.graphics.Point;

/**
 * Unit test for {@link SVGItems}.
 * 
 * @author Matt Kaplan
 *
 * @since April 9th, 2018
 *
 */
public class SVGItemsTest {
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testAddALineToEmptySVGItems() {
		SVGItems svgItems = new SVGItems();
		Point newPoint1 = new Point(0, 0);
		Point newPoint2 = new Point(10, 10);

		svgItems.AddPoints(newPoint1, newPoint2);
		
		assertEquals(svgItems.Points.size(), 2);
		assertEquals(svgItems.Lines.size(), 1);
	}
	
	@Test
	public void testAddALineToTheEndOfAnotherLine() {
		SVGItems svgItems = new SVGItems();
		Point newPoint1 = new Point(0, 0);
		Point newPoint2 = new Point(10, 10);
		Point newPoint3 = new Point(20, 20);
		
		svgItems.AddPoints(newPoint1, newPoint2);
		svgItems.AddPoints(newPoint2, newPoint3);
		
		assertEquals(svgItems.Points.size(), 3);
		assertEquals(svgItems.Lines.size(), 2);
	}
	
	@Test
	public void testAddTwoUnconnectedLines() {
		SVGItems svgItems = new SVGItems();
		Point newPoint1 = new Point(0, 0);
		Point newPoint2 = new Point(10, 10);
		Point newPoint3 = new Point(20, 20);
		Point newPoint4 = new Point(30, 30);
		
		svgItems.AddPoints(newPoint1, newPoint2);
		svgItems.AddPoints(newPoint3, newPoint4);
		
		assertEquals(svgItems.Points.size(), 4);
		assertEquals(svgItems.Lines.size(), 2);
	}
	
	@Test
	public void testConnectedTwoLinesWithAnotherLine() {
		SVGItems svgItems = new SVGItems();
		Point newPoint1 = new Point(0, 0);
		Point newPoint2 = new Point(10, 10);
		Point newPoint3 = new Point(20, 20);
		Point newPoint4 = new Point(30, 30);
		
		svgItems.AddPoints(newPoint1, newPoint2);
		svgItems.AddPoints(newPoint3, newPoint4);
		
		assertEquals(svgItems.Points.size(), 4);
		assertEquals(svgItems.Lines.size(), 2);
		
		svgItems.AddPoints(newPoint2, newPoint3);
		
		assertEquals(svgItems.Points.size(), 4);
		assertEquals(svgItems.Lines.size(), 3);
	}
	
	@Test
	public void testAddALineThatCreatesABranchingPath() {
		SVGItems svgItems = new SVGItems();
		Point newPoint1 = new Point(0, 0);
		Point newPoint2 = new Point(10, 10);
		Point newPoint3 = new Point(20, 20);
		Point newPoint4 = new Point(30, 30);
		Point newPoint5 = new Point(0, 10);
		
		svgItems.AddPoints(newPoint1, newPoint2);
		svgItems.AddPoints(newPoint2, newPoint3);
		svgItems.AddPoints(newPoint3, newPoint4);
		
		assertEquals(svgItems.Points.size(), 4);
		assertEquals(svgItems.Lines.size(), 3);
		
		svgItems.AddPoints(newPoint2, newPoint5);
		
		assertEquals(svgItems.Points.size(), 5);
		assertEquals(svgItems.Lines.size(), 4);
	}
	
	@Test
	public void testAddAPolygon() {
		SVGItems svgItems = new SVGItems();
		Point newPoint1 = new Point(0, 0);
		Point newPoint2 = new Point(10, 10);
		Point newPoint3 = new Point(20, 20);
		
		svgItems.AddPoints(newPoint1, newPoint2);
		svgItems.AddPoints(newPoint2, newPoint3);
		svgItems.AddPoints(newPoint3, newPoint1);
		
		assertEquals(svgItems.Points.size(), 3);
		assertEquals(svgItems.Lines.size(), 3);
	}
	
	@Test
	public void testAddALineOffAPolygon() {
		SVGItems svgItems = new SVGItems();
		Point newPoint1 = new Point(0, 0);
		Point newPoint2 = new Point(10, 10);
		Point newPoint3 = new Point(20, 20);
		Point newPoint4 = new Point(0, 10);
		
		svgItems.AddPoints(newPoint1, newPoint2);
		svgItems.AddPoints(newPoint2, newPoint3);
		svgItems.AddPoints(newPoint3, newPoint1);
		
		assertEquals(svgItems.Points.size(), 3);
		assertEquals(svgItems.Lines.size(), 3);
		
		svgItems.AddPoints(newPoint2, newPoint4);
		
		assertEquals(svgItems.Points.size(), 4);
		assertEquals(svgItems.Lines.size(), 4);
	}
}
