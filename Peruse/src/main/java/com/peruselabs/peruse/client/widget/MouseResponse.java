package com.peruselabs.peruse.client.widget;



import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.peruselabs.peruse.shared.graphics.Point;

public class MouseResponse {
	
	private static final String SVG_NAMESPACE = "http://www.w3.org/2000/svg";
	private Element canvas, line, svgElement, circle;
	private int height, width;
	private boolean circleOn = false;

	
	public MouseResponse() {
		canvas = DOM.getElementById("canvas");

		svgElement = createElementNS(SVG_NAMESPACE, "svg");
		svgElement.setAttribute("width", "98%");
		svgElement.setAttribute("height", "98%");
		canvas.appendChild(svgElement);
	}
	
	public void startLine(Point start, Point end) {		
		line = createElementNS(SVG_NAMESPACE, "line");
		line.setAttribute("x1", Double.toString(start.getX()));
		line.setAttribute("y1", Double.toString(start.getY()));
		line.setAttribute("x2", Double.toString(end.getX()));
		line.setAttribute("y2", Double.toString(end.getY()));
		line.setAttribute("style", "stroke:rgb(0,0,255);stroke-width:3");
		svgElement.appendChild(line);
		
	}
	
	public void updateLine(Point end) {

		line.setAttribute("x2", Double.toString(end.getX()));
		line.setAttribute("y2", Double.toString(end.getY()));
	}
	
	public void finishLine(Point end) {

		line.setAttribute("x2", Double.toString(end.getX()));
		line.setAttribute("y2", Double.toString(end.getY()));
	}
	
	public void showConnection(Point p) {
		if(!circleOn) {
			circle = createElementNS(SVG_NAMESPACE, "circle");
			circle.setAttribute("cx", Double.toString(p.getX()));
			circle.setAttribute("cy", Double.toString(p.getY()));
			circle.setAttribute("r", "5");
			circle.setAttribute("style", "stroke:rgb(0,0,255);stroke-width:3;fill:rgb(0,0,255)");
			svgElement.appendChild(circle);
			circleOn = true;
		}
	}
	public void endConnection() {
		if(circleOn) {
			svgElement.removeChild(circle);
			circleOn = false;
		}
	}
	
	private static native Element createElementNS(final String ns, 
	        final String name)/*-{
	    return document.createElementNS(ns, name);
	}-*/;

}
