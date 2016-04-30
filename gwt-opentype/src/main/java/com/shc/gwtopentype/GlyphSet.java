package com.shc.gwtopentype;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Sri Harsha Chilakapati
 */
public class GlyphSet extends JavaScriptObject
{
    protected GlyphSet()
    {
    }

    public final native Glyph get(int index) /*-{
        return this.get(index);
    }-*/;

    public final native int length() /*-{
        return this.length;
    }-*/;

    public final native Font getFont() /*-{
        return this.font;
    }-*/;
}
