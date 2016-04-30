package com.shc.gwtopentype;

import com.google.gwt.core.client.GWT;

/**
 * @author Sri Harsha Chilakapati
 */
class SuperDevMode
{
    private static SuperDevMode INDICATOR = GWT.create(SuperDevMode.class);

    protected boolean getStatus()
    {
        return false;
    }

    public static boolean isEnabled()
    {
        return INDICATOR.getStatus();
    }
}
