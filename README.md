# GwtOpenType

GWT bindings to [opentype.js](https://github.com/nodebox/opentype.js/) project, which is a JavaScript parser and writer for TrueType and OpenType fonts.

GwtOpenType is a client side project, and works by directly injecting the opentype.js file into the browser. However, it does take care of SuperDevMode, and if you are not debugging, it injects the minified script.

## Installation

GwtOpenType will always be updated to the master branch of the opentype.js repo, and the current version `0.1-SNAPSHOT` maps to the `0.6.1` release of opentype.js. The build is available in maven, and this is how you set it up.

~~~xml
<dependency>
    <groupId>com.goharsha</groupId>
    <artifactId>gwt-opentype</artifactId>
    <version>0.1-SNAPSHOT</version>
</dependency>
~~~

If you are using the Gradle build system like me, you can add the dependency with just a single line:

~~~groovy
compile 'com.goharsha:gwt-opentype:0.1-SNAPSHOT'
~~~

And once you have it in the dependency list, the only step that you need is to inherit the library in your GWT module.

~~~xml
<inherits name='com.shc.GwtOpenType'/>
~~~

And now you are ready to use the GwtOpenType library in your GWT application. The version 0.1 will be released into the maven central repository soon once all of the current API is provided in Java.

## Initialization

Since the script injection happens after the module is loaded, we have to use asynchronous callbacks for it to load. Assuming that you use Java 8, here is how to initialize the library.

~~~java
OpenType.init(() ->
{
    // Once initialized, execute the statements inside here.
});
~~~

Or it is always better to use a method reference here.

~~~java
OpenType.init(this::initialized);
~~~

In case of an error, you are returned with an `Exception` object as a failure callback. By default the exceptions are logged to the console, but you can also throw them if you wish.

~~~java
OpenType.init(this::initialized, e -> e.printStackTrace());
~~~

So once you are initialized, you are free to use the library just like how you would do it in JavaScript. I just provide a Java interface for the JavaScript library.

## Loading a Font

In order to load a font, make sure that your resources are actually being included in the war file. GWT by default includes only the resources in the public path. Once that is done, you can actually load the font.

~~~java
OpenType.load("fonts/Roboto-Thin.ttf", (error, font) ->
{
    if (error != null)
        throw new RuntimeException("Cannot load font: " + error);
    else
    {
        // Use the font to draw on a 2D rendering context.
    }
});
~~~

In case you kept the font in the public path of your module, append `GWT.getModuleBaseForStaticFiles()` to your URL that you pass to the load method.

If you already have an `ArrayBuffer` of the font file, then you can use the `OpenType.parse()` method to parse the font. If the font cannot be loaded, this will throw a RuntimeException.

~~~java
Font font = OpenType.parse(arrayBuffer);
~~~

Then you can use this font to draw text onto a canvas. The synchronous load method is just not exposed since that is especially written for use on NodeJS.
