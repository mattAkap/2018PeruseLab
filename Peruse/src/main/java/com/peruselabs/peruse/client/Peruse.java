package com.peruselabs.peruse.client;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;
import com.peruselabs.peruse.client.widget.PeruseApp;
import com.peruselabs.peruse.client.widget.SVGItems;
import com.peruselabs.peruse.client.widget.SingleCardResult;
import com.peruselabs.peruse.shared.graphics.Point;

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
        SVGItems items = new SVGItems();
        //Element canvas = DOM.getElementById("canvas");
        
        /*SingleCardResult result = new SingleCardResult("images/bonds/singleBond.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/hydrogenBond.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/projectedToYou.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/projectedAway.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/addElement.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/benzene.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloButadiene.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloButane.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloButene.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloHeptane.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloHexadiene1.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloHexadiene2.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloHexane.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloHexene.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloPentadiene.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloPentane.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloPentene.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloPropane.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/cycloPropene.svg");
        app.add(result);
        result = new SingleCardResult("images/bonds/templates/flexibleCycloAlkane.svg");
        app.add(result);
        result = new SingleCardResult("images/Adamentane-sample.svg");
        app.add(result);
        result = new SingleCardResult("images/Adamentane-sample.svg");
        app.add(result);
        result = new SingleCardResult("images/Adamentane-sample.svg");
        app.add(result);
        result = new SingleCardResult("images/Adamentane-sample.svg");
        app.add(result);
        result = new SingleCardResult("images/Adamentane-sample.svg");
        app.add(result);
        result = new SingleCardResult("images/Adamentane-sample.svg");
        app.add(result);
        result = new SingleCardResult("images/Adamentane-sample.svg");
        app.add(result);*/
    }
}
