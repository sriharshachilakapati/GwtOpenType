package com.shc.gwtopentype;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Sri Harsha Chilakapati
 */
public class Options extends JavaScriptObject
{
    protected Options()
    {
    }

    public static native Options create() /*-{
        return { kerning: true };
    }-*/;
}
