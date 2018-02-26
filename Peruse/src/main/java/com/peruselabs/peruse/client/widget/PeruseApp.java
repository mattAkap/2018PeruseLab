/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialPanel;

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

    interface PeruseAppUiBinder extends UiBinder<Widget, PeruseApp> {
    }   
    
    @UiField
    MaterialContainer content;
    
    @UiField
    MaterialPanel paper;

    public PeruseApp() {
        initWidget(uiBinder.createAndBindUi(this));
        paper.setId("canvas");
        MouseListener mouselistener = new MouseListener();
        paper.addDomHandler(mouselistener, MouseDownEvent.getType());
        paper.addDomHandler(mouselistener, MouseMoveEvent.getType());
        paper.addDomHandler(mouselistener, MouseUpEvent.getType());
        paper.addDomHandler(mouselistener, MouseOverEvent.getType());
    }

    public void add(Widget widget) {
        content.add(widget);
    }
    
}
