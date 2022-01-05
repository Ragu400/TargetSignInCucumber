package org.signinstepdef;

import org.basecreation.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import io.cucumber.java.*;

public class Hooks extends BaseClass {
	@Before
	public void beforeScenario() {
		browserLaunch();
		urlLaunch("https://www.target.com/");
		dynamicWait(10);
	}
	@After
	public void afterScenario(Scenario sc) {
		if(sc.isFailed()) {
			TakesScreenshot tk = (TakesScreenshot)driver;
			byte[] b = tk.getScreenshotAs(OutputType.BYTES);
			sc.embed(b, "image/png");
		}
		
	}

}
