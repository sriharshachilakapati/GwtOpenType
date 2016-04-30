package com.shc.gwtopentype;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;

/**
 * A Glyph is an individual mark that often corresponds to a character. Some glyphs, such as ligatures, are a
 * combination of many characters. Glyphs are the basic building blocks of a font.
 *
 * @author Sri Harsha Chilakapati
 */
public class Glyph extends JavaScriptObject
{
    protected Glyph()
    {
    }

    /**
     * Convert the glyph to a Path we can draw on a drawing context.
     *
     * @return The Path object which can be drawn on the canvas.
     */
    public final native Path getPath() /*-{
        return this.getPath(0, 0, 72);
    }-*/;

    /**
     * Convert the glyph to a Path we can draw on a drawing context.
     *
     * @param x Horizontal position of the glyph.
     * @param y Vertical position of the {@code baseline} of the glyph.
     *
     * @return The Path object which can be drawn on the canvas.
     */
    public final native Path getPath(double x, double y) /*-{
        return this.getPath(x, y, 72);
    }-*/;

    /**
     * Convert the glyph to a Path we can draw on a drawing context.
     *
     * @param x        Horizontal position of the glyph.
     * @param y        Vertical position of the {@code baseline} of the glyph.
     * @param fontSize Font size, in pixels.
     *
     * @return The Path object which can be drawn on the canvas.
     */
    public final native Path getPath(double x, double y, int fontSize) /*-{
        return this.getPath(x, y, fontSize);
    }-*/;

    /**
     * Draw the glyph on the given context.
     *
     * @param ctx The 2D rendering context of a canvas to draw the glyph.
     */
    public final native void draw(Context2d ctx) /*-{
        this.draw(ctx, 0, 0, 72);
    }-*/;

    /**
     * Draw the glyph on the given context.
     *
     * @param ctx The 2D rendering context of a canvas to draw the glyph.
     * @param x   Horizontal position of the glyph.
     * @param y   Vertical position of the {@code baseline} of the glyph.
     */
    public final native void draw(Context2d ctx, double x, double y) /*-{
        this.draw(ctx, x, y, 72);
    }-*/;

    /**
     * Draw the glyph on the given context.
     *
     * @param ctx      The 2D rendering context of a canvas to draw the glyph.
     * @param x        Horizontal position of the glyph.
     * @param y        Vertical position of the {@code baseline} of the glyph.
     * @param fontSize Font size, in pixels.
     */
    public final native void draw(Context2d ctx, double x, double y, int fontSize) /*-{
        this.draw(ctx, x, y, fontSize);
    }-*/;

    /**
     * Draw the points of the glyph. On-curve points will be drawn in blue, off-curve points will be drawn in red.
     *
     * @param ctx The 2D rendering context of a canvas to draw the glyph points.
     */
    public final native void drawPoints(Context2d ctx) /*-{
        this.drawPoints(ctx, 0, 0, 72);
    }-*/;

    /**
     * Draw the points of the glyph. On-curve points will be drawn in blue, off-curve points will be drawn in red.
     *
     * @param ctx The 2D rendering context of a canvas to draw the glyph points.
     * @param x   Horizontal position of the glyph.
     * @param y   Vertical position of the {@code baseline} of the glyph.
     */
    public final native void drawPoints(Context2d ctx, double x, double y) /*-{
        this.drawPoints(ctx, x, y, 72);
    }-*/;

    /**
     * Draw the points of the glyph. On-curve points will be drawn in blue, off-curve points will be drawn in red.
     *
     * @param ctx      The 2D rendering context of a canvas to draw the glyph points.
     * @param x        Horizontal position of the glyph.
     * @param y        Vertical position of the {@code baseline} of the glyph.
     * @param fontSize Font size, in pixels.
     */
    public final native void drawPoints(Context2d ctx, double x, double y, int fontSize) /*-{
        this.drawPoints(ctx, x, y, fontSize);
    }-*/;

    /**
     * Draw lines indicating important font measurements. Black lines indicate the origin of the coordinate system
     * (point 0,0). Blue lines indicate the glyph bounding box. Green line indicates the advance width of the glyph.
     *
     * @param ctx      The 2D rendering context of a canvas to draw the glyph metrics.
     */
    public final native void drawMetrics(Context2d ctx) /*-{
        this.drawMetrics(ctx, 0, 0, 72);
    }-*/;

    /**
     * Draw lines indicating important font measurements. Black lines indicate the origin of the coordinate system
     * (point 0,0). Blue lines indicate the glyph bounding box. Green line indicates the advance width of the glyph.
     *
     * @param ctx      The 2D rendering context of a canvas to draw the glyph metrics.
     * @param x        Horizontal position of the glyph.
     * @param y        Vertical position of the {@code baseline} of the glyph.
     */
    public final native void drawMetrics(Context2d ctx, double x, double y) /*-{
        this.drawMetrics(ctx, x, y, 72);
    }-*/;

    /**
     * Draw lines indicating important font measurements. Black lines indicate the origin of the coordinate system
     * (point 0,0). Blue lines indicate the glyph bounding box. Green line indicates the advance width of the glyph.
     *
     * @param ctx      The 2D rendering context of a canvas to draw the glyph metrics.
     * @param x        Horizontal position of the glyph.
     * @param y        Vertical position of the {@code baseline} of the glyph.
     * @param fontSize Font size, in pixels.
     */
    public final native void drawMetrics(Context2d ctx, double x, double y, int fontSize) /*-{
        this.drawMetrics(ctx, x, y, fontSize);
    }-*/;

    /**
     * Calculate the xMin/yMin/xMax/yMax/lsb/rsb for a Glyph.
     *
     * @return The Metrics object for this Glyph.
     */
    public final native Metrics getMetrics() /*-{
        return this.getMetrics();
    }-*/;

    /**
     * Returns the raw, unscaled path used by this Glyph.
     *
     * @return The raw, unscaled Path object of this Glyph.
     */
    public final native Path getRawPath() /*-{
        return this.path;
    }-*/;

    /**
     * Sets the path used by this glyph.
     *
     * @param path The new path object containing the Glyph data.
     */
    public final native void setPath(Path path) /*-{
        this.path = path;
    }-*/;

    public final native Font getFont() /*-{
        return this.font;
    }-*/;

    public final native String getName() /*-{
        return this.name;
    }-*/;

    public final native int getUnicode() /*-{
        return this.unicode;
    }-*/;

    public final native JsArrayInteger getUnicodes() /*-{
        return this.unicodes;
    }-*/;

    public final native int getIndex() /*-{
        return this.index;
    }-*/;

    /**
     * Returns the width to advance the pen when drawing this Glyph.
     *
     * @return The width to advance the pen when drawing this Glyph.
     */
    public final native double getAdvanceWidth() /*-{
        return this.advanceWidth;
    }-*/;

    public final native JsArray<JavaScriptObject> getContours() /*-{
        return this.getContours();
    }-*/;
}
