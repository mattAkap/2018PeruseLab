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

	public void AddPoints(Point startPoint, Point endPoint) {
		if (!Points.contains(startPoint))
			Points.add(startPoint);

		if (!Points.contains(endPoint))
			Points.add(endPoint);

		Line newLine = new Line(startPoint, endPoint);

		if (!Lines.contains(newLine))
			Lines.add(newLine);
		
		
	}
}
