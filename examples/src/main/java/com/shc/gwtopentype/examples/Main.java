package com.shc.gwtopentype.examples;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.shc.gwtopentype.Font;
import com.shc.gwtopentype.Glyph;
import com.shc.gwtopentype.OpenType;

/**
 * @author Sri Harsha Chilakapati
 */
public class Main implements EntryPoint
{
    private Canvas    canvas;
    private Context2d context;
    private Font      font;
    private TextArea  textArea;

    /**
     * Small utility method to export JS objects to the Window, so we can debug using the dev console.
     */
    private static native void export(JavaScriptObject object, String name) /*-{
        $wnd[name] = object;
    }-*/;

    @Override
    public void onModuleLoad()
    {
        // OpenType library should be initialized first. This automatically detects SuperDevMode, and if it is enabled
        // it uses the complete opentype.js file, otherwise it uses opentype.min.js file. You need a callback since the
        // library JS file is injected at runtime.

        OpenType.init(
                // Start application on success
                this::startApp,

                // Print to the console on error
                Throwable::printStackTrace
        );
    }

    private void startApp()
    {
        // Once the library has been initialized, we can load the font. This uses an XmlHttpRequest internally, so make
        // sure that the file really exists in the WAR file. You have to configure that in the build script. This method
        // takes a callback, which is called with an error string, and a font. If there is no error, you can use the
        // font, and the error string will be null.

        OpenType.load("fonts/Roboto-Thin.ttf", ((error, font) -> {
            if (error != null)
                GWT.log(error);
            else
            {
                this.font = font;
                export(font, "font");

                // Create the user interface
                createLayout();
            }
        }));
    }

    private void createLayout()
    {
        // This method is all about constructing the user interface using GWT widgets, and will not be commented. To
        // understand how to render the font, see the draw() method found on line 125.

        SplitLayoutPanel splitLayout = new SplitLayoutPanel()
        {
            @Override
            public void onResize()
            {
                super.onResize();
                resizeCanvas(canvas.getCanvasElement());
                draw();
            }
        };

        splitLayout.addNorth(new HTML("<center><h1>GwtOpenType</h1></center>"), 68);
        splitLayout.addSouth(new HTML("<center>Written by <b>Sri Harsha Chilakapati</b></center>"), 34);

        canvas = Canvas.createIfSupported();
        canvas.setCoordinateSpaceWidth(800);
        canvas.setCoordinateSpaceHeight(600);

        Style canvasStyle = canvas.getCanvasElement().getStyle();
        canvasStyle.setBackgroundColor("#ececec");
        canvasStyle.setWidth(100, Style.Unit.PCT);
        canvasStyle.setHeight(100, Style.Unit.PCT);

        context = canvas.getContext2d();
        export(context, "ctx");

        splitLayout.addWest(canvas, 800);

        textArea = new TextArea();
        textArea.addKeyUpHandler(this::keyUpHandler);
        textArea.setText("Hello World");

        Style textAreaStyle = textArea.getElement().getStyle();
        textAreaStyle.setWidth(100, Style.Unit.PCT);
        textAreaStyle.setHeight(100, Style.Unit.PCT);

        splitLayout.add(textArea);
        RootLayoutPanel.get().add(splitLayout);

        draw();
    }

    private void keyUpHandler(KeyUpEvent keyUpEvent)
    {
        draw();
    }

    private void draw()
    {
        // This is where the font drawing takes place. This method shows how to draw a multi-line string onto a canvas
        // using a 2D context. We also take care of scaling the Glyph from font units into pixels, and render using the
        // kerning points.

        // The font size to render the text with.
        int fontSize = 72;

        // We need to do some calculations like calculating the scale, baseLine and the lineHeight.
        float scale = (1f / font.getUnitsPerEm()) * fontSize;
        float baseLine = font.getAscender() * scale;
        float lineHeight = baseLine - (font.getDescender() * scale);

        // Keep track of the Glyph positions. This is where we draw the Glyph on the canvas. A padding of 10 is added
        // so that the text is not too left on the screen. Basically we are drawing the text at (10, 10) as it's top
        // left corner position.
        double x = 10;
        double y = 10 + baseLine;

        String text = textArea.getText();

        // Don't forget to clear the screen, otherwise we will draw on top of old text, making it look clumsy.
        context.clearRect(0, 0, canvas.getCoordinateSpaceWidth(), canvas.getCoordinateSpaceHeight());

        // The Glyph which was rendered previously. Used to add kerning to the position.
        Glyph lastGlyph = null;

        for (char ch : text.toCharArray())
        {
            // If the character is a newline, reset the x-position, and increment y-position by the line height.
            if (ch == '\n')
            {
                x = 10;
                y += lineHeight;

                // Continue to the next char, newline is not a valid Glyph.
                continue;
            }

            // Convert the char to a Glyph object. Don't worry, allocation will only happen once, and the object
            // is cached by opentype.js library.
            Glyph glyph = font.charToGlyph(ch);

            // If there is a character before this, calculate the kerning value and add that to the x-position.
            if (lastGlyph != null)
                x += font.getKerningValue(lastGlyph, glyph) * scale;

            // Draw the Glyph onto the canvas. If you want to change the color, you have to get the Path of the Glyph,
            // and set it's fill and stroke properties to CSS valid color strings.
            glyph.draw(context, x, y, fontSize);
            lastGlyph = glyph;

            // Advance the x-position by the Glyph's advance width.
            x += glyph.getAdvanceWidth() * scale;
        }
    }

    private native void resizeCanvas(CanvasElement element) /*-{
        // A small trick to keep the canvas from resizing it's contents. We keep the canvas at 100% size
        // so this trick is needed to prevent rendering artifacts.
        element.width = element.clientWidth;
        element.height = element.clientHeight;
    }-*/;
}
