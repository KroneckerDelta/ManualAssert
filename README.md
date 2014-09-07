ManuellAssert
=============

ManuellAssert allows to write tests with assertions performed by a human. This is usefull for example if you want to test the layout of a webpage. It is hard to encode the properties of a 'nice' layout in a program, but often easy for a human to check if a layout is 'nice'. ManuellAssert will simply present the artefact to check to a human user and allows him or her to decide if it is ok or not.

Getting Started
-------------

Have a look at: [de.mic.ma.ManuellAssertTest.java](/src/test/java/de/mic/ma/ManuellAssertTest.java)

There a two versions.

1. You can provide a picture (javafx.scene.image.Image) for evaluation

2. Or if you want to test a web page, you need an URL (de.mic.ma.snapshot.Startpage) and a navigation to your target (de.mic.ma.snapshot.NavigationOrder) with every link (de.mic.ma.snapshot.NavigationsTargets) and on your target page you need something to determine if the page is completely loaded. A Button, Link, Div or similar will do. ManuellAssert will navigate to the page, take the screenshot and present it to the tester.
