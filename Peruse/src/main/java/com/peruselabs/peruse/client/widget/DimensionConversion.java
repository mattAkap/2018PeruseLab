package com.peruselabs.peruse.client.widget;

import com.peruselabs.peruse.shared.graphics.Line;
import com.peruselabs.peruse.shared.graphics.ParallaxScene;
import com.peruselabs.peruse.shared.graphics.Point;

public class DimensionConversion {
	
	public void convertTo3D(SVGItems items, ParallaxScene scene) {
		for(int i = 0; i < items.Lines.size(); i++) {
			Line temp = items.Lines.get(i);
			Point start = temp.getStart();
			Point end = temp.getEnd();
			if(!scene.svg_items.contains(temp)) {
				scene.drawKey(start.getX(), start.getY(), end.getX(), end.getY());
			}
		}
		
	}

}
