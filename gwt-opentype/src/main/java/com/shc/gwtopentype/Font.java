package com.shc.gwtopentype;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.typedarrays.shared.ArrayBuffer;

/**
 * A Font represents a loaded OpenType font file. It contains a set of glyphs and methods to draw text on a drawing
 * context, or to get a path representing the text.
 *
 * @author Sri Harsha Chilakapati
 */
public class Font extends JavaScriptObject
{
    protected Font()
    {
    }

    public static native Font create(Options options) /*-{
        return new $wnd.opentype.Font(options);
    }-*/;

    /**
     * Create a Path object that represents the given text.
     *
     * @param text The text to create.
     *
     * @return The Path object ready to be drawn onto a canvas.
     */
    public final native Path getPath(String text) /*-{
        return this.getPath(text, 0, 0, 72);
    }-*/;

    /**
     * Create a Path object that represents the given text.
     *
     * @param text The text to create.
     * @param x    Horizontal position of the beginning of the text.
     * @param y    Vertical position of the {@code baseline} of the text.
     *
     * @return Returns a Path object.
     */
    public final native Path getPath(String text, double x, double y) /*-{
        return this.getPath(text, x, y, 72);
    }-*/;

    /**
     * Create a Path object that represents the given text.
     *
     * @param text     The text to create.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     *
     * @return Returns a Path object.
     */
    public final native Path getPath(String text, double x, double y, int fontSize) /*-{
        return this.getPath(text, x, y, fontSize);
    }-*/;

    /**
     * Create a Path object that represents the given text.
     *
     * @param text     The text to create.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     * @param options  Options is an optional object that contains: - kerning - Whether to take kerning information into
     *                 account.
     *
     * @return Returns a Path object.
     */
    public final native Path getPath(String text, double x, double y, int fontSize, Options options) /*-{
        return this.getPath(text, x, y, fontSize, options);
    }-*/;

    /**
     * Create an array of Path objects that represents the given text.
     *
     * @param text The text to create.
     *
     * @return Returns an array of Path objects.
     */
    public final native JsArray<Path> getPaths(String text) /*-{
        return this.getPaths(text, 0, 0, 72);
    }-*/;

    /**
     * Create an array of Path objects that represents the given text.
     *
     * @param text The text to create.
     * @param x    Horizontal position of the beginning of the text.
     * @param y    Vertical position of the {@code baseline} of the text.
     *
     * @return Returns an array of Path objects.
     */
    public final native JsArray<Path> getPaths(String text, double x, double y) /*-{
        return this.getPaths(text, x, y, 72);
    }-*/;

    /**
     * Create an array of Path objects that represents the given text.
     *
     * @param text     The text to create.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     *
     * @return Returns an array of Path objects.
     */
    public final native JsArray<Path> getPaths(String text, double x, double y, int fontSize) /*-{
        return this.getPaths(text, x, y, fontSize);
    }-*/;

    /**
     * Create an array of Path objects that represents the given text.
     *
     * @param text     The text to create.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     * @param options  Options is an optional object that contains: - kerning - Whether to take kerning information into
     *                 account.
     *
     * @return Returns an array of Path objects.
     */
    public final native JsArray<Path> getPaths(String text, double x, double y, int fontSize, Options options) /*-{
        return this.getPaths(text, x, y, fontSize, options);
    }-*/;

    /**
     * Draw the text on the given drawing context.
     *
     * @param ctx  The 2D rendering context from the Canvas to draw the text.
     * @param text The text to create.
     */
    public final native void draw(Context2d ctx, String text) /*-{
        this.draw(ctx, 0, 0, 72);
    }-*/;

    /**
     * Draw the text on the given drawing context.
     *
     * @param ctx  The 2D rendering context from the Canvas to draw the text.
     * @param text The text to create.
     * @param x    Horizontal position of the beginning of the text.
     * @param y    Vertical position of the {@code baseline} of the text.
     */
    public final native void draw(Context2d ctx, String text, double x, double y) /*-{
        this.draw(ctx, text, x, y, 72);
    }-*/;

    /**
     * Draw the text on the given drawing context.
     *
     * @param ctx      The 2D rendering context from the Canvas to draw the text.
     * @param text     The text to create.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     */
    public final native void draw(Context2d ctx, String text, double x, double y, int fontSize) /*-{
        this.draw(ctx, text, x, y, fontSize);
    }-*/;

    /**
     * Draw the text on the given drawing context.
     *
     * @param ctx      The 2D rendering context from the Canvas to draw the text.
     * @param text     The text to create.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     * @param options  Options is an optional object that contains: - kerning - Whether to take kerning information into
     *                 account.
     */
    public final native void draw(Context2d ctx, String text, double x, double y, int fontSize, Options options) /*-{
        this.draw(ctx, text, x, y, fontSize, options);
    }-*/;

