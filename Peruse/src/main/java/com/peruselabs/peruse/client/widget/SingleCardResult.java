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

import gwt.material.design.client.ui.MaterialImage;

/**
 * This is to hold results in a single card.
 * 
 * @author Velusamy K. Velu (kool.velu@gmail.com)
 *
 * @since Jan 24, 2018
 *
 */
public class SingleCardResult extends Composite {
    public static final int STD_CARD_WIDTH = 350; // DPI
    public static final int STD_CARD_HIGHT = 200; // DPI

    interface SingleCardResultUiBinder extends UiBinder<Widget, SingleCardResult> {
    }

    private static SingleCardResultUiBinder uiBinder = GWT.create(SingleCardResultUiBinder.class);

    @UiField
    MaterialImage resultImage;

    public SingleCardResult() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public SingleCardResult(String url) {
        initWidget(uiBinder.createAndBindUi(this));
        addImage(url, STD_CARD_WIDTH, STD_CARD_HIGHT);
    }

    public SingleCardResult(String url, int width, int height) {
        initWidget(uiBinder.createAndBindUi(this));
        addImage(url, width, height);
    }

    public void addImage(String url, int width, int height) {
        resultImage.setUrl(url);
        resultImage.setWidth(width + "px");
        resultImage.setHeight(height + "px");
    }
}
