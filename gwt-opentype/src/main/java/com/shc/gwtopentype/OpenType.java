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
    /**
     * Initializes the OpenType library by injecting the JavaScript file into the DOM. We inject the complete script if
     * in super dev mode, otherwise the minified script is injected. The result is notified through callbacks.
     *
     * @param successCallback The callback to be called when initialization is successful.
     */
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

    /**
     * Initializes the OpenType library by injecting the JavaScript file into the DOM. We inject the complete script if
     * in super dev mode, otherwise the minified script is injected. The result is notified through callbacks.
     *
     * @param successCallback The callback to be called when initialization is successful.
     * @param errorCallback   The callback to be called when initialization is failed.
     */
    public static void init(final SuccessCallback successCallback, final ErrorCallback errorCallback)
    {
        String scriptFile = SuperDevMode.isEnabled() ? "opentype.js" : "opentype.min.js";

        ScriptInjector.fromUrl(GWT.getModuleBaseForStaticFiles() + scriptFile)
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

    /**
     * Asynchronously load the font from a URL. When done, call the callback with two arguments {@code (err, font)}. The
     * {@code err} will be null on success, the {@code font} is a Font object.
     *
     * @param url      The URL of the font to be loaded.
     * @param callback The FontCallback object to be notified.
     */
    public static native void load(String url, FontCallback callback) /*-{
        $wnd.opentype.load(url, function (err, font)
        {
            callback.@com.shc.gwtopentype.FontCallback::callback(*)(err, font);
        });
    }-*/;

    /**
     * Parse the OpenType file data (as an ArrayBuffer) and return a Font object. Throws an error if the font could not
     * be parsed.
     *
     * @param buffer The ArrayBuffer containing data of the font file.
     *
     * @return The Font object after parsing is done.
     */
    public static native Font parse(ArrayBuffer buffer) /*-{
        return $wnd.opentype.parse(buffer);
    }-*/;
}