    /**
     * Draw the points of all glyphs in the text. On-curve points will be drawn in blue, off-curve points will be drawn
     * in red.
     *
     * @param ctx  The 2D rendering context from the Canvas to draw the text points.
     * @param text The text to create.
     */
    public final native void drawPoints(Context2d ctx, String text) /*-{
        this.drawPoints(ctx, text, 0, 0, 72);
    }-*/;

    /**
     * Draw the points of all glyphs in the text. On-curve points will be drawn in blue, off-curve points will be drawn
     * in red.
     *
     * @param ctx  The 2D rendering context from the Canvas to draw the text points.
     * @param text The text to create.
     * @param x    Horizontal position of the beginning of the text.
     * @param y    Vertical position of the {@code baseline} of the text.
     */
    public final native void drawPoints(Context2d ctx, String text, double x, double y) /*-{
        this.drawPoints(ctx, text, x, y, 72);
    }-*/;

    /**
     * Draw the points of all glyphs in the text. On-curve points will be drawn in blue, off-curve points will be drawn
     * in red.
     *
     * @param ctx      The 2D rendering context from the Canvas to draw the text points.
     * @param text     The text to create.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     */
    public final native void drawPoints(Context2d ctx, String text, double x, double y, int fontSize) /*-{
        this.drawPoints(ctx, text, x, y, fontSize);
    }-*/;

    /**
     * Draw the points of all glyphs in the text. On-curve points will be drawn in blue, off-curve points will be drawn
     * in red.
     *
     * @param ctx      The 2D rendering context from the Canvas to draw the text points.
     * @param text     The text to create.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     * @param options  Options is an optional object that contains: - kerning - Whether to take kerning information into
     *                 account.
     */
    public final native void drawPoints(Context2d ctx, String text, double x, double y, int fontSize, Options options) /*-{
        this.drawPoints(ctx, text, x, y, fontSize, options);
    }-*/;

    /**
     * Draw lines indicating important font measurements for all glyphs in the text. Black lines indicate the origin of
     * the coordinate system {@code (point 0,0)}. Blue lines indicate the glyph bounding box. Green line indicates the
     * advance width of the glyph.
     *
     * @param ctx  The 2D rendering context from the Canvas to draw the text metrics.
     * @param text The text to create.
     */
    public final native void drawMetrics(Context2d ctx, String text) /*-{
        this.drawMetrics(ctx, text, 0, 0, 72);
    }-*/;

    /**
     * Draw lines indicating important font measurements for all glyphs in the text. Black lines indicate the origin of
     * the coordinate system {@code (point 0,0)}. Blue lines indicate the glyph bounding box. Green line indicates the
     * advance width of the glyph.
     *
     * @param ctx  The 2D rendering context from the Canvas to draw the text metrics.
     * @param text The text to create.
     * @param x    Horizontal position of the beginning of the text.
     * @param y    Vertical position of the {@code baseline} of the text.
     */
    public final native void drawMetrics(Context2d ctx, String text, double x, double y) /*-{
        this.drawMetrics(ctx, text, x, y, 72);
    }-*/;

    /**
     * Draw lines indicating important font measurements for all glyphs in the text. Black lines indicate the origin of
     * the coordinate system {@code (point 0,0)}. Blue lines indicate the glyph bounding box. Green line indicates the
     * advance width of the glyph.
     *
     * @param ctx      The 2D rendering context from the Canvas to draw the text metrics.
     * @param text     The text to create.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     */
    public final native void drawMetrics(Context2d ctx, String text, double x, double y, int fontSize) /*-{
        this.drawMetrics(ctx, text, x, y, fontSize);
    }-*/;

    /**
     * Draw lines indicating important font measurements for all glyphs in the text. Black lines indicate the origin of
     * the coordinate system {@code (point 0,0)}. Blue lines indicate the glyph bounding box. Green line indicates the
     * advance width of the glyph.
     *
     * @param ctx      The 2D rendering context from the Canvas to draw the text metrics.
     * @param text     The text to create.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     * @param options  Options is an optional object that contains: - kerning - Whether to take kerning information into
     *                 account.
     */
    public final native void drawMetrics(Context2d ctx, String text, double x, double y, int fontSize, Options options) /*-{
        this.drawMetrics(ctx, text, x, y, fontSize, options);
    }-*/;

    /**
     * Convert the given text to a list of Glyph objects. Note that there is no strict one-to-one mapping between
     * characters and glyphs, so the list of returned glyphs can be larger or smaller than the length of the given
     * string.
     *
     * @param string The input string to be converted into Glyph objects.
     *
     * @return The list of Glyph objects.
     */
    public final native JsArray<Glyph> stringToGlyphs(String string) /*-{
        return this.stringToGlyphs(string);
    }-*/;

    /**
     * Convert the given character to a single Glyph object. Note that this function assumes that there is a one-to-one
     * mapping between the given character and a glyph; for complex scripts this might not be the case.
     *
     * @param ch The character to be converted into a Glyph.
     *
     * @return A Glyph object corresponding to the character if there is a one-to-one mapping between the given
     * character and glyph. Otherwise, {@code null} is returned.
     */
    public final native Glyph charToGlyph(char ch) /*-{
        return this.charToGlyph(String.fromCharCode(ch));
    }-*/;

