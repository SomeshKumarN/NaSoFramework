package nasofw.root;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import nasofw.util.Enum.*;

public class CustomizedSelenium extends FrameworkManager {

	WebDriver webDriver;

	WebDriver getDriverOf(String browserName) {
		switch (Browser.valueOf(browserName)) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver",
					CustomConfigProperties.getValueOf(Constants.CustomConfigFile.chromeDriverPath));
			webDriver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver",
					CustomConfigProperties.getValueOf(Constants.CustomConfigFile.fireFoxDriverPath));
			webDriver = new FirefoxDriver();
			break;
		case INTERNET_EXPLORER:
			webDriver = new InternetExplorerDriver();
			break;
		case SAFARI:
			webDriver = new SafariDriver();
			break;
		default:
			System.out.println("Selected browser is not in the available list");
			break;
		}
		return webDriver;
	}
}
