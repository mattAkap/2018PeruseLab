package com.peruselabs.peruse.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.peruselabs.peruse.client.widget.PeruseApp;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Peruse implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        PeruseApp app = new PeruseApp();
        RootPanel.get("appHolder").add(app);
    }
}
