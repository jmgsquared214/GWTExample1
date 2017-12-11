GWT Maven Example
=================

Overview
--------

Finally, a working example combining a multi-project maven build together with
GWT 2.

This example is based on the GWT webapp created by the [Maven GWT Plugin archetype](http://mojo.codehaus.org/gwt-maven-plugin/user-guide/archetype.html).

I created this example as I was unable to find any **working** example on the
net. The example doesn't just compile via Maven, but I was also able to run it
in IntelliJ IDEA 11.1 Ultimate.


Running via Maven in GWT Dev Mode
---------------------------------

In order to run the example via Maven in GWT Dev Mode, you need to do:

1. Add MySQL properties in server.properties and hibernate-cfg.xml
2.Start the web application in Tomcat 7 via Maven
3. Start GWT Dev Mode via Maven
4. Run the application in your browser

To accomplish the first point, issue the following Maven command on a shell:

    mvn clean install
    mvn tomcat7:run-war-only

Your application is now deployed at http://127.0.0.1:8082/parent/.

Now, you need to start GWT Dev Mode. Open a second shell and execute:

    mvn gwt:run -pl web

On success, the GWT Dev Mode window opens. Click *Launch Default Browser* to open it in GWT Dev Mode.

You can now make changes to your client Java code. Changes become immediately available as soon as you reloaded your page in the browser.



