package com.shc.gwtopentype.examples;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.shc.gwtopentype.OpenType;

public class Main implements EntryPoint
{
    @Override
    public void onModuleLoad()
    {
        OpenType.init(
                // Show message on success
                () -> Window.alert("Success!!"),

                // Print to the console on error
                Throwable::printStackTrace
        );
    }
}
