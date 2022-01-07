package Generic;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;

public class GalenBaseClass {

	public static WebDriver driver;

	public void launchBrowser(String URL) {
		String setChromeDriver = ClassLoader.getSystemResource("chromedriver.exe").getFile();
		System.setProperty("webdriver.chrome.driver", setChromeDriver);
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 800));
		driver.get(URL);
	}

	public void GalenReport(String gspecPath, String reportName, String subReportName, String failedMessage) {
		try {
			LayoutReport layoutReport = Galen.checkLayout(driver, gspecPath, Arrays.asList("desktop"));
			List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
			GalenTestInfo test = GalenTestInfo.fromString(reportName);
			test.getReport().layout(layoutReport, subReportName);
			tests.add(test);
			HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
			htmlReportBuilder.build(tests, "target");
			if (layoutReport.errors() > 0) {
				Assert.fail(failedMessage);
			}
		} catch (IOException i) {
			System.err.println(i);
		}
	}
}
