module edu.ics372.remotecontrolfx {
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;
	requires javafx.graphics;

	exports edu.ics372.remotecontrolfx.display to javafx.graphics;
	exports edu.ics372.remotecontrolfx.start to javafx.graphics;

}