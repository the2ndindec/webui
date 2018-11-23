package com.webui.pageObjectConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetXmlPageObject {

	public  static void getXmlPageObject()
	{
		System.setProperty("webdriver.chrome.driver", "/webUi/src/main/resources/drives/ChromeDriver 2.41/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.cnblogs.com/");
		String tString=driver.getPageSource();
		System.out.println(tString);
	}
}
