package com.shc.gwtopentype;

import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.typedarrays.shared.ArrayBuffer;

/**
 * <p>Main class in the OpenType library. Use this class to load font objects from either a URL or from an {@link
 * ArrayBuffer}. The usage is like this.</p>
 *
 * <pre>
 *     // Initialize the library. This should be called first, as this loads the opentype.js script.
 *     OpenType.init(
 *            // Show message on success
 *            () -&gt; Window.alert("Success!!"),
 *
 *            // Print to the console on error
 *            Throwable::printStackTrace
 *    );
 * </pre>
 *
 * <p>Once initialized, you can use any of the library methods.</p>
 *
 * @author Sri Harsha Chilakapati
 */
public class OpenType
{
    public static void init(final SuccessCallback successCallback)
    {
        init(successCallback, new ErrorCallback()
        {
            @Override
            public void onError(Exception exception)
            {
                exception.printStackTrace();
            }
        });
    }

    public static void init(final SuccessCallback successCallback, final ErrorCallback errorCallback)
    {
        ScriptInjector.fromUrl(GWT.getModuleBaseForStaticFiles() + "opentype.min.js")
                .setCallback(new Callback<Void, Exception>()
                {
                    @Override
                    public void onFailure(Exception reason)
                    {
                        errorCallback.onError(reason);
                    }

                    @Override
                    public void onSuccess(Void result)
                    {
                        successCallback.onSuccess();
                    }
                })
                .setWindow(ScriptInjector.TOP_WINDOW)
                .inject();
    }

    public static native void load(String url, FontCallback callback) /*-{
        $wnd.opentype.load(url, function (err, font)
        {
            callback.@com.shc.gwtopentype.FontCallback::callback(*)(err, font);
        });
    }-*/;

    public static native Font parse(ArrayBuffer buffer) /*-{
        return $wnd.opentype.parse(buffer);
    }-*/;
}
