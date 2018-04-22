package com.peruselabs.peruse.client.widget;

import com.google.gwt.event.dom.client.HandlesAllMouseEvents;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.peruselabs.peruse.shared.graphics.Point;

public class MouseListener extends HandlesAllMouseEvents{

	private boolean dragging;
	private boolean created = false;
	private boolean is3d;
	private MouseResponse mouseResponse;
	private SVGItems svg_items;
	private Point start, end, neighbor;
	
	public MouseListener(SVGItems items, boolean dimension) {
		svg_items = items;
		is3d = dimension;
	}
	
	@Override
	public void onMouseDown(MouseDownEvent event) {
		if(!is3d) {
			if(created==false) {
				mouseResponse = new MouseResponse();
				created = true;
			}
			
			int x = event.getX();
			int y = event.getY();
			start = new Point(x, y);
			end = new Point(x, y);
			
			if(neighbor != null) {
				start.setX(neighbor.getX());
				start.setY(neighbor.getY());
				end.setX(neighbor.getX());
				end.setY(neighbor.getY());
				mouseResponse.endConnection();
			}
			
			mouseResponse.startLine(start, end);
		
			dragging = true;
		}
	}

	@Override
	public void onMouseUp(MouseUpEvent event) {
		if(!is3d) {
			int x = event.getX();
			int y = event.getY();
			end.setX(x);
			end.setY(y);
			
			if(neighbor != null) {
				end.setX(neighbor.getX());
				end.setY(neighbor.getY());
				mouseResponse.endConnection();
			}
			
			mouseResponse.finishLine(end);
			svg_items.AddPoints(start, end);
			dragging = false;
		}
	}

	@Override
	public void onMouseMove(MouseMoveEvent event) {
		if(!is3d) {
			int x = event.getX();
			int y = event.getY();
			
			Point p = new Point(x,y);
	
			neighbor = svg_items.findnearPoint(p);
			
			if(neighbor != null)
				mouseResponse.showConnection(p);
			else
				mouseResponse.endConnection();
	
			if(dragging) {
				end.setX(x);
				end.setY(y);
				
				if(neighbor != null) {
					end.setX(neighbor.getX());
					end.setY(neighbor.getY());
				}
				
				mouseResponse.updateLine(end);
			}
		}
	}

	@Override
	public void onMouseOut(MouseOutEvent event) {
		// Not needed for this project
	}

	@Override
	public void onMouseOver(MouseOverEvent event) {
		// Not needed for this project
	}

	@Override
	public void onMouseWheel(MouseWheelEvent event) {
		// Not needed for this project
	}
	
	public void setis3d(boolean x) {
		is3d = x;
	}
	
	public SVGItems getsvg_items() {
		return this.svg_items;
	}
}
