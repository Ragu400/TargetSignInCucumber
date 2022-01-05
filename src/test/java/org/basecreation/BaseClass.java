package org.basecreation;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static final String AUTOMATE_USERNAME = "raguvaranry_1rtvGO";
	public static final String AUTOMATE_ACCESS_KEY = "6y6Q22zitkyT5y2zgxhT";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	public static WebDriver driver;// Static variable

//1.LaunchingBrowser
	public static WebDriver browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static void cloudLaunch() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "iPhone");
		caps.setCapability("device", "iPhone 11");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "14.0");
		caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
		caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
	    driver = new RemoteWebDriver(new URL(URL), caps);

	}

//2.LaunchingUrl
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

//3.Getting url
	public static String gettingUrl() {
		return driver.getCurrentUrl();
	}

//4.Getting Title
	public static String gettingTitle() {
		return driver.getTitle();
	}

//5.QuitBrowser
	public static void quitBrowser() {
		driver.quit();
	}

//6.findElement
	public static WebElement findElement(String locatorName, String locatorValue) {
		WebElement e = null;
		if (locatorName.equals("id")) {
			e = driver.findElement(By.id(locatorValue));
		} else if (locatorName.equals("className")) {
			e = driver.findElement(By.className(locatorValue));
		}
		if (locatorName.equals("name")) {
			e = driver.findElement(By.name(locatorValue));
		}
		if (locatorName.equals("tagName")) {
			e = driver.findElement(By.xpath(locatorValue));
		}
		if (locatorName.equals("xpath")) {
			e = driver.findElement(By.xpath(locatorValue));
		}
		return e;
	}

//7.SendKeys
	public static void fillTextBox(WebElement element, String eleValue) {
		element.sendKeys(eleValue);
	}

//8.Click
	public static void click(WebElement element) {
		element.click();
	}

//9.GetText
	public static String getText(WebElement element) {
		return element.getText();
	}

//10.GetAttribute
	public static String getAttribute(WebElement element) {
		return element.getAttribute("value");
	}

//11.Static Wait
	public static void staticWait(long sec) throws InterruptedException {
		Thread.sleep(sec);
	}

//12.Dynamic Wait
	public static void dynamicWait(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

//Actions
//13.MoveToElement
	public static void moveToElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

//14.DragAndDrop
	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

//15.contextclick
	public static void contextClick(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

//16.Doubleclick
	public static void doubleClick(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

//17.Click
	public static void actionClick(WebElement element) {
		Actions a = new Actions(driver);
		a.click(element).perform();
	}

//Robot
//18.Robot
	public static void robot(int PressKey, int ReleaseKey) throws AWTException {
		Robot r = new Robot();
		r.keyPress(PressKey);
		r.keyRelease(ReleaseKey);
	}

//19.Clear
	public static void clear(WebElement element) {
		element.clear();
	}

//Select
//20.SelectByValue
	public static void selectByValue(WebElement element, String selValue) {
		Select s = new Select(element);
		s.selectByValue(selValue);

	}

//21.SelectByIndex
	public static void selectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

//22.SelectByVisibleText
	public static void selectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		{
			s.selectByVisibleText(text);
		}
	}

//23.isMultiple
	public static Boolean isMultiple(WebElement element) {
		Select s = new Select(element);
		return s.isMultiple();
	}

//24.get Particular Options
	public static String getParticularOption(WebElement element, String value) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		String partDay = null;
		for (int i = 0; i < options.size(); i++) {
			WebElement eachOption = options.get(i);
			partDay = eachOption.getText();
			if (partDay.equals(value)) {
				options.get(i).click();
				break;
			}
		}
		return partDay;
	}

	public static void getParticularValue(WebElement element, String txtMonth) {
		Select s = new Select(element);
		s.selectByVisibleText(txtMonth);
	}

	public static void getParticularYear(WebElement element, String txtYear) {
		Select s = new Select(element);
		s.selectByValue(txtYear);
	}

//25.getAllSelected Options
//	public static List<WebElement> getAllSelectedOptions(WebElement element){
//		Select s = new Select(element);
//		return s.getAllSelectedOptions();
//	}
	public static void getAllSelectedOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> allSelect = s.getAllSelectedOptions();
		for (WebElement allId : allSelect) {
			System.out.println(allId.getText());
		}
	}

