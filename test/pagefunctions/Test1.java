package test.pagefunctions;

import nasofw.reusable.FrameworkSupporter;
import nasofw.root.Constants.CustomConfigFile;
import nasofw.root.CustomConfigProperties;

public class Test1 extends FrameworkSupporter {
	
	String searchBoxXpath= "//*[@name='q']";
	String searchBtnXpath="//*[@type='submit' and @name='btnK']";
	
	public void launchGoogle() {
		driver.launch(CustomConfigProperties.getValueOf(CustomConfigFile.url));
		System.out.println("Google URL Launched" + this.getClass());
	}

	public void SearchIndia() {
	driver.findElementByXpath(searchBoxXpath).sendKeys("India");
	driver.findElementByXpath(searchBtnXpath).click();
//		driver.findElementByXpath(searchBtnXpath).getText();
	System.out.println("India has been searched" + this.getClass());
	}
	public void printMethod1() {
		System.out.println("printmethod1 called" + this.getClass());
//		driver.findElementByXpath(searchBoxXpath).sendKeys("India");
//		driver.findElementByXpath(searchBtnXpath).click();
//		System.out.println("India has been searched" + this.getClass());
		
	}
	public void printMethod2() {
		System.out.println("printmethod2 called" + this.getClass());
	}
	public void printMethod1(int s) {
		System.out.println("printmethod2 called" + this.getClass());
	}
	

}
