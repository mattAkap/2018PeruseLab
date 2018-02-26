package com.peruselabs.peruse.client.widget;



import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.HandlesAllMouseEvents;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.user.client.DOM;
import com.peruselabs.peruse.shared.graphics.Point;

public class MouseListener extends HandlesAllMouseEvents{

	private boolean dragging;
	private boolean created = false;
	private MouseResponse mouseResponse;
	
	@Override
	public void onMouseDown(MouseDownEvent event) {
		if(created==false) {
			mouseResponse = new MouseResponse();
			created = true;
		}
		
		int x = event.getX();
		int y = event.getY();
		mouseResponse.startLine(x, y);
	
		dragging = true;
		
		
	}

	@Override
	public void onMouseUp(MouseUpEvent event) {
		int x = event.getX();
		int y = event.getY();
		mouseResponse.finishLine(x, y);
		dragging = false;

				
	}

	@Override
	public void onMouseMove(MouseMoveEvent event) {
		int x = event.getX();
		int y = event.getY();
		if(dragging) {
			mouseResponse.updateLine(x, y);
		}
		
	}

	@Override
	public void onMouseOut(MouseOutEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseOver(MouseOverEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseWheel(MouseWheelEvent event) {
		// TODO Auto-generated method stub
		
	}

}
