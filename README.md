ManuellAssert
=============

This project is for special unittests which a human has to decide about true oder false.

How to start? Please look at: /ManuellAssert/src/test/java/de/mic/ma/ManuellAssertTest.java

There a two versions.
a) You got a picture (javafx.scene.image.Image) to evalute about true or false.
b) You got a webapplication. You need a start URL (de.mic.ma.snapshot.Startpage) and a navigation to your target (de.mic.ma.snapshot.NavigationOrder) 
  with every link (de.mic.ma.snapshot.NavigationsTargets).  At last you need one ID (Button, Link, Div or something else)
  on your targetpage, to be sure, you´re at your targetpage. Then the application take a snapshops and shows to you for evaluation.
