package com.peruselabs.peruse.client.widget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.peruselabs.peruse.shared.graphics.Point;

public class SVGItemsTest {
	
	private SVGItems svgitem;
	
	@Before
    public void setUp() throws Exception {
        svgitem = new SVGItems();
    }
	
	@Test
	public void testfindNearPointclose() {
		Point a = new Point(0, 0);
		Point b = new Point(100, 100);
		svgitem.AddPoints(a, b);
		Point testPoint = new Point(5, 5);
		
		Point result = svgitem.findnearPoint(testPoint);
		
		assertEquals(a, result);
	}
	
	@Test
	public void testfindNearPointsame() {
		Point a = new Point(0, 0);
		Point b = new Point(100, 100);
		svgitem.AddPoints(a, b);
		Point testPoint = new Point(0, 0);
		
		Point result = svgitem.findnearPoint(testPoint);
		
		assertEquals(a, result);
	}
	
	@Test
	public void testfindNearPointmiddle() {
		Point a = new Point(0, 0);
		Point b = new Point(100, 100);
		svgitem.AddPoints(a, b);
		Point testPoint = new Point(51, 51);
		
		Point result = svgitem.findnearPoint(testPoint);
		
		assertEquals(b, result);
	}
	
	@Test
	public void testfindNearPointnull() {
		Point testPoint = new Point(5, 5);
		
		Point result = svgitem.findnearPoint(testPoint);
		
		assertNull(result);
	}
	
	@Test
	public void testfindNearPointmany() {
		Point a = new Point(0, 0);
		Point b = new Point(100, 100);
		Point c = new Point(25, 25);
		Point d = new Point(75, 75);
		svgitem.AddPoints(a, b);
		svgitem.AddPoints(c, d);
		Point testPoint = new Point(85, 85);
		
		Point result = svgitem.findnearPoint(testPoint);
		
		assertEquals(d, result);
	}

}
