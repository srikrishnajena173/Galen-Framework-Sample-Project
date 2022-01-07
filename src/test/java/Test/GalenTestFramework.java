package Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Generic.GalenBaseClass;
import POM.GalenSampleHomePage;

public class GalenTestFramework extends GalenBaseClass {

	@BeforeClass
	public void launchApp() {
		launchBrowser("http://www.swtestacademy.com/");
	}
	
	@Test
	public void homePageLayoutTest() {
		GalenSampleHomePage obj = new GalenSampleHomePage();
		obj.checkHomePageHeaderLayout();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
