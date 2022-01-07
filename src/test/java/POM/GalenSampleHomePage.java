package POM;

import Generic.GalenBaseClass;

public class GalenSampleHomePage extends GalenBaseClass {

	public void checkHomePageHeaderLayout() {
		GalenReport("specs/homepage.gspec", "homepage layout", "check homepage layout", "Header Layout test failed");
	}
}
