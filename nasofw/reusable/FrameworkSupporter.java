package nasofw.reusable;

import nasofw.root.FrameworkManager;
import nasofw.root.SeleniumDriver;

public abstract class FrameworkSupporter {
	public SeleniumDriver driver;
	public FrameworkSupporter(){
		this.driver = FrameworkManager.webDriver;
	}
	
}
