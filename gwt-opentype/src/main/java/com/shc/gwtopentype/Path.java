package com.shc.gwtopentype;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * A bézier path containing a set of path commands similar to a SVG path.
 *
 * @author Sri Harsha Chilakapati
 */
public class Path extends JavaScriptObject
{
    protected Path()
    {
    }

    /**
     * Draw the path to a 2D context.
     *
     * @param context The 2D context to draw the path onto.
     */
    public final native void draw(Context2d context) /*-{
        this.draw(context);
    }-*/;

    /**
     * Convert the Path to a string of path data instructions. See <a href="http://www.w3.org/TR/SVG/paths.html#PathData">
     * http://www.w3.org/TR/SVG/paths.html#PathData</a> with 2 decimal places.
     *
     * @return The SVG path data string.
     */
    public final native String toPathData() /*-{
        return this.toPathData(2);
    }-*/;

    /**
     * Convert the Path to a string of path data instructions. See <a href="http://www.w3.org/TR/SVG/paths.html#PathData">
     * http://www.w3.org/TR/SVG/paths.html#PathData</a>.
     *
     * @param decimalPlaces The amount of decimal places for floating-point values.
     *
     * @return The SVG path data string.
     */
    public final native String toPathData(double decimalPlaces) /*-{
        return this.toPathData(decimalPlaces);
    }-*/;

    /**
     * Convert the path to a SVG {@code <path>} element, as a string with two decimal places.
     *
     * @return The SVG path object.
     */
    public final native String toSVG() /*-{
        return this.toSVG(2);
    }-*/;

    /**
     * Convert the path to a SVG {@code <path>} element, as a string.
     *
     * @param decimalPlaces The amount of decimal places for floating-point values.
     *
     * @return The SVG path object.
     */
    public final native String toSVG(double decimalPlaces) /*-{
        return this.toSVG(decimalPlaces);
    }-*/;

    public final native void moveTo(double x, double y) /*-{
        this.moveTo(x, y);
    }-*/;

    public final native void lineTo(double x, double y) /*-{
        this.lineTo(x, y);
    }-*/;

    public final native void curveTo(double x1, double y1, double x2, double y2, double x, double y) /*-{
        this.curveTo(x1, y1, x2, y2, x, y);
    }-*/;

    public final native void bezierCurveTo(double x1, double y1, double x2, double y2, double x, double y) /*-{
        this.curveTo(x1, y1, x2, y2, x, y);
    }-*/;

    public final native void quadTo(double x1, double y1, double x, double y) /*-{
        this.quadTo(x1, y1, x, y);
    }-*/;

    public final native void quadraticCurveTo(double x1, double y1, double x, double y) /*-{
        this.quadTo(x1, y1, x, y);
    }-*/;

    public final native void close() /*-{
        this.close();
    }-*/;

    public final native void extend(Path path) /*-{
        this.extend(path);
    }-*/;

    public final native void extend(JsArray<Command> commands) /*-{
        this.extend(commands);
    }-*/;

    public final native JsArray<Command> getCommands() /*-{
        return this.commands;
    }-*/;

    public final native String getFill() /*-{
        return this.fill;
    }-*/;

    public final native String setFill(String fill) /*-{
        this.fill = fill;
    }-*/;

    public final native String getStroke() /*-{
        return this.stroke;
    }-*/;

    public final native String setStroke(String stroke) /*-{
        this.stroke = stroke;
    }-*/;

    public final native double getStrokeWidth() /*-{
        return this.strokeWidth;
    }-*/;

    public final native double setStrokeWidth(double strokeWidth) /*-{
        this.strokeWidth = strokeWidth;
    }-*/;
}
