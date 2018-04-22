package com.peruselabs.peruse.client.widget;

import java.util.ArrayList;
import java.util.List;

import com.peruselabs.peruse.shared.graphics.*;
import com.peruselabs.peruse.shared.graphics.Point;

public class SVGItems {
	public List<Point> Points;
	public List<Line> Lines;
	public List<Polygon> Polygons;
	public List<Path> Paths;

	public SVGItems() {
		Points = new ArrayList<Point>();
		Lines = new ArrayList<Line>();
		Polygons = new ArrayList<Polygon>();
		Paths = new ArrayList<Path>();
	}
	
	public boolean contains(Line l) {
		boolean res = false;
		
		for(int i = 0; i<Lines.size(); i++) {
			if(Lines.get(i).equals(l))
				res = true;
		}
		
		return res;
	}

	public void AddPoints(Point startPoint, Point endPoint) {
		if (!Points.contains(startPoint))
			Points.add(startPoint);

		if (!Points.contains(endPoint))
			Points.add(endPoint);

		Line newLine = new Line(startPoint, endPoint);

		if (!Lines.contains(newLine))
			Lines.add(newLine);
	}
	
	public Point findnearPoint(Point p1) {
		Point neighbor = null;
		double min_distance = 1000, distance;
		int index = -1;
		
		for(int i = 0; i < Points.size();i++) {
			Point p2 = Points.get(i);
			distance = Math.sqrt(Math.pow(p1.getX()-p2.getX(), 2) + Math.pow(p1.getY()-p2.getY(), 2));
			
			if(distance < min_distance) {
				min_distance = distance;
				index = i;
			}
		}
		
		if(index != -1)
			neighbor = Points.get(index);
		
		return neighbor;
	}
}