    /**
     * Retrieve the value of the kerning pair between the left glyph (or its index) and the right glyph (or its index).
     * If no kerning pair is found, return 0. The kerning value gets added to the advance width when calculating the
     * spacing between glyphs.
     *
     * @param left  The left Glyph object.
     * @param right The right Glyph object.
     *
     * @return The kerning value between the two Glyphs.
     */
    public final native double getKerningValue(Glyph left, Glyph right) /*-{
        return this.getKerningValue(left, right);
    }-*/;

    /**
     * Check if the font has a glyph for the given character.
     *
     * @param ch The character to be checked.
     *
     * @return True if the font has a glyph for the given character.
     */
    public final native boolean hasChar(char ch) /*-{
        return this.hasChar(String.fromCharCode(ch));
    }-*/;

    /**
     * Convert the given character to a single glyph index. Note that this function assumes that there is a one-to-one
     * mapping between the given character and a glyph; for complex scripts this might not be the case.
     *
     * @param ch The character to be converted.
     *
     * @return The index of the Glyph in the list, or -1 if the Glyph cannot be found.
     */
    public final native int charToGlyphIndex(char ch) /*-{
        var result = this.charToGlyphIndex(String.fromCharCode(ch));
        return result === null || result === undefined ? -1 : result;
    }-*/;

    public final native int nameToGlyphIndex(String name) /*-{
        var result = this.nameToGlyphIndex(name);
        return result === null || result === undefined ? -1 : result;
    }-*/;

    public final native Glyph nameToGlyph(String name) /*-{
        return this.nameToGlyph(name);
    }-*/;

    public final native String glyphIndexToName(int index) /*-{
        return this.glyphIndexToName(index);
    }-*/;

    /**
     * Helper function that invokes the given callback for each glyph in the given text.
     *
     * @param text     The text whose Glyphs to be iterated upon.
     * @param x        Horizontal position of the beginning of the text.
     * @param y        Vertical position of the {@code baseline} of the text.
     * @param fontSize Font size in pixels. We scale the glyph units by {@code 1 / unitsPerEm * fontSize}.
     * @param options  Options is an optional object that contains: - kerning - Whether to take kerning information into
     *                 account.
     * @param callback The GlyphForEachCallback object to be called for each Glyph in text.
     */
    public final native void forEachGlyph(String text, double x, double y, int fontSize,
                                          Options options, GlyphForEachCallback callback) /*-{
        this.forEachGlyph(text, x, y, fontSize, options, function (glyph, x, y, fontSize, options)
        {
            callback.@com.shc.gwtopentype.GlyphForEachCallback::forEach(*)(glyph, x, y, fontSize, options);
        });
    }-*/;

    public final native String getEnglishName(String name) /*-{
        return this.getEnglishName(name);
    }-*/;

    public final native void validate() /*-{
        this.validate();
    }-*/;

    /**
     * Convert the font object to a SFNT data structure. This structure contains all the necessary tables and metadata
     * to create a binary OTF file.
     *
     * @return The SFNT table containing the font object.
     */
    public final native JavaScriptObject toTables() /*-{
        return this.toTables();
    }-*/;

    @Deprecated
    public final native ArrayBuffer toBuffer() /*-{
        return this.toBuffer();
    }-*/;

    public final native ArrayBuffer toArrayBuffer() /*-{
        return this.toArrayBuffer();
    }-*/;

    /**
     * Initiate a download of the OpenType font.
     */
    public final native void download() /*-{
        this.download();
    }-*/;

    /**
     * Returns if the font is supported. Fonts can be marked unsupported if they have encoding tables we can't read.
     *
     * @return True if the font is supported. Else false.
     */
    @Deprecated
    public final native boolean isSupported() /*-{
        return this.supported;
    }-*/;

    /**
     * Returns all the Glyph objects as a list in this font.
     *
     * @return An indexed list of Glyph objects.
     */
    public final native GlyphSet getGlyphs() /*-{
        return this.glyphs;
    }-*/;

    /**
     * X/Y coordinates in fonts are stored as integers. This value determines the size of the grid. Common values are
     * 2048 and 4096.
     *
     * @return The grid size of the font in font units (not pixels).
     */
    public final native int getUnitsPerEm() /*-{
        return this.unitsPerEm;
    }-*/;

    /**
     * Distance from baseline of highest ascender. In font units, not pixels.
     *
     * @return The distance from baseline of highest ascender. In font units, not pixels.
     */
    public final native int getAscender() /*-{
        return this.ascender;
    }-*/;

    /**
     * Distance from baseline of lowest descender. In font units, not pixels.
     *
     * @return The distance from baseline of lowest descender. In font units, not pixels.
     */
    public final native int getDescender() /*-{
        return this.descender;
    }-*/;
}
