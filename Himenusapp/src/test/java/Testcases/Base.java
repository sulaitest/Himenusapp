package Testcases;

import java.net.URL;

public class Base {
	AppiumDriver<MobileElement> driver;
	public void setup()
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName","Redmi 9i");
		dc.setCapability("platformName","Android");
		dc.setCapability("automationName","Appium");
		dc.setCapability("udid","HMUWLNUKUKMRWGZX");
		dc.setCapability("platformVersion","10");
		dc.setCapability("appPackage", "com.inlogic.himenus");
		dc.setCapability("appActivity", "com.inlogic.himenus.MainActivity");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,dc);
		System.out.println("Application Started");
		Thread.sleep(10000);
			}
	

}
