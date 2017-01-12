package nasofw.root;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;

public class SeleniumDriver extends CustomizedSelenium {

	private WebDriver seleniumDriver;

	public SeleniumDriver() {
		setWebDriver(seleniumDriver);
	}

	public SeleniumDriver getWebDriver() {
		return (SeleniumDriver) seleniumDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		CustomizedSelenium customisedSelenium = new CustomizedSelenium();
		this.seleniumDriver = customisedSelenium.getDriverOf(
				FrameworkManager.scriptManagerSheet.getBrowser(FrameworkManager.getCurrentTestCaseId()).toUpperCase());
	}

	public void launch(String URL) {
		seleniumDriver.get(URL);
	}

	void close() {
		seleniumDriver.close();
	}

	public WebElement findElementByXpath(String xpath) {
		return seleniumDriver.findElement(By.xpath(xpath));
	}

	public WebElement findElement(By arg0) {
		return seleniumDriver.findElement(arg0);
	}

	public List<WebElement> findElements(By arg0) {
		return seleniumDriver.findElements(arg0);
	}

	public void get(String arg0) {
		seleniumDriver.get(arg0);
	}

	public String getCurrentUrl() {
		return seleniumDriver.getCurrentUrl();
	}

	public String getPageSource() {
		return seleniumDriver.getPageSource();
	}

	public String getTitle() {
		return seleniumDriver.getTitle();
	}

	public String getWindowHandle() {
		return seleniumDriver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return seleniumDriver.getWindowHandles();
	}

	public Options manage() {
		return seleniumDriver.manage();
	}

	public Navigation navigate() {
		return seleniumDriver.navigate();
	}

	public void quit() {
		seleniumDriver.quit();
	}

	public TargetLocator switchTo() {
		return seleniumDriver.switchTo();
	}

}
