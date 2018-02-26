package com.peruselabs.peruse.client.widget;



import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.peruselabs.peruse.shared.graphics.Point;

public class MouseResponse {
	
	private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";
	private Point start, end;
	private Element canvas, line, svgElement;
	private int height, width;

	
	public MouseResponse() {
		canvas = DOM.getElementById("canvas");

		svgElement = createElementNS(SVG_NAMESPACE, "svg");
		svgElement.setAttribute("width", "99%");
		svgElement.setAttribute("height", "99%");
		canvas.appendChild(svgElement);
	}
	
	public void startLine(int x, int y) {
		start = new Point(x, y);
		end = new Point(x, y);
		
		line = createElementNS(SVG_NAMESPACE, "line");
		line.setAttribute("x1", Double.toString(start.getX()));
		line.setAttribute("y1", Double.toString(start.getY()));
		line.setAttribute("x2", Double.toString(end.getX()));
		line.setAttribute("y2", Double.toString(end.getY()));
		line.setAttribute("style", "stroke:rgb(0,0,255);stroke-width:3");
		svgElement.appendChild(line);
		
	}
	
	public void updateLine(int x, int y) {
		end.setX(x);
		end.setY(y);
		
		line.setAttribute("x2", Double.toString(end.getX()));
		line.setAttribute("y2", Double.toString(end.getY()));
	}
	
	public void finishLine(int x, int y) {
		end.setX(x);
		end.setY(y);
		
		line.setAttribute("x2", Double.toString(end.getX()));
		line.setAttribute("y2", Double.toString(end.getY()));
	}
	
	private static native Element createElementNS(final String ns, 
	        final String name)/*-{
	    return document.createElementNS(ns, name);
	}-*/;

}
