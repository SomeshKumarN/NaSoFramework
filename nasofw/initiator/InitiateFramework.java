package nasofw.initiator;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import nasofw.root.Constants;
import nasofw.root.CustomConfigProperties;
import nasofw.root.FrameworkConfigProperties;
import nasofw.root.FrameworkManager;
import nasofw.root.SeleniumDriver;
import nasofw.util.ExcelManipulator;
import test.pagefunctions.Test1;

public class InitiateFramework {
	static Logger log = Logger.getLogger(InitiateFramework.class.getName());
	 static final String path = "nasofw/settings/log4j.properties";

	public static void main(String[] args) throws IOException,SQLException{
		// Run.InitiateTestSuite();
		// FrameworkManager.executeSuite();
		// System.out.println(FrameworkConfig.getValueOf(Constants.Resources.scriptManagerPath));
		// System.out.println(CustomConfig.getValueOf(Constants.CustomSettingProperties.testScritPackage));
		// System.setProperty("webdriver.chrome.driver",
		// "resources\\drivers\\chromedriver.exe");//C:\\SK_HDD\\AutomationArtifacts\\Browser
		// Drivers\\chromedriver_V52-54.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "resources\\drivers\\geckodriver.exe");//C:\\SK_HDD\\AutomationArtifacts\\Browser
		// Drivers\\chromedriver_V52-54.exe");
		// ChromeOptions options = new ChromeOptions();
		// System.setProperty("webdriver.chrome.args", "--disable-logging");
		// System.setProperty("webdriver.chrome.silentOutput", "true");
		// WebDriver driver = new ChromeDriver(options);
		// driver.get("http://www.google.com");
		// driver.close();driver.quit();
		// SeleniumDriver driver = new SeleniumDriver();
		// driver.get("http://www.google.com");
		// Test1 test = new Test1();
		// test.printMethod1();

		PropertyConfigurator.configure(path);
		log.debug("Hello this is a debug message");
		log.info("Hello this is an info message");
	}

}
