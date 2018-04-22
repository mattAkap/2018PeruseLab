/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.peruselabs.peruse.shared.graphics.ParallaxScene;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialPanel;
import thothbot.parallax.core.client.RenderingPanel;

/**
 * The main container of the application.
 * 
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 22, 2018
 *
 */
public class PeruseApp extends Composite {

    private static PeruseAppUiBinder uiBinder = GWT.create(PeruseAppUiBinder.class);
    private SVGItems items;

    interface PeruseAppUiBinder extends UiBinder<Widget, PeruseApp> {
    }   
    
    @UiField
    MaterialContainer content;
    
    @UiField
    MaterialPanel paper;
    
    @UiField
    MaterialButton button3d;
    
    @UiField
    MaterialButton button2d;
    
    private boolean is3d = false;
    private ParallaxScene scene;
    private RenderingPanel renderingPanel;

    public PeruseApp() {
        initWidget(uiBinder.createAndBindUi(this));
        
        //All of the line/points/polygons of the session
        items = new SVGItems();
        
        paper.setId("canvas");
        MouseListener mouselistener = new MouseListener(items, is3d);
        
        paper.addDomHandler(mouselistener, MouseDownEvent.getType());
        paper.addDomHandler(mouselistener, MouseMoveEvent.getType());
        paper.addDomHandler(mouselistener, MouseUpEvent.getType());
    
        //Rendering Panel for 3D
        renderingPanel = new RenderingPanel();
		renderingPanel.setBackground(0xcccccc);
		renderingPanel.setHeight("99%");
		renderingPanel.setWidth("99%");
		scene = new ParallaxScene();
		renderingPanel.setAnimatedScene(scene);
		paper.add(renderingPanel);
		
        button3d.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Element svgcanvas = DOM.getElementById("svg_canvas");
				
				if(svgcanvas != null)
					svgcanvas.setAttribute("visibility", "hidden");
				
				renderingPanel.setVisible(true);
				DimensionConversion dc = new DimensionConversion();
				dc.convertTo3D(mouselistener.getsvg_items(), scene);
			}
        });
        
        button2d.addClickHandler(new ClickHandler() {
        	
			@Override
			public void onClick(ClickEvent event) {
				Element svgcanvas = DOM.getElementById("svg_canvas");
				if(svgcanvas != null)
					svgcanvas.removeAttribute("visibility");
				
				renderingPanel.setVisible(false);
			}
        });
    }

    public void add(Widget widget) {
        content.add(widget);
    }
}
