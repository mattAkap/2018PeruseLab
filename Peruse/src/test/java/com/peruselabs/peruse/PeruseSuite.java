package com.peruselabs.peruse;

import com.peruselabs.peruse.client.PeruseTest;
import com.google.gwt.junit.tools.GWTTestSuite;
import junit.framework.Test;
import junit.framework.TestSuite;

public class PeruseSuite extends GWTTestSuite {
    public static Test suite() {
        TestSuite suite = new TestSuite("Tests for Peruse");
        suite.addTestSuite(PeruseTest.class);
        return suite;
    }
}
