package com.shc.gwtopentype;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Sri Harsha Chilakapati
 */
public class Command extends JavaScriptObject
{
    protected Command()
    {
    }

    public final native String getType() /*-{
        return this.type;
    }-*/;

    public static class Move extends Command
    {
        protected Move()
        {
        }

        public final native double getX() /*-{
            return this.x;
        }-*/;

        public final native double getY() /*-{
            return this.y;
        }-*/;
    }

    public static class Line extends Command
    {
        protected Line()
        {
        }

        public final native double getX() /*-{
            return this.x;
        }-*/;

        public final native double getY() /*-{
            return this.y;
        }-*/;
    }

    public static class Curve extends Command
    {
        protected Curve()
        {
        }

        public final native double getX() /*-{
            return this.x;
        }-*/;

        public final native double getY() /*-{
            return this.y;
        }-*/;

        public final native double getX1() /*-{
            return this.x1;
        }-*/;

        public final native double getY1() /*-{
            return this.y1;
        }-*/;

        public final native double getX2() /*-{
            return this.x2;
        }-*/;

        public final native double getY2() /*-{
            return this.y2;
        }-*/;
    }

    public static class Quad extends Command
    {
        protected Quad()
        {
        }

        public final native double getX() /*-{
            return this.x;
        }-*/;

        public final native double getY() /*-{
            return this.y;
        }-*/;

        public final native double getX1() /*-{
            return this.x1;
        }-*/;

        public final native double getY1() /*-{
            return this.y1;
        }-*/;
    }

    public static class Close extends Command
    {
        protected Close()
        {
        }
    }
}
