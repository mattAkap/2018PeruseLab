/**
 * Copyright 2018 Velusamy K Velu.  Do not copy this source code or part of this
 * source without express permission from Velusamy K Velu (kool.velu@gmail.com).
 */
package com.peruselabs.peruse.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialContainer;

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

    public PeruseApp() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void add(Widget widget) {
        content.add(widget);
    }
}