//26.getFirstSelected Options
//	public static WebElement getFirstSelectedOptions(WebElement element){
//		Select s = new Select(element);
//		return s.getFirstSelectedOption();
//	}
	public static void getFirstSelectedOptions(WebElement element) {
		Select s = new Select(element);
		WebElement first = s.getFirstSelectedOption();
		System.out.println(first.getText());
	}

//27.deselectByIndex
	public static void deselectByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}

//28.deselectBy Value
	public static void deselectByValue(WebElement element, String eleValue) {
		Select s = new Select(element);
		s.deselectByValue(eleValue);
	}

//29.deselectByVisible Text
	public static void deselectByVisibleText(WebElement element, String eleValue) {
		Select s = new Select(element);
		s.deselectByVisibleText(eleValue);
	}

//30.deselectAll
	public static void deselectAll(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

//Alert
//31.Switch To Alert
	public static Alert alert() {
		Alert a = driver.switchTo().alert();

		return a;
	}

//32.getText in Alert
	public static String getTextInAlert() {
		Alert a = driver.switchTo().alert();
		return a.getText();
	}

////33.sendkeys in Alert
//	public static Alert sendKeysInAlert(String text) {
//		Alert sk = driver.switchTo().alert();
//		 sk.sendKeys(text);
//		 return sk;
//	}

//34.TakesScreenshot
	public static void takesScreenshot(String imagename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(
				System.getProperty("copy.dir") + "\\src\\text\\resources\\Screenshots\\" + imagename + ".png");
		FileUtils.copyFile(src, des);
	}

//35.Javascript getAttribute
	public static Object jsGetAttribute(WebElement webref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return arguments[0].getAttribute('value')", webref);
	}

	// JavaScript setAttribute
	public static void jsSetAttribute(String jscode, WebElement webref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jscode, webref);
	}

//36.Javascript Click
	public static void jsClick(WebElement webref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", webref);
	}

//37.Javascript ScrollDown
	public static void jsScrollDown(WebElement webref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", webref);
	}

//38.Javascript ScrollUp
	public static void jsScrollUp(WebElement webref) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", webref);
	}

//Navigation commands
//39.Back
	public static void back() {
		driver.navigate().back();
	}

//40.Forward
	public static void forward() {
		driver.navigate().forward();
	}

//41.Refresh
	public static void refresh() {
		driver.navigate().refresh();
	}

//WebElement Extra Methods
//42.isDisplayed
	public static boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

//43.isEnabled
	public static boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}

//44.isSelected
	public static boolean isSelected(WebElement element) {
		return element.isSelected();
	}

//Frames
//45.SwitchToFrame By Index
	public static void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}

//46.SwitchToFrame by Name
	public static void frameByName(String text) {
		driver.switchTo().frame(text);
	}

//47.SwitchToFrame by WebElement
	public static void frameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

//48.ComeOut From Frame
	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}

//49.ParentFrame
	public static void parentFrame() {
		driver.switchTo().parentFrame();
	}

//50.Windows Handling
	public static void windowHandle() {
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for (String eachId : allId) {
			if (!parentId.equals(eachId)) {
				driver.switchTo().window(eachId);
			}

		}
	}

//51.Excel
	public static String getExcelData(String file, String sheetName, int rowno, int cellno) throws IOException {
		File loc = new File(
				"C:\\Users\\raguv\\eclipse-workspace\\FirstMaven\\src\\test\\resources\\Excel\\" + file + ".xlsx");
		FileInputStream st = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(st);
		Sheet s = w.getSheet(sheetName);
		Row row = s.getRow(rowno);
		Cell cell = row.getCell(cellno);
		int type = cell.getCellType();
		String value = null;
		if (type == 1) {// 1-String,0-Date
			value = cell.getStringCellValue();
		} else {

			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat sf = new SimpleDateFormat("dd-MM-YYYY");
				value = sf.format(date);
			} else {
				double db = cell.getNumericCellValue();
				long ln = (long) db;
				value = String.valueOf(ln);
			}
		}

		return value;
	}

	public static void findingCol(String beforeXpath, String afterXpath) {

		// Getting Only Columns
		for (int i = 2; i <= 7; i++) {
			String actualXpath = beforeXpath + i + afterXpath;
			WebElement columns = driver.findElement(By.xpath(actualXpath));
			System.out.println(columns.getText());
		}
	}

}
