package com.shc.gwtopentype;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Sri Harsha Chilakapati
 */
public class Metrics extends JavaScriptObject
{
    protected Metrics()
    {
    }

    public final native double getXMin() /*-{
        return this.xMin;
    }-*/;

    public final native double getXMax() /*-{
        return this.xMax;
    }-*/;

    public final native double getYMin() /*-{
        return this.yMin;
    }-*/;

    public final native double getYMax() /*-{
        return this.yMax;
    }-*/;

    public final native double getLeftSideBearing() /*-{
        return this.leftSideBearing;
    }-*/;

    public final native double getRightSideBearing() /*-{
        return this.rightSideBearing;
    }-*/;
}
