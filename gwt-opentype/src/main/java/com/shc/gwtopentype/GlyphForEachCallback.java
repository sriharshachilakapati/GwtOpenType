package com.shc.gwtopentype;

/**
 * @author Sri Harsha Chilakapati
 */
public interface GlyphForEachCallback
{
    void forEach(Glyph glyph, double x, double y, int fontSize, Options options);
}
