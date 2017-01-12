package trailtest_sk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SeleniumListenerTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\SK_HDD\\Automation Artifacts\\Browser Drivers\\chromedriver_V52-54.exe");
		WebDriver driver = new ChromeDriver();
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		EventHandler handler =  new EventHandler();
		edriver.register(handler);
		edriver.get("https://www.google.com");
		edriver.findElement(By.xpath("//*[@class='gb_Psa']")).click();
		edriver.close();
		edriver.quit();
	}

}
