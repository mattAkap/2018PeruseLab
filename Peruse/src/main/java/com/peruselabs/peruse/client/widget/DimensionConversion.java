package com.peruselabs.peruse.client.widget;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.peruselabs.peruse.shared.graphics.Line;
import com.peruselabs.peruse.shared.graphics.ParallaxScene;
import com.peruselabs.peruse.shared.graphics.Point;

public class DimensionConversion {
	
	private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";

	public void convertTo3D(SVGItems items, ParallaxScene scene) {
		for(int i = 0; i < items.Lines.size(); i++) {
			Line temp = items.Lines.get(i);
			Point start = temp.getStart();
			Point end = temp.getEnd();
			if(!scene.svg_items.contains(temp)) {
				scene.drawKey(start.getX(), start.getY(), end.getX(), end.getY());
			}
		}
	}
	
	public void convertTo2D(SVGItems items) {
		Element svgcanvas = DOM.getElementById("svg_canvas");
		svgcanvas.removeAllChildren();
		for(int i = 0; i < items.Lines.size(); i++) {
			Element line = createElementNS(SVG_NAMESPACE, "line");
			Point start = items.Lines.get(i).getStart();
			Point end = items.Lines.get(i).getEnd();
			line.setAttribute("x1", Double.toString(start.getY()));
			line.setAttribute("y1", Double.toString(start.getY()));
			line.setAttribute("x2", Double.toString(end.getX()));
			line.setAttribute("y2", Double.toString(end.getY()));
			line.setAttribute("style", "stroke:rgb(0,0,255);stroke-width:3");
			svgcanvas.appendChild(line);
		}
	}
	
	private static native Element createElementNS(final String ns, 
	        final String name)/*-{
	    return document.createElementNS(ns, name);
	}-*/;
}
